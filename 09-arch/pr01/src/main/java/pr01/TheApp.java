package pr01;

import org.apache.openejb.testing.Application;
import org.apache.tomee.embedded.TomEEEmbeddedApplicationRunner;

@Application
public class TheApp {

  public static void main(String[] args) throws Exception {
    TomEEEmbeddedApplicationRunner.run(TheApp.class);
  }
}