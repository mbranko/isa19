package pr05.v4;

import static jakarta.persistence.InheritanceType.JOINED;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;

@Entity(name="BillingDetails4")
@Table(name="v4_billingdetails")
// ovom anotacijom se naglasava mapiranje tipa "jedna tabela po svakoj klasi"
@Inheritance(strategy=JOINED)
public class BillingDetails {
  
  @Id
  @GeneratedValue
  @Column(name="id", unique=true, nullable=false)
  private Integer id;
  
  @Column(name="owner", nullable=false)
  private String owner;
  
  public BillingDetails() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

}
