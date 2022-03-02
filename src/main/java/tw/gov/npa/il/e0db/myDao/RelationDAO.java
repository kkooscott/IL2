package tw.gov.npa.il.e0db.myDao;

import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class RelationDAO {
  private static final Logger logger = Logger.getLogger(RelationDAO.class);
  
  public DataSource dataSource;
  
  public DataSource getDataSource() {
    return this.dataSource;
  }
  
  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }
  
  public int queryByNewId(long newId) {
    JdbcTemplate query = new JdbcTemplate(this.dataSource);
    int oldId = 0;
    String sql = "SELECT IL_OLDID FROM IL2_RELATION WHERE IL_NEWID=" + newId;
    try {
      oldId = query.queryForInt(sql);
    } catch (EmptyResultDataAccessException e) {
      oldId = 0;
    } 
    return oldId;
  }
  
  public long queryByOldId(int oldId) {
    JdbcTemplate query = new JdbcTemplate(this.dataSource);
    String sql = "SELECT IL_NEWID FROM IL2_RELATION WHERE IL_OLDID=" + oldId;
    long newId = 0L;
    try {
      newId = query.queryForLong(sql);
    } catch (EmptyResultDataAccessException e) {
      newId = 0L;
    } 
    return newId;
  }
  
  public void insert(long newId, int oldId) {
    JdbcTemplate insert = new JdbcTemplate(this.dataSource);
    String sql = "INSERT INTO IL2_RELATION VALUES(" + newId + "," + oldId + ")";
    insert.update(sql);
  }
  
  public int getSeq() {
    JdbcTemplate query = new JdbcTemplate(this.dataSource);
    int count = query.queryForInt("SELECT IL_SEQ FROM IL2_IDSEQ ");
    query.update("UPDATE IL2_IDSEQ SET IL_SEQ=" + (count + 1));
    return count + 1;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\e0db\myDao\RelationDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */