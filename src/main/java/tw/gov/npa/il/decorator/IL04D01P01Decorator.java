package tw.gov.npa.il.decorator;

import org.apache.log4j.Logger;
import org.displaytag.decorator.TableDecorator;
import tw.gov.npa.il.action.bean.IL04D01P01Bean;
import tw.gov.npa.il.util.Constant;

public class IL04D01P01Decorator extends TableDecorator {
//  private static final Logger logger = Logger.getLogger(IL04D01P01Decorator.class);
  
  private boolean ifCheck = false;
  
  public String getId() {
    IL04D01P01Bean bean = (IL04D01P01Bean)getCurrentRowObject();
    String status = bean.getIlStatus();
    String ilRptid = bean.getIlRptid();
    StringBuilder sb = new StringBuilder();
    if ("1".equals(status)) {
      if (this.ifCheck) {
        if ("01".equals(ilRptid) || "20".equals(ilRptid)) {
          sb.append("<input type=\"radio\" id=\"RPT\" name=\"RPT\" value=\"" + bean.getIlRptfn().trim() + ".txt\" >txt<br>");
          sb.append("<input type=\"radio\" id=\"RPT\" name=\"RPT\" value=\"" + bean.getIlRptfn().trim() + ".csv\" >csv");
        } else {
          sb.append("<input type=\"radio\" id=\"RPT\" name=\"RPT\" value=\"" + bean.getIlRptfn().trim() + ".xls\" >");
        } 
      } else {
        this.ifCheck = true;
        if ("01".equals(ilRptid) || "20".equals(ilRptid)) {
          sb.append("<input type=\"radio\" id=\"RPT\" name=\"RPT\" value=\"" + bean.getIlRptfn().trim() + ".txt\" checked >txt<br>");
          sb.append("<input type=\"radio\" id=\"RPT\" name=\"RPT\" value=\"" + bean.getIlRptfn().trim() + ".csv\">csv");
        } else {
          sb.append("<input type=\"radio\" id=\"RPT\" name=\"RPT\" value=\"" + bean.getIlRptfn().trim() + ".xls\" checked >");
        } 
      } 
    } else {
      sb.append("<input type=\"radio\" id=\"RPT\" name=\"RPT\" value=\"\" disabled >");
    } 
    return sb.toString();
  }
  
  public String getIlSnddt() {
    IL04D01P01Bean bean = (IL04D01P01Bean)getCurrentRowObject();
    String result = timeAdToRoc(bean.getIlSnddt().toString().replace("-", "/"));
    return result.substring(0, result.lastIndexOf("."));
  }
  
  public String getIlRptnm() {
    IL04D01P01Bean bean = (IL04D01P01Bean)getCurrentRowObject();
    String result = bean.getIlRptnm();
    return result;
  }
  
  public String getIlStatus() {
    IL04D01P01Bean bean = (IL04D01P01Bean)getCurrentRowObject();
    String result = (String)(new Constant()).getIlStatusMap().get(bean.getIlStatus());
    return result;
  }
  
  public static String timeAdToRoc(String time) {
    if ((time.split("/")).length == 3)
      return (Integer.parseInt(time.substring(0, time.indexOf("/"))) - 1911) + time.substring(time.indexOf("/")); 
    if ((time.split("-")).length == 3)
      return ((Integer.parseInt(time.substring(0, time.indexOf("-"))) - 1911) + time.substring(time.indexOf("-"))).replace("-", "/"); 
    return time;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\decorator\IL04D01P01Decorator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */