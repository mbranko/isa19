package pr06.natural;

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
    // iskljucimo Hibernate-ove log poruke, da ne zatrpava izlaz
    Logger.getLogger("").setLevel(Level.OFF);
    
    // factory proizvodi entity managere
    // factory je thread-safe
    // ime factory-ja pise u persistence.xml fajlu
    EntityManagerFactory factory = 
      Persistence.createEntityManagerFactory("NaturalKeys");
    
    // entity manager obavlja operacije nad bazom
    // nije thread-safe
    EntityManager manager = factory.createEntityManager();
    
    // kreiramo objekte
    Drzava drzava = new Drzava("SRB", "Srbija");
    NaseljenoMesto naseljenoMesto = new NaseljenoMesto("21000", "Novi Sad");
    drzava.add(naseljenoMesto);
    MesnaZajednica mesnaZajednica = new MesnaZajednica("1", "Liman"); // \m/
    naseljenoMesto.add(mesnaZajednica);

    try {
      // pocnemo transakciju
      EntityTransaction tx = manager.getTransaction();
      tx.begin();

      // snimimo objekte u bazu
      manager.persist(drzava);
      // zbog kaskadnog inserta (vidi OneToMany stranu veze) ove vezane objekte
      // ne moramo eksplicitno snimati
      // manager.persist(naseljenoMesto);
      // manager.persist(mesnaZajednica);
      
      // zavrsimo transakciju
      tx.commit();

      // pronadjemo sve drzave u bazi sa sifrom SRB
      Query query = manager.createQuery("SELECT d FROM Drzava d WHERE d.sifra=?1");
      query.setParameter(1, "SRB");
      List<Drzava> list = query.getResultList();
      System.out.println("Pronadjeni objekti:");
      for (Drzava drz: list)
        System.out.println(drz);
      
      tx.begin();
      // obrisemo mesne zajednice sa rednim brojem 1
      Query q = manager.createQuery("DELETE MesnaZajednica mz WHERE mz.redniBroj = '1'");
      int deleted = q.executeUpdate();
      // obrisemo naseljena mesta sa ptt brojem 21000
      q = manager.createQuery("DELETE NaseljenoMesto nm WHERE nm.pttBroj = '21000'");
      deleted += q.executeUpdate();
      // obrisemo drzave sa sifrom SRB
      q = manager.createQuery("DELETE Drzava d WHERE d.sifra = 'SRB'");
      deleted += q.executeUpdate();
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
