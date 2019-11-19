package pr05.v1;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="v1_bankaccount")
public class BankAccount extends BillingDetails {
  
  @Id
  @GeneratedValue(strategy=IDENTITY)
  @Column(name="id", unique=true, nullable=false)
  private Integer id;
  
  @Column(name="number", unique=false, nullable=false)
  private String number;
  
  @Column(name="bank_name", unique=false, nullable=false)
  private String bankName;
  
  @Column(name="swift", unique=false, nullable=false)
  private String swift;

  public BankAccount() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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
