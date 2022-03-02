package tw.gov.npa.il.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Iltb18DataProcessResultDAO extends BaseHibernateDAO {
  private static final Logger log = LoggerFactory.getLogger(Iltb18DataProcessResultDAO.class);
  
  public static final String IL_IMPST = "ilImpst";
  
  public static final String IL_IMPUID = "ilImpuid";
  
  public static final String IL_IMPFL = "ilImpfl";
  
  public static final String IL_IMPTOT = "ilImptot";
  
  public static final String IL_IMPOK = "ilImpok";
  
  public static final String IL_ERRTP1 = "ilErrtp1";
  
  public static final String IL_ERRTP2 = "ilErrtp2";
  
  public static final String IL_ERRTP3 = "ilErrtp3";
  
  public static final String IL_ERRTP4 = "ilErrtp4";
  
  public static final String IL_ERRTP5 = "ilErrtp5";
  
  public static final String IL_ERRTP6 = "ilErrtp6";
  
  public static final String IL_ERRTP7 = "ilErrtp7";
  
  public static final String IL_ERRTP8 = "ilErrtp8";
  
  public static final String IL_ERRTP9 = "ilErrtp9";
  
  public static final String IL_ERRTP0 = "ilErrtp0";
  
  public static final String IL_IMPMSG = "ilImpmsg";
  
  public void save(Iltb18DataProcessResult transientInstance) {
    log.debug("saving Iltb18DataProcessResult instance");
    try {
      getSession().save(transientInstance);
      log.debug("save successful");
    } catch (RuntimeException re) {
      log.error("save failed", re);
      throw re;
    } 
  }
  
  public void delete(Iltb18DataProcessResult persistentInstance) {
    log.debug("deleting Iltb18DataProcessResult instance");
    try {
      getSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    } 
  }
  
  public Iltb18DataProcessResult findById(Iltb18DataProcessResultId id) {
    log.debug("getting Iltb18DataProcessResult instance with id: " + id);
    try {
      Iltb18DataProcessResult instance = (Iltb18DataProcessResult)getSession()
        .get("tw.gov.npa.il.dao.Iltb18DataProcessResult", id);
      return instance;
    } catch (RuntimeException re) {
      log.error("get failed", re);
      throw re;
    } 
  }
  
  public List findByExample(Iltb18DataProcessResult instance) {
    log.debug("finding Iltb18DataProcessResult instance by example");
    try {
      List results = getSession()
        .createCriteria("tw.gov.npa.il.dao.Iltb18DataProcessResult")
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
    log.debug("finding Iltb18DataProcessResult instance with property: " + 
        propertyName + ", value: " + value);
    try {
      String queryString = "from Iltb18DataProcessResult as model where model." + 
        propertyName + "= ?";
      Query queryObject = getSession().createQuery(queryString);
      queryObject.setParameter(0, value);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find by property name failed", re);
      throw re;
    } 
  }
  
  public List findByIlImpst(Object ilImpst) {
    return findByProperty("ilImpst", ilImpst);
  }
  
  public List findByIlImpuid(Object ilImpuid) {
    return findByProperty("ilImpuid", ilImpuid);
  }
  
  public List findByIlImpfl(Object ilImpfl) {
    return findByProperty("ilImpfl", ilImpfl);
  }
  
  public List findByIlImptot(Object ilImptot) {
    return findByProperty("ilImptot", ilImptot);
  }
  
  public List findByIlImpok(Object ilImpok) {
    return findByProperty("ilImpok", ilImpok);
  }
  
  public List findByIlErrtp1(Object ilErrtp1) {
    return findByProperty("ilErrtp1", ilErrtp1);
  }
  
  public List findByIlErrtp2(Object ilErrtp2) {
    return findByProperty("ilErrtp2", ilErrtp2);
  }
  
  public List findByIlErrtp3(Object ilErrtp3) {
    return findByProperty("ilErrtp3", ilErrtp3);
  }
  
  public List findByIlErrtp4(Object ilErrtp4) {
    return findByProperty("ilErrtp4", ilErrtp4);
  }
  
  public List findByIlErrtp5(Object ilErrtp5) {
    return findByProperty("ilErrtp5", ilErrtp5);
  }
  
  public List findByIlErrtp6(Object ilErrtp6) {
    return findByProperty("ilErrtp6", ilErrtp6);
  }
  
  public List findByIlErrtp7(Object ilErrtp7) {
    return findByProperty("ilErrtp7", ilErrtp7);
  }
  
  public List findByIlErrtp8(Object ilErrtp8) {
    return findByProperty("ilErrtp8", ilErrtp8);
  }
  
  public List findByIlErrtp9(Object ilErrtp9) {
    return findByProperty("ilErrtp9", ilErrtp9);
  }
  
  public List findByIlErrtp0(Object ilErrtp0) {
    return findByProperty("ilErrtp0", ilErrtp0);
  }
  
  public List findByIlImpmsg(Object ilImpmsg) {
    return findByProperty("ilImpmsg", ilImpmsg);
  }
  
  public List findAll() {
    log.debug("finding all Iltb18DataProcessResult instances");
    try {
      String queryString = "from Iltb18DataProcessResult";
      Query queryObject = getSession().createQuery(queryString);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find all failed", re);
      throw re;
    } 
  }
  
  public Iltb18DataProcessResult merge(Iltb18DataProcessResult detachedInstance) {
    log.debug("merging Iltb18DataProcessResult instance");
    try {
      Iltb18DataProcessResult result = (Iltb18DataProcessResult)getSession()
        .merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    } 
  }
  
  public void attachDirty(Iltb18DataProcessResult instance) {
    log.debug("attaching dirty Iltb18DataProcessResult instance");
    try {
      getSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
  
  public void attachClean(Iltb18DataProcessResult instance) {
    log.debug("attaching clean Iltb18DataProcessResult instance");
    try {
      getSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\Iltb18DataProcessResultDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */