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
import tw.gov.npa.il.dao.Iltb01Main;
import tw.gov.npa.il.dao.Iltb18DataProcessResult;
import tw.gov.npa.il.dao.Iltb18DataProcessResultId;
import tw.gov.npa.il.util.CVUtil;

public class IL07C01ADao {
  private static final Logger logger = Logger.getLogger(IL07C01ADao.class);
  
  private SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
  
  private Date current = new Date();
  
  private DataSource dataSource;
  
  private ArrayList<Iltb18DataProcessResult> queryList = new ArrayList<Iltb18DataProcessResult>();
  
  private SimpleDateFormat sdfmt = new SimpleDateFormat("yyyyMMdd");
  
  public DataSource getDataSource() {
    return this.dataSource;
  }
  
  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }
  
  public List<Iltb18DataProcessResult> queryListByDateAndType(String date, String type) {
    this.queryList.clear();
    Date tdate = new Date();
    JdbcTemplate queryd = new JdbcTemplate(this.dataSource);
    try {
      tdate = this.sdfmt.parse(date);
    } catch (ParseException e) {
      logger.info("日期轉換異常");
    } 
    Object[] params = new Object[2];
    params[0] = tdate;
    params[1] = type;
    queryd.query(
        "SELECT * FROM ILTB_18_DATA_PROCESS_RESULT WHERE IL_IMPDT=? AND IL_IMPTP=? ", 
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
            iltb18DataProcessResult.setIlImpok(
                Integer.valueOf(rs.getInt("IL_IMPOK")));
            iltb18DataProcessResult.setIlImptot(
                Integer.valueOf(rs.getInt("IL_IMPTOT")));
            IL07C01ADao.this.queryList.add(iltb18DataProcessResult);
          }
        });
    return this.queryList;
  }
  
  public boolean queryDataBynewId(long s) {
    JdbcTemplate queryd = new JdbcTemplate(this.dataSource);
    if (queryd
      .queryForInt("SELECT COUNT(*) FROM ILTB_01_MAIN WHERE IL_12ARCID=" + 
        s) > 0)
      return true; 
    return false;
  }
  
  public boolean queryData(String s) {
    JdbcTemplate queryd = new JdbcTemplate(this.dataSource);
    if (queryd
      .queryForInt("SELECT COUNT(*) FROM ILTB_01_MAIN WHERE IL_ARCID=" + 
        s) > 0)
      return true; 
    return false;
  }
  
  public ArrayList<Iltb18DataProcessResult> queryByKey(Iltb18DataProcessResultId iltb18DataProcessResultId) {
    this.queryList.clear();
    JdbcTemplate query = new JdbcTemplate(this.dataSource);
    Object[] params = new Object[2];
    params[0] = iltb18DataProcessResultId.getIlImpdt();
    params[1] = iltb18DataProcessResultId.getIlImptp();
    query.query(
        "SELECT * FROM ILTB_18_DATA_PROCESS_RESULT WHERE IL_IMPDT=? AND IL_IMPTP=? AND IL_IMPTP='3'", 
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
            IL07C01ADao.this.queryList.add(iltb18DataProcessResult);
          }
        });
    return this.queryList;
  }
  
  public void updateStatusBykey(String date, String type, String userid) throws ParseException {
    JdbcTemplate updated = new JdbcTemplate(this.dataSource);
    StringBuilder sb = new StringBuilder();
    Date tdate = this.sdfmt.parse(date);
    Object[] params = new Object[4];
    params[0] = new Date();
    params[1] = userid;
    params[2] = type;
    params[3] = tdate;
    sb.append("UPDATE ILTB_18_DATA_PROCESS_RESULT SET IL_IMPST='0',IL_MODIFIED=?,IL_IMPUID=? WHERE IL_IMPTP=? AND IL_IMPDT=?");
    updated.update(sb.toString(), params);
  }
  
  public int queryCountbyKey(String date, String type) throws ParseException {
    JdbcTemplate queryd = new JdbcTemplate(this.dataSource);
    StringBuilder sb = new StringBuilder();
    Date tdate = this.sdfmt.parse(date);
    Object[] params = new Object[2];
    params[0] = type;
    params[1] = tdate;
    sb.append("SELECT COUNT(*) FROM ILTB_18_DATA_PROCESS_RESULT WHERE IL_IMPTP=? AND IL_IMPDT=? ");
    return queryd.queryForInt(sb.toString(), params);
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
        "SELECT * FROM ILTB_18_DATA_PROCESS_RESULT WHERE IL_IMPTP='3' AND IL_IMPDT BETWEEN ? AND ? AND IL_IMPUID=?", 
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
            IL07C01ADao.this.queryList.add(iltb18DataProcessResult);
          }
        });
    return this.queryList;
  }
  
  public ArrayList<Iltb18DataProcessResult> queryByStatus(String status) {
    this.queryList.clear();
    JdbcTemplate query = new JdbcTemplate(this.dataSource);
    Object[] params = new Object[1];
    params[0] = status;
    query.query(
        "SELECT * FROM ILTB_18_DATA_PROCESS_RESULT WHERE IL_IMPST=? AND IL_IMPTP='3' ORDER BY IL_IMPDT", 
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
            IL07C01ADao.this.queryList.add(iltb18DataProcessResult);
          }
        });
    return this.queryList;
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
        "UPDATE ILTB_18_DATA_PROCESS_RESULT SET IL_MODIFIED=?,IL_IMPST =? ,IL_IMPTOT=?,IL_IMPOK=?,IL_ERRTP1=? ,IL_ERRTP2=? ,IL_ERRTP3=? ,IL_ERRTP4=? ,IL_ERRTP5=? ,IL_ERRTP6=? ,IL_ERRTP7=?  WHERE IL_IMPTP='3' AND IL_IMPDT=?", 
        
        params);
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
  
  public Date insertLog(String user, String fileName) throws ParseException {
    Date processDate = new Date();
    JdbcTemplate insertd = new JdbcTemplate(this.dataSource);
    StringBuilder sb = new StringBuilder();
    sb.append("INSERT INTO ILTB_18_DATA_PROCESS_RESULT ( IL_IMPDT,IL_IMPTP, IL_IMPST, IL_IMPUID, IL_IMPFL, IL_IMPTOT, IL_IMPOK,IL_ERRTP1, IL_ERRTP2, IL_ERRTP3, IL_ERRTP4, IL_ERRTP5, IL_ERRTP6, IL_ERRTP7, IL_ERRTP8, IL_ERRTP9,IL_ERRTP0, IL_IMPMSG,IL_MODIFIED )values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,NULL)");
    Object[] params = new Object[18];
    params[0] = processDate;
    params[1] = "3";
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
  
  public void insertData(Iltb01Main iltb01Main, long newId) {
    JdbcTemplate insertd = new JdbcTemplate(this.dataSource);
    Object[] params = new Object[75];
    params[0] = iltb01Main.getIlArcid();
    params[1] = iltb01Main.getIlArctp();
    params[2] = iltb01Main.getIlArccs();
    params[3] = iltb01Main.getIlEnm();
    params[4] = iltb01Main.getIlCnm();
    params[5] = iltb01Main.getIlSex();
    params[6] = iltb01Main.getIlBthdt();
    params[7] = iltb01Main.getIlNtcd();
    params[8] = iltb01Main.getIlPspt();
    params[9] = iltb01Main.getIlPsdt();
    params[10] = iltb01Main.getIlMst();
    params[11] = iltb01Main.getIlEdu();
    params[12] = iltb01Main.getIlIndt();
    params[13] = iltb01Main.getIlExdt();
    params[14] = iltb01Main.getIlArcrsn();
    params[15] = iltb01Main.getIlArcst();
    params[16] = iltb01Main.getIlJbcd();
    params[17] = iltb01Main.getIlJbpsn();
    params[18] = iltb01Main.getIlOfcd();
    params[19] = iltb01Main.getIlOfnm();
    params[20] = iltb01Main.getIlOftel();
    params[21] = iltb01Main.getIlOfnmbf();
    params[22] = iltb01Main.getIlJbpzone();
    params[23] = iltb01Main.getIlJbaddr();
    params[24] = iltb01Main.getIlJbtel();
    params[25] = iltb01Main.getIlArpzone();
    params[26] = iltb01Main.getIlAraddr();
    params[27] = iltb01Main.getIlArtel();
    params[28] = iltb01Main.getIlAgnco();
    params[29] = iltb01Main.getIlAgntel();
    params[30] = iltb01Main.getIlJbpmcd();
    params[31] = iltb01Main.getIlJbpmdc();
    params[32] = iltb01Main.getIlJbpmdt();
    params[33] = iltb01Main.getIlJbpmfm();
    params[34] = iltb01Main.getIlJbpmto();
    params[35] = iltb01Main.getIlMicro();
    params[36] = iltb01Main.getIlApydt();
    params[37] = iltb01Main.getIlArcrcp();
    params[38] = iltb01Main.getIlArcno();
    params[39] = iltb01Main.getIlArcfm();
    params[40] = iltb01Main.getIlArcto();
    params[41] = iltb01Main.getIlPst();
    params[42] = iltb01Main.getIlPhq();
    params[43] = iltb01Main.getIlPstext();
    params[44] = iltb01Main.getIlRemrk();
    params[45] = iltb01Main.getIlArcisu();
    params[46] = iltb01Main.getIlFrshp();
    params[47] = iltb01Main.getIlFnm();
    params[48] = iltb01Main.getIlFpid();
    params[49] = iltb01Main.getIlFntcd();
    params[50] = iltb01Main.getIlFrcexit();
    params[51] = iltb01Main.getIlReapydt();
    params[52] = iltb01Main.getIlRetp();
    params[53] = iltb01Main.getIlRepmdc();
    params[54] = iltb01Main.getIlRepmdt();
    params[55] = iltb01Main.getIlRrnote();
    params[56] = iltb01Main.getIlMrkcs();
    params[57] = iltb01Main.getIlFbdrsn();
    params[58] = iltb01Main.getIlMrkdt();
    params[59] = iltb01Main.getIlMrkdc();
    params[60] = iltb01Main.getIlSbmttp();
    params[61] = iltb01Main.getIlMissdt();
    params[62] = iltb01Main.getIlSbmtdt();
    params[63] = iltb01Main.getIlSrchst();
    params[64] = iltb01Main.getIlFnddid();
    params[65] = iltb01Main.getIlFnddt();
    params[66] = iltb01Main.getIlOldarc();
    params[67] = iltb01Main.getIlHcst();
    params[68] = iltb01Main.getIlHcctr();
    params[69] = iltb01Main.getIlLmd();
    params[70] = iltb01Main.getIlFstapydt();
    params[71] = iltb01Main.getIlForfere();
    params[72] = iltb01Main.getIlRepmdcNic();
    params[73] = Long.valueOf(newId);
    params[74] = iltb01Main.getIlArcno();
    insertd.update(
        "INSERT INTO ILTB_01_MAIN (IL_ARCID,IL_ARCTP,IL_ARCCS,IL_ENM,IL_CNM,IL_SEX,IL_BTHDT,IL_NTCD,IL_PSPT,IL_PSDT,IL_MST,IL_EDU,IL_INDT,IL_EXDT,IL_ARCRSN,IL_ARCST,IL_JBCD,IL_JBPSN,IL_OFCD,IL_OFNM,IL_OFTEL,IL_OFNMBF,IL_JBPZONE,IL_JBADDR,IL_JBTEL,IL_ARPZONE,IL_ARADDR,IL_ARTEL,IL_AGNCO,IL_AGNTEL,IL_JBPMCD,IL_JBPMDC,IL_JBPMDT,IL_JBPMFM,IL_JBPMTO,IL_MICRO,IL_APYDT,IL_ARCRCP,IL_ARCNO,IL_ARCFM,IL_ARCTO,IL_PST,IL_PHQ,IL_PSTEXT,IL_REMRK,IL_ARCISU,IL_FRSHP,IL_FNM,IL_FPID,IL_FNTCD,IL_FRCEXIT,IL_REAPYDT,IL_RETP,IL_REPMDC,IL_REPMDT,IL_RRNOTE,IL_MRKCS,IL_FBDRSN,IL_MRKDT,IL_MRKDC,IL_SBMTTP,IL_MISSDT,IL_SBMTDT,IL_SRCHST,IL_FNDDID,IL_FNDDT,IL_OLDARC,IL_HCST,IL_HCCTR,IL_LMD,IL_FSTAPYDT,IL_REPMDC_NIC,IL_FORFERE,IL_12ARCID,IL_OLDARCNO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", 
        
        params);
    Object[] params2 = new Object[17];
    params2[0] = iltb01Main.getIlArcid();
    params2[1] = iltb01Main.getIlArccs();
    params2[2] = iltb01Main.getIlArcno();
    params2[3] = iltb01Main.getIlOldarc();
    params2[4] = iltb01Main.getIlNtcd();
    params2[5] = iltb01Main.getIlPspt();
    params2[6] = iltb01Main.getIlEnm();
    params2[7] = iltb01Main.getIlCnm();
    params2[8] = iltb01Main.getIlBthdt();
    params2[9] = iltb01Main.getIlOfnm();
    params2[10] = iltb01Main.getIlPhq();
    params2[11] = iltb01Main.getIlPst();
    params2[12] = iltb01Main.getIlJbcd();
    params2[13] = iltb01Main.getIlJbpmdt();
    params2[14] = iltb01Main.getIlJbpmdc();
    params2[15] = new Date();
    params2[16] = Long.valueOf(newId);
    insertd.update(
        "INSERT INTO ILTB_01_MAIN_IDX ( IL_ARCID,IL_ARCCS,IL_ARCNO,IL_OLDARC,IL_NTCD,IL_PSPT,IL_ENM,IL_CNM,IL_BTHDT,IL_OFNM,IL_PHQ,IL_PST,IL_JBCD,IL_JBPMDT,IL_JBPMDC,IL_MODIFIED,IL_12ARCID )values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", 
        params2);
  }
  
  public void updateData(Iltb01Main iltb01Main, long newId, int control) {
    JdbcTemplate updated = new JdbcTemplate(this.dataSource);
    if (control == 0) {
      Object[] params = new Object[74];
      params[0] = iltb01Main.getIlArctp();
      params[1] = iltb01Main.getIlArccs();
      params[2] = iltb01Main.getIlEnm();
      params[3] = iltb01Main.getIlCnm();
      params[4] = iltb01Main.getIlSex();
      params[5] = iltb01Main.getIlBthdt();
      params[6] = iltb01Main.getIlNtcd();
      params[7] = iltb01Main.getIlPspt();
      params[8] = iltb01Main.getIlPsdt();
      params[9] = iltb01Main.getIlMst();
      params[10] = iltb01Main.getIlEdu();
      params[11] = iltb01Main.getIlIndt();
      params[12] = iltb01Main.getIlExdt();
      params[13] = iltb01Main.getIlArcrsn();
      params[14] = iltb01Main.getIlArcst();
      params[15] = iltb01Main.getIlJbcd();
      params[16] = iltb01Main.getIlJbpsn();
      params[17] = iltb01Main.getIlOfcd();
      params[18] = iltb01Main.getIlOfnm();
      params[19] = iltb01Main.getIlOftel();
      params[20] = iltb01Main.getIlOfnmbf();
      params[21] = iltb01Main.getIlJbpzone();
      params[22] = iltb01Main.getIlJbaddr();
      params[23] = iltb01Main.getIlJbtel();
      params[24] = iltb01Main.getIlArpzone();
      params[25] = iltb01Main.getIlAraddr();
      params[26] = iltb01Main.getIlArtel();
      params[27] = iltb01Main.getIlAgnco();
      params[28] = iltb01Main.getIlAgntel();
      params[29] = iltb01Main.getIlJbpmcd();
      params[30] = iltb01Main.getIlJbpmdc();
      params[31] = iltb01Main.getIlJbpmdt();
      params[32] = iltb01Main.getIlJbpmfm();
      params[33] = iltb01Main.getIlJbpmto();
      params[34] = iltb01Main.getIlMicro();
      params[35] = iltb01Main.getIlApydt();
      params[36] = iltb01Main.getIlArcrcp();
      params[37] = iltb01Main.getIlArcno();
      params[38] = iltb01Main.getIlArcfm();
      params[39] = iltb01Main.getIlArcto();
      params[40] = iltb01Main.getIlPst();
      params[41] = iltb01Main.getIlPhq();
      params[42] = iltb01Main.getIlPstext();
      params[43] = iltb01Main.getIlRemrk();
      params[44] = iltb01Main.getIlArcisu();
      params[45] = iltb01Main.getIlFrshp();
      params[46] = iltb01Main.getIlFnm();
      params[47] = iltb01Main.getIlFpid();
      params[48] = iltb01Main.getIlFntcd();
      params[49] = iltb01Main.getIlFrcexit();
      params[50] = iltb01Main.getIlReapydt();
      params[51] = iltb01Main.getIlRetp();
      params[52] = iltb01Main.getIlRepmdc();
      params[53] = iltb01Main.getIlRepmdt();
      params[54] = iltb01Main.getIlRrnote();
      params[55] = iltb01Main.getIlMrkcs();
      params[56] = iltb01Main.getIlFbdrsn();
      params[57] = iltb01Main.getIlMrkdt();
      params[58] = iltb01Main.getIlMrkdc();
      params[59] = iltb01Main.getIlSbmttp();
      params[60] = iltb01Main.getIlMissdt();
      params[61] = iltb01Main.getIlSbmtdt();
      params[62] = iltb01Main.getIlSrchst();
      params[63] = iltb01Main.getIlFnddid();
      params[64] = iltb01Main.getIlFnddt();
      params[65] = iltb01Main.getIlOldarc();
      params[66] = iltb01Main.getIlHcst();
      params[67] = iltb01Main.getIlHcctr();
      params[68] = iltb01Main.getIlLmd();
      params[69] = iltb01Main.getIlFstapydt();
      params[70] = iltb01Main.getIlForfere();
      params[71] = iltb01Main.getIlRepmdcNic();
      params[72] = Long.valueOf(newId);
      params[73] = iltb01Main.getIlArcid();
      updated.update(
          "UPDATE ILTB_01_MAIN SET IL_ARCTP=?,IL_ARCCS=?,IL_ENM=?,IL_CNM=?,IL_SEX=?,IL_BTHDT=?,IL_NTCD=?,IL_PSPT=?,IL_PSDT=?,IL_MST=?,IL_EDU=?,IL_INDT=?,IL_EXDT=?,IL_ARCRSN=?,IL_ARCST=?,IL_JBCD=?,IL_JBPSN=?,IL_OFCD=?,IL_OFNM=?,IL_OFTEL=?,IL_OFNMBF=?,IL_JBPZONE=?,IL_JBADDR=?,IL_JBTEL=?,IL_ARPZONE=?,IL_ARADDR=?,IL_ARTEL=?,IL_AGNCO=?,IL_AGNTEL=?,IL_JBPMCD=?,IL_JBPMDC=?,IL_JBPMDT=?,IL_JBPMFM=?,IL_JBPMTO=?,IL_MICRO=?,IL_APYDT=?,IL_ARCRCP=?,IL_ARCNO=?,IL_ARCFM=?,IL_ARCTO=?,IL_PST=?,IL_PHQ=?,IL_PSTEXT=?,IL_REMRK=?,IL_ARCISU=?,IL_FRSHP=?,IL_FNM=?,IL_FPID=?,IL_FNTCD=?,IL_FRCEXIT=?,IL_REAPYDT=?,IL_RETP=?,IL_REPMDC=?,IL_REPMDT=?,IL_RRNOTE=?,IL_MRKCS=?,IL_FBDRSN=?,IL_MRKDT=?,IL_MRKDC=?,IL_SBMTTP=?,IL_MISSDT=?,IL_SBMTDT=?,IL_SRCHST=?,IL_FNDDID=?,IL_FNDDT=?,IL_OLDARC=?,IL_HCST=?,IL_HCCTR=?,IL_LMD=?,IL_FSTAPYDT=?,IL_REPMDC_NIC=?,IL_FORFERE=?,IL_12ARCID=? WHERE IL_ARCID=?", 
          
          params);
      Object[] params2 = new Object[17];
      params2[0] = iltb01Main.getIlArccs();
      params2[1] = iltb01Main.getIlArcno();
      params2[2] = iltb01Main.getIlOldarc();
      params2[3] = iltb01Main.getIlNtcd();
      params2[4] = iltb01Main.getIlPspt();
      params2[5] = iltb01Main.getIlEnm();
      params2[6] = iltb01Main.getIlCnm();
      params2[7] = iltb01Main.getIlBthdt();
      params2[8] = iltb01Main.getIlOfnm();
      params2[9] = iltb01Main.getIlPhq();
      params2[10] = iltb01Main.getIlPst();
      params2[11] = iltb01Main.getIlJbcd();
      params2[12] = iltb01Main.getIlJbpmdt();
      params2[13] = iltb01Main.getIlJbpmdc();
      params2[14] = this.df.format(new Date());
      params2[15] = Long.valueOf(newId);
      params2[16] = iltb01Main.getIlArcid();
      updated.update("UPDATE ILTB_01_MAIN_IDX SET IL_ARCCS=? ,IL_ARCNO=? ,IL_OLDARC=? ,IL_NTCD=? ,IL_PSPT=? ,IL_ENM=? ,IL_CNM=? ,IL_BTHDT=? ,IL_OFNM=? ,IL_PHQ=? ,IL_PST=?,IL_JBCD=? ,IL_JBPMDT=? ,IL_JBPMDC=? ,IL_MODIFIED=?,IL_12ARCID=?  WHERE IL_ARCID=?", 
          
          params2);
    } else if (control == 1) {
      Object[] params = new Object[74];
      params[0] = iltb01Main.getIlArctp();
      params[1] = iltb01Main.getIlArccs();
      params[2] = iltb01Main.getIlEnm();
      params[3] = iltb01Main.getIlCnm();
      params[4] = iltb01Main.getIlSex();
      params[5] = iltb01Main.getIlBthdt();
      params[6] = iltb01Main.getIlNtcd();
      params[7] = iltb01Main.getIlPspt();
      params[8] = iltb01Main.getIlPsdt();
      params[9] = iltb01Main.getIlMst();
      params[10] = iltb01Main.getIlEdu();
      params[11] = iltb01Main.getIlIndt();
      params[12] = iltb01Main.getIlExdt();
      params[13] = iltb01Main.getIlArcrsn();
      params[14] = iltb01Main.getIlArcst();
      params[15] = iltb01Main.getIlJbcd();
      params[16] = iltb01Main.getIlJbpsn();
      params[17] = iltb01Main.getIlOfcd();
      params[18] = iltb01Main.getIlOfnm();
      params[19] = iltb01Main.getIlOftel();
      params[20] = iltb01Main.getIlOfnmbf();
      params[21] = iltb01Main.getIlJbpzone();
      params[22] = iltb01Main.getIlJbaddr();
      params[23] = iltb01Main.getIlJbtel();
      params[24] = iltb01Main.getIlArpzone();
      params[25] = iltb01Main.getIlAraddr();
      params[26] = iltb01Main.getIlArtel();
      params[27] = iltb01Main.getIlAgnco();
      params[28] = iltb01Main.getIlAgntel();
      params[29] = iltb01Main.getIlJbpmcd();
      params[30] = iltb01Main.getIlJbpmdc();
      params[31] = iltb01Main.getIlJbpmdt();
      params[32] = iltb01Main.getIlJbpmfm();
      params[33] = iltb01Main.getIlJbpmto();
      params[34] = iltb01Main.getIlMicro();
      params[35] = iltb01Main.getIlApydt();
      params[36] = iltb01Main.getIlArcrcp();
      params[37] = iltb01Main.getIlArcno();
      params[38] = iltb01Main.getIlArcfm();
      params[39] = iltb01Main.getIlArcto();
      params[40] = iltb01Main.getIlPst();
      params[41] = iltb01Main.getIlPhq();
      params[42] = iltb01Main.getIlPstext();
      params[43] = iltb01Main.getIlRemrk();
      params[44] = iltb01Main.getIlArcisu();
      params[45] = iltb01Main.getIlFrshp();
      params[46] = iltb01Main.getIlFnm();
      params[47] = iltb01Main.getIlFpid();
      params[48] = iltb01Main.getIlFntcd();
      params[49] = iltb01Main.getIlFrcexit();
      params[50] = iltb01Main.getIlReapydt();
      params[51] = iltb01Main.getIlRetp();
      params[52] = iltb01Main.getIlRepmdc();
      params[53] = iltb01Main.getIlRepmdt();
      params[54] = iltb01Main.getIlRrnote();
      params[55] = iltb01Main.getIlMrkcs();
      params[56] = iltb01Main.getIlFbdrsn();
      params[57] = iltb01Main.getIlMrkdt();
      params[58] = iltb01Main.getIlMrkdc();
      params[59] = iltb01Main.getIlSbmttp();
      params[60] = iltb01Main.getIlMissdt();
      params[61] = iltb01Main.getIlSbmtdt();
      params[62] = iltb01Main.getIlSrchst();
      params[63] = iltb01Main.getIlFnddid();
      params[64] = iltb01Main.getIlFnddt();
      params[65] = iltb01Main.getIlOldarc();
      params[66] = iltb01Main.getIlHcst();
      params[67] = iltb01Main.getIlHcctr();
      params[68] = iltb01Main.getIlLmd();
      params[69] = iltb01Main.getIlFstapydt();
      params[70] = iltb01Main.getIlForfere();
      params[71] = iltb01Main.getIlRepmdcNic();
      params[72] = Long.valueOf(newId);
      params[73] = Long.valueOf(newId);
      updated.update(
          "UPDATE ILTB_01_MAIN SET IL_ARCTP=?,IL_ARCCS=?,IL_ENM=?,IL_CNM=?,IL_SEX=?,IL_BTHDT=?,IL_NTCD=?,IL_PSPT=?,IL_PSDT=?,IL_MST=?,IL_EDU=?,IL_INDT=?,IL_EXDT=?,IL_ARCRSN=?,IL_ARCST=?,IL_JBCD=?,IL_JBPSN=?,IL_OFCD=?,IL_OFNM=?,IL_OFTEL=?,IL_OFNMBF=?,IL_JBPZONE=?,IL_JBADDR=?,IL_JBTEL=?,IL_ARPZONE=?,IL_ARADDR=?,IL_ARTEL=?,IL_AGNCO=?,IL_AGNTEL=?,IL_JBPMCD=?,IL_JBPMDC=?,IL_JBPMDT=?,IL_JBPMFM=?,IL_JBPMTO=?,IL_MICRO=?,IL_APYDT=?,IL_ARCRCP=?,IL_ARCNO=?,IL_ARCFM=?,IL_ARCTO=?,IL_PST=?,IL_PHQ=?,IL_PSTEXT=?,IL_REMRK=?,IL_ARCISU=?,IL_FRSHP=?,IL_FNM=?,IL_FPID=?,IL_FNTCD=?,IL_FRCEXIT=?,IL_REAPYDT=?,IL_RETP=?,IL_REPMDC=?,IL_REPMDT=?,IL_RRNOTE=?,IL_MRKCS=?,IL_FBDRSN=?,IL_MRKDT=?,IL_MRKDC=?,IL_SBMTTP=?,IL_MISSDT=?,IL_SBMTDT=?,IL_SRCHST=?,IL_FNDDID=?,IL_FNDDT=?,IL_OLDARC=?,IL_HCST=?,IL_HCCTR=?,IL_LMD=?,IL_FSTAPYDT=?,IL_REPMDC_NIC=?,IL_FORFERE=?,IL_12ARCID=? WHERE IL_12ARCID=?", 
          
          params);
      Object[] params2 = new Object[17];
      params2[0] = iltb01Main.getIlArccs();
      params2[1] = iltb01Main.getIlArcno();
      params2[2] = iltb01Main.getIlOldarc();
      params2[3] = iltb01Main.getIlNtcd();
      params2[4] = iltb01Main.getIlPspt();
      params2[5] = iltb01Main.getIlEnm();
      params2[6] = iltb01Main.getIlCnm();
      params2[7] = iltb01Main.getIlBthdt();
      params2[8] = iltb01Main.getIlOfnm();
      params2[9] = iltb01Main.getIlPhq();
      params2[10] = iltb01Main.getIlPst();
      params2[11] = iltb01Main.getIlJbcd();
      params2[12] = iltb01Main.getIlJbpmdt();
      params2[13] = iltb01Main.getIlJbpmdc();
      params2[14] = this.df.format(new Date());
      params2[15] = Long.valueOf(newId);
      params2[16] = Long.valueOf(newId);
      updated.update("UPDATE ILTB_01_MAIN_IDX SET IL_ARCCS=? ,IL_ARCNO=? ,IL_OLDARC=? ,IL_NTCD=? ,IL_PSPT=? ,IL_ENM=? ,IL_CNM=? ,IL_BTHDT=? ,IL_OFNM=? ,IL_PHQ=? ,IL_PST=?,IL_JBCD=? ,IL_JBPMDT=? ,IL_JBPMDC=? ,IL_MODIFIED=?,IL_12ARCID=?  WHERE IL_12ARCID=?", 
          
          params2);
    } 
  }
  
  public void delete(Iltb01Main iltb01Main) {
    JdbcTemplate updated = new JdbcTemplate(this.dataSource);
    updated.update("DELETE ILTB_01_MAIN WHERE IL_ARCID=" + 
        iltb01Main.getIlArcid());
    updated.update("DELETE ILTB_01_MAIN_IDX WHERE IL_ARCID=" + 
        iltb01Main.getIlArcid());
    updated.update("DELETE ILTB_04_IN_RECORD WHERE IL_ARCID=" + 
        iltb01Main.getIlArcid());
    updated.update("DELETE ILTB_22_IA_RECORD WHERE IL_ARCID=" + 
        iltb01Main.getIlArcid());
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\myDao\IL07C01ADao.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */