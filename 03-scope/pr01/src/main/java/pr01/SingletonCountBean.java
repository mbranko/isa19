package pr01;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Singleton;

@Singleton(name="SingletonCountBean")
@Remote(SingletonCount.class)
@Local(SingletonCountLocal.class)
public class SingletonCountBean implements SingletonCount {

  public int count() {
    return ++value;
  }

  public void set(int value) {
    this.value = value;
  }

  private int value = 0;

}
