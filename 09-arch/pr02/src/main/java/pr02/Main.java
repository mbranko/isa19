package pr02;

import pr02.server.BreadcrumbApi;
import pr02.server.CategoryApi;
import pr02.server.PaymentApi;
import pr02.server.ProductApi;
import spark.route.RouteOverview;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static spark.Spark.*;

public class Main {
  public static void main(String[] args) {
    factory = Persistence.createEntityManagerFactory("WebShop");
    if (args.length > 0)
      staticFiles.externalLocation(args[0]);
    else
      staticFiles.location("/public"); // put files in src/main/resources/public

    notFound((req, res) -> "{ \"error\": \"404 Not Found\"}" );

    internalServerError((req, res) -> "{ \"error\": \"500 Internal Server Error\"}" );

    path("/api", () -> {

      // CORS
      options("/*", (req, res) -> {
        String headers = req.headers("Access-Control-Request-Headers");
        if (headers != null)
          res.header("Access-Control-Allow-Headers", headers);

        String methods = req.headers("Access-Control-Request-Method");
        if (methods != null)
          res.header("Access-Control-Allow-Methods", methods);

        res.header("Access-Control-Allow-Origin", "*");
        return "OK";
      });

      before("/*", (req, res) -> {
        res.type("application/json");
        res.header("Access-Control-Allow-Origin", "*");
      });

      after("/*", (req, res) -> {
      });

      get("/rootCategories", CategoryApi::getRootCategories);

      get("/category/:id", CategoryApi::getCategory);

      get("/product/:id", ProductApi::getProduct);

      get("/breadcrumb/product/:id", BreadcrumbApi::getBreadcrumbsForProduct);

      get("/breadcrumb/category/:id", BreadcrumbApi::getBreadcrumbsForCategory);

      post("/payment", PaymentApi::makePayment);

    });
    RouteOverview.enableRouteOverview(); // overview available at /debug/routeoverview/
  }

  public static EntityManagerFactory getEntityManagerFactory() {
    return factory;
  }

  private static EntityManagerFactory factory;
}
