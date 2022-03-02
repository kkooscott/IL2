package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import tw.gov.npa.il.dao.Iltb20OnlineReport;
import tw.gov.npa.il.dao.Iltb20OnlineReportId;
import tw.gov.npa.il.myDao.MyIltb20OnlineReportDAO;

public class IL04B01Q03 extends ActionSupport {
	private static final Logger logger = Logger.getLogger(IL04B01Q03.class);

	private List<Iltb20OnlineReport> iltb20IdList;

	private Date nowDate = new Date();

	private int ReportKind;

	public int getReportKind() {
		return this.ReportKind;
	}

	public void setReportKind(int reportKind) {
		this.ReportKind = reportKind;
	}

	public List<Iltb20OnlineReport> getIltb20IdList() {
		return this.iltb20IdList;
	}

	public void setIltb20IdList(List<Iltb20OnlineReport> iltb20IdList) {
		this.iltb20IdList = iltb20IdList;
	}

	public Date getNowDate() {
		return this.nowDate;
	}

	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}

	public String toMain() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		HttpSession session1 = ServletActionContext.getRequest().getSession();
		String LOGUIP = (session1.getAttribute("LOGUIP") == null) ? ""
				: session1.getAttribute("LOGUIP").toString().trim();
		String LOGDIDCN = (session1.getAttribute("LOGDIDCN") == null) ? ""
				: session1.getAttribute("LOGDIDCN").toString().trim();
		String LOGUID = (session1.getAttribute("LOGUID") == null) ? ""
				: session1.getAttribute("LOGUID").toString().trim();
		String ilUid = (String) session.getAttribute("LOGUID");
		if (ilUid == null)
			ilUid = "testLogin";
		System.out.println("Which one is=" + this.ReportKind);
		String whereCommand1 = (String) session.getAttribute("whereCommand1");
		String whereCommand2 = (String) session.getAttribute("whereCommand2");
		session.removeAttribute("whereCommand1");
		session.removeAttribute("whereCommand2");
		System.out.println("IL04B01Q03 whereCommand:" + whereCommand1 + whereCommand2);
		String ilRptid = null, ilRptnm = null;
		switch (ReportKind) {
		case 1:
			ilRptid = "11";
			ilRptnm = "自由檢索報表－按國籍及職業分";
			break;
		case 2:
			ilRptid = "12";
			ilRptnm = "自由檢索報表－按國籍及區域分";
			break;
		case 3:
			ilRptid = "13";
			ilRptnm = "自由檢索報表－按職業及區域分";
			break;
		case 4:
			ilRptid = "17";
			ilRptnm = "自由檢索報表－按居留目的及職業分";
			break;
		case 5:
			ilRptid = "18";
			ilRptnm = "自由檢索報表－按居留目的及區域分";
			break;
		case 6:
			ilRptid = "19";
			ilRptnm = "自由檢索報表－按國籍及居留目的分";
			break;
		case 7:
			ilRptid = "22";
			ilRptnm = "自由檢索報表－臺閩地區外僑持續居留年限統計報表及名冊";
			break;
		default:
			System.out.println("ReportKind is " + ReportKind);
			ilRptid = "xxxxx";
			ilRptnm = "xxxxx";
			break;
		}

		Iltb20OnlineReport report = new Iltb20OnlineReport();
		Iltb20OnlineReportId id = new Iltb20OnlineReportId(LOGUID, ilRptid, new Timestamp(System.currentTimeMillis()));
		report.setId(id);
		report.setIlDidnm(LOGDIDCN);
		report.setIlIp(LOGUIP);
		report.setIlRptamt((short) 0);
		report.setIlRptfn(ilRptid + LOGUID);
		report.setIlRptnm(ilRptnm);
		report.setIlRundt(new Timestamp(System.currentTimeMillis()));
		report.setIlShow("ilShow");
		report.setIlStatus("0");// 未執行
		report.setIlWhere1(whereCommand1);
		report.setIlWhere2(whereCommand2);
		report.setIlModified(new Timestamp(System.currentTimeMillis()));

		MyIltb20OnlineReportDAO dao = new MyIltb20OnlineReportDAO();
		dao.update(report);
		request.setAttribute("report", report);

		return SUCCESS;
	}

	public String toQuery() throws Exception {
		return "success";
	}
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL04B01Q03.
 * class Java compiler version: 5 (49.0) JD-Core Version: 1.1.3
 */