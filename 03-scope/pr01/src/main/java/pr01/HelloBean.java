package pr01;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Local(HelloLocal.class)
@Remote(Hello.class)
public class HelloBean implements Hello {

  public String hello(String name) {
    System.out.println("[HelloBean] Called by: " + name);
    return "Hello, " + name;
  }
  
}
