package tw.gov.npa.il.util;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class Constant {
	private Map<String, String> genderMap;

	private Map<String, String> yesNoMap;

	private List<String> bloodList;

	private Map<String, String> reportIdMap;

	private Map<String, String> ilArcrsnMap;

	private Map<String, String> ilJbpmcdMap;

	private Map<String, String> ilRetpMap;

	private Map<String, String> ilStatusMap;

	private Map<String, String> ilPtrlstMap;

	private Map<String, String> ilPstAreaMap;

	public static final String LEVEL_1 = "1";

	public static final String LEVEL_2 = "2";

	public static final String LEVEL_3 = "3";

	public static final String LEVEL_4 = "4";

	public static final String serverName = "WIVILMNA02";

	private String backupFolder;

//	ResourceBundle rb = ResourceBundle.getBundle("config");

//	private Integer logMethod = Integer.valueOf(Integer.parseInt(this.rb.getString("LogWriteMode").toString()));
	private Integer logMethod = Integer.valueOf("0");

	private String apName;

	public Map<String, String> getGenderMap() {
		this.genderMap = ImmutableMap.<String, String>builder().put("1", "男").put("2", "女").build();
		return this.genderMap;
	}

	public Map<String, String> getIlPstAreaMap() {
		this.ilPstAreaMap = ImmutableMap.<String, String>builder().put("A", "基隆市").put("B", "台中市").put("I", "台中市")
				.put("C", "台南市").put("O", "台南市").put("D", "新北市").put("E", "桃園市").put("F", "新竹市").put("G", "新竹縣")
				.put("H", "苗栗縣").put("J", "彰化縣").put("K", "南投縣").put("L", "雲林縣").put("M", "嘉義市").put("N", "嘉義縣")
				.put("Q", "屏東縣").put("R", "台東縣").put("S", "花蓮縣").put("T", "宜蘭縣").put("U", "澎湖縣").put("V", "高雄市")
				.put("P", "高雄市").put("W", "台北市").put("Y", "金門縣").put("Z", "連江縣").build();
		return this.ilPstAreaMap;
	}

	public void setIlPstAreaMap(Map<String, String> ilPstAreaMap) {
		this.ilPstAreaMap = ilPstAreaMap;
	}

	public Map<String, String> getIlPtrlstMap() {
		this.ilPtrlstMap = ImmutableMap.<String, String>builder().put("1", "該僑確住該址").put("2", "該僑未住該址").put("3", "查無該址")
				.put("4", "其它").build();
		return this.ilPtrlstMap;
	}

	public void setIlPtrlstMap(Map<String, String> ilPtrlstMap) {
		this.ilPtrlstMap = ilPtrlstMap;
	}

	public Map<String, String> getIlStatusMap() {
		this.ilStatusMap = ImmutableMap.<String, String>builder().put("0", "未執行").put("1", "完成").put("2", "執行中")
				.put("3", "執行失敗").put("4", "處理失敗").put("5", "處理逾時").put("6", "處理中斷").put("7", "筆數超過限制").build();
		return this.ilStatusMap;
	}

	public void setIlStatusMap(Map<String, String> ilStatusMap) {
		this.ilStatusMap = ilStatusMap;
	}

	public Map<String, String> getIlRetpMap() {
		this.ilJbpmcdMap = ImmutableMap.<String, String>builder().put("0", " ").put("1", "單次").put("2", "多次").build();
		return this.ilRetpMap;
	}

	public void setIlRetpMap(Map<String, String> ilRetpMap) {
		this.ilRetpMap = ilRetpMap;
	}

	public Map<String, String> getIlJbpmcdMap() {
		this.ilJbpmcdMap = ImmutableMap.<String, String>builder().put("1", "勞動部").put("2", "內政部").put("3", "經濟部")
				.put("4", "經濟部投審會").put("5", "科學園區管理局").put("6", "教育部").put("7", "交通部").put("8", "國防部").put("9", "新聞局")
				.put("-", "衛生署").put("A", "台北市政府").put("B", "台中市政府").put("C", "基隆市政府").put("D", "台南市政府")
				.put("E", "高雄市政府").put("F", "新北市政府").put("G", "宜蘭縣政府").put("H", "桃園市政府").put("I", "嘉義市政府")
				.put("J", "新竹縣政府").put("K", "苗栗縣政府").put("L", "台中縣政府").put("M", "南投縣政府").put("N", "彰化縣政府")
				.put("O", "新竹市政府").put("P", "雲林縣政府").put("Q", "嘉義縣政府").put("R", "台南縣政府").put("S", "高雄縣政府")
				.put("T", "屏東縣政府").put("U", "花蓮縣政府").put("V", "台東縣政府").put("W", "金門縣政府").put("X", "澎湖縣政府")
				.put("Y", "連江縣政府").put("Z", "其他").build();
		return this.ilJbpmcdMap;
	}

	public void setIlJbpmcdMap(Map<String, String> ilJbpmcdMap) {
		this.ilJbpmcdMap = ilJbpmcdMap;
	}

	public Map<String, String> getReportIdMap() {
		this.reportIdMap = ImmutableMap.<String, String>builder().put("IL03B01P01_1P", "01").put("IL03B01P01_2P", "02")
				.put("IL03B01P01_3P", "03").put("IL03B01P01_4P", "04").put("IL03B01P01_5P", "05")
				.put("IL03B01P01_6P", "06").build();
		return this.reportIdMap;
	}

	public void setReportIdMap(Map<String, String> reportIdMap) {
		this.reportIdMap = reportIdMap;
	}

	public Map<String, String> getIlArcrsnMap() {
		this.ilArcrsnMap = ImmutableMap.<String, String>builder().put("0", "").put("1", "依親").put("2", "就學")
				.put("3", "應聘").put("4", "投資").put("5", "傳教").put("6", "其他").put("7", "外勞").put("8", "永居(連續居留七年)")
				.put("9", "永居(依親五年配偶)").put("A", "永居(依親五年子女)").put("B", "永居(依親居住十五年)").put("C", "永居(依親居住十年)")
				.put("D", "永居(居住二十年者)").put("E", "永居(高科技人士)").put("F", "永居(特殊貢獻者)").put("G", "永居(其他)").build();
		return this.ilArcrsnMap;
	}

	public void setIlArcrsnMap(Map<String, String> ilArcrsnMap) {
		this.ilArcrsnMap = ilArcrsnMap;
	}

	public void setGenderMap(Map<String, String> genderMap) {
		this.genderMap = genderMap;
	}

	public Map<String, String> getYesNoMap() {
		this.yesNoMap = ImmutableMap.<String, String>builder().put("0", "有").put("1", "無").build();
		return this.yesNoMap;
	}

	public void setYesNoMap(Map<String, String> yesNoMap) {
		this.yesNoMap = yesNoMap;
	}

	public List<String> getBloodList() {
		this.bloodList = Lists.newArrayList("A", "B", "O", "AB");
		return this.bloodList;
	}

	public void setBloodList(List<String> bloodList) {
		this.bloodList = bloodList;
	}

	public String getBackupFolder() {
		return this.backupFolder;
	}

	public void setBackupFolder(String backupFolder) {
		this.backupFolder = backupFolder;
	}

	public Integer getLogMethod() {
		return this.logMethod;
	}

	public void setLogMethod(Integer logMethod) {
		this.logMethod = logMethod;
	}

	public String getApName() {
		return "IL2";
	}

	public void setApName(String apName) {
		this.apName = apName;
	}

	public static String getServername() {
		return "WIVILMNA02";
	}
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\i\\util\Constant.class
 * Java compiler version: 5 (49.0) JD-Core Version: 1.1.3
 */