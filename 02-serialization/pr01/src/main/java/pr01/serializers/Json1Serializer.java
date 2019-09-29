package pr01.serializers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Json1Serializer {
  public static String serialize(Object obj, String skipAttrs) {
    Gson gson;
    if (skipAttrs == null)
      gson = new GsonBuilder().create();
    else
      gson = new GsonBuilder().setExclusionStrategies(
        new AttributeExclusionStrategy(skipAttrs)).create();    
    return gson.toJson(obj);
  }
}