package tw.gov.npa.il.decorator;

import java.text.SimpleDateFormat;
import org.apache.log4j.Logger;
import org.displaytag.decorator.TableDecorator;
import tw.gov.npa.il.entity.IL07A;

public class IL07ADecorator extends TableDecorator {
  private static final Logger logger = Logger.getLogger(IL07ADecorator.class);
  
  private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  
  public String getNTCD() {
    IL07A il07A = (IL07A)getCurrentRowObject();
    String NTCD = il07A.getNTCD();
    return NTCD;
  }
  
  public String getNTNM() {
    IL07A il07A = (IL07A)getCurrentRowObject();
    String NTNM = il07A.getNTNM();
    return NTNM;
  }
  
  public String getNTLBR() {
    IL07A il07A = (IL07A)getCurrentRowObject();
    String NTLBR = il07A.getNTLBR();
    return NTLBR;
  }
  
  public String getNTPRSQ() {
    IL07A il07A = (IL07A)getCurrentRowObject();
    String NTPRSQ = Integer.toString(il07A.getNTPRSQ());
    return NTPRSQ;
  }
  
  public String getNTDTS() {
    IL07A il07A = (IL07A)getCurrentRowObject();
    String NTDTS = "";
    if (il07A.getNTDTS() != null)
      NTDTS = this.df.format(il07A.getNTDTS()); 
    return NTDTS;
  }
  
  public String getNTDTE() {
    IL07A il07A = (IL07A)getCurrentRowObject();
    String NTDTE = "";
    if (il07A.getNTDTE() != null)
      NTDTE = this.df.format(il07A.getNTDTE()); 
    return NTDTE;
  }
  
  public String getFunction() {
    StringBuilder sb = new StringBuilder();
    sb.append("<input type=\"radio\" id=\"optNo\" name=\"optNo\" >");
    return sb.toString();
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\decorator\IL07ADecorator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */