package tw.gov.npa.il.myDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import tw.gov.npa.il.dao.BaseHibernateDAO;
import tw.gov.npa.il.dao.HibernateSessionFactory;
import tw.gov.npa.il.dao.IltbAnnounce;
import tw.gov.npa.il.entity.IL07D;

public class IL07DDao extends BaseHibernateDAO {

	private static final Logger logger = Logger.getLogger(IL07DDao.class);

	private SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	private Date current = new Date();

	private DataSource dataSource;

	public void tryToCloseSession() {
		try {
			HibernateSessionFactory.getSession().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String queryData(String s) {
		JdbcTemplate queryd = new JdbcTemplate(this.dataSource);
		if (queryd.queryForInt("SELECT COUNT(*) FROM ILTB_SRCHST_CODE WHERE IL_SRCHST='" + s + "'") == 0)
			return "0";
		return "1";
	}

	public Boolean insertData(String s1, String s2) {
		try {
			JdbcTemplate insertd = new JdbcTemplate(this.dataSource);
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO ILTB_SRCHST_CODE(IL_SRCHST, IL_SRCHSTNM)VALUES(?,?)");
			Object[] params = new Object[2];
			params[0] = s1;
			params[1] = s2;
			insertd.update(sb.toString(), params);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public Boolean updateData(String s1, String s2) {
		try {
			JdbcTemplate updated = new JdbcTemplate(this.dataSource);
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE ILTB_SRCHST_CODE SET IL_SRCHST=?, IL_SRCHSTNM=? WHERE IL_SRCHST=?");
			Object[] params = new Object[3];
			params[0] = s1;
			params[1] = s2;
			params[2] = s1;
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
			deleted.update("DELETE FROM ILTB_SRCHST_CODE WHERE IL_SRCHST = '" + s + "'");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<IL07D> viewData(String s1, String s2) {
		JdbcTemplate view = new JdbcTemplate(this.dataSource);
		final List<IL07D> queryList = new ArrayList<IL07D>();
		view.query("SELECT * FROM ILTB_SRCHST_CODE where IL_SRCHST>='" + s1 + "' and IL_SRCHST<='" + s2
				+ "' ORDER BY IL_SRCHST", new RowCallbackHandler() {
					int id;

					int flag;

					public void processRow(ResultSet rs) throws SQLException {
						this.flag = 0;
						for (char c : rs.getString("IL_SRCHST").toCharArray()) {
							if (!Character.isDigit(c))
								this.flag = 1;
						}
						if (this.flag == 0) {
							this.id = Integer.valueOf(rs.getString("IL_SRCHST")).intValue();
						} else {
							this.id = 1;
						}
						IL07D il07D = new IL07D();
						il07D.setSRCHST(rs.getString("IL_SRCHST"));
						il07D.setSRCHSTNM(rs.getString("IL_SRCHSTNM"));
						queryList.add(il07D);
					}
				});
		return queryList;
	}

	public List<IL07D> findAll() {
		List<IL07D> list = new ArrayList<IL07D>();
		Map map = null;
		JdbcTemplate queryd = new JdbcTemplate(this.dataSource);
		queryd.query("SELECT * FROM ILTB_SRCHST_CODE", new RowCallbackHandler() {
			int id;

			int flag;

			public void processRow(ResultSet rs) throws SQLException {
				this.flag = 0;
				for (char c : rs.getString("IL_SRCHST").toCharArray()) {
					if (!Character.isDigit(c))
						this.flag = 1;
				}
				if (this.flag == 0) {
					this.id = Integer.valueOf(rs.getString("IL_SRCHST")).intValue();
				} else {
					this.id = 1;
				}
				IL07D il07D = new IL07D();
				il07D.setSRCHST(rs.getString("IL_SRCHST"));
				il07D.setSRCHSTNM(rs.getString("IL_SRCHSTNM"));
				list.add(il07D);
			}
		});
		return list;
	}

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
