package tw.gov.npa.il.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import org.apache.log4j.Logger;
import sun.net.TelnetInputStream;
import sun.net.TelnetOutputStream;
import sun.net.ftp.FtpClient;

public class FtpGetFile {
  private static final Logger logger = Logger.getLogger(FtpGetFile.class);
  
  private byte[] bt;
  
  private TelnetInputStream getfile;
  
  private TelnetOutputStream putfile;
  
  private String str;
  
  private FtpClient ftp;
//
//  public void getLink(String ip, String user, String password) throws Exception {
//    this.ftp = new FtpClient(ip);
//    this.str = this.ftp.getResponseString();
//    System.out.println(this.str);
//    this.ftp.login(user, password);
//    this.str = this.ftp.getResponseString();
//    System.out.println(this.str);
//  }
//
//  public boolean getFile(String ip, String user, String password, String fileName, String path, String savePath) {
//    try {
//      logger.info("1");
//      getLink(ip, user, password);
//      TelnetInputStream in = this.ftp.list();
//      logger.info("2");
//      this.str = this.ftp.getResponseString();
//      logger.info(this.str);
//      logger.info("3");
//      this.bt = new byte[in.available()];
//      in.read(this.bt);
//      this.str = new String(this.bt);
//      logger.info("4");
//      if (path != null)
//        this.ftp.cd(path);
//      this.str = this.ftp.getResponseString();
//      in = this.ftp.list();
//      logger.info("5");
//      this.str = this.ftp.getResponseString();
//      this.bt = new byte[in.available()];
//      in.read(this.bt);
//      logger.info("6");
//      this.str = new String(this.bt);
//      this.str = this.ftp.getResponseString();
//      logger.info("開始下載文件:" + fileName);
//      this.getfile = this.ftp.get(fileName);
//      this.str = this.ftp.getResponseString();
//      this.str = this.ftp.getResponseString();
//      InputStreamReader xieli = new InputStreamReader(this.getfile);
//      BufferedReader b = new BufferedReader(xieli);
//      BufferedWriter writer = new BufferedWriter(new FileWriter(new File(savePath + "\\" + fileName)));
//      int line = 0;
//      while (true) {
//        line++;
//        if (line % 1000 == 0)
//          logger.info(line + "已讀取");
//        String s = b.readLine();
//        if (s == null)
//          break;
//        writer.write(s);
//        writer.flush();
//        writer.newLine();
//      }
//      writer.close();
//      xieli.close();
//      b.close();
//      this.getfile.close();
//      logger.info("下載完畢，共" + line + "筆");
//      this.ftp.sendServer("DELE " + fileName + "\r\n");
//      this.str = this.ftp.getResponseString();
//      getLink(ip, user, password);
//      this.ftp.cd("IL\\bak");
//      FileInputStream bakin = new FileInputStream(savePath + "\\" + fileName);
//      OutputStream out = this.ftp.put(fileName);
//      byte[] buffer = new byte[1024];
//      while (true) {
//        int bytes = bakin.read(buffer);
//        if (bytes < 0)
//          break;
//        out.write(buffer, 0, bytes);
//      }
//      out.close();
//      in.close();
//      this.ftp.closeServer();
//      return true;
//    } catch (Exception e) {
//      e.printStackTrace();
//      logger.info(e.getMessage());
//      logger.info("Ftp link Fail!");
//      return false;
//    }
//  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\i\\util\FtpGetFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */