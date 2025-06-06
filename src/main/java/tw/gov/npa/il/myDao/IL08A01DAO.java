package tw.gov.npa.il.myDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

public class IL08A01DAO {
  private static final Logger logger = Logger.getLogger(IL08A01DAO.class);
  
  private SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
  
  private Date current = new Date();
  
  public DataSource dataSource;
  
//  ResourceBundle rb = ResourceBundle.getBundle("config");

  //	private String contextPath = this.rb.getString("ReportRoot").toString();
  private String contextPath = "ReportRoot=D\\:\\IL2\\";

  public DataSource getDataSource() {
    return this.dataSource;
  }
  
  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }
  
  public boolean queryData(String s) {
    JdbcTemplate queryd = new JdbcTemplate(this.dataSource);
    try {
      Connection conn = this.dataSource.getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT COUNT(*) as cnt FROM ILTB_01_MAIN WHERE IL_ARCNO='" + s + "'");
      rs.next();
      int rsltcnt = rs.getInt("cnt");
      conn.close();
      if (rsltcnt > 0)
        return true; 
    } catch (Exception ex) {}
    return false;
  }
  
  public int queryImgbyIdnoseq(String s, String idseq) {
    int count = -1;
    JdbcTemplate queryd = new JdbcTemplate(this.dataSource);
    count = queryd.queryForInt("SELECT COUNT(*) FROM ILTB_23_IMG_IDX WHERE IL_IDNO='" + s + "' AND IL_IDSEQ='" + idseq + "'");
    return count;
  }
  
  public int queryImg(String s) {
    int count = -1;
    JdbcTemplate queryd = new JdbcTemplate(this.dataSource);
    count = queryd.queryForInt("SELECT COUNT(*) FROM ILTB_23_IMG_IDX WHERE IL_IDNO='" + s + "' ");
    return count;
  }
  
  public void updateImg(String fileName) {
    String idNo = fileName.substring(0, 10);
    JdbcTemplate updated = new JdbcTemplate(this.dataSource);
    try {
      Connection conn = this.dataSource.getConnection();
      PreparedStatement pstmt = conn.prepareStatement("UPDATE ILTB_23_IMG_IDX SET IL_MODIFIED =? WHERE IL_IDSEQ='1' AND IL_IDNO=?");
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      pstmt.setString(1, sdf.format(new Date()));
      pstmt.setString(2, idNo);
      pstmt.executeUpdate();
      conn.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    } 
  }
  
  public void insertIMG(String fileName, String finalPath, String path, String idSeq) {
    String idNo = fileName.substring(0, 10);
    String sql = "SELECT count(*) as cnt FROM ILTB_01_MAIN WHERE IL_ARCNO='" + idNo + "'";
    int rowsize = 0;
    try {
      Connection conn = this.dataSource.getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      if (rs.next())
        rowsize = rs.getInt("cnt"); 
      conn.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    } 
    if (rowsize == 1) {
      try {
        Connection conn = this.dataSource.getConnection();
        Statement stmt = conn.createStatement();
        sql = "SELECT * FROM ILTB_01_MAIN WHERE IL_ARCNO='" + idNo + "'";
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO ILTB_23_IMG_IDX (IL_IMGID,IL_IDNO,IL_IDSEQ,IL_NAME,IL_BTHDT,IL_NTCD,IL_UNC,IL_URL,IL_AP,IL_MODIFIED) VALUES(?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, "1");
        ps.setString(2, idNo);
        ps.setString(3, idSeq);
        ps.setString(4, rs.getString("IL_ENM"));
        ps.setString(5, rs.getString("IL_BTHDT"));
        ps.setString(6, rs.getString("IL_NTCD"));
        ps.setString(7, finalPath + fileName);
        ps.setString(8, "IL2.eportal.npa.gov.tw" + path.replace('\\', '/') + fileName);
        ps.setString(9, "IL2");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        ps.setString(10, sdf.format(new Date()));
        ps.executeUpdate();
        conn.close();
      } catch (Exception ex) {
        ex.printStackTrace();
      } 
    } else {
      logger.info("回傳多筆居留資料!! ");
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\myDao\IL08A01DAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */