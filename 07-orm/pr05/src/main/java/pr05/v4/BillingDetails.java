package pr05.v4;

import static javax.persistence.InheritanceType.JOINED;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@Entity
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
