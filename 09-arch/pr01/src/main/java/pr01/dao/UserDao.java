package pr01.dao;

import pr01.entity.PurchaseOrder;
import pr01.entity.User;

public interface UserDao extends GenericDao<User, Integer> {

  public User login(String username, String password);
  public PurchaseOrder add(User user, PurchaseOrder order);

}
