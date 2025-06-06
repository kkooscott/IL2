package tw.gov.npa.il.decorator;

import com.google.common.base.Strings;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.log4j.Logger;
import org.displaytag.decorator.TableDecorator;
import tw.gov.npa.il.dao.IlScheduleMngId;
import tw.gov.npa.il.myDao.IL08B01U01Dao;
import tw.gov.npa.il.util.Constant;

public class IL08B01U01Decorator extends TableDecorator {
  private static final Logger logger = Logger.getLogger(IL08B01U01Decorator.class);
  
  private String _DATE_FORMAT = "yyyy/MM/dd HH:mm";
  
  public String getId() {
    IlScheduleMngId cv08A02 = (IlScheduleMngId)getCurrentRowObject();
    String id = String.valueOf(cv08A02.getId());
    return id;
  }
  
  public String getType() {
    IlScheduleMngId cv08A02 = (IlScheduleMngId)getCurrentRowObject();
    String type = cv08A02.getType();
    String str = "";
    if (!Strings.isNullOrEmpty(type))
      str = (String)IL08B01U01Dao.typeMap.get(type); 
    return str;
  }
  
  public String getsTime() {
    IlScheduleMngId cv08A02 = (IlScheduleMngId)getCurrentRowObject();
    String str = "";
    Date date = cv08A02.getStime();
    if (date != null) {
      DateFormat sdf = new SimpleDateFormat(this._DATE_FORMAT);
      str = sdf.format(date);
    } 
    return str;
  }
  
  public String geteTime() {
    IlScheduleMngId cv08A02 = (IlScheduleMngId)getCurrentRowObject();
    String str = "";
    Date date = cv08A02.getEtime();
    if (date != null) {
      DateFormat sdf = new SimpleDateFormat(this._DATE_FORMAT);
      str = sdf.format(date);
    } 
    return str;
  }
  
  public String getStatus() {
    IlScheduleMngId cv08A02 = (IlScheduleMngId)getCurrentRowObject();
    String status = cv08A02.getStatus();
    String str = "";
    if (!Strings.isNullOrEmpty(status))
      str = (String)(new Constant()).getIlStatusMap().get(status); 
    return str;
  }
  
  public String getINFO() {
    IlScheduleMngId cv08A02 = (IlScheduleMngId)getCurrentRowObject();
    String status = cv08A02.getStatus();
    int id = cv08A02.getId().intValue();
    String fileDate = cv08A02.getMuserName();
    SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy.MM", Locale.ENGLISH);
    StringBuilder sb = new StringBuilder();
    logger.info("ID" + id);
    if (!Strings.isNullOrEmpty(status) && status.equals("1"))
      sb.append("<input class=\"btnDetail InputButton\" type=\"button\" value=\"顯示\" onclick=\"window.open('../IL2/NPA/" + fileDate.split("@")[0] + "_" + id + "_err.txt')\">"); 
    return sb.toString();
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\decorator\IL08B01U01Decorator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */