package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import tw.gov.npa.il.dao.Iltb15CountryCode;
import tw.gov.npa.il.dao.Iltb16JobCode;
import tw.gov.npa.il.dao.Iltb17SchoolCode;
import tw.gov.npa.il.dao.Iltb17SchoolCodeDAO;
import tw.gov.npa.il.dao.Iltb20OnlineReport;
import tw.gov.npa.il.dao.Iltb20OnlineReportId;
import tw.gov.npa.il.e0db.dao.E0dtNpaunit;
import tw.gov.npa.il.e0db.myDao.MyE0dtNpaunitDAO;
import tw.gov.npa.il.myDao.MyIltb01MainDAO2;
import tw.gov.npa.il.myDao.MyIltb15CountryCodeDAO;
import tw.gov.npa.il.myDao.MyIltb16JobCodeDAO;
import tw.gov.npa.il.myDao.MyIltb20OnlineReportDAO;
import tw.gov.npa.il.report.IL03B01Report;
import tw.gov.npa.il.util.Constant;
import tw.gov.npa.il.util.NTPCUtil;

public class IL03B01P02 extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL03B01P02.class);
  
  private String isFlag;
  
  MyIltb01MainDAO2 myIltb01MainDAO2 = new MyIltb01MainDAO2();
  
  MyE0dtNpaunitDAO myE0dtNpaunitDAO = new MyE0dtNpaunitDAO();
  
  Iltb17SchoolCodeDAO iltb17SchoolCodeDAO = new Iltb17SchoolCodeDAO();
  
  MyIltb15CountryCodeDAO myIltb15CountryCodeDAO = new MyIltb15CountryCodeDAO();
  
  MyIltb16JobCodeDAO myIltb16JobCodeDAO = new MyIltb16JobCodeDAO();
  
  NTPCUtil ntpcUtil = new NTPCUtil();
  
  private E0dtNpaunit e0dtNpaunit = new E0dtNpaunit();
  
  ResourceBundle rb = ResourceBundle.getBundle("config");
  
  private String contextPath = this.rb.getString("ReportRoot").toString();
  
  Constant constant = new Constant();
  
  private Date nowDate = new Date();
  
  List<Iltb17SchoolCode> schoolCodes = new ArrayList<Iltb17SchoolCode>();
  
  List<Iltb15CountryCode> iltb15CountryCodeList = new ArrayList<Iltb15CountryCode>();
  
  List<Iltb16JobCode> iltb16JobCodeList = new ArrayList<Iltb16JobCode>();
  
  private int Choice;
  
  private String ilPst;
  
  private String ilZipCode;
  
  private String ilZipCodeName;
  
  private String ilZipCodeList;
  
  private String ilZipFullNameList;
  
  private String ilPstext;
  
  private String ilPstName;
  
  public int getChoice() {
    return this.Choice;
  }
  
  public List<Iltb15CountryCode> getIltb15CountryCodeList() {
    return this.iltb15CountryCodeList;
  }
  
  public void setIltb15CountryCodeList(List<Iltb15CountryCode> iltb15CountryCodeList) {
    this.iltb15CountryCodeList = iltb15CountryCodeList;
  }
  
  public List<Iltb16JobCode> getIltb16JobCodeList() {
    return this.iltb16JobCodeList;
  }
  
  public void setIltb16JobCodeList(List<Iltb16JobCode> iltb16JobCodeList) {
    this.iltb16JobCodeList = iltb16JobCodeList;
  }
  
  public List<Iltb17SchoolCode> getSchoolCodes() {
    return this.schoolCodes;
  }
  
  public void setSchoolCodes(List<Iltb17SchoolCode> schoolCodes) {
    this.schoolCodes = schoolCodes;
  }
  
  public String getIlPstName() {
    return this.ilPstName;
  }
  
  public void setIlPstName(String ilPstName) {
    this.ilPstName = ilPstName;
  }
  
  public String getIsFlag() {
    return this.isFlag;
  }
  
  public void setIsFlag(String isFlag) {
    this.isFlag = isFlag;
  }
  
  public String getContextPath() {
    return this.contextPath;
  }
  
  public void setContextPath(String contextPath) {
    this.contextPath = contextPath;
  }
  
  public String getIlPst() {
    return this.ilPst;
  }
  
  public void setIlPst(String ilPst) {
    this.ilPst = ilPst;
  }
  
  public String getIlZipCode() {
    return this.ilZipCode;
  }
  
  public void setIlZipCode(String ilZipCode) {
    this.ilZipCode = ilZipCode;
  }
  
  public String getIlZipCodeName() {
    return this.ilZipCodeName;
  }
  
  public void setIlZipCodeName(String ilZipCodeName) {
    this.ilZipCodeName = ilZipCodeName;
  }
  
  public String getIlZipCodeList() {
    return this.ilZipCodeList;
  }
  
  public void setIlZipCodeList(String ilZipCodeList) {
    this.ilZipCodeList = ilZipCodeList;
  }
  
  public String getIlZipFullNameList() {
    return this.ilZipFullNameList;
  }
  
  public void setIlZipFullNameList(String ilZipFullNameList) {
    this.ilZipFullNameList = ilZipFullNameList;
  }
  
  public String getIlPstext() {
    return this.ilPstext;
  }
  
  public void setIlPstext(String ilPstext) {
    this.ilPstext = ilPstext;
  }
  
  public void setChoice(int choice) {
    this.Choice = choice;
  }
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
  }
  
  public String toMain() throws Exception {
    HttpSession session = ServletActionContext.getRequest().getSession();
    String LOGUID = (session.getAttribute("LOGUID") == null) ? "0" : session.getAttribute("LOGUID").toString();
    int usrFlagInfo = Integer.parseInt((session.getAttribute("usrFlagInfo") == null) ? "0" : session.getAttribute("usrFlagInfo").toString());
    String LOGDID = (session.getAttribute("LOGDID") == null) ? "0" : session.getAttribute("LOGDID").toString();
    String LOGUIP = (session.getAttribute("LOGUIP") == null) ? "" : session.getAttribute("LOGUIP").toString().trim();
    String LOGDIDCN = (session.getAttribute("LOGDIDCN") == null) ? "" : session.getAttribute("LOGDIDCN").toString().trim();
    this.e0dtNpaunit = this.myE0dtNpaunitDAO.findById(LOGDID);
    IL03B01Report il03B01Report = new IL03B01Report();
    try {
      if (this.ilPst.trim().equals("AE000"))
        this.ilPst = "BE000"; 
      this.ilPstName = this.myE0dtNpaunitDAO.findById(this.ilPst).getE0FullSNm();
      String[] ilPstArr = this.ntpcUtil.getOlderE0UnitCdByNewE0UnitCd(this.ilPst.trim());
      String[] ilZipCodeArr = this.ntpcUtil.getSplitZipCode(this.ilZipCode);
      String ilPstextName = "";
      if ("".equals(this.ilPstext) || this.ilPstext == null) {
        ilPstextName = "全部";
      } else {
        ilPstextName = this.ilPstext;
      } 
      String unitName = this.myE0dtNpaunitDAO.findById(ilPstArr[0]).getE0FullSNm() + "(郵遞區號:" + this.ilZipFullNameList.replace("　", "") + ")" + ilPstextName;
      StringBuffer sqlStr = new StringBuffer();
      String whereCommand = "";
      String reportId = "";
      switch (this.Choice) {
        case 1:
          this.schoolCodes = this.iltb17SchoolCodeDAO.findAll();
          this.iltb15CountryCodeList = this.myIltb15CountryCodeDAO.findAll();
          this.iltb16JobCodeList = this.myIltb16JobCodeDAO.findAll();
          unitName = unitName + "外責區  自由檢索報表";
          reportId = "01";
          return "report1";
        case 2:
          if (ilPstArr != null) {
            sqlStr.append("(");
            for (int i = 0; i < ilPstArr.length; i++) {
              if (i == 0) {
                sqlStr.append("IL_PHQ='" + ilPstArr[i] + "'");
              } else {
                sqlStr.append(" OR IL_PHQ='" + ilPstArr[i] + "'");
              } 
            } 
            sqlStr.append(")");
          } 
          if (ilZipCodeArr != null) {
            sqlStr.append(" AND (");
            for (int i = 0; i < ilZipCodeArr.length; i++) {
              if (i == 0)
                sqlStr.append("IL_ARPZONE in (" + this.ilZipCodeList + ")"); 
            } 
            sqlStr.append(")");
          } 
          if (!"".equals(this.ilPstext) && this.ilPstext != null)
            sqlStr.append(" AND IL_PSTEXT='" + this.ilPstext + "'"); 
          sqlStr.append(" AND IL_ARCTO > getdate()");
          sqlStr.append(" AND IL_ARCST = '2'");
          sqlStr.append(" AND IL_NTCD <> '35'");
          sqlStr.append(" ORDER BY IL_NTCD, IL_JBCD, IL_SEX");
          unitName = unitName + "外責區  居留外僑統計表(按國籍及職業分)";
          reportId = "02";
          break;
        case 3:
          if (ilPstArr != null) {
            sqlStr.append("(");
            for (int i = 0; i < ilPstArr.length; i++) {
              if (i == 0) {
                sqlStr.append("IL_PHQ='" + ilPstArr[i] + "'");
              } else {
                sqlStr.append(" OR IL_PHQ='" + ilPstArr[i] + "'");
              } 
            } 
            sqlStr.append(")");
          } 
          if (ilZipCodeArr != null) {
            sqlStr.append(" AND (");
            for (int i = 0; i < ilZipCodeArr.length; i++) {
              if (i == 0)
                sqlStr.append("IL_ARPZONE in (" + this.ilZipCodeList + ")"); 
            } 
            sqlStr.append(")");
          } 
          if (!"".equals(this.ilPstext) && this.ilPstext != null)
            sqlStr.append(" AND IL_PSTEXT='" + this.ilPstext + "'"); 
          sqlStr.append(" AND IL_SEX = '1'");
          sqlStr.append(" AND IL_ARCST <> '4'");
          sqlStr.append(" AND IL_JBCD = '37'");
          sqlStr.append(" AND convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112)");
          unitName = unitName + "外責區  外籍男性幫傭名冊";
          reportId = "03";
          break;
        case 4:
          sqlStr.append("IL_SEX = '2' ");
          sqlStr.append("AND IL_NTCD in ('004' , '009' , '017' , '019' , '024' , '027' , '030') ");
          sqlStr.append("AND IL_ARCRSN in ('1','8','9','A','B') ");
          sqlStr.append("AND ((IL_ARCTO >= getdate() AND (IL_ARCST = '2' OR (IL_ARCST = '3' AND (IL_MISSDT IS NULL)))) OR (IL_ARCTO < getdate() AND IL_ARCST = '2')) ");
          sqlStr.append("AND IL_FRSHP = '01' ");
          sqlStr.append("AND IL_FNTCD = '035' ");
          if (ilPstArr != null) {
            sqlStr.append(" AND (");
            for (int i = 0; i < ilPstArr.length; i++) {
              if (i == 0) {
                sqlStr.append("IL_PHQ='" + ilPstArr[i] + "'");
              } else {
                sqlStr.append(" OR IL_PHQ='" + ilPstArr[i] + "'");
              } 
            } 
          } 
          sqlStr.append(")");
          if (ilZipCodeArr != null) {
            sqlStr.append(" AND (");
            for (int i = 0; i < ilZipCodeArr.length; i++) {
              if (i == 0)
                sqlStr.append("IL_ARPZONE in (" + this.ilZipCodeList + ")"); 
            } 
            sqlStr.append(")");
          } 
          unitName = unitName + "外責區  東南亞女子與國人結婚名冊";
          reportId = "04";
          break;
        case 5:
          sqlStr.append(" IL_ARCCS = '1' AND IL_ARCST = '2' AND IL_MISSDT IS NOT NULL ");
          if (ilPstArr != null) {
            sqlStr.append(" AND (");
            for (int i = 0; i < ilPstArr.length; i++) {
              if (i == 0) {
                sqlStr.append("IL_PHQ='" + ilPstArr[i] + "'");
              } else {
                sqlStr.append(" OR IL_PHQ='" + ilPstArr[i] + "'");
              } 
            } 
          } 
          sqlStr.append(")");
          if (ilZipCodeArr != null) {
            sqlStr.append(" AND (");
            for (int i = 0; i < ilZipCodeArr.length; i++) {
              if (i == 0)
                sqlStr.append("IL_ARPZONE in (" + this.ilZipCodeList + ")"); 
            } 
            sqlStr.append(")");
          } 
          unitName = unitName + "外責區  行方不明外勞協尋名冊";
          reportId = "05";
          break;
        case 6:
          if (ilPstArr != null) {
            sqlStr.append("(");
            for (int i = 0; i < ilPstArr.length; i++) {
              if (i == 0) {
                sqlStr.append("IL_PHQ='" + ilPstArr[i] + "'");
              } else {
                sqlStr.append(" OR IL_PHQ='" + ilPstArr[i] + "'");
              } 
            } 
            sqlStr.append(")");
          } 
          if (ilZipCodeArr != null) {
            sqlStr.append(" AND (");
            for (int i = 0; i < ilZipCodeArr.length; i++) {
              if (i == 0)
                sqlStr.append("IL_ARPZONE in (" + this.ilZipCodeList + ")"); 
            } 
            sqlStr.append(")");
          } 
          if (!"".equals(this.ilPstext) && this.ilPstext != null)
            sqlStr.append(" AND IL_PSTEXT='" + this.ilPstext + "'"); 
          sqlStr.append(" AND IL_ARCST = '2'");
          sqlStr.append(" AND IL_ARCTO IS NOT NULL");
          sqlStr.append(" AND IL_ARCTO < getdate()");
          unitName = unitName + "外責區  逾期居留外僑名冊";
          reportId = "06";
          break;
        default:
          this.isFlag = "F";
          return "reportOther";
      } 
      String whereCommand1 = "";
      String whereCommand2 = "";
      whereCommand = sqlStr.toString();
      if (whereCommand.length() >= 255) {
        whereCommand1 = whereCommand.substring(0, 254);
        whereCommand2 = whereCommand.substring(255);
      } else {
        whereCommand1 = whereCommand;
      } 
      Iltb20OnlineReport report = new Iltb20OnlineReport();
      Iltb20OnlineReportId id = new Iltb20OnlineReportId(LOGUID, reportId, new Timestamp(System.currentTimeMillis()));
      report.setId(id);
      report.setIlDidnm(LOGDIDCN);
      report.setIlIp(LOGUIP);
      report.setIlRptamt(Short.valueOf((short)0));
      report.setIlRptfn(reportId + LOGUID);
      report.setIlRptnm(unitName);
      report.setIlRundt(new Timestamp(System.currentTimeMillis()));
      report.setIlShow("");
      report.setIlStatus("0");
      report.setIlWhere1(whereCommand1);
      report.setIlWhere2(whereCommand2);
      report.setIlModified(new Timestamp(System.currentTimeMillis()));
      MyIltb20OnlineReportDAO dao = new MyIltb20OnlineReportDAO();
      dao.update(report);
    } catch (Exception e) {
      e.printStackTrace();
      return "error";
    } 
    this.isFlag = "N";
    return "reportOther";
  }
  
  public String toQuery() throws Exception {
    return "success";
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL03B01P02.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */