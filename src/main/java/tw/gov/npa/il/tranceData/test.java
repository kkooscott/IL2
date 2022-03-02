package tw.gov.npa.il.tranceData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class test {
  public static void main(String[] args) {
    int i = 0;
    try {
      BufferedReader in = new BufferedReader(new InputStreamReader(
            new FileInputStream("c://VIC20131030.TXT"), "UTF-8"));
      BufferedWriter bw = new BufferedWriter(new FileWriter("c://aaa.txt"));
      int count = 0;
      int error = 0;
      while (in.ready()) {
        count++;
        String str = in.readLine();
        if (str.length() != 0) {
          if (str.substring(0, 1).equals("V")) {
            bw.write("\n" + str);
            error++;
            continue;
          } 
          bw.write(str);
        } 
      } 
      System.out.println(error);
      bw.close();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\tranceData\test.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */