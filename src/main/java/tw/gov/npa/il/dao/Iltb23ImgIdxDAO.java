package tw.gov.npa.il.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Iltb23ImgIdxDAO extends BaseHibernateDAO {
  private static final Logger log = LoggerFactory.getLogger(Iltb23ImgIdxDAO.class);
  
  public static final String IL_NAME = "ilName";
  
  public static final String IL_BTHDT = "ilBthdt";
  
  public static final String IL_UNC = "ilUnc";
  
  public static final String IL_URL = "ilUrl";
  
  public static final String IL_AP = "ilAp";
  
  public void save(Iltb23ImgIdx transientInstance) {
    log.debug("saving Iltb23ImgIdx instance");
    try {
      getSession().save(transientInstance);
      log.debug("save successful");
    } catch (RuntimeException re) {
      log.error("save failed", re);
      throw re;
    } 
  }
  
  public void delete(Iltb23ImgIdx persistentInstance) {
    log.debug("deleting Iltb23ImgIdx instance");
    try {
      getSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    } 
  }
  
  public Iltb23ImgIdx findById(Iltb23ImgIdxId id) {
    log.debug("getting Iltb23ImgIdx instance with id: " + id);
    try {
      Iltb23ImgIdx instance = (Iltb23ImgIdx)getSession().get("tw.gov.npa.il.dao.Iltb23ImgIdx", id);
      return instance;
    } catch (RuntimeException re) {
      log.error("get failed", re);
      throw re;
    } 
  }
  
  public List findByExample(Iltb23ImgIdx instance) {
    log.debug("finding Iltb23ImgIdx instance by example");
    try {
      List results = getSession().createCriteria("tw.gov.npa.il.dao.Iltb23ImgIdx").add((Criterion)Example.create(instance)).list();
      log.debug("find by example successful, result size: " + results.size());
      return results;
    } catch (RuntimeException re) {
      log.error("find by example failed", re);
      throw re;
    } 
  }
  
  public List findByProperty(String propertyName, Object value) {
    log.debug("finding Iltb23ImgIdx instance with property: " + propertyName + ", value: " + value);
    try {
      String queryString = "from Iltb23ImgIdx as model where model." + propertyName + "= ?";
      Query queryObject = getSession().createQuery(queryString);
      queryObject.setParameter(0, value);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find by property name failed", re);
      throw re;
    } 
  }
  
  public List findByIlName(Object ilName) {
    return findByProperty("ilName", ilName);
  }
  
  public List findByIlBthdt(Object ilBthdt) {
    return findByProperty("ilBthdt", ilBthdt);
  }
  
  public List findByIlUnc(Object ilUnc) {
    return findByProperty("ilUnc", ilUnc);
  }
  
  public List findByIlUrl(Object ilUrl) {
    return findByProperty("ilUrl", ilUrl);
  }
  
  public List findByIlAp(Object ilAp) {
    return findByProperty("ilAp", ilAp);
  }
  
  public List findAll() {
    log.debug("finding all Iltb23ImgIdx instances");
    try {
      String queryString = "from Iltb23ImgIdx";
      Query queryObject = getSession().createQuery(queryString);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find all failed", re);
      throw re;
    } 
  }
  
  public Iltb23ImgIdx merge(Iltb23ImgIdx detachedInstance) {
    log.debug("merging Iltb23ImgIdx instance");
    try {
      Iltb23ImgIdx result = (Iltb23ImgIdx)getSession().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    } 
  }
  
  public void attachDirty(Iltb23ImgIdx instance) {
    log.debug("attaching dirty Iltb23ImgIdx instance");
    try {
      getSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
  
  public void attachClean(Iltb23ImgIdx instance) {
    log.debug("attaching clean Iltb23ImgIdx instance");
    try {
      getSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\Iltb23ImgIdxDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */