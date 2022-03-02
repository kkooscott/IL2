package tw.gov.npa.il.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IlScheduleMngDAO extends BaseHibernateDAO {
  private static final Logger log = LoggerFactory.getLogger(IlScheduleMngDAO.class);
  
  public void save(IlScheduleMng transientInstance) {
    log.debug("saving IlScheduleMng instance");
    try {
      getSession().save(transientInstance);
      log.debug("save successful");
    } catch (RuntimeException re) {
      log.error("save failed", re);
      throw re;
    } 
  }
  
  public void delete(IlScheduleMng persistentInstance) {
    log.debug("deleting IlScheduleMng instance");
    try {
      getSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    } 
  }
  
  public IlScheduleMng findById(IlScheduleMngId id) {
    log.debug("getting IlScheduleMng instance with id: " + id);
    try {
      IlScheduleMng instance = (IlScheduleMng)getSession().get(
          "tw.gov.npa.il.dao.IlScheduleMng", id);
      return instance;
    } catch (RuntimeException re) {
      log.error("get failed", re);
      throw re;
    } 
  }
  
  public List findByExample(IlScheduleMng instance) {
    log.debug("finding IlScheduleMng instance by example");
    try {
      List results = getSession()
        .createCriteria("tw.gov.npa.il.dao.IlScheduleMng")
        .add((Criterion)Example.create(instance)).list();
      log.debug("find by example successful, result size: " + 
          results.size());
      return results;
    } catch (RuntimeException re) {
      log.error("find by example failed", re);
      throw re;
    } 
  }
  
  public List findByProperty(String propertyName, Object value) {
    log.debug("finding IlScheduleMng instance with property: " + 
        propertyName + ", value: " + value);
    try {
      String queryString = "from IlScheduleMng as model where model." + 
        propertyName + "= ?";
      Query queryObject = getSession().createQuery(queryString);
      queryObject.setParameter(0, value);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find by property name failed", re);
      throw re;
    } 
  }
  
  public List findAll() {
    log.debug("finding all IlScheduleMng instances");
    try {
      String queryString = "from IlScheduleMng";
      Query queryObject = getSession().createQuery(queryString);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find all failed", re);
      throw re;
    } 
  }
  
  public IlScheduleMng merge(IlScheduleMng detachedInstance) {
    log.debug("merging IlScheduleMng instance");
    try {
      IlScheduleMng result = (IlScheduleMng)getSession().merge(
          detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    } 
  }
  
  public void attachDirty(IlScheduleMng instance) {
    log.debug("attaching dirty IlScheduleMng instance");
    try {
      getSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
  
  public void attachClean(IlScheduleMng instance) {
    log.debug("attaching clean IlScheduleMng instance");
    try {
      getSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\IlScheduleMngDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */