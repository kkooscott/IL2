package npalog;

import java.io.BufferedWriter;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.json.simple.JSONObject;

public class NPALog4J {

	ResourceBundle rb = ResourceBundle.getBundle("config");
	private static final Logger logger = Logger.getLogger(NPALog4J.class);

	public int logging(int mesgSendWay, int big5ToUnicode, String LOG_UID, String LOG_DID, String LOG_UIP,
			String LOG_TDT, String OPR_SVR, String OPR_TDT, String OPR_PAGE, String OPR_TYPE, String OPR_SN,
			String OPR_QEND, String OPR_MEND, String OPR_NAME, String OPR_DN, String OPR_PURP, String OPR_COND,
			String QND_IDNO, String QND_NAME, String QND_BIRTHDT, String QND_CARTYPE, String QND_CARNO,
			String PAGE_OBJ) {
		String result = logging(LOG_UID.substring(0, 8), LOG_UID.substring(9), LOG_DID, LOG_UIP, LOG_TDT, OPR_SVR,
				OPR_TDT, OPR_PAGE.contains("-") ? OPR_PAGE : ("系統功能頁面-" + OPR_PAGE), OPR_TYPE, OPR_SN, OPR_QEND,
				OPR_MEND, OPR_NAME, OPR_DN, "", OPR_PURP, "", OPR_COND, QND_IDNO, QND_NAME, QND_BIRTHDT, QND_CARTYPE,
				QND_CARNO, "", "", "", PAGE_OBJ);
		System.out.println("result:" + result);
		return 0;
	}

	public String logging(String LOG_UID, String LOG_CN, String LOG_DID, String LOG_UIP, String LOG_TDT, String OPR_SVR,
			String OPR_TDT, String OPR_PAGE, String OPR_TYPE, String OPR_SN, String OPR_QEND, String OPR_MEND,
			String OPR_NAME, String OPR_DN, String OPR_KIND, String OPR_PURP, String OPR_CASEID, String OPR_COND,
			String QND_IDNO, String QND_NAME, String QND_BIRTHDT, String QND_CARTYPE, String QND_CARNO,
			String QND_PHONE, String QND_IMEI, String QND_CASENO, String PAGE_OBJ) {
		String result = "";

		try {
			LocalDateTime now = LocalDateTime.now();
//            String url = "http://10.100.195.137:8080/NPALogService/sendLogMessage.do";
			String url = rb.getString("logURL").toString();
			DefaultHttpClient client = new DefaultHttpClient();

			HttpPost post = new HttpPost(url);
			post.setHeader("Content-Type", "application/json");

			JSONObject postData = new JSONObject();
			postData.put("LOG_UID", getString(LOG_UID).toUpperCase()); // 使用者帳號
			postData.put("LOG_CN", LOG_CN); // 使用者中文姓名
			postData.put("LOG_DID", getString(LOG_DID).toUpperCase()); // 使用者單位代碼
			postData.put("LOG_UIP", LOG_UIP); // 使用者登入IP
			postData.put("LOG_TDT", transTimeString(LOG_TDT)); // 使用者登入時間
			postData.put("OPR_SVR",
					getString(OPR_SVR).length() == 0 ? InetAddress.getLocalHost().getHostName().toUpperCase()
							: getString(OPR_SVR).toUpperCase()); // AP系統實體伺服器伺服器代碼(名稱)
			postData.put("OPR_TDT",
					getString(OPR_TDT).length() == 0 ? new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
							: transTimeString(OPR_TDT)); // 使用者作業時間
			postData.put("OPR_PAGE", getString(OPR_PAGE).replaceAll("_", "")); // 網頁名稱及檔名
			postData.put("OPR_TYPE", OPR_TYPE); // 作業種類
			postData.put("OPR_SN", OPR_SN); // AP系統代碼
			postData.put("OPR_QEND", OPR_QEND); // 查詢結果(可略)
			postData.put("OPR_MEND", OPR_MEND); // 異動結果(可略)
			postData.put("OPR_NAME", getString(OPR_NAME)); // 實際查詢人姓名
			postData.put("OPR_DN", getString(OPR_DN)); // 實際查詢人單位
			postData.put("OPR_KIND", OPR_KIND); // 實際查詢人用途種類
			postData.put("OPR_PURP", getString(OPR_PURP)); // 實際查詢人用途說明
			postData.put("OPR_CASEID", getString(OPR_CASEID).toUpperCase()); // 員警開案案號
			postData.put("OPR_COND", OPR_COND); // 查詢條件
			postData.put("QND_IDNO", QND_IDNO); // 身分證號
			postData.put("QND_NAME", QND_NAME); // 姓名
			postData.put("QND_BIRTHDT", QND_BIRTHDT); // 生日
			postData.put("QND_CARTYPE", QND_CARTYPE); // 車牌種類
			postData.put("QND_CARNO", QND_CARNO); // 車牌號碼
			postData.put("QND_PHONE", QND_PHONE); // 電話號碼
			postData.put("QND_IMEI", QND_IMEI); // 手機序號(IMEI)
			postData.put("QND_CASENO", QND_CASENO); // 案件號碼
			postData.put("PAGE_OBJ", PAGE_OBJ); // 全文內容

			post.setEntity(new StringEntity(postData.toString(), "UTF-8"));
			logger.info("Log json Data = " + postData.toString());

			HttpResponse resp = client.execute(post);
			logger.info("Response Code = " + resp.getStatusLine().getStatusCode());
			// response回傳code不為200需寫檔案並落地
			if (resp.getStatusLine().getStatusCode() != 200) {
				DateTimeFormatter datetime = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
				Charset charset = Charset.forName("UTF-8");
				Path path = Paths.get("D:/NPALogPostScheduler/message/IL" + datetime.format(now) + ".txt");
				try (BufferedWriter writer = Files.newBufferedWriter(path, charset)) {
					writer.write(postData.toString());
					logger.info("寫入檔案成功");
				}
			}
			HttpEntity entity = resp.getEntity();
			result = EntityUtils.toString(entity);
			logger.info("result = " + result);
		} catch (Exception e) {
			e.printStackTrace();
			result = e.toString();
			logger.error(result);
		}
		return result;
	}

	public String genQueryXML(String[] QRslt) {
		String[] columnName = QRslt[0].split("&");
		int colNum = columnName.length;
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("Data");
		for (int i = 1; i < QRslt.length; i++) {
			String[] data = QRslt[i].split("&", colNum);
			Element datarow = root.addElement("DataRow");
			for (int j = 0; j < columnName.length; j++) {
				datarow.addElement(columnName[j]).addText(data[j]);
			}
		}
		return document.asXML();
	}

	public String genUpdateXML(String BeforeUpdate, String AfterUpdate) {
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("Data");
		Element datarow = root.addElement("DataRow");
		datarow.addElement("BeforeUpdate").addText(BeforeUpdate);
		datarow.addElement("AfterUpdate").addText(AfterUpdate);
		return doc.asXML();
	}

	private String transTimeString(String input) {
		String output = "";
		if (input != null) {
			output = input.replaceAll("/", "").replaceAll(" ", "").replaceAll(":", "");
		}
		return output;
	}

	private String getString(Object o) {
		String tmp = "";
		if (o != null && !o.equals("null")) {
			tmp = o.toString().trim();
		}
		return tmp;
	}

	public int logging2(int mesgSendWay, int big5ToUnicode, String LOG_UID, String LOG_DID, String LOG_UIP,
			String LOG_TDT, String OPR_SVR, String OPR_TDT, String OPR_PAGE, String OPR_TYPE, String OPR_SN,
			String OPR_QEND, String OPR_MEND, String OPR_NAME, String OPR_DN, String OPR_PURP, String OPR_COND,
			String QND_IDNO, String QND_NAME, String QND_BIRTHDT, String QND_CARTYPE, String QND_CARNO,
			String PAGE_OBJ) {
		System.out.println("NPALOG2:LOG_UID=" + LOG_UID + "@LOG_DID=" + LOG_DID + "@LOG_UIP=" + LOG_UIP + "@LOG_TDT="
				+ LOG_TDT + "@OPR_SVR=" + OPR_SVR + "@OPR_TDT=" + OPR_TDT + "@OPR_PAGE=" + OPR_PAGE + "@OPR_TYPE="
				+ OPR_TYPE + "@OPR_SN=" + OPR_SN + "@OPR_QEND=" + OPR_QEND + "@OPR_MEND=" + OPR_MEND + "@OPR_NAME="
				+ OPR_NAME + "@OPR_DN=" + OPR_DN + "@OPR_PURP=" + OPR_PURP + "@OPR_COND=" + OPR_COND + "@QND_IDNO="
				+ QND_IDNO + "@QND_NAME=" + QND_NAME + "@QND_BIRTHDT=" + QND_BIRTHDT + "@QND_CARTYPE=" + QND_CARTYPE
				+ "@QND_CARNO=" + QND_CARNO + "@PAGE_OBJ=" + PAGE_OBJ);
		return logging(mesgSendWay, big5ToUnicode, LOG_UID, LOG_DID, LOG_UIP, LOG_TDT, OPR_SVR, OPR_TDT, OPR_PAGE,
				OPR_TYPE, OPR_SN, OPR_QEND, OPR_MEND, OPR_NAME, OPR_DN, OPR_PURP, OPR_COND, QND_IDNO, QND_NAME,
				QND_BIRTHDT, QND_CARTYPE, QND_CARNO, PAGE_OBJ);
	}
}
