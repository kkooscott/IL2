package tw.gov.npa.il.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ResourceBundle;

public class UploadFile {
//  ResourceBundle rb = ResourceBundle.getBundle("config");
  
//  private String savePath = this.rb.getString("FileRoot").toString();
  private String savePath = "D\\:\\IL2\\file\\";

  public void upFile(File upFile, String fileName) {
    try {
      File saveFile = new File(String.valueOf(this.savePath) + "\\" + fileName);
      InputStream in = new FileInputStream(upFile);
      OutputStream out = new FileOutputStream(saveFile);
      byte[] buf = new byte[1024];
      int len;
      while ((len = in.read(buf)) > 0)
        out.write(buf, 0, len); 
      in.close();
      out.close();
      System.out.println("File copied.");
    } catch (FileNotFoundException ex) {
      System.out.println(String.valueOf(ex.getMessage()) + " in the specified directory.");
      System.exit(0);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\i\\util\UploadFile.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */