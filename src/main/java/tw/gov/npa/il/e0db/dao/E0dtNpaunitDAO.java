package tw.gov.npa.il.e0db.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class E0dtNpaunitDAO extends BaseHibernateDAO {
  private static final Logger log = LoggerFactory.getLogger(E0dtNpaunitDAO.class);
  
  public static final String E0_UNIT_NM = "e0UnitNm";
  
  public static final String E0_UNIT_SNM = "e0UnitSNm";
  
  public static final String E0_UNIT_LEVEL = "e0UnitLevel";
  
  public static final String E0_DEPT_CD = "e0DeptCd";
  
  public static final String E0_BRANCH_CD = "e0BranchCd";
  
  public static final String E0_UNIT_ADDR = "e0UnitAddr";
  
  public static final String E0_AREA_NO = "e0AreaNo";
  
  public static final String E0_PHONE_NO = "e0PhoneNo";
  
  public static final String E0_UNIT_FLAG = "e0UnitFlag";
  
  public static final String E0_FULL_SNM = "e0FullSNm";
  
  public static final String E0_REPORT_FLAG = "e0ReportFlag";
  
  public static final String E0_ORG_CD = "e0OrgCd";
  
  public static final String E0_HR_UNIT_CD = "e0HrUnitCd";
  
  public static final String E0_DELETE_FLAG = "e0DeleteFlag";
  
  public static final String E0_MEMO = "e0Memo";
  
  public static final String E0_POLICE_PHONE = "e0PolicePhone";
  
  public static final String E0_UNIT_SORT = "e0UnitSort";
  
  public static final String E0_OLD_UNIT = "e0OldUnit";
  
  public void save(E0dtNpaunit transientInstance) {
    log.debug("saving E0dtNpaunit instance");
    try {
      getSession().save(transientInstance);
      log.debug("save successful");
    } catch (RuntimeException re) {
      log.error("save failed", re);
      throw re;
    } 
  }
  
  public void delete(E0dtNpaunit persistentInstance) {
    log.debug("deleting E0dtNpaunit instance");
    try {
      getSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    } 
  }
  
  public E0dtNpaunit findById(String id) {
    log.debug("getting E0dtNpaunit instance with id: " + id);
    try {
      E0dtNpaunit instance = (E0dtNpaunit)getSession().get("tw.gov.npa.il.e0db.dao.E0dtNpaunit", id);
      return instance;
    } catch (RuntimeException re) {
      log.error("get failed", re);
      throw re;
    } 
  }
  
  public List findByExample(E0dtNpaunit instance) {
    log.debug("finding E0dtNpaunit instance by example");
    try {
      List results = getSession().createCriteria("tw.gov.npa.il.e0db.dao.E0dtNpaunit").add((Criterion)Example.create(instance)).list();
      log.debug("find by example successful, result size: " + results.size());
      return results;
    } catch (RuntimeException re) {
      log.error("find by example failed", re);
      throw re;
    } 
  }
  
  public List findByProperty(String propertyName, Object value) {
    log.debug("finding E0dtNpaunit instance with property: " + propertyName + ", value: " + value);
    try {
      String queryString = "from E0dtNpaunit as model where model." + propertyName + "= ?";
      Query queryObject = getSession().createQuery(queryString);
      queryObject.setParameter(0, value);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find by property name failed", re);
      throw re;
    } 
  }
  
  public List findByE0UnitNm(Object e0UnitNm) {
    return findByProperty("e0UnitNm", e0UnitNm);
  }
  
  public List findByE0UnitSNm(Object e0UnitSNm) {
    return findByProperty("e0UnitSNm", e0UnitSNm);
  }
  
  public List findByE0UnitLevel(Object e0UnitLevel) {
    return findByProperty("e0UnitLevel", e0UnitLevel);
  }
  
  public List findByE0DeptCd(Object e0DeptCd) {
    return findByProperty("e0DeptCd", e0DeptCd);
  }
  
  public List findByE0BranchCd(Object e0BranchCd) {
    return findByProperty("e0BranchCd", e0BranchCd);
  }
  
  public List findByE0UnitAddr(Object e0UnitAddr) {
    return findByProperty("e0UnitAddr", e0UnitAddr);
  }
  
  public List findByE0AreaNo(Object e0AreaNo) {
    return findByProperty("e0AreaNo", e0AreaNo);
  }
  
  public List findByE0PhoneNo(Object e0PhoneNo) {
    return findByProperty("e0PhoneNo", e0PhoneNo);
  }
  
  public List findByE0UnitFlag(Object e0UnitFlag) {
    return findByProperty("e0UnitFlag", e0UnitFlag);
  }
  
  public List findByE0FullSNm(Object e0FullSNm) {
    return findByProperty("e0FullSNm", e0FullSNm);
  }
  
  public List findByE0ReportFlag(Object e0ReportFlag) {
    return findByProperty("e0ReportFlag", e0ReportFlag);
  }
  
  public List findByE0OrgCd(Object e0OrgCd) {
    return findByProperty("e0OrgCd", e0OrgCd);
  }
  
  public List findByE0HrUnitCd(Object e0HrUnitCd) {
    return findByProperty("e0HrUnitCd", e0HrUnitCd);
  }
  
  public List findByE0DeleteFlag(Object e0DeleteFlag) {
    return findByProperty("e0DeleteFlag", e0DeleteFlag);
  }
  
  public List findByE0Memo(Object e0Memo) {
    return findByProperty("e0Memo", e0Memo);
  }
  
  public List findByE0PolicePhone(Object e0PolicePhone) {
    return findByProperty("e0PolicePhone", e0PolicePhone);
  }
  
  public List findByE0UnitSort(Object e0UnitSort) {
    return findByProperty("e0UnitSort", e0UnitSort);
  }
  
  public List findByE0OldUnit(Object e0OldUnit) {
    return findByProperty("e0OldUnit", e0OldUnit);
  }
  
  public List findAll() {
    log.debug("finding all E0dtNpaunit instances");
    try {
      String queryString = "from E0dtNpaunit";
      Query queryObject = getSession().createQuery(queryString);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find all failed", re);
      throw re;
    } 
  }
  
  public E0dtNpaunit merge(E0dtNpaunit detachedInstance) {
    log.debug("merging E0dtNpaunit instance");
    try {
      E0dtNpaunit result = (E0dtNpaunit)getSession().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    } 
  }
  
  public void attachDirty(E0dtNpaunit instance) {
    log.debug("attaching dirty E0dtNpaunit instance");
    try {
      getSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
  
  public void attachClean(E0dtNpaunit instance) {
    log.debug("attaching clean E0dtNpaunit instance");
    try {
      getSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\e0db\dao\E0dtNpaunitDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */