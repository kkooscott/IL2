package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import tw.gov.npa.il.entity.IL07C;
import tw.gov.npa.il.myDao.IL07CDao;

public class IL07C03D02 extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL07C03D02.class);
  
  private Date nowDate = new Date();
  
  private IL07CDao il07CDao;
  
  private List<IL07C> queryList;
  
  private String txtUVCDBegin;
  
  private String txtUVCDEnd;
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
  }
  
  public String toMain() throws Exception {
    doRealQuery();
    return "success";
  }
  
  private void doRealQuery() {
    this.queryList = this.il07CDao.viewData(this.txtUVCDBegin, this.txtUVCDEnd);
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
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL07C03D02.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */