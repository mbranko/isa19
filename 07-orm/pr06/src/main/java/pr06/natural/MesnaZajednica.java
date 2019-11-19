package pr06.natural;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MESNAZAJEDNICA")
@IdClass(MesnaZajednicaPK.class)
public class MesnaZajednica implements Serializable {

  @Id
  @Column(name="mz_redbroj", unique=true, nullable=false, length=5)
  private String redniBroj;
  
  @ManyToOne
  @Id
  @JoinColumns({
    @JoinColumn(name="nm_pttbroj", referencedColumnName="nm_pttbroj", nullable=false),
    @JoinColumn(name="drz_sifra", referencedColumnName="drz_sifra", nullable=false)})
  private NaseljenoMesto naseljenoMesto;
  
  @Column(name="mz_naziv", unique=true, nullable=false, length=50)
  private String naziv;
  
  public MesnaZajednica(String redniBroj, String naziv) {
    this.redniBroj = redniBroj;
    this.naziv = naziv;
  }

  public MesnaZajednica() {
  }

  public String getRedniBroj() {
    return redniBroj;
  }

  public void setRedniBroj(String redniBroj) {
    this.redniBroj = redniBroj;
  }

  public NaseljenoMesto getNaseljenoMesto() {
    return naseljenoMesto;
  }

  public void setNaseljenoMesto(NaseljenoMesto naseljenoMesto) {
    this.naseljenoMesto = naseljenoMesto;
  }

  public String getNaziv() {
    return naziv;
  }

  public void setNaziv(String naziv) {
    this.naziv = naziv;
  }

  @Override
  public String toString() {
    return "MesnaZajednica [redniBroj=" + redniBroj + ", naseljenoMesto="
        + naseljenoMesto + ", naziv=" + naziv + "]";
  }

  private static final long serialVersionUID = -8435959221660198218L;
}
