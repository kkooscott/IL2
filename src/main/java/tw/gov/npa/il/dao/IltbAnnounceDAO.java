package tw.gov.npa.il.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IltbAnnounceDAO extends BaseHibernateDAO {
  private static final Logger log = LoggerFactory.getLogger(IltbAnnounceDAO.class);
  
  public static final String IL_KIND = "ilKind";
  
  public static final String IL_CONTENT = "ilContent";
  
  public static final String IL_BEGIN_DT = "ilBeginDt";
  
  public static final String IL_BEGIN_TM = "ilBeginTm";
  
  public static final String IL_END_DT = "ilEndDt";
  
  public static final String IL_END_TM = "ilEndTm";
  
  public static final String IL_ANN_UID = "ilAnnUid";
  
  public static final String IL_ANN_UNM = "ilAnnUnm";
  
  public static final String IL_ANN_DT = "ilAnnDt";
  
  public static final String IL_ANN_TM = "ilAnnTm";
  
  public void save(IltbAnnounce transientInstance) {
    log.debug("saving IltbAnnounce instance");
    try {
      getSession().save(transientInstance);
      log.debug("save successful");
    } catch (RuntimeException re) {
      log.error("save failed", re);
      throw re;
    } 
  }
  
  public void delete(IltbAnnounce persistentInstance) {
    log.debug("deleting IltbAnnounce instance");
    try {
      getSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    } 
  }
  
  public IltbAnnounce findById(Integer id) {
    log.debug("getting IltbAnnounce instance with id: " + id);
    try {
      IltbAnnounce instance = (IltbAnnounce)getSession().get(
          "tw.gov.npa.il.dao.IltbAnnounce", id);
      return instance;
    } catch (RuntimeException re) {
      log.error("get failed", re);
      throw re;
    } 
  }
  
  public List findByExample(IltbAnnounce instance) {
    log.debug("finding IltbAnnounce instance by example");
    try {
      List results = getSession()
        .createCriteria("tw.gov.npa.il.dao.IltbAnnounce")
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
    log.debug("finding IltbAnnounce instance with property: " + 
        propertyName + ", value: " + value);
    try {
      String queryString = "from IltbAnnounce as model where model." + 
        propertyName + "= ?";
      Query queryObject = getSession().createQuery(queryString);
      queryObject.setParameter(0, value);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find by property name failed", re);
      throw re;
    } 
  }
  
  public List findByIlKind(Object ilKind) {
    return findByProperty("ilKind", ilKind);
  }
  
  public List findByIlContent(Object ilContent) {
    return findByProperty("ilContent", ilContent);
  }
  
  public List findByIlBeginDt(Object ilBeginDt) {
    return findByProperty("ilBeginDt", ilBeginDt);
  }
  
  public List findByIlBeginTm(Object ilBeginTm) {
    return findByProperty("ilBeginTm", ilBeginTm);
  }
  
  public List findByIlEndDt(Object ilEndDt) {
    return findByProperty("ilEndDt", ilEndDt);
  }
  
  public List findByIlEndTm(Object ilEndTm) {
    return findByProperty("ilEndTm", ilEndTm);
  }
  
  public List findByIlAnnUid(Object ilAnnUid) {
    return findByProperty("ilAnnUid", ilAnnUid);
  }
  
  public List findByIlAnnUnm(Object ilAnnUnm) {
    return findByProperty("ilAnnUnm", ilAnnUnm);
  }
  
  public List findByIlAnnDt(Object ilAnnDt) {
    return findByProperty("ilAnnDt", ilAnnDt);
  }
  
  public List findByIlAnnTm(Object ilAnnTm) {
    return findByProperty("ilAnnTm", ilAnnTm);
  }
  
  public List findAll() {
    log.debug("finding all IltbAnnounce instances");
    try {
      String queryString = "from IltbAnnounce";
      Query queryObject = getSession().createQuery(queryString);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find all failed", re);
      throw re;
    } 
  }
  
  public IltbAnnounce merge(IltbAnnounce detachedInstance) {
    log.debug("merging IltbAnnounce instance");
    try {
      IltbAnnounce result = (IltbAnnounce)getSession().merge(
          detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    } 
  }
  
  public void attachDirty(IltbAnnounce instance) {
    log.debug("attaching dirty IltbAnnounce instance");
    try {
      getSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
  
  public void attachClean(IltbAnnounce instance) {
    log.debug("attaching clean IltbAnnounce instance");
    try {
      getSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\IltbAnnounceDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */