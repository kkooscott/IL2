package tw.gov.npa.il.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Iltb20OnlineReportDAO_new1 extends BaseHibernateDAO {
  private static final Logger log = LoggerFactory.getLogger(Iltb20OnlineReportDAO_new1.class);
  
  public static final String IL_DIDNM = "ilDidnm";
  
  public static final String IL_IP = "ilIp";
  
  public static final String IL_RPTNM = "ilRptnm";
  
  public static final String IL_RPTFN = "ilRptfn";
  
  public static final String IL_STATUS = "ilStatus";
  
  public static final String IL_SHOW = "ilShow";
  
  public static final String IL_WHERE1 = "ilWhere1";
  
  public static final String IL_WHERE2 = "ilWhere2";
  
  public static final String IL_WHERE3 = "ilWhere3";
  
  public static final String IL_WHERE4 = "ilWhere4";
  
  public static final String IL_RPTAMT = "ilRptamt";
  
  public void save(Iltb20OnlineReport transientInstance) {
    log.debug("saving Iltb20OnlineReport instance");
    try {
      Transaction tran = getSession().beginTransaction();
      getSession().save(transientInstance);
      tran.commit();
      log.debug("save successful");
      getSession().close();
    } catch (RuntimeException re) {
      log.error("save failed", re);
      throw re;
    } 
  }
  
  public void delete(Iltb20OnlineReport persistentInstance) {
    log.debug("deleting Iltb20OnlineReport instance");
    try {
      getSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    } 
  }
  
  public Iltb20OnlineReport findById(Iltb20OnlineReportId id) {
    log.debug("getting Iltb20OnlineReport instance with id: " + id);
    try {
      Iltb20OnlineReport instance = (Iltb20OnlineReport)getSession()
        .get("tw.gov.npa.il.dao.Iltb20OnlineReport", id);
      return instance;
    } catch (RuntimeException re) {
      log.error("get failed", re);
      throw re;
    } 
  }
  
  public List findByExample(Iltb20OnlineReport instance) {
    log.debug("finding Iltb20OnlineReport instance by example");
    try {
      List results = getSession()
        .createCriteria("tw.gov.npa.il.dao.Iltb20OnlineReport")
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
    log.debug("finding Iltb20OnlineReport instance with property: " + 
        propertyName + ", value: " + value);
    try {
      String queryString = "from Iltb20OnlineReport as model where model." + 
        propertyName + "= ?";
      Query queryObject = getSession().createQuery(queryString);
      queryObject.setParameter(0, value);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find by property name failed", re);
      throw re;
    } 
  }
  
  public List findByIlDidnm(Object ilDidnm) {
    return findByProperty("ilDidnm", ilDidnm);
  }
  
  public List findByIlIp(Object ilIp) {
    return findByProperty("ilIp", ilIp);
  }
  
  public List findByIlRptnm(Object ilRptnm) {
    return findByProperty("ilRptnm", ilRptnm);
  }
  
  public List findByIlRptfn(Object ilRptfn) {
    return findByProperty("ilRptfn", ilRptfn);
  }
  
  public List findByIlStatus(Object ilStatus) {
    return findByProperty("ilStatus", ilStatus);
  }
  
  public List findByIlShow(Object ilShow) {
    return findByProperty("ilShow", ilShow);
  }
  
  public List findByIlWhere1(Object ilWhere1) {
    return findByProperty("ilWhere1", ilWhere1);
  }
  
  public List findByIlWhere2(Object ilWhere2) {
    return findByProperty("ilWhere2", ilWhere2);
  }
  
  public List findByIlWhere3(Object ilWhere3) {
    return findByProperty("ilWhere3", ilWhere3);
  }
  
  public List findByIlWhere4(Object ilWhere4) {
    return findByProperty("ilWhere4", ilWhere4);
  }
  
  public List findByIlRptamt(Object ilRptamt) {
    return findByProperty("ilRptamt", ilRptamt);
  }
  
  public List findAll() {
    log.debug("finding all Iltb20OnlineReport instances");
    try {
      String queryString = "from Iltb20OnlineReport";
      Query queryObject = getSession().createQuery(queryString);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find all failed", re);
      throw re;
    } 
  }
  
  public Iltb20OnlineReport merge(Iltb20OnlineReport detachedInstance) {
    log.debug("merging Iltb20OnlineReport instance");
    try {
      Iltb20OnlineReport result = (Iltb20OnlineReport)getSession()
        .merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    } 
  }
  
  public void attachDirty(Iltb20OnlineReport instance) {
    log.debug("attaching dirty Iltb20OnlineReport instance");
    try {
      getSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
  
  public void attachClean(Iltb20OnlineReport instance) {
    log.debug("attaching clean Iltb20OnlineReport instance");
    try {
      getSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\Iltb20OnlineReportDAO_new1.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */