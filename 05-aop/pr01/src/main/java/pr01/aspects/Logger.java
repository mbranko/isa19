package pr01.aspects;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class Logger {

  @AroundInvoke
  public Object logEvent(InvocationContext ctx) throws Exception {
    if (ctx.getMethod() == null)
      return ctx.proceed();
    
    // pokupi naziv metode koja se poziva
    String methodName = ctx.getMethod().getName();

    // da li naziv metode pocinje sa "process"
    if (methodName.startsWith("process")) 
      // ispisi naziv metode
      System.out.println("Method called: " + methodName);

    // dozvoli dalje izvrsavanje
    return ctx.proceed();
  }
}
