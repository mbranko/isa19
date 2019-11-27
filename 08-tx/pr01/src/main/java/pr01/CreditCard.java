package pr01;

import java.io.Serializable;

public class CreditCard implements Serializable {

  private String number;
  private int expiryMonth;
  private int expiryYear;
  private String holderName;

  public CreditCard(int expiryMonth, int expiryYear, String holderName,
      String number) {
    this.expiryMonth = expiryMonth;
    this.expiryYear = expiryYear;
    this.holderName = holderName;
    this.number = number;
  }

  public CreditCard() {
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public int getExpiryMonth() {
    return expiryMonth;
  }

  public void setExpiryMonth(int expiryMonth) {
    this.expiryMonth = expiryMonth;
  }

  public int getExpiryYear() {
    return expiryYear;
  }

  public void setExpiryYear(int expiryYear) {
    this.expiryYear = expiryYear;
  }

  public String getHolderName() {
    return holderName;
  }

  public void setHolderName(String holderName) {
    this.holderName = holderName;
  }
  
  private static final long serialVersionUID = 4446086264471552176L;
}
