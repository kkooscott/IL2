package tw.gov.npa.il.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetDateUtil {
  public int[] getNowDate() {
    int[] nowDateArr = new int[2];
    Calendar c = Calendar.getInstance();
    c.setTime(new Date());
    int month = c.get(2);
    int year = c.get(1);
    nowDateArr[0] = year;
    nowDateArr[1] = month;
    return nowDateArr;
  }
  
  public int[] getNowYearWeek() {
    int[] nowDateArr = new int[2];
    Calendar c = Calendar.getInstance();
    c.setTime(new Date());
    int week = c.get(3);
    int year = c.get(1);
    nowDateArr[0] = year;
    nowDateArr[1] = week;
    return nowDateArr;
  }
  
  public String getLastWeekDateByYearWeek(String year, String week) {
    int yearInt = Integer.parseInt(year);
    int weekInt = Integer.parseInt(week);
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    Calendar c = Calendar.getInstance();
    c.set(1, yearInt);
    c.set(3, weekInt);
    c.set(7, 7);
    String thisTime = dateFormat.format(c.getTime());
    return thisTime;
  }
  
  public String getNoSpiltDate(String dateStr) {
    if (!"".equals(dateStr) && dateStr != null) {
      String[] tempArr = dateStr.split("/");
      dateStr = "";
      for (String s : tempArr)
        dateStr = dateStr + s; 
    } 
    return dateStr;
  }
  
  public String getNoSpiltToSpiltDate(String dateStr) {
    if (!"".equals(dateStr) && dateStr != null && 
      dateStr.length() == 8) {
      String year = dateStr.substring(0, 4);
      String month = dateStr.substring(4, 6);
      String day = dateStr.substring(6, 8);
      dateStr = year + "/" + month + "/" + day;
    } 
    return dateStr;
  }
  
  public String getSepSpiltDateStart(String dateStr) {
    if (!"".equals(dateStr) && dateStr != null) {
      String[] tempArr = dateStr.split("/");
      dateStr = tempArr[0] + "-" + tempArr[1] + "-" + tempArr[2] + " 00:00:00";
    } 
    return dateStr;
  }
  
  public String getSepSpiltDateEnd(String dateStr) {
    if (!"".equals(dateStr) && dateStr != null) {
      String[] tempArr = dateStr.split("/");
      dateStr = tempArr[0] + "-" + tempArr[1] + "-" + tempArr[2] + " 23:59:59";
    } 
    return dateStr;
  }
  
  public static void main(String[] args) throws ParseException {
    GetDateUtil getDateUtil = new GetDateUtil();
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\i\\util\GetDateUtil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */