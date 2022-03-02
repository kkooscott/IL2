package tw.gov.npa.il.report.bean;

public class IDTypeBean {
  private String typeName;
  
  private int sequence;
  
  public IDTypeBean(String typeName, int sequence) {
    this.typeName = typeName;
    this.sequence = sequence;
  }
  
  public String getTypeName() {
    return this.typeName;
  }
  
  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }
  
  public int getSequence() {
    return this.sequence;
  }
  
  public void setSequence(int sequence) {
    this.sequence = sequence;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\report\bean\IDTypeBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */