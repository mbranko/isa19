package pr01.dao;

import pr01.entity.Product;

import java.util.List;

public interface ProductDao extends GenericDao<Product, Integer> {

  public List<Product> findProducts(int categoryId);
  
}
