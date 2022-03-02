package tw.gov.npa.il.report;

import org.apache.log4j.Logger;

public class DailyReport {
  private static final Logger logger = Logger.getLogger(DailyReport.class);
  
  public void doReport(String scheduleType) {
    logger.info(String.valueOf(scheduleType) + "報表排程");
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\report\DailyReport.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */