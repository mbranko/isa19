package pr06;

import pr06.natural.Drzava;
import pr06.natural.MesnaZajednica;
import pr06.natural.NaseljenoMesto;
import pr06.surrogate.PrimerIdentity;
import pr06.surrogate.PrimerSequence;
import pr06.surrogate.PrimerTable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {
  public static void main(String[] args) throws Exception {
    Logger.getLogger("").setLevel(Level.OFF);
    final EntityManagerFactory factory =
        Persistence.createEntityManagerFactory("KeyDemo");

    EntityManager em = factory.createEntityManager();

    /*
      Kreiranje objekata sa surogatnim kljucem: vrednost kljuca se
      ne definise prilikom kreiranja objekta, vec prilikom inserta
      u bazu podataka.
     */
    PrimerIdentity p1 = new PrimerIdentity();
    p1.setName("ABC");
    PrimerSequence p2 = new PrimerSequence();
    p2.setName("DEF");
    PrimerTable p3 = new PrimerTable();
    p3.setName("GHI");

    /*
      Kreiranje objekata sa prirodnim kljucem: vrednost kljuca se
      mora definisati pre inserta u bazu podataka.
     */
    Drzava drzava = new Drzava("SRB", "Srbija");
    NaseljenoMesto naseljenoMesto = new NaseljenoMesto("21000", "Novi Sad");
    drzava.add(naseljenoMesto);
    MesnaZajednica mesnaZajednica = new MesnaZajednica("1", "Liman"); // \m/
    naseljenoMesto.add(mesnaZajednica);

    em.getTransaction().begin();

    System.out.println("\n===== SURROGATE =====");
    em.persist(p1);
    em.persist(p2);
    em.persist(p3);
    System.out.println("Dodato 3 objekta sa surogatnim kljucevima.");
    em.getTransaction().commit();

    System.out.println("\n===== NATURAL =====");
    em.getTransaction().begin();
    em.persist(drzava);
    // zbog kaskadnog inserta (vidi OneToMany stranu veze) ove vezane objekte
    // ne moramo eksplicitno snimati
    // manager.persist(naseljenoMesto);
    // manager.persist(mesnaZajednica);
    em.getTransaction().commit();

    // pronadjemo sve drzave u bazi sa sifrom SRB
    Query query = em.createQuery("SELECT d FROM Drzava d WHERE d.sifra=?1");
    query.setParameter(1, "SRB");
    List<Drzava> list = query.getResultList();
    System.out.println("Pronadjeni objekti:");
    for (Drzava drz: list)
      System.out.println(drz);

    em.getTransaction().begin();
    // obrisemo mesne zajednice sa rednim brojem 1
    Query q = em.createQuery("DELETE MesnaZajednica mz WHERE mz.redniBroj = '1'");
    int deleted = q.executeUpdate();
    // obrisemo naseljena mesta sa ptt brojem 21000
    q = em.createQuery("DELETE NaseljenoMesto nm WHERE nm.pttBroj = '21000'");
    deleted += q.executeUpdate();
    // obrisemo drzave sa sifrom SRB
    q = em.createQuery("DELETE Drzava d WHERE d.sifra = 'SRB'");
    deleted += q.executeUpdate();
    em.getTransaction().commit();
    System.out.println("Obrisano: " + deleted + " objekata.");

    em.close();
    System.exit(0);
  }
}
