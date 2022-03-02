package tw.gov.npa.il.report.bean;

public class IL04CColumnBean {
  private String columnName;
  
  private int width;
  
  private int sequence;
  
  private boolean write;
  
  private int outputTo;
  
  public IL04CColumnBean(String columnName, int width, int sequence, boolean write) {
    this.columnName = columnName;
    this.width = width;
    this.sequence = sequence;
    this.write = write;
  }
  
  public String getColumnName() {
    return this.columnName;
  }
  
  public void setColumnName(String columnName) {
    this.columnName = columnName;
  }
  
  public int getWidth() {
    return this.width;
  }
  
  public void setWidth(int width) {
    this.width = width;
  }
  
  public int getSequence() {
    return this.sequence;
  }
  
  public void setSequence(int sequence) {
    this.sequence = sequence;
  }
  
  public boolean isWrite() {
    return this.write;
  }
  
  public void setWrite(boolean write) {
    this.write = write;
  }
  
  public boolean setWrite(String show) {
    if (show == null || show.length() == 0) {
      this.write = true;
    } else if (show.indexOf("," + this.sequence + ",") >= 0) {
      this.write = true;
    } else {
      this.write = false;
    } 
    return this.write;
  }
  
  public int getOutputTo() {
    return this.outputTo;
  }
  
  public void setOutputTo(int outputTo) {
    this.outputTo = outputTo;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\report\bean\IL04CColumnBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */