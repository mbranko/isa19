package pr02.model;

import java.io.Serializable;

public class CreditCard implements Serializable {

  private String number;
  private int expiryMonth;
  private int expiryYear;
  private String holderName;
  private int cvc;

  public CreditCard(int expiryMonth, int expiryYear, String holderName,
      String number, int cvc) {
    this.expiryMonth = expiryMonth;
    this.expiryYear = expiryYear;
    this.holderName = holderName;
    this.number = number;
    this.cvc = cvc;
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

  public int getCvc() {
    return cvc;
  }

  public void setCvc(int cvc) {
    this.cvc = cvc;
  }

  @Override
  public String toString() {
    return "CreditCard{" +
        "number='" + number + '\'' +
        ", expiryMonth=" + expiryMonth +
        ", expiryYear=" + expiryYear +
        ", holderName='" + holderName + '\'' +
        ", cvc=" + cvc +
        '}';
  }

  private static final long serialVersionUID = 425031458539895797L;
}
