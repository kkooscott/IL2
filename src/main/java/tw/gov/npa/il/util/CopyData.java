package tw.gov.npa.il.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CopyData {
	// static ResourceBundle rb = ResourceBundle.getBundle("db");

	public static void main(String[] args) {

//		long start = Long.parseLong(args[0]);
//		long end = Long.parseLong(args[1]);
		long start = 0;
		long end = 0;
//		String url = rb.getString("connstr").toString();
//		String user = rb.getString("user").toString();
//		String password = rb.getString("pwd").toString();

//		String url = "jdbc:sybase:Tds:10.0.2.15:4100/IL2DB?charset=utf8";
//		String user = "sa";
//		String password = "";
		
		String url = setString(args[0]);
		String user = setString(args[1]);
		String password = setString(args[2]);
		
		long i = 0;
		long success = 0;
		long failed = 0;
		long total = 0;
		int result;
		String oldArcno = null;
		System.out.println(url);
		System.out.println(user);
		System.out.println(password);

		try {
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("SELECT top 1 IL_12ARCID from ILTB_01_MAIN " + "ORDER BY IL_12ARCID");

			if (rs.next()) {
				start = rs.getLong("IL_12ARCID");
			}
			System.out.println("String : " + start);
			rs = st.executeQuery("SELECT top 1 IL_12ARCID from ILTB_01_MAIN " + "ORDER BY IL_12ARCID DESC");

			if (rs.next()) {
				end = rs.getLong("IL_12ARCID");
			}
			System.out.println("End : " + end);
			for (i = start; i <= end; i++) {
				rs = st.executeQuery("SELECT TOP 1 IL_12ARCID,IL_OLDARCNO from ILTB_01_MAIN " + "WHERE IL_12ARCID >= "
						+ i + "ORDER BY IL_12ARCID");

				if (rs.next()) {
					i = rs.getLong("IL_12ARCID");
					oldArcno = rs.getString("IL_OLDARCNO");

					if(oldArcno == null) {
						result = st.executeUpdate("UPDATE IL2DB.dbo.ILTB_01_MAIN " + 
								"SET IL_OLDARCNO = IL_ARCNO , IL_OLDAPYDT = IL_APYDT " + 
								"where IL_12ARCID = " + i);
						if(result == 0) {
							System.out.println("Update Error: " + i);
							failed++;
						} else {
							success++;
						}
					}
				}
				total++;
			}
			System.out.println(total + " / " + success + " / " + failed);
		} catch (SQLException ex) {
			System.out.println(i + "//" + oldArcno);
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String setString(String str) {
		return str==null?"":str;
	}

}
