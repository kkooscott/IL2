package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import org.apache.log4j.Logger;
import tw.gov.npa.il.dao.CW09ADAO;
import tw.gov.npa.il.dao.IltbAnnounceDAO;
import tw.gov.npa.il.entity.basic.TbAnnounce;

public class IL09AAction extends ActionSupport {
  private static Logger logger = Logger.getLogger(IL09AAction.class);
  
  IltbAnnounceDAO iltbAnnounceDAO = new IltbAnnounceDAO();
  
  private List<TbAnnounce> nAnnounce;
  
  private List<TbAnnounce> sAnnounce;
  
  private CW09ADAO cw09ADAO;
  
  public CW09ADAO getCw09ADAO() {
    return this.cw09ADAO;
  }
  
  public void setCw09ADAO(CW09ADAO cw09adao) {
    this.cw09ADAO = cw09adao;
  }
  
  public String toCW09A01Q() {
    logger.info("Enter toCW09A01Q");
    this.nAnnounce = this.cw09ADAO.find("1");
    this.sAnnounce = this.cw09ADAO.find("2");
    logger.info("nAnnounce " + this.nAnnounce.toString());
    logger.info("sAnnounce " + this.sAnnounce.toString());
    System.out.println("nAnnounce " + this.nAnnounce.size());
    System.out.println("sAnnounce " + this.sAnnounce.size());
    return "success";
  }
  
  public List<TbAnnounce> getNAnnounce() {
    return this.nAnnounce;
  }
  
  public void setNAnnounce(List<TbAnnounce> nAnnounce) {
    this.nAnnounce = nAnnounce;
  }
  
  public List<TbAnnounce> getSAnnounce() {
    return this.sAnnounce;
  }
  
  public void setSAnnounce(List<TbAnnounce> sAnnounce) {
    this.sAnnounce = sAnnounce;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL09AAction.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */