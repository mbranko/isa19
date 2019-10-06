package pr02;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import pr02.count.CountBean;

@SpringBootApplication
public class AOPApp {
  public static void main(String[] args) {
    ConfigurableApplicationContext ctx = new SpringApplicationBuilder()
        .sources(AOPApp.class)
        .run(args);

    CountBean count = ctx.getBean(CountBean.class);
    for(int i = 0; i < 5; i++)
      System.out.println("returned: " + count.count());

    count.store();
  }
}
