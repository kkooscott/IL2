package tw.gov.npa.il.dao;

import java.io.Serializable;
import java.sql.Timestamp;

public class Iltb19DataProcess implements Serializable {
  private Iltb19DataProcessId id;
  
  private String ilCmdline;
  
  private Integer ilStatus;
  
  private Timestamp ilModified;
  
  public Iltb19DataProcess() {}
  
  public Iltb19DataProcess(Iltb19DataProcessId id, String ilCmdline, Integer ilStatus) {
    this.id = id;
    this.ilCmdline = ilCmdline;
    this.ilStatus = ilStatus;
  }
  
  public Iltb19DataProcess(Iltb19DataProcessId id, String ilCmdline, Integer ilStatus, Timestamp ilModified) {
    this.id = id;
    this.ilCmdline = ilCmdline;
    this.ilStatus = ilStatus;
    this.ilModified = ilModified;
  }
  
  public Iltb19DataProcessId getId() {
    return this.id;
  }
  
  public void setId(Iltb19DataProcessId id) {
    this.id = id;
  }
  
  public String getIlCmdline() {
    return this.ilCmdline;
  }
  
  public void setIlCmdline(String ilCmdline) {
    this.ilCmdline = ilCmdline;
  }
  
  public Integer getIlStatus() {
    return this.ilStatus;
  }
  
  public void setIlStatus(Integer ilStatus) {
    this.ilStatus = ilStatus;
  }
  
  public Timestamp getIlModified() {
    return this.ilModified;
  }
  
  public void setIlModified(Timestamp ilModified) {
    this.ilModified = ilModified;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\Iltb19DataProcess.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */