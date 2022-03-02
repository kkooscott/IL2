package tw.gov.npa.il.timerTask;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.TimerTask;
import tw.gov.npa.il.dao.HibernateSessionFactory;
import tw.gov.npa.il.report.IL04A01Report;

public class CDRecordCollectorTimerTask extends TimerTask {
  public void run() {
    System.out.println("總TimerTask Start... TimerTask任務時間：" + new Date());
    try {
      long startTime = System.currentTimeMillis();
      System.out.println("TimerTask Start");
      IL04A01Report.main(null);
      System.out.println("TimerTask Over");
      DecimalFormat myformat = new DecimalFormat("0.00");
      long endTime = System.currentTimeMillis();
      long costLong = (endTime - startTime) / 1000L / 60L;
      String cost = myformat.format(costLong);
      System.out.println(new Date() + ": 總TimerTask finish., 執行花費時間=" + cost + "分鐘");
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("TimerTask任務 failed：" + e.getMessage());
    } finally {
      try {
        HibernateSessionFactory.getSession().close();
      } catch (Exception e) {
        e.printStackTrace();
      } 
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\timerTask\CDRecordCollectorTimerTask.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */