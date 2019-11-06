package pr04;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="products")
public class Product implements Serializable {

  @Id
  @GeneratedValue(strategy=IDENTITY)
  @Column(name="product_id", unique=true, nullable=false)
  private Integer id;
  
  @Column(name="prod_name", unique=false, nullable=false)
  private String name;
  
  @Column(name="vendor", unique=false, nullable=false)
  private String vendor;
  
  @Column(name="description", unique=false, nullable=false)
  private String description;
  
  @Column(name="price", unique=false, nullable=false)
  private BigDecimal price;
  
  @ManyToOne
  @JoinColumn(name="category_id", referencedColumnName="category_id", nullable=false)
  private Category category;
  
  @ManyToOne
  @JoinColumn(name="supplier_id", referencedColumnName="supplier_id", nullable=false)
  private Supplier supplier;
  
  @OneToMany(cascade={ALL}, fetch=LAZY, mappedBy="product")
  private Set<OrderItem> orderItems = new HashSet<OrderItem>();
  
  @OneToMany(cascade={ALL}, fetch=LAZY, mappedBy="product")
  private Set<ProductImage> images = new HashSet<ProductImage>();
  
  public void add(OrderItem item) {
    if (item.getProduct() != null)
      item.getProduct().getOrderItems().remove(item);
    item.setProduct(this);
    getOrderItems().add(item);
  }
  
  public void add(ProductImage image) {
    if (image.getProduct() != null)
      image.getProduct().getImages().remove(image);
    image.setProduct(this);
    getImages().add(image);
  }
  
  public Product() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getVendor() {
    return vendor;
  }

  public void setVendor(String vendor) {
    this.vendor = vendor;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Supplier getSupplier() {
    return supplier;
  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }

  public Set<OrderItem> getOrderItems() {
    return orderItems;
  }

  public void setOrderItems(Set<OrderItem> orderItems) {
    this.orderItems = orderItems;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }
  
  public Set<ProductImage> getImages() {
    return images;
  }

  public void setImages(Set<ProductImage> images) {
    this.images = images;
  }

  public String toString() {
    return "(Product)[id="+id+",name="+name+",vendor="+vendor+",description="+description+",price="+price+"]";
  }

  private static final long serialVersionUID = -2072305515982921869L;
}
