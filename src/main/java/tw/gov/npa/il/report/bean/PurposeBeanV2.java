package tw.gov.npa.il.report.bean;

public class PurposeBeanV2 {
  private String level1;
  
  private String level2;
  
  private String code;
  
  private int sequence1;
  
  private int sequence2;
  
  public PurposeBeanV2(String level1, String level2, String code, int sequence1, int sequence2) {
    this.level1 = level1;
    this.level2 = level2;
    this.code = code;
    this.sequence1 = sequence1;
    this.sequence2 = sequence2;
  }
  
  public String getLevel1() {
    return this.level1;
  }
  
  public void setLevel1(String level1) {
    this.level1 = level1;
  }
  
  public String getLevel2() {
    return this.level2;
  }
  
  public void setLevel2(String level2) {
    this.level2 = level2;
  }
  
  public String getCode() {
    return this.code;
  }
  
  public void setCode(String code) {
    this.code = code;
  }
  
  public int getSequence1() {
    return this.sequence1;
  }
  
  public void setSequence1(int sequence1) {
    this.sequence1 = sequence1;
  }
  
  public int getSequence2() {
    return this.sequence2;
  }
  
  public void setSequence2(int sequence2) {
    this.sequence2 = sequence2;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\report\bean\PurposeBeanV2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */