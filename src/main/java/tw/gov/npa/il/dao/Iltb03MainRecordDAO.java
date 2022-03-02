package tw.gov.npa.il.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Iltb03MainRecordDAO extends BaseHibernateDAO {
  private static final Logger log = LoggerFactory.getLogger(Iltb03MainRecordDAO.class);
  
  public static final String IL_ARCTP = "ilArctp";
  
  public static final String IL_ARCCS = "ilArccs";
  
  public static final String IL_HSTMRK = "ilHstmrk";
  
  public static final String IL_ENM = "ilEnm";
  
  public static final String IL_PSPT = "ilPspt";
  
  public static final String IL_ARCRSN = "ilArcrsn";
  
  public static final String IL_JBCD = "ilJbcd";
  
  public static final String IL_OFCD = "ilOfcd";
  
  public static final String IL_OFNM = "ilOfnm";
  
  public static final String IL_OFTEL = "ilOftel";
  
  public static final String IL_JBPZONE = "ilJbpzone";
  
  public static final String IL_JBADDR = "ilJbaddr";
  
  public static final String IL_JBTEL = "ilJbtel";
  
  public static final String IL_ARPZONE = "ilArpzone";
  
  public static final String IL_ARADDR = "ilAraddr";
  
  public static final String IL_ARTEL = "ilArtel";
  
  public static final String IL_AGNCO = "ilAgnco";
  
  public static final String IL_AGNTEL = "ilAgntel";
  
  public static final String IL_JBPMCD = "ilJbpmcd";
  
  public static final String IL_JBPMDC = "ilJbpmdc";
  
  public static final String IL_MICRO = "ilMicro";
  
  public static final String IL_ARCRCP = "ilArcrcp";
  
  public static final String IL_ARCNO = "ilArcno";
  
  public static final String IL_FRCEXIT = "ilFrcexit";
  
  public static final String IL_RETP = "ilRetp";
  
  public static final String IL_REPMDC = "ilRepmdc";
  
  public static final String IL_RRNOTE = "ilRrnote";
  
  public static final String IL_MRKCS = "ilMrkcs";
  
  public static final String IL_FBDRSN = "ilFbdrsn";
  
  public static final String IL_MRKDC = "ilMrkdc";
  
  public static final String IL_TID = "ilTid";
  
  public void save(Iltb03MainRecord transientInstance) {
    log.debug("saving Iltb03MainRecord instance");
    try {
      getSession().save(transientInstance);
      log.debug("save successful");
    } catch (RuntimeException re) {
      log.error("save failed", re);
      throw re;
    } 
  }
  
  public void delete(Iltb03MainRecord persistentInstance) {
    log.debug("deleting Iltb03MainRecord instance");
    try {
      getSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    } 
  }
  
  public Iltb03MainRecord findById(Iltb03MainRecordId id) {
    log.debug("getting Iltb03MainRecord instance with id: " + id);
    try {
      Iltb03MainRecord instance = (Iltb03MainRecord)getSession().get("tw.gov.npa.il.dao.Iltb03MainRecord", id);
      return instance;
    } catch (RuntimeException re) {
      log.error("get failed", re);
      throw re;
    } 
  }
  
  public List findByExample(Iltb03MainRecord instance) {
    log.debug("finding Iltb03MainRecord instance by example");
    try {
      List results = getSession().createCriteria("tw.gov.npa.il.dao.Iltb03MainRecord").add((Criterion)Example.create(instance)).list();
      log.debug("find by example successful, result size: " + results.size());
      return results;
    } catch (RuntimeException re) {
      log.error("find by example failed", re);
      throw re;
    } 
  }
  
  public List findByProperty(String propertyName, Object value) {
    log.debug("finding Iltb03MainRecord instance with property: " + propertyName + ", value: " + value);
    try {
      String queryString = "from Iltb03MainRecord as model where model." + propertyName + "= ?";
      Query queryObject = getSession().createQuery(queryString);
      queryObject.setParameter(0, value);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find by property name failed", re);
      throw re;
    } 
  }
  
  public List findByIlArctp(Object ilArctp) {
    return findByProperty("ilArctp", ilArctp);
  }
  
  public List findByIlArccs(Object ilArccs) {
    return findByProperty("ilArccs", ilArccs);
  }
  
  public List findByIlHstmrk(Object ilHstmrk) {
    return findByProperty("ilHstmrk", ilHstmrk);
  }
  
  public List findByIlEnm(Object ilEnm) {
    return findByProperty("ilEnm", ilEnm);
  }
  
  public List findByIlPspt(Object ilPspt) {
    return findByProperty("ilPspt", ilPspt);
  }
  
  public List findByIlArcrsn(Object ilArcrsn) {
    return findByProperty("ilArcrsn", ilArcrsn);
  }
  
  public List findByIlJbcd(Object ilJbcd) {
    return findByProperty("ilJbcd", ilJbcd);
  }
  
  public List findByIlOfcd(Object ilOfcd) {
    return findByProperty("ilOfcd", ilOfcd);
  }
  
  public List findByIlOfnm(Object ilOfnm) {
    return findByProperty("ilOfnm", ilOfnm);
  }
  
  public List findByIlOftel(Object ilOftel) {
    return findByProperty("ilOftel", ilOftel);
  }
  
  public List findByIlJbpzone(Object ilJbpzone) {
    return findByProperty("ilJbpzone", ilJbpzone);
  }
  
  public List findByIlJbaddr(Object ilJbaddr) {
    return findByProperty("ilJbaddr", ilJbaddr);
  }
  
  public List findByIlJbtel(Object ilJbtel) {
    return findByProperty("ilJbtel", ilJbtel);
  }
  
  public List findByIlArpzone(Object ilArpzone) {
    return findByProperty("ilArpzone", ilArpzone);
  }
  
  public List findByIlAraddr(Object ilAraddr) {
    return findByProperty("ilAraddr", ilAraddr);
  }
  
  public List findByIlArtel(Object ilArtel) {
    return findByProperty("ilArtel", ilArtel);
  }
  
  public List findByIlAgnco(Object ilAgnco) {
    return findByProperty("ilAgnco", ilAgnco);
  }
  
  public List findByIlAgntel(Object ilAgntel) {
    return findByProperty("ilAgntel", ilAgntel);
  }
  
  public List findByIlJbpmcd(Object ilJbpmcd) {
    return findByProperty("ilJbpmcd", ilJbpmcd);
  }
  
  public List findByIlJbpmdc(Object ilJbpmdc) {
    return findByProperty("ilJbpmdc", ilJbpmdc);
  }
  
  public List findByIlMicro(Object ilMicro) {
    return findByProperty("ilMicro", ilMicro);
  }
  
  public List findByIlArcrcp(Object ilArcrcp) {
    return findByProperty("ilArcrcp", ilArcrcp);
  }
  
  public List findByIlArcno(Object ilArcno) {
    return findByProperty("ilArcno", ilArcno);
  }
  
  public List findByIlFrcexit(Object ilFrcexit) {
    return findByProperty("ilFrcexit", ilFrcexit);
  }
  
  public List findByIlRetp(Object ilRetp) {
    return findByProperty("ilRetp", ilRetp);
  }
  
  public List findByIlRepmdc(Object ilRepmdc) {
    return findByProperty("ilRepmdc", ilRepmdc);
  }
  
  public List findByIlRrnote(Object ilRrnote) {
    return findByProperty("ilRrnote", ilRrnote);
  }
  
  public List findByIlMrkcs(Object ilMrkcs) {
    return findByProperty("ilMrkcs", ilMrkcs);
  }
  
  public List findByIlFbdrsn(Object ilFbdrsn) {
    return findByProperty("ilFbdrsn", ilFbdrsn);
  }
  
  public List findByIlMrkdc(Object ilMrkdc) {
    return findByProperty("ilMrkdc", ilMrkdc);
  }
  
  public List findByIlTid(Object ilTid) {
    return findByProperty("ilTid", ilTid);
  }
  
  public List findAll() {
    log.debug("finding all Iltb03MainRecord instances");
    try {
      String queryString = "from Iltb03MainRecord";
      Query queryObject = getSession().createQuery(queryString);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find all failed", re);
      throw re;
    } 
  }
  
  public Iltb03MainRecord merge(Iltb03MainRecord detachedInstance) {
    log.debug("merging Iltb03MainRecord instance");
    try {
      Iltb03MainRecord result = (Iltb03MainRecord)getSession().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    } 
  }
  
  public void attachDirty(Iltb03MainRecord instance) {
    log.debug("attaching dirty Iltb03MainRecord instance");
    try {
      getSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
  
  public void attachClean(Iltb03MainRecord instance) {
    log.debug("attaching clean Iltb03MainRecord instance");
    try {
      getSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\Iltb03MainRecordDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */