package tw.gov.npa.il.myDao;

import java.util.Date;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tw.gov.npa.il.dao.HibernateSessionFactory;
import tw.gov.npa.il.dao.IltbFunc;
import tw.gov.npa.il.dao.IltbFuncDAO;

public class MyIltbFuncDAO extends IltbFuncDAO {
  private static final Logger logger = Logger.getLogger(MyIltbFuncDAO.class);
  
  public void tryToCloseSession() {
    try {
      HibernateSessionFactory.getSession().close();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public boolean updateIltbFunc(IltbFunc iltbFunc) {
    Session session = null;
    Transaction tran = null;
    try {
      session = getSession();
      tran = session.beginTransaction();
      save(iltbFunc);
      tran.commit();
      System.out.println(new Date() + ":" + "iltbFunc資料庫寫入完成");
      return true;
    } catch (Exception e) {
      if (tran != null)
        try {
          tran.rollback();
        } catch (Exception ex) {
          ex.printStackTrace();
        }  
      String errorMsg = e.getMessage();
      System.out.println(new Date() + ":" + "iltbFunc資料庫寫入失敗=" + errorMsg);
      return false;
    } finally {
      tryToCloseSession();
    } 
  }
  
  public boolean delIltbFunc(IltbFunc iltbFunc) {
    Session session = null;
    Transaction tran = null;
    try {
      session = getSession();
      tran = session.beginTransaction();
      delete(iltbFunc);
      tran.commit();
      System.out.println(new Date() + ":" + "iltbFunc資料庫刪除完成");
      return true;
    } catch (Exception e) {
      if (tran != null)
        try {
          tran.rollback();
        } catch (Exception ex) {
          ex.printStackTrace();
        }  
      String errorMsg = e.getMessage();
      System.out.println(new Date() + ":" + "iltbFunc資料庫刪除失敗=" + errorMsg);
      return false;
    } finally {
      tryToCloseSession();
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\myDao\MyIltbFuncDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */