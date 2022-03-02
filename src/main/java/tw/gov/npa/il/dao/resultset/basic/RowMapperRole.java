package tw.gov.npa.il.dao.resultset.basic;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import tw.gov.npa.il.entity.basic.TbRole;

public class RowMapperRole implements RowMapper<TbRole> {
  public TbRole mapRow(ResultSet resultSet, int i) throws SQLException {
    RsExtractorRole extractor = new RsExtractorRole();
    return extractor.extractData(resultSet);
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\resultset\basic\RowMapperRole.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */