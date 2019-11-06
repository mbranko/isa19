package pr04;

public class ClientThread extends Thread {

  private Hello bean;

  public ClientThread setBean(Hello bean) {
    this.bean = bean;
    return this;
  }

  public void run() {
    System.out.println("Thread: " + this.toString() + ", reply: " + bean.hello());
    try {
      Thread.sleep(20);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
