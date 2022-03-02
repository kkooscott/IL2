package tw.gov.npa.il.dao;

import java.io.Serializable;
import java.sql.Timestamp;

public class Iltb19DataProcessId implements Serializable {
  private String ilIp;
  
  private Timestamp ilOptime;
  
  public Iltb19DataProcessId() {}
  
  public Iltb19DataProcessId(String ilIp, Timestamp ilOptime) {
    this.ilIp = ilIp;
    this.ilOptime = ilOptime;
  }
  
  public String getIlIp() {
    return this.ilIp;
  }
  
  public void setIlIp(String ilIp) {
    this.ilIp = ilIp;
  }
  
  public Timestamp getIlOptime() {
    return this.ilOptime;
  }
  
  public void setIlOptime(Timestamp ilOptime) {
    this.ilOptime = ilOptime;
  }
  
  public boolean equals(Object other) {
    if (this == other)
      return true; 
    if (other == null)
      return false; 
    if (!(other instanceof Iltb19DataProcessId))
      return false; 
    Iltb19DataProcessId castOther = (Iltb19DataProcessId)other;
    if (getIlIp() == castOther.getIlIp() || (getIlIp() != null && 
      castOther.getIlIp() != null && getIlIp().equals(
        castOther.getIlIp())))
      if (getIlOptime() == castOther.getIlOptime() || (
        getIlOptime() != null && 
        castOther.getIlOptime() != null && 
        getIlOptime().equals(castOther.getIlOptime())))
        return true;  
    return false;
  }
  
  public int hashCode() {
    int result = 17;
    result = 37 * result + (
      (getIlIp() == null) ? 0 : getIlIp().hashCode());
    result = 37 * result + (
      (getIlOptime() == null) ? 0 : getIlOptime().hashCode());
    return result;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\Iltb19DataProcessId.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */