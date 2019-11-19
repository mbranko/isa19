package pr04;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

public class Client {

  public static void main(String[] args) throws Exception {
    Logger.getLogger("").setLevel(Level.OFF);
    Properties properties = new Properties();
    properties.setProperty(Context.INITIAL_CONTEXT_FACTORY,
        "org.apache.openejb.client.RemoteInitialContextFactory");
    properties.setProperty(Context.PROVIDER_URL,
        "ejbd://localhost:4201");
    InitialContext ctx = new InitialContext(properties);

    System.out.println("===== Test 1: single thread");
    Hello hello = (Hello) ctx.lookup("java:global/Server/HelloBean!pr04.Hello");
    for (int i = 0; i < 10; i++) {
      System.out.println(hello.hello());
      Thread.sleep(20);
    }

    System.out.println("===== Test 2: multi thread");
    for (int i = 0; i < 100; i++) {
      new ClientThread().setBean(hello).start();
    }
  }
}