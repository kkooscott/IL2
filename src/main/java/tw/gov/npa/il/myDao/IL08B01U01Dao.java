package tw.gov.npa.il.myDao;

import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import tw.gov.npa.il.entity.IL08A02;

public class IL08B01U01Dao {
  private DataSource dataSource;
  
  public static final String TYPE_1 = "1";
  
  public static final String TYPE_2 = "2";
  
  public static final String STATUS_1 = "1";
  
  public static final String STATUS_2 = "2";
  
  public static final String STATUS_3 = "3";
  
  public static final String STATUS_4 = "4";
  
  public static final String STATUS_5 = "5";
  
  public static final ImmutableMap<String, String> typeMap = (new ImmutableMap.Builder())
    .put("1", "影像資料匯入作業")
    .build();
  
  public static final ImmutableMap<String, String> statusMap = (new ImmutableMap.Builder())
    .put("1", "未完成")
    .put("2", "處理中")
    .put("3", "已完成")
    .put("4", "異常")
    .put("5", "已停止")
    .build();
  
  private static List<IL08A02> cv08A02List = new ArrayList<IL08A02>();
  
  static {
    IL08A02 cv08A02_1 = new IL08A02();
    cv08A02_1.setId(1);
    cv08A02_1.setType("1");
    cv08A02_1.setsTime(new Date());
    cv08A02_1.seteTime(new Date());
    cv08A02_1.setStatus("2");
    cv08A02List.add(cv08A02_1);
    IL08A02 cv08A02_2 = new IL08A02();
    cv08A02_2.setId(2);
    cv08A02_2.setType("1");
    cv08A02_2.setsTime(new Date());
    cv08A02_2.seteTime(new Date());
    cv08A02_2.setStatus("3");
    cv08A02List.add(cv08A02_2);
    IL08A02 cv08A02_3 = new IL08A02();
    cv08A02_3.setId(3);
    cv08A02_3.setType("1");
    cv08A02_3.setsTime(new Date());
    cv08A02_3.seteTime(new Date());
    cv08A02_3.setStatus("3");
    cv08A02List.add(cv08A02_3);
    IL08A02 cv08A02_4 = new IL08A02();
    cv08A02_4.setId(4);
    cv08A02_4.setType("1");
    cv08A02_4.setsTime(new Date());
    cv08A02_3.seteTime(new Date());
    cv08A02_4.setStatus("3");
    cv08A02List.add(cv08A02_4);
    IL08A02 cv08A02_5 = new IL08A02();
    cv08A02_5.setId(5);
    cv08A02_5.setType("1");
    cv08A02_5.setsTime(new Date());
    cv08A02_5.setStatus("1");
    cv08A02List.add(cv08A02_5);
    IL08A02 cv08A02_6 = new IL08A02();
    cv08A02_6.setId(6);
    cv08A02_6.setType("1");
    cv08A02_6.setsTime(new Date());
    cv08A02_6.setStatus("2");
    cv08A02List.add(cv08A02_6);
  }
  
  public List<IL08A02> find(IL08A02 cv08A02) {
    System.out.println("cv08A02List.size()=" + cv08A02List.size());
    return cv08A02List;
  }
  
  public DataSource getDataSource() {
    return this.dataSource;
  }
  
  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\myDao\IL08B01U01Dao.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */