package pr02;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeanScopeApp {

  public static void main(String[] args) {
    Logger.getLogger("").setLevel(Level.OFF);
    SpringApplication.run(BeanScopeApp.class, args);
  }
}
