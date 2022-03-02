package tw.gov.npa.il.report.data.il04a01;

public class AreaCodeBean implements Comparable<AreaCodeBean> {
  private String areaName;
  
  private String areaCode;
  
  private Integer sequence;
  
  public AreaCodeBean(String areaName, String areaCode, Integer sequence) {
    this.areaName = areaName;
    this.areaCode = areaCode;
    this.sequence = sequence;
  }
  
  public String getAreaName() {
    return this.areaName;
  }
  
  public void setAreaName(String areaName) {
    this.areaName = areaName;
  }
  
  public String getAreaCode() {
    return this.areaCode;
  }
  
  public void setAreaCode(String areaCode) {
    this.areaCode = areaCode;
  }
  
  public Integer getSequence() {
    return this.sequence;
  }
  
  public void setSequence(Integer sequence) {
    this.sequence = sequence;
  }
  
  public int compareTo(AreaCodeBean o) {
    return this.sequence.compareTo(o.sequence);
  }
  
  public String toString() {
    StringBuffer sb = new StringBuffer();
    sb.append("AreaCodeBean:");
    sb.append("areaName:").append(this.areaName);
    sb.append(",areaCode:").append(this.areaCode);
    sb.append(",sequence:").append(this.sequence);
    return sb.toString();
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\report\data\il04a01\AreaCodeBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */