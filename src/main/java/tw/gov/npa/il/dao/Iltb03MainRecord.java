package tw.gov.npa.il.dao;

import java.io.Serializable;
import java.sql.Timestamp;

public class Iltb03MainRecord implements Serializable {
  private Iltb03MainRecordId id;
  
  private String ilArctp;
  
  private String ilArccs;
  
  private Short ilHstmrk;
  
  private String ilEnm;
  
  private String ilPspt;
  
  private Timestamp ilPsdt;
  
  private String ilArcrsn;
  
  private String ilJbcd;
  
  private String ilOfcd;
  
  private String ilOfnm;
  
  private String ilOftel;
  
  private String ilJbpzone;
  
  private String ilJbaddr;
  
  private String ilJbtel;
  
  private String ilArpzone;
  
  private String ilAraddr;
  
  private String ilArtel;
  
  private String ilAgnco;
  
  private String ilAgntel;
  
  private String ilJbpmcd;
  
  private String ilJbpmdc;
  
  private Timestamp ilJbpmdt;
  
  private Timestamp ilJbpmfm;
  
  private Timestamp ilJbpmto;
  
  private String ilMicro;
  
  private String ilArcrcp;
  
  private String ilArcno;
  
  private Timestamp ilArcfm;
  
  private Timestamp ilArcto;
  
  private String ilFrcexit;
  
  private Timestamp ilReapydt;
  
  private String ilRetp;
  
  private String ilRepmdc;
  
  private Timestamp ilRepmdt;
  
  private String ilRrnote;
  
  private String ilMrkcs;
  
  private String ilFbdrsn;
  
  private Timestamp ilMrkdt;
  
  private String ilMrkdc;
  
  private Timestamp ilDpdt;
  
  private String ilTid;
  
  private Timestamp ilModified;
  
  public Iltb03MainRecord() {}
  
  public Iltb03MainRecord(Iltb03MainRecordId id, Timestamp ilDpdt, String ilTid) {
    this.id = id;
    this.ilDpdt = ilDpdt;
    this.ilTid = ilTid;
  }
  
  public Iltb03MainRecord(Iltb03MainRecordId id, String ilArctp, String ilArccs, Short ilHstmrk, String ilEnm, String ilPspt, Timestamp ilPsdt, String ilArcrsn, String ilJbcd, String ilOfcd, String ilOfnm, String ilOftel, String ilJbpzone, String ilJbaddr, String ilJbtel, String ilArpzone, String ilAraddr, String ilArtel, String ilAgnco, String ilAgntel, String ilJbpmcd, String ilJbpmdc, Timestamp ilJbpmdt, Timestamp ilJbpmfm, Timestamp ilJbpmto, String ilMicro, String ilArcrcp, String ilArcno, Timestamp ilArcfm, Timestamp ilArcto, String ilFrcexit, Timestamp ilReapydt, String ilRetp, String ilRepmdc, Timestamp ilRepmdt, String ilRrnote, String ilMrkcs, String ilFbdrsn, Timestamp ilMrkdt, String ilMrkdc, Timestamp ilDpdt, String ilTid, Timestamp ilModified) {
    this.id = id;
    this.ilArctp = ilArctp;
    this.ilArccs = ilArccs;
    this.ilHstmrk = ilHstmrk;
    this.ilEnm = ilEnm;
    this.ilPspt = ilPspt;
    this.ilPsdt = ilPsdt;
    this.ilArcrsn = ilArcrsn;
    this.ilJbcd = ilJbcd;
    this.ilOfcd = ilOfcd;
    this.ilOfnm = ilOfnm;
    this.ilOftel = ilOftel;
    this.ilJbpzone = ilJbpzone;
    this.ilJbaddr = ilJbaddr;
    this.ilJbtel = ilJbtel;
    this.ilArpzone = ilArpzone;
    this.ilAraddr = ilAraddr;
    this.ilArtel = ilArtel;
    this.ilAgnco = ilAgnco;
    this.ilAgntel = ilAgntel;
    this.ilJbpmcd = ilJbpmcd;
    this.ilJbpmdc = ilJbpmdc;
    this.ilJbpmdt = ilJbpmdt;
    this.ilJbpmfm = ilJbpmfm;
    this.ilJbpmto = ilJbpmto;
    this.ilMicro = ilMicro;
    this.ilArcrcp = ilArcrcp;
    this.ilArcno = ilArcno;
    this.ilArcfm = ilArcfm;
    this.ilArcto = ilArcto;
    this.ilFrcexit = ilFrcexit;
    this.ilReapydt = ilReapydt;
    this.ilRetp = ilRetp;
    this.ilRepmdc = ilRepmdc;
    this.ilRepmdt = ilRepmdt;
    this.ilRrnote = ilRrnote;
    this.ilMrkcs = ilMrkcs;
    this.ilFbdrsn = ilFbdrsn;
    this.ilMrkdt = ilMrkdt;
    this.ilMrkdc = ilMrkdc;
    this.ilDpdt = ilDpdt;
    this.ilTid = ilTid;
    this.ilModified = ilModified;
  }
  
  public Iltb03MainRecordId getId() {
    return this.id;
  }
  
  public void setId(Iltb03MainRecordId id) {
    this.id = id;
  }
  
  public String getIlArctp() {
    return this.ilArctp;
  }
  
  public void setIlArctp(String ilArctp) {
    this.ilArctp = ilArctp;
  }
  
  public String getIlArccs() {
    return this.ilArccs;
  }
  
  public void setIlArccs(String ilArccs) {
    this.ilArccs = ilArccs;
  }
  
  public Short getIlHstmrk() {
    return this.ilHstmrk;
  }
  
  public void setIlHstmrk(Short ilHstmrk) {
    this.ilHstmrk = ilHstmrk;
  }
  
  public String getIlEnm() {
    return this.ilEnm;
  }
  
  public void setIlEnm(String ilEnm) {
    this.ilEnm = ilEnm;
  }
  
  public String getIlPspt() {
    return this.ilPspt;
  }
  
  public void setIlPspt(String ilPspt) {
    this.ilPspt = ilPspt;
  }
  
  public Timestamp getIlPsdt() {
    return this.ilPsdt;
  }
  
  public void setIlPsdt(Timestamp ilPsdt) {
    this.ilPsdt = ilPsdt;
  }
  
  public String getIlArcrsn() {
    return this.ilArcrsn;
  }
  
  public void setIlArcrsn(String ilArcrsn) {
    this.ilArcrsn = ilArcrsn;
  }
  
  public String getIlJbcd() {
    return this.ilJbcd;
  }
  
  public void setIlJbcd(String ilJbcd) {
    this.ilJbcd = ilJbcd;
  }
  
  public String getIlOfcd() {
    return this.ilOfcd;
  }
  
  public void setIlOfcd(String ilOfcd) {
    this.ilOfcd = ilOfcd;
  }
  
  public String getIlOfnm() {
    return this.ilOfnm;
  }
  
  public void setIlOfnm(String ilOfnm) {
    this.ilOfnm = ilOfnm;
  }
  
  public String getIlOftel() {
    return this.ilOftel;
  }
  
  public void setIlOftel(String ilOftel) {
    this.ilOftel = ilOftel;
  }
  
  public String getIlJbpzone() {
    return this.ilJbpzone;
  }
  
  public void setIlJbpzone(String ilJbpzone) {
    this.ilJbpzone = ilJbpzone;
  }
  
  public String getIlJbaddr() {
    return this.ilJbaddr;
  }
  
  public void setIlJbaddr(String ilJbaddr) {
    this.ilJbaddr = ilJbaddr;
  }
  
  public String getIlJbtel() {
    return this.ilJbtel;
  }
  
  public void setIlJbtel(String ilJbtel) {
    this.ilJbtel = ilJbtel;
  }
  
  public String getIlArpzone() {
    return this.ilArpzone;
  }
  
  public void setIlArpzone(String ilArpzone) {
    this.ilArpzone = ilArpzone;
  }
  
  public String getIlAraddr() {
    return this.ilAraddr;
  }
  
  public void setIlAraddr(String ilAraddr) {
    this.ilAraddr = ilAraddr;
  }
  
  public String getIlArtel() {
    return this.ilArtel;
  }
  
  public void setIlArtel(String ilArtel) {
    this.ilArtel = ilArtel;
  }
  
  public String getIlAgnco() {
    return this.ilAgnco;
  }
  
  public void setIlAgnco(String ilAgnco) {
    this.ilAgnco = ilAgnco;
  }
  
  public String getIlAgntel() {
    return this.ilAgntel;
  }
  
  public void setIlAgntel(String ilAgntel) {
    this.ilAgntel = ilAgntel;
  }
  
  public String getIlJbpmcd() {
    return this.ilJbpmcd;
  }
  
  public void setIlJbpmcd(String ilJbpmcd) {
    this.ilJbpmcd = ilJbpmcd;
  }
  
  public String getIlJbpmdc() {
    return this.ilJbpmdc;
  }
  
  public void setIlJbpmdc(String ilJbpmdc) {
    this.ilJbpmdc = ilJbpmdc;
  }
  
  public Timestamp getIlJbpmdt() {
    return this.ilJbpmdt;
  }
  
  public void setIlJbpmdt(Timestamp ilJbpmdt) {
    this.ilJbpmdt = ilJbpmdt;
  }
  
  public Timestamp getIlJbpmfm() {
    return this.ilJbpmfm;
  }
  
  public void setIlJbpmfm(Timestamp ilJbpmfm) {
    this.ilJbpmfm = ilJbpmfm;
  }
  
  public Timestamp getIlJbpmto() {
    return this.ilJbpmto;
  }
  
  public void setIlJbpmto(Timestamp ilJbpmto) {
    this.ilJbpmto = ilJbpmto;
  }
  
  public String getIlMicro() {
    return this.ilMicro;
  }
  
  public void setIlMicro(String ilMicro) {
    this.ilMicro = ilMicro;
  }
  
  public String getIlArcrcp() {
    return this.ilArcrcp;
  }
  
  public void setIlArcrcp(String ilArcrcp) {
    this.ilArcrcp = ilArcrcp;
  }
  
  public String getIlArcno() {
    return this.ilArcno;
  }
  
  public void setIlArcno(String ilArcno) {
    this.ilArcno = ilArcno;
  }
  
  public Timestamp getIlArcfm() {
    return this.ilArcfm;
  }
  
  public void setIlArcfm(Timestamp ilArcfm) {
    this.ilArcfm = ilArcfm;
  }
  
  public Timestamp getIlArcto() {
    return this.ilArcto;
  }
  
  public void setIlArcto(Timestamp ilArcto) {
    this.ilArcto = ilArcto;
  }
  
  public String getIlFrcexit() {
    return this.ilFrcexit;
  }
  
  public void setIlFrcexit(String ilFrcexit) {
    this.ilFrcexit = ilFrcexit;
  }
  
  public Timestamp getIlReapydt() {
    return this.ilReapydt;
  }
  
  public void setIlReapydt(Timestamp ilReapydt) {
    this.ilReapydt = ilReapydt;
  }
  
  public String getIlRetp() {
    return this.ilRetp;
  }
  
  public void setIlRetp(String ilRetp) {
    this.ilRetp = ilRetp;
  }
  
  public String getIlRepmdc() {
    return this.ilRepmdc;
  }
  
  public void setIlRepmdc(String ilRepmdc) {
    this.ilRepmdc = ilRepmdc;
  }
  
  public Timestamp getIlRepmdt() {
    return this.ilRepmdt;
  }
  
  public void setIlRepmdt(Timestamp ilRepmdt) {
    this.ilRepmdt = ilRepmdt;
  }
  
  public String getIlRrnote() {
    return this.ilRrnote;
  }
  
  public void setIlRrnote(String ilRrnote) {
    this.ilRrnote = ilRrnote;
  }
  
  public String getIlMrkcs() {
    return this.ilMrkcs;
  }
  
  public void setIlMrkcs(String ilMrkcs) {
    this.ilMrkcs = ilMrkcs;
  }
  
  public String getIlFbdrsn() {
    return this.ilFbdrsn;
  }
  
  public void setIlFbdrsn(String ilFbdrsn) {
    this.ilFbdrsn = ilFbdrsn;
  }
  
  public Timestamp getIlMrkdt() {
    return this.ilMrkdt;
  }
  
  public void setIlMrkdt(Timestamp ilMrkdt) {
    this.ilMrkdt = ilMrkdt;
  }
  
  public String getIlMrkdc() {
    return this.ilMrkdc;
  }
  
  public void setIlMrkdc(String ilMrkdc) {
    this.ilMrkdc = ilMrkdc;
  }
  
  public Timestamp getIlDpdt() {
    return this.ilDpdt;
  }
  
  public void setIlDpdt(Timestamp ilDpdt) {
    this.ilDpdt = ilDpdt;
  }
  
  public String getIlTid() {
    return this.ilTid;
  }
  
  public void setIlTid(String ilTid) {
    this.ilTid = ilTid;
  }
  
  public Timestamp getIlModified() {
    return this.ilModified;
  }
  
  public void setIlModified(Timestamp ilModified) {
    this.ilModified = ilModified;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\Iltb03MainRecord.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */