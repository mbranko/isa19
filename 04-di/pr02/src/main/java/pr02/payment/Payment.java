package pr02.payment;

import pr02.model.CreditCard;

public interface Payment {
  boolean processCreditCard(CreditCard card);
}