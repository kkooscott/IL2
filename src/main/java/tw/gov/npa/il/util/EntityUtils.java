package tw.gov.npa.il.util;

import tw.gov.npa.il.entity.basic.TbAnnounce;
import tw.gov.npa.il.entity.input.cw09b.Input09B;

public class EntityUtils {
  public static Input09B announce2Input(TbAnnounce src) {
    Input09B rv = new Input09B();
    rv.setNo(src.getNo());
    rv.setKind(src.getKind());
    rv.setContent(src.getContent());
    rv.setBeginDate(DateUtils.getDate(src.getBeginDate()));
    rv.setBeginHour(src.getBeginTime().substring(0, 2));
    rv.setBeginMinute(src.getBeginTime().substring(2, 4));
    rv.setEndDate(DateUtils.getDate(src.getEndDate()));
    rv.setEndHour(src.getEndTime().substring(0, 2));
    rv.setEndMinute(src.getEndTime().substring(2, 4));
    rv.setUid(src.getUid());
    rv.setuName(src.getuName());
    rv.setSettingDate(src.getSettingDate());
    rv.setSettingTime(src.getSettingDate());
    rv.setModified(src.getModified());
    return rv;
  }
  
  public static TbAnnounce input2Announce(Input09B src) {
    TbAnnounce rv = new TbAnnounce();
    rv.setNo(src.getNo());
    rv.setKind(src.getKind());
    rv.setContent(src.getContent());
    rv.setBeginDate(DateUtils.getACDate(src.getBeginDate()));
    if (src.getBeginHour() != null && src.getBeginMinute() != null)
      rv.setBeginTime(src.getBeginHour().concat(src.getBeginMinute())); 
    rv.setEndDate(DateUtils.getACDate(src.getEndDate()));
    if (src.getEndHour() != null && src.getEndMinute() != null)
      rv.setEndTime(src.getEndHour().concat(src.getEndMinute())); 
    rv.setUid(src.getUid());
    rv.setuName(src.getuName());
    rv.setSettingDate(src.getSettingDate());
    rv.setSettingTime(src.getSettingTime());
    rv.setModified(src.getModified());
    return rv;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\i\\util\EntityUtils.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */