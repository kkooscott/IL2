package tw.gov.npa.il.myDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import tw.gov.npa.il.entity.IL07C;

public class IL07CDao {
	private static final Logger logger = Logger.getLogger(IL07CDao.class);

	private SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	private Date current = new Date();

	private DataSource dataSource;

	public String queryData(String s) {
		JdbcTemplate queryd = new JdbcTemplate(this.dataSource);
		if (queryd.queryForInt("SELECT COUNT(*) FROM ILTB_17_SCHOOL_CODE WHERE IL_UVCD='" + s + "'") == 0)
			return "0";
		return "1";
	}

	public Boolean insertData(String s1, String s2, String s3, String s4, String s5, String s6) {
		try {
			JdbcTemplate insertd = new JdbcTemplate(this.dataSource);
			StringBuilder sb = new StringBuilder();
			sb.append(
					"INSERT INTO ILTB_17_SCHOOL_CODE(IL_UVCD, IL_UVCNM, IL_UVCPNM, IL_UVPZONE, IL_UVADDR, IL_UVTEL, IL_LMD)VALUES(?,?,?,?,?,?,?)");
			Object[] params = new Object[7];
			params[0] = s1;
			params[1] = s2;
			params[2] = s3;
			params[3] = s4;
			params[4] = s5;
			params[5] = s6;
			params[6] = this.df.format(this.current);
			insertd.update(sb.toString(), params);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Boolean updateData(String s1, String s2, String s3, String s4, String s5, String s6) {
		try {
			JdbcTemplate updated = new JdbcTemplate(this.dataSource);
			StringBuilder sb = new StringBuilder();
			sb.append(
					"UPDATE ILTB_17_SCHOOL_CODE SET IL_UVCNM=?, IL_UVCPNM=?, IL_UVPZONE=?, IL_UVADDR=?, IL_UVTEL=?, IL_LMD=? WHERE IL_UVCD=?");
			Object[] params = new Object[7];
			params[0] = s2;
			params[1] = s3;
			params[2] = s4;
			params[3] = s5;
			params[4] = s6;
			params[5] = this.df.format(this.current);
			params[6] = s1;
			updated.update(sb.toString(), params);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Boolean deleteData(String s) {
		try {
			JdbcTemplate deleted = new JdbcTemplate(this.dataSource);
			deleted.update("DELETE FROM ILTB_17_SCHOOL_CODE WHERE IL_UVCD = '" + s + "'");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<IL07C> viewData(String s1, String s2) {
		JdbcTemplate view = new JdbcTemplate(this.dataSource);
		final List<IL07C> queryList = new ArrayList<IL07C>();
		view.query("SELECT * FROM ILTB_17_SCHOOL_CODE where IL_UVCD>='" + s1 + "' and IL_UVCD<='" + s2
				+ "' ORDER BY IL_UVCD", new RowCallbackHandler() {
					int id;

					int flag;

					public void processRow(ResultSet rs) throws SQLException {
						this.flag = 0;
						for (char c : rs.getString("IL_UVCD").toCharArray()) {
							if (!Character.isDigit(c))
								this.flag = 1;
						}
						if (this.flag == 0) {
							this.id = Integer.valueOf(rs.getString("IL_UVCD")).intValue();
						} else {
							this.id = 1;
						}
						IL07C il07C = new IL07C();
						il07C.setUVCD(rs.getString("IL_UVCD"));
						il07C.setUVCNM(rs.getString("IL_UVCNM"));
						il07C.setUVCPNM(rs.getString("IL_UVCPNM"));
						il07C.setUVPZONE(rs.getString("IL_UVPZONE"));
						il07C.setUVADDR(rs.getString("IL_UVADDR"));
						il07C.setUVTEL(rs.getString("IL_UVTEL"));
						il07C.setLMD(rs.getTimestamp("IL_LMD"));
						queryList.add(il07C);
					}
				});
		return queryList;
	}

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\myDao\IL07CDao.class
 * Java compiler version: 5 (49.0) JD-Core Version: 1.1.3
 */