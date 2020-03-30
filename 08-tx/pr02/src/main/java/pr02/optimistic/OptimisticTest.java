package pr02.optimistic;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.OptimisticLockException;

public class OptimisticTest {
  
  public static void run(EntityManagerFactory factory) throws Exception {
    final CountDownLatch latch = new CountDownLatch(2);
    Runnable r1 = () -> {
      try {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        // ucitaj objekat
        System.out.println("[Thread 1] Ucitavam objekat...");
        BankAccount account = em.find(BankAccount.class, 1);

        // cekaj 3 sekunde
        System.out.println("[Thread 1] Cekam 3 sekunde...");
        try { Thread.sleep(3000); } catch (InterruptedException e) { }

        // dodaj 10000 na racun
        System.out.println("[Thread 1] Dodajem 10000 na racun...");
        account.deposit(new BigDecimal(10000));

        System.out.println("[Thread 1] Zavrsavam transakciju...");
        em.flush();  // <-- ovde ce se desiti exception
        em.getTransaction().commit();
        em.close();
      } catch (OptimisticLockException e) {
        System.out.println("GRESKA!!! [Thread 1] " + e.getClass().getName() + ": " + e.getMessage());
      }
      latch.countDown();
    };
    
    Runnable r2 = () -> {
      try {
        // cekaj 2 sekunde
        System.out.println("[Thread 2] Cekam 2 sekunde...");
        try { Thread.sleep(2000); } catch (InterruptedException e) { }

        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        // ucitaj objekat
        System.out.println("[Thread 2] Ucitavam objekat...");
        BankAccount account = em.find(BankAccount.class, 1);

        // skini 500 sa racuna
        System.out.println("[Thread 2] Skidam 500 sa racuna...");
        account.withdraw(new BigDecimal(500));

        System.out.println("[Thread 2] Zavrsavam transakciju  ...");
        em.flush();
        em.getTransaction().commit();
        em.close();
      } catch (OptimisticLockException e) {
        System.out.println("GRESKA!!! [Thread 2] " + e.getClass().getName() + ": " + e.getMessage());
      }
      latch.countDown();
    };

    new Thread(r1).start();
    new Thread(r2).start();
    latch.await();
  }

}
