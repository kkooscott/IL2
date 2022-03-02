package tw.gov.npa.il.dao.resultset.basic;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import tw.gov.npa.il.entity.basic.TbSystemFlowStepConfig;

public class RowMapperSysFlowStepCtrl implements RowMapper<TbSystemFlowStepConfig> {
  public TbSystemFlowStepConfig mapRow(ResultSet resultSet, int i) throws SQLException {
    RsExtractorSysFlowStepCtrl extractor = new RsExtractorSysFlowStepCtrl();
    return extractor.extractData(resultSet);
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\resultset\basic\RowMapperSysFlowStepCtrl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */