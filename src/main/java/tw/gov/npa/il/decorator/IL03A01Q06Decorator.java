package tw.gov.npa.il.decorator;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import org.apache.log4j.Logger;
import org.displaytag.decorator.TableDecorator;
import tw.gov.npa.il.dao.Iltb03MainRecord;
import tw.gov.npa.il.dao.Iltb16JobCode;
import tw.gov.npa.il.myDao.MyIltb16JobCodeDAO;
import tw.gov.npa.il.util.Constant;

public class IL03A01Q06Decorator extends TableDecorator {
//  private static final Logger logger = Logger.getLogger(IL03A01Q06Decorator.class);
  
  Constant constant = new Constant();
  
  public String getIlArccs() {
    SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
    Iltb03MainRecord bean = (Iltb03MainRecord)getCurrentRowObject();
    Timestamp ilApydt = bean.getId().getIlApydt();
    String result = df.format(ilApydt);
    return result;
  }
  
  public String getIlArctp() {
    SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
    Iltb03MainRecord bean = (Iltb03MainRecord)getCurrentRowObject();
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
    if (!"".equals(bean.getIlRetp()) && bean.getIlRetp() != null)
      try {
        sb.append(", 重入國類別：" + (String)this.constant.getIlRetpMap().get(bean.getIlRetp()));
      } catch (Exception e) {} 
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
    String sbstring = sb.toString();
    if (sbstring.startsWith(", "))
      sbstring = sbstring.substring(2); 
    sbstring = sbstring.replace(", ", "<br>");
    return sbstring;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\decorator\IL03A01Q06Decorator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */