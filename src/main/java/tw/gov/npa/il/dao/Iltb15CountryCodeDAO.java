package tw.gov.npa.il.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Iltb15CountryCodeDAO extends BaseHibernateDAO {
  private static final Logger log = LoggerFactory.getLogger(Iltb15CountryCodeDAO.class);
  
  public static final String IL_NTNM = "ilNtnm";
  
  public static final String IL_NTLBR = "ilNtlbr";
  
  public static final String IL_NTPRSQ = "ilNtprsq";
  
  public void save(Iltb15CountryCode transientInstance) {
    log.debug("saving Iltb15CountryCode instance");
    try {
      getSession().save(transientInstance);
      log.debug("save successful");
    } catch (RuntimeException re) {
      log.error("save failed", re);
      throw re;
    } 
  }
  
  public void delete(Iltb15CountryCode persistentInstance) {
    log.debug("deleting Iltb15CountryCode instance");
    try {
      getSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    } 
  }
  
  public Iltb15CountryCode findById(String id) {
    log.debug("getting Iltb15CountryCode instance with id: " + id);
    try {
      Iltb15CountryCode instance = (Iltb15CountryCode)getSession().get("tw.gov.npa.il.dao.Iltb15CountryCode", id);
      return instance;
    } catch (RuntimeException re) {
      log.error("get failed", re);
      throw re;
    } 
  }
  
  public List findByExample(Iltb15CountryCode instance) {
    log.debug("finding Iltb15CountryCode instance by example");
    try {
      List results = getSession().createCriteria("tw.gov.npa.il.dao.Iltb15CountryCode").add((Criterion)Example.create(instance)).list();
      log.debug("find by example successful, result size: " + results.size());
      return results;
    } catch (RuntimeException re) {
      log.error("find by example failed", re);
      throw re;
    } 
  }
  
  public List findByProperty(String propertyName, Object value) {
    log.debug("finding Iltb15CountryCode instance with property: " + propertyName + ", value: " + value);
    try {
      String queryString = "from Iltb15CountryCode as model where model." + propertyName + "= ?";
      Query queryObject = getSession().createQuery(queryString);
      queryObject.setParameter(0, value);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find by property name failed", re);
      throw re;
    } 
  }
  
  public List findByIlNtnm(Object ilNtnm) {
    return findByProperty("ilNtnm", ilNtnm);
  }
  
  public List findByIlNtlbr(Object ilNtlbr) {
    return findByProperty("ilNtlbr", ilNtlbr);
  }
  
  public List findByIlNtprsq(Object ilNtprsq) {
    return findByProperty("ilNtprsq", ilNtprsq);
  }
  
  public Iltb15CountryCode findByIlNtcd(Object ilNtcd) {
    Iltb15CountryCode back = null;
    List<Iltb15CountryCode> result = findByProperty("ilNtcd", ilNtcd);
    if (result != null && result.size() == 1)
      back = result.get(0); 
    return back;
  }
  
  public List findAll() {
    log.debug("finding all Iltb15CountryCode instances");
    try {
      String queryString = "from Iltb15CountryCode order by ilNtcd asc";
      Query queryObject = getSession().createQuery(queryString);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find all failed", re);
      throw re;
    } 
  }
  
  public Iltb15CountryCode merge(Iltb15CountryCode detachedInstance) {
    log.debug("merging Iltb15CountryCode instance");
    try {
      Iltb15CountryCode result = (Iltb15CountryCode)getSession().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    } 
  }
  
  public void attachDirty(Iltb15CountryCode instance) {
    log.debug("attaching dirty Iltb15CountryCode instance");
    try {
      getSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
  
  public void attachClean(Iltb15CountryCode instance) {
    log.debug("attaching clean Iltb15CountryCode instance");
    try {
      getSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\Iltb15CountryCodeDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */