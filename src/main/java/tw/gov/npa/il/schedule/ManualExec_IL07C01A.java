package tw.gov.npa.il.schedule;

import javax.sql.DataSource;
import tw.gov.npa.il.e0db.myDao.RelationDAO;
import tw.gov.npa.il.myDao.IL07C01ADao;
import tw.gov.npa.il.schedule.ILReportSchedule;
import tw.gov.npa.il.schedule.JdbcDataSourceImpl;
import tw.gov.npa.il.tranceData.IL07C01A;

public class ManualExec_IL07C01A {
  public static void main(String[] paramArrayOfString) {
    System.out.println("manualexec");
    ILReportSchedule iLReportSchedule = new ILReportSchedule();
    iLReportSchedule.iL07C01A = new IL07C01A();
    iLReportSchedule.iL07C01A.il07C01ADao = new IL07C01ADao();
    iLReportSchedule.iL07C01A.il07C01ADao.setDataSource((DataSource)new JdbcDataSourceImpl());
    iLReportSchedule.iL07C01A.relationDAO = new RelationDAO();
    iLReportSchedule.iL07C01A.relationDAO.setDataSource((DataSource)new JdbcDataSourceImpl());
    iLReportSchedule.runReportFixColumn();
  }
}
