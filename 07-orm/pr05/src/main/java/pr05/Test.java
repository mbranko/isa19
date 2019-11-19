package pr05;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {
  public static void main(String[] args) throws Exception {
    Logger.getLogger("").setLevel(Level.OFF);
    final EntityManagerFactory factory =
        Persistence.createEntityManagerFactory("Bank");

    EntityManager em = factory.createEntityManager();

    /* prva varijanta */
    pr05.v1.BankAccount b1 = new pr05.v1.BankAccount();
    b1.setBankName("Super Banka");
    b1.setSwift("SUBARS99");
    b1.setNumber("123456789");
    b1.setOwner("Zika");

    pr05.v1.CreditCard c1 = new pr05.v1.CreditCard();
    c1.setNumber("1234123412341234");
    c1.setExpMonth("11");
    c1.setExpYear("2019");
    c1.setOwner("Zika");

    /* druga varijanta */
    pr05.v2.BankAccount b2 = new pr05.v2.BankAccount();
    b2.setBankName("Super Banka");
    b2.setSwift("SUBARS99");
    b2.setNumber("123456789");
    b2.setOwner("Zika");

    pr05.v2.CreditCard c2 = new pr05.v2.CreditCard();
    c2.setNumber("1234123412341234");
    c2.setExpMonth("11");
    c2.setExpYear("2019");
    c2.setOwner("Zika");

    /* treca varijanta */
    pr05.v3.BankAccount b3 = new pr05.v3.BankAccount();
    b3.setBankName("Super Banka");
    b3.setSwift("SUBARS99");
    b3.setNumber("123456789");
    b3.setOwner("Zika");

    pr05.v3.CreditCard c3 = new pr05.v3.CreditCard();
    c3.setNumber("1234123412341234");
    c3.setExpMonth("11");
    c3.setExpYear("2019");
    c3.setOwner("Zika");

    /* cetvrta varijanta */
    pr05.v4.BankAccount b4 = new pr05.v4.BankAccount();
    b4.setBankName("Super Banka");
    b4.setSwift("SUBARS99");
    b4.setNumber("123456789");
    b4.setOwner("Zika");

    pr05.v4.CreditCard c4 = new pr05.v4.CreditCard();
    c4.setNumber("1234123412341234");
    c4.setExpMonth("11");
    c4.setExpYear("2019");
    c4.setOwner("Zika");

    em.getTransaction().begin();
    em.persist(b1);
    em.persist(c1);
    System.out.println("Sacuvani v1");
    em.persist(b2);
    em.persist(c2);
    System.out.println("Sacuvani v2");
    em.persist(b3);
    em.persist(c3);
    System.out.println("Sacuvani v3");
    em.persist(b4);
    em.persist(c4);
    System.out.println("Sacuvani v4");
    em.getTransaction().commit();

    em.close();

    System.exit(0);
  }
}
