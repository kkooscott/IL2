package tw.gov.npa.il.report.data.il04c01;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import tw.gov.npa.il.dao.Iltb01Main;
import tw.gov.npa.il.dao.Iltb15CountryCode;
import tw.gov.npa.il.dao.Iltb15CountryCodeDAO;
import tw.gov.npa.il.dao.Iltb16JobCodeDAO;
import tw.gov.npa.il.myDao.MyIltb01MainDAO;
import tw.gov.npa.il.report.CommonDataGetter;
import tw.gov.npa.il.report.bean.IL04CColumnBean;

public class Builder08C01P {
  private static int RPT_MAXLEN = 200;
  
  private static String firstSeperator = "================================================================================================================================================================================================================";
  
  private static String dataSeperator = "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
  
  private static Iltb15CountryCodeDAO countryDao;
  
  private static Iltb16JobCodeDAO jobDao;
  
  public static List<String> build(String whereCondition, String show) {
    List<String> back = new ArrayList<String>();
    countryDao = new Iltb15CountryCodeDAO();
    jobDao = new Iltb16JobCodeDAO();
    MyIltb01MainDAO myIltb01MainDAO = new MyIltb01MainDAO();
    List<Iltb01Main> iltb01MainList = myIltb01MainDAO.getIL08C01P(whereCondition);
    System.out.println("iltb01MainList=" + iltb01MainList.size());
    List<IL04CColumnBean> columns = CommonDataGetter.getIL04CColumn(true);
    int c1l = 0, c2l = 0, c3l = 0, cc = 1;
    StringBuffer c1t = new StringBuffer(), c2t = new StringBuffer(), c3t = new StringBuffer();
    System.out.println("寫欄位...");
    for (IL04CColumnBean column : columns) {
      if (column.setWrite(show)) {
        System.out.println("欄位名=" + column.getColumnName());
        if (cc == 1) {
          if (c1l + column.getWidth() + 1 <= RPT_MAXLEN) {
            column.setOutputTo(1);
            c1l += column.getWidth() + 1;
            c1t.append(getFormattedString(column.getColumnName(), column.getWidth()));
            continue;
          } 
          column.setOutputTo(2);
          c2l += column.getWidth() + 1;
          cc = 2;
          c2t.append(getFormattedString(column.getColumnName(), column.getWidth()));
          continue;
        } 
        if (cc == 2) {
          if (c2l + column.getWidth() + 1 <= RPT_MAXLEN) {
            column.setOutputTo(2);
            c2l += column.getWidth() + 1;
            c2t.append(getFormattedString(column.getColumnName(), column.getWidth()));
            continue;
          } 
          column.setOutputTo(3);
          c3l += column.getWidth() + 1;
          cc = 3;
          c3t.append(getFormattedString(column.getColumnName(), column.getWidth()));
          continue;
        } 
        if (cc == 3) {
          column.setOutputTo(3);
          c3l += column.getWidth() + 1;
          cc = 3;
          c3t.append(getFormattedString(column.getColumnName(), column.getWidth()));
          continue;
        } 
        System.out.println("有問題，不會超過三行");
      } 
    } 
    back.add("序號    ");
    back.add(c1t.toString());
    if (c2t.length() > 0)
      back.add(c2t.toString()); 
    if (c3t.length() > 0)
      back.add(c3t.toString()); 
    back.add(firstSeperator);
    int i = 0;
    String colname = "";
    System.out.println("寫資料...");
    for (Iltb01Main obj : iltb01MainList) {
      try {
        i++;
        c1t = new StringBuffer();
        c2t = new StringBuffer();
        c3t = new StringBuffer();
        for (IL04CColumnBean column : columns) {
          colname = column.getColumnName();
          if (column.isWrite()) {
            if (column.getOutputTo() == 1) {
              try {
                c1t.append(getFormattedString(getIltb01MainDataByIndex(obj, column.getSequence()), column.getWidth()));
              } catch (Exception ex) {
                c1t.append(getFormattedString("", column.getWidth()));
              } 
              continue;
            } 
            if (column.getOutputTo() == 2) {
              try {
                c2t.append(getFormattedString(getIltb01MainDataByIndex(obj, column.getSequence()), column.getWidth()));
              } catch (Exception ex) {
                c2t.append(getFormattedString("", column.getWidth()));
              } 
              continue;
            } 
            try {
              c3t.append(getFormattedString(getIltb01MainDataByIndex(obj, column.getSequence()), column.getWidth()));
            } catch (Exception ex) {
              c3t.append(getFormattedString("", column.getWidth()));
            } 
          } 
        } 
        back.add(i + "");
        back.add(c1t.toString());
        if (c2t.length() > 0)
          back.add(c2t.toString()); 
        if (c3t.length() > 0)
          back.add(c3t.toString()); 
        back.add(dataSeperator);
      } catch (Exception ex) {
        System.out.println(ex);
        ex.printStackTrace();
        System.out.println("第" + i + "筆, column=" + colname);
      } 
    } 
    System.out.println("build finished....return");
    return back;
  }
  
  public static List<String> build_csv(String whereCondition, String show) {
    List<String> back = new ArrayList<String>();
    countryDao = new Iltb15CountryCodeDAO();
    jobDao = new Iltb16JobCodeDAO();
    MyIltb01MainDAO myIltb01MainDAO = new MyIltb01MainDAO();
    List<Iltb01Main> iltb01MainList = myIltb01MainDAO.getIL08C01P(whereCondition);
    System.out.println("iltb01MainList=" + iltb01MainList.size());
    List<IL04CColumnBean> columns = CommonDataGetter.getIL04CColumn(true);
    int c1l = 0, c2l = 0, c3l = 0, cc = 1;
    StringBuffer c1t = new StringBuffer(), c2t = new StringBuffer(), c3t = new StringBuffer();
    for (IL04CColumnBean column : columns) {
      if (column.setWrite(show))
        c1t.append(getFormattedString(column.getColumnName(), column.getWidth()) + ","); 
    } 
    back.add("序號    ," + c1t.toString());
    if (c2t.length() > 0)
      back.add(c2t.toString()); 
    if (c3t.length() > 0)
      back.add(c3t.toString()); 
    int i = 0;
    for (Iltb01Main obj : iltb01MainList) {
      i++;
      c1t = new StringBuffer();
      c2t = new StringBuffer();
      c3t = new StringBuffer();
      for (IL04CColumnBean column : columns) {
        if (column.isWrite())
          try {
            c1t.append(getFormattedString(getIltb01MainDataByIndex(obj, column.getSequence()), column.getWidth()) + ",");
          } catch (Exception ex) {
            System.out.println("i=" + i + "   " + column.getColumnName());
            c1t.append(getFormattedString("", column.getWidth()) + ",");
          }  
      } 
      back.add(i + "," + c1t.toString());
      if (c2t.length() > 0)
        back.add(c2t.toString()); 
      if (c3t.length() > 0)
        back.add(c3t.toString()); 
    } 
    return back;
  }
  
  private static String getFormattedString(String text, int length) {
    StringBuffer sb = new StringBuffer();
    int minus = 0;
    if (text != null) {
      sb.append(text);
      if ((text.getBytes()).length > text.length())
        minus = (text.getBytes()).length - text.length(); 
    } else {
      sb.append("----");
    } 
    for (int i = 0; i <= length + 1; i++)
      sb.append(" "); 
    return sb.substring(0, length + 2 - minus).toString();
  }
  
  private static String getFormattedString(Timestamp ts) {
    if (ts != null)
      return String.format("%tY", new Object[] { ts }) + "/" + String.format("%tm", new Object[] { ts }) + "/" + String.format("%td", new Object[] { ts }); 
    return "";
  }
  
  private static String getIltb01MainDataByIndex(Iltb01Main obj, int idx) {
    Iltb15CountryCode iltb15CountryCode;
    String back = "";
    switch (idx) {
      case 1:
        back = obj.getIlArcno();
        break;
      case 2:
        back = getFormattedString(obj.getIlArcfm());
        break;
      case 3:
        back = getFormattedString(obj.getIlArcto());
        break;
      case 4:
        back = obj.getIlPspt();
        break;
      case 5:
        back = obj.getIlEnm();
        break;
      case 6:
        back = obj.getIlCnm();
        break;
      case 7:
        iltb15CountryCode = countryDao.findById(obj.getIlNtcd());
        if (iltb15CountryCode != null) {
          back = iltb15CountryCode.getIlNtnm();
          break;
        } 
        back = "";
        break;
      case 8:
        if (obj.getIlSex().equals("1")) {
          back = "男";
          break;
        } 
        back = "女";
        break;
      case 9:
        back = obj.getIlBthdt();
        break;
      case 10:
        back = jobDao.findById(obj.getIlJbcd()).getIlOpnm();
        break;
      case 11:
        if (obj.getIlArcst().equals("1")) {
          back = "改變國籍";
          break;
        } 
        if (obj.getIlArcst().equals("2")) {
          back = "在台";
          break;
        } 
        if (obj.getIlArcst().equals("3")) {
          back = "離台";
          break;
        } 
        if (obj.getIlArcst().equals("4")) {
          back = "死亡";
          break;
        } 
        if (obj.getIlArcst().equals("5")) {
          back = "註銷居留證";
          break;
        } 
        if (obj.getIlArcst().equals("6")) {
          back = "棄原國籍取我國籍";
          break;
        } 
        back = "";
        break;
      case 12:
        if (obj.getIlArcrsn().equals("1")) {
          back = "依親";
          break;
        } 
        if (obj.getIlArcrsn().equals("2")) {
          back = "就學";
          break;
        } 
        if (obj.getIlArcrsn().equals("3")) {
          back = "應聘";
          break;
        } 
        if (obj.getIlArcrsn().equals("4")) {
          back = "投資";
          break;
        } 
        if (obj.getIlArcrsn().equals("5")) {
          back = "傳教";
          break;
        } 
        if (obj.getIlArcrsn().equals("6")) {
          back = "其他";
          break;
        } 
        if (obj.getIlArcrsn().equals("7")) {
          back = "外勞";
          break;
        } 
        if (obj.getIlArcrsn().equals("8")) {
          back = "居留七年";
          break;
        } 
        if (obj.getIlArcrsn().equals("9")) {
          back = "依親五年配偶";
          break;
        } 
        if (obj.getIlArcrsn().equals("A")) {
          back = "依親五年子女";
          break;
        } 
        if (obj.getIlArcrsn().equals("B")) {
          back = "依親居住十五年";
          break;
        } 
        if (obj.getIlArcrsn().equals("C")) {
          back = "依親居住十年";
          break;
        } 
        if (obj.getIlArcrsn().equals("D")) {
          back = "居住二十年者";
          break;
        } 
        if (obj.getIlArcrsn().equals("E")) {
          back = "高科技人士";
          break;
        } 
        if (obj.getIlArcrsn().equals("F")) {
          back = "特殊貢獻者";
          break;
        } 
        if (obj.getIlArcrsn().equals("G")) {
          back = "其他";
          break;
        } 
        back = "";
        break;
      case 13:
        if (obj.getIlEdu().equals("01")) {
          back = "博士";
          break;
        } 
        if (obj.getIlEdu().equals("02")) {
          back = "碩士";
          break;
        } 
        if (obj.getIlEdu().equals("03")) {
          back = "大學畢業";
          break;
        } 
        if (obj.getIlEdu().equals("04")) {
          back = "大學肄業";
          break;
        } 
        if (obj.getIlEdu().equals("05")) {
          back = "專科畢業";
          break;
        } 
        if (obj.getIlEdu().equals("06")) {
          back = "專科肄業";
          break;
        } 
        if (obj.getIlEdu().equals("07")) {
          back = "高中畢業";
          break;
        } 
        if (obj.getIlEdu().equals("08")) {
          back = "高中肄業";
          break;
        } 
        if (obj.getIlEdu().equals("09")) {
          back = "初中畢業";
          break;
        } 
        if (obj.getIlEdu().equals("10")) {
          back = "初中肄業";
          break;
        } 
        if (obj.getIlEdu().equals("11")) {
          back = "小學畢業";
          break;
        } 
        if (obj.getIlEdu().equals("12")) {
          back = "小學肄業";
          break;
        } 
        if (obj.getIlEdu().equals("13")) {
          back = "識字";
          break;
        } 
        if (obj.getIlEdu().equals("14")) {
          back = "不識字";
          break;
        } 
        if (obj.getIlEdu().equals("15")) {
          back = "不明";
          break;
        } 
        back = "";
        break;
      case 14:
        back = obj.getIlOfcd();
        break;
      case 15:
        back = obj.getIlOfnm();
        break;
      case 16:
        back = obj.getIlOftel();
        break;
      case 17:
        back = obj.getIlJbaddr();
        break;
      case 18:
        back = obj.getIlJbtel();
        break;
      case 19:
        back = obj.getIlArpzone();
        break;
      case 20:
        back = obj.getIlAraddr();
        break;
      case 21:
        back = obj.getIlArtel();
        break;
      case 22:
        back = obj.getIlPst();
        break;
      case 23:
        back = obj.getIlPstext();
        break;
      case 24:
        if (obj.getIlFrshp().equals("1")) {
          back = "夫";
          break;
        } 
        if (obj.getIlFrshp().equals("2")) {
          back = "妻";
          break;
        } 
        if (obj.getIlFrshp().equals("3")) {
          back = "父";
          break;
        } 
        if (obj.getIlFrshp().equals("4")) {
          back = "母";
          break;
        } 
        if (obj.getIlFrshp().equals("5")) {
          back = "子";
          break;
        } 
        if (obj.getIlFrshp().equals("6")) {
          back = "女";
          break;
        } 
        if (obj.getIlFrshp().equals("7")) {
          back = "祖父";
          break;
        } 
        if (obj.getIlFrshp().equals("8")) {
          back = "祖母";
          break;
        } 
        if (obj.getIlFrshp().equals("9")) {
          back = "兄";
          break;
        } 
        if (obj.getIlFrshp().equals("10")) {
          back = "弟";
          break;
        } 
        if (obj.getIlFrshp().equals("11")) {
          back = "姊";
          break;
        } 
        if (obj.getIlFrshp().equals("12")) {
          back = "妹";
          break;
        } 
        if (obj.getIlFrshp().equals("13")) {
          back = "其他";
          break;
        } 
        back = "";
        break;
      case 25:
        back = " ";
        if (obj.getIlFntcd() != null) {
          Iltb15CountryCode country = countryDao.findById(obj.getIlFntcd());
          if (country != null)
            back = country.getIlNtnm(); 
          break;
        } 
        System.out.println("obj.getIlFntcd()==null");
        break;
      case 26:
        back = getFormattedString(obj.getIlMissdt());
        break;
      case 27:
        back = getFormattedString(obj.getIlSbmtdt());
        break;
      case 28:
        back = getFormattedString(obj.getIlFnddt());
        break;
      case 29:
        if (obj.getIlSrchst().equals("1")) {
          back = "行方不明";
          break;
        } 
        if (obj.getIlSrchst().equals("2")) {
          back = "取消協尋通報";
          break;
        } 
        if (obj.getIlSrchst().equals("3")) {
          back = "查獲或收容";
          break;
        } 
        if (obj.getIlSrchst().equals("4")) {
          back = "取消查獲通報";
          break;
        } 
        if (obj.getIlSrchst().equals("5")) {
          back = "收容費預墊";
          break;
        } 
        if (obj.getIlSrchst().equals("6")) {
          back = "取消預墊通報";
          break;
        } 
        back = "";
        break;
      case 30:
        back = getFormattedString(obj.getIlIndt());
        break;
      case 31:
        back = getFormattedString(obj.getIlExdt());
        break;
      case 32:
        back = obj.getIlFpid();
        break;
      case 33:
        back = obj.getIlFnm();
        break;
      case 34:
        back = getFormattedString(obj.getIlApydt());
        break;
      case 35:
        back = " ";
        break;
      case 36:
        back = obj.getIlArcrcp();
        break;
      case 37:
        back = obj.getIlMicro();
        break;
    } 
    return back;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\report\data\il04c01\Builder08C01P.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */