package pr02;

import java.io.IOException;
import java.util.List;

import spark.*;
import static spark.Spark.*;

import pr02.messages.OceneProtos.Ocena;
import pr02.messages.OceneProtos.Predmet;
import pr02.messages.OceneProtos.Student;

public class App {

  public static void main(String[] args) {
    notFound((req, res) -> "{ \"error\": \"404 Not Found\"}");
    internalServerError((req, res) -> "{ \"error\": \"500 Internal Server Error\"}");
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
    response.status(200);
    response.type("application/x-protobuf; messageType=\"pr02.messages.Student\"");
    try {
      s.writeTo(response.raw().getOutputStream());
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return "";
  }

  public static String getStudenti(Request request, Response response) {
    Studenti s = DemoFactory.getStudenti();
    response.status(200);
    response.type("application/x-protobuf; messageType=\"pr02.messages.Studenti\"");
    try {
      s.writeTo(response.raw().getOutputStream());
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return "";
  }

  public static String getOcena(Request request, Response response) {
    String ocenaId = request.params(":id");
    int oid = Integer.parseInt(ocenaId);
    Ocena o = DemoFactory.getOcena(oid);
    if (o == null) {
      response.status(404);
      return "";
    }
    response.status(200);
    response.type("application/x-protobuf; messageType=\"pr02.messages.Ocena\"");
    try {
      o.writeTo(response.raw().getOutputStream());
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return "";
  }

  public static String getOcene(Request request, Response response) {
    Ocene ocene = DemoFactory.getOcene();
    response.status(200);
    response.type("application/x-protobuf; messageType=\"pr02.messages.Ocene\"");
    try {
      ocene.writeTo(response.raw().getOutputStream());
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return "";
  }
}
