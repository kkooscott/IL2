package tw.gov.npa.il.decorator;

import org.apache.log4j.Logger;
import org.displaytag.decorator.TableDecorator;
import tw.gov.npa.il.action.bean.IL02A01U02Bean;
import tw.gov.npa.il.util.GetDateUtil;

public class IL02A01U02Decorator extends TableDecorator {
  private static final Logger logger = Logger.getLogger(IL02A01U02Decorator.class);
  
  public int getId() {
    IL02A01U02Bean bean = (IL02A01U02Bean)getCurrentRowObject();
    int result = bean.getId();
    return result;
  }
  
  public int getIlArcid() {
    IL02A01U02Bean bean = (IL02A01U02Bean)getCurrentRowObject();
    int result = bean.getIlArcid();
    return result;
  }
  
  public String getIlPspt() {
    IL02A01U02Bean bean = (IL02A01U02Bean)getCurrentRowObject();
    String result = bean.getIlPspt();
    return result;
  }
  
  public String getIlNTNM() {
    IL02A01U02Bean bean = (IL02A01U02Bean)getCurrentRowObject();
    String result = bean.getIlNTNM();
    return result;
  }
  
  public String getIlNtcd() {
    IL02A01U02Bean bean = (IL02A01U02Bean)getCurrentRowObject();
    String result = bean.getIlNtcd();
    return result;
  }
  
  public String getIlEnm() {
    IL02A01U02Bean bean = (IL02A01U02Bean)getCurrentRowObject();
    String result = bean.getIlEnm();
    return result;
  }
  
  public String getIlBthdt() {
    IL02A01U02Bean bean = (IL02A01U02Bean)getCurrentRowObject();
    String result = bean.getIlBthdt();
    return (new GetDateUtil()).getNoSpiltToSpiltDate(result);
  }
  
  public String getFunction() {
    IL02A01U02Bean bean = (IL02A01U02Bean)getCurrentRowObject();
    int ilArcid = bean.getIlArcid();
    int id = bean.getId();
    StringBuilder sb = new StringBuilder();
    sb.append("<input type=\"radio\" id=\"ilArcid\" name=\"ilArcid\" value=\"" + ilArcid + "\" >" + id);
    return sb.toString();
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\decorator\IL02A01U02Decorator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */