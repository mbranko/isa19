package pr05.v4;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="v4_bankaccount")
public class BankAccount extends BillingDetails {

  @Column(name="number", unique=false, nullable=false)
  private String number;
  
  @Column(name="bank_name", unique=false, nullable=false)
  private String bankName;
  
  @Column(name="swift", unique=false, nullable=false)
  private String swift;

  public BankAccount() {
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public String getSwift() {
    return swift;
  }

  public void setSwift(String swift) {
    this.swift = swift;
  }
}
