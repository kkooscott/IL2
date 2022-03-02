package tw.gov.npa.il.decorator;

import org.apache.log4j.Logger;
import org.displaytag.decorator.TableDecorator;
import tw.gov.npa.il.entity.IL07D;

public class IL07DDecorator extends TableDecorator {
	private static final Logger logger = Logger.getLogger(IL07DDecorator.class);

	public String getSRCHST() {
		IL07D il07D = (IL07D) getCurrentRowObject();
		String SRCHST = il07D.getSRCHST();
		return SRCHST;
	}

	public String getSRCHSTNM() {
		IL07D il07D = (IL07D) getCurrentRowObject();
		String SRCHSTNM = il07D.getSRCHSTNM();
		return SRCHSTNM;
	}

	public String getFunction() {
		StringBuilder sb = new StringBuilder();
		sb.append("<input type=\"radio\" id=\"optNo\" name=\"optNo\" >");
		return sb.toString();
	}
}
