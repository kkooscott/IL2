package tw.gov.npa.il.entity.input.cw09b;

import java.sql.Timestamp;

public class Input09B {
  private int no;
  
  private String kind;
  
  private String content;
  
  private String beginDate;
  
  private String beginHour;
  
  private String beginMinute;
  
  private String endDate;
  
  private String endHour;
  
  private String endMinute;
  
  private String uid;
  
  private String uName;
  
  private String settingDate;
  
  private String settingTime;
  
  private Timestamp modified;
  
  public int getNo() {
    return this.no;
  }
  
  public void setNo(int no) {
    this.no = no;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public void setKind(String kind) {
    this.kind = kind;
  }
  
  public String getContent() {
    return this.content;
  }
  
  public void setContent(String content) {
    this.content = content;
  }
  
  public String getBeginDate() {
    return this.beginDate;
  }
  
  public void setBeginDate(String beginDate) {
    this.beginDate = beginDate;
  }
  
  public String getBeginHour() {
    return this.beginHour;
  }
  
  public void setBeginHour(String beginHour) {
    this.beginHour = beginHour;
  }
  
  public String getBeginMinute() {
    return this.beginMinute;
  }
  
  public void setBeginMinute(String beginMinute) {
    this.beginMinute = beginMinute;
  }
  
  public String getEndDate() {
    return this.endDate;
  }
  
  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }
  
  public String getEndHour() {
    return this.endHour;
  }
  
  public void setEndHour(String endHour) {
    this.endHour = endHour;
  }
  
  public String getEndMinute() {
    return this.endMinute;
  }
  
  public void setEndMinute(String endMinute) {
    this.endMinute = endMinute;
  }
  
  public String getUid() {
    return this.uid;
  }
  
  public void setUid(String uid) {
    this.uid = uid;
  }
  
  public String getuName() {
    return this.uName;
  }
  
  public void setuName(String uName) {
    this.uName = uName;
  }
  
  public String getSettingDate() {
    return this.settingDate;
  }
  
  public void setSettingDate(String settingDate) {
    this.settingDate = settingDate;
  }
  
  public String getSettingTime() {
    return this.settingTime;
  }
  
  public void setSettingTime(String settingTime) {
    this.settingTime = settingTime;
  }
  
  public Timestamp getModified() {
    return this.modified;
  }
  
  public void setModified(Timestamp modified) {
    this.modified = modified;
  }
  
  public String toString() {
    return "Input09B [no=" + this.no + ", kind=" + this.kind + ", content=" + this.content + 
      ", beginDate=" + this.beginDate + ", beginHour=" + this.beginHour + 
      ", beginMinute=" + this.beginMinute + ", endDate=" + this.endDate + 
      ", endHour=" + this.endHour + ", endMinute=" + this.endMinute + 
      ", uid=" + this.uid + ", uName=" + this.uName + ", settingDate=" + 
      this.settingDate + ", settingTime=" + this.settingTime + ", modified=" + 
      this.modified + "]";
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\entity\input\cw09b\Input09B.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */