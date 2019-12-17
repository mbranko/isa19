package pr29;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import pr29.async.PaymentClient;

@SpringBootApplication
@EnableAsync
public class AsyncApp {
  public static void main(String[] args) throws Exception {
    System.setProperty("logging.pattern.console", "");
    ConfigurableApplicationContext ctx = new SpringApplicationBuilder()
        .sources(AsyncApp.class)
        .bannerMode(Banner.Mode.OFF)
        .run(args);

    PaymentClient client = ctx.getBean(PaymentClient.class);
    client.testPayment();
  }
}
