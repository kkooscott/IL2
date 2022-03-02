package tw.gov.npa.il.util;

import com.google.common.base.Strings;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.log4j.Logger;

public class CVUtil {
  private static final Logger logger = Logger.getLogger(CVUtil.class);
  
  public static Date rocDayToDate(String yyyMMddSlash) {
    Date date;
    if (Strings.isNullOrEmpty(yyyMMddSlash))
      return null; 
    String[] ary = yyyMMddSlash.split("/", -1);
    String yyyy = String.valueOf(Integer.parseInt(ary[0]) + 1911);
    DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
    try {
      date = df.parse(yyyy + "/" + ary[1] + "/" + ary[2] + " 00:00:00.000");
    } catch (ParseException e) {
      logger.error(e, e);
      date = null;
    } 
    return date;
  }
  
  public static String getROCYYYMMDD() {
    return getROCYYYMMDD(new Date());
  }
  
  public static String getROCYYYMMDD(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
    String yyyyMMDD = df.format(cal.getTime());
    String[] ary = yyyyMMDD.split("/", -1);
    String ROCYear = String.valueOf(Integer.parseInt(ary[0]) - 1911);
    return ROCYear + "/" + ary[1] + "/" + ary[2];
  }
  
  public static String getROCFullStatement(Date date) {
    return getROCYYYMMDD(date) + " 00:00:00.000";
  }
  
  public static String getLogDateStatement(Date date) {
    DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    return df.format(date);
  }
  
  public static String getBackupDateTimeString(Date date) {
    DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    return df.format(date);
  }
  
  public static Date getStringToDateTime(String dateStr) throws ParseException {
    DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    return df.parse(dateStr);
  }
  
  public static Timestamp getStringToTimestamp(String dateStr) throws ParseException {
    Date date = getStringToDateTime(dateStr);
    return new Timestamp(date.getTime());
  }
  
  public static String getYYYYMMDD(Date date) {
    DateFormat df = new SimpleDateFormat("yyyyMMdd");
    return df.format(date);
  }
  
  public static String trim(String str) {
    if (str == null)
      return ""; 
    return str.trim();
  }
  
  public static String trim(BigDecimal bigDecimal) {
    if (bigDecimal == null)
      return ""; 
    return String.valueOf(bigDecimal);
  }
  
  public static String trim(Date date) {
    if (date == null)
      return ""; 
    return getBackupDateTimeString(date);
  }
  
  public static String trim(Integer oriInt) {
    if (oriInt == null)
      return ""; 
    return oriInt.toString();
  }
  
  public static String trim(Short oriShort) {
    if (oriShort == null)
      return ""; 
    return oriShort.toString();
  }
  
  public static Object revertFromString(String str, Class cls) throws ParseException {
    if ("java.lang.Integer".equals(cls.getName()))
      return Integer.valueOf(str); 
    if ("java.lang.Double".equals(cls.getName()))
      return Double.valueOf(str); 
    if ("java.lang.Short".equals(cls.getName()))
      return Short.valueOf(str); 
    if ("java.sql.Timestamp".equals(cls.getName()))
      return getStringToTimestamp(str); 
    if ("java.math.BigDecimal".equals(cls.getName()))
      return new BigDecimal(str); 
    return str;
  }
  
  public static Timestamp getCurrentTimeStamp() {
    return convertFromDate(new Date());
  }
  
  public static Timestamp convertFromDate(Date date) {
    return new Timestamp(date.getTime());
  }
  
  public static String getCurrentTime() {
    return getLogDateStatement(new Date());
  }
  
  public static String getLOGTDT(String str) {
    str = str.replace("%2F", "/");
    str = str.replace("+", " ");
    str = str.replace("%3A", ":");
    return "20" + str;
  }
  
  public static boolean equals(Object beforeObj, Object afterObj) {
    if (beforeObj == null && afterObj == null)
      return true; 
    if (beforeObj == null && afterObj != null)
      return false; 
    if (beforeObj != null && afterObj == null)
      return false; 
    if (beforeObj instanceof Integer)
      return (((Integer)beforeObj).compareTo((Integer)afterObj) == 0); 
    if (beforeObj instanceof String)
      return beforeObj.equals(afterObj); 
    if (beforeObj instanceof Short)
      return (((Short)beforeObj).compareTo((Short)afterObj) == 0); 
    if (beforeObj instanceof Timestamp)
      return (((Timestamp)beforeObj).compareTo((Timestamp)afterObj) == 0); 
    if (beforeObj instanceof BigDecimal)
      return (((BigDecimal)beforeObj).compareTo((BigDecimal)afterObj) == 0); 
    return false;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\i\\util\CVUtil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */