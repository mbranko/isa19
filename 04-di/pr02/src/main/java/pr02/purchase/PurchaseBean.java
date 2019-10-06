package pr02.purchase;

import pr02.model.Order;
import pr02.payment.PaymentLocal;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Stateless(name="PurchaseBean")
@Remote(Purchase.class)
@Local(PurchaseLocal.class)
public class PurchaseBean implements Purchase {
  
  public boolean processOrder(Order order) {
    boolean paymentOK = payment.processCreditCard(order.getCreditCard());
    return paymentOK;
  }

  /*
  Ovo nam više nije potrebno

  @PostConstruct
  public void construct() {
    try {
      Properties env = new Properties();
      env.put("java.naming.factory.initial", 
          "org.apache.openejb.client.LocalInitialContextFactory");
      Context c = new InitialContext(env);
      payment = (PaymentLocal)c.lookup("PaymentBeanLocal");
    } catch (NamingException ex) {
      ex.printStackTrace();
    }
  }
  */

  @EJB
  private PaymentLocal payment;
}
