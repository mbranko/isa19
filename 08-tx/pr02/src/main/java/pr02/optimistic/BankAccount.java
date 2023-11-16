package pr02.optimistic;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity(name="BankAccountOpt")
@Table(name="bank_account_opt")
public class BankAccount {

  @Id
  @GeneratedValue(strategy=IDENTITY)
  @Column(name="acct_id", unique=true, nullable=false)
  private Integer id;
  
  @Column(name="acct_number", unique=true, nullable=false)
  private String number;
  
  @Column(name="balance", unique=false, nullable=false)
  private BigDecimal balance;
  
  @Version
  @Column(name="version", unique=false, nullable=false)
  private int version;

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

  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }
}
