package pr04;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Test {

  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    Logger.getLogger("org.hibernate").setLevel(Level.OFF);

    EntityManagerFactory factory = 
      Persistence.createEntityManagerFactory("WebShop");
    
    // lazy fetching u okviru jedne sesije
    System.out.println(
        "\n==== Test 1: Citamo sve dobavljace i njihove proizvode unutar jedne sesije");
    EntityManager manager = factory.createEntityManager();
    List<Supplier> suppliers = null;
    try {
      Query q1 = manager.createQuery(
          "SELECT s FROM Supplier s");
      suppliers = q1.getResultList();
      print(suppliers);
    } catch (Exception ex) {
      System.out.println("Exception / Test 1: " + ex.getMessage());
    } finally {
      manager.close();
    }
    
    // lazy fetching izvan sesije - Product objekti nece biti ucitani!
    System.out.println(
        "\n==== Test 2: Citamo sve dobavljace, a potom pokusavamo da citamo " +
        "\n==== i njihove vezane proizvode izvan sesije");
    manager = factory.createEntityManager();
    try {
      Query q1 = manager.createQuery(
          "SELECT s FROM Supplier s");
      suppliers = q1.getResultList();
      manager.close();
      print(suppliers);
    } catch (Exception ex) {
      System.out.println("Exception / Test 2: " + ex.getMessage());
    }
    
    // umesto lazy fetching radimo eager fetching pomocu JPQL upita
    System.out.println(
        "\n==== Test 3: Citamo hijerarhijski sve kategorije pomocu eager fetching");
    manager = factory.createEntityManager();
    try {
      Query q1 = manager.createQuery(
          "SELECT DISTINCT s FROM Supplier s LEFT JOIN FETCH s.products");
      suppliers = q1.getResultList();
      manager.close();
      print(suppliers);
    } catch (Exception ex) {
      System.out.println("Exception / Test 3: " + ex.getMessage());
    }
    
    // u bazu dodajemo novog dobavljaca i dva njegova proizvoda
    // NAPOMENA: proizvodi se nigde eksplicitno ne snimaju u bazu,
    // zato sto je prisutna anotacija @OneToMany(cascade=ALL, ...) u
    // klasi Supplier!
    System.out.println(
        "\n==== Test 4: Dodajemo novog dobavljaca i dva proizvoda");

    // napravimo dobavljaca
    Supplier zika = new Supplier();
    zika.setName("Zika boss");
    zika.setAddress("Zikin bulevar 1");

    // napravimo proizvode i povezemo ih sa dobavljacem
    Product p1 = new Product();
    p1.setName("xServer 3650");
    p1.setVendor("IBM");
    p1.setPrice(new BigDecimal("1950.00"));
    p1.setDescription("manji server");
    p1.setSupplier(zika);
    zika.getProducts().add(p1);
    Product p2 = new Product();
    p2.setName("xServer 4500");
    p2.setVendor("IBM");
    p2.setPrice(new BigDecimal("4350.00"));
    p2.setDescription("veci server");
    p2.setSupplier(zika);
    zika.getProducts().add(p2);

    manager = factory.createEntityManager();
    try {
      // azuriracemo bazu, treba nam transakcija
      manager.getTransaction().begin();
      
      // ucitamo kategoriju ID=4, "Serveri"
      Category serveri = manager.find(Category.class, 4);
      
      // povezemo proizvode sa kategorijom
      p1.setCategory(serveri);
      serveri.getProducts().add(p1);
      p2.setCategory(serveri);
      serveri.getProducts().add(p2);
      
      // snimimo dobavljaca <--- bice snimljeni i proizvodi!!!
      manager.persist(zika);

      // ispisemo sve dobavljace sa proizvodima
      Query q1 = manager.createQuery("SELECT s FROM Supplier s");
      suppliers = q1.getResultList();
      print(suppliers);
      
      manager.getTransaction().commit();
      manager.close();
    } catch (Exception ex) {
      System.out.println("Exception / Test 4: " + ex.getMessage());
    }
    
    // Objekat koji je dobavljen u jednoj sesiji ostaje "nadgledan" do kraja
    // sesije i izmenje na njemu se automatski prenose u bazu na kraju 
    // transakcije. Ovde cemo promeniti atribut address za prvog dobavljaca
    // u bazi. Nigde nije eksplicitno pozvana metoda manager.merge() - nije
    // zabranjeno, ali u ovom slucaju nije ni potrebno!!!
    try {
      manager = factory.createEntityManager();
      manager.getTransaction().begin();
      Query q = manager.createQuery("SELECT s FROM Supplier s");
      suppliers = q.getResultList();
      if (suppliers.size() > 0) {
        suppliers.get(0).setAddress("Nova adresa 1");
      }
      manager.getTransaction().commit();
      manager.close();
    } catch (Exception ex) {
      System.out.println("Exception / Test 5: " + ex.getMessage());
    }
    
    factory.close();
  }
  
  private static void print(List<Supplier> list) {
    for (Supplier s: list) {
      System.out.println(s);
      for (Product p: s.getProducts()) {
        System.out.println("  " + p);
      }
    }
  }
  
}
