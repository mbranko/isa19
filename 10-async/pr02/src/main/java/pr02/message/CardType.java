package pr02.message;

import java.io.Serializable;

public enum CardType implements Serializable {
  VISA("VISA"), VISA_ELECTRON("VISA Electron"), 
  MASTERCARD("MasterCard"), MAESTRO("Maestro");
  
  private CardType(String name) {
    this.name = name;
  }
  
  @Override
  public String toString() {
    return name;
  }
  
  private String name;
}
