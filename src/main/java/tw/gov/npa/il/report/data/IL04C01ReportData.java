package tw.gov.npa.il.report.data;

import java.util.List;
import net.sf.jasperreports.engine.JRException;
import org.apache.log4j.Logger;
import tw.gov.npa.il.report.data.il04c01.Builder08C01P;

public class IL04C01ReportData {
  private static final Logger logger = Logger.getLogger(IL04C01ReportData.class);
  
  public static List<String> buildDataSourceIL08C01P(String whereCondition, String show) {
    return Builder08C01P.build(whereCondition, show);
  }
  
  public static List<String> buildDataSourceIL08C01P_csv(String whereCondition, String show) {
    return Builder08C01P.build_csv(whereCondition, show);
  }
  
  public static void main(String[] args) throws JRException {
    buildDataSourceIL08C01P("", "");
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\report\data\IL04C01ReportData.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */