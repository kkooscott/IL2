package tw.gov.npa.il.myDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tw.gov.npa.il.dao.HibernateSessionFactory;
import tw.gov.npa.il.dao.IltbAnnounce;
import tw.gov.npa.il.dao.IltbAnnounceDAO;

public class MyIltbAnnounceDAO extends IltbAnnounceDAO {
  private static final Logger logger = Logger.getLogger(MyIltbAnnounceDAO.class);
  
  public void tryToCloseSession() {
    try {
      HibernateSessionFactory.getSession().close();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public boolean update(IltbAnnounce bean) {
    Session session = null;
    Transaction tran = null;
    try {
      session = getSession();
      tran = session.beginTransaction();
      save(bean);
      tran.commit();
      System.out.println(new Date() + ":" + "IltbAnnounce資料庫寫入完成");
      return true;
    } catch (Exception e) {
      if (tran != null)
        try {
          tran.rollback();
        } catch (Exception ex) {
          ex.printStackTrace();
        }  
      String errorMsg = e.getMessage();
      System.out.println(new Date() + ":" + "IltbAnnounce資料庫寫入失敗=" + errorMsg);
      return false;
    } finally {
      tryToCloseSession();
    } 
  }
  
  public boolean del(IltbAnnounce bean) {
    Session session = null;
    Transaction tran = null;
    try {
      session = getSession();
      tran = session.beginTransaction();
      delete(bean);
      tran.commit();
      System.out.println(new Date() + ":" + "IltbAnnounce資料庫刪除完成");
      return true;
    } catch (Exception e) {
      if (tran != null)
        try {
          tran.rollback();
        } catch (Exception ex) {
          ex.printStackTrace();
        }  
      String errorMsg = e.getMessage();
      System.out.println(new Date() + ":" + "IltbAnnounce資料庫刪除失敗=" + errorMsg);
      return false;
    } finally {
      tryToCloseSession();
    } 
  }
  
  public List<IltbAnnounce> searchByQueryMethod(String kind, String beginDate, String endDate) {
    List<IltbAnnounce> list = new ArrayList<IltbAnnounce>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      if (kind.equals("0")) {
        sqlStr.append("SELECT * FROM ILTB_ANNOUNCE  ");
        if (!"".equals(beginDate) && beginDate != null)
          sqlStr.append("WHERE IL_BEGIN_DT >= '" + beginDate + "'"); 
        if (!"".equals(endDate) && endDate != null)
          sqlStr.append(" AND IL_END_DT <= '" + endDate + "'"); 
      } else {
        sqlStr.append("SELECT * FROM ILTB_ANNOUNCE");
        sqlStr.append(" WHERE IL_KIND='" + kind + "'");
        if (!"".equals(beginDate) && beginDate != null)
          sqlStr.append(" AND IL_BEGIN_DT >= '" + beginDate + "'"); 
        if (!"".equals(endDate) && endDate != null)
          sqlStr.append(" AND IL_END_DT <= '" + endDate + "'"); 
      } 
      System.out.println("sqlStr=" + sqlStr);
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(IltbAnnounce.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\myDao\MyIltbAnnounceDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */