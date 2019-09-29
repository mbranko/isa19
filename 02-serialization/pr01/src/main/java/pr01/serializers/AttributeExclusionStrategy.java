package pr01.serializers;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class AttributeExclusionStrategy implements ExclusionStrategy {

  private String regex;

  public AttributeExclusionStrategy(String regex) {
    this.regex = regex;
  }
  public boolean shouldSkipClass(Class<?> clazz) {
    return false;
  }

  public boolean shouldSkipField(FieldAttributes fa) {
    return fa.getName().matches(regex);
  }
}
