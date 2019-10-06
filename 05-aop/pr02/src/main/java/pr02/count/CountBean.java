package pr02.count;

import org.springframework.stereotype.Component;
import pr02.logger.Loggable;
import pr02.transaction.Transactable;

@Component
public class CountBean {

  private int count = 0;

  @Loggable
  public int count() {
    System.out.println("[CountBean] Incrementing counter to: " + (++count));
    return count;
  }

  @Transactable
  public int store() {
    System.out.println("[CountBean] storing counter value: " + count);
    return count;
  }
}
