package tw.gov.npa.il.report.bean;

public class YearBean {
  private String yearName;
  
  private int requence;
  
  public YearBean(String yearName, int requence) {
    this.yearName = yearName;
    this.requence = requence;
  }
  
  public String getYearName() {
    return this.yearName;
  }
  
  public void setYearName(String yearName) {
    this.yearName = yearName;
  }
  
  public int getRequence() {
    return this.requence;
  }
  
  public void setRequence(int requence) {
    this.requence = requence;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\report\bean\YearBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */