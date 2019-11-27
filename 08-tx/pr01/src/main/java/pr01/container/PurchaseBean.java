package pr01.container;

import static javax.ejb.TransactionAttributeType.REQUIRED;
import static javax.ejb.TransactionManagementType.CONTAINER;
import pr01.CreditCard;
import pr01.PurchaseOrder;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionManagement;

@Stateless(name="PurchaseContainer")
@Remote(Purchase.class)
@Local(PurchaseLocal.class)
@TransactionManagement(CONTAINER)
public class PurchaseBean implements Purchase {
  
  @TransactionAttribute(REQUIRED)
  public boolean processOrder(PurchaseOrder order, CreditCard card) {
    boolean paymentOK = false;
    try {
      paymentOK = payment.processCreditCard(card);
    } catch (MyException ex) {
      paymentOK = false;
    }
    return paymentOK;
  }
  
  @EJB
  private PaymentLocal payment;
}
