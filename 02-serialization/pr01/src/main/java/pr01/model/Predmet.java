package pr01.model;

import java.io.Serializable;
import java.util.Objects;

public class Predmet implements Serializable {
  private String sifra;
  private String naziv;

  public Predmet() { }
  
  public Predmet(String sifra, String naziv) {
    this.sifra = sifra;
    this.naziv = naziv;
  }

  public String getSifra() {
    return this.sifra;
  }

  public void setSifra(String sifra) {
    this.sifra = sifra;
  }

  public String getNaziv() {
    return this.naziv;
  }

  public void setNaziv(String naziv) {
    this.naziv = naziv;
  }

  public Predmet sifra(String sifra) {
    this.sifra = sifra;
    return this;
  }

  public Predmet naziv(String naziv) {
    this.naziv = naziv;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Predmet)) {
      return false;
    }
    Predmet predmet = (Predmet) o;
    return Objects.equals(sifra, predmet.sifra) && Objects.equals(naziv, predmet.naziv);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sifra, naziv);
  }

  @Override
  public String toString() {
    return "{" +
      " sifra='" + getSifra() + "'" +
      ", naziv='" + getNaziv() + "'" +
      "}";
  }

  private static final long serialVersionUID = 1L;
}