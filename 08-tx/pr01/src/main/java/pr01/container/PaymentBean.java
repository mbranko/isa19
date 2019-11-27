package pr01.container;

import pr01.CreditCard;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionManagement;

import static javax.ejb.TransactionAttributeType.REQUIRED;
import static javax.ejb.TransactionManagementType.CONTAINER;

@Stateless(name="PaymentContainer")
@Local(PaymentLocal.class)
@Remote(Payment.class)
@TransactionManagement(CONTAINER)
public class PaymentBean implements Payment {

  @Resource
  private SessionContext ctx;
  
  @TransactionAttribute(REQUIRED)
  //@TransactionAttribute(REQUIRES_NEW)
  //@TransactionAttribute(MANDATORY)
  //@TransactionAttribute(SUPPORTS)
  //@TransactionAttribute(NOT_SUPPORTED)
  //@TransactionAttribute(NEVER)
  public boolean processCreditCard(CreditCard card) throws MyException {
    if (somethingWentWrong()) {
      ctx.setRollbackOnly();
      return false;
    } else 
      return true;
  }
  
  private boolean somethingWentWrong() throws MyException {
    return Math.random() > 0.5;
  }
}
