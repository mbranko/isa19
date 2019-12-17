package pr01.dao;

import pr01.entity.ProductImage;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(ProductImageDao.class)
public class ProductImageDaoBean extends GenericDaoBean<ProductImage, Integer> implements ProductImageDao {

}
