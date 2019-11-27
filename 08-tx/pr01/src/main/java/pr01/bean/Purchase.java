package pr01.bean;

import pr01.CreditCard;
import pr01.PurchaseOrder;

public interface Purchase {
  
  public boolean processOrder(PurchaseOrder order, CreditCard card);

}
