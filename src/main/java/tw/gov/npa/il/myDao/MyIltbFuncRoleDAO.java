package tw.gov.npa.il.myDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tw.gov.npa.il.dao.HibernateSessionFactory;
import tw.gov.npa.il.dao.IltbFuncRole;
import tw.gov.npa.il.dao.IltbFuncRoleDAO;

public class MyIltbFuncRoleDAO extends IltbFuncRoleDAO {
  private static final Logger logger = Logger.getLogger(MyIltbFuncRoleDAO.class);
  
  public void tryToCloseSession() {
    try {
      HibernateSessionFactory.getSession().close();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public boolean updateIltbFuncRole(IltbFuncRole bean) {
    Session session = null;
    Transaction tran = null;
    try {
      session = getSession();
      tran = session.beginTransaction();
      save(bean);
      tran.commit();
      System.out.println(new Date() + ":" + "IltbFuncRole資料庫寫入完成");
      return true;
    } catch (Exception e) {
      if (tran != null)
        try {
          tran.rollback();
        } catch (Exception ex) {
          ex.printStackTrace();
        }  
      String errorMsg = e.getMessage();
      System.out.println(new Date() + ":" + "IltbFuncRole資料庫寫入失敗=" + errorMsg);
      return false;
    } finally {
      tryToCloseSession();
    } 
  }
  
  public boolean del(IltbFuncRole bean) {
    Session session = null;
    Transaction tran = null;
    try {
      session = getSession();
      tran = session.beginTransaction();
      delete(bean);
      tran.commit();
      System.out.println(new Date() + ":" + "IltbFuncRole資料庫刪除完成");
      return true;
    } catch (Exception e) {
      if (tran != null)
        try {
          tran.rollback();
        } catch (Exception ex) {
          ex.printStackTrace();
        }  
      String errorMsg = e.getMessage();
      System.out.println(new Date() + ":" + "IltbFuncRole資料庫刪除失敗=" + errorMsg);
      return false;
    } finally {
      tryToCloseSession();
    } 
  }
  
  public List<IltbFuncRole> searchByIlFuncNo(int IlFuncNo) {
    List<IltbFuncRole> list = new ArrayList<IltbFuncRole>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * FROM ILTB_FUNC_ROLE");
      sqlStr.append(" WHERE IL_FUNC_NO=" + IlFuncNo);
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(IltbFuncRole.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\myDao\MyIltbFuncRoleDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */