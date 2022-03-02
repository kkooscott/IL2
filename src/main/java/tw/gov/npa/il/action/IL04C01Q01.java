package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import tw.gov.npa.il.dao.Iltb15CountryCode;
import tw.gov.npa.il.dao.Iltb15CountryCodeDAO;
import tw.gov.npa.il.dao.Iltb16JobCode;
import tw.gov.npa.il.dao.Iltb17SchoolCode;
import tw.gov.npa.il.dao.Iltb17SchoolCodeDAO;
import tw.gov.npa.il.dao.Iltb20OnlineReport;
import tw.gov.npa.il.myDao.MyIltb16JobCodeDAO;

public class IL04C01Q01 extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL04C01Q01.class);
  
  List<Iltb17SchoolCode> schoolCodes = new ArrayList<Iltb17SchoolCode>();
  
  List<Iltb15CountryCode> countryCodes = new ArrayList<Iltb15CountryCode>();
  
  List<Iltb16JobCode> jobCodes = new ArrayList<Iltb16JobCode>();
  
  private List<Iltb20OnlineReport> iltb20IdList;
  
  private Date nowDate = new Date();
  
  public List<Iltb20OnlineReport> getIltb20IdList() {
    return this.iltb20IdList;
  }
  
  public void setIltb20IdList(List<Iltb20OnlineReport> iltb20IdList) {
    this.iltb20IdList = iltb20IdList;
  }
  
  public List<Iltb17SchoolCode> getSchoolCodes() {
    return this.schoolCodes;
  }
  
  public void setSchoolCodes(List<Iltb17SchoolCode> schoolCodes) {
    this.schoolCodes = schoolCodes;
  }
  
  public List<Iltb15CountryCode> getCountryCodes() {
    return this.countryCodes;
  }
  
  public void setCountryCodes(List<Iltb15CountryCode> countryCodes) {
    this.countryCodes = countryCodes;
  }
  
  public List<Iltb16JobCode> getJobCodes() {
    return this.jobCodes;
  }
  
  public void setJobCodes(List<Iltb16JobCode> jobCodes) {
    this.jobCodes = jobCodes;
  }
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
  }
  
  public String toMain() throws Exception {
    Iltb17SchoolCodeDAO iltb17SchoolCodeDAO = new Iltb17SchoolCodeDAO();
    this.schoolCodes = iltb17SchoolCodeDAO.findAll();
    MyIltb16JobCodeDAO myIltb16JobCodeDAO = new MyIltb16JobCodeDAO();
    this.jobCodes = myIltb16JobCodeDAO.getDataByIlNtprsq();
    Iltb15CountryCodeDAO iltb15CountryCodeDAO = new Iltb15CountryCodeDAO();
    this.countryCodes = iltb15CountryCodeDAO.findAll();
    return "success";
  }
  
  public String toQuery() throws Exception {
    return "success";
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL04C01Q01.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */