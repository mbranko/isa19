package pr03.beans;

import org.springframework.stereotype.Component;
import pr03.model.CreditCard;

@Component
public class PaymentBean {

  public boolean processCreditCard(CreditCard card) {
    return Math.random() < 0.5f;
  }

}
