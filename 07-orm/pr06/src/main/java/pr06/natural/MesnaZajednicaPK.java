package pr06.natural;

import java.io.Serializable;

public class MesnaZajednicaPK implements Serializable {

  private String redniBroj;
  private NaseljenoMestoPK naseljenoMesto;
  
  public boolean equals(Object o) {
    if (o instanceof MesnaZajednicaPK) {
      MesnaZajednicaPK x = (MesnaZajednicaPK)o;
      return this.redniBroj.equals(x.redniBroj) && this.naseljenoMesto.equals(x.naseljenoMesto);
    } else
      return false;
  }
  
  public int hashCode() {
    return redniBroj.hashCode() + naseljenoMesto.hashCode();
  }

  public MesnaZajednicaPK(String redniBroj, NaseljenoMestoPK naseljenoMesto) {
    this.redniBroj = redniBroj;
    this.naseljenoMesto = naseljenoMesto;
  }

  public MesnaZajednicaPK() {
  }

  public String getRedniBroj() {
    return redniBroj;
  }

  public void setRedniBroj(String redniBroj) {
    this.redniBroj = redniBroj;
  }

  public NaseljenoMestoPK getNaseljenoMesto() {
    return naseljenoMesto;
  }

  public void setNaseljenoMesto(NaseljenoMestoPK naseljenoMesto) {
    this.naseljenoMesto = naseljenoMesto;
  }
  
  private static final long serialVersionUID = 8971191714268379062L;
}
