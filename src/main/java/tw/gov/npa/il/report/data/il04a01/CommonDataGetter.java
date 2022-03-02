package tw.gov.npa.il.report.data.il04a01;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import tw.gov.npa.il.dao.Iltb01Main;
import tw.gov.npa.il.dao.Iltb15CountryCode;
import tw.gov.npa.il.dao.Iltb15CountryCodeDAO;
import tw.gov.npa.il.dao.Iltb16JobCode;
import tw.gov.npa.il.myDao.MyIltb16JobCodeDAO;

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
  
  public static void main(String[] arg) {
    getAreaCode();
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\report\data\il04a01\CommonDataGetter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */