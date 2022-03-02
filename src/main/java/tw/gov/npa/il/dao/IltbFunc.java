package tw.gov.npa.il.dao;

import java.io.Serializable;
import java.sql.Timestamp;

public class IltbFunc implements Serializable {
  private Integer ilFuncNo;
  
  private String ilFunc;
  
  private String ilFuncNm;
  
  private String ilFuncUrl;
  
  private String ilFuncGroup;
  
  private String ilFuncDisable;
  
  private Timestamp ilModified;
  
  private String ilModuid;
  
  public IltbFunc() {}
  
  public IltbFunc(String ilFunc, String ilFuncNm, String ilFuncGroup, String ilFuncDisable) {
    this.ilFunc = ilFunc;
    this.ilFuncNm = ilFuncNm;
    this.ilFuncGroup = ilFuncGroup;
    this.ilFuncDisable = ilFuncDisable;
  }
  
  public IltbFunc(String ilFunc, String ilFuncNm, String ilFuncUrl, String ilFuncGroup, String ilFuncDisable, Timestamp ilModified, String ilModuid) {
    this.ilFunc = ilFunc;
    this.ilFuncNm = ilFuncNm;
    this.ilFuncUrl = ilFuncUrl;
    this.ilFuncGroup = ilFuncGroup;
    this.ilFuncDisable = ilFuncDisable;
    this.ilModified = ilModified;
    this.ilModuid = ilModuid;
  }
  
  public Integer getIlFuncNo() {
    return this.ilFuncNo;
  }
  
  public void setIlFuncNo(Integer ilFuncNo) {
    this.ilFuncNo = ilFuncNo;
  }
  
  public String getIlFunc() {
    return this.ilFunc;
  }
  
  public void setIlFunc(String ilFunc) {
    this.ilFunc = ilFunc;
  }
  
  public String getIlFuncNm() {
    return this.ilFuncNm;
  }
  
  public void setIlFuncNm(String ilFuncNm) {
    this.ilFuncNm = ilFuncNm;
  }
  
  public String getIlFuncUrl() {
    return this.ilFuncUrl;
  }
  
  public void setIlFuncUrl(String ilFuncUrl) {
    this.ilFuncUrl = ilFuncUrl;
  }
  
  public String getIlFuncGroup() {
    return this.ilFuncGroup;
  }
  
  public void setIlFuncGroup(String ilFuncGroup) {
    this.ilFuncGroup = ilFuncGroup;
  }
  
  public String getIlFuncDisable() {
    return this.ilFuncDisable;
  }
  
  public void setIlFuncDisable(String ilFuncDisable) {
    this.ilFuncDisable = ilFuncDisable;
  }
  
  public Timestamp getIlModified() {
    return this.ilModified;
  }
  
  public void setIlModified(Timestamp ilModified) {
    this.ilModified = ilModified;
  }
  
  public String getIlModuid() {
    return this.ilModuid;
  }
  
  public void setIlModuid(String ilModuid) {
    this.ilModuid = ilModuid;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\IltbFunc.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */