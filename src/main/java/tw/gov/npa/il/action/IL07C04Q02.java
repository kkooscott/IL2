package tw.gov.npa.il.action;

import com.aspose.cells.MsoFillFormat;
import com.aspose.cells.MsoLineFormat;
import com.aspose.cells.MsoPresetTextEffect;
import com.aspose.cells.WorkbookDesigner;
import com.aspose.cells.Worksheet;
import com.opensymphony.xwork2.ActionSupport;

import jxl.Workbook;
import jxl.write.Alignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import tw.gov.npa.il.entity.IL07C;
import tw.gov.npa.il.myDao.IL07CDao;

public class IL07C04Q02 extends ActionSupport {
	private static final Logger logger = Logger.getLogger(IL07C04Q02.class);

//	ResourceBundle rb = ResourceBundle.getBundle("config");

	//	private String contextPath = this.rb.getString("templatePath").toString();

	private String contextPath = "D\\:\\reportTemplate\\";
	
	private Date nowDate = new Date();

	private IL07CDao il07CDao;

	private List<IL07C> queryList;

	private String txtUVCDBegin;

	private String txtUVCDEnd;

	private String txtUVCD;

	public String toMain() throws Exception {
		doRealQuery();
		return "success";
	}

	public String toQuery() throws Exception {
		return "success";
	}

	private void doRealQuery() {
		this.queryList = this.il07CDao.viewData(this.txtUVCDBegin, this.txtUVCDEnd);
	}

	public void doExcel() {

		try {
			HttpSession session = ServletActionContext.getRequest().getSession();
			HttpServletResponse response = ServletActionContext.getResponse();

			WritableWorkbook workbook;
			WritableSheet sheet;

			WritableCellFormat cellFormat = new WritableCellFormat();
			cellFormat.setVerticalAlignment(jxl.write.VerticalAlignment.CENTRE);
			WritableCellFormat format1 = new WritableCellFormat();
			format1.setVerticalAlignment(jxl.write.VerticalAlignment.CENTRE);
			format1.setWrap(true);

			String filename = String.valueOf(System.currentTimeMillis());
			workbook = Workbook.createWorkbook(new File(contextPath + filename + ".xls"));
			sheet = workbook.createSheet("Sheet1", 0); // 第2個參數是 0-base sheet index

			for (int i = 0; i < workbook.getSheetNames().length; i++) {

				sheet = workbook.getSheet(i);

				sheet.mergeCells(0, 0, 4, 0);
				sheet.mergeCells(0, 1, 4, 1);

				sheet.setColumnView(0, 15);
				sheet.setColumnView(1, 20);
				sheet.setColumnView(2, 25);
				sheet.setColumnView(3, 20);
				sheet.setColumnView(4, 20);
				sheet.setColumnView(5, 15);
				sheet.setColumnView(6, 25);
				sheet.setColumnView(7, 30);
				sheet.setColumnView(8, 20);

				sheet.mergeCells(0, 2, 1, 2);
				sheet.mergeCells(2, 2, 3, 2);
				sheet.mergeCells(0, 3, 1, 3);
				sheet.mergeCells(2, 3, 3, 3);
				sheet.mergeCells(0, 4, 1, 4);
				sheet.mergeCells(2, 4, 3, 4);

				Label title = new Label(0, 0, "大專院校代碼列印");
				WritableCellFormat titleFormat = new WritableCellFormat();
				titleFormat.setAlignment(Alignment.CENTRE);
				titleFormat.setFont(new WritableFont(WritableFont.TAHOMA, 16));
				title.setCellFormat(titleFormat);
				sheet.addCell(title);

				Label header = new Label(0, 6, "筆次");
				sheet.addCell(header);
				header = new Label(1, 6, "院校代碼");
				sheet.addCell(header);
				header = new Label(2, 6, "中文名稱");
				sheet.addCell(header);

				header = new Label(3, 6, "郵遞區號");
				sheet.addCell(header);

				header = new Label(4, 6, "院校電話");
				sheet.addCell(header);

				header = new Label(0, 2, "列印單位：");
				sheet.addCell(header);

				header = new Label(2, 2, "列印人：" + session.getAttribute("LOGCN"));
				sheet.addCell(header);

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

				Calendar cal = Calendar.getInstance();

				header = new Label(0, 3, "列印日期：" + sdf.format(cal.getTime()));
				sheet.addCell(header);

			}

			Label data;

			Properties prop = new Properties();

			ResourceBundle dbConfig = ResourceBundle.getBundle("db");

			String connstr = dbConfig.getString("connstr");
			String dbuser = dbConfig.getString("user");
			String dbpwd = dbConfig.getString("pwd");

			Connection conn = DriverManager.getConnection(connstr, dbuser, dbpwd);

			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = stmt.executeQuery("select E0_UNIT_NM from ABDB..E0DT_NPAUNIT where E0_UNIT_CD='" + session.getAttribute("LOGDID") + "'");
			rs.next();
			Label header = new Label(0, 2, "列印單位：" + rs.getString("E0_UNIT_NM"));
			sheet.addCell(header);

			rs = stmt.executeQuery("select * from ILTB_17_SCHOOL_CODE where IL_UVCD>='" + this.txtUVCDBegin + "' and IL_UVCD<='" + this.txtUVCDEnd + "'");

			rs.last();
			int resultcount = rs.getRow();
			rs.beforeFirst();

			int datacount = 0;

			while (rs.next()) {
				datacount++;

				data = new Label(0, (datacount + 6), String.valueOf(datacount), cellFormat);
				sheet.addCell(data);

				data = new Label(1, (datacount + 6), rs.getString("IL_UVCD"), cellFormat);
				sheet.addCell(data);

				data = new Label(2, (datacount + 6), rs.getString("IL_UVCNM"), cellFormat);
				sheet.addCell(data);

				data = new Label(3, (datacount + 6), rs.getString("IL_UVPZONE"), cellFormat);

				sheet.addCell(data);

				data = new Label(4, (datacount + 6), rs.getString("IL_UVTEL"), cellFormat);
				sheet.addCell(data);
			}

			workbook.write();
			workbook.close();
			conn.close();
			response.setHeader("Content-Disposition", "attachment; filename=\"school_code.xls\"");

			String time = (String) session.getAttribute("LOGTDT");
			String watermark = (String) session.getAttribute("LOGUNITNM") + "-" + (String) session.getAttribute("LOGCN") + "-" + time;
			com.aspose.cells.License license = new com.aspose.cells.License();
			license.setLicense("Aspose.Total.Java.lic");
			com.aspose.cells.Workbook wb = new com.aspose.cells.Workbook(contextPath + filename + ".xls");
			Worksheet st = wb.getWorksheets().get(0);
			int maxRow = st.getCells().getMaxDataRow();
			int maxCol = st.getCells().getMaxDataColumn();
			
			for (int i = 0; i < maxCol; i++) {
				for (int k = 0; k < maxRow; k++) {
					InsertWaterMarkToXLS(wb, st, watermark, k, k, i, i, 30, 600);
					k++;k++;k++;k++;
				}
				i++;i++;i++;
			}
			WorkbookDesigner designer = new WorkbookDesigner();
			designer.setWorkbook(wb);
			response.setContentType("application/vnd.ms-excel");
			wb.save(response.getOutputStream(), wb.getFileFormat());
			response.flushBuffer();
			new File(filename + ".xls").delete();
		} catch (Exception e) {
			e.printStackTrace();

			System.out.println("error!");
		}
	}
	
	protected void InsertWaterMarkToXLS(com.aspose.cells.Workbook workbook, Worksheet sheet, String watermarkText,
			int upperLeftRow, int top, int upperLeftColumn, int left, int height, int width) {
		// 添加浮水印
		com.aspose.cells.Shape wordart = sheet.getShapes().addTextEffect(MsoPresetTextEffect.TEXT_EFFECT_1, watermarkText, "標楷體 標準", 8, false, true, upperLeftRow, top, upperLeftColumn, left, height, width);
		wordart.setRotationAngle(-30);
		// 用藝術字體填充
		MsoFillFormat wordArtFormat = wordart.getFillFormat();
		// 設置顏色
		wordArtFormat.setForeColor(com.aspose.cells.Color.getGray());
		// 設置透明度
		wordArtFormat.setTransparency(0.5);
		// 設置線條不可見
		MsoLineFormat lineFormat = wordart.getLineFormat();
		lineFormat.setVisible(false);
		lineFormat.setForeColor(com.aspose.cells.Color.getWhite());
		lineFormat.setTransparency(0.5);
	}

	public Date getNowDate() {
		return this.nowDate;
	}

	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}

	public IL07CDao getIl07CDao() {
		return this.il07CDao;
	}

	public void setIl07CDao(IL07CDao il07cDao) {
		this.il07CDao = il07cDao;
	}

	public List<IL07C> getQueryList() {
		return this.queryList;
	}

	public void setQueryList(List<IL07C> queryList) {
		this.queryList = queryList;
	}

	public String getTxtUVCDBegin() {
		return this.txtUVCDBegin;
	}

	public void setTxtUVCDBegin(String txtUVCDBegin) {
		this.txtUVCDBegin = txtUVCDBegin;
	}

	public String getTxtUVCDEnd() {
		return this.txtUVCDEnd;
	}

	public void setTxtUVCDEnd(String txtUVCDEnd) {
		this.txtUVCDEnd = txtUVCDEnd;
	}

	public String getTxtUVCD() {
		return this.txtUVCD;
	}

	public void setTxtUVCD(String txtUVCD) {
		this.txtUVCD = txtUVCD;
	}
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL07C04Q02.
 * class Java compiler version: 5 (49.0) JD-Core Version: 1.1.3
 */