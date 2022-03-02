package tw.gov.npa.il.dao;

import java.io.Serializable;
import java.sql.Timestamp;

public class Iltb20OnlineReport implements Serializable {
  private Iltb20OnlineReportId id;
  
  private String ilDidnm;
  
  private String ilIp;
  
  private String ilRptnm;
  
  private String ilRptfn;
  
  private Timestamp ilRundt;
  
  private String ilStatus;
  
  private String ilShow;
  
  private String ilWhere1;
  
  private String ilWhere2;
  
  private String ilWhere3;
  
  private String ilWhere4;
  
  private Short ilRptamt;
  
  private Timestamp ilModified;
  
  public Iltb20OnlineReport() {}
  
  public Iltb20OnlineReport(Iltb20OnlineReportId id, String ilDidnm, String ilIp, String ilRptnm, String ilRptfn, Timestamp ilRundt, String ilStatus, String ilShow, String ilWhere1, Short ilRptamt) {
    this.id = id;
    this.ilDidnm = ilDidnm;
    this.ilIp = ilIp;
    this.ilRptnm = ilRptnm;
    this.ilRptfn = ilRptfn;
    this.ilRundt = ilRundt;
    this.ilStatus = ilStatus;
    this.ilShow = ilShow;
    this.ilWhere1 = ilWhere1;
    this.ilRptamt = ilRptamt;
  }
  
  public Iltb20OnlineReport(Iltb20OnlineReportId id, String ilDidnm, String ilIp, String ilRptnm, String ilRptfn, Timestamp ilRundt, String ilStatus, String ilShow, String ilWhere1, String ilWhere2, String ilWhere3, String ilWhere4, Short ilRptamt, Timestamp ilModified) {
    this.id = id;
    this.ilDidnm = ilDidnm;
    this.ilIp = ilIp;
    this.ilRptnm = ilRptnm;
    this.ilRptfn = ilRptfn;
    this.ilRundt = ilRundt;
    this.ilStatus = ilStatus;
    this.ilShow = ilShow;
    this.ilWhere1 = ilWhere1;
    this.ilWhere2 = ilWhere2;
    this.ilWhere3 = ilWhere3;
    this.ilWhere4 = ilWhere4;
    this.ilRptamt = ilRptamt;
    this.ilModified = ilModified;
  }
  
  public Iltb20OnlineReportId getId() {
    return this.id;
  }
  
  public void setId(Iltb20OnlineReportId id) {
    this.id = id;
  }
  
  public String getIlDidnm() {
    return this.ilDidnm;
  }
  
  public void setIlDidnm(String ilDidnm) {
    this.ilDidnm = ilDidnm;
  }
  
  public String getIlIp() {
    return this.ilIp;
  }
  
  public void setIlIp(String ilIp) {
    this.ilIp = ilIp;
  }
  
  public String getIlRptnm() {
    return this.ilRptnm;
  }
  
  public void setIlRptnm(String ilRptnm) {
    this.ilRptnm = ilRptnm;
  }
  
  public String getIlRptfn() {
    return this.ilRptfn;
  }
  
  public void setIlRptfn(String ilRptfn) {
    this.ilRptfn = ilRptfn;
  }
  
  public Timestamp getIlRundt() {
    return this.ilRundt;
  }
  
  public void setIlRundt(Timestamp ilRundt) {
    this.ilRundt = ilRundt;
  }
  
  public String getIlStatus() {
    return this.ilStatus;
  }
  
  public void setIlStatus(String ilStatus) {
    this.ilStatus = ilStatus;
  }
  
  public String getIlShow() {
    return this.ilShow;
  }
  
  public void setIlShow(String ilShow) {
    this.ilShow = ilShow;
  }
  
  public String getIlWhere1() {
    return this.ilWhere1;
  }
  
  public void setIlWhere1(String ilWhere1) {
    this.ilWhere1 = ilWhere1;
  }
  
  public String getIlWhere2() {
    return this.ilWhere2;
  }
  
  public void setIlWhere2(String ilWhere2) {
    this.ilWhere2 = ilWhere2;
  }
  
  public String getIlWhere3() {
    return this.ilWhere3;
  }
  
  public void setIlWhere3(String ilWhere3) {
    this.ilWhere3 = ilWhere3;
  }
  
  public String getIlWhere4() {
    return this.ilWhere4;
  }
  
  public void setIlWhere4(String ilWhere4) {
    this.ilWhere4 = ilWhere4;
  }
  
  public Short getIlRptamt() {
    return this.ilRptamt;
  }
  
  public void setIlRptamt(Short ilRptamt) {
    this.ilRptamt = ilRptamt;
  }
  
  public Timestamp getIlModified() {
    return this.ilModified;
  }
  
  public void setIlModified(Timestamp ilModified) {
    this.ilModified = ilModified;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\Iltb20OnlineReport.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */