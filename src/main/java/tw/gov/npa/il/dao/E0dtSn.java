package tw.gov.npa.il.dao;

import java.io.Serializable;
import java.sql.Timestamp;

public class E0dtSn implements Serializable {
  private E0dtSnId id;
  
  private Timestamp e0PrcdTime;
  
  private String e0SvrUnitCode;
  
  private String e0Userid;
  
  private String e0Ip;
  
  private String e0InqRslt;
  
  private String e0UpdateRslt;
  
  private String e0UseridUnitCode;
  
  private String e0UseridDeptCode;
  
  private String e0UseridBranchCode;
  
  private String e0SyncFlag;
  
  public E0dtSn() {}
  
  public E0dtSn(E0dtSnId id, Timestamp e0PrcdTime, String e0SvrUnitCode, String e0Userid, String e0Ip, String e0InqRslt, String e0UpdateRslt, String e0UseridUnitCode, String e0UseridDeptCode, String e0UseridBranchCode, String e0SyncFlag) {
    this.id = id;
    this.e0PrcdTime = e0PrcdTime;
    this.e0SvrUnitCode = e0SvrUnitCode;
    this.e0Userid = e0Userid;
    this.e0Ip = e0Ip;
    this.e0InqRslt = e0InqRslt;
    this.e0UpdateRslt = e0UpdateRslt;
    this.e0UseridUnitCode = e0UseridUnitCode;
    this.e0UseridDeptCode = e0UseridDeptCode;
    this.e0UseridBranchCode = e0UseridBranchCode;
    this.e0SyncFlag = e0SyncFlag;
  }
  
  public E0dtSnId getId() {
    return this.id;
  }
  
  public void setId(E0dtSnId id) {
    this.id = id;
  }
  
  public Timestamp getE0PrcdTime() {
    return this.e0PrcdTime;
  }
  
  public void setE0PrcdTime(Timestamp e0PrcdTime) {
    this.e0PrcdTime = e0PrcdTime;
  }
  
  public String getE0SvrUnitCode() {
    return this.e0SvrUnitCode;
  }
  
  public void setE0SvrUnitCode(String e0SvrUnitCode) {
    this.e0SvrUnitCode = e0SvrUnitCode;
  }
  
  public String getE0Userid() {
    return this.e0Userid;
  }
  
  public void setE0Userid(String e0Userid) {
    this.e0Userid = e0Userid;
  }
  
  public String getE0Ip() {
    return this.e0Ip;
  }
  
  public void setE0Ip(String e0Ip) {
    this.e0Ip = e0Ip;
  }
  
  public String getE0InqRslt() {
    return this.e0InqRslt;
  }
  
  public void setE0InqRslt(String e0InqRslt) {
    this.e0InqRslt = e0InqRslt;
  }
  
  public String getE0UpdateRslt() {
    return this.e0UpdateRslt;
  }
  
  public void setE0UpdateRslt(String e0UpdateRslt) {
    this.e0UpdateRslt = e0UpdateRslt;
  }
  
  public String getE0UseridUnitCode() {
    return this.e0UseridUnitCode;
  }
  
  public void setE0UseridUnitCode(String e0UseridUnitCode) {
    this.e0UseridUnitCode = e0UseridUnitCode;
  }
  
  public String getE0UseridDeptCode() {
    return this.e0UseridDeptCode;
  }
  
  public void setE0UseridDeptCode(String e0UseridDeptCode) {
    this.e0UseridDeptCode = e0UseridDeptCode;
  }
  
  public String getE0UseridBranchCode() {
    return this.e0UseridBranchCode;
  }
  
  public void setE0UseridBranchCode(String e0UseridBranchCode) {
    this.e0UseridBranchCode = e0UseridBranchCode;
  }
  
  public String getE0SyncFlag() {
    return this.e0SyncFlag;
  }
  
  public void setE0SyncFlag(String e0SyncFlag) {
    this.e0SyncFlag = e0SyncFlag;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\E0dtSn.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */