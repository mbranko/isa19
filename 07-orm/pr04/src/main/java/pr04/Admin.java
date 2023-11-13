package pr04;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity                 // klasa je perzistentna
@Table(name="admins")   // mapira se na tabelu admins
public class Admin implements Serializable {

  @Id                                 // atribut je deo primarnog kljuca
  @GeneratedValue(strategy=IDENTITY)  // vrednost se generise automatski, u bazi
  @Column(name="admin_id", unique=true, nullable=false) 
  private Integer id;
  
  @Column(name="username", unique=false, nullable=false)
  private String username;
  
  @Column(name="pasword", unique=false, nullable=false)
  private String password;

  /**
   * Prazan konstruktor je obavezan, mogu se dodati i drugi
   */
  public Admin() {
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
  
  public String toString() {
    return "(Admin)[id="+id+",username="+username+",password="+password+"]";
  }

  private static final long serialVersionUID = 8311195509845733818L;
}
