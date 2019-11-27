package pr01.container;

import pr01.CreditCard;
import pr01.PurchaseOrder;

import javax.naming.Context;
import javax.naming.InitialContext;

public class ContainerMgdClient {

  public static void test() throws Exception {
    CreditCard card = new CreditCard(12, 2010, "John Doe", "411111111111");
    PurchaseOrder order = new PurchaseOrder();

    Context ctx = new InitialContext();
    Purchase purchase = (Purchase)ctx.lookup("java:global/pr01/PurchaseContainer!pr01.container.Purchase");

    boolean status = purchase.processOrder(order, card);
    System.out.println(status ? "Order processed." : "Order rejected.");
  }
}
