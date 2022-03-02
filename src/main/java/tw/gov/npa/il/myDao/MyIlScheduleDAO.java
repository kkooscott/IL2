package tw.gov.npa.il.myDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import tw.gov.npa.il.dao.IlScheduleMngId;

public class MyIlScheduleDAO {
	private static final Logger logger = Logger.getLogger(MyIlScheduleDAO.class);

	private SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	private Date current = new Date();

	public DataSource dataSource;

	private ArrayList<IlScheduleMngId> queryList = new ArrayList<IlScheduleMngId>();

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public List<IlScheduleMngId> queryByDate(String sDate, String eDate, String type) {
		this.queryList.clear();
		JdbcTemplate queryd = new JdbcTemplate(this.dataSource);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		Object[] params = new Object[3];
		try {
			params[0] = df.parse(sDate);
			params[1] = df.parse(eDate);
			params[2] = type;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		queryd.query(
				"SELECT id,sgroup,type,status,mUserName,mUnitId,sTime,eTime FROM IL_SCHEDULE_MNG WHERE sTime >=?  AND eTime=? AND type=?",
				params, new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						IlScheduleMngId ilScheduleMngId = new IlScheduleMngId();
						ilScheduleMngId.setId(Integer.valueOf(Integer.parseInt(rs.getString("id"))));
						ilScheduleMngId.setSgroup(rs.getString("sgroup"));
						ilScheduleMngId.setType(rs.getString("type"));
						ilScheduleMngId.setStatus(rs.getString("status"));
						if (rs.getString("sTime") != null)
							ilScheduleMngId.setStime(Timestamp.valueOf(rs.getString("sTime")));
						if (rs.getString("eTime") != null)
							ilScheduleMngId.setEtime(Timestamp.valueOf(rs.getString("eTime")));
						ilScheduleMngId.setMunitId(rs.getString("mUnitId"));
						ilScheduleMngId.setMuserName(rs.getString("mUserName"));
						MyIlScheduleDAO.this.queryList.add(ilScheduleMngId);
					}
				});
		return this.queryList;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(IlScheduleMngId ilScheduleMngId) {
		JdbcTemplate insertd = new JdbcTemplate(this.dataSource);
		Object[] params = new Object[6];
		params[0] = ilScheduleMngId.getSgroup();
		params[1] = ilScheduleMngId.getType();
		params[2] = ilScheduleMngId.getStatus();
		params[3] = ilScheduleMngId.getMuserName();
		params[4] = ilScheduleMngId.getMunitId();
		params[5] = new Date();
		insertd.update("INSERT INTO IL_SCHEDULE_MNG(sgroup,type,status,mUserName,mUnitId,sTime) VALUES(?,?,?,?,?,?)",
				params);
	}

	public void update(IlScheduleMngId ilScheduleMngId) {
		JdbcTemplate insertd = new JdbcTemplate(this.dataSource);
		Object[] params = new Object[8];
		params[0] = ilScheduleMngId.getSgroup();
		params[1] = ilScheduleMngId.getType();
		params[2] = ilScheduleMngId.getStatus();
		params[3] = ilScheduleMngId.getMuserName();
		params[4] = ilScheduleMngId.getMunitId();
		params[5] = ilScheduleMngId.getStime();
		params[6] = ilScheduleMngId.getEtime();
		params[7] = ilScheduleMngId.getId();
		insertd.update(
				"UPDATE IL_SCHEDULE_MNG SET sgroup=?,type=?,status=?,mUserName=?,mUnitId=?,sTime=?,eTime=? WHERE id=?",
				params);
	}

	public void updateStatus(int id, String status) {
		JdbcTemplate insertd = new JdbcTemplate(this.dataSource);
		if (status.equals("6")) {
			Object[] params = new Object[3];
			params[0] = status;
			params[1] = new Date();
			params[2] = Integer.valueOf(id);
			insertd.update("UPDATE IL_SCHEDULE_MNG SET status=?,eTime=? WHERE id=?", params);
		} else if (status.equals("0")) {
			Object[] params = new Object[2];
			params[0] = status;
			params[1] = Integer.valueOf(id);
			insertd.update("UPDATE IL_SCHEDULE_MNG SET status=?,eTime=null WHERE id=?", params);
		}
	}

	public ArrayList<IlScheduleMngId> queryByStatus(String status) {
		JdbcTemplate queryd = new JdbcTemplate(this.dataSource);
		this.queryList.clear();
		queryd.query("SELECT id,sgroup,type,status,mUserName,mUnitId,sTime,eTime FROM IL_SCHEDULE_MNG WHERE status='"
				+ status + "'", new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						IlScheduleMngId ilScheduleMngId = new IlScheduleMngId();
						ilScheduleMngId.setId(Integer.valueOf(Integer.parseInt(rs.getString("id"))));
						ilScheduleMngId.setSgroup(rs.getString("sgroup"));
						ilScheduleMngId.setType(rs.getString("type"));
						ilScheduleMngId.setStatus(rs.getString("status"));
						if (rs.getString("sTime") != null)
							ilScheduleMngId.setStime(Timestamp.valueOf(rs.getString("sTime")));
						if (rs.getString("eTime") != null)
							ilScheduleMngId.setEtime(Timestamp.valueOf(rs.getString("eTime")));
						ilScheduleMngId.setMunitId(rs.getString("mUnitId"));
						ilScheduleMngId.setMuserName(rs.getString("mUserName"));
						MyIlScheduleDAO.this.queryList.add(ilScheduleMngId);
					}
				});
		return this.queryList;
	}

	public ArrayList<IlScheduleMngId> queryByDate(String date1, String date2) {
		JdbcTemplate queryd = new JdbcTemplate(this.dataSource);
		this.queryList.clear();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Object[] params = new Object[2];
		try {
			params[0] = sdf.parseObject(date1);
			params[1] = sdf.parseObject(date2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		queryd.query(
				"SELECT id,sgroup,type,status,mUserName,mUnitId,sTime,eTime FROM IL_SCHEDULE_MNG WHERE sTime >= ? and sTime<= ?",
				new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						IlScheduleMngId ilScheduleMngId = new IlScheduleMngId();
						ilScheduleMngId.setId(Integer.valueOf(Integer.parseInt(rs.getString("id"))));
						ilScheduleMngId.setSgroup(rs.getString("sgroup"));
						ilScheduleMngId.setType(rs.getString("type"));
						ilScheduleMngId.setStatus(rs.getString("status"));
						if (rs.getString("sTime") != null)
							ilScheduleMngId.setStime(Timestamp.valueOf(rs.getString("sTime")));
						if (rs.getString("eTime") != null)
							ilScheduleMngId.setEtime(Timestamp.valueOf(rs.getString("eTime")));
						ilScheduleMngId.setMunitId(rs.getString("mUnitId"));
						ilScheduleMngId.setMuserName(rs.getString("mUserName"));
						MyIlScheduleDAO.this.queryList.add(ilScheduleMngId);
					}
				}, params);
		return this.queryList;
	}

	public List<IlScheduleMngId> queryById(String id) {
		JdbcTemplate queryd = new JdbcTemplate(this.dataSource);
		this.queryList.clear();
		queryd.query("SELECT id,sgroup,type,status,mUserName,mUnitId,sTime,eTime FROM IL_SCHEDULE_MNG WHERE id=" + id,
				new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						IlScheduleMngId ilScheduleMngId = new IlScheduleMngId();
						ilScheduleMngId.setId(Integer.valueOf(Integer.parseInt(rs.getString("id"))));
						ilScheduleMngId.setSgroup(rs.getString("sgroup"));
						ilScheduleMngId.setType(rs.getString("type"));
						ilScheduleMngId.setStatus(rs.getString("status"));
						if (rs.getString("sTime") != null)
							ilScheduleMngId.setStime(Timestamp.valueOf(rs.getString("sTime")));
						if (rs.getString("eTime") != null)
							ilScheduleMngId.setEtime(Timestamp.valueOf(rs.getString("eTime")));
						ilScheduleMngId.setMunitId(rs.getString("mUnitId"));
						ilScheduleMngId.setMuserName(rs.getString("mUserName"));
						MyIlScheduleDAO.this.queryList.add(ilScheduleMngId);
					}
				});
		return this.queryList;
	}
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\myDao\MyIlScheduleDAO
 * .class Java compiler version: 5 (49.0) JD-Core Version: 1.1.3
 */