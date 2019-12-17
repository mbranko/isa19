package pr01;

import org.apache.openejb.core.LocalInitialContextFactory;

import javax.annotation.Resource;
import javax.ejb.embeddable.EJBContainer;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {

  @Resource
  private static ConnectionFactory factory;

  public static void main(String[] args) throws Exception {
    Logger.getLogger("").setLevel(Level.OFF);
    final Properties properties = new Properties();
    properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, LocalInitialContextFactory.class.getName());
    properties.setProperty(Context.PROVIDER_URL, "ejbd://localhost:4201");
    properties.setProperty("openejb.embedded.remotable", "true");
    properties.setProperty("ejbd.port", "4201");
    properties.setProperty("ejbd.disabled", "false");
    properties.setProperty("openejb.jmx.active", "false");
    final EJBContainer container = EJBContainer.createEJBContainer(properties);
    Context ctx = new InitialContext();

    Client client = (Client)ctx.lookup("java:global/pr01/ClientBean!pr01.Client");

    System.out.println("\n==== QUEUE ====");
    client.sendToQueue();

    System.out.println("\n==== TOPIC CLIENT ====");
    client.sendToTopic();

    try { Thread.sleep(2000); } catch (Exception ex) { }
    container.close();
  }
}
