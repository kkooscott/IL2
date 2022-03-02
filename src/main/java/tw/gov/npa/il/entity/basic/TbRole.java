package tw.gov.npa.il.entity.basic;

import java.sql.Timestamp;

public class TbRole {
  private int roleNo;
  
  private String role;
  
  private String roleNm;
  
  private Timestamp modified;
  
  private String moduid;
  
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
    return "TbRole [roleNo=" + this.roleNo + ", role=" + this.role + ", roleNm=" + 
      this.roleNm + ", modified=" + this.modified + ", moduid=" + this.moduid + 
      "]";
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\entity\basic\TbRole.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */