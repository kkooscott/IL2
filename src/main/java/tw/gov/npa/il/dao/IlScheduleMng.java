package tw.gov.npa.il.dao;

import java.io.Serializable;

public class IlScheduleMng implements Serializable {
  private IlScheduleMngId id;
  
  public IlScheduleMng() {}
  
  public IlScheduleMng(IlScheduleMngId id) {
    this.id = id;
  }
  
  public IlScheduleMngId getId() {
    return this.id;
  }
  
  public void setId(IlScheduleMngId id) {
    this.id = id;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\IlScheduleMng.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */