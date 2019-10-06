package pr03;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Local;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful(name="CountBean")
@Remote(Count.class)
@Local(CountLocal.class)
public class CountBean implements Count {
  
  private int value = 0;

  public int count() {
    return ++value;
  }
  
  public void set(int value) {
    this.value = value;
  }
  
  @Remove
  public void remove() {
    System.out.println("[CountBean] @Remove");
  }
  
  @PostConstruct
  public void construct() {
    System.out.println("[CountBean] @PostConstruct");
  }
  
  @PreDestroy
  public void destroy() {
    System.out.println("[CountBean] @PreDestroy");
  }

  @PostActivate
  public void activate() {
    System.out.println("[CountBean] @PostActivate");
  }
  
  @PrePassivate
  public void passivate() {
    System.out.println("[CountBean] @PrePassivate");
  }

}

