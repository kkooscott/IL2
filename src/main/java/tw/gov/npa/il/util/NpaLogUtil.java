package tw.gov.npa.il.util;

import npalog.NPALog4J;
import org.apache.log4j.Logger;
import tw.gov.npa.il.entity.NpaLogEntity;

public class NpaLogUtil {
	private static final Logger logger = Logger.getLogger(NpaLogUtil.class);

	private static Constant constant = new Constant();

	/*
	 * public static int doLogging(NpaLogEntity logEntity) { int rv = -1;
	 * logger.info(":::::: NPA LOG PARAM :::::: " + logEntity.toString()); NPALog4J
	 * npaLog4J = new NPALog4J(); rv =
	 * npaLog4J.logging2(constant.getLogMethod().intValue(), 1,
	 * logEntity.getLogCN(), logEntity.getLogDID(), logEntity.getLogGUIP(),
	 * logEntity.getLogTDT(), Constant.getServername(),
	 * logEntity.getSystemDateTime(), logEntity.getPageName(),
	 * logEntity.getOprClass(), constant.getApName(), logEntity.getQueryRes(),
	 * logEntity.getUpdateRes(), logEntity.getOprName(), logEntity.getOprUnit(),
	 * logEntity.getOprGoal(), logEntity.getOtherQeryStr(),
	 * logEntity.getQueryIdno(), logEntity.getQueryName(),
	 * logEntity.getQueryBthYear(), "", "", logEntity.getContent()); return rv; }
	 */
	public static String doLogging(NpaLogEntity logEntity) {
		String rv = "";
		logger.info(":::::: NPA LOG PARAM :::::: " + logEntity.toString());
		NPALog4J npaLog4J = new NPALog4J();
		rv = npaLog4J.logging(
				logEntity.getLogUID(),
				logEntity.getLogCN(),
				logEntity.getLogDID(),
				logEntity.getLogGUIP(),
				logEntity.getLogTDT(),
				Constant.getServername(),
				logEntity.getSystemDateTime(),
				logEntity.getPageName(),
				logEntity.getOprClass(),
				constant.getApName(),
				logEntity.getQueryRes(),
				logEntity.getUpdateRes(),
				logEntity.getOprName(),
				logEntity.getOprUnit(),
				logEntity.getOprGoal().substring(0, 3),
				logEntity.getOprGoal().substring(3),
				"",
				logEntity.getOtherQeryStr(),
				logEntity.getQueryIdno(),
				logEntity.getQueryName(),
				logEntity.getQueryBthYear(),
				"",
				"",
				"",
				"",
				"",
				logEntity.getContent());
		return rv;
	}

	public static String getOtherContent(String[] strs) {
		String rv = "";
		NPALog4J npaLog4J = new NPALog4J();
		rv = npaLog4J.genQueryXML(strs);
		return rv;
	}

	public static String getUpdateContent(String before, String after) {
		String rv = "";
		NPALog4J npaLog4J = new NPALog4J();
		rv = npaLog4J.genUpdateXML(before, after);
		return rv;
	}
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\i\\util\NpaLogUtil.class
 * Java compiler version: 5 (49.0) JD-Core Version: 1.1.3
 */