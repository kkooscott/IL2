package tw.gov.npa.il.report;

import java.sql.Timestamp;
import java.util.List;
import java.util.ResourceBundle;
import tw.gov.npa.il.dao.Iltb20OnlineReport;
import tw.gov.npa.il.dao.Iltb20OnlineReportDAO;

public class IL04Report {
  ResourceBundle rb = ResourceBundle.getBundle("config");
  
  public String contextPath = this.rb.getString("contextPath").toString();
  
  public static void main(String[] arg) throws Exception {
    IL04A01Report iL04A01Report = new IL04A01Report();
    IL04B01Report iL04B01Report = new IL04B01Report();
    IL04C01Report iL04C01Report = new IL04C01Report();
    Iltb20OnlineReportDAO iltb20OnlineReportDAO = new Iltb20OnlineReportDAO();
    List<Iltb20OnlineReport> reports = iltb20OnlineReportDAO.findByIlStatus(Integer.valueOf(2));
    for (Iltb20OnlineReport report : reports) {
      String rptId = report.getId().getIlRptid();
      String whereCondition = String.valueOf(report.getIlWhere1().trim()) + 
        report.getIlWhere2().trim() + 
        report.getIlWhere3().trim() + 
        report.getIlWhere4().trim();
      report.setIlStatus("1");
      report.setIlRundt(new Timestamp(System.currentTimeMillis()));
      iltb20OnlineReportDAO.save(report);
    } 
  }
  
  public String getContextPath() {
    return this.contextPath;
  }
  
  public void setContextPath(String contextPath) {
    this.contextPath = contextPath;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\report\IL04Report.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */