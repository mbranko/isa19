package pr01.session;

import pr01.entity.CreditCard;
import pr01.entity.PurchaseOrder;

public interface Purchase {
  
  public boolean processOrder(PurchaseOrder order, CreditCard card);

}
