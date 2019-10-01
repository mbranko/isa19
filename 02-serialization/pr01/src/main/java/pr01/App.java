package pr01;

import java.util.List;

import spark.*;
import static spark.Spark.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.*;

import pr01.model.*;
import pr01.serializers.*;

public class App {

  public static void main(String[] args) {
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

      get("/studenti/:id", App::getStudent);
      get("/studenti/", App::getStudenti);
      get("/studenti", App::getStudenti);
      get("/ocene/:id", App::getOcena);
      get("/ocene/", App::getOcene);
      get("/ocene", App::getOcene);
    });
  }

  public static String getStudent(Request request, Response response) {
    String indeks = request.params(":id");
    Student s = DemoFactory.getStudent(indeks);
    if (s == null) {
      response.status(404);
      return "";
    }
    String format = "json1";
    if (request.queryParams("format") != null)
      format = request.queryParams("format");
    response.status(200);
    response.type("application/json");
    switch(format) {
      case "json":
      case "json1":
        return Json1Serializer.serialize(s, "student");
      case "json2":
        return Json1Serializer.serialize(s, "student|ocene");
      default:
        return "";
    }
  }

  public static String getStudenti(Request request, Response response) {
    List<Student> s = DemoFactory.getStudenti();
    String format = "json1";
    if (request.queryParams("format") != null)
      format = request.queryParams("format");
    response.status(200);
    response.type("application/json");
    switch(format) {
      case "json":
      case "json1":
        return Json1Serializer.serialize(s, "student");
      case "json2":
        return Json1Serializer.serialize(s, "student|ocene");
      default:
        return "";
    }
  }

  public static String getOcena(Request request, Response response) {
    String ocenaId = request.params(":id");
    int oid = Integer.parseInt(ocenaId);
    Ocena o = DemoFactory.getOcena(oid);
    if (o == null) {
      response.status(404);
      return "";
    }
    String format = "json1";
    if (request.queryParams("format") != null)
      format = request.queryParams("format");
    response.status(200);
    response.type("application/json");
    switch(format) {
      case "json":
      case "json1":
        return Json1Serializer.serialize(o, "ocene");
      case "json2":
        return Json2Serializer.serialize(o, "ocene");
      default:
        return "";
    }
  }

  public static String getOcene(Request request, Response response) {
    List<Ocena> ocene = DemoFactory.getOcene();
    String format = "json1";
    if (request.queryParams("format") != null)
      format = request.queryParams("format");
    response.status(200);
    response.type("application/json");
    switch(format) {
      case "json":
      case "json1":
        return Json1Serializer.serialize(ocene, "ocene");
      case "json2":
        return Json2Serializer.serialize(ocene, "ocene");
      default:
        return "";
    }
  }
}