package pr02.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pr02.Main;
import pr02.model.Category;
import pr02.model.Product;
import spark.Request;
import spark.Response;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BreadcrumbApi {

  public static String getBreadcrumbsForProduct(Request req, Response res) {
    String prodId = req.params(":id");
    EntityManager em = Main.getEntityManagerFactory().createEntityManager();
    Product product = ProductApi.getProduct(em, prodId);
    if (product == null) {
      res.redirect("/error", 404);
      return "";
    }
    List<Category> ancestors = new ArrayList<>();
    Category parent = product.getCategory();
    ancestors.add(parent);
    parent = parent.getParent();
    while (parent != null) {
      ancestors.add(parent);
      parent = parent.getParent();
    }
    Collections.reverse(ancestors);

    Gson gson = new GsonBuilder().setExclusionStrategies(
        new AttributeExclusionStrategy("parent|children|products")).create();
    String result = gson.toJson(ancestors);
    em.close();
    return result;
  }

  public static String getBreadcrumbsForCategory(Request req, Response res) {
    String catId = req.params(":id");
    EntityManager em = Main.getEntityManagerFactory().createEntityManager();
    Category category = CategoryApi.getCategory(em, catId);
    if (category == null) {
      res.redirect("/error", 404);
      return "";
    }
    List<Category> ancestors = new ArrayList<>();
    Category parent = category.getParent();
    while (parent != null) {
      ancestors.add(parent);
      parent = parent.getParent();
    }
    Collections.reverse(ancestors);

    Gson gson = new GsonBuilder().setExclusionStrategies(
        new AttributeExclusionStrategy("parent|children|products")).create();
    String result = gson.toJson(ancestors);
    em.close();
    return result;
  }
}
