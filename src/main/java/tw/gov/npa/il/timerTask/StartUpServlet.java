package tw.gov.npa.il.timerTask;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StartUpServlet extends HttpServlet {
  public void destroy() {
    super.destroy();
  }
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
  
  public void init() throws ServletException {
    System.out.println("StartUpServlet init Start... Set 01:00 Execute");
    Calendar c = Calendar.getInstance();
    c.set(5, 1);
    c.set(11, 1);
    c.set(12, 0);
    c.set(13, 0);
    c.set(14, 0);
    CDRecordCollectorTimerTask cDRecordCollectorTimerTask = new CDRecordCollectorTimerTask();
    Date firstTime = new Date();
    long period = 86400000L;
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(cDRecordCollectorTimerTask, firstTime, period);
    try {
      Thread.sleep(10000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } 
    System.out.println("StartUpServlet init finish.");
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\timerTask\StartUpServlet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */