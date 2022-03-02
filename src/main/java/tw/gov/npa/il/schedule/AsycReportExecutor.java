package tw.gov.npa.il.schedule;

import java.util.Random;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import tw.gov.npa.il.report.DailyReport;

public class AsycReportExecutor {
  private static final Logger logger = Logger.getLogger(AsycReportExecutor.class);
  
  DailyReport dailyReport;
  
  @Async
  public void doReport() {
    logger.info("do Report");
    String threadName = Thread.currentThread().getName();
    try {
      Thread.sleep((new Random()).nextInt(2147483647));
    } catch (InterruptedException e) {
      logger.error(e, e);
      Thread.currentThread().interrupt();
    } 
    logger.info(String.valueOf(threadName) + "has completed");
  }
  
  public DailyReport getDailyReport() {
    return this.dailyReport;
  }
  
  public void setDailyReport(DailyReport dailyReport) {
    this.dailyReport = dailyReport;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\schedule\AsycReportExecutor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */