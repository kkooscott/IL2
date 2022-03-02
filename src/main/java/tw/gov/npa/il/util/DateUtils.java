package tw.gov.npa.il.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.log4j.Logger;

public class DateUtils {
  private static Logger logger = Logger.getLogger(DateUtils.class);
  
  public static String getCNow(boolean title) {
    String rv = "";
    Calendar c = Calendar.getInstance();
    int year = c.get(1) - 1911;
    int month = c.get(2) + 1;
    int day = c.get(5);
    if (title)
      rv = String.valueOf(rv) + "民國"; 
    rv = String.valueOf(rv) + String.format("%d年%d月%d日", new Object[] { Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day) });
    return rv;
  }
  
  public static String getACDate(String input) {
    logger.info("Enter getACDate input: " + input);
    String rv = "";
    if (input != null && !"".equals(input)) {
      String[] res = input.split("/");
      rv = Integer.toString(Integer.parseInt(res[0]) + 1911);
      rv = String.valueOf(rv) + res[1];
      rv = String.valueOf(rv) + res[2];
    } 
    return rv;
  }
  
  public static String getDate(String input) {
    logger.info("Enter getDate input: " + input);
    String rv = "";
    if (input != null && !"".equals(input)) {
      rv = 
        Integer.toString(Integer.parseInt(input.substring(0, 4)) - 1911);
      rv = String.valueOf(rv) + "/";
      rv = String.valueOf(rv) + input.substring(4, 6);
      rv = String.valueOf(rv) + "/";
      rv = String.valueOf(rv) + input.substring(6, 8);
    } 
    return rv;
  }
  
  public static String getNowDate() {
    Calendar c = Calendar.getInstance();
    return (new SimpleDateFormat("yyyyMMdd")).format(c.getTime());
  }
  
  public static String getNowTime() {
    Calendar c = Calendar.getInstance();
    return (new SimpleDateFormat("HHmmss")).format(c.getTime());
  }
  
  public static Map<String, String> getTimeMap(int type) {
    Map<String, String> rv = new LinkedHashMap<String, String>();
    int range = 0;
    switch (type) {
      case 0:
        range = 24;
        break;
      case 1:
        range = 60;
        break;
    } 
    for (int i = 0; i < range; i++) {
      String h = String.format("%02d", new Object[] { Integer.valueOf(i) });
      rv.put(h, h);
    } 
    return rv;
  }
  
  public static String getNowStr(String format) {
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    return sdf.format(Calendar.getInstance().getTime());
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\i\\util\DateUtils.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */