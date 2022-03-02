package tw.gov.npa.il.entity.basic;

import java.io.Serializable;
import java.sql.Timestamp;

public class TbSystemFlowStepConfig implements Serializable {
  private Integer stepid;
  
  private String stepname;
  
  private String indexid;
  
  private String stepurl;
  
  private String functag;
  
  private String loadtitle;
  
  private String func;
  
  private String funcdisable;
  
  private Timestamp modified;
  
  private String moduid;
  
  public TbSystemFlowStepConfig() {}
  
  public TbSystemFlowStepConfig(String stepname, String indexid, String functag, String funcdisable) {
    this.stepname = stepname;
    this.indexid = indexid;
    this.functag = functag;
    this.funcdisable = funcdisable;
  }
  
  public TbSystemFlowStepConfig(String stepname, String indexid, String stepurl, String functag, String loadtitle, String func, String funcdisable, Timestamp modified, String moduid) {
    this.stepname = stepname;
    this.indexid = indexid;
    this.stepurl = stepurl;
    this.functag = functag;
    this.loadtitle = loadtitle;
    this.func = func;
    this.funcdisable = funcdisable;
    this.modified = modified;
    this.moduid = moduid;
  }
  
  public Integer getStepid() {
    return this.stepid;
  }
  
  public void setStepid(Integer stepid) {
    this.stepid = stepid;
  }
  
  public String getStepname() {
    return this.stepname;
  }
  
  public void setStepname(String stepname) {
    this.stepname = stepname;
  }
  
  public String getIndexid() {
    return this.indexid;
  }
  
  public void setIndexid(String indexid) {
    this.indexid = indexid;
  }
  
  public String getStepurl() {
    return this.stepurl;
  }
  
  public void setStepurl(String stepurl) {
    this.stepurl = stepurl;
  }
  
  public String getFunctag() {
    return this.functag;
  }
  
  public void setFunctag(String functag) {
    this.functag = functag;
  }
  
  public String getLoadtitle() {
    return this.loadtitle;
  }
  
  public void setLoadtitle(String loadtitle) {
    this.loadtitle = loadtitle;
  }
  
  public String getFunc() {
    return this.func;
  }
  
  public void setFunc(String func) {
    this.func = func;
  }
  
  public String getFuncdisable() {
    return this.funcdisable;
  }
  
  public void setFuncdisable(String funcdisable) {
    this.funcdisable = funcdisable;
  }
  
  public Timestamp getModified() {
    return this.modified;
  }
  
  public void setModified(Timestamp modified) {
    this.modified = modified;
  }
  
  public String getModuid() {
    return this.moduid;
  }
  
  public void setModuid(String moduid) {
    this.moduid = moduid;
  }
  
  public String toString() {
    return "TbSystemFlowStepConfig [stepid=" + this.stepid + ", stepname=" + 
      this.stepname + ", indexid=" + this.indexid + ", stepurl=" + this.stepurl + 
      ", functag=" + this.functag + ", loadtitle=" + this.loadtitle + 
      ", func=" + this.func + ", funcdisable=" + this.funcdisable + 
      ", modified=" + this.modified + ", moduid=" + this.moduid + "]";
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\entity\basic\TbSystemFlowStepConfig.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */