package pr01.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class GenericDaoBean<T, ID extends Serializable> implements GenericDao<T, ID> {
  
  private Class<T> entityType;
  
  @PersistenceContext
  protected EntityManager em;
  
  @SuppressWarnings("unchecked")
  public GenericDaoBean() {
    entityType = (Class<T>)
      ((ParameterizedType)getClass().getGenericSuperclass())
        .getActualTypeArguments()[0];
  }

  public Class<T> getEntityType() {
    return entityType;
  }
  
  public T findById(ID id) {
    T entity;
    entity = em.find(entityType, id);
    return entity;
  }
  
  @SuppressWarnings("unchecked")
  public List<T> findAll() {
    Query q = em.createQuery("SELECT x FROM " + entityType.getSimpleName()+ " x");
    List<T> result = q.getResultList();
    return result;
  }
  
  @SuppressWarnings("unchecked")
  public List<T> findBy(String query) {
    Query q = em.createQuery(query);
    List<T> result = q.getResultList();
    return result;
  }
  
  public T persist(T entity) {
    em.persist(entity);
    return entity;
  }
  
  public T merge(T entity) {
    entity = em.merge(entity);
    return entity;
  }
  
  public void remove(T entity) {
    em.remove(entity);
  }
  
  public void flush() {
    em.flush();
  }
  
  public void clear() {
    em.clear();
  }
  
}
