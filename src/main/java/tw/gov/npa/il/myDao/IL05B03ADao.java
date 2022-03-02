package tw.gov.npa.il.myDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import tw.gov.npa.il.action.bean.IL05B03ABean;
import tw.gov.npa.il.dao.Iltb18DataProcessResult;
import tw.gov.npa.il.dao.Iltb18DataProcessResultId;
import tw.gov.npa.il.util.CVUtil;

public class IL05B03ADao {
  private static final Logger logger = Logger.getLogger(IL05B03ADao.class);
  
  private SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
  
  private Date current = new Date();
  
  private DataSource dataSource;
  
  private SimpleDateFormat sdfmt = new SimpleDateFormat("yyyyMMdd");
  
  private List<IL05B03ABean> queryList = new ArrayList<IL05B03ABean>();
  
  private ArrayList<Iltb18DataProcessResult> queryLogList = new ArrayList<Iltb18DataProcessResult>();
  
  public DataSource getDataSource() {
    return this.dataSource;
  }
  
  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }
  
  public List<IL05B03ABean> getList(Date date) {
    String sdate = this.sdfmt.format(date);
    logger.info(this.dataSource);
    JdbcTemplate queryd = new JdbcTemplate(this.dataSource);
    queryd.query(
        "SELECT IL_ARCID,  IL_PTRLDT, IL_PTRLST, isnull(IL_PTRLMRK,'') IL_PTRLMRK, IL_UID, IL_UNM,  IL_LMD, IL_MANTYPE  FROM ILTB_04_IN_RECORD WHERE IL_ARCID IN(SELECT DISTINCT IL_ARCID FROM ILTB_04_IN_RECORD WHERE IL_LMD='" + 
        
        sdate + "') order by IL_ARCID", 
        
        new RowCallbackHandler() {
          public void processRow(ResultSet rs) throws SQLException {
            IL05B03ABean il05b03 = new IL05B03ABean();
            il05b03.setIlArcid(Integer.valueOf(Integer.parseInt(rs
                    .getString("IL_ARCID"))));
            il05b03.setIlPtrldt(Timestamp.valueOf(rs
                  .getString("IL_PTRLDT")));
            il05b03.setIlPtrlst(rs.getString("IL_PTRLST"));
            il05b03.setIlPtrlmrk(rs.getString("IL_PTRLMRK"));
            il05b03.setIlUid(rs.getString("IL_UID"));
            il05b03.setIlUnm(rs.getString("IL_UNM"));
            il05b03.setIlLmd(Timestamp.valueOf(rs
                  .getString("IL_LMD")));
            il05b03.setIlMantype(rs.getString("IL_MANTYPE"));
            IL05B03ADao.this.queryList.add(il05b03);
          }
        });
    return this.queryList;
  }
  
  private String dateConvert(String convertNumber, String type) {
    int value = Integer.parseInt(convertNumber);
    if (value < 10)
      return Integer.toString(value); 
    if (type.equals("year"))
      return convertNumber.substring(2, 4); 
    if (type.equals("month")) {
      switch (value) {
        case 10:
          return "A";
        case 11:
          return "B";
        case 12:
          return "C";
      } 
      return null;
    } 
    if (type.equals("day")) {
      switch (value) {
        case 10:
          return "A";
        case 11:
          return "B";
        case 12:
          return "C";
        case 13:
          return "D";
        case 14:
          return "E";
        case 15:
          return "F";
        case 16:
          return "G";
        case 17:
          return "H";
        case 18:
          return "I";
        case 19:
          return "J";
        case 20:
          return "K";
        case 21:
          return "L";
        case 22:
          return "M";
        case 23:
          return "N";
        case 24:
          return "O";
        case 25:
          return "P";
        case 26:
          return "Q";
        case 27:
          return "R";
        case 28:
          return "S";
        case 29:
          return "T";
        case 30:
          return "U";
        case 31:
          return "V";
      } 
      return null;
    } 
    return null;
  }
  
  public void updateStatusBykey(String date, String type, String userid) throws ParseException {
    JdbcTemplate updated = new JdbcTemplate(this.dataSource);
    StringBuilder sb = new StringBuilder();
    Date tdate = this.sdfmt.parse(date);
    Object[] params = new Object[4];
    params[0] = new Date();
    params[1] = userid;
    params[2] = "T";
    params[3] = tdate;
    sb.append("UPDATE ILTB_18_DATA_PROCESS_RESULT SET IL_IMPST='0',IL_MODIFIED=?,IL_IMPUID=? WHERE IL_IMPTP=? AND IL_IMPDT=?");
    updated.update(sb.toString(), params);
  }
  
  public ArrayList<Iltb18DataProcessResult> queryByDate(String date, String user) {
    this.queryList.clear();
    JdbcTemplate query = new JdbcTemplate(this.dataSource);
    Object[] params = new Object[3];
    Date sDate = null;
    Date eDate = null;
    try {
      sDate = CVUtil.getStringToDateTime(String.valueOf(date) + "000000000");
      eDate = CVUtil.getStringToDateTime(String.valueOf(date) + "235959000");
    } catch (ParseException e) {
      e.printStackTrace();
    } 
    params[0] = sDate;
    params[1] = eDate;
    params[2] = user;
    query.query(
        "SELECT * FROM ILTB_18_DATA_PROCESS_RESULT WHERE IL_IMPTP='T' AND IL_IMPDT BETWEEN ? AND ? AND IL_IMPUID=?", 
        params, new RowCallbackHandler() {
          public void processRow(ResultSet rs) throws SQLException {
            Iltb18DataProcessResult iltb18DataProcessResult = new Iltb18DataProcessResult();
            Iltb18DataProcessResultId iltb18DataProcessResultId = new Iltb18DataProcessResultId();
            iltb18DataProcessResultId.setIlImpdt(rs
                .getTimestamp("IL_IMPDT"));
            iltb18DataProcessResultId.setIlImptp(rs
                .getString("IL_IMPTP"));
            iltb18DataProcessResult
              .setId(iltb18DataProcessResultId);
            iltb18DataProcessResult.setIlImpst(rs
                .getString("IL_IMPST"));
            iltb18DataProcessResult.setIlImpuid(rs
                .getString("IL_IMPUID"));
            iltb18DataProcessResult.setIlImpfl(rs
                .getString("IL_IMPFL"));
            iltb18DataProcessResult.setIlImptot(
                Integer.valueOf(rs.getInt("IL_IMPTOT")));
            iltb18DataProcessResult.setIlImpok(
                Integer.valueOf(rs.getInt("IL_IMPOK")));
            iltb18DataProcessResult.setIlImpmsg(rs
                .getString("IL_IMPMSG"));
            iltb18DataProcessResult.setIlModified(rs
                .getTimestamp("IL_MODIFIED"));
            iltb18DataProcessResult.setIlErrtp0(
                Integer.valueOf(rs.getInt("IL_ERRTP0")));
            iltb18DataProcessResult.setIlErrtp1(
                Integer.valueOf(rs.getInt("IL_ERRTP1")));
            iltb18DataProcessResult.setIlErrtp2(
                Integer.valueOf(rs.getInt("IL_ERRTP2")));
            iltb18DataProcessResult.setIlErrtp3(
                Integer.valueOf(rs.getInt("IL_ERRTP3")));
            iltb18DataProcessResult.setIlErrtp4(
                Integer.valueOf(rs.getInt("IL_ERRTP4")));
            iltb18DataProcessResult.setIlErrtp5(
                Integer.valueOf(rs.getInt("IL_ERRTP5")));
            iltb18DataProcessResult.setIlErrtp6(
                Integer.valueOf(rs.getInt("IL_ERRTP6")));
            iltb18DataProcessResult.setIlErrtp7(
                Integer.valueOf(rs.getInt("IL_ERRTP7")));
            iltb18DataProcessResult.setIlErrtp8(
                Integer.valueOf(rs.getInt("IL_ERRTP8")));
            iltb18DataProcessResult.setIlErrtp9(
                Integer.valueOf(rs.getInt("IL_ERRTP9")));
            IL05B03ADao.this.queryLogList.add(iltb18DataProcessResult);
          }
        });
    return this.queryLogList;
  }
  
  public int queryCountbyKey(String date, String type) throws ParseException {
    JdbcTemplate queryd = new JdbcTemplate(this.dataSource);
    StringBuilder sb = new StringBuilder();
    Date tdate = this.sdfmt.parse(date);
    Object[] params = new Object[2];
    params[0] = type;
    params[1] = tdate;
    sb.append("SELECT COUNT(*) FROM ILTB_18_DATA_PROCESS_RESULT WHERE IL_IMPTP=? AND IL_IMPDT=?");
    return queryd.queryForInt(sb.toString(), params);
  }
  
  public Date insertLog(String user, String date) throws ParseException {
    Date processDate = new Date();
    JdbcTemplate insertd = new JdbcTemplate(this.dataSource);
    StringBuilder sb = new StringBuilder();
    String fileName = "IL7A" + dateConvert(date, "year") + 
      dateConvert(date.substring(4, 6), "month") + 
      dateConvert(date.substring(6, 8), "day");
    Date tdate = this.sdfmt.parse(date);
    Date sysDate = new Date();
    sb.append("INSERT INTO ILTB_18_DATA_PROCESS_RESULT ( IL_IMPDT,IL_IMPTP, IL_IMPST, IL_IMPUID, IL_IMPFL, IL_IMPTOT, IL_IMPOK,IL_ERRTP1, IL_ERRTP2, IL_ERRTP3, IL_ERRTP4, IL_ERRTP5, IL_ERRTP6, IL_ERRTP7, IL_ERRTP8, IL_ERRTP9,IL_ERRTP0, IL_IMPMSG,IL_MODIFIED )values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,NULL,?)");
    Object[] params = new Object[18];
    params[0] = processDate;
    params[1] = "T";
    params[2] = "0";
    params[3] = user;
    params[4] = fileName;
    params[5] = Integer.valueOf(0);
    params[6] = Integer.valueOf(0);
    params[7] = Integer.valueOf(0);
    params[8] = Integer.valueOf(0);
    params[9] = Integer.valueOf(0);
    params[10] = Integer.valueOf(0);
    params[11] = Integer.valueOf(0);
    params[12] = Integer.valueOf(0);
    params[13] = Integer.valueOf(0);
    params[14] = Integer.valueOf(0);
    params[15] = Integer.valueOf(0);
    params[16] = Integer.valueOf(0);
    params[17] = processDate;
    insertd.update(sb.toString(), params);
    return processDate;
  }
  
  public ArrayList<Iltb18DataProcessResult> queryByKey(Iltb18DataProcessResultId iltb18DataProcessResultId) {
    this.queryList.clear();
    JdbcTemplate query = new JdbcTemplate(this.dataSource);
    Object[] params = new Object[2];
    params[0] = iltb18DataProcessResultId.getIlImpdt();
    params[1] = iltb18DataProcessResultId.getIlImptp();
    query.query(
        "SELECT * FROM ILTB_18_DATA_PROCESS_RESULT WHERE IL_IMPDT=? AND IL_IMPTP=? AND IL_IMPTP='T'", 
        params, new RowCallbackHandler() {
          public void processRow(ResultSet rs) throws SQLException {
            Iltb18DataProcessResult iltb18DataProcessResult = new Iltb18DataProcessResult();
            Iltb18DataProcessResultId iltb18DataProcessResultId = new Iltb18DataProcessResultId();
            iltb18DataProcessResultId.setIlImpdt(rs
                .getTimestamp("IL_IMPDT"));
            iltb18DataProcessResultId.setIlImptp(rs
                .getString("IL_IMPTP"));
            iltb18DataProcessResult
              .setId(iltb18DataProcessResultId);
            iltb18DataProcessResult.setIlImpst(rs
                .getString("IL_IMPST"));
            iltb18DataProcessResult.setIlImpuid(rs
                .getString("IL_IMPUID"));
            iltb18DataProcessResult.setIlImpfl(rs
                .getString("IL_IMPFL"));
            iltb18DataProcessResult.setIlImptot(
                Integer.valueOf(rs.getInt("IL_IMPTOT")));
            iltb18DataProcessResult.setIlImpok(
                Integer.valueOf(rs.getInt("IL_IMPOK")));
            iltb18DataProcessResult.setIlImpmsg(rs
                .getString("IL_IMPMSG"));
            iltb18DataProcessResult.setIlModified(rs
                .getTimestamp("IL_MODIFIED"));
            iltb18DataProcessResult.setIlErrtp0(
                Integer.valueOf(rs.getInt("IL_ERRTP0")));
            iltb18DataProcessResult.setIlErrtp1(
                Integer.valueOf(rs.getInt("IL_ERRTP1")));
            iltb18DataProcessResult.setIlErrtp2(
                Integer.valueOf(rs.getInt("IL_ERRTP2")));
            iltb18DataProcessResult.setIlErrtp3(
                Integer.valueOf(rs.getInt("IL_ERRTP3")));
            iltb18DataProcessResult.setIlErrtp4(
                Integer.valueOf(rs.getInt("IL_ERRTP4")));
            iltb18DataProcessResult.setIlErrtp5(
                Integer.valueOf(rs.getInt("IL_ERRTP5")));
            iltb18DataProcessResult.setIlErrtp6(
                Integer.valueOf(rs.getInt("IL_ERRTP6")));
            iltb18DataProcessResult.setIlErrtp7(
                Integer.valueOf(rs.getInt("IL_ERRTP7")));
            iltb18DataProcessResult.setIlErrtp8(
                Integer.valueOf(rs.getInt("IL_ERRTP8")));
            iltb18DataProcessResult.setIlErrtp9(
                Integer.valueOf(rs.getInt("IL_ERRTP9")));
            IL05B03ADao.this.queryLogList.add(iltb18DataProcessResult);
          }
        });
    return this.queryLogList;
  }
  
  public ArrayList<Iltb18DataProcessResult> queryByStatus(String status) {
    this.queryLogList.clear();
    JdbcTemplate query = new JdbcTemplate(this.dataSource);
    Object[] params = new Object[1];
    params[0] = status;
    query.query(
        "SELECT * FROM ILTB_18_DATA_PROCESS_RESULT WHERE IL_IMPST=? AND IL_IMPTP='T'", 
        params, new RowCallbackHandler() {
          public void processRow(ResultSet rs) throws SQLException {
            Iltb18DataProcessResult iltb18DataProcessResult = new Iltb18DataProcessResult();
            Iltb18DataProcessResultId iltb18DataProcessResultId = new Iltb18DataProcessResultId();
            iltb18DataProcessResultId.setIlImpdt(rs
                .getTimestamp("IL_IMPDT"));
            iltb18DataProcessResultId.setIlImptp(rs
                .getString("IL_IMPTP"));
            iltb18DataProcessResult
              .setId(iltb18DataProcessResultId);
            iltb18DataProcessResult.setIlImpst(rs
                .getString("IL_IMPST"));
            iltb18DataProcessResult.setIlImpuid(rs
                .getString("IL_IMPUID"));
            iltb18DataProcessResult.setIlImpfl(rs
                .getString("IL_IMPFL"));
            iltb18DataProcessResult.setIlImptot(
                Integer.valueOf(rs.getInt("IL_IMPTOT")));
            iltb18DataProcessResult.setIlImpok(
                Integer.valueOf(rs.getInt("IL_IMPOK")));
            iltb18DataProcessResult.setIlImpmsg(rs
                .getString("IL_IMPMSG"));
            iltb18DataProcessResult.setIlModified(rs
                .getTimestamp("IL_MODIFIED"));
            iltb18DataProcessResult.setIlErrtp0(
                Integer.valueOf(rs.getInt("IL_ERRTP0")));
            iltb18DataProcessResult.setIlErrtp1(
                Integer.valueOf(rs.getInt("IL_ERRTP1")));
            iltb18DataProcessResult.setIlErrtp2(
                Integer.valueOf(rs.getInt("IL_ERRTP2")));
            iltb18DataProcessResult.setIlErrtp3(
                Integer.valueOf(rs.getInt("IL_ERRTP3")));
            iltb18DataProcessResult.setIlErrtp4(
                Integer.valueOf(rs.getInt("IL_ERRTP4")));
            iltb18DataProcessResult.setIlErrtp5(
                Integer.valueOf(rs.getInt("IL_ERRTP5")));
            iltb18DataProcessResult.setIlErrtp6(
                Integer.valueOf(rs.getInt("IL_ERRTP6")));
            iltb18DataProcessResult.setIlErrtp7(
                Integer.valueOf(rs.getInt("IL_ERRTP7")));
            iltb18DataProcessResult.setIlErrtp8(
                Integer.valueOf(rs.getInt("IL_ERRTP8")));
            iltb18DataProcessResult.setIlErrtp9(
                Integer.valueOf(rs.getInt("IL_ERRTP9")));
            IL05B03ADao.this.queryLogList.add(iltb18DataProcessResult);
          }
        });
    return this.queryLogList;
  }
  
  public void updateLog(Timestamp date, String status, int totalCount, int sucessCount, int IL_ERRTP1, int IL_ERRTP2, int IL_ERRTP3, int IL_ERRTP4, int IL_ERRTP5, int IL_ERRTP6, int IL_ERRTP7) {
    JdbcTemplate insertd = new JdbcTemplate(this.dataSource);
    Object[] params = new Object[12];
    params[0] = new Date();
    params[1] = status;
    params[2] = Integer.valueOf(totalCount);
    params[3] = Integer.valueOf(sucessCount);
    params[4] = Integer.valueOf(IL_ERRTP1);
    params[5] = Integer.valueOf(IL_ERRTP2);
    params[6] = Integer.valueOf(IL_ERRTP3);
    params[7] = Integer.valueOf(IL_ERRTP4);
    params[8] = Integer.valueOf(IL_ERRTP5);
    params[9] = Integer.valueOf(IL_ERRTP6);
    params[10] = Integer.valueOf(IL_ERRTP7);
    params[11] = date;
    insertd.update(
        "UPDATE ILTB_18_DATA_PROCESS_RESULT SET IL_MODIFIED=?,IL_IMPST =? ,IL_IMPTOT=?,IL_IMPOK=?,IL_ERRTP1=? ,IL_ERRTP2=? ,IL_ERRTP3=? ,IL_ERRTP4=? ,IL_ERRTP5=? ,IL_ERRTP6=? ,IL_ERRTP7=?  WHERE IL_IMPTP='T' AND IL_IMPDT=?", 
        
        params);
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\myDao\IL05B03ADao.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */