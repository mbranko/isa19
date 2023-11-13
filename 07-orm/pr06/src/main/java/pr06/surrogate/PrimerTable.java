package pr06.surrogate;

import static jakarta.persistence.GenerationType.TABLE;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

/**
 * Ova klasa koristi TABLE tip generisanja vrednosti primarnog kljuca. U ovom
 * slucaju koristi se posebna tabela sa potencijalno vise brojaca iz koje se
 * brojevi zahvataju uz pesimisticko zakljucavanje.
 * 
 * Ovaj tip generisanja primarnog kljuca je prenosiv izmedju razlicitih baza
 * podataka, jer se ne oslanja na specificne funkcije pojedinacnih konkretnih
 * baza.
 */
@Entity
@Table(name="pr06_table")
public class PrimerTable {

  @Id
  @GeneratedValue(strategy=TABLE, generator="pr06_idtable")
  @TableGenerator(
      name="pr06_idtable", 
      table="p27_counters", 
      pkColumnName="counter_name", 
      pkColumnValue="primer", 
      valueColumnName="counter_value", 
      initialValue=1,
      allocationSize=1)
  @Column(name="id")
  private Integer id;
  
  @Column(name="name")
  private String name;

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
}