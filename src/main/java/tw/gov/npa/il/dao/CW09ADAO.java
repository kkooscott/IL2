package tw.gov.npa.il.dao;

import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import tw.gov.npa.il.dao.resultset.basic.RowMapperAnn;
import tw.gov.npa.il.entity.basic.TbAnnounce;

public class CW09ADAO {
  private static Logger logger = Logger.getLogger(CW09ADAO.class);
  
  private DataSource dataSource;
  
  public List<TbAnnounce> find(String kind) {
    logger.debug("Enter find");
    JdbcTemplate db = new JdbcTemplate(this.dataSource);
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT IL_ANN_NO, IL_KIND, IL_CONTENT, IL_BEGIN_DT, IL_BEGIN_TM, ");
    sb.append("IL_END_DT, IL_END_TM, IL_ANN_UID, IL_ANN_UNM, IL_ANN_DT, IL_ANN_TM, IL_MODIFIED ");
    sb.append("FROM ILTB_ANNOUNCE ");
    sb.append("WHERE IL_KIND = ? ");
    sb.append("AND IL_BEGIN_DT <= getDate() AND IL_END_DT >= getDate()");
    sb.append("ORDER BY IL_ANN_NO");
    Date date = new Date();
    Object[] objs = { kind };
    logger.info("SQL:" + sb.toString());
    logger.info("Params:" + ToStringBuilder.reflectionToString(objs));
    return db.query(sb.toString(), objs, (RowMapper)new RowMapperAnn());
  }
  
  public DataSource getDataSource() {
    return this.dataSource;
  }
  
  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\CW09ADAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */