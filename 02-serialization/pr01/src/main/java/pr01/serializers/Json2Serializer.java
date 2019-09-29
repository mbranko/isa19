package pr01.serializers;

import java.util.List;
import com.google.gson.*;

import pr01.model.*;

public class Json2Serializer {

  public static String serialize(Ocena ocena, String skipAttrs) {
    Gson gson;
    if (skipAttrs == null)
      gson = new GsonBuilder().create();
    else
      gson = new GsonBuilder().setExclusionStrategies(
        new AttributeExclusionStrategy(skipAttrs)).create();
    JsonElement elem = gson.toJsonTree(ocena);
    JsonObject obj = elem.getAsJsonObject();
    replacePredmetWithUrl(ocena, obj);
    replaceStudentWithUrl(ocena, obj);
    return gson.toJson(obj);
  }

  public static String serialize(List<Ocena> ocene, String skipAttrs) {
    Gson gson;
    if (skipAttrs == null)
      gson = new GsonBuilder().create();
    else
      gson = new GsonBuilder().setExclusionStrategies(
        new AttributeExclusionStrategy(skipAttrs)).create();
    JsonElement elem = gson.toJsonTree(ocene);
    JsonArray array = elem.getAsJsonArray();
    for (int i = 0; i < array.size(); i++) {
      JsonObject obj = array.get(i).getAsJsonObject();
      replacePredmetWithUrl(ocene.get(i), obj);
      replaceStudentWithUrl(ocene.get(i), obj);
    }
    return gson.toJson(array);
  }

  private static JsonObject replaceStudentWithUrl(Ocena ocena, JsonObject object) {
    object.remove("student");
    object.addProperty("student", "http://localhost:4567/api/studenti/" + ocena.getStudent().getIndeks() + "?format=json2");
    return object;
  }

  private static JsonObject replacePredmetWithUrl(Ocena ocena, JsonObject object) {
    object.remove("predmet");
    object.addProperty("predmet", "http://localhost:4567/api/predmeti/" + ocena.getPredmet().getSifra() + "?format=json2");
    return object;
  }
    
}