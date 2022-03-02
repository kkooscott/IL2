package tw.gov.npa.il.dao;

import java.io.Serializable;
import java.sql.Timestamp;

public class IltbSystemFlowStepConfig implements Serializable {
  private Integer ilStepid;
  
  private String ilStepname;
  
  private String ilIndexid;
  
  private String ilStepurl;
  
  private String ilFunctag;
  
  private String ilLoadtitle;
  
  private String ilFunc;
  
  private String ilFuncDisable;
  
  private Timestamp ilModified;
  
  private String ilModuid;
  
  public IltbSystemFlowStepConfig() {}
  
  public IltbSystemFlowStepConfig(String ilStepname, String ilIndexid, String ilFunctag, String ilFuncDisable) {
    this.ilStepname = ilStepname;
    this.ilIndexid = ilIndexid;
    this.ilFunctag = ilFunctag;
    this.ilFuncDisable = ilFuncDisable;
  }
  
  public IltbSystemFlowStepConfig(String ilStepname, String ilIndexid, String ilStepurl, String ilFunctag, String ilLoadtitle, String ilFunc, String ilFuncDisable, Timestamp ilModified, String ilModuid) {
    this.ilStepname = ilStepname;
    this.ilIndexid = ilIndexid;
    this.ilStepurl = ilStepurl;
    this.ilFunctag = ilFunctag;
    this.ilLoadtitle = ilLoadtitle;
    this.ilFunc = ilFunc;
    this.ilFuncDisable = ilFuncDisable;
    this.ilModified = ilModified;
    this.ilModuid = ilModuid;
  }
  
  public Integer getIlStepid() {
    return this.ilStepid;
  }
  
  public void setIlStepid(Integer ilStepid) {
    this.ilStepid = ilStepid;
  }
  
  public String getIlStepname() {
    return this.ilStepname;
  }
  
  public void setIlStepname(String ilStepname) {
    this.ilStepname = ilStepname;
  }
  
  public String getIlIndexid() {
    return this.ilIndexid;
  }
  
  public void setIlIndexid(String ilIndexid) {
    this.ilIndexid = ilIndexid;
  }
  
  public String getIlStepurl() {
    return this.ilStepurl;
  }
  
  public void setIlStepurl(String ilStepurl) {
    this.ilStepurl = ilStepurl;
  }
  
  public String getIlFunctag() {
    return this.ilFunctag;
  }
  
  public void setIlFunctag(String ilFunctag) {
    this.ilFunctag = ilFunctag;
  }
  
  public String getIlLoadtitle() {
    return this.ilLoadtitle;
  }
  
  public void setIlLoadtitle(String ilLoadtitle) {
    this.ilLoadtitle = ilLoadtitle;
  }
  
  public String getIlFunc() {
    return this.ilFunc;
  }
  
  public void setIlFunc(String ilFunc) {
    this.ilFunc = ilFunc;
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


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\IltbSystemFlowStepConfig.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */