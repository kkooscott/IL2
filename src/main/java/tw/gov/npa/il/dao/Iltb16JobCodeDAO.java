package tw.gov.npa.il.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Iltb16JobCodeDAO extends BaseHibernateDAO {
  private static final Logger log = LoggerFactory.getLogger(Iltb16JobCodeDAO.class);
  
  public static final String IL_OPNM = "ilOpnm";
  
  public static final String IL_OPPRSQ = "ilOpprsq";
  
  public static final String IL_OPCS = "ilOpcs";
  
  public void save(Iltb16JobCode transientInstance) {
    log.debug("saving Iltb16JobCode instance");
    try {
      getSession().save(transientInstance);
      log.debug("save successful");
    } catch (RuntimeException re) {
      log.error("save failed", re);
      throw re;
    } 
  }
  
  public void delete(Iltb16JobCode persistentInstance) {
    log.debug("deleting Iltb16JobCode instance");
    try {
      getSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    } 
  }
  
  public Iltb16JobCode findById(String id) {
    log.info("getting Iltb16JobCode instance with id: " + id);
    try {
      Iltb16JobCode instance = (Iltb16JobCode)getSession().get("tw.gov.npa.il.dao.Iltb16JobCode", id);
      return instance;
    } catch (RuntimeException re) {
      log.error("get failed", re);
      throw re;
    } 
  }
  
  public List findByExample(Iltb16JobCode instance) {
    log.debug("finding Iltb16JobCode instance by example");
    try {
      List results = getSession().createCriteria("tw.gov.npa.il.dao.Iltb16JobCode").add((Criterion)Example.create(instance)).list();
      log.debug("find by example successful, result size: " + results.size());
      return results;
    } catch (RuntimeException re) {
      log.error("find by example failed", re);
      throw re;
    } 
  }
  
  public List findByProperty(String propertyName, Object value) {
    log.debug("finding Iltb16JobCode instance with property: " + propertyName + ", value: " + value);
    try {
      String queryString = "from Iltb16JobCode as model where model." + propertyName + "= ?";
      Query queryObject = getSession().createQuery(queryString);
      queryObject.setParameter(0, value);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find by property name failed", re);
      throw re;
    } 
  }
  
  public List findByIlOpnm(Object ilOpnm) {
    return findByProperty("ilOpnm", ilOpnm);
  }
  
  public List findByIlOpprsq(Object ilOpprsq) {
    return findByProperty("ilOpprsq", ilOpprsq);
  }
  
  public List findByIlOpcs(Object ilOpcs) {
    return findByProperty("ilOpcs", ilOpcs);
  }
  
  public List findAll() {
    log.debug("finding all Iltb16JobCode instances");
    try {
      String queryString = "from Iltb16JobCode";
      Query queryObject = getSession().createQuery(queryString);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find all failed", re);
      throw re;
    } 
  }
  
  public Iltb16JobCode merge(Iltb16JobCode detachedInstance) {
    log.debug("merging Iltb16JobCode instance");
    try {
      Iltb16JobCode result = (Iltb16JobCode)getSession().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    } 
  }
  
  public void attachDirty(Iltb16JobCode instance) {
    log.debug("attaching dirty Iltb16JobCode instance");
    try {
      getSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
  
  public void attachClean(Iltb16JobCode instance) {
    log.debug("attaching clean Iltb16JobCode instance");
    try {
      getSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\Iltb16JobCodeDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */