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
import tw.gov.npa.il.entity.IL07B;

public class IL07BDao {
	private static final Logger logger = Logger.getLogger(IL07BDao.class);

	private SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	private Date current = new Date();

	private DataSource dataSource;

	public String queryData(String s) {
		JdbcTemplate queryd = new JdbcTemplate(this.dataSource);
		if (queryd.queryForInt("SELECT COUNT(*) FROM ILTB_16_JOB_CODE WHERE IL_OPCD='" + s + "'") == 0)
			return "0";
		return "1";
	}

	public Boolean insertData(String s1, String s2, String s3, String s4) {
		try {
			JdbcTemplate insertd = new JdbcTemplate(this.dataSource);
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO ILTB_16_JOB_CODE(IL_OPCD, IL_OPNM, IL_OPPRSQ, IL_OPCS, IL_LMD)VALUES(?,?,?,?,?)");
			Object[] params = new Object[5];
			params[0] = s1;
			params[1] = s2;
			params[2] = Integer.valueOf(s3);
			params[3] = s4;
			params[4] = this.df.format(this.current);
			insertd.update(sb.toString(), params);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Boolean updateData(String s1, String s2, String s3, String s4) {
		try {
			JdbcTemplate updated = new JdbcTemplate(this.dataSource);
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE ILTB_16_JOB_CODE SET IL_OPNM=?, IL_OPPRSQ=?, IL_OPCS=?, IL_LMD=? WHERE IL_OPCD=?");
			Object[] params = new Object[5];
			params[0] = s2;
			params[1] = Integer.valueOf(s3);
			params[2] = s4;
			params[3] = this.df.format(this.current);
			params[4] = s1;
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
			deleted.update("DELETE FROM ILTB_16_JOB_CODE WHERE IL_OPCD = '" + s + "'");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<IL07B> viewData(String s1, String s2) {
		JdbcTemplate view = new JdbcTemplate(this.dataSource);
		final List<IL07B> queryList = new ArrayList<IL07B>();
		view.query("SELECT * FROM ILTB_16_JOB_CODE ORDER BY IL_OPCD", new RowCallbackHandler() {
			int n1 = Integer.valueOf(s1);
			int n2 = Integer.valueOf(s2);
			int id;

			public void processRow(ResultSet rs) throws SQLException {
				this.id = Integer.valueOf(rs.getString("IL_OPCD")).intValue();
				if (this.id >= this.n1 && this.id <= this.n2) {
					IL07B il07B = new IL07B();
					il07B.setOPCD(rs.getString("IL_OPCD"));
					il07B.setOPNM(rs.getString("IL_OPNM"));
					il07B.setOPPRSQ(rs.getInt("IL_OPPRSQ"));
					il07B.setOPCS(rs.getString("IL_OPCS"));
					il07B.setLMD(rs.getTimestamp("IL_LMD"));
					queryList.add(il07B);
				}
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
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\myDao\IL07BDao.class
 * Java compiler version: 5 (49.0) JD-Core Version: 1.1.3
 */