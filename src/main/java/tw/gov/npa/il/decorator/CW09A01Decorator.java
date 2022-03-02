package tw.gov.npa.il.decorator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.log4j.Logger;
import org.displaytag.decorator.TableDecorator;
import tw.gov.npa.il.entity.basic.TbAnnounce;
import tw.gov.npa.il.util.CVUtil;

public class CW09A01Decorator extends TableDecorator {
  private static final Logger logger = Logger.getLogger(CW09A01Decorator.class);
  
  private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
  
  public String getContent() {
    TbAnnounce sAnnounce = (TbAnnounce)getCurrentRowObject();
    logger.info("sAnnounce" + sAnnounce.getContent());
    return sAnnounce.getContent();
  }
  
  public String getBeginDate() {
    TbAnnounce sAnnounce = (TbAnnounce)getCurrentRowObject();
    try {
      return CVUtil.getROCYYYMMDD(this.sdf.parse(sAnnounce.getBeginDate()));
    } catch (ParseException e) {
      e.printStackTrace();
      return " ";
    } 
  }
  
  public String getEndDate() {
    TbAnnounce sAnnounce = (TbAnnounce)getCurrentRowObject();
    try {
      return CVUtil.getROCYYYMMDD(this.sdf.parse(sAnnounce.getEndDate()));
    } catch (ParseException e) {
      e.printStackTrace();
      return " ";
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\decorator\CW09A01Decorator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */