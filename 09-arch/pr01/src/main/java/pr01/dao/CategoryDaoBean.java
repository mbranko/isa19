package pr01.dao;

import pr01.entity.Category;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
@Local(CategoryDao.class)
public class CategoryDaoBean extends GenericDaoBean<Category, Integer> implements CategoryDao {

  @SuppressWarnings("unchecked")
  public List<Category> findRoots() {
    Query q = em.createQuery("SELECT c FROM Category c WHERE c.parent IS NULL");
    List<Category> result = q.getResultList();
    return result;
  }
  
  public Category loadWithChildren(int categoryId) {
    Query q = em.createQuery("SELECT DISTINCT c FROM Category c LEFT JOIN FETCH c.children LEFT JOIN FETCH c.products WHERE c.id=:id");
    q.setParameter("id", categoryId);
    //Category c = em.find(Category.class, categoryId);
    //c.getProducts();
    //c.getChildren();
    Category result = (Category)q.getSingleResult();
    return result;
  }
}
