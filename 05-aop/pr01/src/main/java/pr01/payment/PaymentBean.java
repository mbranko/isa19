package pr01.payment;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import pr01.model.CreditCard;
import pr01.aspects.Logger;

@Stateless(name="PaymentBean")
@Local(PaymentLocal.class)
@Remote(Payment.class)
public class PaymentBean implements Payment {

  @Interceptors(Logger.class)
  public boolean processCreditCard(CreditCard card) {
    return Math.random() < 0.5f;
  }
}
