package pr01;

import java.io.Serializable;
import java.util.Date;

public class PurchaseOrder implements Serializable {

  private Integer id;
  
  private Date date; 
  
  public PurchaseOrder() {
    this.date = new Date();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  private static final long serialVersionUID = -3704140777060608278L;
}
