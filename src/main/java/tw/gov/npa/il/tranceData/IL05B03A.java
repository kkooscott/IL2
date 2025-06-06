package tw.gov.npa.il.tranceData;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;
import tw.gov.npa.il.action.bean.IL05B03ABean;
import tw.gov.npa.il.dao.Iltb18DataProcessResult;
import tw.gov.npa.il.e0db.myDao.RelationDAO;
import tw.gov.npa.il.myDao.IL05B03ADao;

public class IL05B03A {
  private static final Logger logger = Logger.getLogger(IL05B03A.class);
  
  private List<IL05B03ABean> dataList = new ArrayList<IL05B03ABean>();
  
  private SimpleDateFormat sdf4 = new SimpleDateFormat("hhmmss", 
      Locale.ENGLISH);
  
  private String fileName;
  
  private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
  
  SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
  
  private SimpleDateFormat sdf3 = new SimpleDateFormat("MMM dd yyyy hh:mmaa", 
      Locale.ENGLISH);
  
  private Date processDate;
  
  private IL05B03ADao il05B03ADao;
  
  private int totalCount = 0;
  
  private int sucessCount = 0;
  
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
  
//  ResourceBundle rb = ResourceBundle.getBundle("config");
  
//  private String contextPath = this.rb.getString("FileRoot").toString();
private String contextPath = "D:\\IL2\\file";


  private String path = String.valueOf(this.contextPath) + "\\IL7A\\";
  
  private RelationDAO relationDAO;
  
  public RelationDAO getRelationDAO() {
    return this.relationDAO;
  }
  
  public void setRelationDAO(RelationDAO relationDAO) {
    this.relationDAO = relationDAO;
  }
  
  public IL05B03ADao getIl05B03ADao() {
    return this.il05B03ADao;
  }
  
  public void setIl05B03ADao(IL05B03ADao il05b03aDao) {
    this.il05B03ADao = il05b03aDao;
  }
  
  public void getArcId(Date date) {
    this.dataList = this.il05B03ADao.getList(date);
    this.totalCount = this.dataList.size();
  }
  
  public void IL05B03AMain() {
    ArrayList<Iltb18DataProcessResult> jobList = searchJob();
    if (jobList.size() > 0)
      for (int i = 0; i < jobList.size(); i++)
        startJob(((Iltb18DataProcessResult)jobList.get(i)).getIlImpuid(), ((Iltb18DataProcessResult)jobList.get(i)).getId().getIlImptp(), ((Iltb18DataProcessResult)jobList.get(i))
            .getId().getIlImpdt(), ((Iltb18DataProcessResult)jobList.get(i)).getIlImpfl());  
  }
  
  private ArrayList<Iltb18DataProcessResult> searchJob() {
    return this.il05B03ADao.queryByStatus("0");
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
    try {
      if (user.isEmpty() || user.equals(""))
        user = "System"; 
      String findDate = this.sdf2.format(impdt);
      this.processDate = impdt;
      try {
        this.il05B03ADao.updateLog(impdt, "2", this.h_nImpTot, this.h_nImpOK, 
            this.h_nImpErr1, this.h_nImpErr2, this.h_nImpErr3, this.h_nImpErr4, 
            this.h_nImpErr5, this.h_nImpErr6, this.h_nImpErr7);
        Date tdate = this.sdf2.parse(findDate);
        this.fileName = String.valueOf(filename.trim()) + "_" + this.sdf4.format(this.processDate) + "_" + user + 
          ".txt";
        getArcId(tdate);
      } catch (ParseException parseException) {}
      try {
        writeFile();
      } catch (IOException e) {
        e.printStackTrace();
        logger.info("Write Fail");
      } 
      this.il05B03ADao.updateLog(impdt, "1", this.h_nImpTot, this.h_nImpOK, this.h_nImpErr1, 
          this.h_nImpErr2, this.h_nImpErr3, this.h_nImpErr4, this.h_nImpErr5, this.h_nImpErr6, 
          this.h_nImpErr7);
    } catch (Exception e) {
      this.il05B03ADao.updateLog(impdt, "3", this.h_nImpTot, this.h_nImpOK, this.h_nImpErr1, 
          this.h_nImpErr2, this.h_nImpErr3, this.h_nImpErr4, this.h_nImpErr5, this.h_nImpErr6, 
          this.h_nImpErr7);
      logger.info("日期格式不正確。");
    } 
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
  
  public void writeFile() throws IOException {
    File pathFile = new File(this.path);
    logger.info(this.path);
    if (!pathFile.exists())
      pathFile.mkdirs(); 
    FileWriter outFile = new FileWriter(String.valueOf(this.path) + this.fileName);
    BufferedWriter bw = new BufferedWriter(outFile);
    String headerValue = "NO.  ARCID      PTRLDT            PTRLST  PTRLMRK                                                                                                                                                                                                         UID         UNM                                                 LMD                  MANTYPE              \n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
    String tailValue = "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
    bw.write(headerValue);
    for (int i = 0; i < this.dataList.size(); i++) {
      this.h_nImpTot++;
      String ilArcId = ((IL05B03ABean)this.dataList.get(i)).getIlArcid().toString();
      String ilPtrldt = this.sdf3.format(((IL05B03ABean)this.dataList.get(i)).getIlPtrldt());
      String ilPtrlst = ((IL05B03ABean)this.dataList.get(i)).getIlPtrlst();
      String ilPtrlMrk = ((IL05B03ABean)this.dataList.get(i)).getIlPtrlmrk();
      String ilUId = ((IL05B03ABean)this.dataList.get(i)).getIlUid();
      String ilUnm = ((IL05B03ABean)this.dataList.get(i)).getIlUnm();
      String ilLmd = this.sdf3.format(((IL05B03ABean)this.dataList.get(i)).getIlLmd());
      String ilManType = ((IL05B03ABean)this.dataList.get(i)).getIlMantype();
      bw.write(fillSpace(Integer.toString(i), 6));
      bw.write(fillSpace(ilArcId, 8));
      bw.write(fillSpace(ilPtrldt, 21));
      bw.write(fillSpace(ilPtrlst, 3));
      bw.write(fillSpace(ilPtrlMrk, 200));
      bw.write(fillSpace(ilUId, 10));
      bw.write(fillSpace(ilUnm, 18));
      bw.write(fillSpace(ilLmd, 35));
      bw.write(ilManType);
      if (i < this.dataList.size() - 1)
        bw.newLine(); 
      this.h_nImpOK++;
      this.sucessCount++;
    } 
    bw.write(tailValue);
    if (this.dataList.size() == 0)
      bw.write("\n 查無資料!"); 
    bw.close();
  }
  
  public String fillSpace(String value, int length) {
    for (int i = value.length(); i <= length; i++)
      value = String.valueOf(value) + " "; 
    return value;
  }
  
  public static void main(String[] args) throws ParseException {}
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\tranceData\IL05B03A.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */