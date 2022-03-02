package tw.gov.npa.il.dao;

import java.io.Serializable;
import java.sql.Timestamp;

public class Iltb03MainRecordId implements Serializable {
  private Integer ilArcid;
  
  private Timestamp ilApydt;
  
  private Short ilSeq;
  
  public Iltb03MainRecordId() {}
  
  public Iltb03MainRecordId(Integer ilArcid, Timestamp ilApydt, Short ilSeq) {
    this.ilArcid = ilArcid;
    this.ilApydt = ilApydt;
    this.ilSeq = ilSeq;
  }
  
  public Integer getIlArcid() {
    return this.ilArcid;
  }
  
  public void setIlArcid(Integer ilArcid) {
    this.ilArcid = ilArcid;
  }
  
  public Timestamp getIlApydt() {
    return this.ilApydt;
  }
  
  public void setIlApydt(Timestamp ilApydt) {
    this.ilApydt = ilApydt;
  }
  
  public Short getIlSeq() {
    return this.ilSeq;
  }
  
  public void setIlSeq(Short ilSeq) {
    this.ilSeq = ilSeq;
  }
  
  public boolean equals(Object other) {
    if (this == other)
      return true; 
    if (other == null)
      return false; 
    if (!(other instanceof Iltb03MainRecordId))
      return false; 
    Iltb03MainRecordId castOther = (Iltb03MainRecordId)other;
    return ((getIlArcid() == castOther.getIlArcid() || (getIlArcid() != null && castOther.getIlArcid() != null && getIlArcid().equals(castOther.getIlArcid()))) && (getIlApydt() == castOther.getIlApydt() || (getIlApydt() != null && castOther.getIlApydt() != null && getIlApydt().equals(castOther.getIlApydt()))) && (getIlSeq() == castOther.getIlSeq() || (getIlSeq() != null && castOther.getIlSeq() != null && getIlSeq().equals(castOther.getIlSeq()))));
  }
  
  public int hashCode() {
    int result = 17;
    result = 37 * result + ((getIlArcid() == null) ? 0 : getIlArcid().hashCode());
    result = 37 * result + ((getIlApydt() == null) ? 0 : getIlApydt().hashCode());
    result = 37 * result + ((getIlSeq() == null) ? 0 : getIlSeq().hashCode());
    return result;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\Iltb03MainRecordId.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */