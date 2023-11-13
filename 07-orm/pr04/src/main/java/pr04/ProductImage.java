package pr04;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="product_images")
public class ProductImage implements Serializable {

  @Id
  @GeneratedValue(strategy=IDENTITY)
  @Column(name="image_id", unique=true, nullable=false)
  private Integer id;
  
  @Column(name="image_title", unique=false, nullable=true)
  private String title;
  
  @Column(name="image_width", unique=false, nullable=false)
  private int width;
  
  @Column(name="image_height", unique=false, nullable=false)
  private int height;
  
  @Column(name="content_type", unique=false, nullable=false)
  private String contentType;
  
  @Lob
  @Basic(fetch=LAZY)
  @Column(name="image_data", unique=false, nullable=true)
  private byte[] imageData;
  
  @ManyToOne
  @JoinColumn(name="product_id", referencedColumnName="product_id", nullable=false)
  private Product product;
  
  public ProductImage() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public byte[] getImageData() {
    return imageData;
  }

  public void setImageData(byte[] imageData) {
    this.imageData = imageData;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  private static final long serialVersionUID = -1583467827576674112L;
}
