package tw.gov.npa.il.dao;

import java.io.Serializable;
import java.sql.Timestamp;

public class Iltb15CountryCode implements Serializable {
  private String ilNtcd;
  
  private String ilNtnm;
  
  private String ilNtlbr;
  
  private Short ilNtprsq;
  
  private Timestamp ilNtdts;
  
  private Timestamp ilNtdte;
  
  private Timestamp ilLmd;
  
  public Iltb15CountryCode() {}
  
  public Iltb15CountryCode(String ilNtnm, String ilNtlbr, Short ilNtprsq, Timestamp ilLmd) {
    this.ilNtnm = ilNtnm;
    this.ilNtlbr = ilNtlbr;
    this.ilNtprsq = ilNtprsq;
    this.ilLmd = ilLmd;
  }
  
  public Iltb15CountryCode(String ilNtnm, String ilNtlbr, Short ilNtprsq, Timestamp ilNtdts, Timestamp ilNtdte, Timestamp ilLmd) {
    this.ilNtnm = ilNtnm;
    this.ilNtlbr = ilNtlbr;
    this.ilNtprsq = ilNtprsq;
    this.ilNtdts = ilNtdts;
    this.ilNtdte = ilNtdte;
    this.ilLmd = ilLmd;
  }
  
  public String getIlNtcd() {
    return this.ilNtcd;
  }
  
  public void setIlNtcd(String ilNtcd) {
    this.ilNtcd = ilNtcd;
  }
  
  public String getIlNtnm() {
    return this.ilNtnm;
  }
  
  public void setIlNtnm(String ilNtnm) {
    this.ilNtnm = ilNtnm;
  }
  
  public String getIlNtlbr() {
    return this.ilNtlbr;
  }
  
  public void setIlNtlbr(String ilNtlbr) {
    this.ilNtlbr = ilNtlbr;
  }
  
  public Short getIlNtprsq() {
    return this.ilNtprsq;
  }
  
  public void setIlNtprsq(Short ilNtprsq) {
    this.ilNtprsq = ilNtprsq;
  }
  
  public Timestamp getIlNtdts() {
    return this.ilNtdts;
  }
  
  public void setIlNtdts(Timestamp ilNtdts) {
    this.ilNtdts = ilNtdts;
  }
  
  public Timestamp getIlNtdte() {
    return this.ilNtdte;
  }
  
  public void setIlNtdte(Timestamp ilNtdte) {
    this.ilNtdte = ilNtdte;
  }
  
  public Timestamp getIlLmd() {
    return this.ilLmd;
  }
  
  public void setIlLmd(Timestamp ilLmd) {
    this.ilLmd = ilLmd;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\Iltb15CountryCode.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */