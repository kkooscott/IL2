package tw.gov.npa.il.dao;

import java.io.Serializable;
import java.sql.Timestamp;

public class IltbRole implements Serializable {
  private Integer ilRoleNo;
  
  private String ilRole;
  
  private String ilRoleNm;
  
  private Timestamp ilModified;
  
  private String ilModuid;
  
  public IltbRole() {}
  
  public IltbRole(String ilRole, String ilRoleNm) {
    this.ilRole = ilRole;
    this.ilRoleNm = ilRoleNm;
  }
  
  public IltbRole(String ilRole, String ilRoleNm, Timestamp ilModified, String ilModuid) {
    this.ilRole = ilRole;
    this.ilRoleNm = ilRoleNm;
    this.ilModified = ilModified;
    this.ilModuid = ilModuid;
  }
  
  public Integer getIlRoleNo() {
    return this.ilRoleNo;
  }
  
  public void setIlRoleNo(Integer ilRoleNo) {
    this.ilRoleNo = ilRoleNo;
  }
  
  public String getIlRole() {
    return this.ilRole;
  }
  
  public void setIlRole(String ilRole) {
    this.ilRole = ilRole;
  }
  
  public String getIlRoleNm() {
    return this.ilRoleNm;
  }
  
  public void setIlRoleNm(String ilRoleNm) {
    this.ilRoleNm = ilRoleNm;
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


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\IltbRole.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */