package pr02.server;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pr02.Main;
import pr02.model.Category;
import spark.*;

import java.util.List;


public class CategoryApi {

  public static String getRootCategories(Request request, Response response) {
    EntityManager em = Main.getEntityManagerFactory().createEntityManager();
    TypedQuery<Category> query = em.createQuery(
        "SELECT c FROM Category c WHERE c.parent IS NULL", Category.class);
    List<Category> result = query.getResultList();
    em.close();
    Gson gson = new GsonBuilder().setExclusionStrategies(
        new AttributeExclusionStrategy("children|products")).create();
    return gson.toJson(result);
  }

  public static String getCategory(Request request, Response response) {
    String catId = request.params(":id");
    EntityManager em = Main.getEntityManagerFactory().createEntityManager();
    Category category = getCategory(em, catId);
    if (category == null) {
      response.redirect("/error", 404);
      return "";
    }
    Gson gson = new GsonBuilder().setExclusionStrategies(
      new AttributeExclusionStrategy("parent|category|supplier")).create();
    String result = gson.toJson(category);
    em.close();
    return result;
  }

  public static Category getCategory(EntityManager em, int id) {
    TypedQuery<Category> query = em.createQuery(
        "SELECT c FROM Category c WHERE c.id=:id", Category.class);
    query.setParameter("id", id);
    return query.getSingleResult();
  }

  public static Category getCategory(EntityManager em, String id) {
    try {
      int cid = Integer.parseInt(id);
      return getCategory(em, cid);
    } catch (Exception ex) {
      return null;
    }
  }
}
