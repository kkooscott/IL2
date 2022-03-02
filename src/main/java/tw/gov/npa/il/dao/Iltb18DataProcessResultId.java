package tw.gov.npa.il.dao;

import java.io.Serializable;
import java.sql.Timestamp;

public class Iltb18DataProcessResultId implements Serializable {
  private Timestamp ilImpdt;
  
  private String ilImptp;
  
  public Iltb18DataProcessResultId() {}
  
  public Iltb18DataProcessResultId(Timestamp ilImpdt, String ilImptp) {
    this.ilImpdt = ilImpdt;
    this.ilImptp = ilImptp;
  }
  
  public Timestamp getIlImpdt() {
    return this.ilImpdt;
  }
  
  public void setIlImpdt(Timestamp ilImpdt) {
    this.ilImpdt = ilImpdt;
  }
  
  public String getIlImptp() {
    return this.ilImptp;
  }
  
  public void setIlImptp(String ilImptp) {
    this.ilImptp = ilImptp;
  }
  
  public boolean equals(Object other) {
    if (this == other)
      return true; 
    if (other == null)
      return false; 
    if (!(other instanceof Iltb18DataProcessResultId))
      return false; 
    Iltb18DataProcessResultId castOther = (Iltb18DataProcessResultId)other;
    if ((getIlImpdt() == castOther.getIlImpdt() || (
      getIlImpdt() != null && castOther.getIlImpdt() != null && 
      getIlImpdt().equals(castOther.getIlImpdt()))) && (
      getIlImptp() == castOther.getIlImptp() || (
      getIlImptp() != null && castOther.getIlImptp() != null && 
      getIlImptp().equals(castOther.getIlImptp()))))
      return true; 
    return false;
  }
  
  public int hashCode() {
    int result = 17;
    result = 37 * result + (
      (getIlImpdt() == null) ? 0 : getIlImpdt().hashCode());
    result = 37 * result + (
      (getIlImptp() == null) ? 0 : getIlImptp().hashCode());
    return result;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\Iltb18DataProcessResultId.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */