package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import org.apache.log4j.Logger;

public class IL03B01P01 extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL03B01P01.class);
  
  private Date nowDate = new Date();
  
  private int ilArcid;
  
  private String ilPst;
  
  private String ilZipCode;
  
  private String ilZipCodeName;
  
  private String ilZipCodeList;
  
  private String ilZipFullNameList;
  
  private String ilPstext;
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public int getIlArcid() {
    return this.ilArcid;
  }
  
  public void setIlArcid(int ilArcid) {
    this.ilArcid = ilArcid;
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
    this.ilZipFullNameList = ilZipFullNameList.replace("　", "");
  }
  
  public String getIlPstext() {
    return this.ilPstext;
  }
  
  public void setIlPstext(String ilPstext) {
    this.ilPstext = ilPstext;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
  }
  
  public String toMain() throws Exception {
    return "success";
  }
  
  public String toQuery() throws Exception {
    return "success";
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL03B01P01.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */