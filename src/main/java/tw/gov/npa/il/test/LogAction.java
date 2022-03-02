package tw.gov.npa.il.test;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.log4j.Logger;
import tw.gov.npa.il.util.NTPCUtil;

public class LogAction extends ActionSupport {
  private static final Logger logger = Logger.getLogger(LogAction.class);
  
  private NTPCUtil ntpcUtil = new NTPCUtil();
  
  private Boolean hasQuery;
  
  private boolean android;
  
  private boolean ios;
  
  private String fromDate;
  
  private String fromTime;
  
  private String toDate;
  
  private String toTime;
  
  private String unit1Cd;
  
  private String unit2Cd;
  
  private String unit3Cd;
  
  private String appName;
  
  private String loginEid;
  
  private String deviceName;
  
  private List<Log> queryList;
  
  private InputStream excelStream;
  
  private String contentDisposition;
  
  public String doDownloadLogExcel() throws JRException {
    logger.debug("doDownloadLogreport touched");
    if (this.fromTime == null || this.fromTime.isEmpty())
      this.fromTime = "00:00"; 
    if (this.toTime == null || this.toTime.isEmpty())
      this.toTime = "23:59"; 
    String checkMessage = NTPCUtil.checkDate(this.fromDate, this.fromTime, this.toDate, this.toTime);
    LogQueryBean qb = new LogQueryBean();
    qb.setAndroid(Boolean.valueOf(this.android));
    qb.setIos(Boolean.valueOf(this.ios));
    qb.setAppName(this.appName);
    qb.setDeviceName(this.deviceName);
    qb.setFromDate(this.fromDate);
    qb.setFromTime(this.fromTime);
    qb.setToDate(this.toDate);
    qb.setToTime(this.toTime);
    qb.setLoginEid(this.loginEid);
    qb.setUnit1Cd(this.unit1Cd);
    qb.setUnit2Cd(this.unit2Cd);
    qb.setUnit3Cd(this.unit3Cd);
    List<Log> logList = new ArrayList<Log>();
    JRBeanCollectionDataSource jRMainTotalDS = new JRBeanCollectionDataSource(logList);
    HashMap<String, Object> param = new HashMap<String, Object>();
    ActionContext context = ActionContext.getContext();
    String printUnit = (String)context.getSession().get("LOGDIDCN");
    String unitName = "Hi";
    param.put("STARTDATE", String.valueOf(this.fromDate) + " " + this.fromTime);
    param.put("ENDDATE", String.valueOf(this.toDate) + " " + this.toTime);
    param.put("UNITNAME", unitName);
    param.put("PRINTUNIT", printUnit);
    param.put("PRINTTIME", NTPCUtil.dateFormat.format(new Date()));
    String fileName = "download_log";
    this.excelStream = NTPCUtil.createExcel("", fileName, param, jRMainTotalDS);
    if (this.excelStream == null)
      return "error"; 
    this.contentDisposition = "filename=\"" + this.ntpcUtil.appendDateString(fileName) + ".xls\"";
    return "downloadExcel";
  }
  
  public Boolean getHasQuery() {
    return this.hasQuery;
  }
  
  public NTPCUtil getNtpcUtil() {
    return this.ntpcUtil;
  }
  
  public void setNtpcUtil(NTPCUtil ntpcUtil) {
    this.ntpcUtil = ntpcUtil;
  }
  
  public void setHasQuery(Boolean hasQuery) {
    this.hasQuery = hasQuery;
  }
  
  public boolean isAndroid() {
    return this.android;
  }
  
  public void setAndroid(boolean android) {
    this.android = android;
  }
  
  public boolean isIos() {
    return this.ios;
  }
  
  public void setIos(boolean ios) {
    this.ios = ios;
  }
  
  public String getFromDate() {
    return this.fromDate;
  }
  
  public void setFromDate(String fromDate) {
    this.fromDate = fromDate;
  }
  
  public String getFromTime() {
    return this.fromTime;
  }
  
  public void setFromTime(String fromTime) {
    this.fromTime = fromTime;
  }
  
  public String getToDate() {
    return this.toDate;
  }
  
  public void setToDate(String toDate) {
    this.toDate = toDate;
  }
  
  public String getToTime() {
    return this.toTime;
  }
  
  public void setToTime(String toTime) {
    this.toTime = toTime;
  }
  
  public String getUnit1Cd() {
    return this.unit1Cd;
  }
  
  public void setUnit1Cd(String unit1Cd) {
    this.unit1Cd = unit1Cd;
  }
  
  public String getUnit2Cd() {
    return this.unit2Cd;
  }
  
  public void setUnit2Cd(String unit2Cd) {
    this.unit2Cd = unit2Cd;
  }
  
  public String getUnit3Cd() {
    return this.unit3Cd;
  }
  
  public void setUnit3Cd(String unit3Cd) {
    this.unit3Cd = unit3Cd;
  }
  
  public String getAppName() {
    return this.appName;
  }
  
  public void setAppName(String appName) {
    this.appName = appName;
  }
  
  public String getLoginEid() {
    return this.loginEid;
  }
  
  public void setLoginEid(String loginEid) {
    this.loginEid = loginEid;
  }
  
  public String getDeviceName() {
    return this.deviceName;
  }
  
  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }
  
  public List<Log> getQueryList() {
    return this.queryList;
  }
  
  public void setQueryList(List<Log> queryList) {
    this.queryList = queryList;
  }
  
  public InputStream getExcelStream() {
    return this.excelStream;
  }
  
  public void setExcelStream(InputStream excelStream) {
    this.excelStream = excelStream;
  }
  
  public String getContentDisposition() {
    return this.contentDisposition;
  }
  
  public void setContentDisposition(String contentDisposition) {
    this.contentDisposition = contentDisposition;
  }
  
  private void logParameter() {
    logger.debug(Boolean.valueOf(this.android));
    logger.debug(Boolean.valueOf(this.ios));
    logger.debug(this.appName);
    logger.debug(this.deviceName);
    logger.debug(this.fromDate);
    logger.debug(this.fromTime);
    logger.debug(this.toDate);
    logger.debug(this.toTime);
    logger.debug(this.loginEid);
    logger.debug(this.unit1Cd);
    logger.debug(this.unit2Cd);
    logger.debug(this.unit3Cd);
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\test\LogAction.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */