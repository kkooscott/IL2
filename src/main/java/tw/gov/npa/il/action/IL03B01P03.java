package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import tw.gov.npa.il.dao.Iltb20OnlineReport;
import tw.gov.npa.il.dao.Iltb20OnlineReportId;
import tw.gov.npa.il.e0db.myDao.MyE0dtNpaunitDAO;
import tw.gov.npa.il.myDao.MyIltb20OnlineReportDAO;
import tw.gov.npa.il.util.GetDateUtil;
import tw.gov.npa.il.util.NTPCUtil;

public class IL03B01P03 extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL03B01P03.class);
  
  public String toMain() throws Exception {
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpSession session = request.getSession();
    HttpSession session1 = ServletActionContext.getRequest().getSession();
    String LOGUIP = (session1.getAttribute("LOGUIP") == null) ? "" : session1.getAttribute("LOGUIP").toString().trim();
    String LOGDIDCN = (session1.getAttribute("LOGDIDCN") == null) ? "" : session1.getAttribute("LOGDIDCN").toString().trim();
    String LOGUID = (session1.getAttribute("LOGUID") == null) ? "" : session1.getAttribute("LOGUID").toString().trim();
    this.ilPstName = this.myE0dtNpaunitDAO.findById(this.ilPst).getE0FullSNm();
    String[] ilPstArr = this.ntpcUtil.getOlderE0UnitCdByNewE0UnitCd(this.ilPst.trim());
    String ilPstextName = "";
    if ("".equals(this.ilPstext) || this.ilPstext == null) {
      ilPstextName = "全部";
    } else {
      ilPstextName = this.ilPstext;
    } 
    String unitName = this.myE0dtNpaunitDAO.findById(ilPstArr[0]).getE0FullSNm() + "(郵遞區號:" + this.ilZipFullNameList.replace("　", "") + ")" + ilPstextName;
    String reportId = "01";
    String ilUid = (String)session.getAttribute("LOGUID");
    if (ilUid == null)
      ilUid = "testLogin"; 
    spellString();
    Iltb20OnlineReport report = new Iltb20OnlineReport();
    Iltb20OnlineReportId id = new Iltb20OnlineReportId(LOGUID, reportId, new Timestamp(System.currentTimeMillis()));
    report.setId(id);
    report.setIlDidnm(LOGDIDCN);
    report.setIlIp(LOGUIP);
    report.setIlRptamt(Short.valueOf((short)0));
    report.setIlRptfn(reportId + LOGUID);
    report.setIlRptnm(unitName + " 外責區  自由檢索報表");
    report.setIlRundt(new Timestamp(System.currentTimeMillis()));
    report.setIlShow("");
    report.setIlStatus("0");
    report.setIlWhere1(this.whereCommand1);
    report.setIlWhere2(this.whereCommand2);
    report.setIlModified(new Timestamp(System.currentTimeMillis()));
    MyIltb20OnlineReportDAO dao = new MyIltb20OnlineReportDAO();
    dao.update(report);
    request.setAttribute("report", report);
    return "success";
  }
  
  public void spellString() {
    StringBuffer sql = new StringBuffer();
    if (this.PHQPST != null && !this.PHQPST.equals("")) {
      String[] ilPstArr = this.ntpcUtil.getOlderE0UnitCdByNewE0UnitCd(this.PHQPST);
      sql.append("(");
      for (int i = 0; i < ilPstArr.length; i++) {
        if (i == 0) {
          sql.append("IL_PHQ='" + ilPstArr[i] + "'");
        } else {
          sql.append(" OR IL_PHQ='" + ilPstArr[i] + "'");
        } 
      } 
      sql.append(") AND ");
    } 
    if (this.ilZipCode != null && !this.ilZipCode.equals("")) {
      String[] ilZipCodeArr = this.ntpcUtil.getSplitZipCode(this.ilZipCode);
      sql.append("(");
      for (int i = 0; i < ilZipCodeArr.length; i++) {
        if (i == 0)
          sql.append("IL_ARPZONE in (" + this.ilZipCodeList + ")"); 
      } 
      sql.append(") AND ");
    } 
    if (this.PSTEXT != null && !this.PSTEXT.equals(""))
      sql.append("IL_PSTEXT = '").append(this.PSTEXT).append("' and "); 
    if (this.txtBTHD_FROM != null && !this.txtBTHD_FROM.equals(""))
      sql.append("rtrim(IL_BTHDT) >= '").append(this.getDateUtil.getNoSpiltDate(this.txtBTHD_FROM)).append("' and "); 
    if (this.txtBTHD_TO != null && !this.txtBTHD_TO.equals(""))
      sql.append("rtrim(IL_BTHDT) <= '").append(this.getDateUtil.getNoSpiltDate(this.txtBTHD_TO)).append("' and "); 
    if (this.SEX != null && !this.SEX.equals(""))
      sql.append("IL_SEX = '").append(this.SEX).append("' and "); 
    if (this.ARCST_LIST != null && !this.ARCST_LIST.equals(""))
      sql.append("IL_ARCST in (").append(this.ARCST_LIST).append(") and "); 
    if (this.OP_LIST != null && !this.OP_LIST.equals(""))
      sql.append("IL_JBCD in (").append(this.OP_LIST).append(") and "); 
    if (this.NT_LIST != null && !this.NT_LIST.equals(""))
      sql.append("IL_NTCD in (").append(this.NT_LIST).append(") and "); 
    if (this.UV != null && !this.UV.equals(""))
      sql.append("IL_OFCD = '").append(this.UV).append("' and "); 
    if (this.txtARC_FROM != null && !this.txtARC_FROM.equals(""))
      sql.append("IL_ARCTO >= '").append(this.getDateUtil.getSepSpiltDateStart(this.txtARC_FROM)).append("' and "); 
    if (this.txtARC_TO != null && !this.txtARC_TO.equals(""))
      sql.append("IL_ARCTO <= '").append(this.getDateUtil.getSepSpiltDateStart(this.txtARC_TO)).append("' and "); 
    if (this.EDU_LIST != null && !this.EDU_LIST.equals(""))
      sql.append("IL_EDU in (").append(this.EDU_LIST).append(") and "); 
    if (this.MST != null && !this.MST.equals(""))
      sql.append("IL_MST = '").append(this.MST).append("' and "); 
    if (this.FRCEXIT != null && !this.FRCEXIT.equals(""))
      sql.append("IL_FRCEXIT = '").append(this.FRCEXIT).append("' and "); 
    if (this.txtAPY_FROM != null && !this.txtAPY_FROM.equals(""))
      sql.append("IL_APYDT >= '").append(this.getDateUtil.getSepSpiltDateStart(this.txtAPY_FROM)).append("' and "); 
    if (this.txtAPY_TO != null && !this.txtAPY_TO.equals(""))
      sql.append("IL_APYDT <= '").append(this.getDateUtil.getSepSpiltDateStart(this.txtAPY_TO)).append("' and "); 
    if (this.FBDRSN != null && !this.FBDRSN.equals(""))
      sql.append("IL_FBDRSN = '").append(this.FBDRSN).append("' and "); 
    if (this.txtREAPY_FROM != null && !this.txtREAPY_FROM.equals(""))
      sql.append("IL_REAPYDT >= '").append(this.getDateUtil.getSepSpiltDateStart(this.txtREAPY_FROM)).append("' and "); 
    if (this.txtREAPY_TO != null && !this.txtREAPY_TO.equals(""))
      sql.append("IL_REAPYDT <= '").append(this.getDateUtil.getSepSpiltDateStart(this.txtREAPY_TO)).append("' and "); 
    if (this.SRCHST != null && !this.SRCHST.equals(""))
      sql.append("IL_SRCHST = '").append(this.SRCHST).append("' and "); 
    if (this.txtMISS_FROM != null && !this.txtMISS_FROM.equals(""))
      sql.append("IL_MISSDT >= '").append(this.getDateUtil.getSepSpiltDateStart(this.txtMISS_FROM)).append("' and "); 
    if (this.txtMISS_TO != null && !this.txtMISS_TO.equals(""))
      sql.append("IL_MISSDT <= '").append(this.getDateUtil.getSepSpiltDateStart(this.txtMISS_TO)).append("' and "); 
    if (this.txtSBMT_FROM != null && !this.txtSBMT_FROM.equals(""))
      sql.append("IL_SBMTDT >= '").append(this.getDateUtil.getSepSpiltDateStart(this.txtSBMT_FROM)).append("' and "); 
    if (this.txtSBMT_TO != null && !this.txtSBMT_TO.equals(""))
      sql.append("IL_SBMTDT <= '").append(this.getDateUtil.getSepSpiltDateStart(this.txtSBMT_TO)).append("' and "); 
    if (this.FNDDID != null && !this.FNDDID.equals(""))
      sql.append("IL_FNDDID = '").append(this.FNDDID).append("' and "); 
    if (this.txtFIND_FROM != null && !this.txtFIND_FROM.equals(""))
      sql.append("IL_FNDDT >= '").append(this.getDateUtil.getSepSpiltDateStart(this.txtFIND_FROM)).append("' and "); 
    if (this.txtFIND_TO != null && !this.txtFIND_TO.equals(""))
      sql.append("IL_FNDDT <= '").append(this.getDateUtil.getSepSpiltDateStart(this.txtFIND_TO)).append("' and "); 
    if (this.txtIN_FROM != null && !this.txtIN_FROM.equals(""))
      sql.append("IL_INDT >= '").append(this.getDateUtil.getSepSpiltDateStart(this.txtIN_FROM)).append("' and "); 
    if (this.txtIN_TO != null && !this.txtIN_TO.equals(""))
      sql.append("IL_INDT <= '").append(this.getDateUtil.getSepSpiltDateStart(this.txtIN_TO)).append("' and "); 
    if (this.txtEXIT_FROM != null && !this.txtEXIT_FROM.equals(""))
      sql.append("IL_EXDT >= '").append(this.getDateUtil.getSepSpiltDateStart(this.txtEXIT_FROM)).append("' and "); 
    if (this.txtEXIT_TO != null && !this.txtEXIT_TO.equals(""))
      sql.append("IL_EXDT <= '").append(this.getDateUtil.getSepSpiltDateStart(this.txtEXIT_TO)).append("' and "); 
    String whereCommand = "";
    if (sql.length() > 0)
      whereCommand = sql.substring(0, sql.length() - 4); 
    if (whereCommand.length() >= 600) {
      this.whereCommand1 = whereCommand.substring(0, 600);
      this.whereCommand2 = whereCommand.substring(600);
    } else {
      this.whereCommand1 = whereCommand;
    } 
    System.out.println("IL03B01P03 whereCommand:" + this.whereCommand1 + this.whereCommand2);
  }
  
  public String toQuery() throws Exception {
    return "success";
  }
  
  NTPCUtil ntpcUtil = new NTPCUtil();
  
  MyE0dtNpaunitDAO myE0dtNpaunitDAO = new MyE0dtNpaunitDAO();
  
  private List<Iltb20OnlineReport> iltb20IdList;
  
  private GetDateUtil getDateUtil = new GetDateUtil();
  
  private Date nowDate = new Date();
  
  private String ilPst;
  
  private String ilZipCode;
  
  private String ilZipCodeName;
  
  private String ilPstext;
  
  private String ilPstName;
  
  private String whereCommand1;
  
  private String whereCommand2;
  
  private String PHQPST;
  
  private String PSTEXT;
  
  private String txtBTHD_FROM;
  
  private String txtBTHD_TO;
  
  private String SEX;
  
  private String ARCST;
  
  private String ARCST_LIST;
  
  private String OP;
  
  private String OP_LIST;
  
  private String NT;
  
  private String NT_LIST;
  
  private String UV;
  
  private String txtARC_FROM;
  
  private String txtARC_TO;
  
  private String EDU;
  
  private String EDU_LIST;
  
  private String MST;
  
  private String FRCEXIT;
  
  private String txtAPY_FROM;
  
  private String txtAPY_TO;
  
  private String FBDRSN;
  
  private String txtREAPY_FROM;
  
  private String txtREAPY_TO;
  
  private String SRCHST;
  
  private String txtMISS_FROM;
  
  private String txtMISS_TO;
  
  private String txtSBMT_FROM;
  
  private String txtSBMT_TO;
  
  private String FNDDID;
  
  private String txtFIND_FROM;
  
  private String txtFIND_TO;
  
  private String txtIN_FROM;
  
  private String txtIN_TO;
  
  private String txtEXIT_FROM;
  
  private String txtEXIT_TO;
  
  private String MANTYPE;
  
  private String ilZipCodeList;
  
  private String ilZipFullNameList;
  
  public String getWhereCommand1() {
    return this.whereCommand1;
  }
  
  public void setWhereCommand1(String whereCommand1) {
    this.whereCommand1 = whereCommand1;
  }
  
  public String getWhereCommand2() {
    return this.whereCommand2;
  }
  
  public void setWhereCommand2(String whereCommand2) {
    this.whereCommand2 = whereCommand2;
  }
  
  public String getPHQPST() {
    return this.PHQPST;
  }
  
  public void setPHQPST(String pHQPST) {
    this.PHQPST = pHQPST;
  }
  
  public String getPSTEXT() {
    return this.PSTEXT;
  }
  
  public void setPSTEXT(String pSTEXT) {
    this.PSTEXT = pSTEXT;
  }
  
  public String getTxtBTHD_FROM() {
    return this.txtBTHD_FROM;
  }
  
  public void setTxtBTHD_FROM(String txtBTHD_FROM) {
    this.txtBTHD_FROM = txtBTHD_FROM;
  }
  
  public String getTxtBTHD_TO() {
    return this.txtBTHD_TO;
  }
  
  public void setTxtBTHD_TO(String txtBTHD_TO) {
    this.txtBTHD_TO = txtBTHD_TO;
  }
  
  public String getSEX() {
    return this.SEX;
  }
  
  public void setSEX(String sEX) {
    this.SEX = sEX;
  }
  
  public String getARCST() {
    return this.ARCST;
  }
  
  public void setARCST(String aRCST) {
    this.ARCST = aRCST;
  }
  
  public String getARCST_LIST() {
    return this.ARCST_LIST;
  }
  
  public void setARCST_LIST(String aRCST_LIST) {
    this.ARCST_LIST = aRCST_LIST;
  }
  
  public String getOP() {
    return this.OP;
  }
  
  public void setOP(String oP) {
    this.OP = oP;
  }
  
  public String getOP_LIST() {
    return this.OP_LIST;
  }
  
  public void setOP_LIST(String oP_LIST) {
    this.OP_LIST = oP_LIST;
  }
  
  public String getNT() {
    return this.NT;
  }
  
  public void setNT(String nT) {
    this.NT = nT;
  }
  
  public String getNT_LIST() {
    return this.NT_LIST;
  }
  
  public void setNT_LIST(String nT_LIST) {
    this.NT_LIST = nT_LIST;
  }
  
  public String getUV() {
    return this.UV;
  }
  
  public void setUV(String uV) {
    this.UV = uV;
  }
  
  public String getTxtARC_FROM() {
    return this.txtARC_FROM;
  }
  
  public void setTxtARC_FROM(String txtARC_FROM) {
    this.txtARC_FROM = txtARC_FROM;
  }
  
  public String getTxtARC_TO() {
    return this.txtARC_TO;
  }
  
  public void setTxtARC_TO(String txtARC_TO) {
    this.txtARC_TO = txtARC_TO;
  }
  
  public String getEDU() {
    return this.EDU;
  }
  
  public void setEDU(String eDU) {
    this.EDU = eDU;
  }
  
  public String getEDU_LIST() {
    return this.EDU_LIST;
  }
  
  public void setEDU_LIST(String eDU_LIST) {
    this.EDU_LIST = eDU_LIST;
  }
  
  public String getMST() {
    return this.MST;
  }
  
  public void setMST(String mST) {
    this.MST = mST;
  }
  
  public String getFRCEXIT() {
    return this.FRCEXIT;
  }
  
  public void setFRCEXIT(String fRCEXIT) {
    this.FRCEXIT = fRCEXIT;
  }
  
  public String getTxtAPY_FROM() {
    return this.txtAPY_FROM;
  }
  
  public void setTxtAPY_FROM(String txtAPY_FROM) {
    this.txtAPY_FROM = txtAPY_FROM;
  }
  
  public String getTxtAPY_TO() {
    return this.txtAPY_TO;
  }
  
  public void setTxtAPY_TO(String txtAPY_TO) {
    this.txtAPY_TO = txtAPY_TO;
  }
  
  public String getFBDRSN() {
    return this.FBDRSN;
  }
  
  public void setFBDRSN(String fBDRSN) {
    this.FBDRSN = fBDRSN;
  }
  
  public String getTxtREAPY_FROM() {
    return this.txtREAPY_FROM;
  }
  
  public void setTxtREAPY_FROM(String txtREAPY_FROM) {
    this.txtREAPY_FROM = txtREAPY_FROM;
  }
  
  public String getTxtREAPY_TO() {
    return this.txtREAPY_TO;
  }
  
  public void setTxtREAPY_TO(String txtREAPY_TO) {
    this.txtREAPY_TO = txtREAPY_TO;
  }
  
  public String getSRCHST() {
    return this.SRCHST;
  }
  
  public void setSRCHST(String sRCHST) {
    this.SRCHST = sRCHST;
  }
  
  public String getTxtMISS_FROM() {
    return this.txtMISS_FROM;
  }
  
  public void setTxtMISS_FROM(String txtMISS_FROM) {
    this.txtMISS_FROM = txtMISS_FROM;
  }
  
  public String getTxtMISS_TO() {
    return this.txtMISS_TO;
  }
  
  public void setTxtMISS_TO(String txtMISS_TO) {
    this.txtMISS_TO = txtMISS_TO;
  }
  
  public String getTxtSBMT_FROM() {
    return this.txtSBMT_FROM;
  }
  
  public void setTxtSBMT_FROM(String txtSBMT_FROM) {
    this.txtSBMT_FROM = txtSBMT_FROM;
  }
  
  public String getTxtSBMT_TO() {
    return this.txtSBMT_TO;
  }
  
  public void setTxtSBMT_TO(String txtSBMT_TO) {
    this.txtSBMT_TO = txtSBMT_TO;
  }
  
  public String getFNDDID() {
    return this.FNDDID;
  }
  
  public void setFNDDID(String fNDDID) {
    this.FNDDID = fNDDID;
  }
  
  public String getTxtFIND_FROM() {
    return this.txtFIND_FROM;
  }
  
  public void setTxtFIND_FROM(String txtFIND_FROM) {
    this.txtFIND_FROM = txtFIND_FROM;
  }
  
  public String getTxtFIND_TO() {
    return this.txtFIND_TO;
  }
  
  public void setTxtFIND_TO(String txtFIND_TO) {
    this.txtFIND_TO = txtFIND_TO;
  }
  
  public String getTxtIN_FROM() {
    return this.txtIN_FROM;
  }
  
  public void setTxtIN_FROM(String txtIN_FROM) {
    this.txtIN_FROM = txtIN_FROM;
  }
  
  public String getTxtIN_TO() {
    return this.txtIN_TO;
  }
  
  public void setTxtIN_TO(String txtIN_TO) {
    this.txtIN_TO = txtIN_TO;
  }
  
  public String getTxtEXIT_FROM() {
    return this.txtEXIT_FROM;
  }
  
  public void setTxtEXIT_FROM(String txtEXIT_FROM) {
    this.txtEXIT_FROM = txtEXIT_FROM;
  }
  
  public String getTxtEXIT_TO() {
    return this.txtEXIT_TO;
  }
  
  public void setTxtEXIT_TO(String txtEXIT_TO) {
    this.txtEXIT_TO = txtEXIT_TO;
  }
  
  public String getMANTYPE() {
    return this.MANTYPE;
  }
  
  public void setMANTYPE(String mANTYPE) {
    this.MANTYPE = mANTYPE;
  }
  
  public String getIlPst() {
    return this.ilPst;
  }
  
  public void setIlPst(String ilPst) {
    this.ilPst = ilPst;
  }
  
  public String getIlZipCodeName() {
    return this.ilZipCodeName;
  }
  
  public void setIlZipCodeName(String ilZipCodeName) {
    this.ilZipCodeName = ilZipCodeName;
  }
  
  public String getIlZipCode() {
    return this.ilZipCode;
  }
  
  public void setIlZipCode(String ilZipCode) {
    this.ilZipCode = ilZipCode;
  }
  
  public String getIlZipCodeList() {
    return this.ilZipCodeList;
  }
  
  public void setIlZipCodeList(String ilZipCodeList) {
    this.ilZipCodeList = ilZipCodeList;
  }
  
  public String getIlZipFullNameList() {
    return this.ilZipFullNameList;
  }
  
  public void setIlZipFullNameList(String ilZipFullNameList) {
    this.ilZipFullNameList = ilZipFullNameList;
  }
  
  public String getIlPstext() {
    return this.ilPstext;
  }
  
  public void setIlPstext(String ilPstext) {
    this.ilPstext = ilPstext;
  }
  
  public String getIlPstName() {
    return this.ilPstName;
  }
  
  public void setIlPstName(String ilPstName) {
    this.ilPstName = ilPstName;
  }
  
  public List<Iltb20OnlineReport> getIltb20IdList() {
    return this.iltb20IdList;
  }
  
  public void setIltb20IdList(List<Iltb20OnlineReport> iltb20IdList) {
    this.iltb20IdList = iltb20IdList;
  }
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL03B01P03.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */