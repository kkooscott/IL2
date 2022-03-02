package tw.gov.npa.il.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Iltb17SchoolCodeDAO extends BaseHibernateDAO {
  private static final Logger log = LoggerFactory.getLogger(Iltb17SchoolCodeDAO.class);
  
  public static final String IL_UVCNM = "ilUvcnm";
  
  public static final String IL_UVCPNM = "ilUvcpnm";
  
  public static final String IL_UVPZONE = "ilUvpzone";
  
  public static final String IL_UVADDR = "ilUvaddr";
  
  public static final String IL_UVTEL = "ilUvtel";
  
  public void save(Iltb17SchoolCode transientInstance) {
    log.debug("saving Iltb17SchoolCode instance");
    try {
      getSession().save(transientInstance);
      log.debug("save successful");
    } catch (RuntimeException re) {
      log.error("save failed", re);
      throw re;
    } 
  }
  
  public void delete(Iltb17SchoolCode persistentInstance) {
    log.debug("deleting Iltb17SchoolCode instance");
    try {
      getSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    } 
  }
  
  public Iltb17SchoolCode findById(String id) {
    log.debug("getting Iltb17SchoolCode instance with id: " + id);
    try {
      Iltb17SchoolCode instance = (Iltb17SchoolCode)getSession().get(
          "tw.gov.npa.il.dao.Iltb17SchoolCode", id);
      return instance;
    } catch (RuntimeException re) {
      log.error("get failed", re);
      throw re;
    } 
  }
  
  public List findByExample(Iltb17SchoolCode instance) {
    log.debug("finding Iltb17SchoolCode instance by example");
    try {
      List results = getSession()
        .createCriteria("tw.gov.npa.il.dao.Iltb17SchoolCode")
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
    log.debug("finding Iltb17SchoolCode instance with property: " + 
        propertyName + ", value: " + value);
    try {
      String queryString = "from Iltb17SchoolCode as model where model." + 
        propertyName + "= ?";
      Query queryObject = getSession().createQuery(queryString);
      queryObject.setParameter(0, value);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find by property name failed", re);
      throw re;
    } 
  }
  
  public List findByIlUvcnm(Object ilUvcnm) {
    return findByProperty("ilUvcnm", ilUvcnm);
  }
  
  public List findByIlUvcpnm(Object ilUvcpnm) {
    return findByProperty("ilUvcpnm", ilUvcpnm);
  }
  
  public List findByIlUvpzone(Object ilUvpzone) {
    return findByProperty("ilUvpzone", ilUvpzone);
  }
  
  public List findByIlUvaddr(Object ilUvaddr) {
    return findByProperty("ilUvaddr", ilUvaddr);
  }
  
  public List findByIlUvtel(Object ilUvtel) {
    return findByProperty("ilUvtel", ilUvtel);
  }
  
  public List findAll() {
    log.debug("finding all Iltb17SchoolCode instances");
    try {
      String queryString = "from Iltb17SchoolCode";
      Query queryObject = getSession().createQuery(queryString);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find all failed", re);
      throw re;
    } 
  }
  
  public Iltb17SchoolCode merge(Iltb17SchoolCode detachedInstance) {
    log.debug("merging Iltb17SchoolCode instance");
    try {
      Iltb17SchoolCode result = (Iltb17SchoolCode)getSession().merge(
          detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    } 
  }
  
  public void attachDirty(Iltb17SchoolCode instance) {
    log.debug("attaching dirty Iltb17SchoolCode instance");
    try {
      getSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
  
  public void attachClean(Iltb17SchoolCode instance) {
    log.debug("attaching clean Iltb17SchoolCode instance");
    try {
      getSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\Iltb17SchoolCodeDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */