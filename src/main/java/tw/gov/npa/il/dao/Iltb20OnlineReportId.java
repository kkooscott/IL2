package tw.gov.npa.il.dao;

import java.io.Serializable;
import java.sql.Timestamp;

public class Iltb20OnlineReportId implements Serializable {
  private String ilUid;
  
  private String ilRptid;
  
  private Timestamp ilSnddt;
  
  public Iltb20OnlineReportId() {}
  
  public Iltb20OnlineReportId(String ilUid, String ilRptid, Timestamp ilSnddt) {
    this.ilUid = ilUid;
    this.ilRptid = ilRptid;
    this.ilSnddt = ilSnddt;
  }
  
  public String getIlUid() {
    return this.ilUid;
  }
  
  public void setIlUid(String ilUid) {
    this.ilUid = ilUid;
  }
  
  public String getIlRptid() {
    return this.ilRptid;
  }
  
  public void setIlRptid(String ilRptid) {
    this.ilRptid = ilRptid;
  }
  
  public Timestamp getIlSnddt() {
    return this.ilSnddt;
  }
  
  public void setIlSnddt(Timestamp ilSnddt) {
    this.ilSnddt = ilSnddt;
  }
  
  public boolean equals(Object other) {
    if (this == other)
      return true; 
    if (other == null)
      return false; 
    if (!(other instanceof Iltb20OnlineReportId))
      return false; 
    Iltb20OnlineReportId castOther = (Iltb20OnlineReportId)other;
    if (getIlUid() == castOther.getIlUid() || (getIlUid() != null && 
      castOther.getIlUid() != null && getIlUid().equals(
        castOther.getIlUid())))
      if ((getIlRptid() == castOther.getIlRptid() || (
        getIlRptid() != null && castOther.getIlRptid() != null && 
        getIlRptid().equals(castOther.getIlRptid()))) && (
        getIlSnddt() == castOther.getIlSnddt() || (
        getIlSnddt() != null && castOther.getIlSnddt() != null && 
        getIlSnddt().equals(castOther.getIlSnddt()))))
        return true;  
    return false;
  }
  
  public int hashCode() {
    int result = 17;
    result = 37 * result + (
      (getIlUid() == null) ? 0 : getIlUid().hashCode());
    result = 37 * result + (
      (getIlRptid() == null) ? 0 : getIlRptid().hashCode());
    result = 37 * result + (
      (getIlSnddt() == null) ? 0 : getIlSnddt().hashCode());
    return result;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\Iltb20OnlineReportId.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */