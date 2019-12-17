package pr02.server;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pr02.model.Product;
import spark.Request;
import spark.Response;

import pr02.Main;

public class ProductApi {

  public static String getProduct(Request req, Response res) {
    String prodId = req.params(":id");
    EntityManager em = Main.getEntityManagerFactory().createEntityManager();
    Product product = getProduct(em, prodId);
    if (product == null) {
      res.redirect("/error", 404);
      return "";
    }

    Gson gson = new GsonBuilder().setExclusionStrategies(
        new AttributeExclusionStrategy("parent|products|orderItems|images")).create();
    String result =  gson.toJson(product);
    em.close();
    return result;
  }

  public static Product getProduct(EntityManager em, int id) {
    TypedQuery<Product> query = em.createQuery(
        "SELECT p FROM Product p WHERE p.id=:id", Product.class);
    query.setParameter("id", id);
    return query.getSingleResult();
  }

  public static Product getProduct(EntityManager em, String id) {
    try {
      int pid = Integer.parseInt(id);
      return getProduct(em, pid);
    } catch (Exception ex) {
      return null;
    }
  }
}
