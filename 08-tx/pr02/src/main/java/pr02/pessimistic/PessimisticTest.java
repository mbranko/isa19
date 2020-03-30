package pr02.pessimistic;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

public class PessimisticTest {
  
  public static void run(EntityManagerFactory factory) throws Exception {
    final CountDownLatch latch = new CountDownLatch(2);
    Runnable r1 = () -> {
      try {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        // ucitaj objekat
        System.out.println("[Thread 1] Ucitavam i zakljucavam objekat...");
        BankAccount account = em.find(BankAccount.class, 1,
            LockModeType.PESSIMISTIC_WRITE);

        // cekaj 3 sekunde
        System.out.println("[Thread 1] Cekam 3 sekunde...");
        try { Thread.sleep(3000); } catch (InterruptedException e) { }

        // dodaj 10000 na racun
        System.out.println("[Thread 1] Dodajem 10000 na racun...");
        account.deposit(new BigDecimal(10000));

        System.out.println("[Thread 1] Zavrsavam transakciju...");
        em.getTransaction().commit();
        em.close();
      } catch (Exception e) {
        System.out.println("[Thread 1] " + e.getMessage());
        e.printStackTrace();
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
        System.out.println("[Thread 2] Ucitavam i zakljucavam objekat...");
        BankAccount account = em.find(BankAccount.class, 1,
            LockModeType.PESSIMISTIC_WRITE);

        // skini 500 sa racuna
        System.out.println("[Thread 2] Skidam 500 sa racuna...");
        account.withdraw(new BigDecimal(500));

        System.out.println("[Thread 2] Zavrsavam transakciju...");
        em.getTransaction().commit();
        em.close();
      } catch (Exception e) {
        System.out.println("[Thread 2] " + e.getMessage());
        e.printStackTrace();
      }
      latch.countDown();
    };

    new Thread(r1).start();
    new Thread(r2).start();
    latch.await();
  }
}
