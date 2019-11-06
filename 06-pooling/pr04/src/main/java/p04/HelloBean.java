package pr04;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Local(HelloLocal.class)
@Remote(Hello.class)
public class HelloBean implements Hello {

  public String hello() {
    return "Hello from " + this.toString();
  }

}
