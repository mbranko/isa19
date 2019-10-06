package pr03;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import pr03.beans.PurchaseBean;
import pr03.model.CreditCard;
import pr03.model.Order;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class DIApp {
  public static void main(String[] args) {
    ConfigurableApplicationContext ctx = new SpringApplicationBuilder()
        .sources(DIApp.class)
        .run(args);

    PurchaseBean pb = ctx.getBean(PurchaseBean.class);

    CreditCard card = new CreditCard(12, 2010, "John Doe", "411111111111");
    Order order = new Order(card, new Date(), new ArrayList<>(), new ArrayList<>());

    System.out.println("PurchaseBean: " + pb.processOrder(order));
  }
}
