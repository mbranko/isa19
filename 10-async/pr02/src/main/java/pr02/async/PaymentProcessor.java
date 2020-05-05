package pr02.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import pr02.message.PaymentInfo;

import java.util.concurrent.Future;

@Component
public class PaymentProcessor {

  @Async
  public void processPaymentOne(PaymentInfo paymentInfo) {
    System.out.println("[PaymentProcessor.processPaymentOne][" + Thread.currentThread().getName() + "]: " + paymentInfo);
  }

  @Async
  public Future<String> processPaymentTwo(PaymentInfo paymentInfo) {
    System.out.println("[PaymentProcessor.processPaymentTwo][" + Thread.currentThread().getName() + "]: " + paymentInfo);
    return new AsyncResult<>("DEMO RESULT");
  }

}
