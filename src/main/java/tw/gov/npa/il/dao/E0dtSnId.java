package tw.gov.npa.il.dao;

import java.io.Serializable;
import java.math.BigDecimal;

public class E0dtSnId implements Serializable {
  private BigDecimal e0Sn;
  
  private String e0ServerName;
  
  public E0dtSnId() {}
  
  public E0dtSnId(BigDecimal e0Sn, String e0ServerName) {
    this.e0Sn = e0Sn;
    this.e0ServerName = e0ServerName;
  }
  
  public BigDecimal getE0Sn() {
    return this.e0Sn;
  }
  
  public void setE0Sn(BigDecimal e0Sn) {
    this.e0Sn = e0Sn;
  }
  
  public String getE0ServerName() {
    return this.e0ServerName;
  }
  
  public void setE0ServerName(String e0ServerName) {
    this.e0ServerName = e0ServerName;
  }
  
  public boolean equals(Object other) {
    if (this == other)
      return true; 
    if (other == null)
      return false; 
    if (!(other instanceof E0dtSnId))
      return false; 
    E0dtSnId castOther = (E0dtSnId)other;
    if (getE0Sn() == castOther.getE0Sn() || (getE0Sn() != null && 
      castOther.getE0Sn() != null && getE0Sn().equals(
        castOther.getE0Sn())))
      if (getE0ServerName() == castOther.getE0ServerName() || (
        getE0ServerName() != null && 
        castOther.getE0ServerName() != null && 
        getE0ServerName().equals(castOther.getE0ServerName())))
        return true;  
    return false;
  }
  
  public int hashCode() {
    int result = 17;
    result = 37 * result + (
      (getE0Sn() == null) ? 0 : getE0Sn().hashCode());
    result = 37 * 
      result + (
      (getE0ServerName() == null) ? 0 : getE0ServerName()
      .hashCode());
    return result;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\E0dtSnId.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */