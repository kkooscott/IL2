package tw.gov.npa.il.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class TestConnectDB {


        public static void main(String[] args) {
            String url = "jdbc:sybase:Tds:172.16.220.77:5000/IL2DB";
            String username = "sa";
            String password = "syscom#1";

            try {
                Class.forName("com.sybase.jdbc4.jdbc.SybDriver"); // 驅動類
                Connection connection = DriverManager.getConnection(url, username, password);
                System.out.println("連接成功！");
                connection.close();
            } catch (Exception e) {
                System.out.println("找不到驅動類: " + e.getMessage());
            }
        }



}
