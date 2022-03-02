package tw.gov.npa.il.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Iltb04InRecordDAO extends BaseHibernateDAO {
  private static final Logger log = LoggerFactory.getLogger(Iltb04InRecordDAO.class);
  
  public static final String IL_PTRLST = "ilPtrlst";
  
  public static final String IL_PTRLMRK = "ilPtrlmrk";
  
  public static final String IL_UID = "ilUid";
  
  public static final String IL_UNM = "ilUnm";
  
  public static final String IL_MANTYPE = "ilMantype";
  
  public void save(Iltb04InRecord transientInstance) {
    log.debug("saving Iltb04InRecord instance");
    try {
      getSession().save(transientInstance);
      log.debug("save successful");
    } catch (RuntimeException re) {
      log.error("save failed", re);
      throw re;
    } 
  }
  
  public void delete(Iltb04InRecord persistentInstance) {
    log.debug("deleting Iltb04InRecord instance");
    try {
      getSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    } 
  }
  
  public Iltb04InRecord findById(Iltb04InRecordId id) {
    log.debug("getting Iltb04InRecord instance with id: " + id);
    try {
      Iltb04InRecord instance = (Iltb04InRecord)getSession().get(
          "tw.gov.npa.il.dao.Iltb04InRecord", id);
      return instance;
    } catch (RuntimeException re) {
      log.error("get failed", re);
      throw re;
    } 
  }
  
  public List findByExample(Iltb04InRecord instance) {
    log.debug("finding Iltb04InRecord instance by example");
    try {
      List results = getSession()
        .createCriteria("tw.gov.npa.il.dao.Iltb04InRecord")
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
    log.debug("finding Iltb04InRecord instance with property: " + 
        propertyName + ", value: " + value);
    try {
      String queryString = "from Iltb04InRecord as model where model." + 
        propertyName + "= ?";
      Query queryObject = getSession().createQuery(queryString);
      queryObject.setParameter(0, value);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find by property name failed", re);
      throw re;
    } 
  }
  
  public List findByIlPtrlst(Object ilPtrlst) {
    return findByProperty("ilPtrlst", ilPtrlst);
  }
  
  public List findByIlPtrlmrk(Object ilPtrlmrk) {
    return findByProperty("ilPtrlmrk", ilPtrlmrk);
  }
  
  public List findByIlUid(Object ilUid) {
    return findByProperty("ilUid", ilUid);
  }
  
  public List findByIlUnm(Object ilUnm) {
    return findByProperty("ilUnm", ilUnm);
  }
  
  public List findByIlMantype(Object ilMantype) {
    return findByProperty("ilMantype", ilMantype);
  }
  
  public List findAll() {
    log.debug("finding all Iltb04InRecord instances");
    try {
      String queryString = "from Iltb04InRecord";
      Query queryObject = getSession().createQuery(queryString);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find all failed", re);
      throw re;
    } 
  }
  
  public Iltb04InRecord merge(Iltb04InRecord detachedInstance) {
    log.debug("merging Iltb04InRecord instance");
    try {
      Iltb04InRecord result = (Iltb04InRecord)getSession().merge(
          detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    } 
  }
  
  public void attachDirty(Iltb04InRecord instance) {
    log.debug("attaching dirty Iltb04InRecord instance");
    try {
      getSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
  
  public void attachClean(Iltb04InRecord instance) {
    log.debug("attaching clean Iltb04InRecord instance");
    try {
      getSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\Iltb04InRecordDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */