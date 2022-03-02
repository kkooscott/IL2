package tw.gov.npa.il.dao;

import java.io.Serializable;
import java.sql.Timestamp;

public class IltbFuncRole implements Serializable {
  private Integer ilFuncRoleNo;
  
  private Integer ilFuncNo;
  
  private String ilFunc;
  
  private String ilFuncNm;
  
  private Integer ilRoleNo;
  
  private String ilRole;
  
  private String ilRoleNm;
  
  private String ilEnable;
  
  private Timestamp ilModified;
  
  private String ilModuid;
  
  public IltbFuncRole() {}
  
  public IltbFuncRole(Integer ilFuncNo, Integer ilRoleNo, String ilEnable) {
    this.ilFuncNo = ilFuncNo;
    this.ilRoleNo = ilRoleNo;
    this.ilEnable = ilEnable;
  }
  
  public IltbFuncRole(Integer ilFuncNo, String ilFunc, String ilFuncNm, Integer ilRoleNo, String ilRole, String ilRoleNm, String ilEnable, Timestamp ilModified, String ilModuid) {
    this.ilFuncNo = ilFuncNo;
    this.ilFunc = ilFunc;
    this.ilFuncNm = ilFuncNm;
    this.ilRoleNo = ilRoleNo;
    this.ilRole = ilRole;
    this.ilRoleNm = ilRoleNm;
    this.ilEnable = ilEnable;
    this.ilModified = ilModified;
    this.ilModuid = ilModuid;
  }
  
  public Integer getIlFuncRoleNo() {
    return this.ilFuncRoleNo;
  }
  
  public void setIlFuncRoleNo(Integer ilFuncRoleNo) {
    this.ilFuncRoleNo = ilFuncRoleNo;
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
  
  public String getIlEnable() {
    return this.ilEnable;
  }
  
  public void setIlEnable(String ilEnable) {
    this.ilEnable = ilEnable;
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


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\IltbFuncRole.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */