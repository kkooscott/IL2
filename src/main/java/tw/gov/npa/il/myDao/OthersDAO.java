package tw.gov.npa.il.myDao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import tw.gov.npa.il.dao.BaseHibernateDAO;
import tw.gov.npa.il.dao.HibernateSessionFactory;

public class OthersDAO extends BaseHibernateDAO {

	private static final Logger logger = Logger.getLogger(OthersDAO.class);

	private DataSource dataSource;

	private String queryResult;

	public void tryToCloseSession() {
		try {
			HibernateSessionFactory.getSession().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String queryCodeDetail(String ilFnddid) {
		JdbcTemplate queryd = new JdbcTemplate(this.dataSource);
		Object[] params = new Object[1];
		params[0] = ilFnddid;
		queryResult = ilFnddid;

		queryd.query("select * from ILTB_CODEDETAIL where IL_CKIND  ='QP' and IL_CID = ?", params,
				new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						if (rs.getNString(2).equals(ilFnddid)) {
							queryResult = ilFnddid + rs.getString(3);
						}
					}
				});

		return queryResult;
	}

	public String queryIlRemrk(int ilArcid) {
		JdbcTemplate queryd = new JdbcTemplate(this.dataSource);
		Object[] params = new Object[1];
		params[0] = ilArcid;
		queryResult = ilArcid + "";

		queryd.query("select * from ILTB_01_MAIN WHERE IL_ARCID = ?", params, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				queryResult = rs.getString("IL_REMRK");
			}
		});

		return queryResult;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
