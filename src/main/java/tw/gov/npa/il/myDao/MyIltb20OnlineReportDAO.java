package tw.gov.npa.il.myDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import tw.gov.npa.il.dao.HibernateSessionFactory;
import tw.gov.npa.il.dao.Iltb20OnlineReport;
import tw.gov.npa.il.dao.Iltb20OnlineReportDAO;

public class MyIltb20OnlineReportDAO extends Iltb20OnlineReportDAO {
  private static final Logger logger = Logger.getLogger(MyIltb20OnlineReportDAO.class);
  
  private DataSource dataSource;
  
  private SimpleDateFormat sdfmt = new SimpleDateFormat("yyyyMMdd");
  
  @Autowired
  private SessionFactory sessionFactory;
  
  public DataSource getDataSource() {
	    return this.dataSource;
	  }
	  
  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }
  
  public void tryToCloseSession() {
    try {
      HibernateSessionFactory.closeSession();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  
  
  public boolean goToMergeTest(Iltb20OnlineReport bean) {
	  logger.info("zxzxzx");
	  logger.info("IlUid----->"+bean.getId().getIlUid());
	  logger.info("IlRptid----->"+bean.getId().getIlRptid());
	  logger.info("IlSnddt----->"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(bean.getId().getIlSnddt()));

	  Session session = null;
	  Transaction tran = null;
	  
	  try {
		session = getSession();
	    StringBuilder sb = new StringBuilder();sb.append(" UPDATE ILTB_20_ONLINE_REPORT SET IL_STATUS ='"+bean.getIlStatus()+"'");
	    sb.append(" WHERE IL_UID = '"+bean.getId().getIlUid()+"'");
	    sb.append(" AND IL_RPTID = '"+bean.getId().getIlRptid()+"'");
	    sb.append(" AND IL_STATUS = '0'");
//	    		  AND CONVERT(CHAR,IL_SNDDT,140) = :sndDt");

	    
	    String querySql = sb.toString();
	    logger.info("querySql----->"+sb.toString());
	    
	    if(null != session) {
	    	logger.info("<------session----->");
	    	tran = session.beginTransaction();
		    Query query = session.createSQLQuery(querySql);
		    query.executeUpdate();
		    tran.commit();
		    session.close();
	   
	      logger.info(new Date() + ":" + "Iltb20OnlineReport資料庫寫入完成");
	    }
	    return true;
    } catch (Exception e) {
      if (tran != null)
        try {
          tran.rollback();
        } catch (Exception ex) {
          ex.printStackTrace();
        }  
      String errorMsg = e.getMessage();
      logger.info(new Date() + ":" + "Iltb20OnlineReport資料庫寫入失敗=" + errorMsg);
      return false;
    
    } finally {
      tryToCloseSession();
    } 
  }
  
  public boolean goToMerge(Iltb20OnlineReport bean) {
	  logger.info("zxzxzx");
    Session session = null;
    Transaction tran = null;
    try {
    	logger.info("cxcxcxcxc");
      session = getSession();
      logger.info("aqaqaq");
      tran = session.beginTransaction();
      logger.info("cxcdededed");
      merge(bean);
      logger.info("erererer");
      tran.commit();
      logger.info("gtgtgtg");
      logger.info(new Date() + ":" + "Iltb20OnlineReport資料庫寫入完成");
      return true;
    } catch (Exception e) {
      if (tran != null)
        try {
          tran.rollback();
        } catch (Exception ex) {
          ex.printStackTrace();
        }  
      String errorMsg = e.getMessage();
      logger.info(new Date() + ":" + "Iltb20OnlineReport資料庫寫入失敗=" + errorMsg);
      return false;
    } finally {
      tryToCloseSession();
    } 
  }
  
  public boolean update(Iltb20OnlineReport bean) {
    Session session = null;
    Transaction tran = null;
    try {
      session = getSession();
      tran = session.beginTransaction();
      save(bean);
      tran.commit();
      System.out.println(new Date() + ":" + "Iltb20OnlineReport資料庫寫入完成");
      return true;
    } catch (Exception e) {
      if (tran != null)
        try {
          tran.rollback();
        } catch (Exception ex) {
          ex.printStackTrace();
        }  
      String errorMsg = e.getMessage();
      System.out.println(new Date() + ":" + "Iltb20OnlineReport資料庫寫入失敗=" + errorMsg);
      return false;
    } finally {
      tryToCloseSession();
    } 
  }
  
  public boolean del(Iltb20OnlineReport bean) {
    Session session = null;
    Transaction tran = null;
    try {
      session = getSession();
      tran = session.beginTransaction();
      delete(bean);
      tran.commit();
      System.out.println(new Date() + ":" + "Iltb20OnlineReport資料庫刪除完成");
      return true;
    } catch (Exception e) {
      if (tran != null)
        try {
          tran.rollback();
        } catch (Exception ex) {
          ex.printStackTrace();
        }  
      String errorMsg = e.getMessage();
      System.out.println(new Date() + ":" + "Iltb20OnlineReport資料庫刪除失敗=" + errorMsg);
      return false;
    } finally {
      tryToCloseSession();
    } 
  }
  
  public boolean updateManyInstance(List<Iltb20OnlineReport> beanList) {
    Session session = null;
    Transaction tran = null;
    try {
      session = getSession();
      tran = session.beginTransaction();
      for (Iltb20OnlineReport bean : beanList)
        save(bean); 
      tran.commit();
      System.out.println(new Date() + ":" + "Iltb20OnlineReport資料庫寫入完成");
      return true;
    } catch (Exception e) {
      if (tran != null)
        try {
          tran.rollback();
        } catch (Exception ex) {
          ex.printStackTrace();
        }  
      String errorMsg = e.getMessage();
      System.out.println(new Date() + ":" + "Iltb20OnlineReport資料庫寫入失敗=" + errorMsg);
      return false;
    } finally {
      tryToCloseSession();
    } 
  }
  
  public boolean delManyInstance(List<Iltb20OnlineReport> beanList) {
    Session session = null;
    Transaction tran = null;
    try {
      session = getSession();
      tran = session.beginTransaction();
      for (Iltb20OnlineReport bean : beanList)
        delete(bean); 
      tran.commit();
      System.out.println(new Date() + ":" + "Iltb20OnlineReport資料庫刪除完成");
      return true;
    } catch (Exception e) {
      if (tran != null)
        try {
          tran.rollback();
        } catch (Exception ex) {
          ex.printStackTrace();
        }  
      String errorMsg = e.getMessage();
      System.out.println(new Date() + ":" + "Iltb20OnlineReport資料庫刪除失敗=" + errorMsg);
      return false;
    } finally {
      tryToCloseSession();
    } 
  }
  
  public List<Iltb20OnlineReport> queryDataIL03B01UnProcess() {
    List<Iltb20OnlineReport> list = new ArrayList<Iltb20OnlineReport>();
    try {
    	logger.info("QQQQQQ");
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("SELECT * FROM ILTB_20_ONLINE_REPORT WHERE IL_STATUS = '0' AND IL_RPTID IN ('01','02','03','04','05','06') ORDER BY IL_RPTID");
      logger.info(sqlStr.toString());
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      logger.info("SSSSSSS");
      q.addEntity(Iltb20OnlineReport.class);
      
      list = q.list();
      logger.info("DDDDDDDSSSSSSS");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb20OnlineReport> queryDataB01UnProcess() {
    List<Iltb20OnlineReport> list = new ArrayList<Iltb20OnlineReport>();
    try {
    	logger.info("RRRRRR");
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append(" SELECT * FROM ILTB_20_ONLINE_REPORT ");
      sqlStr.append(" WHERE IL_STATUS = '0'");
      sqlStr.append(" AND IL_RPTID in ('11','12','13','14','15','16','17','18','19','20','21','22')");
      sqlStr.append(" ORDER BY IL_RPTID");
      logger.info(sqlStr.toString());
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb20OnlineReport.class);
      list = q.list();
      logger.info(Integer.valueOf(list.size()));
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb20OnlineReport> queryDataIL03ByLogUId(String LOGUID) {
    List<Iltb20OnlineReport> list = new ArrayList<Iltb20OnlineReport>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append(" SELECT * FROM ILTB_20_ONLINE_REPORT");
      sqlStr.append(" WHERE IL_UID = '" + LOGUID + "'");
      sqlStr.append(" AND IL_RPTID in ('01','02','03','04','05','06')");
      sqlStr.append(" ORDER BY IL_RPTID, IL_SNDDT DESC");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb20OnlineReport.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
  
  public List<Iltb20OnlineReport> queryDataByLogUId(String LOGUID) {
    List<Iltb20OnlineReport> list = new ArrayList<Iltb20OnlineReport>();
    try {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append(" SELECT * FROM ILTB_20_ONLINE_REPORT");
      sqlStr.append(" WHERE IL_UID = '" + LOGUID + "'");
      sqlStr.append(" AND IL_RPTID in ('11','12','13','14','15','16','17','18','19','21','22')");
      sqlStr.append(" ORDER BY IL_RPTID, IL_SNDDT DESC");
      SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
      q.addEntity(Iltb20OnlineReport.class);
      list = q.list();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      tryToCloseSession();
    } 
    return list;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\myDao\MyIltb20OnlineReportDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */