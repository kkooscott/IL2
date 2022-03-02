package tw.gov.npa.il.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IltbRoleDAO extends BaseHibernateDAO {
  private static final Logger log = LoggerFactory.getLogger(IltbRoleDAO.class);
  
  public static final String IL_ROLE = "ilRole";
  
  public static final String IL_ROLE_NM = "ilRoleNm";
  
  public static final String IL_MODUID = "ilModuid";
  
  public void save(IltbRole transientInstance) {
    log.debug("saving IltbRole instance");
    try {
      getSession().save(transientInstance);
      log.debug("save successful");
    } catch (RuntimeException re) {
      log.error("save failed", re);
      throw re;
    } 
  }
  
  public void delete(IltbRole persistentInstance) {
    log.debug("deleting IltbRole instance");
    try {
      getSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    } 
  }
  
  public IltbRole findById(Integer id) {
    log.debug("getting IltbRole instance with id: " + id);
    try {
      IltbRole instance = (IltbRole)getSession().get(
          "tw.gov.npa.il.dao.IltbRole", id);
      return instance;
    } catch (RuntimeException re) {
      log.error("get failed", re);
      throw re;
    } 
  }
  
  public List findByExample(IltbRole instance) {
    log.debug("finding IltbRole instance by example");
    try {
      List results = getSession()
        .createCriteria("tw.gov.npa.il.dao.IltbRole")
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
    log.debug("finding IltbRole instance with property: " + propertyName + 
        ", value: " + value);
    try {
      String queryString = "from IltbRole as model where model." + 
        propertyName + "= ?";
      Query queryObject = getSession().createQuery(queryString);
      queryObject.setParameter(0, value);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find by property name failed", re);
      throw re;
    } 
  }
  
  public List findByIlRole(Object ilRole) {
    return findByProperty("ilRole", ilRole);
  }
  
  public List findByIlRoleNm(Object ilRoleNm) {
    return findByProperty("ilRoleNm", ilRoleNm);
  }
  
  public List findByIlModuid(Object ilModuid) {
    return findByProperty("ilModuid", ilModuid);
  }
  
  public List findAll() {
    log.debug("finding all IltbRole instances");
    try {
      String queryString = "from IltbRole";
      Query queryObject = getSession().createQuery(queryString);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find all failed", re);
      throw re;
    } 
  }
  
  public IltbRole merge(IltbRole detachedInstance) {
    log.debug("merging IltbRole instance");
    try {
      IltbRole result = (IltbRole)getSession().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    } 
  }
  
  public void attachDirty(IltbRole instance) {
    log.debug("attaching dirty IltbRole instance");
    try {
      getSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
  
  public void attachClean(IltbRole instance) {
    log.debug("attaching clean IltbRole instance");
    try {
      getSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\IltbRoleDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */