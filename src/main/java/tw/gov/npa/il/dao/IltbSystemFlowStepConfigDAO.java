package tw.gov.npa.il.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IltbSystemFlowStepConfigDAO extends BaseHibernateDAO {
  private static final Logger log = LoggerFactory.getLogger(IltbSystemFlowStepConfigDAO.class);
  
  public static final String IL_STEPNAME = "ilStepname";
  
  public static final String IL_INDEXID = "ilIndexid";
  
  public static final String IL_STEPURL = "ilStepurl";
  
  public static final String IL_FUNCTAG = "ilFunctag";
  
  public static final String IL_LOADTITLE = "ilLoadtitle";
  
  public static final String IL_FUNC = "ilFunc";
  
  public static final String IL_FUNC_DISABLE = "ilFuncDisable";
  
  public static final String IL_MODUID = "ilModuid";
  
  public void save(IltbSystemFlowStepConfig transientInstance) {
    log.debug("saving IltbSystemFlowStepConfig instance");
    try {
      getSession().save(transientInstance);
      log.debug("save successful");
    } catch (RuntimeException re) {
      log.error("save failed", re);
      throw re;
    } 
  }
  
  public void delete(IltbSystemFlowStepConfig persistentInstance) {
    log.debug("deleting IltbSystemFlowStepConfig instance");
    try {
      getSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    } 
  }
  
  public IltbSystemFlowStepConfig findById(Integer id) {
    log.debug("getting IltbSystemFlowStepConfig instance with id: " + id);
    try {
      IltbSystemFlowStepConfig instance = (IltbSystemFlowStepConfig)getSession()
        .get("tw.gov.npa.il.dao.IltbSystemFlowStepConfig", id);
      return instance;
    } catch (RuntimeException re) {
      log.error("get failed", re);
      throw re;
    } 
  }
  
  public List findByExample(IltbSystemFlowStepConfig instance) {
    log.debug("finding IltbSystemFlowStepConfig instance by example");
    try {
      List results = getSession()
        .createCriteria(
          "tw.gov.npa.il.dao.IltbSystemFlowStepConfig")
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
    log.debug("finding IltbSystemFlowStepConfig instance with property: " + 
        propertyName + ", value: " + value);
    try {
      String queryString = "from IltbSystemFlowStepConfig as model where model." + 
        propertyName + "= ?";
      Query queryObject = getSession().createQuery(queryString);
      queryObject.setParameter(0, value);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find by property name failed", re);
      throw re;
    } 
  }
  
  public List findByIlStepname(Object ilStepname) {
    return findByProperty("ilStepname", ilStepname);
  }
  
  public List findByIlIndexid(Object ilIndexid) {
    return findByProperty("ilIndexid", ilIndexid);
  }
  
  public List findByIlStepurl(Object ilStepurl) {
    return findByProperty("ilStepurl", ilStepurl);
  }
  
  public List findByIlFunctag(Object ilFunctag) {
    return findByProperty("ilFunctag", ilFunctag);
  }
  
  public List findByIlLoadtitle(Object ilLoadtitle) {
    return findByProperty("ilLoadtitle", ilLoadtitle);
  }
  
  public List findByIlFunc(Object ilFunc) {
    return findByProperty("ilFunc", ilFunc);
  }
  
  public List findByIlFuncDisable(Object ilFuncDisable) {
    return findByProperty("ilFuncDisable", ilFuncDisable);
  }
  
  public List findByIlModuid(Object ilModuid) {
    return findByProperty("ilModuid", ilModuid);
  }
  
  public List findAll() {
    log.debug("finding all IltbSystemFlowStepConfig instances");
    try {
      String queryString = "from IltbSystemFlowStepConfig";
      Query queryObject = getSession().createQuery(queryString);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find all failed", re);
      throw re;
    } 
  }
  
  public IltbSystemFlowStepConfig merge(IltbSystemFlowStepConfig detachedInstance) {
    log.debug("merging IltbSystemFlowStepConfig instance");
    try {
      IltbSystemFlowStepConfig result = (IltbSystemFlowStepConfig)getSession()
        .merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    } 
  }
  
  public void attachDirty(IltbSystemFlowStepConfig instance) {
    log.debug("attaching dirty IltbSystemFlowStepConfig instance");
    try {
      getSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
  
  public void attachClean(IltbSystemFlowStepConfig instance) {
    log.debug("attaching clean IltbSystemFlowStepConfig instance");
    try {
      getSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\IltbSystemFlowStepConfigDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */