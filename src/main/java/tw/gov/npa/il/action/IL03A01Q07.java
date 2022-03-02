package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import tw.gov.npa.il.action.bean.IL03A01Q07Bean;
import tw.gov.npa.il.dao.Iltb04InRecord;
import tw.gov.npa.il.myDao.MyIltb04InRecordDAO;
import tw.gov.npa.il.util.Constant;

public class IL03A01Q07 extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL03A01Q07.class);
  
  MyIltb04InRecordDAO myIltb04InRecordDAO = new MyIltb04InRecordDAO();
  
  private List<IL03A01Q07Bean> queryList = new ArrayList<IL03A01Q07Bean>();
  
  private Date nowDate = new Date();
  
  private int ilArcid;
  
  private String ilArcno;
  
  private String ilPspt;
  
  private String ilEnm;
  
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
    List<Iltb04InRecord> iltb04InRecordList = new ArrayList<Iltb04InRecord>();
    iltb04InRecordList = this.myIltb04InRecordDAO.getDataByIlArcid(this.ilArcid);
    for (int i = 0; i < iltb04InRecordList.size(); i++) {
      Iltb04InRecord iltb04InRecord = iltb04InRecordList.get(i);
      IL03A01Q07Bean bean = new IL03A01Q07Bean();
      bean.setId(i + 1);
      bean.setIlPtrldt(iltb04InRecord.getId().getIlPtrldt());
      bean.setIlPtrlmrk(iltb04InRecord.getIlPtrlmrk());
      bean.setIlPtrlst(iltb04InRecord.getIlPtrlst());
      bean.setIlUnm(iltb04InRecord.getIlUnm());
      this.queryList.add(bean);
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL03A01Q07.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */