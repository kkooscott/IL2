package tw.gov.npa.il.dao.resultset.basic;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import tw.gov.npa.il.entity.basic.TbSystemFlowStepConfig;

public class RsExtractorSysFlowStepCtrl implements ResultSetExtractor<TbSystemFlowStepConfig> {
  public TbSystemFlowStepConfig extractData(ResultSet rs) throws SQLException, DataAccessException {
    TbSystemFlowStepConfig entity = new TbSystemFlowStepConfig();
    entity.setStepid(Integer.valueOf(rs.getInt("IL_STEPID")));
    entity.setStepname(rs.getString("IL_STEPNAME"));
    entity.setIndexid(rs.getString("IL_INDEXID"));
    entity.setStepurl(rs.getString("IL_STEPURL"));
    entity.setFunctag(rs.getString("IL_FUNCTAG"));
    entity.setLoadtitle(rs.getString("IL_LOADTITLE"));
    entity.setFunc(rs.getString("IL_FUNC"));
    entity.setFuncdisable(rs.getString("IL_FUNC_DISABLE"));
    entity.setModified(rs.getTimestamp("IL_MODIFIED"));
    entity.setModuid(rs.getString("IL_MODUID"));
    return entity;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\resultset\basic\RsExtractorSysFlowStepCtrl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */