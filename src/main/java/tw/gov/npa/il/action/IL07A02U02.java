package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import tw.gov.npa.il.entity.IL07A;
import tw.gov.npa.il.myDao.IL07ADao;

public class IL07A02U02 extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL07A02U02.class);
  
  private Date nowDate = new Date();
  
  private IL07ADao il07ADao;
  
  private List<IL07A> queryList;
  
  private String txtNTCDBegin;
  
  private String txtNTCDEnd;
  
  private String txtNTCD;
  
  public String toMain() throws Exception {
    doRealQuery();
    return "success";
  }
  
  private void doRealQuery() {
    this.queryList = this.il07ADao.viewData(this.txtNTCDBegin, this.txtNTCDEnd);
  }
  
  public IL07ADao getIl07ADao() {
    return this.il07ADao;
  }
  
  public void setIl07ADao(IL07ADao il07aDao) {
    this.il07ADao = il07aDao;
  }
  
  public List<IL07A> getQueryList() {
    return this.queryList;
  }
  
  public void setQueryList(List<IL07A> queryList) {
    this.queryList = queryList;
  }
  
  public String getTxtNTCDBegin() {
    return this.txtNTCDBegin;
  }
  
  public void setTxtNTCDBegin(String txtNTCDBegin) {
    this.txtNTCDBegin = txtNTCDBegin;
  }
  
  public String getTxtNTCDEnd() {
    return this.txtNTCDEnd;
  }
  
  public void setTxtNTCDEnd(String txtNTCDEnd) {
    this.txtNTCDEnd = txtNTCDEnd;
  }
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
  }
  
  public String getTxtNTCD() {
    return this.txtNTCD;
  }
  
  public void setTxtNTCD(String txtNTCD) {
    this.txtNTCD = txtNTCD;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL07A02U02.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */