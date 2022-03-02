package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import tw.gov.npa.il.entity.IL07B;
import tw.gov.npa.il.myDao.IL07BDao;

public class IL07B02U02 extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL07B02U02.class);
  
  private Date nowDate = new Date();
  
  private IL07BDao il07BDao;
  
  private List<IL07B> queryList;
  
  private String txtOPCDBegin;
  
  private String txtOPCDEnd;
  
  private String txtOPCD;
  
  public String toMain() throws Exception {
    doRealQuery();
    return "success";
  }
  
  private void doRealQuery() {
    this.queryList = this.il07BDao.viewData(this.txtOPCDBegin, this.txtOPCDEnd);
  }
  
  public IL07BDao getIl07BDao() {
    return this.il07BDao;
  }
  
  public void setIl07BDao(IL07BDao il07bDao) {
    this.il07BDao = il07bDao;
  }
  
  public List<IL07B> getQueryList() {
    return this.queryList;
  }
  
  public void setQueryList(List<IL07B> queryList) {
    this.queryList = queryList;
  }
  
  public String getTxtOPCDBegin() {
    return this.txtOPCDBegin;
  }
  
  public void setTxtOPCDBegin(String txtOPCDBegin) {
    this.txtOPCDBegin = txtOPCDBegin;
  }
  
  public String getTxtOPCDEnd() {
    return this.txtOPCDEnd;
  }
  
  public void setTxtOPCDEnd(String txtOPCDEnd) {
    this.txtOPCDEnd = txtOPCDEnd;
  }
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
  }
  
  public String getTxtOPCD() {
    return this.txtOPCD;
  }
  
  public void setTxtOPCD(String txtOPCD) {
    this.txtOPCD = txtOPCD;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL07B02U02.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */