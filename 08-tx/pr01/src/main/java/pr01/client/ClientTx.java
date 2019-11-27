package pr01.client;

import pr01.CreditCard;
import pr01.PurchaseOrder;
import pr01.container.Purchase;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.transaction.UserTransaction;

/**
 * Rucno upravljanje transakcijom sa strane klijenta.
 */
public class ClientTx {

  public static void test() throws Exception {
    Context ctx = new InitialContext();
    Purchase purchase = (Purchase) ctx.lookup(
        "java:global/pr01/PurchaseContainer!pr01.container.Purchase");

    UserTransaction tx = (UserTransaction)ctx.lookup(
        "java:comp/UserTransaction");
    tx.begin();
    CreditCard card = new CreditCard(12, 2010, "John Doe", "411111111111");
    PurchaseOrder order = new PurchaseOrder();
    boolean status = purchase.processOrder(order, card);
    if (status)
      tx.commit();
    else
      tx.rollback();

    System.out.println(status ? "Order processed." : "Order rejected.");
  }
}
