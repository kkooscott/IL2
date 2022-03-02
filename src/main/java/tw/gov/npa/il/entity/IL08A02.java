package tw.gov.npa.il.entity;

import java.util.Date;

public class IL08A02 {
  private int id;
  
  private String group;
  
  private String type;
  
  private Date sTime;
  
  private Date eTime;
  
  private String status;
  
  private String mUserName;
  
  private String mUnitId;
  
  public int getId() {
    return this.id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getGroup() {
    return this.group;
  }
  
  public void setGroup(String group) {
    this.group = group;
  }
  
  public String getType() {
    return this.type;
  }
  
  public void setType(String type) {
    this.type = type;
  }
  
  public Date getsTime() {
    return this.sTime;
  }
  
  public void setsTime(Date sTime) {
    this.sTime = sTime;
  }
  
  public Date geteTime() {
    return this.eTime;
  }
  
  public void seteTime(Date eTime) {
    this.eTime = eTime;
  }
  
  public String getStatus() {
    return this.status;
  }
  
  public void setStatus(String status) {
    this.status = status;
  }
  
  public String getmUserName() {
    return this.mUserName;
  }
  
  public void setmUserName(String mUserName) {
    this.mUserName = mUserName;
  }
  
  public String getmUnitId() {
    return this.mUnitId;
  }
  
  public void setmUnitId(String mUnitId) {
    this.mUnitId = mUnitId;
  }
  
  public String toString() {
    return "CV08A02{id='" + 
      this.id + '\'' + 
      ", group='" + this.group + '\'' + 
      ", type='" + this.type + '\'' + 
      ", sTime='" + this.sTime + '\'' + 
      ", eTime='" + this.eTime + '\'' + 
      ", status='" + this.status + '\'' + 
      ", mUserName='" + this.mUserName + '\'' + 
      ", mUnitId='" + this.mUnitId + '\'' + 
      '}';
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\entity\IL08A02.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */