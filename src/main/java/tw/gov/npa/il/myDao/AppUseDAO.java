package tw.gov.npa.il.myDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

public class AppUseDAO {
	private static final Logger logger = Logger.getLogger(AppUseDAO.class);

	private JdbcTemplate jdbcTemplate;

	public Map<String, String> findMainUse() {
		logger.info("find main use");
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT E0_USECODE as code, E0_USENAME as name                        \n");
		sb.append("FROM ABDB..E0DT_APPUSE                \n");
		sb.append("WHERE E0_USECODE LIKE '%00'     \n");
		sb.append("ORDER BY E0_USECODE             \n");
		final Map<String, String> map = new LinkedHashMap<String, String>();
		this.jdbcTemplate.query(sb.toString(), new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				map.put(rs.getString("code"), rs.getString("name"));
			}
		});
		return map;
	}

	public Map<String, String> findDetailUse(String code) {
		logger.info("find detail use");
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT E0_USECODE as code, E0_USENAME as name             \n");
		sb.append("FROM ABDB..E0DT_APPUSE                                          \n");
		sb.append("WHERE substring(E0_USECODE,1,1) = substring(?,1,1)        \n");
		sb.append("and E0_USECODE != ?                                       \n");
		Object[] params = { code, code };
		System.out.println("SQL=" + sb.toString());
		logger.info("SQL:" + sb.toString());
		logger.info("params:" + code);
		final Map<String, String> map = new LinkedHashMap<String, String>();
		this.jdbcTemplate.query(sb.toString(), params, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				map.put(rs.getString("name"), rs.getString("name"));
			}
		});
		return map;
	}

	public JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\myDao\AppUseDAO.class
 * Java compiler version: 5 (49.0) JD-Core Version: 1.1.3
 */