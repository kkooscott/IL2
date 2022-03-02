package tw.gov.npa.il.report;

import java.io.Serializable;
import tw.gov.npa.il.myDao.MyIltb01MainDAO;

class Counter implements Serializable {
  int number;
  
  public int getNumber() {
    return this.number;
  }
  
  public void setNumber(int number) {
    this.number = number;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\report\MyIltb01MainDAO$Counter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */