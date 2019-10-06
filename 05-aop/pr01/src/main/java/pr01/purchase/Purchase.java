package pr01.purchase;

import pr01.model.Order;

public interface Purchase {
  public boolean processOrder(Order order);
}
