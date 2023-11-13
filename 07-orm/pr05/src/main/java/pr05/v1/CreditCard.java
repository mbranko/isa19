package pr05.v1;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="CreditCard1")
@Table(name="v1_creditcard")
public class CreditCard extends BillingDetails {
  
  @Id
  @GeneratedValue(strategy=IDENTITY)
  @Column(name="id", unique=true, nullable=false)
  private Integer id;
  
  @Column(name="number", unique=false, nullable=false)
  private String number;
  
  @Column(name="exp_month", unique=false, nullable=false)
  private String expMonth;
  
  @Column(name="exp_year", unique=false, nullable=false)
  private String expYear;

  public CreditCard() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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
