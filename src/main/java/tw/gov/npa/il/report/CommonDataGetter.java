package tw.gov.npa.il.report;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import tw.gov.npa.il.dao.Iltb01Main;
import tw.gov.npa.il.dao.Iltb15CountryCode;
import tw.gov.npa.il.dao.Iltb15CountryCodeDAO;
import tw.gov.npa.il.dao.Iltb16JobCode;
import tw.gov.npa.il.myDao.MyIltb16JobCodeDAO;
import tw.gov.npa.il.report.bean.AreaCodeBean;
import tw.gov.npa.il.report.bean.IDTypeBean;
import tw.gov.npa.il.report.bean.IL04CColumnBean;
import tw.gov.npa.il.report.bean.JobCodeBean;
import tw.gov.npa.il.report.bean.PeopleNumberTypeBean;
import tw.gov.npa.il.report.bean.PurposeBean;
import tw.gov.npa.il.report.bean.PurposeBeanV2;
import tw.gov.npa.il.report.bean.YearBean;

public class CommonDataGetter {
  public static List<Iltb16JobCode> getJobCode() {
    MyIltb16JobCodeDAO myIltb16JobCodeDAO = new MyIltb16JobCodeDAO();
    List<Iltb16JobCode> iltb16JobCodeList = myIltb16JobCodeDAO.getDataByIlNtprsq();
    Iltb16JobCode iltb16JobCode98 = new Iltb16JobCode();
    iltb16JobCode98.setIlOpcd("98");
    iltb16JobCode98.setIlOpnm("失業");
    iltb16JobCode98.setIlOpprsq(Short.valueOf((short)99));
    iltb16JobCode98.setIlOpcs("98");
    iltb16JobCode98.setIlLmd(new Timestamp(System.currentTimeMillis()));
    iltb16JobCodeList.add(iltb16JobCode98);
    Iltb16JobCode iltb16JobCode = new Iltb16JobCode();
    iltb16JobCode.setIlOpcd("99");
    iltb16JobCode.setIlOpnm("未滿15足歲兒童");
    iltb16JobCode.setIlOpprsq(Short.valueOf((short)99));
    iltb16JobCode.setIlOpcs("99");
    iltb16JobCode.setIlLmd(new Timestamp(System.currentTimeMillis()));
    iltb16JobCodeList.add(iltb16JobCode);
    System.out.println("iltb16JobCodeList=" + iltb16JobCodeList.size());
    return iltb16JobCodeList;
  }
  
  public static List<JobCodeBean> getJobCodeBean(boolean isVertical) {
    List<JobCodeBean> list = new ArrayList<JobCodeBean>();
    list.add(new JobCodeBean("07", "公務人員"));
    list.add(new JobCodeBean("10", "商務人員"));
    list.add(new JobCodeBean("05", "工程師"));
    list.add(new JobCodeBean("29", "會計師"));
    list.add(new JobCodeBean("32", "律師"));
    list.add(new JobCodeBean("16", "新聞記者"));
    list.add(new JobCodeBean("21", "教師"));
    list.add(new JobCodeBean("04", "醫師"));
    list.add(new JobCodeBean("13", "護理人員"));
    list.add(new JobCodeBean("11", "傳教士"));
    list.add(new JobCodeBean("09", "技工技匠"));
    if (isVertical) {
      list.add(new JobCodeBean("25", "　|小計"));
      list.add(new JobCodeBean("35", "外|營建業技工"));
      list.add(new JobCodeBean("36", "籍|製造業技工"));
      list.add(new JobCodeBean("37", "勞|家庭幫傭"));
      list.add(new JobCodeBean("38", "工|監護工"));
      list.add(new JobCodeBean("39", "　|船員"));
      list.add(new JobCodeBean("40", "　|其他"));
    } else {
      list.add(new JobCodeBean("25", "小計"));
      list.add(new JobCodeBean("35", "營建業技工"));
      list.add(new JobCodeBean("36", "製造業技工"));
      list.add(new JobCodeBean("37", "家庭幫傭"));
      list.add(new JobCodeBean("38", "監護工"));
      list.add(new JobCodeBean("39", "船員"));
      list.add(new JobCodeBean("40", "其他"));
    } 
    list.add(new JobCodeBean("03", "船員"));
    list.add(new JobCodeBean("24", "其他(有業者)"));
    list.add(new JobCodeBean("98", "失業"));
    list.add(new JobCodeBean("08", "家務"));
    list.add(new JobCodeBean("20", "學生"));
    list.add(new JobCodeBean("25", "其他(無業者)"));
    list.add(new JobCodeBean("99", "未滿十五足歲兒童"));
    return list;
  }
  
  public static List<Iltb15CountryCode> getCountryCode() {
    Iltb15CountryCodeDAO iltb15CountryCodeDAO = new Iltb15CountryCodeDAO();
    List<Iltb15CountryCode> iltb15CountryCodeList = iltb15CountryCodeDAO.findAll();
    System.out.println("iltb15CountryCodeList=" + iltb15CountryCodeList.size());
    return iltb15CountryCodeList;
  }
  
  public static List<Iltb15CountryCode> getCountryCodeOfWorkers() {
    List<Iltb15CountryCode> iltb15CountryCodeList = new ArrayList<Iltb15CountryCode>();
    Iltb15CountryCode nt1 = new Iltb15CountryCode();
    nt1.setIlNtcd("024");
    nt1.setIlNtnm("菲律賓");
    Iltb15CountryCode nt2 = new Iltb15CountryCode();
    nt2.setIlNtcd("019");
    nt2.setIlNtnm("馬來西亞");
    Iltb15CountryCode nt3 = new Iltb15CountryCode();
    nt3.setIlNtcd("009");
    nt3.setIlNtnm("印尼");
    Iltb15CountryCode nt4 = new Iltb15CountryCode();
    nt4.setIlNtcd("030");
    nt4.setIlNtnm("泰國");
    Iltb15CountryCode nt5 = new Iltb15CountryCode();
    nt5.setIlNtcd("034");
    nt5.setIlNtnm("越南");
    Iltb15CountryCode nt6 = new Iltb15CountryCode();
    nt6.setIlNtcd("313");
    nt6.setIlNtnm("尼加拉瓜");
    Iltb15CountryCode nt7 = new Iltb15CountryCode();
    nt7.setIlNtcd("999");
    nt7.setIlNtnm("其他");
    iltb15CountryCodeList.add(nt1);
    iltb15CountryCodeList.add(nt2);
    iltb15CountryCodeList.add(nt3);
    iltb15CountryCodeList.add(nt4);
    iltb15CountryCodeList.add(nt5);
    iltb15CountryCodeList.add(nt6);
    iltb15CountryCodeList.add(nt7);
    System.out.println("iltb15CountryCodeList=" + iltb15CountryCodeList.size());
    return iltb15CountryCodeList;
  }
  
  public static List<AreaCodeBean> getAreaCode() {
    List<AreaCodeBean> list = new ArrayList<AreaCodeBean>();
    list.add(new AreaCodeBean("台灣地區", "ZZZ1", Integer.valueOf(0)));
    list.add(new AreaCodeBean("　台灣省", "ZZZ2", Integer.valueOf(1)));
    list.add(new AreaCodeBean("　　宜蘭縣", "T000", Integer.valueOf(2)));
    list.add(new AreaCodeBean("　　新竹縣", "G000", Integer.valueOf(3)));
    list.add(new AreaCodeBean("　　苗栗縣 ", "H000", Integer.valueOf(4)));
    list.add(new AreaCodeBean("　　彰化縣", "J000", Integer.valueOf(5)));
    list.add(new AreaCodeBean("　　南投縣", "K000", Integer.valueOf(6)));
    list.add(new AreaCodeBean("　　雲林縣 ", "L000", Integer.valueOf(7)));
    list.add(new AreaCodeBean("　　嘉義縣", "N000", Integer.valueOf(8)));
    list.add(new AreaCodeBean("　　屏東縣", "Q000", Integer.valueOf(9)));
    list.add(new AreaCodeBean("　　臺東縣", "R000", Integer.valueOf(10)));
    list.add(new AreaCodeBean("　　花蓮縣", "S000", Integer.valueOf(11)));
    list.add(new AreaCodeBean("　　澎湖縣", "U000", Integer.valueOf(12)));
    list.add(new AreaCodeBean("　　基隆市", "A000", Integer.valueOf(13)));
    list.add(new AreaCodeBean("　　新竹市", "F000", Integer.valueOf(14)));
    list.add(new AreaCodeBean("　　嘉義市", "M000", Integer.valueOf(15)));
    list.add(new AreaCodeBean("　直轄市", "ZZZ3", Integer.valueOf(16)));
    list.add(new AreaCodeBean("　　臺北市", "W000", Integer.valueOf(17)));
    list.add(new AreaCodeBean("　　新北市", "D000", Integer.valueOf(18)));
    list.add(new AreaCodeBean("　　臺中市 ", "B000", Integer.valueOf(19)));
    list.add(new AreaCodeBean("　　臺南市", "C000", Integer.valueOf(20)));
    list.add(new AreaCodeBean("　　高雄市", "V000", Integer.valueOf(21)));
    list.add(new AreaCodeBean("　　桃園市", "E000", Integer.valueOf(22)));
    list.add(new AreaCodeBean("　福建省", "ZZZ4", Integer.valueOf(23)));
    list.add(new AreaCodeBean("　　金門縣", "Y000", Integer.valueOf(24)));
    list.add(new AreaCodeBean("　　連江縣", "Z000", Integer.valueOf(25)));
    System.out.println("areaCodeList=" + list.size());
    return list;
  }
  
  public static List<PurposeBean> getPurposeCode() {
    List<PurposeBean> list = new ArrayList<PurposeBean>();
    list.add(new PurposeBean("依親", "  合計", " ", "", 0, 0, 0));
    list.add(new PurposeBean("依親", " 依本國人", "小計", "", 1, 0, 1));
    list.add(new PurposeBean("依親", " 依本國人", "配偶", "", 2, 0, 1));
    list.add(new PurposeBean("依親", " 依本國人", "子女", "", 3, 0, 1));
    list.add(new PurposeBean("依親", " 依本國人", "父母", "", 4, 0, 1));
    list.add(new PurposeBean("依親", " 依本國人", "其他", "", 5, 0, 1));
    list.add(new PurposeBean("依親", "依外國人", "小計", "", 6, 0, 2));
    list.add(new PurposeBean("依親", "依外國人", "配偶", "", 7, 0, 2));
    list.add(new PurposeBean("依親", "依外國人", "子女", "", 8, 0, 2));
    list.add(new PurposeBean("依親", "依外國人", "父母", "", 9, 0, 2));
    list.add(new PurposeBean("依親", "依外國人", "其他", "", 10, 0, 2));
    list.add(new PurposeBean("就學", " ", " ", "", 11, 1, 0));
    list.add(new PurposeBean("應聘", " ", " ", "", 12, 2, 0));
    list.add(new PurposeBean("投資", " ", " ", "", 13, 3, 0));
    list.add(new PurposeBean("傳教", " ", " ", "", 14, 4, 0));
    list.add(new PurposeBean("外勞", " ", " ", "", 15, 5, 0));
    list.add(new PurposeBean("其他", " ", " ", "", 16, 6, 0));
    list.add(new PurposeBean("永久居留", "小計", " ", "", 17, 7, 0));
    list.add(new PurposeBean("永久居留", "居留七年", " ", "", 18, 7, 1));
    list.add(new PurposeBean("永久居留", "依親五年配偶", " ", "", 19, 7, 2));
    list.add(new PurposeBean("永久居留", "依親五年子女", " ", "", 20, 7, 3));
    list.add(new PurposeBean("永久居留", "居留十五年", " ", "", 21, 7, 4));
    list.add(new PurposeBean("永久居留", "依親居住十年", " ", "", 22, 7, 5));
    list.add(new PurposeBean("永久居留", "居住二十年者", " ", "", 23, 7, 6));
    list.add(new PurposeBean("永久居留", "高科技人士", " ", "", 24, 7, 7));
    list.add(new PurposeBean("永久居留", "特殊貢獻者", " ", "", 25, 7, 8));
    list.add(new PurposeBean("永久居留", "其他", " ", "", 26, 7, 9));
    System.out.println("purposeCodeList=" + list.size());
    return list;
  }
  
  public static List<PurposeBeanV2> getPurposeCodeV2() {
    List<PurposeBeanV2> list = new ArrayList<PurposeBeanV2>();
    list.add(new PurposeBeanV2("依親", "", "", 0, 0));
    list.add(new PurposeBeanV2("就學", "", "", 1, 0));
    list.add(new PurposeBeanV2("應聘", "", "", 2, 0));
    list.add(new PurposeBeanV2("投資", "", "", 3, 0));
    list.add(new PurposeBeanV2("傳教", "", "", 4, 0));
    list.add(new PurposeBeanV2("外勞", "", "", 5, 0));
    list.add(new PurposeBeanV2("其他", "", "", 6, 0));
    list.add(new PurposeBeanV2("永久居留", "小計", "", 7, 0));
    list.add(new PurposeBeanV2("永久居留", "居留七年", "", 8, 1));
    list.add(new PurposeBeanV2("永久居留", "依親五年配偶", "", 9, 2));
    list.add(new PurposeBeanV2("永久居留", "依親五年子女", "", 10, 3));
    list.add(new PurposeBeanV2("永久居留", "居留十五年", "", 11, 4));
    list.add(new PurposeBeanV2("永久居留", "依親居住十年", "", 12, 5));
    list.add(new PurposeBeanV2("永久居留", "居住二十年者", "", 13, 6));
    list.add(new PurposeBeanV2("永久居留", "高科技人士", "", 14, 7));
    list.add(new PurposeBeanV2("永久居留", "特殊貢獻者", "", 15, 8));
    list.add(new PurposeBeanV2("永久居留", "其他", "", 16, 9));
    System.out.println("purposeCodeList=" + list.size());
    return list;
  }
  
  public static List<IDTypeBean> getIDType() {
    List<IDTypeBean> list = new ArrayList<IDTypeBean>();
    list.add(new IDTypeBean("外僑居留證", 0));
    list.add(new IDTypeBean("外僑永久居留證", 1));
    System.out.println("IDTypeList=" + list.size());
    return list;
  }
  
  public static List<PeopleNumberTypeBean> getPeopleNumberType() {
    List<PeopleNumberTypeBean> list = new ArrayList<PeopleNumberTypeBean>();
    list.add(new PeopleNumberTypeBean("新增逃逸人數", 0));
    list.add(new PeopleNumberTypeBean("當月查獲人數", 1));
    list.add(new PeopleNumberTypeBean("目前協尋人數", 2));
    System.out.println("NumberTypeList=" + list.size());
    return list;
  }
  
  public static List<Iltb01Main> getTestIltb01Mains() {
    List<Iltb01Main> list = new ArrayList<Iltb01Main>();
    return list;
  }
  
  public static List<YearBean> getYear() {
    List<YearBean> list = new ArrayList<YearBean>();
    list.add(new YearBean("０年", 0));
    list.add(new YearBean("１年", 1));
    list.add(new YearBean("２年", 2));
    list.add(new YearBean("３年", 3));
    list.add(new YearBean("４年", 4));
    list.add(new YearBean("５年", 5));
    list.add(new YearBean("６年", 6));
    list.add(new YearBean("７年", 7));
    list.add(new YearBean("８年", 8));
    list.add(new YearBean("９年", 9));
    list.add(new YearBean("10年", 10));
    list.add(new YearBean("11年", 11));
    list.add(new YearBean("12年", 12));
    list.add(new YearBean("13年", 13));
    list.add(new YearBean("14年", 14));
    list.add(new YearBean("15年", 15));
    list.add(new YearBean("16年", 16));
    list.add(new YearBean("17年", 17));
    list.add(new YearBean("18年", 18));
    list.add(new YearBean("19年", 19));
    list.add(new YearBean("20年", 20));
    list.add(new YearBean("20年以上", 21));
    System.out.println("YearList=" + list.size());
    return list;
  }
  
  public static List<IL04CColumnBean> getIL04CColumn(boolean write) {
    List<IL04CColumnBean> list = new ArrayList<IL04CColumnBean>();
    list.add(new IL04CColumnBean("外來人口統一證號", 10, 1, write));
    list.add(new IL04CColumnBean("居留效期(起)", 12, 2, write));
    list.add(new IL04CColumnBean("居留效期(迄)", 12, 3, write));
    list.add(new IL04CColumnBean("護照號碼", 10, 4, write));
    list.add(new IL04CColumnBean("英文姓名", 40, 5, write));
    list.add(new IL04CColumnBean("中文姓名", 12, 6, write));
    list.add(new IL04CColumnBean("國籍", 20, 7, write));
    list.add(new IL04CColumnBean("性別", 4, 8, write));
    list.add(new IL04CColumnBean("出生日期", 8, 9, write));
    list.add(new IL04CColumnBean("職業", 20, 10, write));
    list.add(new IL04CColumnBean("居留狀況", 16, 11, write));
    list.add(new IL04CColumnBean("居留事由", 12, 12, write));
    list.add(new IL04CColumnBean("教育程度", 8, 13, write));
    list.add(new IL04CColumnBean("服務處所", 8, 14, write));
    list.add(new IL04CColumnBean("服務處所名稱", 44, 15, write));
    list.add(new IL04CColumnBean("服務處所電話", 15, 16, write));
    list.add(new IL04CColumnBean("工作地址", 62, 17, write));
    list.add(new IL04CColumnBean("工作電話", 15, 18, write));
    list.add(new IL04CColumnBean("居留地址郵遞區號", 16, 19, write));
    list.add(new IL04CColumnBean("居留地址", 62, 20, write));
    list.add(new IL04CColumnBean("居留電話", 15, 21, write));
    list.add(new IL04CColumnBean("管轄分局", 8, 22, write));
    list.add(new IL04CColumnBean("管轄外責區代碼", 14, 23, write));
    list.add(new IL04CColumnBean("在華親屬稱謂", 12, 24, write));
    list.add(new IL04CColumnBean("在華親屬國籍", 20, 25, write));
    list.add(new IL04CColumnBean("逃逸日期", 8, 26, write));
    list.add(new IL04CColumnBean("報案日期", 8, 27, write));
    list.add(new IL04CColumnBean("查獲日期", 8, 28, write));
    list.add(new IL04CColumnBean("協尋處理情形", 12, 29, write));
    list.add(new IL04CColumnBean("在台日期", 8, 30, write));
    list.add(new IL04CColumnBean("離台日期", 8, 31, write));
    list.add(new IL04CColumnBean("親屬身分(居留)證號", 18, 32, write));
    list.add(new IL04CColumnBean("親屬姓名", 44, 33, write));
    list.add(new IL04CColumnBean("申請日期", 8, 34, write));
    list.add(new IL04CColumnBean("人口分類", 22, 35, write));
    list.add(new IL04CColumnBean("收據號碼", 8, 36, write));
    list.add(new IL04CColumnBean("縮影編號", 10, 37, write));
    return list;
  }
  
  public static void main(String[] arg) {
    getAreaCode();
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\report\CommonDataGetter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */