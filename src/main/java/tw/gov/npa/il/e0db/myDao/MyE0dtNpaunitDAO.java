package tw.gov.npa.il.e0db.myDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tw.gov.npa.il.e0db.dao.E0dtNpaunit;
import tw.gov.npa.il.e0db.dao.E0dtNpaunitDAO;
import tw.gov.npa.il.e0db.dao.HibernateSessionFactoryE0DB;

public class MyE0dtNpaunitDAO extends E0dtNpaunitDAO {
  private static final Logger logger = Logger.getLogger(MyE0dtNpaunitDAO.class);
  
  public void tryToCloseSession() {
    try {
      HibernateSessionFactoryE0DB.getSession().close();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public boolean updateData(E0dtNpaunit bean) {
    Session session = null;
    Transaction tran = null;
    try {
      session = getSession();
      tran = session.beginTransaction();
      save(bean);
      tran.commit();
      System.out.println(new Date() + ":" + "E0dtNpaunit資料庫寫入完成");
      return true;
    } catch (Exception e) {
      if (tran != null)
        try {
          tran.rollback();
        } catch (Exception ex) {
          ex.printStackTrace();
        }  
      String errorMsg = e.getMessage();
      System.out.println(new Date() + ":" + "E0dtNpaunit資料庫寫入失敗=" + errorMsg);
      return false;
    } finally {
      tryToCloseSession();
    } 
  }
  
  public boolean delData(E0dtNpaunit bean) {
    Session session = null;
    Transaction tran = null;
    try {
      session = getSession();
      tran = session.beginTransaction();
      delete(bean);
      tran.commit();
      System.out.println(new Date() + ":" + "E0dtNpaunit資料庫刪除完成");
      return true;
    } catch (Exception e) {
      if (tran != null)
        try {
          tran.rollback();
        } catch (Exception ex) {
          ex.printStackTrace();
        }  
      String errorMsg = e.getMessage();
      System.out.println(new Date() + ":" + "E0dtNpaunit資料庫刪除失敗=" + errorMsg);
      return false;
    } finally {
      tryToCloseSession();
    } 
  }
  
  public List<E0dtNpaunit> getDataByE0UnitFlag(String e0UnitFlag, String e0UnitCd) {
    List<E0dtNpaunit> list = new ArrayList<E0dtNpaunit>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * FROM E0DT_NPAUNIT ");
      sqlStr.append(" WHERE E0_UNIT_FLAG in ('" + e0UnitFlag + "')");
      if (!"".equals(e0UnitCd))
        sqlStr.append(" AND E0_UNIT_CD in ('" + e0UnitCd + "')"); 
      sqlStr.append(" ORDER BY E0_UNIT_CD");
      SQLQuery q = HibernateSessionFactoryE0DB.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(E0dtNpaunit.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\e0db\myDao\MyE0dtNpaunitDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */