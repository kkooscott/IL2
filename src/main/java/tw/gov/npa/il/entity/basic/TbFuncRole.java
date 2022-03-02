package tw.gov.npa.il.entity.basic;

import java.sql.Timestamp;

public class TbFuncRole {
  private int funcRoleNo;
  
  private int funcNo;
  
  private String func;
  
  private String funcNm;
  
  private int roleNo;
  
  private String role;
  
  private String roleNm;
  
  private String enable;
  
  private Timestamp modified;
  
  private String moduid;
  
  public int getFuncRoleNo() {
    return this.funcRoleNo;
  }
  
  public void setFuncRoleNo(int funcRoleNo) {
    this.funcRoleNo = funcRoleNo;
  }
  
  public int getFuncNo() {
    return this.funcNo;
  }
  
  public void setFuncNo(int funcNo) {
    this.funcNo = funcNo;
  }
  
  public String getFunc() {
    return this.func;
  }
  
  public void setFunc(String func) {
    this.func = func;
  }
  
  public String getFuncNm() {
    return this.funcNm;
  }
  
  public void setFuncNm(String funcNm) {
    this.funcNm = funcNm;
  }
  
  public int getRoleNo() {
    return this.roleNo;
  }
  
  public void setRoleNo(int roleNo) {
    this.roleNo = roleNo;
  }
  
  public String getRole() {
    return this.role;
  }
  
  public void setRole(String role) {
    this.role = role;
  }
  
  public String getRoleNm() {
    return this.roleNm;
  }
  
  public void setRoleNm(String roleNm) {
    this.roleNm = roleNm;
  }
  
  public String getEnable() {
    return this.enable;
  }
  
  public void setEnable(String enable) {
    this.enable = enable;
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
    return "TbFuncRole [funcRoleNo=" + this.funcRoleNo + ", funcNo=" + this.funcNo + 
      ", func=" + this.func + ", funcNm=" + this.funcNm + ", roleNo=" + 
      this.roleNo + ", role=" + this.role + ", roleNm=" + this.roleNm + 
      ", enable=" + this.enable + ", modified=" + this.modified + ", moduid=" + 
      this.moduid + "]";
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\entity\basic\TbFuncRole.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */