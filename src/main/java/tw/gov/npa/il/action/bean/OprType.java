package tw.gov.npa.il.action.bean;

public enum OprType {
  Insert("N"),
  Delete("D"),
  Update("U"),
  Query("Q"),
  Print("T"),
  WebService("W");
  
  private final String name;
  
  OprType(String s) {
    this.name = s;
  }
  
  public boolean equalsName(String otherName) {
    return (otherName == null) ? false : this.name.equals(otherName);
  }
  
  public String toString() {
    return this.name;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\bean\OprType.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */