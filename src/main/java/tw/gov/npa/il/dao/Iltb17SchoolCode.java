package tw.gov.npa.il.dao;

import java.io.Serializable;
import java.sql.Timestamp;

public class Iltb17SchoolCode implements Serializable {
  private String ilUvcd;
  
  private String ilUvcnm;
  
  private String ilUvcpnm;
  
  private String ilUvpzone;
  
  private String ilUvaddr;
  
  private String ilUvtel;
  
  private Timestamp ilLmd;
  
  public Iltb17SchoolCode() {}
  
  public Iltb17SchoolCode(String ilUvcnm, String ilUvcpnm, Timestamp ilLmd) {
    this.ilUvcnm = ilUvcnm;
    this.ilUvcpnm = ilUvcpnm;
    this.ilLmd = ilLmd;
  }
  
  public Iltb17SchoolCode(String ilUvcnm, String ilUvcpnm, String ilUvpzone, String ilUvaddr, String ilUvtel, Timestamp ilLmd) {
    this.ilUvcnm = ilUvcnm;
    this.ilUvcpnm = ilUvcpnm;
    this.ilUvpzone = ilUvpzone;
    this.ilUvaddr = ilUvaddr;
    this.ilUvtel = ilUvtel;
    this.ilLmd = ilLmd;
  }
  
  public String getIlUvcd() {
    return this.ilUvcd;
  }
  
  public void setIlUvcd(String ilUvcd) {
    this.ilUvcd = ilUvcd;
  }
  
  public String getIlUvcnm() {
    return this.ilUvcnm;
  }
  
  public void setIlUvcnm(String ilUvcnm) {
    this.ilUvcnm = ilUvcnm;
  }
  
  public String getIlUvcpnm() {
    return this.ilUvcpnm;
  }
  
  public void setIlUvcpnm(String ilUvcpnm) {
    this.ilUvcpnm = ilUvcpnm;
  }
  
  public String getIlUvpzone() {
    return this.ilUvpzone;
  }
  
  public void setIlUvpzone(String ilUvpzone) {
    this.ilUvpzone = ilUvpzone;
  }
  
  public String getIlUvaddr() {
    return this.ilUvaddr;
  }
  
  public void setIlUvaddr(String ilUvaddr) {
    this.ilUvaddr = ilUvaddr;
  }
  
  public String getIlUvtel() {
    return this.ilUvtel;
  }
  
  public void setIlUvtel(String ilUvtel) {
    this.ilUvtel = ilUvtel;
  }
  
  public Timestamp getIlLmd() {
    return this.ilLmd;
  }
  
  public void setIlLmd(Timestamp ilLmd) {
    this.ilLmd = ilLmd;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\Iltb17SchoolCode.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */