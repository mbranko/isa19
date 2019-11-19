package pr05.v2;

import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;

@Entity
// ovom anotacijom se naglasava da je ova klasa koren hijerarhije koja koristi
// koncept jedna tabela po konkretnoj klasi
@Inheritance(strategy=TABLE_PER_CLASS)
public abstract class BillingDetails {
  
  @Id
  @GeneratedValue
  @Column(name="id", unique=true, nullable=false)
  private Integer id;
  
  @Column(name="owner", unique=false, nullable=false)
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
