package tw.gov.npa.il.dao.resultset.basic;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class RowMapperAnn implements RowMapper {
  public Object mapRow(ResultSet resultSet, int i) throws SQLException {
    RsExtractorAnn extractor = new RsExtractorAnn();
    return extractor.extractData(resultSet);
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\resultset\basic\RowMapperAnn.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */