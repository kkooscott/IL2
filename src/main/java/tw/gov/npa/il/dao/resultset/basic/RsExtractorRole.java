package tw.gov.npa.il.dao.resultset.basic;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import tw.gov.npa.il.entity.basic.TbRole;

public class RsExtractorRole implements ResultSetExtractor<TbRole> {
  public TbRole extractData(ResultSet rs) throws SQLException, DataAccessException {
    TbRole entity = new TbRole();
    entity.setRoleNo(rs.getInt("IL_ROLE_NO"));
    entity.setRole(rs.getString("IL_ROLE"));
    entity.setRoleNm(rs.getString("IL_ROLE_NM"));
    entity.setModified(rs.getTimestamp("IL_MODIFIED"));
    entity.setModuid(rs.getString("IL_MODUID"));
    return entity;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\resultset\basic\RsExtractorRole.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */