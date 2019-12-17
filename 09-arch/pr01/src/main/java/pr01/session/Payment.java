package pr01.session;

import pr01.entity.CreditCard;

public interface Payment {

  public boolean processCreditCard(CreditCard card);
  
}
