package pr01;

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

    // pozovi stateless bean
    System.out.println("==== STATELESS ====");
    Hello hello = (Hello) ctx.lookup("HelloBeanRemote");
    String response = hello.hello("Branko");
    System.out.println("Response: " + response);

    // pozovi stateful bean 10 puta
    System.out.println("==== STATEFUL ====");
    Count c = (Count)ctx.lookup("CountBeanRemote");
    for (int i = 0; i < 10; i++) {
      System.out.println("count: " + c.count());
      Thread.sleep(100);
    }

    // pozovi singleton bean 10 puta
    System.out.println("==== SINGLETON ====");
    SingletonCount sc = (SingletonCount)ctx.lookup("SingletonCountBeanRemote");
    for (int i = 0; i < 10; i++) {
      System.out.println("count: " + sc.count());
      Thread.sleep(100);
    }
  }
}