package tw.gov.npa.il.dao;

import java.io.Serializable;
import java.sql.Timestamp;

public class Iltb01MainIdx implements Serializable {
  private Integer ilArcid;
  
  private String ilArccs;
  
  private String ilArcno;
  
  private String ilOldarc;
  
  private String ilNtcd;
  
  private String ilPspt;
  
  private String ilEnm;
  
  private String ilCnm;
  
  private String ilBthdt;
  
  private String ilOfnm;
  
  private String ilPhq;
  
  private String ilPst;
  
  private String ilJbcd;
  
  private Timestamp ilJbpmdt;
  
  private String ilJbpmdc;
  
  private Timestamp ilModified;
  
  private Long il12ArcId;
  
  public Long getIl12ArcId() {
    return this.il12ArcId;
  }
  
  public void setIl12ArcId(Long il12ArcId) {
    this.il12ArcId = il12ArcId;
  }
  
  public Iltb01MainIdx() {}
  
  public Iltb01MainIdx(String ilArccs, String ilArcno, String ilOldarc, String ilNtcd, String ilPspt, String ilEnm, String ilCnm, String ilBthdt, String ilOfnm, String ilPhq, String ilPst, String ilJbcd, Timestamp ilJbpmdt, String ilJbpmdc, Timestamp ilModified) {
    this.ilArccs = ilArccs;
    this.ilArcno = ilArcno;
    this.ilOldarc = ilOldarc;
    this.ilNtcd = ilNtcd;
    this.ilPspt = ilPspt;
    this.ilEnm = ilEnm;
    this.ilCnm = ilCnm;
    this.ilBthdt = ilBthdt;
    this.ilOfnm = ilOfnm;
    this.ilPhq = ilPhq;
    this.ilPst = ilPst;
    this.ilJbcd = ilJbcd;
    this.ilJbpmdt = ilJbpmdt;
    this.ilJbpmdc = ilJbpmdc;
    this.ilModified = ilModified;
  }
  
  public Integer getIlArcid() {
    return this.ilArcid;
  }
  
  public void setIlArcid(Integer ilArcid) {
    this.ilArcid = ilArcid;
  }
  
  public String getIlArccs() {
    return this.ilArccs;
  }
  
  public void setIlArccs(String ilArccs) {
    this.ilArccs = ilArccs;
  }
  
  public String getIlArcno() {
    return this.ilArcno;
  }
  
  public void setIlArcno(String ilArcno) {
    this.ilArcno = ilArcno;
  }
  
  public String getIlOldarc() {
    return this.ilOldarc;
  }
  
  public void setIlOldarc(String ilOldarc) {
    this.ilOldarc = ilOldarc;
  }
  
  public String getIlNtcd() {
    return this.ilNtcd;
  }
  
  public void setIlNtcd(String ilNtcd) {
    this.ilNtcd = ilNtcd;
  }
  
  public String getIlPspt() {
    return this.ilPspt;
  }
  
  public void setIlPspt(String ilPspt) {
    this.ilPspt = ilPspt;
  }
  
  public String getIlEnm() {
    return this.ilEnm;
  }
  
  public void setIlEnm(String ilEnm) {
    this.ilEnm = ilEnm;
  }
  
  public String getIlCnm() {
    return this.ilCnm;
  }
  
  public void setIlCnm(String ilCnm) {
    this.ilCnm = ilCnm;
  }
  
  public String getIlBthdt() {
    return this.ilBthdt;
  }
  
  public void setIlBthdt(String ilBthdt) {
    this.ilBthdt = ilBthdt;
  }
  
  public String getIlOfnm() {
    return this.ilOfnm;
  }
  
  public void setIlOfnm(String ilOfnm) {
    this.ilOfnm = ilOfnm;
  }
  
  public String getIlPhq() {
    return this.ilPhq;
  }
  
  public void setIlPhq(String ilPhq) {
    this.ilPhq = ilPhq;
  }
  
  public String getIlPst() {
    return this.ilPst;
  }
  
  public void setIlPst(String ilPst) {
    this.ilPst = ilPst;
  }
  
  public String getIlJbcd() {
    return this.ilJbcd;
  }
  
  public void setIlJbcd(String ilJbcd) {
    this.ilJbcd = ilJbcd;
  }
  
  public Timestamp getIlJbpmdt() {
    return this.ilJbpmdt;
  }
  
  public void setIlJbpmdt(Timestamp ilJbpmdt) {
    this.ilJbpmdt = ilJbpmdt;
  }
  
  public String getIlJbpmdc() {
    return this.ilJbpmdc;
  }
  
  public void setIlJbpmdc(String ilJbpmdc) {
    this.ilJbpmdc = ilJbpmdc;
  }
  
  public Timestamp getIlModified() {
    return this.ilModified;
  }
  
  public void setIlModified(Timestamp ilModified) {
    this.ilModified = ilModified;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\Iltb01MainIdx.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */