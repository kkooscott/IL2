package tw.gov.npa.il.myDao;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

public class IL07C01CDao {
	private static final Logger logger = Logger.getLogger(IL07C01CDao.class);

	private DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public boolean updateData(String oldArcno, String Arcno, String birth) {

		try {
			JdbcTemplate updated = new JdbcTemplate(this.dataSource);

			Object[] params = new Object[3];
			params[0] = Arcno;
			params[1] = oldArcno;
			params[2] = birth;

			updated.update("UPDATE ILTB_01_MAIN SET IL_ARCNO=? WHERE IL_ARCNO=? AND IL_BTHDT=?", params);

			updated.update("UPDATE ILTB_01_MAIN_IDX SET IL_ARCNO=? WHERE IL_ARCNO=? AND IL_BTHDT=?", params);
			
			return true;
		} catch (Exception e) {
			logger.error(e.getStackTrace());
			return false;
		}
	}
}
