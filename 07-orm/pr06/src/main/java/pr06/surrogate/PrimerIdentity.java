package pr06.surrogate;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Ova klasa koristi IDENTITY tip generisanja vrednosti primarnog kljuca.
 * Ovaj mehanizam je dostupan u MySQL, DB2, SQL Server, Sybase, i Hypersonic SQL
 * bazama (svaka koristi razlicitu SQL sintaksu prilikom definisanja seme baze).
 * 
 * Svi prethodni primeri koriste ovaj tip generisanja primarnog kljuca, i to za
 * MySQL bazu.
 */
@Entity
@Table(name="pr06_identity")
public class PrimerIdentity {

  @Id
  @GeneratedValue(strategy=IDENTITY)
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
