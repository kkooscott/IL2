package tw.gov.npa.il.decorator;

import java.text.SimpleDateFormat;
import org.apache.log4j.Logger;
import org.displaytag.decorator.TableDecorator;
import tw.gov.npa.il.entity.IL07B;

public class IL03A01Q04Decorator extends TableDecorator {
  private static final Logger logger = Logger.getLogger(IL03A01Q04Decorator.class);
  
  private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  
  public String getOPCD() {
    IL07B il07B = (IL07B)getCurrentRowObject();
    String OPCD = il07B.getOPCD();
    return OPCD;
  }
  
  public String getOPNM() {
    IL07B il07B = (IL07B)getCurrentRowObject();
    String OPNM = il07B.getOPNM();
    return OPNM;
  }
  
  public String getOPPRSQ() {
    IL07B il07B = (IL07B)getCurrentRowObject();
    String OPPRSQ = Integer.toString(il07B.getOPPRSQ());
    return OPPRSQ;
  }
  
  public String getOPCS() {
    IL07B il07B = (IL07B)getCurrentRowObject();
    String OPCS = il07B.getOPCS();
    return OPCS;
  }
  
  public String getFunction() {
    StringBuilder sb = new StringBuilder();
    sb.append("<input type=\"radio\" id=\"optNo\" name=\"optNo\" >");
    return sb.toString();
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\decorator\IL03A01Q04Decorator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */