package pr01.dao;

import pr01.entity.Supplier;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(SupplierDao.class)
public class SupplierDaoBean extends GenericDaoBean<Supplier, Integer> implements SupplierDao {

}
