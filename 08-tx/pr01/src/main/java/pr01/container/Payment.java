package pr01.container;

import pr01.CreditCard;

public interface Payment {

  public boolean processCreditCard(CreditCard card) throws MyException;
  
}
