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

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import tw.gov.npa.il.entity.IL07D;
import tw.gov.npa.il.myDao.IL07DDao;

public class IL07D04Q02 extends ActionSupport {
	private static final Logger logger = Logger.getLogger(IL07D04Q02.class);

	ResourceBundle rb = ResourceBundle.getBundle("config");

	private String contextPath = this.rb.getString("templatePath").toString();
	
	private Date nowDate = new Date();

	private IL07DDao il07DDao;

	private List<IL07D> queryList;

	private String txtSRCHSTBegin;

	private String txtSRCHSTEnd;

	private String txtSRCHST;

	public String toMain() throws Exception {
		doRealQuery();
		return "success";
	}

	public String toQuery() throws Exception {
		return "success";
	}

	private void doRealQuery() {
		this.queryList = this.il07DDao.viewData(this.txtSRCHSTBegin, this.txtSRCHSTEnd);
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

				Label title = new Label(0, 0, "特殊身份代碼列印");
				WritableCellFormat titleFormat = new WritableCellFormat();
				titleFormat.setAlignment(Alignment.CENTRE);
				titleFormat.setFont(new WritableFont(WritableFont.TAHOMA, 16));
				title.setCellFormat(titleFormat);
				sheet.addCell(title);

				Label header = new Label(0, 6, "筆次");
				sheet.addCell(header);
				header = new Label(1, 6, "特殊身份代碼");
				sheet.addCell(header);
				header = new Label(2, 6, "特殊身份中文名稱");
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

			ResultSet rs = stmt.executeQuery("select E0_UNIT_NM from ABDB..E0DT_NPAUNIT where E0_UNIT_CD='"
					+ session.getAttribute("LOGDID") + "'");
			rs.next();
			Label header = new Label(0, 2, "列印單位：" + rs.getString("E0_UNIT_NM"));
			sheet.addCell(header);

			rs = stmt.executeQuery("select * from ILTB_SRCHST_CODE where IL_SRCHST>='" + this.txtSRCHSTBegin
					+ "' and IL_SRCHST<='" + this.txtSRCHSTEnd + "'");

			rs.last();
			int resultcount = rs.getRow();
			rs.beforeFirst();

			int datacount = 0;

			while (rs.next()) {
				datacount++;

				data = new Label(0, (datacount + 6), String.valueOf(datacount), cellFormat);
				sheet.addCell(data);

				data = new Label(1, (datacount + 6), rs.getString("IL_SRCHST"), cellFormat);
				sheet.addCell(data);

				data = new Label(2, (datacount + 6), rs.getString("IL_SRCHSTNM"), cellFormat);
				sheet.addCell(data);
			}

			workbook.write();
			workbook.close();
			conn.close();
			response.setHeader("Content-Disposition", "attachment; filename=\"srchst_code.xls\"");

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
				i++;
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

	public IL07DDao getIl07DDao() {
		return this.il07DDao;
	}

	public void setIl07DDao(IL07DDao il07dDao) {
		this.il07DDao = il07dDao;
	}

	public List<IL07D> getQueryList() {
		return this.queryList;
	}

	public void setQueryList(List<IL07D> queryList) {
		this.queryList = queryList;
	}

	public String getTxtSRCHSTBegin() {
		return this.txtSRCHSTBegin;
	}

	public void setTxtSRCHSTBegin(String txtSRCHSTBegin) {
		this.txtSRCHSTBegin = txtSRCHSTBegin;
	}

	public String getTxtSRCHSTEnd() {
		return this.txtSRCHSTEnd;
	}

	public void setTxtSRCHSTEnd(String txtSRCHSTEnd) {
		this.txtSRCHSTEnd = txtSRCHSTEnd;
	}

	public String getTxtSRCHST() {
		return this.txtSRCHST;
	}

	public void setTxtSRCHST(String txtSRCHST) {
		this.txtSRCHST = txtSRCHST;
	}
}
