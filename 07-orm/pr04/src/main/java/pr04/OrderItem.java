package pr04;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="order_items")
public class OrderItem implements Serializable {

  @Id
  @GeneratedValue(strategy=IDENTITY)
  @Column(name="item_id", unique=true, nullable=false)
  private Integer id;
  
  @Column(name="quantity", unique=false, nullable=false)
  private int quantity;
  
  @ManyToOne
  @JoinColumn(name="order_id", referencedColumnName="order_id", nullable=false)
  private PurchaseOrder order;
  
  @ManyToOne
  @JoinColumn(name="product_id", referencedColumnName="product_id", nullable=false)
  private Product product;
  
  public BigDecimal getSum() {
    return product.getPrice().multiply(new BigDecimal(quantity));
  }
  
  public OrderItem() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public PurchaseOrder getOrder() {
    return order;
  }

  public void setOrder(PurchaseOrder order) {
    this.order = order;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  private static final long serialVersionUID = 5860954691671951096L;
}
