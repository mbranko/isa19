package pr06.natural;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="NASELJENOMESTO")
@IdClass(NaseljenoMestoPK.class)
public class NaseljenoMesto implements Serializable {

  @ManyToOne
  @Id
  @JoinColumn(name="drz_sifra", referencedColumnName="drz_sifra", nullable=false)
  private Drzava drzava;
  
  @Id
  @Column(name="nm_pttbroj", unique=true, nullable=false, length=5)
  private String pttBroj;
  
  @Column(name="nm_naziv", unique=false, nullable=false, length=50)
  private String naziv;
  
  @OneToMany(cascade={ALL}, fetch=LAZY, mappedBy="naseljenoMesto")
  private Set<MesnaZajednica> mesneZajednice = new HashSet<MesnaZajednica>();

  public void add(MesnaZajednica mz) {
    if (mz.getNaseljenoMesto() != null)
      mz.getNaseljenoMesto().getMesneZajednice().remove(mz);
    mz.setNaseljenoMesto(this);
    getMesneZajednice().add(mz);
  }
  
  public void remove(MesnaZajednica mz) {
    mz.setNaseljenoMesto(null);
    getMesneZajednice().remove(mz);
  }

  public NaseljenoMesto() {
  }

  public NaseljenoMesto(String pttBroj, String naziv) {
    this.pttBroj = pttBroj;
    this.naziv = naziv;
  }

  public Drzava getDrzava() {
    return drzava;
  }

  public void setDrzava(Drzava drzava) {
    this.drzava = drzava;
  }

  public String getPttBroj() {
    return pttBroj;
  }

  public void setPttBroj(String pttBroj) {
    this.pttBroj = pttBroj;
  }

  public String getNaziv() {
    return naziv;
  }

  public void setNaziv(String naziv) {
    this.naziv = naziv;
  }

  public Set<MesnaZajednica> getMesneZajednice() {
    return mesneZajednice;
  }

  public void setMesneZajednice(Set<MesnaZajednica> mesneZajednice) {
    this.mesneZajednice = mesneZajednice;
  }

  @Override
  public String toString() {
    return "NaseljenoMesto [drzava=" + drzava + ", pttBroj=" + pttBroj
        + ", naziv=" + naziv + "]";
  }

  private static final long serialVersionUID = 1981675936825251088L;
}
