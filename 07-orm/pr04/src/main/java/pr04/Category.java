package pr04;

import java.io.Serializable;
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
@Table(name="categories")
public class Category implements Serializable {

  @Id
  @GeneratedValue(strategy=IDENTITY)
  @Column(name="category_id", unique=true, nullable=false)
  private Integer id;
  
  @Column(name="cat_name", unique=false, nullable=false)
  private String name;
  
  @Column(name="cat_desc", unique=false, nullable=true)
  private String description;

  @ManyToOne
  @JoinColumn(name="parent_cat_id", referencedColumnName="category_id", nullable=true)
  private Category parent;
  
  @OneToMany(cascade={ALL}, fetch=LAZY, mappedBy="parent")
  private Set<Category> children = new HashSet<Category>();
  
  @OneToMany(cascade={ALL}, fetch=LAZY, mappedBy="category")
  private Set<Product> products = new HashSet<Product>();
  
  public void add(Category c) {
    if (c.getParent() != null)
      c.getParent().getChildren().remove(c);
    c.setParent(this);
    getChildren().add(c);
  }
  
  public void add(Product p) {
    if (p.getCategory() != null)
      p.getCategory().getProducts().remove(p);
    p.setCategory(this);
    getProducts().add(p);
  }
  
  public void remove(Category c) {
    c.setParent(null);
    getChildren().remove(c);
  }
  
  public void remove(Product p) {
    p.setCategory(null);
    getProducts().remove(p);
  }
  
  public Category() {
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Category getParent() {
    return parent;
  }

  public void setParent(Category parent) {
    this.parent = parent;
  }

  public Set<Category> getChildren() {
    return children;
  }

  public void setChildren(Set<Category> children) {
    this.children = children;
  }

  public Set<Product> getProducts() {
    return products;
  }

  public void setProducts(Set<Product> products) {
    this.products = products;
  }
  
  public String toString() {
    return "(Category)[id="+id+",name="+name+",description="+description+"]";
  }
  
  private static final long serialVersionUID = 5969496673973694792L;
}
