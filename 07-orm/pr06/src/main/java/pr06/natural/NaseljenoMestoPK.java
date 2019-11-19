package pr06.natural;

import java.io.Serializable;

public class NaseljenoMestoPK implements Serializable {

  private String pttBroj;
  private String drzava;
  
  public boolean equals(Object o) {
    if (o instanceof NaseljenoMestoPK) {
      NaseljenoMestoPK x = (NaseljenoMestoPK)o;
      return this.pttBroj.equals(x.pttBroj) && this.drzava.equals(x.drzava);
    } else
      return false;
  }
  
  public int hashCode() {
    return pttBroj.hashCode() + drzava.hashCode();
  }
  
  public NaseljenoMestoPK(String pttBroj, String drzava) {
    this.pttBroj = pttBroj;
    this.drzava = drzava;
  }

  public NaseljenoMestoPK() {
  }

  public String getPttBroj() {
    return pttBroj;
  }

  public void setPttBroj(String pttBroj) {
    this.pttBroj = pttBroj;
  }

  public String getDrzava() {
    return drzava;
  }

  public void setDrzava(String drzava) {
    this.drzava = drzava;
  }

  private static final long serialVersionUID = -917161929023430962L;
}
