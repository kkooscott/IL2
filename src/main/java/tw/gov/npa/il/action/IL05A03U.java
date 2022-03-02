package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import tw.gov.npa.il.myDao.IL07C01ADao;
import tw.gov.npa.il.myDao.IL07C01BDao;
import tw.gov.npa.il.util.UploadFile;

public class IL05A03U extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL05A03U.class);
  
  private Date nowDate = new Date();
  
  private String FLDTYear = "";
  
  private String FLDTMonth = "";
  
  private String FLDTDay = "";
  
  private String DataType;
  
  private IL07C01ADao il07C01ADao;
  
  private IL07C01BDao il07C01BDao;
  
  private String selectDate;
  
  private File txtFile;
  
  private String txtFileFileName;
  
  private String control;
  
  public String getControl() {
    return this.control;
  }
  
  public void setControl(String control) {
    this.control = control;
  }
  
  public String getTxtFileFileName() {
    return this.txtFileFileName;
  }
  
  public void setTxtFileFileName(String txtFileFileName) {
    this.txtFileFileName = txtFileFileName;
  }
  
  public File getTxtFile() {
    return this.txtFile;
  }
  
  public void setTxtFile(File txtFile) {
    this.txtFile = txtFile;
  }
  
  public String getSelectDate() {
    return this.selectDate;
  }
  
  public void setSelectDate(String selectDate) {
    this.selectDate = selectDate;
  }
  
  public String getFLDTYear() {
    return this.FLDTYear;
  }
  
  public void setFLDTYear(String fLDTYear) {
    this.FLDTYear = fLDTYear;
  }
  
  public String getFLDTMonth() {
    return this.FLDTMonth;
  }
  
  public void setFLDTMonth(String fLDTMonth) {
    this.FLDTMonth = fLDTMonth;
  }
  
  public String getFLDTDay() {
    return this.FLDTDay;
  }
  
  public void setFLDTDay(String fLDTDay) {
    this.FLDTDay = fLDTDay;
  }
  
  public String getDataType() {
    return this.DataType;
  }
  
  public void setDataType(String dataType) {
    this.DataType = dataType;
  }
  
  public IL07C01ADao getIl07C01ADao() {
    return this.il07C01ADao;
  }
  
  public void setIl07C01ADao(IL07C01ADao il07c01aDao) {
    this.il07C01ADao = il07c01aDao;
  }
  
  public IL07C01BDao getIl07C01BDao() {
    return this.il07C01BDao;
  }
  
  public void setIl07C01BDao(IL07C01BDao il07c01bDao) {
    this.il07C01BDao = il07c01bDao;
  }
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
  }
  
  public String toMain() throws Exception {
    if (getControl() == null || getControl() == "") {
      setControl("99");
    } else if (this.txtFile != null) {
      if (this.txtFile.length() == 0L) {
        setControl("0");
      } else if (!this.txtFileFileName.toUpperCase().endsWith(".TXT")) {
        setControl("3");
      } else {
        UploadFile uf = new UploadFile();
        uf.upFile(this.txtFile, getTxtFileFileName());
        toQuery();
        setControl("2");
      } 
    } else if (this.txtFile == null) {
      setControl("1");
    } 
    return "success";
  }
  
  public String toQuery() throws Exception {
    HttpSession session = ServletActionContext.getRequest().getSession();
    String LOGUIP = (session.getAttribute("LOGUIP") == null) ? "" : session
      .getAttribute("LOGUIP").toString().trim();
    String LOGDIDCN = (session.getAttribute("LOGDIDCN") == null) ? "" : 
      session.getAttribute("LOGDIDCN").toString().trim();
    String LOGUID = (session.getAttribute("LOGUID") == null) ? "" : session
      .getAttribute("LOGUID").toString().trim();
    if (this.DataType.equals("3")) {
      logger.info("跑居留");
      logger.info(this.il07C01ADao);
      logger.info(LOGUID);
      this.il07C01ADao.insertLog(LOGUID, getTxtFileFileName());
    } else if (this.DataType.equals("4")) {
      logger.info(LOGUID);
      logger.info(String.valueOf(this.FLDTYear) + this.FLDTMonth + this.FLDTDay);
      this.il07C01BDao.insertLog(LOGUID, getTxtFileFileName());
    } 
    return "success";
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL05A03U.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */