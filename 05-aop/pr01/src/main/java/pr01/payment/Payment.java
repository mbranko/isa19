package pr01.payment;

import pr01.model.CreditCard;

public interface Payment {
  public boolean processCreditCard(CreditCard card);
}