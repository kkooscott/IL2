package tw.gov.npa.il.dao;

import java.io.Serializable;
import java.sql.Timestamp;

public class Iltb04InRecordId implements Serializable {
  private Integer ilArcid;
  
  private Timestamp ilPtrldt;
  
  public Iltb04InRecordId() {}
  
  public Iltb04InRecordId(Integer ilArcid, Timestamp ilPtrldt) {
    this.ilArcid = ilArcid;
    this.ilPtrldt = ilPtrldt;
  }
  
  public Integer getIlArcid() {
    return this.ilArcid;
  }
  
  public void setIlArcid(Integer ilArcid) {
    this.ilArcid = ilArcid;
  }
  
  public Timestamp getIlPtrldt() {
    return this.ilPtrldt;
  }
  
  public void setIlPtrldt(Timestamp ilPtrldt) {
    this.ilPtrldt = ilPtrldt;
  }
  
  public boolean equals(Object other) {
    if (this == other)
      return true; 
    if (other == null)
      return false; 
    if (!(other instanceof Iltb04InRecordId))
      return false; 
    Iltb04InRecordId castOther = (Iltb04InRecordId)other;
    if ((getIlArcid() == castOther.getIlArcid() || (
      getIlArcid() != null && castOther.getIlArcid() != null && 
      getIlArcid().equals(castOther.getIlArcid()))) && (
      getIlPtrldt() == castOther.getIlPtrldt() || (
      getIlPtrldt() != null && 
      castOther.getIlPtrldt() != null && 
      getIlPtrldt().equals(castOther.getIlPtrldt()))))
      return true; 
    return false;
  }
  
  public int hashCode() {
    int result = 17;
    result = 37 * result + (
      (getIlArcid() == null) ? 0 : getIlArcid().hashCode());
    result = 37 * result + (
      (getIlPtrldt() == null) ? 0 : getIlPtrldt().hashCode());
    return result;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\Iltb04InRecordId.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */