package pr01.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@Entity
@Table(name="users")
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy=IDENTITY)
  @Column(name="user_id", unique=true, nullable=false)
  private Integer id;
  
  @Column(name="username", unique=false, nullable=false)
  private String username;
  
  @Column(name="pasword", unique=false, nullable=false)
  private String password;
  
  @Column(name="first_name", unique=false, nullable=false)
  private String firstName;
  
  @Column(name="last_name", unique=false, nullable=false)
  private String lastName;
  
  @Column(name="user_address", unique=false, nullable=false)
  private String address;
  
  @Column(name="email", unique=false, nullable=false)
  private String email;
  
  @Column(name="receive_news", unique=false, nullable=false)
  private boolean receiveNews;
  
  @JsonManagedReference("user-order")
  @OneToMany(cascade={ALL}, fetch=LAZY, mappedBy="user")
  private Set<PurchaseOrder> orders = new HashSet<PurchaseOrder>();

  public void add(PurchaseOrder order) {
    if (order.getUser() != null)
      order.getUser().getOrders().remove(order);
    order.setUser(this);
    getOrders().add(order);
  }
  
  public User() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean isReceiveNews() {
    return receiveNews;
  }

  public void setReceiveNews(boolean receiveNews) {
    this.receiveNews = receiveNews;
  }

  public Set<PurchaseOrder> getOrders() {
    return orders;
  }

  public void setOrders(Set<PurchaseOrder> orders) {
    this.orders = orders;
  }
  
  private static final long serialVersionUID = -5303448656679186126L;
}
