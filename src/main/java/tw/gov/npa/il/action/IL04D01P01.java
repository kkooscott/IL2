package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import tw.gov.npa.il.action.bean.IL04D01P01Bean;
import tw.gov.npa.il.dao.Iltb20OnlineReport;
import tw.gov.npa.il.myDao.MyIltb20OnlineReportDAO;

public class IL04D01P01 extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL04D01P01.class);
  
  MyIltb20OnlineReportDAO myIltb20OnlineReportDAO = new MyIltb20OnlineReportDAO();
  
  private List<Iltb20OnlineReport> iltb20OnlineReportList = new ArrayList<Iltb20OnlineReport>();
  
  private List<IL04D01P01Bean> queryList = new ArrayList<IL04D01P01Bean>();
  
  private Date nowDate = new Date();
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public List<Iltb20OnlineReport> getIltb20OnlineReportList() {
    return this.iltb20OnlineReportList;
  }
  
  public void setIltb20OnlineReportList(List<Iltb20OnlineReport> iltb20OnlineReportList) {
    this.iltb20OnlineReportList = iltb20OnlineReportList;
  }
  
  public List<IL04D01P01Bean> getQueryList() {
    return this.queryList;
  }
  
  public void setQueryList(List<IL04D01P01Bean> queryList) {
    this.queryList = queryList;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
  }
  
  public String toMain() throws Exception {
    try {
      toQuery();
    } catch (Exception e) {
      logger.error(e, e);
      e.printStackTrace();
      return "error";
    } 
    return "success";
  }
  
  public String toQuery() throws Exception {
    HttpSession session = ServletActionContext.getRequest().getSession();
    String LOGUIP = (session.getAttribute("LOGUIP") == null) ? "" : session.getAttribute("LOGUIP").toString().trim();
    String LOGDIDCN = (session.getAttribute("LOGDIDCN") == null) ? "" : session.getAttribute("LOGDIDCN").toString().trim();
    String LOGUID = (session.getAttribute("LOGUID") == null) ? "" : session.getAttribute("LOGUID").toString().trim();
    this.iltb20OnlineReportList = this.myIltb20OnlineReportDAO.queryDataByLogUId(LOGUID);
    String preIlRptid = "";
    boolean chooseSession = false;
    for (int i = 0; i < this.iltb20OnlineReportList.size(); i++) {
      Iltb20OnlineReport bean = this.iltb20OnlineReportList.get(i);
      if (i == 0) {
        preIlRptid = bean.getId().getIlRptid();
        chooseSession = true;
      } else if (!preIlRptid.equals(bean.getId().getIlRptid())) {
        chooseSession = true;
      } else {
        chooseSession = false;
      } 
      if (chooseSession) {
        IL04D01P01Bean il04D01P01Bean = new IL04D01P01Bean();
        il04D01P01Bean.setId((new StringBuilder(String.valueOf(i + 1))).toString());
        il04D01P01Bean.setIlRptfn(bean.getIlRptfn());
        il04D01P01Bean.setIlRptid(bean.getId().getIlRptid());
        il04D01P01Bean.setIlRptnm(bean.getIlRptnm());
        il04D01P01Bean.setIlSnddt(bean.getId().getIlSnddt());
        il04D01P01Bean.setIlStatus(bean.getIlStatus());
        il04D01P01Bean.setIlUid(bean.getId().getIlUid());
        this.queryList.add(il04D01P01Bean);
      } 
      preIlRptid = bean.getId().getIlRptid();
    } 
    return "success";
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL04D01P01.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */