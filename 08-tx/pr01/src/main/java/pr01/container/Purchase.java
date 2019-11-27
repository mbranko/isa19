package pr01.container;

import pr01.CreditCard;
import pr01.PurchaseOrder;

public interface Purchase {
  
  public boolean processOrder(PurchaseOrder order, CreditCard card);

}
