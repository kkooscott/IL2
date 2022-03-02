package tw.gov.npa.il.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IltbFuncRoleDAO extends BaseHibernateDAO {
  private static final Logger log = LoggerFactory.getLogger(IltbFuncRoleDAO.class);
  
  public static final String IL_FUNC_NO = "ilFuncNo";
  
  public static final String IL_FUNC = "ilFunc";
  
  public static final String IL_FUNC_NM = "ilFuncNm";
  
  public static final String IL_ROLE_NO = "ilRoleNo";
  
  public static final String IL_ROLE = "ilRole";
  
  public static final String IL_ROLE_NM = "ilRoleNm";
  
  public static final String IL_ENABLE = "ilEnable";
  
  public static final String IL_MODUID = "ilModuid";
  
  public void save(IltbFuncRole transientInstance) {
    log.debug("saving IltbFuncRole instance");
    try {
      getSession().save(transientInstance);
      log.debug("save successful");
    } catch (RuntimeException re) {
      log.error("save failed", re);
      throw re;
    } 
  }
  
  public void delete(IltbFuncRole persistentInstance) {
    log.debug("deleting IltbFuncRole instance");
    try {
      getSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    } 
  }
  
  public IltbFuncRole findById(Integer id) {
    log.debug("getting IltbFuncRole instance with id: " + id);
    try {
      IltbFuncRole instance = (IltbFuncRole)getSession().get(
          "tw.gov.npa.il.dao.IltbFuncRole", id);
      return instance;
    } catch (RuntimeException re) {
      log.error("get failed", re);
      throw re;
    } 
  }
  
  public List findByExample(IltbFuncRole instance) {
    log.debug("finding IltbFuncRole instance by example");
    try {
      List results = getSession()
        .createCriteria("tw.gov.npa.il.dao.IltbFuncRole")
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
    log.debug("finding IltbFuncRole instance with property: " + 
        propertyName + ", value: " + value);
    try {
      String queryString = "from IltbFuncRole as model where model." + 
        propertyName + "= ?";
      Query queryObject = getSession().createQuery(queryString);
      queryObject.setParameter(0, value);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find by property name failed", re);
      throw re;
    } 
  }
  
  public List findByIlFuncNo(Object ilFuncNo) {
    return findByProperty("ilFuncNo", ilFuncNo);
  }
  
  public List findByIlFunc(Object ilFunc) {
    return findByProperty("ilFunc", ilFunc);
  }
  
  public List findByIlFuncNm(Object ilFuncNm) {
    return findByProperty("ilFuncNm", ilFuncNm);
  }
  
  public List findByIlRoleNo(Object ilRoleNo) {
    return findByProperty("ilRoleNo", ilRoleNo);
  }
  
  public List findByIlRole(Object ilRole) {
    return findByProperty("ilRole", ilRole);
  }
  
  public List findByIlRoleNm(Object ilRoleNm) {
    return findByProperty("ilRoleNm", ilRoleNm);
  }
  
  public List findByIlEnable(Object ilEnable) {
    return findByProperty("ilEnable", ilEnable);
  }
  
  public List findByIlModuid(Object ilModuid) {
    return findByProperty("ilModuid", ilModuid);
  }
  
  public List findAll() {
    log.debug("finding all IltbFuncRole instances");
    try {
      String queryString = "from IltbFuncRole";
      Query queryObject = getSession().createQuery(queryString);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find all failed", re);
      throw re;
    } 
  }
  
  public IltbFuncRole merge(IltbFuncRole detachedInstance) {
    log.debug("merging IltbFuncRole instance");
    try {
      IltbFuncRole result = (IltbFuncRole)getSession().merge(
          detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    } 
  }
  
  public void attachDirty(IltbFuncRole instance) {
    log.debug("attaching dirty IltbFuncRole instance");
    try {
      getSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
  
  public void attachClean(IltbFuncRole instance) {
    log.debug("attaching clean IltbFuncRole instance");
    try {
      getSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\IltbFuncRoleDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */