package pr02.pessimistic;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="bank_account_pes")
public class BankAccount {

  @Id
  @GeneratedValue(strategy=IDENTITY)
  @Column(name="acct_id", unique=true, nullable=false)
  private Integer id;
  
  @Column(name="acct_number", unique=true, nullable=false)
  private String number;
  
  @Column(name="balance", unique=false, nullable=false)
  private BigDecimal balance;
  
  public void withdraw(BigDecimal amount) {
    setBalance(balance.subtract(amount));
  }
  
  public void deposit(BigDecimal amount) {
    setBalance(balance.add(amount));
  }
  
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

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

}
