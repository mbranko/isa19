package pr29.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pr29.message.CardType;
import pr29.message.PaymentInfo;

import java.math.BigDecimal;
import java.util.concurrent.Future;

@Component
public class PaymentClient {

  @Autowired
  PaymentProcessor paymentProcessor;

  public void testPayment() throws Exception {
    PaymentInfo msg1 = new PaymentInfo(CardType.VISA, "111111111", "2008/12",
        new BigDecimal("1350.32"));
    PaymentInfo msg2 = new PaymentInfo(CardType.VISA, "22222222", "2008/12",
        new BigDecimal("5324.33"));

    System.out.println("[PaymentClient][" + Thread.currentThread().getName() + "] Calling processPaymentOne with " + msg1);
    paymentProcessor.processPaymentOne(msg1);

    System.out.println("[PaymentClient][" + Thread.currentThread().getName() + "] Calling processPaymentTwo with " + msg2);
    Future<String> future = paymentProcessor.processPaymentTwo(msg2);
    while (!future.isDone()) {
      Thread.sleep(500);
    }
    System.out.println("[PaymentClient] Result: " + future.get());
  }
}
