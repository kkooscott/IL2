package tw.gov.npa.il.dao;

import java.io.Serializable;

public class IltbFuncRoleId implements Serializable {
  private Integer ilFuncRoleNo;
  
  private Integer ilFuncNo;
  
  private Integer ilRoleNo;
  
  public IltbFuncRoleId() {}
  
  public IltbFuncRoleId(Integer ilFuncRoleNo, Integer ilFuncNo, Integer ilRoleNo) {
    this.ilFuncRoleNo = ilFuncRoleNo;
    this.ilFuncNo = ilFuncNo;
    this.ilRoleNo = ilRoleNo;
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
  
  public Integer getIlRoleNo() {
    return this.ilRoleNo;
  }
  
  public void setIlRoleNo(Integer ilRoleNo) {
    this.ilRoleNo = ilRoleNo;
  }
  
  public boolean equals(Object other) {
    if (this == other)
      return true; 
    if (other == null)
      return false; 
    if (!(other instanceof IltbFuncRoleId))
      return false; 
    IltbFuncRoleId castOther = (IltbFuncRoleId)other;
    if ((getIlFuncRoleNo() == castOther.getIlFuncRoleNo() || (
      getIlFuncRoleNo() != null && 
      castOther.getIlFuncRoleNo() != null && 
      getIlFuncRoleNo().equals(castOther.getIlFuncRoleNo()))) && (
      getIlFuncNo() == castOther.getIlFuncNo() || (
      getIlFuncNo() != null && 
      castOther.getIlFuncNo() != null && 
      getIlFuncNo().equals(castOther.getIlFuncNo()))) && (
      getIlRoleNo() == castOther.getIlRoleNo() || (
      getIlRoleNo() != null && 
      castOther.getIlRoleNo() != null && 
      getIlRoleNo().equals(castOther.getIlRoleNo()))))
      return true; 
    return false;
  }
  
  public int hashCode() {
    int result = 17;
    result = 37 * 
      result + (
      (getIlFuncRoleNo() == null) ? 0 : getIlFuncRoleNo()
      .hashCode());
    result = 37 * result + (
      (getIlFuncNo() == null) ? 0 : getIlFuncNo().hashCode());
    result = 37 * result + (
      (getIlRoleNo() == null) ? 0 : getIlRoleNo().hashCode());
    return result;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\IltbFuncRoleId.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */