package tw.gov.npa.il.report.data;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.log4j.Logger;
import tw.gov.npa.il.report.data.il04b01.Builder08B01P;
import tw.gov.npa.il.report.data.il04b01.Builder08B02P;
import tw.gov.npa.il.report.data.il04b01.Builder08B03P;
import tw.gov.npa.il.report.data.il04b01.Builder08B04P;
import tw.gov.npa.il.report.data.il04b01.Builder08B05P;
import tw.gov.npa.il.report.data.il04b01.Builder08B06P;
import tw.gov.npa.il.report.data.il04b01.Builder08B07P;

public class IL04B01ReportData {
  private static final Logger logger = Logger.getLogger(IL04B01ReportData.class);
  
  public static JRBeanCollectionDataSource buildDataSourceIL08B01P(String whereCondition) {
    return Builder08B01P.build(whereCondition);
  }
  
  public static JRBeanCollectionDataSource buildDataSourceIL08B02P(String whereCondition) {
    return Builder08B02P.build(whereCondition);
  }
  
  public static JRBeanCollectionDataSource buildDataSourceIL08B03P(String whereCondition) {
    return Builder08B03P.build(whereCondition);
  }
  
  public static JRBeanCollectionDataSource buildDataSourceIL08B04P(String whereCondition) {
    return Builder08B04P.build(whereCondition);
  }
  
  public static JRBeanCollectionDataSource buildDataSourceIL08B05P(String whereCondition) {
    return Builder08B05P.build(whereCondition);
  }
  
  public static JRBeanCollectionDataSource buildDataSourceIL08B06P(String whereCondition) {
    return Builder08B06P.build(whereCondition);
  }
  
  public static JRBeanCollectionDataSource buildDataSourceIL08B07P(String whereCondition) {
    return Builder08B07P.build(whereCondition);
  }
  
  public static void main(String[] args) throws JRException {
    buildDataSourceIL08B01P("");
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\report\data\IL04B01ReportData.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */