package pr05.v1;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

// ova klasa nije entity (ne mapira se na tabelu u bazi) ali njeni propertiji
// ce biti nasledjeni u entity klasama - otuda je potrebna ova anotacija
@MappedSuperclass
public abstract class BillingDetails {
  
  // ovaj properti ce biti nasledjen
  @Column(name="owner", unique=false, nullable=false)
  protected String owner;

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  } 
}
