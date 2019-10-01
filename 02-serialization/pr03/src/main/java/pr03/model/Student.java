package pr03.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
  private String indeks;
  private String ime;
  private String prezime;
  private List<Ocena> ocene = new ArrayList<Ocena>();

  public Student() {
  }

  public Student(String indeks, String ime, String prezime) {
    this.indeks = indeks;
    this.ime = ime;
    this.prezime = prezime;
  }

  public String getIndeks() {
    return this.indeks;
  }

  public void setIndeks(String indeks) {
    this.indeks = indeks;
  }

  public String getIme() {
    return this.ime;
  }

  public void setIme(String ime) {
    this.ime = ime;
  }

  public String getPrezime() {
    return this.prezime;
  }

  public void setPrezime(String prezime) {
    this.prezime = prezime;
  }

  public Student indeks(String indeks) {
    this.indeks = indeks;
    return this;
  }

  public Student ime(String ime) {
    this.ime = ime;
    return this;
  }

  public Student prezime(String prezime) {
    this.prezime = prezime;
    return this;
  }

  public List<Ocena> getOcene() {
    return this.ocene;
  }

  public void setOcene(List<Ocena> ocene) {
    this.ocene = ocene;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(indeks, student.indeks) && Objects.equals(ime, student.ime) && Objects.equals(prezime, student.prezime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(indeks, ime, prezime);
  }

  @Override
  public String toString() {
    return "{" +
      " indeks='" + getIndeks() + "'" +
      ", ime='" + getIme() + "'" +
      ", prezime='" + getPrezime() + "'" +
      "}";
  }


  private static final long serialVersionUID = 1L;
}
