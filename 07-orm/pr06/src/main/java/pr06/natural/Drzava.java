package pr06.natural;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DRZAVA")
public class Drzava implements Serializable {

  @Id
  @Column(name="drz_sifra", unique=true, nullable=false, length=3)
  private String sifra;
  
  @Column(name="drz_naziv", unique=false, nullable=false, length=50)
  private String naziv;
  
  @OneToMany(cascade={ALL}, fetch=LAZY, mappedBy="drzava")
  private Set<NaseljenoMesto> naseljenaMesta = new HashSet<NaseljenoMesto>();

  public void add(NaseljenoMesto nm) {
    if (nm.getDrzava() != null)
      nm.getDrzava().getNaseljenaMesta().remove(nm);
    nm.setDrzava(this);
    getNaseljenaMesta().add(nm);
  }
  
  public void remove(NaseljenoMesto nm) {
    nm.setDrzava(null);
    getNaseljenaMesta().remove(nm);
  }
  
  public Drzava() {
  }

  public Drzava(String sifra, String naziv) {
    this.sifra = sifra;
    this.naziv = naziv;
  }

  public String getSifra() {
    return sifra;
  }

  public void setSifra(String sifra) {
    this.sifra = sifra;
  }

  public String getNaziv() {
    return naziv;
  }

  public void setNaziv(String naziv) {
    this.naziv = naziv;
  }

  public Set<NaseljenoMesto> getNaseljenaMesta() {
    return naseljenaMesta;
  }

  public void setNaseljenaMesta(Set<NaseljenoMesto> naseljenaMesta) {
    this.naseljenaMesta = naseljenaMesta;
  }

  @Override
  public String toString() {
    return "Drzava [sifra=" + sifra + ", naziv=" + naziv + "]";
  }
  
  private static final long serialVersionUID = -655325497754567545L;
}
