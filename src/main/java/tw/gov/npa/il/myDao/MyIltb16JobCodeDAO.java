package tw.gov.npa.il.myDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tw.gov.npa.il.dao.HibernateSessionFactory;
import tw.gov.npa.il.dao.Iltb16JobCode;
import tw.gov.npa.il.dao.Iltb16JobCodeDAO;

public class MyIltb16JobCodeDAO extends Iltb16JobCodeDAO {
  private static final Logger logger = Logger.getLogger(MyIltb16JobCodeDAO.class);
  
  public void tryToCloseSession() {
    try {
      HibernateSessionFactory.getSession().close();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public boolean updateData(Iltb16JobCode bean) {
    Session session = null;
    Transaction tran = null;
    try {
      session = getSession();
      tran = session.beginTransaction();
      save(bean);
      tran.commit();
      System.out.println(new Date() + ":" + "Iltb16JobCode資料庫寫入完成");
      return true;
    } catch (Exception e) {
      if (tran != null)
        try {
          tran.rollback();
        } catch (Exception ex) {
          ex.printStackTrace();
        }  
      String errorMsg = e.getMessage();
      System.out.println(new Date() + ":" + "Iltb16JobCode資料庫寫入失敗=" + errorMsg);
      return false;
    } finally {
      tryToCloseSession();
    } 
  }
  
  public boolean delData(Iltb16JobCode bean) {
    Session session = null;
    Transaction tran = null;
    try {
      session = getSession();
      tran = session.beginTransaction();
      delete(bean);
      tran.commit();
      System.out.println(new Date() + ":" + "Iltb16JobCode資料庫刪除完成");
      return true;
    } catch (Exception e) {
      if (tran != null)
        try {
          tran.rollback();
        } catch (Exception ex) {
          ex.printStackTrace();
        }  
      String errorMsg = e.getMessage();
      System.out.println(new Date() + ":" + "Iltb16JobCode資料庫刪除失敗=" + errorMsg);
      return false;
    } finally {
      tryToCloseSession();
    } 
  }
  
  public boolean updateManyInstance(List<Iltb16JobCode> beanList) {
    Session session = null;
    Transaction tran = null;
    try {
      session = getSession();
      tran = session.beginTransaction();
      for (Iltb16JobCode bean : beanList)
        save(bean); 
      tran.commit();
      System.out.println(new Date() + ":" + "Iltb16JobCode資料庫寫入完成");
      return true;
    } catch (Exception e) {
      if (tran != null)
        try {
          tran.rollback();
        } catch (Exception ex) {
          ex.printStackTrace();
        }  
      String errorMsg = e.getMessage();
      System.out.println(new Date() + ":" + "Iltb16JobCode資料庫寫入失敗=" + errorMsg);
      return false;
    } finally {
      tryToCloseSession();
    } 
  }
  
  public boolean delManyInstance(List<Iltb16JobCode> beanList) {
    Session session = null;
    Transaction tran = null;
    try {
      session = getSession();
      tran = session.beginTransaction();
      for (Iltb16JobCode bean : beanList)
        delete(bean); 
      tran.commit();
      System.out.println(new Date() + ":" + "Iltb16JobCode資料庫刪除完成");
      return true;
    } catch (Exception e) {
      if (tran != null)
        try {
          tran.rollback();
        } catch (Exception ex) {
          ex.printStackTrace();
        }  
      String errorMsg = e.getMessage();
      System.out.println(new Date() + ":" + "Iltb16JobCode資料庫刪除失敗=" + errorMsg);
      return false;
    } finally {
      tryToCloseSession();
    } 
  }
  
  public List<Iltb16JobCode> getDataByIlNtprsq() {
    List<Iltb16JobCode> list = new ArrayList<Iltb16JobCode>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * FROM ILTB_16_JOB_CODE");
      sqlStr.append(" ORDER BY IL_OPPRSQ");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb16JobCode.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\myDao\MyIltb16JobCodeDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */