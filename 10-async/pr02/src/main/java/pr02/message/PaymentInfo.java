package pr02.message;

import java.io.Serializable;
import java.math.BigDecimal;

public class PaymentInfo implements Serializable {

  private CardType cardType;
  private String cardNumber;
  private String expiryDate;
  private BigDecimal amount;

  public PaymentInfo(CardType cardType, String cardNumber, String expiryDate,
      BigDecimal amount) {
    this.cardType = cardType;
    this.cardNumber = cardNumber;
    this.expiryDate = expiryDate;
    this.amount = amount;
  }

  public PaymentInfo() {
  }
  public CardType getCardType() {
    return cardType;
  }
  public void setCardType(CardType cardType) {
    this.cardType = cardType;
  }
  public String getCardNumber() {
    return cardNumber;
  }
  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }
  public String getExpiryDate() {
    return expiryDate;
  }
  public void setExpiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
  }
  public BigDecimal getAmount() {
    return amount;
  }
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
  
  @Override
  public String toString() {
    return "PaymentInfo[cardType="+cardType+",cardNumber="+cardNumber+
        ",expiryDate="+expiryDate+",amount="+amount+"]";
  }

  private static final long serialVersionUID = 4148763144979916258L;
}
