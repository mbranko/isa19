package pr04;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import static jakarta.persistence.TemporalType.TIMESTAMP;
import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="orders")
public class PurchaseOrder implements Serializable {

  @Id
  @GeneratedValue(strategy=IDENTITY)
  @Column(name="order_id", unique=true, nullable=false)
  private Integer id;
  
  @Temporal(TIMESTAMP)
  @Column(name="order_date", unique=false, nullable=false)
  private Date date; 
  
  @ManyToOne
  @JoinColumn(name="user_id", referencedColumnName="user_id", nullable=false)
  private User user;
  
  @OneToMany(cascade={ALL}, fetch=EAGER, mappedBy="order")
  private Set<OrderItem> items = new HashSet<OrderItem>();
  
  public BigDecimal getTotal() {
    BigDecimal total = new BigDecimal(0);
    for (OrderItem i: items)
      total = total.add(i.getSum());
    return total;
  }
  
  public void add(OrderItem item) {
    if (item.getOrder() != null)
      item.getOrder().getItems().remove(item);
    item.setOrder(this);
    getItems().add(item);
  }
  
  public PurchaseOrder() {
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

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Set<OrderItem> getItems() {
    return items;
  }

  public void setItems(Set<OrderItem> items) {
    this.items = items;
  }

  private static final long serialVersionUID = -5220201667149710925L;
}
