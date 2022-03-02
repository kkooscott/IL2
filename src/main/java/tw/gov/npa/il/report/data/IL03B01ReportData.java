package tw.gov.npa.il.report.data;

import java.util.List;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.log4j.Logger;
import tw.gov.npa.il.dao.Iltb01Main;
import tw.gov.npa.il.report.data.il03B01.Builder03B01;

public class IL03B01ReportData {
  private static final Logger logger = Logger.getLogger(IL03B01ReportData.class);
  
  public static JRBeanCollectionDataSource buildDataSourceIL03B01_2P(List<Iltb01Main> iltb01MainList) {
    return Builder03B01.buildBy02P(iltb01MainList);
  }
  
  public static JRBeanCollectionDataSource buildDataSourceIL03B01_3P(List<Iltb01Main> iltb01MainList) {
    return Builder03B01.build(iltb01MainList);
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\report\data\IL03B01ReportData.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */