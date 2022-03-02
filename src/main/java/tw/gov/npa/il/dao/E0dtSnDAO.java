package tw.gov.npa.il.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class E0dtSnDAO extends BaseHibernateDAO {
  private static final Logger log = LoggerFactory.getLogger(E0dtSnDAO.class);
  
  public static final String E0_SVR_UNIT_CODE = "e0SvrUnitCode";
  
  public static final String E0_USERID = "e0Userid";
  
  public static final String E0_IP = "e0Ip";
  
  public static final String E0_INQ_RSLT = "e0InqRslt";
  
  public static final String E0_UPDATE_RSLT = "e0UpdateRslt";
  
  public static final String E0_USERID_UNIT_CODE = "e0UseridUnitCode";
  
  public static final String E0_USERID_DEPT_CODE = "e0UseridDeptCode";
  
  public static final String E0_USERID_BRANCH_CODE = "e0UseridBranchCode";
  
  public static final String E0_SYNC_FLAG = "e0SyncFlag";
  
  public void save(E0dtSn transientInstance) {
    log.debug("saving E0dtSn instance");
    try {
      getSession().save(transientInstance);
      log.debug("save successful");
    } catch (RuntimeException re) {
      log.error("save failed", re);
      throw re;
    } 
  }
  
  public void delete(E0dtSn persistentInstance) {
    log.debug("deleting E0dtSn instance");
    try {
      getSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    } 
  }
  
  public E0dtSn findById(E0dtSnId id) {
    log.debug("getting E0dtSn instance with id: " + id);
    try {
      E0dtSn instance = (E0dtSn)getSession().get(
          "tw.gov.npa.il.dao.E0dtSn", id);
      return instance;
    } catch (RuntimeException re) {
      log.error("get failed", re);
      throw re;
    } 
  }
  
  public List findByExample(E0dtSn instance) {
    log.debug("finding E0dtSn instance by example");
    try {
      List results = getSession()
        .createCriteria("tw.gov.npa.il.dao.E0dtSn")
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
    log.debug("finding E0dtSn instance with property: " + propertyName + 
        ", value: " + value);
    try {
      String queryString = "from E0dtSn as model where model." + 
        propertyName + "= ?";
      Query queryObject = getSession().createQuery(queryString);
      queryObject.setParameter(0, value);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find by property name failed", re);
      throw re;
    } 
  }
  
  public List findByE0SvrUnitCode(Object e0SvrUnitCode) {
    return findByProperty("e0SvrUnitCode", e0SvrUnitCode);
  }
  
  public List findByE0Userid(Object e0Userid) {
    return findByProperty("e0Userid", e0Userid);
  }
  
  public List findByE0Ip(Object e0Ip) {
    return findByProperty("e0Ip", e0Ip);
  }
  
  public List findByE0InqRslt(Object e0InqRslt) {
    return findByProperty("e0InqRslt", e0InqRslt);
  }
  
  public List findByE0UpdateRslt(Object e0UpdateRslt) {
    return findByProperty("e0UpdateRslt", e0UpdateRslt);
  }
  
  public List findByE0UseridUnitCode(Object e0UseridUnitCode) {
    return findByProperty("e0UseridUnitCode", e0UseridUnitCode);
  }
  
  public List findByE0UseridDeptCode(Object e0UseridDeptCode) {
    return findByProperty("e0UseridDeptCode", e0UseridDeptCode);
  }
  
  public List findByE0UseridBranchCode(Object e0UseridBranchCode) {
    return findByProperty("e0UseridBranchCode", e0UseridBranchCode);
  }
  
  public List findByE0SyncFlag(Object e0SyncFlag) {
    return findByProperty("e0SyncFlag", e0SyncFlag);
  }
  
  public List findAll() {
    log.debug("finding all E0dtSn instances");
    try {
      String queryString = "from E0dtSn";
      Query queryObject = getSession().createQuery(queryString);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find all failed", re);
      throw re;
    } 
  }
  
  public E0dtSn merge(E0dtSn detachedInstance) {
    log.debug("merging E0dtSn instance");
    try {
      E0dtSn result = (E0dtSn)getSession().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    } 
  }
  
  public void attachDirty(E0dtSn instance) {
    log.debug("attaching dirty E0dtSn instance");
    try {
      getSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
  
  public void attachClean(E0dtSn instance) {
    log.debug("attaching clean E0dtSn instance");
    try {
      getSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\E0dtSnDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */