package tw.gov.npa.il.decorator;

import java.text.SimpleDateFormat;
import java.util.Locale;
import org.apache.log4j.Logger;
import org.displaytag.decorator.TableDecorator;
import tw.gov.npa.il.dao.Iltb18DataProcessResult;

public class IL05C01Q01Decorator extends TableDecorator {
  private static final Logger logger = Logger.getLogger(IL05C01Q01Decorator.class);
  
  private SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
  
  public String getJOB_NAME() {
    Iltb18DataProcessResult bean = (Iltb18DataProcessResult)getCurrentRowObject();
    String user = bean.getIlImpuid();
    logger.info("user:" + user);
    String type = "(自動)";
    if (!user.trim().equals("System"))
      type = "(手動)"; 
    if (bean.getId().getIlImptp().equals("3"))
      return "居留主檔資料轉入" + type; 
    if (bean.getId().getIlImptp().equals("4"))
      return "移民署查察記事資料轉入" + type; 
    if (bean.getId().getIlImptp().equals("T"))
      return "查察記事資料轉出" + type; 
    return " ";
  }
  
  public String getIMPDT() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Iltb18DataProcessResult bean = (Iltb18DataProcessResult)getCurrentRowObject();
    return sdf.format(bean.getId().getIlImpdt());
  }
  
  public String getTOTAL_COUNT() {
    Iltb18DataProcessResult bean = (Iltb18DataProcessResult)getCurrentRowObject();
    return Integer.toString(bean.getIlImptot().intValue());
  }
  
  public String getSUCCESS_COUNT() {
    Iltb18DataProcessResult bean = (Iltb18DataProcessResult)getCurrentRowObject();
    return Integer.toString(bean.getIlImpok().intValue());
  }
  
  public String getFAIL_COUNT() {
    Iltb18DataProcessResult bean = (Iltb18DataProcessResult)getCurrentRowObject();
    logger.info("tot:" + bean.getIlImptot() + " suce:" + bean.getIlImpok());
    return Integer.toString(bean.getIlImptot().intValue() - bean.getIlImpok().intValue());
  }
  
  public String getSTATUS() {
    Iltb18DataProcessResult bean = (Iltb18DataProcessResult)getCurrentRowObject();
    if (bean.getIlImpst().equals("0"))
      return "尚未執行"; 
    if (bean.getIlImpst().equals("1"))
      return "完成"; 
    if (bean.getIlImpst().equals("2"))
      return "執行中"; 
    if (bean.getIlImpst().equals("3"))
      return "執行失敗"; 
    if (bean.getIlImpst().equals("4"))
      return "處理失敗"; 
    if (bean.getIlImpst().equals("5"))
      return "處理逾時"; 
    return " ";
  }
  
  public String getFILENAME() {
    Iltb18DataProcessResult bean = (Iltb18DataProcessResult)getCurrentRowObject();
    String link = "<a href=\"il/dlsample.jsp?filename=" + bean.getIlImpfl().trim() + "\">" + bean.getIlImpfl().trim() + "</a>";
    return link;
  }
  
  public String getINFO() {
    SimpleDateFormat sdf4 = new SimpleDateFormat("hhmmss", Locale.ENGLISH);
    Iltb18DataProcessResult bean = (Iltb18DataProcessResult)getCurrentRowObject();
    if (bean.getId().getIlImptp().equals("3")) {
      String value = "<a href=\"il/dlsample.jsp?filename=" + bean.getIlImpfl().trim().replace(".txt", "") + "_" + sdf4.format(bean.getId().getIlImpdt()) + "_" + bean.getIlImpuid().trim() + ".txt\" >錯誤</a>&nbsp" + "<a href=\"il/dlsample.jsp?filename=" + bean.getIlImpfl().trim().replace(".txt", "") + "_" + sdf4.format(bean.getId().getIlImpdt()) + "_" + bean.getIlImpuid().trim() + ".rbk\" >校對清冊</a>";
      return value;
    } 
    if (bean.getId().getIlImptp().equals("4")) {
      String value = "<a href=\"il/dlsample.jsp?filename=" + bean.getIlImpfl().trim().replace(".txt", "") + "_" + sdf4.format(bean.getId().getIlImpdt()) + "_" + bean.getIlImpuid().trim() + ".txt\" >錯誤</a> &nbsp" + "<a href=\"il/dlsample.jsp?filename=" + bean.getIlImpfl().trim().replace(".txt", "") + "_" + sdf4.format(bean.getId().getIlImpdt()) + "_" + bean.getIlImpuid().trim() + ".err\" >校對清冊</a>";
      return value;
    } 
    if (bean.getId().getIlImptp().equals("T")) {
      String value = "<a href=\"il/dlsample.jsp?filename=" + bean.getIlImpfl().trim().replace(".txt", "") + "_" + sdf4.format(bean.getId().getIlImpdt()) + "_" + bean.getIlImpuid().trim() + ".txt\" >轉出資料</a>";
      return value;
    } 
    return " ";
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\decorator\IL05C01Q01Decorator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */