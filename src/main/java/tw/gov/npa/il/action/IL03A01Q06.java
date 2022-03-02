package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import tw.gov.npa.il.dao.Iltb01Main;
import tw.gov.npa.il.dao.Iltb03MainRecord;
import tw.gov.npa.il.dao.Iltb16JobCode;
import tw.gov.npa.il.myDao.MyIltb01MainDAO;
import tw.gov.npa.il.myDao.MyIltb03MainRecordDAO;
import tw.gov.npa.il.myDao.MyIltb16JobCodeDAO;
import tw.gov.npa.il.util.Constant;

public class IL03A01Q06 extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL03A01Q06.class);
  
  MyIltb03MainRecordDAO myIltb03MainRecordDAO = new MyIltb03MainRecordDAO();
  
  private List<Iltb03MainRecord> queryList = new ArrayList<Iltb03MainRecord>();
  
  private Date nowDate = new Date();
  
  MyIltb01MainDAO myIltb01MainDAO = new MyIltb01MainDAO();
  
  private Iltb01Main iltb01Main = new Iltb01Main();
  
  private int allSize;
  
  private int ilArcid;
  
  private String ilArcno;
  
  private String ilPspt;
  
  private String ilEnm;
  
  private Constant constant = new Constant();
  
  private String logcn;
  
  private String logpstname;
  
  private String main;
  
  private String detail;
  
  public Iltb01Main getIltb01Main() {
    return this.iltb01Main;
  }
  
  public List<Iltb03MainRecord> getQueryList() {
    return this.queryList;
  }
  
  public void setQueryList(List<Iltb03MainRecord> queryList) {
    this.queryList = queryList;
  }
  
  public void setIltb01Main(Iltb01Main iltb01Main) {
    this.iltb01Main = iltb01Main;
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
  
  public int getAllSize() {
    return this.allSize;
  }
  
  public void setAllSize(int allSize) {
    this.allSize = allSize;
  }
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
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
    this.queryList = this.myIltb03MainRecordDAO.getDataByIlArcid(this.ilArcid);
  }
  
  public String getIlArctp(DateFormat df, Iltb03MainRecord bean) {
    StringBuilder sb = new StringBuilder();
    if (!"".equals(bean.getIlJbpmfm()) && bean.getIlJbpmfm() != null) {
      sb.append("居留效期起日：");
      sb.append(df.format(bean.getIlJbpmfm()));
    } 
    if (!"".equals(bean.getIlJbpmto()) && bean.getIlJbpmto() != null) {
      sb.append(", 居留效期迄日：");
      sb.append(df.format(bean.getIlJbpmto()));
    } 
    if (!"".equals(bean.getIlEnm()) && bean.getIlEnm() != null) {
      sb.append(", 英文姓名：");
      sb.append(bean.getIlEnm());
    } 
    if (!"".equals(bean.getIlArcno()) && bean.getIlArcno() != null) {
      sb.append(", 外來人口統一證號：");
      sb.append(bean.getIlArcno());
    } 
    if (!"".equals(bean.getIlPspt()) && bean.getIlPspt() != null) {
      sb.append(", 護照號碼：");
      sb.append(bean.getIlPspt());
    } 
    if (!"".equals(bean.getIlJbcd()) && bean.getIlJbcd() != null) {
      MyIltb16JobCodeDAO myIltb16JobCodeDAO = new MyIltb16JobCodeDAO();
      Iltb16JobCode iltb16JobCode = myIltb16JobCodeDAO.findById(bean.getIlJbcd());
      sb.append(", 職業：");
      sb.append(iltb16JobCode.getIlOpnm());
    } 
    if (!"".equals(bean.getIlArcrsn()) && bean.getIlArcrsn() != null) {
      sb.append(", 居留事由：");
      sb.append((String)this.constant.getIlArcrsnMap().get(bean.getIlArcrsn()));
    } 
    if (!"".equals(bean.getIlMicro()) && bean.getIlMicro() != null) {
      sb.append(", 縮影編號：");
      sb.append(bean.getIlMicro());
    } 
    if (!"".equals(bean.getIlOfnm()) && bean.getIlOfnm() != null) {
      sb.append(", 服務處所/就讀學校/依親對象：");
      sb.append(bean.getIlOfnm());
    } 
    if (!"".equals(bean.getIlJbaddr()) && bean.getIlJbaddr() != null) {
      sb.append(", 工作地址：");
      sb.append(bean.getIlJbaddr());
    } 
    if (!"".equals(bean.getIlJbtel()) && bean.getIlJbtel() != null) {
      sb.append(", 工作電話：");
      sb.append(bean.getIlJbtel());
    } 
    if (!"".equals(bean.getIlAraddr()) && bean.getIlAraddr() != null) {
      sb.append(", 居留地址：");
      sb.append(bean.getIlAraddr());
    } 
    if (!"".equals(bean.getIlArtel()) && bean.getIlArtel() != null) {
      sb.append(", 居留電話：");
      sb.append(bean.getIlArtel());
    } 
    if (!"".equals(bean.getIlJbpmcd()) && bean.getIlJbpmcd() != null) {
      sb.append(", 工作許可機關：");
      sb.append((String)this.constant.getIlJbpmcdMap().get(bean.getIlJbpmcd()));
    } 
    if (!"".equals(bean.getIlJbpmdt()) && bean.getIlJbpmdt() != null) {
      sb.append(", 許可日期：");
      sb.append(df.format(bean.getIlJbpmdt()));
    } 
    if (!"".equals(bean.getIlJbpmdc()) && bean.getIlJbpmdc() != null) {
      sb.append(", 文號：");
      sb.append(bean.getIlJbpmdc());
    } 
    if (!"".equals(bean.getIlArcfm()) && bean.getIlArcfm() != null) {
      sb.append(", 許可效期起日：");
      sb.append(df.format(bean.getIlArcfm()));
    } 
    if (!"".equals(bean.getIlArcto()) && bean.getIlArcto() != null) {
      sb.append(", 許可效期迄日：");
      sb.append(df.format(bean.getIlArcto()));
    } 
    if (!"".equals(bean.getIlArcrcp()) && bean.getIlArcrcp() != null) {
      sb.append(", 收據號碼：");
      sb.append(bean.getIlArcrcp());
    } 
    if (!"".equals(bean.getIlReapydt()) && bean.getIlReapydt() != null) {
      sb.append(", 重入國申請日期：");
      sb.append(df.format(bean.getIlReapydt()));
    } 
    if (!"".equals(bean.getIlRetp()) && bean.getIlRetp() != null) {
      sb.append(", 重入國類別：");
      sb.append((String)this.constant.getIlRetpMap().get(bean.getIlRetp()));
    } 
    if (!"".equals(bean.getIlRepmdc()) && bean.getIlRepmdc() != null) {
      sb.append(", 重入國許可證號：");
      sb.append(bean.getIlRepmdc());
    } 
    if (!"".equals(bean.getIlRepmdt()) && bean.getIlRepmdt() != null) {
      sb.append(", 重入國核准期限：");
      sb.append(df.format(bean.getIlRepmdt()));
    } 
    if (!"".equals(bean.getIlRrnote()) && bean.getIlRrnote() != null) {
      sb.append(", 重入國備考：");
      sb.append(bean.getIlRrnote());
    } 
    if (!"".equals(bean.getIlMrkcs()) && bean.getIlMrkcs() != null) {
      sb.append(", 撤(註)銷居留/出國報備：");
      sb.append(bean.getIlMrkcs());
    } 
    if (!"".equals(bean.getIlFbdrsn()) && bean.getIlFbdrsn() != null) {
      sb.append(", 撤(註)銷居留原因：");
      sb.append(bean.getIlFbdrsn());
    } 
    if (!"".equals(bean.getIlMrkdt()) && bean.getIlMrkdt() != null) {
      sb.append(", 日期：");
      sb.append(df.format(bean.getIlMrkdt()));
    } 
    if (!"".equals(bean.getIlMrkdc()) && bean.getIlMrkdc() != null) {
      sb.append(", 文號：");
      sb.append(bean.getIlMrkdc());
    } 
    return sb.toString();
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL03A01Q06.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */