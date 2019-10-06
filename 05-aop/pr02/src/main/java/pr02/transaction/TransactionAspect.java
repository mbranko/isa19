package pr02.transaction;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAspect {

  @Around("@annotation(pr02.transaction.Transactable)")
  public Object performTransaction(ProceedingJoinPoint proceedingJoinPoint) {
    System.out.println("[TransactionAspect] checking before invocation");
    Object value = null;
    try {
      value = proceedingJoinPoint.proceed();
    } catch (Throwable e) {
      e.printStackTrace();
    }
    System.out.println("[TransactionAspect] checking after invocation; return value: " + value);
    return value;
  }
}
