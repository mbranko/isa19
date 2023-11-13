package pr05.v2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

// ovde je dovoljno navesti da je klasa entity, sve se nasledjuje 
// iz BillingDetails
@Entity(name="CreditCard2")
@Table(name="v2_creditcard")
public class CreditCard extends BillingDetails {

  @Column(name="number", unique=false, nullable=false)
  private String number;
  
  @Column(name="exp_month", unique=false, nullable=false)
  private String expMonth;
  
  @Column(name="exp_year", unique=false, nullable=false)
  private String expYear;

  public CreditCard() {
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getExpMonth() {
    return expMonth;
  }

  public void setExpMonth(String expMonth) {
    this.expMonth = expMonth;
  }

  public String getExpYear() {
    return expYear;
  }

  public void setExpYear(String expYear) {
    this.expYear = expYear;
  }
}