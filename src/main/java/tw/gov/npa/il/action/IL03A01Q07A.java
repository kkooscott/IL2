package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import tw.gov.npa.il.action.bean.IL03A01Q07Bean;
import tw.gov.npa.il.myDao.IL03ADao;
import tw.gov.npa.il.myDao.MyIltb22IaRecordDAO;
import tw.gov.npa.il.util.Constant;

public class IL03A01Q07A extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL03A01Q07A.class);
  
  MyIltb22IaRecordDAO myIltb22IaRecordDAO = new MyIltb22IaRecordDAO();
  
  private List<IL03A01Q07Bean> queryList = new ArrayList<IL03A01Q07Bean>();
  
  private Date nowDate = new Date();
  
  private int ilArcid;
  
  private String ilArcno;
  
  private String ilPspt;
  
  private String ilEnm;
  
  private IL03ADao il03ADao;
  
  private Constant constant = new Constant();
  
  private String logcn;
  
  private String logpstname;
  
  private String main;
  
  private String detail;
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public List<IL03A01Q07Bean> getQueryList() {
    return this.queryList;
  }
  
  public void setQueryList(List<IL03A01Q07Bean> queryList) {
    this.queryList = queryList;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
  }
  
  public int getIlArcid() {
    return this.ilArcid;
  }
  
  public void setIlArcid(int ilArcid) {
    this.ilArcid = ilArcid;
  }
  
  public String getIlArcno() {
    return this.ilArcno;
  }
  
  public void setIlArcno(String ilArcno) {
    this.ilArcno = ilArcno;
  }
  
  public String getIlPspt() {
    return this.ilPspt;
  }
  
  public void setIlPspt(String ilPspt) {
    this.ilPspt = ilPspt;
  }
  
  public String getIlEnm() {
    return this.ilEnm;
  }
  
  public void setIlEnm(String ilEnm) {
    this.ilEnm = ilEnm;
  }
  
  public IL03ADao getIl03ADao() {
    return this.il03ADao;
  }
  
  public void setIl03ADao(IL03ADao il03aDao) {
    this.il03ADao = il03aDao;
  }
  
  public Constant getConstant() {
    return this.constant;
  }
  
  public void setConstant(Constant constant) {
    this.constant = constant;
  }
  
  public String getLogcn() {
    return this.logcn;
  }
  
  public void setLogcn(String logcn) {
    this.logcn = logcn;
  }
  
  public String getLogpstname() {
    return this.logpstname;
  }
  
  public void setLogpstname(String logpstname) {
    this.logpstname = logpstname;
  }
  
  public String getMain() {
    return this.main;
  }
  
  public void setMain(String main) {
    this.main = main;
  }
  
  public String getDetail() {
    return this.detail;
  }
  
  public void setDetail(String detail) {
    this.detail = detail;
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
  
  public void toQuery() throws Exception {
    this.queryList = this.il03ADao.viewData(this.ilArcid);
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL03A01Q07A.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */