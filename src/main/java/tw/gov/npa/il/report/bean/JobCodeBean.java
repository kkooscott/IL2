package tw.gov.npa.il.report.bean;

public class JobCodeBean {
  private String code;
  
  private String name;
  
  public JobCodeBean(String code, String name) {
    this.code = code;
    this.name = name;
  }
  
  public String getCode() {
    return this.code;
  }
  
  public void setCode(String code) {
    this.code = code;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\report\bean\JobCodeBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */