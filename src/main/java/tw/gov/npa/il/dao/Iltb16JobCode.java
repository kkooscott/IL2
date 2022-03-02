package tw.gov.npa.il.dao;

import java.io.Serializable;
import java.sql.Timestamp;

public class Iltb16JobCode implements Serializable {
  private String ilOpcd;
  
  private String ilOpnm;
  
  private Short ilOpprsq;
  
  private String ilOpcs;
  
  private Timestamp ilLmd;
  
  public Iltb16JobCode() {}
  
  public Iltb16JobCode(String ilOpnm, Short ilOpprsq, String ilOpcs, Timestamp ilLmd) {
    this.ilOpnm = ilOpnm;
    this.ilOpprsq = ilOpprsq;
    this.ilOpcs = ilOpcs;
    this.ilLmd = ilLmd;
  }
  
  public String getIlOpcd() {
    return this.ilOpcd;
  }
  
  public void setIlOpcd(String ilOpcd) {
    this.ilOpcd = ilOpcd;
  }
  
  public String getIlOpnm() {
    return this.ilOpnm;
  }
  
  public void setIlOpnm(String ilOpnm) {
    this.ilOpnm = ilOpnm;
  }
  
  public Short getIlOpprsq() {
    return this.ilOpprsq;
  }
  
  public void setIlOpprsq(Short ilOpprsq) {
    this.ilOpprsq = ilOpprsq;
  }
  
  public String getIlOpcs() {
    return this.ilOpcs;
  }
  
  public void setIlOpcs(String ilOpcs) {
    this.ilOpcs = ilOpcs;
  }
  
  public Timestamp getIlLmd() {
    return this.ilLmd;
  }
  
  public void setIlLmd(Timestamp ilLmd) {
    this.ilLmd = ilLmd;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\Iltb16JobCode.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */