package tw.gov.npa.il.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.StringTokenizer;
import org.hibernate.SQLQuery;
import tw.gov.npa.il.action.bean.Menu;
import tw.gov.npa.il.dao.HibernateSessionFactory;
import tw.gov.npa.il.dao.IltbSystemFlowStepConfig;

public class MiscMain {
	static String SQL_TABLE = "IL_SYSTEM_FLOW_STEP_CONFIG";

	public static List<Menu> getMenuList(boolean bByLevel, List<String> sByTitleId) {
		List<String> allList = new ArrayList();
		List<Menu> rootList = new ArrayList();
		StringBuffer sqlStrBuffer = new StringBuffer();
		String sqlStr = "";
		sqlStrBuffer.append("SELECT a.* FROM ILTB_SYSTEM_FLOW_STEP_CONFIG a, ILTB_FUNC_ROLE b");
		sqlStrBuffer.append(" WHERE a.IL_FUNC_DISABLE='1'");
		sqlStrBuffer.append(" AND a.IL_STEPID = b.IL_FUNC_NO");
		sqlStrBuffer.append(" AND (b.IL_ROLE = '" + sByTitleId.get(0) + "'");
		for (int i = 1; i < sByTitleId.size(); i++)
			sqlStrBuffer.append(" OR b.IL_ROLE = '" + sByTitleId.get(i) + "'");
		sqlStrBuffer.append(") AND b.IL_ENABLE = '1'");
		sqlStrBuffer.append(" GROUP BY a.IL_STEPID");
		sqlStrBuffer.append(" ORDER BY a.IL_INDEXID");
		sqlStr = sqlStrBuffer.toString();
		System.out.println("LOAD_TITLE sqlStr=" + sqlStr);
		List<IltbSystemFlowStepConfig> systemRoleServicelist = new ArrayList<IltbSystemFlowStepConfig>();
		try {
			SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr);
			q.addEntity(IltbSystemFlowStepConfig.class);
			systemRoleServicelist = q.list();
		} catch (Exception em) {
			em.printStackTrace();
		} finally {
			HibernateSessionFactory.getSession().close();
		}
		Hashtable<Object, Object> menuHT = new Hashtable<Object, Object>();
		try {
			for (int j = 0; j < systemRoleServicelist.size(); j++) {
				Menu menu = fetchMenu(systemRoleServicelist.get(j));
				menuHT.put(menu.getIndex(), menu);
				allList.add(menu.getIndex());
				if (menu.getLevel() == 1)
					rootList.add(menu);
			}
			if (!bByLevel) {
				ArrayList allList2 = new ArrayList();
				for (int k = 0; k < allList.size(); k++)
					allList2.add(menuHT.get(allList.get(k)));
				return allList2;
			}
			while (!allList.isEmpty()) {
				String mindex = allList.remove(0);
				Menu m = (Menu) menuHT.get(mindex);
				if (m.getLevel() != 1) {
					String parentId = m.getParentId();
					if (menuHT.containsKey(parentId)) {
						Menu parent = (Menu) menuHT.get(parentId);
						parent.addChild(m);
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rootList;
	}

	public static Menu fetchMenu(IltbSystemFlowStepConfig list) throws SQLException {
		Menu data = new Menu();
		data.setStepId(list.getIlStepid().toString());
		data.setStepName(list.getIlStepname().toString());
		data.setIndex(list.getIlIndexid().toString());
		data.setUrl(list.getIlStepurl().toString());
		String s = data.getIndex();
		StringTokenizer a = new StringTokenizer(s, ".");
		int level = 0;
		int seq = 0;
		String temp = "";
		String parentId = "";
		while (a.hasMoreTokens()) {
			level++;
			temp = a.nextToken();
		}
		if (level != 1) {
			parentId = s.substring(0, s.lastIndexOf("."));
		} else {
			parentId = "ROOT";
		}
		data.setLevel(level);
		data.setSeq(seq);
		data.setParentId(parentId);
		return data;
	}

	private static void close(Connection conn) {
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException sQLException) {
			}
	}
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\i\\util\MiscMain.class
 * Java compiler version: 5 (49.0) JD-Core Version: 1.1.3
 */