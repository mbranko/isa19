package pr03.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Date;

public class Ocena implements Serializable {

  private Integer id;
  private Student student;
  private Predmet predmet;
  private Date datumPolaganja;
  private int ocena;

  public Ocena() {
    this.id = getNewId();
  }

  public Ocena(Student student, Predmet predmet, Date datumPolaganja, int ocena) {
    this.id = getNewId();
    this.student = student;
    this.predmet = predmet;
    this.datumPolaganja = datumPolaganja;
    this.ocena = ocena;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Student getStudent() {
    return this.student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Predmet getPredmet() {
    return this.predmet;
  }

  public void setPredmet(Predmet predmet) {
    this.predmet = predmet;
  }

  public Date getDatumPolaganja() {
    return this.datumPolaganja;
  }

  public void setDatumPolaganja(Date datumPolaganja) {
    this.datumPolaganja = datumPolaganja;
  }

  public int getOcena() {
    return this.ocena;
  }

  public void setOcena(int ocena) {
    this.ocena = ocena;
  }

  public Ocena student(Student student) {
    this.student = student;
    return this;
  }

  public Ocena predmet(Predmet predmet) {
    this.predmet = predmet;
    return this;
  }

  public Ocena datumPolaganja(Date datumPolaganja) {
    this.datumPolaganja = datumPolaganja;
    return this;
  }

  public Ocena ocena(int ocena) {
    this.ocena = ocena;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Ocena)) {
      return false;
    }
    Ocena ocena = (Ocena) o;
    return Objects.equals(student, ocena.student) && Objects.equals(predmet, ocena.predmet) && Objects.equals(datumPolaganja, ocena.datumPolaganja) && this.ocena == ocena.ocena;
  }

  @Override
  public int hashCode() {
    return Objects.hash(student, predmet, datumPolaganja, ocena);
  }

  @Override
  public String toString() {
    return "{" +
      " student='" + getStudent() + "'" +
      ", predmet='" + getPredmet() + "'" +
      ", datumPolaganja='" + getDatumPolaganja() + "'" +
      ", ocena='" + getOcena() + "'" +
      "}";
  }

  private static int idMax = 1;

  private static int getNewId() {
    return idMax++;
  }

  private static final long serialVersionUID = 1L;
}