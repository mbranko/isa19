package pr06.surrogate;

import static jakarta.persistence.GenerationType.SEQUENCE;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * Ova klasa koristi SEQUENCE tip generisanja vrednosti primarnog kljuca. Ovaj
 * mehanizam je dostupan u Oracle, DB2, PostgreSQL, SAPDB i McKoi bazama (svaka 
 * koristi razlicitu SQL sintaksu prilikom definisanja seme baze). 
 *
 * Primer vezan za ovaj entity podrazumeva koriscenje Oracle baze (SQL skript
 * nece moci da se izvrsi na MySQL bazi).
 */
@Entity
@Table(name="pr06_sequence")
@SequenceGenerator(
    name="pr06_idseq", 
    sequenceName="pr06_gen", 
    initialValue=1, 
    allocationSize=1)
public class PrimerSequence {

  @Id
  @GeneratedValue(strategy=SEQUENCE, generator="pr06_idseq")
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
