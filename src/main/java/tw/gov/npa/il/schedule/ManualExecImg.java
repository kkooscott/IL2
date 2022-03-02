package tw.gov.npa.il.schedule;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.CommonDataSource;
import javax.sql.DataSource;
import java.util.*;
import java.io.*;
import tw.gov.npa.il.myDao.MyIlScheduleDAO;
public class ManualExecImg{
	public ManualExecImg(){
		
	}
	
	public static void main(String[] args){
		System.out.println("manualexecimg");
		ILReportSchedule scheduler=new ILReportSchedule();
		
		
		
		
		//08
		
		scheduler.myIlScheduleDAO=new MyIlScheduleDAO();
		scheduler.myIlScheduleDAO.dataSource=new JdbcDataSourceImpl();
		
		scheduler.iL08A01=new tw.gov.npa.il.tranceData.IL08A01();
		scheduler.iL08A01.iL08A01=new tw.gov.npa.il.myDao.IL08A01DAO();
		scheduler.iL08A01.iL08A01.dataSource=new JdbcDataSourceImpl();
		scheduler.iL08A01.dataSource=new JdbcDataSourceImpl();
		
		
		 
		
		scheduler.runIL08();
		
		
	}
}


class JdbcDataSourceImpl implements DataSource {
        
		@Override
		public Logger getParentLogger() throws SQLFeatureNotSupportedException{
			return Logger.getLogger("JdbcDataSourceImpl");
		}
	
        @Override
        public Connection getConnection() throws SQLException {
        	
	        Properties prop = new Properties();
	        
	        try{
	        
	            FileInputStream  in = new FileInputStream("db.properties");
	            prop.load(in);
	            in.close();
	        }catch(Exception e){
	        	System.out.println("error");
	        }

        	
        	
                //if (connection != null) {
                        //System.out.println("Cant craete a Connection");
                        
                //} else {
                        
                //}
                Connection connection = null;
				connection = DriverManager.getConnection(prop.getProperty("connstr"), prop.getProperty("user"), prop.getProperty("pwd"));
                return connection;
        }

        @Override
        public Connection getConnection(String username, String password) throws SQLException {
        	
        	
        	Properties prop = new Properties();
	        
	        try{
	        
	            FileInputStream  in = new FileInputStream("db.properties");
	            prop.load(in);
	            in.close();
	        }catch(Exception e){
	        	System.out.println("error");
	        }
	        
	        
        	
                // TODO Auto-generated method stub
                //if (connection != null) {
                //        System.out.println("Cant craete a Connection");
                //} else {
						Connection connection = null;
                        connection = DriverManager.getConnection(prop.getProperty("connstr"), username,password);
                //}
                return connection;
        }

        @Override
        public PrintWriter getLogWriter() throws SQLException {
                // TODO Auto-generated method stub
                PrintWriter logWriter = null;
                try {
                        logWriter = new PrintWriter("Logfile.log");
                } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                return logWriter;
        }

        @Override
        public int getLoginTimeout() throws SQLException {
                // TODO Auto-generated method stub
                return 0;
        }

        @Override
        public void setLogWriter(PrintWriter out) throws SQLException {
                // TODO Auto-generated method stub
                try {
                        DriverManager.setLogWriter(new PrintWriter(
                                        "C:/work/vinay/Logfile.log"));
                } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
        }

        @Override
        public void setLoginTimeout(int seconds) throws SQLException {
                // TODO Auto-generated method stub
        }

        @Override
        public boolean isWrapperFor(Class<?> iface) throws SQLException {
                // TODO Auto-generated method stub
                return false;
        }

        @Override
        public <T> T unwrap(Class<T> iface) throws SQLException {
                // TODO Auto-generated method stub
                return null;
        }

        public static void main(String[] args) throws SQLException {
                JdbcDataSourceImpl ds = new JdbcDataSourceImpl();
                Connection connection = ds.getConnection();
                PrintWriter out = DriverManager.getLogWriter();
                ds.setLogWriter(out);
                PrintWriter res = ds.getLogWriter();
                System.out.println(res.toString());
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM student");
                while (rs.next()) {
                        System.out.println("Roll No-" + rs.getInt(1) + ", Name- "+ rs.getString(2));
                }
                ds.setLoginTimeout(5);
        }
}