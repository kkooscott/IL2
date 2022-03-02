package tw.gov.npa.il.myDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import tw.gov.npa.il.action.bean.IL03A01Q07Bean;

public class IL03ADao {
  private static final Logger logger = Logger.getLogger(IL03ADao.class);
  
  private DataSource dataSource;
  
  public List<IL03A01Q07Bean> viewData(int ilArcid) {
    JdbcTemplate view = new JdbcTemplate(this.dataSource);
    final List<IL03A01Q07Bean> queryList = new ArrayList<IL03A01Q07Bean>();
    StringBuffer sqlStr = new StringBuffer();
    sqlStr.append("SELECT * FROM ILTB_22_IA_RECORD");
    sqlStr.append(" WHERE IL_ARCID = " + ilArcid);
    sqlStr.append(" ORDER BY IL_PTRLDT DESC");
    view.query(sqlStr.toString(), 
        new RowCallbackHandler() {
          public void processRow(ResultSet rs) throws SQLException {
            IL03A01Q07Bean il03A01Q07Bean = new IL03A01Q07Bean();
            il03A01Q07Bean.setIlPtrldt(rs.getTimestamp("IL_PTRLDT"));
            il03A01Q07Bean.setIlPtrlmrk(rs.getString("IL_PTRLMRK"));
            il03A01Q07Bean.setIlPtrlst(rs.getString("IL_PTRLST"));
            il03A01Q07Bean.setIlUnm(rs.getString("IL_UNM"));
            queryList.add(il03A01Q07Bean);
          }
        });
    return queryList;
  }
  
  public DataSource getDataSource() {
    return this.dataSource;
  }
  
  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\myDao\IL03ADao.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */