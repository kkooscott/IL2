package tw.gov.npa.il.e0db.myDao;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import tw.gov.npa.il.dao.resultset.basic.RowMapperFuncRole;
import tw.gov.npa.il.dao.resultset.basic.RowMapperRole;
import tw.gov.npa.il.dao.resultset.basic.RowMapperSysFlowStepCtrl;
import tw.gov.npa.il.entity.basic.TbFuncRole;
import tw.gov.npa.il.entity.basic.TbRole;
import tw.gov.npa.il.entity.basic.TbSystemFlowStepConfig;

public class CW08ADAO {
  private static Logger logger = Logger.getLogger(CW08ADAO.class);
  
  private DataSource dataSource;
  
  public List<TbSystemFlowStepConfig> findAllSysFlowStepConfig() {
    JdbcTemplate db = new JdbcTemplate(this.dataSource);
    StringBuffer sql = new StringBuffer();
    sql.append("SELECT");
    sql.append(" IL_STEPID, IL_STEPNAME, IL_INDEXID,");
    sql.append(" IL_STEPURL, IL_FUNCTAG, IL_LOADTITLE,");
    sql.append(" IL_FUNC, IL_FUNC_DISABLE, IL_MODIFIED,");
    sql.append(" IL_MODUID");
    sql.append(" FROM ILTB_SYSTEM_FLOW_STEP_CONFIG");
    return db.query(sql.toString(), (RowMapper)new RowMapperSysFlowStepCtrl());
  }
  
  public List<TbRole> findAllRole() {
    JdbcTemplate db = new JdbcTemplate(this.dataSource);
    StringBuffer sql = new StringBuffer();
    sql.append("SELECT");
    sql.append(" IL_ROLE_NO, IL_ROLE, IL_ROLE_NM,");
    sql.append(" IL_MODIFIED, IL_MODUID");
    sql.append(" FROM ILTB_ROLE");
    return db.query(sql.toString(), (RowMapper)new RowMapperRole());
  }
  
  public List<TbFuncRole> findAllFuncRole() {
    JdbcTemplate db = new JdbcTemplate(this.dataSource);
    StringBuffer sql = new StringBuffer();
    sql.append("SELECT");
    sql.append(" IL_FUNC_ROLE_NO, IL_FUNC_NO, IL_FUNC,");
    sql.append(" IL_FUNC_NM, IL_ROLE_NO, IL_ROLE,");
    sql.append(" IL_ROLE_NM, IL_ENABLE, IL_MODIFIED,");
    sql.append(" IL_MODUID");
    sql.append(" FROM ILTB_FUNC_ROLE");
    return db.query(sql.toString(), (RowMapper)new RowMapperFuncRole());
  }
  
  public List<TbFuncRole> searchFuncRoleByFuncNo(int stepid) {
    JdbcTemplate db = new JdbcTemplate(this.dataSource);
    StringBuffer sql = new StringBuffer();
    sql.append("SELECT");
    sql.append(" IL_FUNC_ROLE_NO, IL_FUNC_NO, IL_FUNC,");
    sql.append(" IL_FUNC_NM, IL_ROLE_NO, IL_ROLE,");
    sql.append(" IL_ROLE_NM, IL_ENABLE, IL_MODIFIED,");
    sql.append(" IL_MODUID");
    sql.append(" FROM ILTB_FUNC_ROLE");
    sql.append(" WHERE IL_FUNC_NO = ? ");
    logger.info(sql.toString());
    logger.info("IL_FUNC_NO=" + stepid);
    Object[] args = { Integer.valueOf(stepid) };
    return db.query(sql.toString(), args, (RowMapper)new RowMapperFuncRole());
  }
  
  public TbFuncRole findFuncRoleById(int id) {
    List<TbFuncRole> rv = new ArrayList<TbFuncRole>();
    JdbcTemplate db = new JdbcTemplate(this.dataSource);
    StringBuffer sql = new StringBuffer();
    sql.append("SELECT");
    sql.append(" IL_FUNC_ROLE_NO, IL_FUNC_NO, IL_FUNC,");
    sql.append(" IL_FUNC_NM, IL_ROLE_NO, IL_ROLE,");
    sql.append(" IL_ROLE_NM, IL_ENABLE, IL_MODIFIED,");
    sql.append(" IL_MODUID");
    sql.append(" FROM ILTB_FUNC_ROLE");
    sql.append(" WHERE IL_FUNC_ROLE_NO = ? ");
    logger.info(sql.toString());
    logger.info("IL_FUNC_ROLE_NO=" + id);
    Object[] args = { Integer.valueOf(id) };
    rv = db.query(sql.toString(), args, (RowMapper)new RowMapperFuncRole());
    return rv.get(0);
  }
  
  public int updateTbFuncRole(TbFuncRole update) {
    int rv = 0;
    JdbcTemplate db = new JdbcTemplate(this.dataSource);
    StringBuffer sql = new StringBuffer();
    sql.append("UPDATE ILTB_FUNC_ROLE");
    sql.append(" SET IL_FUNC_ROLE_NO = ?, IL_FUNC_NO = ?,");
    sql.append(" IL_FUNC = ?, IL_FUNC_NM = ?,");
    sql.append(" IL_ROLE_NO = ?, IL_ROLE = ?,");
    sql.append(" IL_ROLE_NM = ?, IL_ENABLE = ?,");
    sql.append(" IL_MODIFIED = getdate(), IL_MODUID = ?");
    sql.append(" FROM ILTB_FUNC_ROLE");
    sql.append(" WHERE IL_FUNC_ROLE_NO = ? ");
    logger.info(sql.toString());
    logger.info(Integer.valueOf(update.getFuncRoleNo()));
    logger.info(Integer.valueOf(update.getFuncNo()));
    logger.info(update.getFunc());
    logger.info(update.getFuncNm());
    logger.info(Integer.valueOf(update.getRoleNo()));
    logger.info(update.getRole());
    logger.info(update.getRoleNm());
    logger.info(update.getEnable());
    logger.info(update.getModuid());
    logger.info(Integer.valueOf(update.getFuncRoleNo()));
    Object[] args = { Integer.valueOf(update.getFuncRoleNo()), Integer.valueOf(update.getFuncNo()), update.getFunc(), update.getFuncNm(), Integer.valueOf(update.getRoleNo()), update.getRole(), update.getRoleNm(), update.getEnable(), update.getModuid(), Integer.valueOf(update.getFuncRoleNo()) };
    return db.update(sql.toString(), args);
  }
  
  public DataSource getDataSource() {
    return this.dataSource;
  }
  
  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\e0db\myDao\CW08ADAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */