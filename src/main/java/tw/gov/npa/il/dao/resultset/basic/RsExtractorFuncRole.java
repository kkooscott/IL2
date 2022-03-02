package tw.gov.npa.il.dao.resultset.basic;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import tw.gov.npa.il.entity.basic.TbFuncRole;

public class RsExtractorFuncRole implements ResultSetExtractor<TbFuncRole> {
  public TbFuncRole extractData(ResultSet rs) throws SQLException, DataAccessException {
    TbFuncRole entity = new TbFuncRole();
    entity.setFuncRoleNo(rs.getInt("IL_FUNC_ROLE_NO"));
    entity.setFuncNo(rs.getInt("IL_FUNC_NO"));
    entity.setFunc(rs.getString("IL_FUNC"));
    entity.setFuncNm(rs.getString("IL_FUNC_NM"));
    entity.setRoleNo(rs.getInt("IL_ROLE_NO"));
    entity.setRole(rs.getString("IL_ROLE"));
    entity.setRoleNm(rs.getString("IL_ROLE_NM"));
    entity.setEnable(rs.getString("IL_ENABLE"));
    entity.setModified(rs.getTimestamp("IL_MODIFIED"));
    entity.setModuid(rs.getString("IL_MODUID"));
    return entity;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\resultset\basic\RsExtractorFuncRole.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */