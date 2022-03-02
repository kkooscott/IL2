package tw.gov.npa.il.dao;

import java.io.Serializable;
import java.sql.Timestamp;

public class Iltb18DataProcessResult implements Serializable {
  private Iltb18DataProcessResultId id;
  
  private String ilImpst;
  
  private String ilImpuid;
  
  private String ilImpfl;
  
  private Integer ilImptot;
  
  private Integer ilImpok;
  
  private Integer ilErrtp1;
  
  private Integer ilErrtp2;
  
  private Integer ilErrtp3;
  
  private Integer ilErrtp4;
  
  private Integer ilErrtp5;
  
  private Integer ilErrtp6;
  
  private Integer ilErrtp7;
  
  private Integer ilErrtp8;
  
  private Integer ilErrtp9;
  
  private Integer ilErrtp0;
  
  private String ilImpmsg;
  
  private Timestamp ilModified;
  
  public Iltb18DataProcessResult() {}
  
  public Iltb18DataProcessResult(Iltb18DataProcessResultId id, String ilImpst, String ilImpuid, String ilImpfl, Integer ilImptot, Integer ilImpok, Integer ilErrtp1, Integer ilErrtp2, Integer ilErrtp3, Integer ilErrtp4, Integer ilErrtp5, Integer ilErrtp6, Integer ilErrtp7, Integer ilErrtp8, Integer ilErrtp9, Integer ilErrtp0) {
    this.id = id;
    this.ilImpst = ilImpst;
    this.ilImpuid = ilImpuid;
    this.ilImpfl = ilImpfl;
    this.ilImptot = ilImptot;
    this.ilImpok = ilImpok;
    this.ilErrtp1 = ilErrtp1;
    this.ilErrtp2 = ilErrtp2;
    this.ilErrtp3 = ilErrtp3;
    this.ilErrtp4 = ilErrtp4;
    this.ilErrtp5 = ilErrtp5;
    this.ilErrtp6 = ilErrtp6;
    this.ilErrtp7 = ilErrtp7;
    this.ilErrtp8 = ilErrtp8;
    this.ilErrtp9 = ilErrtp9;
    this.ilErrtp0 = ilErrtp0;
  }
  
  public Iltb18DataProcessResult(Iltb18DataProcessResultId id, String ilImpst, String ilImpuid, String ilImpfl, Integer ilImptot, Integer ilImpok, Integer ilErrtp1, Integer ilErrtp2, Integer ilErrtp3, Integer ilErrtp4, Integer ilErrtp5, Integer ilErrtp6, Integer ilErrtp7, Integer ilErrtp8, Integer ilErrtp9, Integer ilErrtp0, String ilImpmsg, Timestamp ilModified) {
    this.id = id;
    this.ilImpst = ilImpst;
    this.ilImpuid = ilImpuid;
    this.ilImpfl = ilImpfl;
    this.ilImptot = ilImptot;
    this.ilImpok = ilImpok;
    this.ilErrtp1 = ilErrtp1;
    this.ilErrtp2 = ilErrtp2;
    this.ilErrtp3 = ilErrtp3;
    this.ilErrtp4 = ilErrtp4;
    this.ilErrtp5 = ilErrtp5;
    this.ilErrtp6 = ilErrtp6;
    this.ilErrtp7 = ilErrtp7;
    this.ilErrtp8 = ilErrtp8;
    this.ilErrtp9 = ilErrtp9;
    this.ilErrtp0 = ilErrtp0;
    this.ilImpmsg = ilImpmsg;
    this.ilModified = ilModified;
  }
  
  public Iltb18DataProcessResultId getId() {
    return this.id;
  }
  
  public void setId(Iltb18DataProcessResultId id) {
    this.id = id;
  }
  
  public String getIlImpst() {
    return this.ilImpst;
  }
  
  public void setIlImpst(String ilImpst) {
    this.ilImpst = ilImpst;
  }
  
  public String getIlImpuid() {
    return this.ilImpuid;
  }
  
  public void setIlImpuid(String ilImpuid) {
    this.ilImpuid = ilImpuid;
  }
  
  public String getIlImpfl() {
    return this.ilImpfl;
  }
  
  public void setIlImpfl(String ilImpfl) {
    this.ilImpfl = ilImpfl;
  }
  
  public Integer getIlImptot() {
    return this.ilImptot;
  }
  
  public void setIlImptot(Integer ilImptot) {
    this.ilImptot = ilImptot;
  }
  
  public Integer getIlImpok() {
    return this.ilImpok;
  }
  
  public void setIlImpok(Integer ilImpok) {
    this.ilImpok = ilImpok;
  }
  
  public Integer getIlErrtp1() {
    return this.ilErrtp1;
  }
  
  public void setIlErrtp1(Integer ilErrtp1) {
    this.ilErrtp1 = ilErrtp1;
  }
  
  public Integer getIlErrtp2() {
    return this.ilErrtp2;
  }
  
  public void setIlErrtp2(Integer ilErrtp2) {
    this.ilErrtp2 = ilErrtp2;
  }
  
  public Integer getIlErrtp3() {
    return this.ilErrtp3;
  }
  
  public void setIlErrtp3(Integer ilErrtp3) {
    this.ilErrtp3 = ilErrtp3;
  }
  
  public Integer getIlErrtp4() {
    return this.ilErrtp4;
  }
  
  public void setIlErrtp4(Integer ilErrtp4) {
    this.ilErrtp4 = ilErrtp4;
  }
  
  public Integer getIlErrtp5() {
    return this.ilErrtp5;
  }
  
  public void setIlErrtp5(Integer ilErrtp5) {
    this.ilErrtp5 = ilErrtp5;
  }
  
  public Integer getIlErrtp6() {
    return this.ilErrtp6;
  }
  
  public void setIlErrtp6(Integer ilErrtp6) {
    this.ilErrtp6 = ilErrtp6;
  }
  
  public Integer getIlErrtp7() {
    return this.ilErrtp7;
  }
  
  public void setIlErrtp7(Integer ilErrtp7) {
    this.ilErrtp7 = ilErrtp7;
  }
  
  public Integer getIlErrtp8() {
    return this.ilErrtp8;
  }
  
  public void setIlErrtp8(Integer ilErrtp8) {
    this.ilErrtp8 = ilErrtp8;
  }
  
  public Integer getIlErrtp9() {
    return this.ilErrtp9;
  }
  
  public void setIlErrtp9(Integer ilErrtp9) {
    this.ilErrtp9 = ilErrtp9;
  }
  
  public Integer getIlErrtp0() {
    return this.ilErrtp0;
  }
  
  public void setIlErrtp0(Integer ilErrtp0) {
    this.ilErrtp0 = ilErrtp0;
  }
  
  public String getIlImpmsg() {
    return this.ilImpmsg;
  }
  
  public void setIlImpmsg(String ilImpmsg) {
    this.ilImpmsg = ilImpmsg;
  }
  
  public Timestamp getIlModified() {
    return this.ilModified;
  }
  
  public void setIlModified(Timestamp ilModified) {
    this.ilModified = ilModified;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\Iltb18DataProcessResult.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */