package tw.gov.npa.il.dao;

import java.io.Serializable;
import java.sql.Timestamp;

public class IlScheduleMngId implements Serializable {
  private Integer id;
  
  private String sgroup;
  
  private String type;
  
  private Timestamp stime;
  
  private Timestamp etime;
  
  private String status;
  
  private String muserName;
  
  private String munitId;
  
  public IlScheduleMngId() {}
  
  public IlScheduleMngId(Integer id, String type, String status) {
    this.id = id;
    this.type = type;
    this.status = status;
  }
  
  public IlScheduleMngId(Integer id, String sgroup, String type, Timestamp stime, Timestamp etime, String status, String muserName, String munitId) {
    this.id = id;
    this.sgroup = sgroup;
    this.type = type;
    this.stime = stime;
    this.etime = etime;
    this.status = status;
    this.muserName = muserName;
    this.munitId = munitId;
  }
  
  public Integer getId() {
    return this.id;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public String getSgroup() {
    return this.sgroup;
  }
  
  public void setSgroup(String sgroup) {
    this.sgroup = sgroup;
  }
  
  public String getType() {
    return this.type;
  }
  
  public void setType(String type) {
    this.type = type;
  }
  
  public Timestamp getStime() {
    return this.stime;
  }
  
  public void setStime(Timestamp stime) {
    this.stime = stime;
  }
  
  public Timestamp getEtime() {
    return this.etime;
  }
  
  public void setEtime(Timestamp etime) {
    this.etime = etime;
  }
  
  public String getStatus() {
    return this.status;
  }
  
  public void setStatus(String status) {
    this.status = status;
  }
  
  public String getMuserName() {
    return this.muserName;
  }
  
  public void setMuserName(String muserName) {
    this.muserName = muserName;
  }
  
  public String getMunitId() {
    return this.munitId;
  }
  
  public void setMunitId(String munitId) {
    this.munitId = munitId;
  }
  
  public boolean equals(Object other) {
    if (this == other)
      return true; 
    if (other == null)
      return false; 
    if (!(other instanceof IlScheduleMngId))
      return false; 
    IlScheduleMngId castOther = (IlScheduleMngId)other;
    if (getId() == castOther.getId() || (getId() != null && 
      castOther.getId() != null && getId().equals(
        castOther.getId())))
      if ((getSgroup() == castOther.getSgroup() || (
        getSgroup() != null && castOther.getSgroup() != null && 
        getSgroup().equals(castOther.getSgroup()))) && (
        getType() == castOther.getType() || (getType() != null && 
        castOther.getType() != null && getType()
        .equals(castOther.getType()))) && (
        getStime() == castOther.getStime() || (
        getStime() != null && castOther.getStime() != null && 
        getStime().equals(castOther.getStime()))) && (
        getEtime() == castOther.getEtime() || (
        getEtime() != null && castOther.getEtime() != null && 
        getEtime().equals(castOther.getEtime()))) && (
        getStatus() == castOther.getStatus() || (
        getStatus() != null && castOther.getStatus() != null && 
        getStatus().equals(castOther.getStatus()))) && (
        getMuserName() == castOther.getMuserName() || (
        getMuserName() != null && 
        castOther.getMuserName() != null && 
        getMuserName().equals(castOther.getMuserName()))) && (
        getMunitId() == castOther.getMunitId() || (
        getMunitId() != null && castOther.getMunitId() != null && 
        getMunitId().equals(castOther.getMunitId()))))
        return true;  
    return false;
  }
  
  public int hashCode() {
    int result = 17;
    result = 37 * result + ((getId() == null) ? 0 : getId().hashCode());
    result = 37 * result + (
      (getSgroup() == null) ? 0 : getSgroup().hashCode());
    result = 37 * result + (
      (getType() == null) ? 0 : getType().hashCode());
    result = 37 * result + (
      (getStime() == null) ? 0 : getStime().hashCode());
    result = 37 * result + (
      (getEtime() == null) ? 0 : getEtime().hashCode());
    result = 37 * result + (
      (getStatus() == null) ? 0 : getStatus().hashCode());
    result = 37 * result + (
      (getMuserName() == null) ? 0 : getMuserName().hashCode());
    result = 37 * result + (
      (getMunitId() == null) ? 0 : getMunitId().hashCode());
    return result;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\IlScheduleMngId.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */