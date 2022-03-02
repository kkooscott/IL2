package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import tw.gov.npa.il.dao.Iltb15CountryCode;
import tw.gov.npa.il.dao.Iltb15CountryCodeDAO;

public class IL02A01U01 extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL02A01U01.class);
  
  private Date nowDate = new Date();
  
  List<Iltb15CountryCode> iltb15CountryCodeList = new ArrayList<Iltb15CountryCode>();
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public List<Iltb15CountryCode> getIltb15CountryCodeList() {
    return this.iltb15CountryCodeList;
  }
  
  public void setIltb15CountryCodeList(List<Iltb15CountryCode> iltb15CountryCodeList) {
    this.iltb15CountryCodeList = iltb15CountryCodeList;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
  }
  
  public String toMain() throws Exception {
    return "success";
  }
  
  public String toQuery() throws Exception {
    try {
      Iltb15CountryCodeDAO iltb15CountryCodeDAO = new Iltb15CountryCodeDAO();
      this.iltb15CountryCodeList = iltb15CountryCodeDAO.findAll();
    } catch (Exception e) {
      logger.error(e, e);
      e.printStackTrace();
      return "error";
    } 
    return "success";
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL02A01U01.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */