package pr03;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Test {

  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    Logger.getLogger("org.hibernate").setLevel(Level.OFF);

    // factory proizvodi entity managere
    // factory je thread-safe
    EntityManagerFactory factory = 
      Persistence.createEntityManagerFactory("AdminDemo");
    
    // entity manager obavlja operacije nad bazom
    // nije thread-safe
    EntityManager manager = factory.createEntityManager();
    
    // kreiramo objekte
    Admin pera = new Admin();
    pera.setUsername("pera");
    pera.setPassword("pera");
    Admin zika = new Admin();
    zika.setUsername("zika");
    zika.setPassword("zika");
    Admin laza = new Admin();
    laza.setUsername("laza");
    laza.setPassword("laza");
    
    try {
      // pocnemo transakciju
      EntityTransaction tx = manager.getTransaction();
      tx.begin();
      // snimimo objekte u bazu
      manager.persist(pera);
      manager.persist(zika);
      manager.persist(laza);
      // zavrsimo transakciju
      tx.commit();
      System.out.println("Snimljeni objekti:\n"+pera+"\n"+zika+"\n"+laza);
      
      tx.begin();
      // pronadjemo sve objekte u bazi sa ID>0
      Query query = manager.createQuery("SELECT a FROM Admin a WHERE a.id>?1");
      query.setParameter(1, 0);
      List<Admin> list = query.getResultList();
      tx.commit();
      System.out.println("Pronadjeni objekti:");
      for (Admin a : list)
        System.out.println(a);
        
      tx.begin();
      // pronadjemo objekat u bazi (po ID=1)
      Admin admin = manager.find(Admin.class, 1);
      System.out.println("Pronadjen objekat:\n" + admin);
      // azuriramo objekat u bazi
      admin.setPassword("trlababalan");
      manager.merge(admin);
      tx.commit();
      System.out.println("Azuriran objekat:\n" + admin);
      
      tx.begin();
      // obrisemo objekat u bazi po ID>1
      Query q = manager.createQuery("DELETE FROM Admin a WHERE a.id > 1");
      int deleted = q.executeUpdate();
      tx.commit();
      System.out.println("Obrisano: " + deleted + " objekata.");
      
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      manager.close();
      factory.close();
    }
  }
}
