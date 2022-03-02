package tw.gov.npa.il.decorator;

import org.apache.log4j.Logger;
import org.displaytag.decorator.TableDecorator;
import tw.gov.npa.il.dao.Iltb01Main;

public class IL02C01U02Decorator extends TableDecorator {
  private static final Logger logger = Logger.getLogger(IL02C01U02Decorator.class);
  
  public String getIlArcno() {
    Iltb01Main bean = (Iltb01Main)getCurrentRowObject();
    String result = bean.getIlArcno();
    return result;
  }
  
  public String getIlArccs() {
    Iltb01Main bean = (Iltb01Main)getCurrentRowObject();
    String ilArccs = bean.getIlArccs();
    String result = null;
    if ("0".equals(ilArccs)) {
      result = "外僑";
    } else if ("1".equals(ilArccs)) {
      result = "外勞";
    } else {
      result = "查無資料";
    } 
    return result;
  }
  
  public String getIlJbpzone() {
    Iltb01Main bean = (Iltb01Main)getCurrentRowObject();
    String result = bean.getIlJbpzone();
    return result;
  }
  
  public String getIlAraddr() {
    Iltb01Main bean = (Iltb01Main)getCurrentRowObject();
    String result = bean.getIlAraddr();
    return result;
  }
  
  public String getIlPstext() {
    Iltb01Main bean = (Iltb01Main)getCurrentRowObject();
    String ilPstext = (bean.getIlPstext() == null) ? "" : bean.getIlPstext().trim();
    int ilArcid = bean.getIlArcid().intValue();
    StringBuilder sb = new StringBuilder();
    sb.append("<input type=\"text\" id=\"ilPstext" + ilArcid + "\" name=\"ilPstext\" maxlength='2' class='InputText' style='width:50px;' value=\"" + ilPstext + "\" >");
    return sb.toString();
  }
  
  public String getIlArctp() {
    Iltb01Main bean = (Iltb01Main)getCurrentRowObject();
    int ilArcid = bean.getIlArcid().intValue();
    StringBuilder sb = new StringBuilder();
    sb.append("<input type=\"button\" name=\"btnQuery\" id=\"btnQuery\" class=\"InputButton\" onclick=\"doUpdate(" + ilArcid + ");\" value=\"更新\" />");
    return sb.toString();
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\decorator\IL02C01U02Decorator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */