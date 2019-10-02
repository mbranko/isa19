package pr01;

import org.apache.openejb.OpenEjbContainer;
import org.apache.openejb.core.LocalInitialContextFactory;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class Server {

  private Server() {
  }

  public static void main(String[] args) throws Exception {
    final Properties properties = new Properties();
    properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, 
        LocalInitialContextFactory.class.getName());
    properties.setProperty("openejb.embedded.remotable", "true");
    properties.setProperty("ejbd.port", "4201");
    properties.setProperty("ejbd.disabled", "false");
    properties.setProperty("openejb.jmx.active", "false");
    // properties.setProperty("openejb.jndiname.format", "{deploymentId}");
    final EJBContainer container = EJBContainer.createEJBContainer(properties);
    final CountDownLatch latch = new CountDownLatch(10);

    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        latch.countDown();
        container.close();
      }
    });

    latch.await();
  }
}