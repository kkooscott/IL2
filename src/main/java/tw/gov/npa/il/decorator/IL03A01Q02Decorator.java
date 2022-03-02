package tw.gov.npa.il.decorator;

import org.apache.log4j.Logger;
import org.displaytag.decorator.TableDecorator;
import tw.gov.npa.il.action.bean.IL03A01Q02Bean;
import tw.gov.npa.il.util.GetDateUtil;

public class IL03A01Q02Decorator extends TableDecorator {
	private static final Logger logger = Logger.getLogger(IL03A01Q02Decorator.class);

	public int getId() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		int result = bean.getId();
		return result;
	}

	public int getIlArcid() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		int result = bean.getIlArcid();
		return result;
	}

	public String getIlPspt() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlPspt();
		return result;
	}

	public String getIlNTNM() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlNTNM();
		return result;
	}

	public String getIlNtcd() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlNtcd();
		return result;
	}

	public String getIlEnm() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlEnm();
		return result;
	}

	public String getIlBthdt() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlBthdt();
		return (new GetDateUtil()).getNoSpiltToSpiltDate(result);
	}

	public String getIlArctp() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlArctp();
		return result;
	}

	public String getIlArccs() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlArccs();
		return result;
	}

	public String getIlCnm() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlCnm();
		return result;
	}

	public String getIlSex() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlSex();
		return result;
	}

	public String getIlPsdt() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlPsdt();
		return result;
	}

	public String getIlMst() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlMst();
		return result;
	}

	public String getIlEdu() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlEdu();
		return result;
	}

	public String getIlIndt() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlIndt();
		return (new GetDateUtil()).getNoSpiltToSpiltDate(result);
	}

	public String getIlExdt() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlExdt();
		return (new GetDateUtil()).getNoSpiltToSpiltDate(result);
	}

	public String getIlArcrsn() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlArcrsn();
		return result;
	}

	public String getIlArcst() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlBthdt();
		return result;
	}

	public String getIlJbcd() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlArcst();
		return result;
	}

	public String getIlJbpsn() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlJbpsn();
		return result;
	}

	public String getIlOfcd() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlOfcd();
		return result;
	}

	public String getIlOfnm() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlOfnm();
		return result;
	}

	public String getIlOftel() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlOftel();
		return result;
	}

	public String getIlOfnmbf() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlOfnmbf();
		return result;
	}

	public String getIlJbpzone() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlJbpzone();
		return result;
	}

	public String getIlJbaddr() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlJbaddr();
		return result;
	}

	public String getIlJbtel() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlJbtel();
		return result;
	}

	public String getIlArpzone() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlArpzone();
		return result;
	}

	public String getIlAraddr() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlAraddr();
		return result;
	}

	public String getIlArtel() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlArtel();
		return result;
	}

	public String getIlAgnco() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlAgnco();
		return result;
	}

	public String getIlAgntel() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlAgntel();
		return result;
	}

	public String getIlJbpmcd() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlJbpmcd();
		return result;
	}

	public String getIlJbpmdc() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlJbpmdc();
		return result;
	}

	public String getIlJbpmdt() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlJbpmdt();
		return (new GetDateUtil()).getNoSpiltToSpiltDate(result);
	}

	public String getIlJbpmfm() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlJbpmfm();
		return (new GetDateUtil()).getNoSpiltToSpiltDate(result);
	}

	public String getIlJbpmto() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlJbpmto();
		return (new GetDateUtil()).getNoSpiltToSpiltDate(result);
	}

	public String getIlMicro() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlMicro();
		return result;
	}

	public String getIlApydt() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlApydt();
		return (new GetDateUtil()).getNoSpiltToSpiltDate(result);
	}

	public String getIlArcrcp() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlArcrcp();
		return result;
	}

	public String getIlArcno() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlArcno();
		return result;
	}

	public String getIlArcfm() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlArcfm();
		return (new GetDateUtil()).getNoSpiltToSpiltDate(result);
	}

	public String getIlArcto() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlArcto();
		return (new GetDateUtil()).getNoSpiltToSpiltDate(result);
	}

	public String getIlPst() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlPst();
		return result;
	}

	public String getIlPhq() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlPhq();
		return result;
	}

	public String getIlPstext() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlPstext();
		return result;
	}

	public String getIlRemrk() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlRemrk();
		return result;
	}

	public String getIlArcisu() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlArcisu();
		return result;
	}

	public String getIlFrshp() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlFrshp();
		return result;
	}

	public String getIlFnm() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlFnm();
		return result;
	}

	public String getIlFpid() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlFpid();
		return result;
	}

	public String getIlFntcd() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlFntcd();
		return result;
	}

	public String getIlFrcexit() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlFrcexit();
		return result;
	}

	public String getIlReapydt() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlReapydt();
		return (new GetDateUtil()).getNoSpiltToSpiltDate(result);
	}

	public String getIlRetp() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlRetp();
		return result;

	}

	public String getIlRepmdc() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlRepmdc();
		return result;
	}

	public String getIlRepmdt() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlRepmdt();
		return (new GetDateUtil()).getNoSpiltToSpiltDate(result);
	}

	public String getIlRrnote() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlRrnote();
		return result;
	}

	public String getIlMrkcs() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlMrkcs();
		return result;
	}

	public String getIlFbdrsn() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlFbdrsn();
		return result;
	}

	public String getIlMrkdt() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlMrkdt();
		return (new GetDateUtil()).getNoSpiltToSpiltDate(result);
	}

	public String getIlMrkdc() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlMrkdc();
		return result;
	}

	public String getIlSbmttp() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlSbmttp();
		return result;
	}

	public String getIlMissdt() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlMissdt();
		return (new GetDateUtil()).getNoSpiltToSpiltDate(result);

	}

	public String getIlSbmtdt() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlSbmtdt();
		return (new GetDateUtil()).getNoSpiltToSpiltDate(result);
	}

	public String getIlSrchst() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlSrchst();
		return result;
	}

	public String getIlFnddid() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlFnddid();
		return result;
	}

	public String getIlFnddt() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlFnddt();
		return (new GetDateUtil()).getNoSpiltToSpiltDate(result);
	}

	public String getIlOldarc() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlOldarc();
		return result;
	}

	public String getIlHcst() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlHcst();
		return result;
	}

	public String getIlHcctr() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlHcctr();
		return result;
	}

	public String getIlLmd() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlLmd();
		return result;
	}

	public String getIlFstapydt() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlFstapydt();
		return (new GetDateUtil()).getNoSpiltToSpiltDate(result);
	}

	public String getIlRepmdcNic() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlRepmdcNic();
		return result;
	}

	public String getIlForfere() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlForfere();
		return result;
	}

	public String getIl12ArcId() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIl12ArcId();
		return result;
	}

	public String getChkilNTNM() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkilNTNM();
		return result;
	}

	public String getChkARCNO() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkARCNO();
		return result;
	}

	public String getChkPSPT() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkPSPT();
		return result;
	}

	public String getChkENM() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkENM();
		return result;
	}

	public String getChkNTCD() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkNTCD();
		return result;
	}

	public String getChkBTHDT() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkBTHDT();
		return result;
	}

	public String getChkCNM() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkCNM();
		return result;
	}

	public String getChkARCFM() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkARCFM();
		return result;
	}

	public String getChkARCTO() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkARCTO();
		return result;
	}

	public String getChkSEX() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkSEX();
		return result;
	}

	public String getChkJBCD() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkJBCD();
		return result;
	}

	public String getChkARCST() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkARCST();
		return result;
	}

	public String getChkARCRSN() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkARCRSN();
		return result;
	}

	public String getChkEDU() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkEDU();
		return result;
	}

	public String getChkOFCD() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkOFCD();
		return result;
	}

	public String getChkOFNM() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkOFNM();
		return result;
	}

	public String getChkOFTEL() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkOFTEL();
		return result;
	}

	public String getChkJBADDR() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkJBADDR();
		return result;
	}

	public String getChkJBTEL() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkJBTEL();
		return result;
	}

	public String getChkARPZONE() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkARPZONE();
		return result;
	}

	public String getChkARADDR() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkARADDR();
		return result;
	}

	public String getChkARTEL() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkARTEL();
		return result;
	}

	public String getChkPHQ() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkPHQ();
		return result;
	}

	public String getChkPSTEXT() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkPSTEXT();
		return result;
	}

	public String getChkFRSHP() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkFRSHP();
		return result;
	}

	public String getChkFNTCD() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkFNTCD();
		return result;
	}

	public String getChkMISSDT() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkMISSDT();
		return result;
	}

	public String getChkSBMTDT() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkSBMTDT();
		return result;
	}

	public String getChkFNDDT() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkFNDDT();
		return result;
	}

	public String getChkSRCHST() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkSRCHST();
		return result;
	}

	public String getChkINDT() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkINDT();
		return result;
	}

	public String getChkEXDT() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkEXDT();
		return result;
	}

	public String getChkFPID() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkFPID();
		return result;
	}

	public String getChkFNM() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkFNM();
		return result;
	}

	public String getChkAPYDT() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkAPYDT();
		return result;
	}

	public String getChkARCRCP() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkARCRCP();
		return result;
	}

	public String getChkMICRO() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkMICRO();
		return result;
	}

	public String getChkOLDARCNO() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkOLDARCNO();
		return result;
	}

	public String getIlMANTYPE() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getIlMANTYPE();
		return result;
	}

	public String getChkMANTYPE() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		String result = bean.getChkMANTYPE();
		return result;
	}

	public String getFunction() {
		IL03A01Q02Bean bean = (IL03A01Q02Bean) getCurrentRowObject();
		int ilArcid = bean.getIlArcid();
		int id = bean.getId();
		StringBuilder sb = new StringBuilder();
		if (id == 1) {
			sb.append("<input type=\"radio\" id=\"ilArcid\" name=\"ilArcid\" value=\"" + ilArcid + "\" checked >" + id);
		} else {
			sb.append("<input type=\"radio\" id=\"ilArcid\" name=\"ilArcid\" value=\"" + ilArcid + "\" >" + id);
		}
		return sb.toString();
	}
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\decorator\
 * IL03A01Q02Decorator.class Java compiler version: 5 (49.0) JD-Core Version:
 * 1.1.3
 */