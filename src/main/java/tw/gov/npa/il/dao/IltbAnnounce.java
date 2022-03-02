package tw.gov.npa.il.dao;

import java.io.Serializable;
import java.sql.Timestamp;

public class IltbAnnounce implements Serializable {
  private Integer ilAnnNo;
  
  private String ilKind;
  
  private String ilContent;
  
  private String ilBeginDt;
  
  private String ilBeginTm;
  
  private String ilEndDt;
  
  private String ilEndTm;
  
  private String ilAnnUid;
  
  private String ilAnnUnm;
  
  private String ilAnnDt;
  
  private String ilAnnTm;
  
  private Timestamp ilModified;
  
  public IltbAnnounce() {}
  
  public IltbAnnounce(String ilBeginDt, String ilBeginTm) {
    this.ilBeginDt = ilBeginDt;
    this.ilBeginTm = ilBeginTm;
  }
  
  public IltbAnnounce(String ilKind, String ilContent, String ilBeginDt, String ilBeginTm, String ilEndDt, String ilEndTm, String ilAnnUid, String ilAnnUnm, String ilAnnDt, String ilAnnTm, Timestamp ilModified) {
    this.ilKind = ilKind;
    this.ilContent = ilContent;
    this.ilBeginDt = ilBeginDt;
    this.ilBeginTm = ilBeginTm;
    this.ilEndDt = ilEndDt;
    this.ilEndTm = ilEndTm;
    this.ilAnnUid = ilAnnUid;
    this.ilAnnUnm = ilAnnUnm;
    this.ilAnnDt = ilAnnDt;
    this.ilAnnTm = ilAnnTm;
    this.ilModified = ilModified;
  }
  
  public Integer getIlAnnNo() {
    return this.ilAnnNo;
  }
  
  public void setIlAnnNo(Integer ilAnnNo) {
    this.ilAnnNo = ilAnnNo;
  }
  
  public String getIlKind() {
    return this.ilKind;
  }
  
  public void setIlKind(String ilKind) {
    this.ilKind = ilKind;
  }
  
  public String getIlContent() {
    return this.ilContent;
  }
  
  public void setIlContent(String ilContent) {
    this.ilContent = ilContent;
  }
  
  public String getIlBeginDt() {
    return this.ilBeginDt;
  }
  
  public void setIlBeginDt(String ilBeginDt) {
    this.ilBeginDt = ilBeginDt;
  }
  
  public String getIlBeginTm() {
    return this.ilBeginTm;
  }
  
  public void setIlBeginTm(String ilBeginTm) {
    this.ilBeginTm = ilBeginTm;
  }
  
  public String getIlEndDt() {
    return this.ilEndDt;
  }
  
  public void setIlEndDt(String ilEndDt) {
    this.ilEndDt = ilEndDt;
  }
  
  public String getIlEndTm() {
    return this.ilEndTm;
  }
  
  public void setIlEndTm(String ilEndTm) {
    this.ilEndTm = ilEndTm;
  }
  
  public String getIlAnnUid() {
    return this.ilAnnUid;
  }
  
  public void setIlAnnUid(String ilAnnUid) {
    this.ilAnnUid = ilAnnUid;
  }
  
  public String getIlAnnUnm() {
    return this.ilAnnUnm;
  }
  
  public void setIlAnnUnm(String ilAnnUnm) {
    this.ilAnnUnm = ilAnnUnm;
  }
  
  public String getIlAnnDt() {
    return this.ilAnnDt;
  }
  
  public void setIlAnnDt(String ilAnnDt) {
    this.ilAnnDt = ilAnnDt;
  }
  
  public String getIlAnnTm() {
    return this.ilAnnTm;
  }
  
  public void setIlAnnTm(String ilAnnTm) {
    this.ilAnnTm = ilAnnTm;
  }
  
  public Timestamp getIlModified() {
    return this.ilModified;
  }
  
  public void setIlModified(Timestamp ilModified) {
    this.ilModified = ilModified;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\IltbAnnounce.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */