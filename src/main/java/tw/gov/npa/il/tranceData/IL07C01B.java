package tw.gov.npa.il.tranceData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;
import tw.gov.npa.il.dao.Iltb18DataProcessResult;
import tw.gov.npa.il.dao.Iltb22IaRecord;
import tw.gov.npa.il.e0db.myDao.RelationDAO;
import tw.gov.npa.il.myDao.IL07C01BDao;

public class IL07C01B {
  private StringBuffer IMPFL = new StringBuffer("IL72");
  
  private int h_nImpTot = 0;
  
  private int h_nImpOK = 0;
  
  private int h_nImpErr1 = 0;
  
  private int h_nImpErr2 = 0;
  
  private int h_nImpErr3 = 0;
  
  private int h_nImpErr4 = 0;
  
  private int h_nImpErr5 = 0;
  
  private int h_nImpErr6 = 0;
  
  private int h_nImpErr7 = 0;
  
  private int h_nImpErr8 = 0;
  
  private int h_nImpErr9 = 0;
  
  private int h_nImpErr10 = 0;
  
  private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
  
  private SimpleDateFormat sdf3 = new SimpleDateFormat("MMM dd yyyy hh:mmaa", 
      Locale.ENGLISH);
  
  private SimpleDateFormat sdf4 = new SimpleDateFormat("hhmmss", 
      Locale.ENGLISH);
  
  private String user;
  
  private String fileName;
  
  private Date processDate;
  
  public IL07C01BDao il07C01BDao;
  
  private ArrayList<String> logList = new ArrayList<String>();
  
  private ArrayList<String> logList2 = new ArrayList<String>();
  
  private static final Logger logger = Logger.getLogger(IL07C01B.class);
  
  private File file;
  
//  ResourceBundle rb = ResourceBundle.getBundle("config");
  
//  private String contextPath = this.rb.getString("FileRoot").toString();
private String contextPath = "D:\\IL2\\file";

  private RelationDAO relationDAO;
  
  public RelationDAO getRelationDAO() {
    return this.relationDAO;
  }
  
  public void setRelationDAO(RelationDAO relationDAO) {
    this.relationDAO = relationDAO;
  }
  
  public IL07C01BDao getIl07C01BDao() {
    return this.il07C01BDao;
  }
  
  public void setIl07C01BDao(IL07C01BDao il07c01bDao) {
    this.il07C01BDao = il07c01bDao;
  }
  
  public String fillSpace(String value, int length) {
    for (int i = value.length(); i <= length; i++)
      value = String.valueOf(value) + " "; 
    return value;
  }
  
  public int readFile() {
    logger.info(this.file.getPath());
    if (this.file.exists()) {
      try {
        BufferedReader in = new BufferedReader(new InputStreamReader(
              new FileInputStream(this.file.getPath()), "ISO-8859-1"));
        int count = 0;
        String last_id = "null";
        while (in.ready()) {
          try {
            this.h_nImpTot++;
            Iltb22IaRecord iltb22IaRecord = new Iltb22IaRecord();
            String str = in.readLine();
            logger.info(Integer.valueOf(str.length()));
            if (str.length() == 330) {
              iltb22IaRecord.setIlArcid(
                  Integer.valueOf(Integer.parseInt(convertValue(str, 0, 7))));
              iltb22IaRecord
                .setIlPtrldt(Timestamp.valueOf(this.sdf
                    .format(this.sdf3.parse(convertValue(
                          str, 7, 26)))));
              iltb22IaRecord
                .setIlPtrlst(convertValue(str, 26, 27));
              iltb22IaRecord.setIlPtrlmrk(convertValue(str, 27, 
                    282));
              iltb22IaRecord
                .setIlUid(convertValue(str, 282, 290));
              iltb22IaRecord
                .setIlUnm(convertValue(str, 290, 307));
              iltb22IaRecord.setIlLmd(Timestamp.valueOf(this.sdf
                    .format(this.sdf3.parse(convertValue(str, 307, 
                          329)))));
              if (!convertValue(str, 329, 330).equals("")) {
                iltb22IaRecord.setIlMantype(convertValue(str, 
                      329, 330));
              } else {
                iltb22IaRecord.setIlMantype("0");
              } 
              if (this.il07C01BDao.queryData(str.substring(0, 7)
                  .trim())) {
                int control = 0;
                try {
                  if (!last_id.equals(str.substring(0, 7))) {
                    control = 2;
                    this.il07C01BDao.deleteData(str.substring(0, 
                          7));
                    last_id = str.substring(0, 7);
                  } 
                  control = 3;
                  this.il07C01BDao.insertData(iltb22IaRecord);
                  this.h_nImpOK++;
                } catch (Exception e) {
                  if (control == 3) {
                    this.h_nImpErr3++;
                    logger.info("寫檔失敗");
                    this.logList.add(str);
                    this.logList2.add(String.valueOf(fillSpace(
                            Integer.toString(this.h_nImpTot), 5)) + 
                        "3");
                  } else if (control == 2) {
                    this.h_nImpErr2++;
                    logger.info("刪檔失敗");
                    this.logList.add(str);
                    this.logList2.add(String.valueOf(fillSpace(
                            Integer.toString(this.h_nImpTot), 5)) + 
                        "2");
                  } 
                  e.printStackTrace();
                } 
                continue;
              } 
              this.h_nImpErr1++;
              logger.info("LTB01居留主檔無相關資料");
              this.logList.add(str);
              this.logList2.add(String.valueOf(fillSpace(
                      Integer.toString(this.h_nImpTot), 5)) + 
                  "1");
              continue;
            } 
            if (str.length() == 341) {
              logger.info("新格式轉入");
              iltb22IaRecord
                .setIlPtrldt(Timestamp.valueOf(this.sdf
                    .format(this.sdf3.parse(convertValue(
                          str, 7, 26)))));
              iltb22IaRecord
                .setIlPtrlst(convertValue(str, 26, 27));
              iltb22IaRecord.setIlPtrlmrk(convertValue(str, 27, 
                    282));
              iltb22IaRecord
                .setIlUid(convertValue(str, 282, 290));
              iltb22IaRecord
                .setIlUnm(convertValue(str, 290, 307));
              iltb22IaRecord.setIlLmd(Timestamp.valueOf(this.sdf
                    .format(this.sdf3.parse(convertValue(str, 307, 
                          329)))));
              if (!convertValue(str, 329, 330).equals("")) {
                iltb22IaRecord.setIlMantype(convertValue(str, 
                      329, 330));
              } else {
                iltb22IaRecord.setIlMantype("0");
              } 
              if (!convertValue(str, 0, 7).equals(""))
                iltb22IaRecord.setIlArcid(
                    Integer.valueOf(Integer.parseInt(convertValue(str, 0, 7)))); 
              long newId = 0L;
              int control = 0;
              newId = 
                Long.parseLong(convertValue(str, 329, 341));
              if (this.il07C01BDao.queryData(str.substring(0, 7)
                  .trim())) {
                try {
                  if (!last_id.equals(str.substring(0, 7))) {
                    control = 2;
                    this.il07C01BDao.deleteData(str.substring(0, 
                          7));
                    last_id = str.substring(0, 7);
                  } 
                  control = 3;
                  this.il07C01BDao.insertData(iltb22IaRecord);
                  this.h_nImpOK++;
                } catch (Exception e) {
                  if (control == 3) {
                    this.h_nImpErr3++;
                    logger.info("寫檔失敗");
                    this.logList.add(str);
                    this.logList2.add(String.valueOf(fillSpace(
                            Integer.toString(this.h_nImpTot), 5)) + 
                        "3");
                  } else if (control == 2) {
                    this.h_nImpErr2++;
                    logger.info("刪檔失敗");
                    this.logList.add(str);
                    this.logList2.add(String.valueOf(fillSpace(
                            Integer.toString(this.h_nImpTot), 5)) + 
                        "2");
                  } 
                  e.printStackTrace();
                } 
                continue;
              } 
              if (this.il07C01BDao.queryDataBy12ArcId(newId)) {
                iltb22IaRecord.setIlArcid(Integer.valueOf(this.il07C01BDao.queryoldIdBy12ArcId(newId)));
                try {
                  if (!last_id.equals(iltb22IaRecord.getIlArcid())) {
                    control = 2;
                    this.il07C01BDao.deleteData(iltb22IaRecord.getIlArcid().toString());
                    last_id = iltb22IaRecord.getIlArcid().toString();
                  } 
                  control = 3;
                  this.il07C01BDao.insertData(iltb22IaRecord);
                  this.h_nImpOK++;
                } catch (Exception e) {
                  if (control == 3) {
                    this.h_nImpErr3++;
                    logger.info("寫檔失敗");
                    this.logList.add(str);
                    this.logList2.add(String.valueOf(fillSpace(
                            Integer.toString(this.h_nImpTot), 5)) + 
                        "3");
                  } else if (control == 2) {
                    this.h_nImpErr2++;
                    logger.info("刪檔失敗");
                    this.logList.add(str);
                    this.logList2.add(String.valueOf(fillSpace(
                            Integer.toString(this.h_nImpTot), 5)) + 
                        "2");
                  } 
                  e.printStackTrace();
                } 
                continue;
              } 
              this.h_nImpErr1++;
              logger.info("LTB01居留主檔無相關資料");
              this.logList.add(str);
              this.logList2.add(String.valueOf(fillSpace(
                      Integer.toString(this.h_nImpTot), 5)) + 
                  "1");
              continue;
            } 
            logger.info("長度不符");
            this.h_nImpErr4++;
            this.logList.add(str);
            this.logList2.add(String.valueOf(fillSpace(
                    Integer.toString(this.h_nImpTot), 5)) + 
                "4");
          } catch (Exception e) {
            logger.info("資料轉換失敗");
            e.printStackTrace();
          } 
        } 
      } catch (Exception e) {
        logger.info("讀檔失敗");
      } 
    } else {
      return 0;
    } 
    return 1;
  }
  
  private String dateConvert(String convertNumber, String type) {
    int value = Integer.parseInt(convertNumber);
    if (value < 10)
      return Integer.toString(value); 
    if (type.equals("year"))
      return convertNumber.substring(2, 4); 
    if (type.equals("month")) {
      switch (value) {
        case 10:
          return "A";
        case 11:
          return "B";
        case 12:
          return "C";
      } 
      return null;
    } 
    if (type.equals("day")) {
      switch (value) {
        case 10:
          return "A";
        case 11:
          return "B";
        case 12:
          return "C";
        case 13:
          return "D";
        case 14:
          return "E";
        case 15:
          return "F";
        case 16:
          return "G";
        case 17:
          return "H";
        case 18:
          return "I";
        case 19:
          return "J";
        case 20:
          return "K";
        case 21:
          return "L";
        case 22:
          return "M";
        case 23:
          return "N";
        case 24:
          return "O";
        case 25:
          return "P";
        case 26:
          return "Q";
        case 27:
          return "R";
        case 28:
          return "S";
        case 29:
          return "T";
        case 30:
          return "U";
        case 31:
          return "V";
      } 
      return null;
    } 
    return null;
  }
  
  private void writeLog(int sucess) {
    String headerValue = "NO.  ERRTP   ARCID  PTRLDT              PTRLST PTRLMRK                                                                                                                                                                                                         UID         UNM                          LMD                  MANTYPE              \n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
    String computValue = "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\nERRTP1:  " + 
      
      this.h_nImpErr1 + 
      "\n" + 
      "ERRTP2:  " + 
      this.h_nImpErr2 + 
      "\n" + 
      "ERRTP3:  " + 
      this.h_nImpErr3 + 
      "\n" + 
      "ERRTP4:  " + 
      this.h_nImpErr4 + 
      "\n" + 
      "ImpOK :  " + 
      this.h_nImpOK + "\n" + "ImpTot:  " + this.h_nImpTot + "\n";
    File pathFile = new File(this.contextPath);
    if (!pathFile.exists())
      pathFile.mkdirs(); 
    try {
      BufferedWriter bw = new BufferedWriter(new FileWriter(String.valueOf(this.contextPath) + "\\" + 
            this.fileName.trim().replace(".txt", "") + "_" + 
            this.sdf4.format(this.processDate) + "_" + this.user.trim() + ".err"));
      bw.write(headerValue);
      for (int i = 0; i < this.logList.size(); i++) {
        if (((String)this.logList.get(i)).length() != 330 || ((String)this.logList.get(i)).length() != 341) {
          bw.write(fillSpace(
                convertValue(this.logList2.get(i), 0, (
                  (String)this.logList2.get(i)).length() - 1).trim(), 4));
          bw.write(fillSpace("4", 4));
          bw.write(new String(((String)this.logList.get(i)).getBytes("ISO-8859-1"), 
                "Big5"));
        } else {
          bw.write(fillSpace(
                convertValue(this.logList2.get(i), 0, (
                  (String)this.logList2.get(i)).length() - 1).trim(), 4));
          bw.write(fillSpace(
                convertValue(this.logList2.get(i), (
                  (String)this.logList2.get(i)).length() - 1, (
                  (String)this.logList2.get(i)).length()).trim(), 4));
          bw.write(this.logList.get(i));
        } 
        bw.newLine();
      } 
      bw.write(computValue);
      if (sucess == 0)
        bw.write("\n 檔案不存在!"); 
      bw.close();
      File logFile = new File(String.valueOf(this.contextPath) + "\\" + 
          this.fileName.trim().replace(".txt", "") + "_" + 
          this.sdf4.format(this.processDate) + "_" + this.user.trim() + ".txt");
      BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream(logFile), "big5"));
      for (int j = 0; j < this.logList.size(); j++) {
        bw2.write(new String(((String)this.logList.get(j)).getBytes("ISO-8859-1"), 
              "Big5"));
        bw2.newLine();
      } 
      if (sucess == 0)
        bw2.write("\n 檔案不存在!"); 
      bw2.close();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  private String convertValue(String data, int start, int end) {
    try {
      String convertValue = new String(data.substring(start, end).getBytes(
            "ISO-8859-1"), "Big5");
      return convertValue.trim();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
      return null;
    } 
  }
  
  public void il07C01bMain(int control, String fileName) {
    if (control == 0) {
      Calendar cal = Calendar.getInstance();
      cal.setTime(new Date());
      cal.add(5, -1);
      SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
      String autoDate = sdf2.format(cal.getTime());
      try {
        if (this.il07C01BDao.queryCountbyKey(autoDate, "4") == 0)
          try {
            this.processDate = this.il07C01BDao.insertLog("System", fileName);
          } catch (ParseException e) {
            logger.info("檔名轉換異常");
          }  
      } catch (ParseException e) {
        e.printStackTrace();
      } 
    } 
    ArrayList<Iltb18DataProcessResult> jobList = searchJob();
    if (jobList.size() > 0)
      for (int i = 0; i < jobList.size(); i++)
        startJob(((Iltb18DataProcessResult)jobList.get(i)).getIlImpuid(), ((Iltb18DataProcessResult)jobList.get(i)).getId()
            .getIlImptp(), ((Iltb18DataProcessResult)jobList.get(i)).getId().getIlImpdt(), (
            (Iltb18DataProcessResult)jobList.get(i)).getIlImpfl());  
    logger.info("查察記事轉入 執行結束 執行次數:" + jobList.size());
  }
  
  private void startJob(String user, String type, Timestamp impdt, String filename) {
    this.h_nImpTot = 0;
    this.h_nImpOK = 0;
    this.h_nImpErr1 = 0;
    this.h_nImpErr2 = 0;
    this.h_nImpErr3 = 0;
    this.h_nImpErr4 = 0;
    this.h_nImpErr5 = 0;
    this.h_nImpErr6 = 0;
    this.h_nImpErr7 = 0;
    this.h_nImpErr8 = 0;
    this.h_nImpErr9 = 0;
    this.h_nImpErr10 = 0;
    int sucess = 0;
    this.user = user;
    this.logList.clear();
    SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
    String date = df.format(impdt);
    this.processDate = impdt;
    this.user = user;
    try {
      this.il07C01BDao.updateLog(impdt, "2", this.h_nImpTot, this.h_nImpOK, this.h_nImpErr1, 
          this.h_nImpErr2, this.h_nImpErr3, this.h_nImpErr4, this.h_nImpErr5, this.h_nImpErr6, 
          this.h_nImpErr7);
      this.fileName = filename.trim();
      this.file = new File(String.valueOf(this.contextPath) + "\\" + this.fileName);
      sucess = readFile();
    } catch (Exception e) {
      this.il07C01BDao.updateLog(impdt, "3", this.h_nImpTot, this.h_nImpOK, this.h_nImpErr1, 
          this.h_nImpErr2, this.h_nImpErr3, this.h_nImpErr4, this.h_nImpErr5, this.h_nImpErr6, 
          this.h_nImpErr7);
    } 
    if (sucess == 1) {
      this.il07C01BDao.updateLog(impdt, "1", this.h_nImpTot, this.h_nImpOK, this.h_nImpErr1, 
          this.h_nImpErr2, this.h_nImpErr3, this.h_nImpErr4, this.h_nImpErr5, this.h_nImpErr6, 
          this.h_nImpErr7);
      writeLog(1);
    } else if (sucess == 0) {
      this.il07C01BDao.updateLog(impdt, "3", this.h_nImpTot, this.h_nImpOK, this.h_nImpErr1, 
          this.h_nImpErr2, this.h_nImpErr3, this.h_nImpErr4, this.h_nImpErr5, this.h_nImpErr6, 
          this.h_nImpErr7);
      writeLog(0);
    } 
  }
  
  private ArrayList<Iltb18DataProcessResult> searchJob() {
    return this.il07C01BDao.queryByStatus("0");
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\tranceData\IL07C01B.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */