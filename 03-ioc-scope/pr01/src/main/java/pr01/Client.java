package pr01;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

public class Client {

  public static void main(String[] args) throws Exception {
    Properties properties = new Properties();
    properties.setProperty(Context.INITIAL_CONTEXT_FACTORY,
        "org.apache.openejb.client.RemoteInitialContextFactory");
    properties.setProperty(Context.PROVIDER_URL,
        "ejbd://localhost:4201");
    InitialContext ctx = new InitialContext(properties);
    Logger.getLogger("").setLevel(Level.OFF);

    // pozovi stateless bean
    System.out.println("==== STATELESS ====");
    Hello hello = (Hello) ctx.lookup("java:global/Server/HelloBean!pr01.Hello");
    
    // poziv se desava ovde
    String response = hello.hello("Branko");

    System.out.println("Response: " + response);

    // pozovi stateful bean 10 puta
    System.out.println("==== STATEFUL ====");
    Count c = (Count)ctx.lookup("java:global/Server/CountBean!pr01.Count");
    for (int i = 0; i < 10; i++) {

      // poziv se desava ovde
      int count = c.count();

      System.out.println("count: " + count);
      Thread.sleep(100);
    }

    // pozovi singleton bean 10 puta
    System.out.println("==== SINGLETON ====");
    SingletonCount sc = (SingletonCount)ctx.lookup(
      "java:global/Server/SingletonCountBean!pr01.SingletonCount");
    for (int i = 0; i < 10; i++) {

      // poziv se desava ovde
      int count = sc.count();

      System.out.println("count: " + count);
      Thread.sleep(100);
    }
  }
}