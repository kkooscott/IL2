package tw.gov.npa.il.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.Type;
import tw.gov.npa.il.action.bean.IL02A01U02Bean;
import tw.gov.npa.il.action.bean.IL03A01Q02Bean;
import tw.gov.npa.il.dao.HibernateSessionFactory;
import tw.gov.npa.il.dao.Iltb01Main;
import tw.gov.npa.il.dao.Iltb01MainDAO;

public class MyIltb01MainDAO extends Iltb01MainDAO {
  private static final Logger logger = Logger.getLogger(tw.gov.npa.il.myDao.MyIltb01MainDAO.class);
  
  public static final int MAX_RESULT = 300;
  
  public void tryToCloseSession() {
    try {
      HibernateSessionFactory.getSession().close();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public boolean updateData(Iltb01Main bean) {
    Session session = null;
    Transaction tran = null;
    try {
      session = getSession();
      tran = session.beginTransaction();
      save(bean);
      tran.commit();
      System.out.println(new Date() + ":" + "Iltb01Main資料庫寫入完成");
      return true;
    } catch (Exception e) {
      if (tran != null)
        try {
          tran.rollback();
        } catch (Exception ex) {
          ex.printStackTrace();
        }  
      String errorMsg = e.getMessage();
      System.out.println(new Date() + ":" + "Iltb01Main資料庫寫入失敗=" + errorMsg);
      return false;
    } finally {
      tryToCloseSession();
    } 
  }
  
  public boolean delData(Iltb01Main bean) {
    Session session = null;
    Transaction tran = null;
    try {
      session = getSession();
      tran = session.beginTransaction();
      delete(bean);
      tran.commit();
      System.out.println(new Date() + ":" + "Iltb01Main資料庫刪除完成");
      return true;
    } catch (Exception e) {
      if (tran != null)
        try {
          tran.rollback();
        } catch (Exception ex) {
          ex.printStackTrace();
        }  
      String errorMsg = e.getMessage();
      System.out.println(new Date() + ":" + "Iltb01Main資料庫刪除失敗=" + errorMsg);
      return false;
    } finally {
      tryToCloseSession();
    } 
  }
  
  public List<IL02A01U02Bean> getIL02A01U02Q(int usrFlagInfo, String ilNtcd, String ilPspt, String ilEnm, String txtBEGIN_DT, String ilArcno) {
    List<IL02A01U02Bean> list = new ArrayList<IL02A01U02Bean>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT a.IL_ARCID, a.IL_PSPT, a.IL_ENM, a.IL_NTCD, a.IL_BTHDT, b.IL_NTNM FROM ILTB_01_MAIN a, ILTB_15_COUNTRY_CODE b");
      sqlStr.append(" WHERE a.IL_NTCD = b.IL_NTCD");
      if (usrFlagInfo != 90 && usrFlagInfo != 91 && usrFlagInfo != 92)
        if (usrFlagInfo == 10 || usrFlagInfo == 21 || usrFlagInfo == 22 || usrFlagInfo == 32 || usrFlagInfo == 33 || usrFlagInfo == 50 || usrFlagInfo == 61) {
          sqlStr.append(" AND a.IL_PHQ ('" + usrFlagInfo + "')");
        } else {
          sqlStr.append(" AND a.IL_PST in ('" + usrFlagInfo + "')");
        }  
      if (!"".equals(ilPspt) || ilPspt == null)
        sqlStr.append(" AND a.IL_PSPT = '" + ilPspt + "'"); 
      if (!"".equals(ilEnm) || ilEnm == null)
        sqlStr.append(" AND a.IL_ENM = '" + ilEnm + "'"); 
      if (!"".equals(txtBEGIN_DT) || txtBEGIN_DT == null)
        sqlStr.append(" AND a.IL_BTHDT = '" + txtBEGIN_DT + "'"); 
      if (!"".equals(ilArcno) || ilArcno == null)
        sqlStr.append(" AND a.IL_ARCNO = '" + ilArcno + "'"); 
      if (!"".equals(ilNtcd) || ilNtcd == null)
        sqlStr.append(" AND a.IL_NTCD ='" + ilNtcd + "'"); 
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_ARCID", (Type)Hibernate.INTEGER);
      q.addScalar("IL_PSPT", (Type)Hibernate.STRING);
      q.addScalar("IL_ENM", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTNM", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          IL02A01U02Bean bean = new IL02A01U02Bean();
          int IL_ARCID = 0;
          String IL_PSPT = null;
          String IL_ENM = null;
          String IL_NTCD = null;
          String IL_BTHDT = null;
          String IL_NTNM = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_ARCID = ((Integer)objArr[0]).intValue(); 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_PSPT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_ENM = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_NTCD = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_BTHDT = (String)objArr[4]; 
          if (!"".equals(objArr[5]) && objArr[5] != null)
            IL_NTNM = (String)objArr[5]; 
          bean.setId(i + 1);
          bean.setIlArcid(IL_ARCID);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlEnm(IL_ENM);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlNTNM(IL_NTNM);
          bean.setIlPspt(IL_PSPT);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL02C01U02Q(String[] ilPstArr, String ilZipCode, String txtBEGIN_DT, String txtBEGIN_DF, String ilPstext, String[] ilArccsArr) {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * FROM ILTB_01_MAIN");
      sqlStr.append(" WHERE IL_ARPZONE='" + ilZipCode + "'");
      if (ilPstArr != null) {
        sqlStr.append(" AND(");
        for (int i = 0; i < ilPstArr.length; i++) {
          if (i == 0) {
            sqlStr.append("IL_PHQ='" + ilPstArr[i] + "'");
          } else {
            sqlStr.append(" OR IL_PHQ='" + ilPstArr[i] + "'");
          } 
        } 
        sqlStr.append(")");
      } 
      sqlStr.append(" AND IL_APYDT>= '" + txtBEGIN_DT + "'");
      sqlStr.append(" AND IL_APYDT<= '" + txtBEGIN_DF + "'");
      if (!"".equals(ilPstext) && ilPstext != null)
        sqlStr.append(" AND IL_PSTEXT='" + ilPstext + "'"); 
      if (!"".equals(ilArccsArr) && ilArccsArr != null)
        if (ilArccsArr.length == 2) {
          sqlStr.append(" AND IL_ARCCS in ('0','1')");
        } else {
          for (String ilArccs : ilArccsArr) {
            if (ilArccs.equals(Integer.valueOf(0))) {
              sqlStr.append(" AND IL_ARCCS in ('0')");
            } else if (ilArccs.equals(Integer.valueOf(1))) {
              sqlStr.append(" AND IL_ARCCS in ('1')");
            } 
          } 
        }  
      sqlStr.append(" ORDER BY IL_ARADDR");
      System.out.println("sqlStr=" + sqlStr);
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<IL03A01Q02Bean> getIL03A01Q02(String ilArcno, String ilPspt, String ilEnm, String ilCnm, String ilOfnm, String ilPhq, String ilJbpmdt, String ilJbpmdc) {
    List<IL03A01Q02Bean> list = new ArrayList<IL03A01Q02Bean>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT a.IL_ARCID, a.IL_PSPT, a.IL_ENM, a.IL_NTCD, a.IL_BTHDT, b.IL_NTNM FROM ILTB_01_MAIN a, ILTB_15_COUNTRY_CODE b");
      sqlStr.append(" WHERE a.IL_NTCD = b.IL_NTCD");
      if (!"".equals(ilArcno) || ilArcno == null)
        sqlStr.append(" AND a.IL_ARCNO = '" + ilArcno + "'"); 
      if (!"".equals(ilPspt) || ilPspt == null)
        sqlStr.append(" AND a.IL_PSPT = '" + ilPspt + "'"); 
      if (!"".equals(ilEnm) || ilEnm == null)
        sqlStr.append(" AND a.IL_ENM = '" + ilEnm + "'"); 
      if (!"".equals(ilCnm) || ilCnm == null)
        sqlStr.append(" AND a.IL_CNM = '" + ilCnm + "'"); 
      if (!"".equals(ilOfnm) || ilOfnm == null)
        sqlStr.append(" AND a.IL_OFNM = '" + ilOfnm + "'"); 
      if (!"".equals(ilPhq) || ilPhq == null)
        sqlStr.append(" AND a.IL_PHQ = '" + ilPhq + "'"); 
      if (!"".equals(ilJbpmdt) || ilJbpmdt == null)
        sqlStr.append(" AND a.IL_JBPMDT ='" + ilJbpmdt + "'"); 
      if (!"".equals(ilJbpmdc) || ilJbpmdc == null)
        sqlStr.append(" AND a.IL_JBPMDC ='" + ilJbpmdc + "'"); 
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_ARCID", (Type)Hibernate.INTEGER);
      q.addScalar("IL_PSPT", (Type)Hibernate.STRING);
      q.addScalar("IL_ENM", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTNM", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          IL03A01Q02Bean bean = new IL03A01Q02Bean();
          int IL_ARCID = 0;
          String IL_PSPT = null;
          String IL_ENM = null;
          String IL_NTCD = null;
          String IL_BTHDT = null;
          String IL_NTNM = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_ARCID = ((Integer)objArr[0]).intValue(); 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_PSPT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_ENM = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_NTCD = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_BTHDT = (String)objArr[4]; 
          if (!"".equals(objArr[5]) && objArr[5] != null)
            IL_NTNM = (String)objArr[5]; 
          bean.setId(i + 1);
          bean.setIlArcid(IL_ARCID);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlEnm(IL_ENM);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlNTNM(IL_NTNM);
          bean.setIlPspt(IL_PSPT);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A01P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * from ILTB_01_MAIN");
      sqlStr.append(" WHERE IL_ARCTP = '1' AND (IL_ARCST = '2' or IL_ARCST = '3')");
      sqlStr.append(" AND IL_NTCD <> '035' AND IL_NTCD <> '061'");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A02P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * from ILTB_01_MAIN");
      sqlStr.append(" WHERE IL_ARCTP = '1' AND (IL_ARCST = '2' or IL_ARCST = '3')");
      sqlStr.append(" AND IL_NTCD <> '035' AND IL_NTCD <> '061'");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A07P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and ((IL_ARCTP = '0'");
      sqlStr.append(" and IL_ARCST in ('2', '3')");
      sqlStr.append(" and convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS != '2'))))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A07P_01() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and ((IL_ARCTP = '0'");
      sqlStr.append(" and IL_ARCST in ('2', '3')");
      sqlStr.append(" and convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS != '2'))))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A07P_02() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ not in ('Y000','Z000')");
      sqlStr.append(" and ((IL_ARCTP = '0'");
      sqlStr.append(" and IL_ARCST in ('2', '3')");
      sqlStr.append(" and convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS != '2'))))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A07P_03() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ not in ('V000','W000','Y000','Z000''D000','I000','C000','B000','O000','P000')");
      sqlStr.append(" and ((IL_ARCTP = '0'");
      sqlStr.append(" and IL_ARCST in ('2', '3')");
      sqlStr.append(" and convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS != '2'))))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A07P_04() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('Y000','Z000')");
      sqlStr.append(" and ((IL_ARCTP = '0'");
      sqlStr.append(" and IL_ARCST in ('2', '3')");
      sqlStr.append(" and convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS != '2'))))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A07P_05() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ = 'W000'");
      sqlStr.append(" and ((IL_ARCTP = '0'");
      sqlStr.append(" and IL_ARCST in ('2', '3')");
      sqlStr.append(" and convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS != '2'))))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A07P_06() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ = 'D000'");
      sqlStr.append(" and ((IL_ARCTP = '0'");
      sqlStr.append(" and IL_ARCST in ('2', '3')");
      sqlStr.append(" and convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS != '2'))))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A07P_07() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('B000','I000')");
      sqlStr.append(" and ((IL_ARCTP = '0'");
      sqlStr.append(" and IL_ARCST in ('2', '3')");
      sqlStr.append(" and convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS != '2'))))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A07P_08() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('C000','O000')");
      sqlStr.append(" and ((IL_ARCTP = '0'");
      sqlStr.append(" and IL_ARCST in ('2', '3')");
      sqlStr.append(" and convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS != '2'))))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A07P_09() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('E000')");
      sqlStr.append(" and ((IL_ARCTP = '0'");
      sqlStr.append(" and IL_ARCST in ('2', '3')");
      sqlStr.append(" and convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS != '2'))))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A07P_10() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('F000')");
      sqlStr.append(" and ((IL_ARCTP = '0'");
      sqlStr.append(" and IL_ARCST in ('2', '3')");
      sqlStr.append(" and convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS != '2'))))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A07P_11() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('G000')");
      sqlStr.append(" and ((IL_ARCTP = '0'");
      sqlStr.append(" and IL_ARCST in ('2', '3')");
      sqlStr.append(" and convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS != '2'))))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A07P_12() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('H000')");
      sqlStr.append(" and ((IL_ARCTP = '0'");
      sqlStr.append(" and IL_ARCST in ('2', '3')");
      sqlStr.append(" and convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS != '2'))))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A07P_13() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('J000')");
      sqlStr.append(" and ((IL_ARCTP = '0'");
      sqlStr.append(" and IL_ARCST in ('2', '3')");
      sqlStr.append(" and convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS != '2'))))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A07P_14() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('K000')");
      sqlStr.append(" and ((IL_ARCTP = '0'");
      sqlStr.append(" and IL_ARCST in ('2', '3')");
      sqlStr.append(" and convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS != '2'))))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A07P_15() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('L000')");
      sqlStr.append(" and ((IL_ARCTP = '0'");
      sqlStr.append(" and IL_ARCST in ('2', '3')");
      sqlStr.append(" and convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS != '2'))))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A07P_16() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('M000')");
      sqlStr.append(" and ((IL_ARCTP = '0'");
      sqlStr.append(" and IL_ARCST in ('2', '3')");
      sqlStr.append(" and convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS != '2'))))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A07P_17() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('N000')");
      sqlStr.append(" and ((IL_ARCTP = '0'");
      sqlStr.append(" and IL_ARCST in ('2', '3')");
      sqlStr.append(" and convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS != '2'))))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A07P_18() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('Q000')");
      sqlStr.append(" and ((IL_ARCTP = '0'");
      sqlStr.append(" and IL_ARCST in ('2', '3')");
      sqlStr.append(" and convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS != '2'))))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A07P_19() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('R000')");
      sqlStr.append(" and ((IL_ARCTP = '0'");
      sqlStr.append(" and IL_ARCST in ('2', '3')");
      sqlStr.append(" and convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS != '2'))))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A07P_20() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('S000')");
      sqlStr.append(" and ((IL_ARCTP = '0'");
      sqlStr.append(" and IL_ARCST in ('2', '3')");
      sqlStr.append(" and convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS != '2'))))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A07P_21() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('T000')");
      sqlStr.append(" and ((IL_ARCTP = '0'");
      sqlStr.append(" and IL_ARCST in ('2', '3')");
      sqlStr.append(" and convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS != '2'))))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A07P_22() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('U000')");
      sqlStr.append(" and ((IL_ARCTP = '0'");
      sqlStr.append(" and IL_ARCST in ('2', '3')");
      sqlStr.append(" and convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS != '2'))))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A07P_23() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('Y000')");
      sqlStr.append(" and ((IL_ARCTP = '0'");
      sqlStr.append(" and IL_ARCST in ('2', '3')");
      sqlStr.append(" and convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS != '2'))))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A07P_24() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('Z000')");
      sqlStr.append(" and ((IL_ARCTP = '0'");
      sqlStr.append(" and IL_ARCST in ('2', '3')");
      sqlStr.append(" and convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS != '2'))))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A07P_25() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('A000')");
      sqlStr.append(" and ((IL_ARCTP = '0'");
      sqlStr.append(" and IL_ARCST in ('2', '3')");
      sqlStr.append(" and convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS != '2'))))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A07P_26() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('V000','P000')");
      sqlStr.append(" and ((IL_ARCTP = '0'");
      sqlStr.append(" and IL_ARCST in ('2', '3')");
      sqlStr.append(" and convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS != '2'))))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A07P_27() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and ((IL_ARCTP = '0'");
      sqlStr.append(" and IL_ARCST in ('2', '3')");
      sqlStr.append(" and convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS != '2'))))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A08P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_NTCD, IL_SEX, IL_PHQ from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD not in ('035', '061')");
      sqlStr.append(" and ( ( IL_ARCTP='0' and IL_ARCST in ('2', '3') and convert(char(8), IL_ARCTO, 112) >= convert(char(8), getdate(), 112)");
      sqlStr.append("  ) or ( IL_ARCTP='1' and (IL_ARCST='2' or (IL_ARCST='3' and IL_MRKCS!='2')) ) )");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_PHQ", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_NTCD = null;
          String IL_SEX = null;
          String IL_PHQ = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_NTCD = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_SEX = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_PHQ = (String)objArr[2]; 
          bean.setIlSex(IL_SEX);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlPhq(IL_PHQ);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A09P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_ARCRSN, IL_OFNM, IL_ARCNO, IL_PHQ from ILTB_01_MAIN");
      sqlStr.append(" where IL_NTCD <> '035'");
      sqlStr.append(" and IL_NTCD <> '061' ");
      sqlStr.append(" and ((IL_ARCTP = '0' ");
      sqlStr.append(" and convert(char(8), IL_ARCTO, 112) >= convert(char(8), getdate(), 112)");
      sqlStr.append(" and IL_ARCST in ('2', '3'))");
      sqlStr.append(" or (IL_ARCTP = '1'");
      sqlStr.append(" and IL_ARCTP = '1'");
      sqlStr.append(" and (IL_ARCST = '2' ");
      sqlStr.append(" or (IL_ARCST = '3' ");
      sqlStr.append(" and IL_MRKCS <> '2'))))\t");
      sqlStr.append(" ORDER BY IL_PHQ");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_OFNM", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCNO", (Type)Hibernate.STRING);
      q.addScalar("IL_PHQ", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_ARCRSN = null;
          String IL_OFNM = null;
          String IL_ARCNO = null;
          String IL_PHQ = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_ARCRSN = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_OFNM = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCNO = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_PHQ = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlOfnm(IL_OFNM);
          bean.setIlArcno(IL_ARCNO);
          bean.setIlPhq(IL_PHQ);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A10P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A11P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ not in ('Y000','Z000')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A12P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ not in ('V000','W000','Y000','Z000''D000','I000','C000','B000','O000','P000')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A13P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('Y000','Z000')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A14P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ = 'W000'");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A14_2P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ = 'D000'");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A14_3P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('B000','I000')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A14_4P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('C000','O000')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A14_5P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('E000')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A14_6P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('F000')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A14_7P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('G000')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A14_8P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('H000')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A14_9P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('J000')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A14_10P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('K000')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A14_11P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('L000')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A14_12P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('M000')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A14_13P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('N000')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A14_14P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('Q000')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A14_15P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('R000')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A14_16P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('S000')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A14_17P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('T000')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A14_18P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('U000')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A14_19P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('Y000')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A14_20P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('Z000')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A14_21P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('A000')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A15P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and IL_PHQ in ('V000','P000')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A16P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" ORDER BY IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_NTCD = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_NTCD = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCRSN = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_JBCD = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A17P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_ARCRSN, IL_OFNM, IL_ARCNO, IL_PHQ from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" order by IL_PHQ");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_OFNM", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCNO", (Type)Hibernate.STRING);
      q.addScalar("IL_PHQ", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_ARCRSN = null;
          String IL_OFNM = null;
          String IL_ARCNO = null;
          String IL_PHQ = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_ARCRSN = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_OFNM = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCNO = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_PHQ = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlOfnm(IL_OFNM);
          bean.setIlArcno(IL_ARCNO);
          bean.setIlPhq(IL_PHQ);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A18P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_ARCRSN, IL_OFNM, IL_ARCNO, IL_PHQ, IL_NTCD from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" order by IL_PHQ");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_OFNM", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCNO", (Type)Hibernate.STRING);
      q.addScalar("IL_PHQ", (Type)Hibernate.STRING);
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_ARCRSN = null;
          String IL_OFNM = null;
          String IL_ARCNO = null;
          String IL_PHQ = null;
          String IL_NTCD = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_ARCRSN = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_OFNM = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_ARCNO = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_PHQ = (String)objArr[4]; 
          if (!"".equals(objArr[5]) && objArr[5] != null)
            IL_NTCD = (String)objArr[5]; 
          bean.setIlSex(IL_SEX);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlOfnm(IL_OFNM);
          bean.setIlArcno(IL_ARCNO);
          bean.setIlPhq(IL_PHQ);
          bean.setIlNtcd(IL_NTCD);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A19P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_NTCD, IL_SEX, IL_PHQ from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" order by IL_PHQ");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_NTCD", (Type)Hibernate.STRING);
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_PHQ", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_NTCD = null;
          String IL_SEX = null;
          String IL_PHQ = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_NTCD = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_SEX = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_PHQ = (String)objArr[2]; 
          bean.setIlSex(IL_SEX);
          bean.setIlNtcd(IL_NTCD);
          bean.setIlPhq(IL_PHQ);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A29P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_ARCRSN, IL_JBCD, IL_PHQ from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCST = '2'");
      sqlStr.append(" and IL_MRKCS != '2'");
      sqlStr.append(" and IL_NTCD not in ('035', '061')");
      sqlStr.append(" and (IL_ARCTP = '1' or (IL_ARCTP = '0' and convert(char(8),isnull(IL_ARCTO,''),112) >= convert(char(8),getdate(),112)))");
      sqlStr.append(" order by IL_PHQ");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addScalar("IL_SEX", (Type)Hibernate.STRING);
      q.addScalar("IL_BTHDT", (Type)Hibernate.STRING);
      q.addScalar("IL_ARCRSN", (Type)Hibernate.STRING);
      q.addScalar("IL_JBCD", (Type)Hibernate.STRING);
      q.addScalar("IL_PHQ", (Type)Hibernate.STRING);
      List<Object[]> objList = q.list();
      if (objList.size() > 0)
        for (int i = 0; i < objList.size(); i++) {
          Iltb01Main bean = new Iltb01Main();
          String IL_SEX = null;
          String IL_BTHDT = null;
          String IL_ARCRSN = null;
          String IL_JBCD = null;
          String IL_PHQ = null;
          Object[] objArr = objList.get(i);
          if (!"".equals(objArr[0]) && objArr[0] != null)
            IL_SEX = (String)objArr[0]; 
          if (!"".equals(objArr[1]) && objArr[1] != null)
            IL_BTHDT = (String)objArr[1]; 
          if (!"".equals(objArr[2]) && objArr[2] != null)
            IL_ARCRSN = (String)objArr[2]; 
          if (!"".equals(objArr[3]) && objArr[3] != null)
            IL_JBCD = (String)objArr[3]; 
          if (!"".equals(objArr[4]) && objArr[4] != null)
            IL_PHQ = (String)objArr[4]; 
          bean.setIlSex(IL_SEX);
          bean.setIlBthdt(IL_BTHDT);
          bean.setIlArcrsn(IL_ARCRSN);
          bean.setIlJbcd(IL_JBCD);
          bean.setIlPhq(IL_PHQ);
          list.add(i, bean);
        }  
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A22P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * from ILTB_01_MAIN");
      sqlStr.append(" where  IL_ARCCS = '1' ");
      sqlStr.append(" AND IL_PHQ   not in ('V000','W000','Y000','Z000''D000','I000','C000','B000','O000','P000')");
      sqlStr.append(" And (IL_SBMTDT is not NULL) ");
      sqlStr.append(" AND (IL_FNDDT is  NULL or convert(char(6),IL_FNDDT,112) = convert(char(6),dateadd(mm,-1,getdate()),112) )");
      sqlStr.append(" order by IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A22PIsNew() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * FROM ILTB_01_MAIN");
      sqlStr.append(" WHERE IL_PHQ NOT IN ('V000','W000','Y000','Z000''D000','I000','C000','B000','O000','P000')");
      sqlStr.append(" AND IL_ARCCS='1'");
      sqlStr.append(" AND convert(char(6),IL_SBMTDT,112) = convert(char(6),dateadd(mm,-1,getdate()),112)");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A22PIsFound() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * FROM ILTB_01_MAIN");
      sqlStr.append(" WHERE IL_PHQ NOT IN ('V000','W000','Y000','Z000''D000','I000','C000','B000','O000','P000')");
      sqlStr.append(" AND IL_ARCCS='1'");
      sqlStr.append(" AND convert(char(6),IL_FNDDT,112) = convert(char(6),dateadd(mm,-1,getdate()),112)");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A22PIsNow() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * FROM ILTB_01_MAIN");
      sqlStr.append(" WHERE IL_PHQ NOT IN ('V000','W000','Y000','Z000''D000','I000','C000','B000','O000','P000')");
      sqlStr.append(" AND IL_ARCCS='1'");
      sqlStr.append(" AND IL_SBMTDT IS NOT NULL");
      sqlStr.append(" AND IL_FNDDT IS NULL");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A23P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * from ILTB_01_MAIN");
      sqlStr.append(" where  IL_ARCCS = '1' ");
      sqlStr.append(" And (IL_SBMTDT is not NULL) ");
      sqlStr.append(" AND (IL_FNDDT is  NULL or convert(char(6),IL_FNDDT,112) = convert(char(6),dateadd(mm,-1,getdate()),112) )");
      sqlStr.append(" order by IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A23PIsNew() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * FROM ILTB_01_MAIN");
      sqlStr.append(" WHERE IL_ARCCS='1'");
      sqlStr.append(" AND convert(char(6),IL_SBMTDT,112) = convert(char(6),dateadd(mm,-1,getdate()),112)");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A23PIsFound() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * FROM ILTB_01_MAIN");
      sqlStr.append(" WHERE IL_ARCCS='1'");
      sqlStr.append(" AND  convert(char(6),IL_FNDDT,112) = convert(char(6),dateadd(mm,-1,getdate()),112)");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A23PIsNow() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * FROM ILTB_01_MAIN");
      sqlStr.append(" WHERE IL_ARCCS='1'");
      sqlStr.append(" AND IL_SBMTDT IS NOT NULL");
      sqlStr.append(" AND IL_FNDDT IS NULL");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A27P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * from ILTB_01_MAIN");
      sqlStr.append(" WHERE IL_ARCCS = '0'");
      sqlStr.append(" and IL_NTCD <> '035' and IL_NTCD <> '061'");
      sqlStr.append(" and (IL_OFNM like '%夫%' OR IL_OFNM like '%妻%')");
      sqlStr.append(" and ((IL_ARCTP = '0' and convert(char(8), IL_ARCTO, 112) >= convert(char(8), getdate(), 112)");
      sqlStr.append(" and IL_ARCST in ('2', '3'))");
      sqlStr.append(" or (IL_ARCTP = '1' and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS <> '2'))))");
      sqlStr.append(" order by IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A30P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCCS = '0'");
      sqlStr.append(" and IL_NTCD <> '035' and IL_NTCD <> '061'");
      sqlStr.append(" and (IL_OFNM like '%夫%' OR IL_OFNM like '%妻%')");
      sqlStr.append(" and ((IL_ARCTP = '0' and convert(char(8), IL_ARCTO, 112) >= convert(char(8), getdate(), 112)");
      sqlStr.append(" and IL_ARCST in ('2', '3'))");
      sqlStr.append(" or (IL_ARCTP = '1' and (IL_ARCST = '2' or (IL_ARCST = '3' and IL_MRKCS <> '2'))))");
      sqlStr.append(" order by IL_ARCTP");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A28P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCCS = '0' ");
      sqlStr.append(" and IL_NTCD <> '035' and IL_NTCD <> '061' ");
      sqlStr.append(" and (IL_OFNM like '%夫%' OR IL_OFNM like '%妻%')");
      sqlStr.append(" and IL_ARCST = '2' and IL_MRKCS <> '2' ");
      sqlStr.append(" and ((IL_ARCTP = '0' and convert(char(8), IL_ARCTO, 112) >= convert(char(8), getdate(), 112)) or IL_ARCTP = '1')");
      sqlStr.append(" order by IL_ARCTP");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A31P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCCS = '0' ");
      sqlStr.append(" AND IL_PHQ not in ('V000','W000','Y000','Z000''D000','I000','C000','B000','O000','P000') ");
      sqlStr.append(" And (IL_SBMTDT is not NULL) ");
      sqlStr.append(" AND (IL_FNDDT is NULL or convert(char(6),IL_FNDDT,112) = convert(char(6),dateadd(mm,-1,getdate()),112))");
      sqlStr.append(" order by IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A31PIsNew() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * FROM ILTB_01_MAIN");
      sqlStr.append(" WHERE IL_PHQ NOT IN ('V000','W000','Y000','Z000''D000','I000','C000','B000','O000','P000')");
      sqlStr.append(" AND IL_ARCCS='0'");
      sqlStr.append(" AND convert(char(6),IL_SBMTDT,112) = convert(char(6),dateadd(mm,-1,getdate()),112)");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A31PIsFound() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * FROM ILTB_01_MAIN");
      sqlStr.append(" WHERE IL_PHQ NOT IN ('V000','W000','Y000','Z000''D000','I000','C000','B000','O000','P000')");
      sqlStr.append(" AND IL_ARCCS='0'");
      sqlStr.append(" AND convert(char(6),IL_FNDDT,112) = convert(char(6),dateadd(mm,-1,getdate()),112)");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A31PIsNow() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * FROM ILTB_01_MAIN");
      sqlStr.append(" WHERE IL_PHQ NOT IN ('V000','W000','Y000','Z000''D000','I000','C000','B000','O000','P000')");
      sqlStr.append(" AND IL_ARCCS='0'");
      sqlStr.append(" AND IL_SBMTDT IS NOT NULL");
      sqlStr.append(" AND IL_FNDDT IS NULL");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A32P() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCCS = '0' ");
      sqlStr.append(" And (IL_SBMTDT is not NULL) ");
      sqlStr.append(" AND (IL_FNDDT is NULL or convert(char(6),IL_FNDDT,112) = convert(char(6),dateadd(mm,-1,getdate()),112))");
      sqlStr.append(" order by IL_NTCD");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A32PIsNew() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * FROM ILTB_01_MAIN");
      sqlStr.append(" WHERE IL_ARCCS='0'");
      sqlStr.append(" AND convert(char(6),IL_SBMTDT,112) = convert(char(6),dateadd(mm,-1,getdate()),112)");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A32PIsFound() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * FROM ILTB_01_MAIN");
      sqlStr.append(" WHERE IL_ARCCS='0'");
      sqlStr.append(" AND  convert(char(6),IL_FNDDT,112) = convert(char(6),dateadd(mm,-1,getdate()),112)");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08A32PIsNow() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * FROM ILTB_01_MAIN");
      sqlStr.append(" WHERE IL_ARCCS='0'");
      sqlStr.append(" AND IL_SBMTDT IS NOT NULL");
      sqlStr.append(" AND IL_FNDDT IS NULL");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08B01P(String whereCondition) {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * from ILTB_01_MAIN");
      if (whereCondition != null && whereCondition.length() > 0) {
        sqlStr.append(" WHERE ");
        sqlStr.append(whereCondition);
      } 
      System.out.println("sqlStr=" + sqlStr);
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08B02P(String whereCondition) {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * from ILTB_01_MAIN");
      if (whereCondition != null && whereCondition.length() > 0) {
        sqlStr.append(" WHERE ");
        sqlStr.append(whereCondition);
      } 
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08B03P(String whereCondition) {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * from ILTB_01_MAIN");
      if (whereCondition != null && whereCondition.length() > 0) {
        sqlStr.append(" WHERE ");
        sqlStr.append(whereCondition);
      } 
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08B04P(String whereCondition) {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * from ILTB_01_MAIN");
      if (whereCondition != null && whereCondition.length() > 0) {
        sqlStr.append(" WHERE ");
        sqlStr.append(whereCondition);
      } 
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08B05P(String whereCondition) {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * from ILTB_01_MAIN");
      if (whereCondition != null && whereCondition.length() > 0) {
        sqlStr.append(" WHERE ");
        sqlStr.append(whereCondition);
      } 
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08B06P(String whereCondition) {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * from ILTB_01_MAIN");
      if (whereCondition != null && whereCondition.length() > 0) {
        sqlStr.append(" WHERE ");
        sqlStr.append(whereCondition);
      } 
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08B07P(String whereCondition) {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * from ILTB_01_MAIN");
      sqlStr.append(" where IL_ARCRSN < '7'");
      sqlStr.append(" and (IL_ARCST = '2' or IL_ARCST = '3')");
      sqlStr.append(" and IL_NTCD <> '035' and IL_NTCD <> '061'");
      sqlStr.append(" and IL_ARCTO >= convert(char(10), dateadd(dd, -1, convert(char(8), getdate(), 111) + '01'), 111)");
      sqlStr.append(" and IL_FSTAPYDT <= convert(char(10), dateadd(dd, -1, convert(char(8), getdate(), 111) + '01'), 111)");
      if (whereCondition != null && whereCondition.length() > 0) {
        sqlStr.append(" AND ");
        sqlStr.append(whereCondition);
      } 
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb01Main> getIL08C01P(String whereCondition) {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * from ILTB_01_MAIN");
      if (whereCondition != null && whereCondition.length() > 0) {
        sqlStr.append(" WHERE ");
        sqlStr.append(whereCondition);
      } 
      System.out.println("sqlStr=" + sqlStr);
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb01Main.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\report\MyIltb01MainDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */