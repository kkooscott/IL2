package tw.gov.npa.il.dao.resultset.basic;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import tw.gov.npa.il.entity.basic.TbFuncRole;

public class RowMapperFuncRole implements RowMapper<TbFuncRole> {
  public TbFuncRole mapRow(ResultSet resultSet, int i) throws SQLException {
    RsExtractorFuncRole extractor = new RsExtractorFuncRole();
    return extractor.extractData(resultSet);
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\resultset\basic\RowMapperFuncRole.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */