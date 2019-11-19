package pr06.surrogate;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
