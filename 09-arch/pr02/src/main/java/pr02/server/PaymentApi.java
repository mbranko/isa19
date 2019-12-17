package pr02.server;

import javax.persistence.EntityManager;
import java.util.Date;

import com.google.gson.*;
import pr02.Main;
import pr02.model.OrderItem;
import pr02.model.Product;
import pr02.model.PurchaseOrder;
import pr02.model.User;
import spark.Request;
import spark.Response;


public class PaymentApi {
  public static String makePayment(Request request, Response response) {
    JsonObject root = new JsonParser().parse(request.body()).getAsJsonObject();
    JsonObject order = root.getAsJsonObject("order");
    JsonArray items = order.getAsJsonArray("items");
    EntityManager em = Main.getEntityManagerFactory().createEntityManager();
    em.getTransaction().begin();
    PurchaseOrder purchaseOrder = new PurchaseOrder();
    purchaseOrder.setDate(new Date());

    for (int i = 0; i < items.size(); i++) {
      OrderItem item = new OrderItem();
      int productId = items.get(i).getAsJsonObject().get("product").getAsJsonObject().get("id").getAsInt();
      item.setProduct(em.find(Product.class, productId));
      item.setQuantity(items.get(i).getAsJsonObject().get("quantity").getAsInt());
      purchaseOrder.add(item);
    }
    User user = em.find(User.class, 1);
    user.add(purchaseOrder);
    response.status(201);

    em.getTransaction().commit();
    em.close();
    return "{ \"status\": \"OK\"}";
  }
}
