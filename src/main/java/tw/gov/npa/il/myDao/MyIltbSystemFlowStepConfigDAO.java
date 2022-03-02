package tw.gov.npa.il.myDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tw.gov.npa.il.dao.HibernateSessionFactory;
import tw.gov.npa.il.dao.IltbSystemFlowStepConfig;
import tw.gov.npa.il.dao.IltbSystemFlowStepConfigDAO;

public class MyIltbSystemFlowStepConfigDAO extends IltbSystemFlowStepConfigDAO {
  private static final Logger logger = Logger.getLogger(MyIltbSystemFlowStepConfigDAO.class);
  
  public void tryToCloseSession() {
    try {
      HibernateSessionFactory.getSession().close();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public boolean update(IltbSystemFlowStepConfig bean) {
    Session session = null;
    Transaction tran = null;
    try {
      session = getSession();
      tran = session.beginTransaction();
      save(bean);
      tran.commit();
      System.out.println(new Date() + ":" + "IltbSystemFlowStepConfig資料庫寫入完成");
      return true;
    } catch (Exception e) {
      if (tran != null)
        try {
          tran.rollback();
        } catch (Exception ex) {
          ex.printStackTrace();
        }  
      String errorMsg = e.getMessage();
      System.out.println(new Date() + ":" + "IltbSystemFlowStepConfig資料庫寫入失敗=" + errorMsg);
      return false;
    } finally {
      tryToCloseSession();
    } 
  }
  
  public boolean del(IltbSystemFlowStepConfig bean) {
    Session session = null;
    Transaction tran = null;
    try {
      session = getSession();
      tran = session.beginTransaction();
      delete(bean);
      tran.commit();
      System.out.println(new Date() + ":" + "IltbSystemFlowStepConfig資料庫刪除完成");
      return true;
    } catch (Exception e) {
      if (tran != null)
        try {
          tran.rollback();
        } catch (Exception ex) {
          ex.printStackTrace();
        }  
      String errorMsg = e.getMessage();
      System.out.println(new Date() + ":" + "IltbSystemFlowStepConfig資料庫刪除失敗=" + errorMsg);
      return false;
    } finally {
      tryToCloseSession();
    } 
  }
  
  public List<IltbSystemFlowStepConfig> searchByIlFunc(String ilFunc) {
    List<IltbSystemFlowStepConfig> list = new ArrayList<IltbSystemFlowStepConfig>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * FROM ILTB_SYSTEM_FLOW_STEP_CONFIG");
      sqlStr.append(" WHERE IL_FUNC='" + ilFunc + "'");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(IltbSystemFlowStepConfig.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<IltbSystemFlowStepConfig> searchByIlFunctag(String ilFunctag) {
    List<IltbSystemFlowStepConfig> list = new ArrayList<IltbSystemFlowStepConfig>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * FROM ILTB_SYSTEM_FLOW_STEP_CONFIG");
      sqlStr.append(" WHERE IL_FUNCTAG='" + ilFunctag + "'");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(IltbSystemFlowStepConfig.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<IltbSystemFlowStepConfig> searchByIlIndexid(String ilIndexid) {
    List<IltbSystemFlowStepConfig> list = new ArrayList<IltbSystemFlowStepConfig>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * FROM ILTB_SYSTEM_FLOW_STEP_CONFIG");
      sqlStr.append(" WHERE IL_INDEXID like '%" + ilIndexid + "%'");
      sqlStr.append(" AND IL_FUNCTAG = '1'");
      sqlStr.append(" ORDER BY IL_INDEXID DESC");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(IltbSystemFlowStepConfig.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\myDao\MyIltbSystemFlowStepConfigDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */