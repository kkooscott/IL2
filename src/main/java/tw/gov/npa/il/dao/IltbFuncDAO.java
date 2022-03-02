package tw.gov.npa.il.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IltbFuncDAO extends BaseHibernateDAO {
  private static final Logger log = LoggerFactory.getLogger(IltbFuncDAO.class);
  
  public static final String IL_FUNC = "ilFunc";
  
  public static final String IL_FUNC_NM = "ilFuncNm";
  
  public static final String IL_FUNC_URL = "ilFuncUrl";
  
  public static final String IL_FUNC_GROUP = "ilFuncGroup";
  
  public static final String IL_FUNC_DISABLE = "ilFuncDisable";
  
  public static final String IL_MODUID = "ilModuid";
  
  public void save(IltbFunc transientInstance) {
    log.debug("saving IltbFunc instance");
    try {
      getSession().save(transientInstance);
      log.debug("save successful");
    } catch (RuntimeException re) {
      log.error("save failed", re);
      throw re;
    } 
  }
  
  public void delete(IltbFunc persistentInstance) {
    log.debug("deleting IltbFunc instance");
    try {
      getSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    } 
  }
  
  public IltbFunc findById(Integer id) {
    log.debug("getting IltbFunc instance with id: " + id);
    try {
      IltbFunc instance = (IltbFunc)getSession().get(
          "tw.gov.npa.il.dao.IltbFunc", id);
      return instance;
    } catch (RuntimeException re) {
      log.error("get failed", re);
      throw re;
    } 
  }
  
  public List findByExample(IltbFunc instance) {
    log.debug("finding IltbFunc instance by example");
    try {
      List results = getSession()
        .createCriteria("tw.gov.npa.il.dao.IltbFunc")
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
    log.debug("finding IltbFunc instance with property: " + propertyName + 
        ", value: " + value);
    try {
      String queryString = "from IltbFunc as model where model." + 
        propertyName + "= ?";
      Query queryObject = getSession().createQuery(queryString);
      queryObject.setParameter(0, value);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find by property name failed", re);
      throw re;
    } 
  }
  
  public List findByIlFunc(Object ilFunc) {
    return findByProperty("ilFunc", ilFunc);
  }
  
  public List findByIlFuncNm(Object ilFuncNm) {
    return findByProperty("ilFuncNm", ilFuncNm);
  }
  
  public List findByIlFuncUrl(Object ilFuncUrl) {
    return findByProperty("ilFuncUrl", ilFuncUrl);
  }
  
  public List findByIlFuncGroup(Object ilFuncGroup) {
    return findByProperty("ilFuncGroup", ilFuncGroup);
  }
  
  public List findByIlFuncDisable(Object ilFuncDisable) {
    return findByProperty("ilFuncDisable", ilFuncDisable);
  }
  
  public List findByIlModuid(Object ilModuid) {
    return findByProperty("ilModuid", ilModuid);
  }
  
  public List findAll() {
    log.debug("finding all IltbFunc instances");
    try {
      String queryString = "from IltbFunc";
      Query queryObject = getSession().createQuery(queryString);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find all failed", re);
      throw re;
    } 
  }
  
  public IltbFunc merge(IltbFunc detachedInstance) {
    log.debug("merging IltbFunc instance");
    try {
      IltbFunc result = (IltbFunc)getSession().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    } 
  }
  
  public void attachDirty(IltbFunc instance) {
    log.debug("attaching dirty IltbFunc instance");
    try {
      getSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
  
  public void attachClean(IltbFunc instance) {
    log.debug("attaching clean IltbFunc instance");
    try {
      getSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\IltbFuncDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */