package tw.gov.npa.il.dao.resultset.basic;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import tw.gov.npa.il.entity.basic.TbAnnounce;

public class RsExtractorAnn implements ResultSetExtractor<TbAnnounce> {
  public TbAnnounce extractData(ResultSet resultSet) throws SQLException, DataAccessException {
    TbAnnounce entity = new TbAnnounce();
    entity.setNo(resultSet.getInt("IL_ANN_NO"));
    entity.setKind(resultSet.getString("IL_KIND"));
    entity.setContent(resultSet.getString("IL_CONTENT"));
    entity.setBeginDate(resultSet.getString("IL_BEGIN_DT"));
    entity.setBeginTime(resultSet.getString("IL_BEGIN_TM"));
    entity.setEndDate(resultSet.getString("IL_END_DT"));
    entity.setEndTime(resultSet.getString("IL_END_TM"));
    entity.setUid(resultSet.getString("IL_ANN_UID"));
    entity.setuName(resultSet.getString("IL_ANN_UNM"));
    entity.setSettingDate(resultSet.getString("IL_ANN_DT"));
    entity.setSettingTime(resultSet.getString("IL_ANN_TM"));
    entity.setModified(resultSet.getTimestamp("IL_MODIFIED"));
    return entity;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\resultset\basic\RsExtractorAnn.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */