package tw.gov.npa.il.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Iltb01MainIdxDAO extends BaseHibernateDAO {
  private static final Logger log = LoggerFactory.getLogger(Iltb01MainIdxDAO.class);
  
  public static final String IL_ARCCS = "ilArccs";
  
  public static final String IL_ARCNO = "ilArcno";
  
  public static final String IL_OLDARC = "ilOldarc";
  
  public static final String IL_NTCD = "ilNtcd";
  
  public static final String IL_PSPT = "ilPspt";
  
  public static final String IL_ENM = "ilEnm";
  
  public static final String IL_CNM = "ilCnm";
  
  public static final String IL_BTHDT = "ilBthdt";
  
  public static final String IL_OFNM = "ilOfnm";
  
  public static final String IL_PHQ = "ilPhq";
  
  public static final String IL_PST = "ilPst";
  
  public static final String IL_JBCD = "ilJbcd";
  
  public static final String IL_JBPMDC = "ilJbpmdc";
  
  public void save(Iltb01MainIdx transientInstance) {
    log.debug("saving Iltb01MainIdx instance");
    try {
      getSession().save(transientInstance);
      log.debug("save successful");
    } catch (RuntimeException re) {
      log.error("save failed", re);
      throw re;
    } 
  }
  
  public void delete(Iltb01MainIdx persistentInstance) {
    log.debug("deleting Iltb01MainIdx instance");
    try {
      getSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    } 
  }
  
  public Iltb01MainIdx findById(Integer id) {
    log.debug("getting Iltb01MainIdx instance with id: " + id);
    try {
      Iltb01MainIdx instance = (Iltb01MainIdx)getSession().get(
          "tw.gov.npa.il.dao.Iltb01MainIdx", id);
      return instance;
    } catch (RuntimeException re) {
      log.error("get failed", re);
      throw re;
    } 
  }
  
  public List findByExample(Iltb01MainIdx instance) {
    log.debug("finding Iltb01MainIdx instance by example");
    try {
      List results = getSession()
        .createCriteria("tw.gov.npa.il.dao.Iltb01MainIdx")
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
    log.debug("finding Iltb01MainIdx instance with property: " + 
        propertyName + ", value: " + value);
    try {
      String queryString = "from Iltb01MainIdx as model where model." + 
        propertyName + "= ?";
      Query queryObject = getSession().createQuery(queryString);
      queryObject.setParameter(0, value);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find by property name failed", re);
      throw re;
    } 
  }
  
  public List findByIlArccs(Object ilArccs) {
    return findByProperty("ilArccs", ilArccs);
  }
  
  public List findByIlArcno(Object ilArcno) {
    return findByProperty("ilArcno", ilArcno);
  }
  
  public List findByIlOldarc(Object ilOldarc) {
    return findByProperty("ilOldarc", ilOldarc);
  }
  
  public List findByIlNtcd(Object ilNtcd) {
    return findByProperty("ilNtcd", ilNtcd);
  }
  
  public List findByIlPspt(Object ilPspt) {
    return findByProperty("ilPspt", ilPspt);
  }
  
  public List findByIlEnm(Object ilEnm) {
    return findByProperty("ilEnm", ilEnm);
  }
  
  public List findByIlCnm(Object ilCnm) {
    return findByProperty("ilCnm", ilCnm);
  }
  
  public List findByIlBthdt(Object ilBthdt) {
    return findByProperty("ilBthdt", ilBthdt);
  }
  
  public List findByIlOfnm(Object ilOfnm) {
    return findByProperty("ilOfnm", ilOfnm);
  }
  
  public List findByIlPhq(Object ilPhq) {
    return findByProperty("ilPhq", ilPhq);
  }
  
  public List findByIlPst(Object ilPst) {
    return findByProperty("ilPst", ilPst);
  }
  
  public List findByIlJbcd(Object ilJbcd) {
    return findByProperty("ilJbcd", ilJbcd);
  }
  
  public List findByIlJbpmdc(Object ilJbpmdc) {
    return findByProperty("ilJbpmdc", ilJbpmdc);
  }
  
  public List findAll() {
    log.debug("finding all Iltb01MainIdx instances");
    try {
      String queryString = "from Iltb01MainIdx";
      Query queryObject = getSession().createQuery(queryString);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find all failed", re);
      throw re;
    } 
  }
  
  public Iltb01MainIdx merge(Iltb01MainIdx detachedInstance) {
    log.debug("merging Iltb01MainIdx instance");
    try {
      Iltb01MainIdx result = (Iltb01MainIdx)getSession().merge(
          detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    } 
  }
  
  public void attachDirty(Iltb01MainIdx instance) {
    log.debug("attaching dirty Iltb01MainIdx instance");
    try {
      getSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
  
  public void attachClean(Iltb01MainIdx instance) {
    log.debug("attaching clean Iltb01MainIdx instance");
    try {
      getSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\Iltb01MainIdxDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */