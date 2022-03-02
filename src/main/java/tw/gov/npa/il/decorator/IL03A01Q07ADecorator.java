package tw.gov.npa.il.decorator;

import java.sql.Timestamp;
import org.apache.log4j.Logger;
import org.displaytag.decorator.TableDecorator;
import tw.gov.npa.il.action.bean.IL03A01Q07Bean;

public class IL03A01Q07ADecorator extends TableDecorator {
  private static final Logger logger = Logger.getLogger(IL03A01Q07ADecorator.class);
  
  public int getId() {
    IL03A01Q07Bean bean = (IL03A01Q07Bean)getCurrentRowObject();
    int result = getListIndex();
    return result;
  }
  
  public Timestamp getIlPtrldt() {
    IL03A01Q07Bean bean = (IL03A01Q07Bean)getCurrentRowObject();
    Timestamp result = bean.getIlPtrldt();
    return result;
  }
  
  public String getIlPtrlst() {
    IL03A01Q07Bean bean = (IL03A01Q07Bean)getCurrentRowObject();
    String result = bean.getIlPtrlst();
    return result;
  }
  
  public String getIlPtrlmrk() {
    IL03A01Q07Bean bean = (IL03A01Q07Bean)getCurrentRowObject();
    String result = bean.getIlPtrlmrk();
    return result;
  }
  
  public String getIlUnm() {
    IL03A01Q07Bean bean = (IL03A01Q07Bean)getCurrentRowObject();
    String result = bean.getIlUnm();
    return result;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\decorator\IL03A01Q07ADecorator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */