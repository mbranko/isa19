package pr02.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
  
  private Date date;
  private CreditCard creditCard;
  private List<String> items;
  private List<Integer> quantities;

  public Order(CreditCard creditCard, Date date, List<String> items, List<Integer> quantities) {
    this.creditCard = creditCard;
    this.date = date;
    this.items = items;
    this.quantities = quantities;
  }
  public Order() {
  }

  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }
  public CreditCard getCreditCard() {
    return creditCard;
  }
  public void setCreditCard(CreditCard creditCard) {
    this.creditCard = creditCard;
  }
  public List<String> getItems() {
    return items;
  }
  public void setItems(List<String> items) {
    this.items = items;
  }
  public List<Integer> getQuantities() {
    return quantities;
  }
  public void setQuantities(List<Integer> quantities) {
    this.quantities = quantities;
  }

  private static final long serialVersionUID = -1501017917557352889L;
}
