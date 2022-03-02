package tw.gov.npa.il.e0db.dao;

import java.io.Serializable;
import java.sql.Timestamp;

public class E0dtNpaunit implements Serializable {
  private String e0UnitCd;
  
  private String e0UnitNm;
  
  private String e0UnitSNm;
  
  private String e0UnitLevel;
  
  private String e0DeptCd;
  
  private String e0BranchCd;
  
  private String e0UnitAddr;
  
  private String e0AreaNo;
  
  private String e0PhoneNo;
  
  private String e0UnitFlag;
  
  private Timestamp e0Lmd;
  
  private String e0FullSNm;
  
  private String e0ReportFlag;
  
  private String e0OrgCd;
  
  private String e0HrUnitCd;
  
  private Integer e0DeleteFlag;
  
  private Timestamp e0Modify;
  
  private String e0Memo;
  
  private String e0PolicePhone;
  
  private String e0UnitSort;
  
  private String e0OldUnit;
  
  public E0dtNpaunit() {}
  
  public E0dtNpaunit(String e0UnitNm, String e0UnitSNm, String e0UnitLevel, String e0DeptCd, String e0BranchCd, String e0UnitAddr, String e0AreaNo, String e0PhoneNo) {
    this.e0UnitNm = e0UnitNm;
    this.e0UnitSNm = e0UnitSNm;
    this.e0UnitLevel = e0UnitLevel;
    this.e0DeptCd = e0DeptCd;
    this.e0BranchCd = e0BranchCd;
    this.e0UnitAddr = e0UnitAddr;
    this.e0AreaNo = e0AreaNo;
    this.e0PhoneNo = e0PhoneNo;
  }
  
  public E0dtNpaunit(String e0UnitNm, String e0UnitSNm, String e0UnitLevel, String e0DeptCd, String e0BranchCd, String e0UnitAddr, String e0AreaNo, String e0PhoneNo, String e0UnitFlag, Timestamp e0Lmd, String e0FullSNm, String e0ReportFlag, String e0OrgCd, String e0HrUnitCd, Integer e0DeleteFlag, Timestamp e0Modify, String e0Memo, String e0PolicePhone, String e0UnitSort, String e0OldUnit) {
    this.e0UnitNm = e0UnitNm;
    this.e0UnitSNm = e0UnitSNm;
    this.e0UnitLevel = e0UnitLevel;
    this.e0DeptCd = e0DeptCd;
    this.e0BranchCd = e0BranchCd;
    this.e0UnitAddr = e0UnitAddr;
    this.e0AreaNo = e0AreaNo;
    this.e0PhoneNo = e0PhoneNo;
    this.e0UnitFlag = e0UnitFlag;
    this.e0Lmd = e0Lmd;
    this.e0FullSNm = e0FullSNm;
    this.e0ReportFlag = e0ReportFlag;
    this.e0OrgCd = e0OrgCd;
    this.e0HrUnitCd = e0HrUnitCd;
    this.e0DeleteFlag = e0DeleteFlag;
    this.e0Modify = e0Modify;
    this.e0Memo = e0Memo;
    this.e0PolicePhone = e0PolicePhone;
    this.e0UnitSort = e0UnitSort;
    this.e0OldUnit = e0OldUnit;
  }
  
  public String getE0UnitCd() {
    return this.e0UnitCd;
  }
  
  public void setE0UnitCd(String e0UnitCd) {
    this.e0UnitCd = e0UnitCd;
  }
  
  public String getE0UnitNm() {
    return this.e0UnitNm;
  }
  
  public void setE0UnitNm(String e0UnitNm) {
    this.e0UnitNm = e0UnitNm;
  }
  
  public String getE0UnitSNm() {
    return this.e0UnitSNm;
  }
  
  public void setE0UnitSNm(String e0UnitSNm) {
    this.e0UnitSNm = e0UnitSNm;
  }
  
  public String getE0UnitLevel() {
    return this.e0UnitLevel;
  }
  
  public void setE0UnitLevel(String e0UnitLevel) {
    this.e0UnitLevel = e0UnitLevel;
  }
  
  public String getE0DeptCd() {
    return this.e0DeptCd;
  }
  
  public void setE0DeptCd(String e0DeptCd) {
    this.e0DeptCd = e0DeptCd;
  }
  
  public String getE0BranchCd() {
    return this.e0BranchCd;
  }
  
  public void setE0BranchCd(String e0BranchCd) {
    this.e0BranchCd = e0BranchCd;
  }
  
  public String getE0UnitAddr() {
    return this.e0UnitAddr;
  }
  
  public void setE0UnitAddr(String e0UnitAddr) {
    this.e0UnitAddr = e0UnitAddr;
  }
  
  public String getE0AreaNo() {
    return this.e0AreaNo;
  }
  
  public void setE0AreaNo(String e0AreaNo) {
    this.e0AreaNo = e0AreaNo;
  }
  
  public String getE0PhoneNo() {
    return this.e0PhoneNo;
  }
  
  public void setE0PhoneNo(String e0PhoneNo) {
    this.e0PhoneNo = e0PhoneNo;
  }
  
  public String getE0UnitFlag() {
    return this.e0UnitFlag;
  }
  
  public void setE0UnitFlag(String e0UnitFlag) {
    this.e0UnitFlag = e0UnitFlag;
  }
  
  public Timestamp getE0Lmd() {
    return this.e0Lmd;
  }
  
  public void setE0Lmd(Timestamp e0Lmd) {
    this.e0Lmd = e0Lmd;
  }
  
  public String getE0FullSNm() {
    return this.e0FullSNm.replace("＊桃園縣", "桃園市");
  }
  
  public void setE0FullSNm(String e0FullSNm) {
    this.e0FullSNm = e0FullSNm;
  }
  
  public String getE0ReportFlag() {
    return this.e0ReportFlag;
  }
  
  public void setE0ReportFlag(String e0ReportFlag) {
    this.e0ReportFlag = e0ReportFlag;
  }
  
  public String getE0OrgCd() {
    return this.e0OrgCd;
  }
  
  public void setE0OrgCd(String e0OrgCd) {
    this.e0OrgCd = e0OrgCd;
  }
  
  public String getE0HrUnitCd() {
    return this.e0HrUnitCd;
  }
  
  public void setE0HrUnitCd(String e0HrUnitCd) {
    this.e0HrUnitCd = e0HrUnitCd;
  }
  
  public Integer getE0DeleteFlag() {
    return this.e0DeleteFlag;
  }
  
  public void setE0DeleteFlag(Integer e0DeleteFlag) {
    this.e0DeleteFlag = e0DeleteFlag;
  }
  
  public Timestamp getE0Modify() {
    return this.e0Modify;
  }
  
  public void setE0Modify(Timestamp e0Modify) {
    this.e0Modify = e0Modify;
  }
  
  public String getE0Memo() {
    return this.e0Memo;
  }
  
  public void setE0Memo(String e0Memo) {
    this.e0Memo = e0Memo;
  }
  
  public String getE0PolicePhone() {
    return this.e0PolicePhone;
  }
  
  public void setE0PolicePhone(String e0PolicePhone) {
    this.e0PolicePhone = e0PolicePhone;
  }
  
  public String getE0UnitSort() {
    return this.e0UnitSort;
  }
  
  public void setE0UnitSort(String e0UnitSort) {
    this.e0UnitSort = e0UnitSort;
  }
  
  public String getE0OldUnit() {
    return this.e0OldUnit;
  }
  
  public void setE0OldUnit(String e0OldUnit) {
    this.e0OldUnit = e0OldUnit;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\e0db\dao\E0dtNpaunit.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */