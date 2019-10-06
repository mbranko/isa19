package pr03.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pr03.model.Order;

@Component
public class PurchaseBean {

  @Autowired
  private PaymentBean payment;

  public boolean processOrder(Order order) {
    boolean paymentOK = payment.processCreditCard(order.getCreditCard());
    return paymentOK;
  }

}
