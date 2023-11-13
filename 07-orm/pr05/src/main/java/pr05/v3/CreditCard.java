package pr05.v3;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="CreditCard3")
// ovom anotacijom se navodi vrednost diskriminatorske kolone koja vazi za 
// objekte ove klase
@DiscriminatorValue("CC")
public class CreditCard extends BillingDetails {

  @Column(name="cc_number")
  private String number;
  
  @Column(name="exp_month")
  private String expMonth;
  
  @Column(name="exp_year")
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
