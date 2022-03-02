package tw.gov.npa.il.decorator;

import org.apache.log4j.Logger;
import org.displaytag.decorator.TableDecorator;
import tw.gov.npa.il.dao.IltbAnnounce;
import tw.gov.npa.il.util.DateUtils;

public class CW09B01Decorator extends TableDecorator {
  private static final Logger logger = Logger.getLogger(CW09B01Decorator.class);
  
  public String getSid() {
    IltbAnnounce announce = (IltbAnnounce)getCurrentRowObject();
    String sid = Integer.toString(announce.getIlAnnNo().intValue());
    return sid;
  }
  
  public String getSelect() {
    StringBuilder sb = new StringBuilder();
    sb.append("<input id=\"GridView1_chkRow_1\" type=\"checkbox\" name=\"GridView1$ctl03$chkRow\" />");
    return sb.toString();
  }
  
  public String getContent() {
    IltbAnnounce announce = (IltbAnnounce)getCurrentRowObject();
    String content = announce.getIlContent();
    String no = Integer.toString(announce.getIlAnnNo().intValue());
    StringBuilder sb = new StringBuilder();
    sb.append(" <a href=\"toCW09B03U.action?no=");
    sb.append(no);
    sb.append("\">");
    sb.append(content);
    sb.append("</a>");
    logger.info("content: " + sb.toString());
    return sb.toString();
  }
  
  public String getBeginDate() {
    IltbAnnounce announce = (IltbAnnounce)getCurrentRowObject();
    String beginDate = DateUtils.getDate(announce.getIlBeginDt());
    return beginDate;
  }
  
  public String getEndDate() {
    IltbAnnounce announce = (IltbAnnounce)getCurrentRowObject();
    String endDate = DateUtils.getDate(announce.getIlEndDt());
    return endDate;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\decorator\CW09B01Decorator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */