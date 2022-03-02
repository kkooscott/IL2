package tw.gov.npa.il.decorator;

import org.apache.log4j.Logger;
import org.displaytag.decorator.TableDecorator;
import tw.gov.npa.il.entity.IL07C;

public class IL07CDecorator extends TableDecorator {
  private static final Logger logger = Logger.getLogger(IL07CDecorator.class);
  
  public String getUVCD() {
    IL07C il07C = (IL07C)getCurrentRowObject();
    String UVCD = il07C.getUVCD();
    return UVCD;
  }
  
  public String getUVCNM() {
    IL07C il07C = (IL07C)getCurrentRowObject();
    String UVCNM = il07C.getUVCNM();
    return UVCNM;
  }
  
  public String getUVPZONE() {
    IL07C il07C = (IL07C)getCurrentRowObject();
    String UVPZONE = il07C.getUVPZONE();
    return UVPZONE;
  }
  
  public String getUVTEL() {
    IL07C il07C = (IL07C)getCurrentRowObject();
    String UVTEL = il07C.getUVTEL();
    return UVTEL;
  }
  
  public String getFunction() {
    StringBuilder sb = new StringBuilder();
    sb.append("<input type=\"radio\" id=\"optNo\" name=\"optNo\" >");
    return sb.toString();
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\decorator\IL07CDecorator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */