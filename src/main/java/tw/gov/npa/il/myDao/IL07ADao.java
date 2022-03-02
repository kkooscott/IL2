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
import tw.gov.npa.il.entity.IL07A;

public class IL07ADao {
	private static final Logger logger = Logger.getLogger(IL07ADao.class);

	private SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	private Date current = new Date();

	private DataSource dataSource;

	public String queryData(String s) {
		JdbcTemplate queryd = new JdbcTemplate(this.dataSource);
		if (queryd.queryForInt("SELECT COUNT(*) FROM ILTB_15_COUNTRY_CODE WHERE IL_NTCD='" + s + "'") == 0)
			return "0";
		return "1";
	}

	public Boolean insertData(String s1, String s2, String s3) {
		try {
			JdbcTemplate insertd = new JdbcTemplate(this.dataSource);
			StringBuilder sb = new StringBuilder();
			sb.append(
					"INSERT INTO ILTB_15_COUNTRY_CODE(IL_NTCD, IL_NTNM, IL_NTLBR, IL_NTPRSQ, IL_NTDTS, IL_NTDTE, IL_LMD)VALUES(?,?,?,?,?,?,?)");
			Object[] params = new Object[7];
			params[0] = s1;
			params[1] = s2;
			params[2] = s3;
			params[3] = Integer.valueOf(findNTPRSQ(s1));
			params[4] = "";
			params[5] = "";
			params[6] = this.df.format(this.current);
			insertd.update(sb.toString(), params);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Boolean updateData(String s1, String s2, String s3) {
		try {
			JdbcTemplate updated = new JdbcTemplate(this.dataSource);
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE ILTB_15_COUNTRY_CODE SET IL_NTNM=?, IL_NTLBR=?, IL_NTPRSQ=?, IL_LMD=? WHERE IL_NTCD=?");
			Object[] params = new Object[5];
			params[0] = s2;
			params[1] = s3;
			params[2] = Integer.valueOf(findNTPRSQ(s1));
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
			deleted.update("DELETE FROM ILTB_15_COUNTRY_CODE WHERE IL_NTCD = '" + s + "'");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<IL07A> viewData(String s1, String s2) {
		JdbcTemplate view = new JdbcTemplate(this.dataSource);
		final List<IL07A> queryList = new ArrayList<IL07A>();
		view.query("SELECT * FROM ILTB_15_COUNTRY_CODE ORDER BY IL_NTCD", new RowCallbackHandler() {
			int n1 = Integer.valueOf(s1);
			int n2 = Integer.valueOf(s2);
			int id;

			public void processRow(ResultSet rs) throws SQLException {
				this.id = Integer.valueOf(rs.getString("IL_NTCD")).intValue();
				if (this.id >= this.n1 && this.id <= this.n2) {
					IL07A il07A = new IL07A();
					il07A.setNTCD(rs.getString("IL_NTCD"));
					il07A.setNTNM(rs.getString("IL_NTNM"));
					il07A.setNTLBR(rs.getString("IL_NTLBR"));
					il07A.setNTPRSQ(rs.getInt("IL_NTPRSQ"));
					il07A.setNTDTS(rs.getTimestamp("IL_NTDTS"));
					il07A.setNTDTE(rs.getTimestamp("IL_NTDTE"));
					il07A.setLMD(rs.getTimestamp("IL_LMD"));
					queryList.add(il07A);
				}
			}
		});
		return queryList;
	}

	public int findNTPRSQ(String s) {
		int id = Integer.valueOf(s).intValue();
		int val = 0;
		if (id == 24) {
			val = 1;
		} else if (id == 19) {
			val = 2;
		} else if (id == 9) {
			val = 3;
		} else if (id == 30) {
			val = 4;
		} else if (id == 34) {
			val = 5;
		} else if (id == 21) {
			val = 6;
		}
		return val;
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
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\myDao\IL07ADao.class
 * Java compiler version: 5 (49.0) JD-Core Version: 1.1.3
 */