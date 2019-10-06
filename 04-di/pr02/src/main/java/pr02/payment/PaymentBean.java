package pr02.payment;

import pr02.model.CreditCard;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless(name="PaymentBean")
@Local(PaymentLocal.class)
@Remote(Payment.class)
public class PaymentBean implements Payment {

  public boolean processCreditCard(CreditCard card) {
    return Math.random() < 0.5f;
  }
}
