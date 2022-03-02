package tw.gov.npa.il.entity.basic;

import java.sql.Timestamp;

public class TbAnnounce {
  private int no;
  
  private String kind;
  
  private String content;
  
  private String beginDate;
  
  private String beginTime;
  
  private String endDate;
  
  private String endTime;
  
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
  
  public String getBeginTime() {
    return this.beginTime;
  }
  
  public void setBeginTime(String beginTime) {
    this.beginTime = beginTime;
  }
  
  public String getEndDate() {
    return this.endDate;
  }
  
  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }
  
  public String getEndTime() {
    return this.endTime;
  }
  
  public void setEndTime(String endTime) {
    this.endTime = endTime;
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
    return "no: " + this.no + ", kind: " + this.kind + ", content: " + this.content + 
      ", beginDate: " + this.beginDate + ", beginTime: " + this.beginTime + 
      ", endDate: " + this.endDate + ", endTime: " + this.endTime + ", uid: " + 
      this.uid + ", uName: " + this.uName + ", settingDate: " + this.settingDate + 
      ", settingTime: " + this.settingTime + ", modified: " + this.modified;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\entity\basic\TbAnnounce.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */