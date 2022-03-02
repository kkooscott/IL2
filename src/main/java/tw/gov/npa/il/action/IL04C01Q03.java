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

public class IL04C01Q03 extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL04C01Q03.class);
  
  private List<Iltb20OnlineReport> iltb20IdList;
  
  public String toMain() throws Exception {
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpSession session = request.getSession();
    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
    HttpSession session1 = ServletActionContext.getRequest().getSession();
    String LOGUIP = (session1.getAttribute("LOGUIP") == null) ? "" : session1.getAttribute("LOGUIP").toString().trim();
    String LOGDIDCN = (session1.getAttribute("LOGDIDCN") == null) ? "" : session1.getAttribute("LOGDIDCN").toString().trim();
    String LOGUID = (session1.getAttribute("LOGUID") == null) ? "" : session1.getAttribute("LOGUID").toString().trim();
    String ilUid = (String)session.getAttribute("LOGUID");
    if (ilUid == null)
      ilUid = "testLogin"; 
    String whereCommand1 = (String)session.getAttribute("whereCommand1");
    String whereCommand2 = (String)session.getAttribute("whereCommand2");
    session.removeAttribute("whereCommand1");
    session.removeAttribute("whereCommand2");
    System.out.println("IL04C01Q03 whereCommand:" + whereCommand1 + whereCommand2);
    StringBuffer sb = new StringBuffer(",");
    byte b;
    int i;
    String[] arrayOfString;
    for (i = (arrayOfString = this.chkField).length, b = 0; b < i; ) {
      String s = arrayOfString[b];
      sb.append(s).append(',');
      b++;
    } 
    System.out.println("sb:" + sb.toString());
    Iltb20OnlineReport report = new Iltb20OnlineReport();
    Iltb20OnlineReportId id = new Iltb20OnlineReportId(LOGUID, "20", new Timestamp(System.currentTimeMillis()));
    report.setId(id);
    report.setIlDidnm(LOGDIDCN);
    report.setIlIp(LOGUIP);
    report.setIlRptamt(Short.valueOf((short)0));
    report.setIlRptfn("20" + LOGUID);
    report.setIlRptnm("自由檢索報表－無固定欄項");
    report.setIlRundt(new Timestamp(System.currentTimeMillis()));
    report.setIlShow(sb.toString());
    report.setIlStatus("0");
    report.setIlWhere1(whereCommand1);
    report.setIlWhere2(whereCommand2);
    report.setIlModified(new Timestamp(System.currentTimeMillis()));
    MyIltb20OnlineReportDAO dao = new MyIltb20OnlineReportDAO();
    dao.update(report);
    request.setAttribute("report", report);
    return "success";
  }
  
  public String toQuery() throws Exception {
    return "success";
  }
  
  private Date nowDate = new Date();
  
  private String[] chkField;
  
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
  
  public String[] getChkField() {
    return this.chkField;
  }
  
  public void setChkField(String[] chkField) {
    this.chkField = chkField;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL04C01Q03.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */