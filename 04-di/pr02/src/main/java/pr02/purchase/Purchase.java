package pr02.purchase;

import pr02.model.Order;

public interface Purchase {
  public boolean processOrder(Order order);
}
