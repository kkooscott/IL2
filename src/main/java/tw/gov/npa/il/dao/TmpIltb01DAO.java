package tw.gov.npa.il.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TmpIltb01DAO extends BaseHibernateDAO {
  private static final Logger log = LoggerFactory.getLogger(TmpIltb01DAO.class);
  
  public static final String IL_ARCTP = "ilArctp";
  
  public static final String IL_ARCCS = "ilArccs";
  
  public static final String IL_ENM = "ilEnm";
  
  public static final String IL_CNM = "ilCnm";
  
  public static final String IL_SEX = "ilSex";
  
  public static final String IL_BTHDT = "ilBthdt";
  
  public static final String IL_NTCD = "ilNtcd";
  
  public static final String IL_PSPT = "ilPspt";
  
  public static final String IL_MST = "ilMst";
  
  public static final String IL_EDU = "ilEdu";
  
  public static final String IL_ARCRSN = "ilArcrsn";
  
  public static final String IL_ARCST = "ilArcst";
  
  public static final String IL_JBCD = "ilJbcd";
  
  public static final String IL_JBPSN = "ilJbpsn";
  
  public static final String IL_OFCD = "ilOfcd";
  
  public static final String IL_OFNM = "ilOfnm";
  
  public static final String IL_OFTEL = "ilOftel";
  
  public static final String IL_OFNMBF = "ilOfnmbf";
  
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
  
  public static final String IL_PST = "ilPst";
  
  public static final String IL_PHQ = "ilPhq";
  
  public static final String IL_PSTEXT = "ilPstext";
  
  public static final String IL_REMRK = "ilRemrk";
  
  public static final String IL_ARCISU = "ilArcisu";
  
  public static final String IL_FRSHP = "ilFrshp";
  
  public static final String IL_FNM = "ilFnm";
  
  public static final String IL_FPID = "ilFpid";
  
  public static final String IL_FNTCD = "ilFntcd";
  
  public static final String IL_FRCEXIT = "ilFrcexit";
  
  public static final String IL_RETP = "ilRetp";
  
  public static final String IL_REPMDC = "ilRepmdc";
  
  public static final String IL_RRNOTE = "ilRrnote";
  
  public static final String IL_MRKCS = "ilMrkcs";
  
  public static final String IL_FBDRSN = "ilFbdrsn";
  
  public static final String IL_MRKDC = "ilMrkdc";
  
  public static final String IL_SBMTTP = "ilSbmttp";
  
  public static final String IL_SRCHST = "ilSrchst";
  
  public static final String IL_FNDDID = "ilFnddid";
  
  public static final String IL_OLDARC = "ilOldarc";
  
  public static final String IL_HCST = "ilHcst";
  
  public static final String IL_HCCTR = "ilHcctr";
  
  public static final String IL_REPMDC_NIC = "ilRepmdcNic";
  
  public static final String IL_FORFERE = "ilForfere";
  
  public void save(TmpIltb01 transientInstance) {
    log.debug("saving TmpIltb01 instance");
    try {
      getSession().save(transientInstance);
      log.debug("save successful");
    } catch (RuntimeException re) {
      log.error("save failed", re);
      throw re;
    } 
  }
  
  public void delete(TmpIltb01 persistentInstance) {
    log.debug("deleting TmpIltb01 instance");
    try {
      getSession().delete(persistentInstance);
      log.debug("delete successful");
    } catch (RuntimeException re) {
      log.error("delete failed", re);
      throw re;
    } 
  }
  
  public TmpIltb01 findById(Integer id) {
    log.debug("getting TmpIltb01 instance with id: " + id);
    try {
      TmpIltb01 instance = (TmpIltb01)getSession().get(
          "tw.gov.npa.il.dao.TmpIltb01", id);
      return instance;
    } catch (RuntimeException re) {
      log.error("get failed", re);
      throw re;
    } 
  }
  
  public List findByExample(TmpIltb01 instance) {
    log.debug("finding TmpIltb01 instance by example");
    try {
      List results = getSession()
        .createCriteria("tw.gov.npa.il.dao.TmpIltb01")
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
    log.debug("finding TmpIltb01 instance with property: " + propertyName + 
        ", value: " + value);
    try {
      String queryString = "from TmpIltb01 as model where model." + 
        propertyName + "= ?";
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
  
  public List findByIlEnm(Object ilEnm) {
    return findByProperty("ilEnm", ilEnm);
  }
  
  public List findByIlCnm(Object ilCnm) {
    return findByProperty("ilCnm", ilCnm);
  }
  
  public List findByIlSex(Object ilSex) {
    return findByProperty("ilSex", ilSex);
  }
  
  public List findByIlBthdt(Object ilBthdt) {
    return findByProperty("ilBthdt", ilBthdt);
  }
  
  public List findByIlNtcd(Object ilNtcd) {
    return findByProperty("ilNtcd", ilNtcd);
  }
  
  public List findByIlPspt(Object ilPspt) {
    return findByProperty("ilPspt", ilPspt);
  }
  
  public List findByIlMst(Object ilMst) {
    return findByProperty("ilMst", ilMst);
  }
  
  public List findByIlEdu(Object ilEdu) {
    return findByProperty("ilEdu", ilEdu);
  }
  
  public List findByIlArcrsn(Object ilArcrsn) {
    return findByProperty("ilArcrsn", ilArcrsn);
  }
  
  public List findByIlArcst(Object ilArcst) {
    return findByProperty("ilArcst", ilArcst);
  }
  
  public List findByIlJbcd(Object ilJbcd) {
    return findByProperty("ilJbcd", ilJbcd);
  }
  
  public List findByIlJbpsn(Object ilJbpsn) {
    return findByProperty("ilJbpsn", ilJbpsn);
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
  
  public List findByIlOfnmbf(Object ilOfnmbf) {
    return findByProperty("ilOfnmbf", ilOfnmbf);
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
  
  public List findByIlPst(Object ilPst) {
    return findByProperty("ilPst", ilPst);
  }
  
  public List findByIlPhq(Object ilPhq) {
    return findByProperty("ilPhq", ilPhq);
  }
  
  public List findByIlPstext(Object ilPstext) {
    return findByProperty("ilPstext", ilPstext);
  }
  
  public List findByIlRemrk(Object ilRemrk) {
    return findByProperty("ilRemrk", ilRemrk);
  }
  
  public List findByIlArcisu(Object ilArcisu) {
    return findByProperty("ilArcisu", ilArcisu);
  }
  
  public List findByIlFrshp(Object ilFrshp) {
    return findByProperty("ilFrshp", ilFrshp);
  }
  
  public List findByIlFnm(Object ilFnm) {
    return findByProperty("ilFnm", ilFnm);
  }
  
  public List findByIlFpid(Object ilFpid) {
    return findByProperty("ilFpid", ilFpid);
  }
  
  public List findByIlFntcd(Object ilFntcd) {
    return findByProperty("ilFntcd", ilFntcd);
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
  
  public List findByIlSbmttp(Object ilSbmttp) {
    return findByProperty("ilSbmttp", ilSbmttp);
  }
  
  public List findByIlSrchst(Object ilSrchst) {
    return findByProperty("ilSrchst", ilSrchst);
  }
  
  public List findByIlFnddid(Object ilFnddid) {
    return findByProperty("ilFnddid", ilFnddid);
  }
  
  public List findByIlOldarc(Object ilOldarc) {
    return findByProperty("ilOldarc", ilOldarc);
  }
  
  public List findByIlHcst(Object ilHcst) {
    return findByProperty("ilHcst", ilHcst);
  }
  
  public List findByIlHcctr(Object ilHcctr) {
    return findByProperty("ilHcctr", ilHcctr);
  }
  
  public List findByIlRepmdcNic(Object ilRepmdcNic) {
    return findByProperty("ilRepmdcNic", ilRepmdcNic);
  }
  
  public List findByIlForfere(Object ilForfere) {
    return findByProperty("ilForfere", ilForfere);
  }
  
  public List findAll() {
    log.debug("finding all TmpIltb01 instances");
    try {
      String queryString = "from TmpIltb01";
      Query queryObject = getSession().createQuery(queryString);
      return queryObject.list();
    } catch (RuntimeException re) {
      log.error("find all failed", re);
      throw re;
    } 
  }
  
  public TmpIltb01 merge(TmpIltb01 detachedInstance) {
    log.debug("merging TmpIltb01 instance");
    try {
      TmpIltb01 result = (TmpIltb01)getSession().merge(detachedInstance);
      log.debug("merge successful");
      return result;
    } catch (RuntimeException re) {
      log.error("merge failed", re);
      throw re;
    } 
  }
  
  public void attachDirty(TmpIltb01 instance) {
    log.debug("attaching dirty TmpIltb01 instance");
    try {
      getSession().saveOrUpdate(instance);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
  
  public void attachClean(TmpIltb01 instance) {
    log.debug("attaching clean TmpIltb01 instance");
    try {
      getSession().lock(instance, LockMode.NONE);
      log.debug("attach successful");
    } catch (RuntimeException re) {
      log.error("attach failed", re);
      throw re;
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\TmpIltb01DAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */