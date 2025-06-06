package tw.gov.npa.il.schedule;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;
import tw.gov.npa.il.dao.Iltb20OnlineReport;
import tw.gov.npa.il.myDao.MyIltb01MainDAO2;
import tw.gov.npa.il.myDao.MyIltb20OnlineReportDAO;
import tw.gov.npa.il.report.IL03B01Report;
import tw.gov.npa.il.report.IL04B01Report;
import tw.gov.npa.il.report.IL04C01Report;
import tw.gov.npa.il.util.WSUtil;

public class ReportScheduler {
	private static final Logger logger = Logger.getLogger(ReportScheduler.class);

	MyIltb20OnlineReportDAO myIltb20OnlineReportDAO = new MyIltb20OnlineReportDAO();

	MyIltb01MainDAO2 myIltb01MainDAO2 = new MyIltb01MainDAO2();

//	ResourceBundle rb = ResourceBundle.getBundle("config");
	
	private WSUtil wsUtil;

//	private int countLimit = Integer.parseInt(this.rb.getString("countLimit").toString());
	private int countLimit = Integer.parseInt("3000");

	public WSUtil getWsUtil() {
		return wsUtil;
	}

	public void setWsUtil(WSUtil wsUtil) {
		this.wsUtil = wsUtil;
	}

	public void scheduleIL03B01() {
		IL03B01Report il03B01Report = new IL03B01Report();
		List<Iltb20OnlineReport> iltb20OnlineReportList = this.myIltb20OnlineReportDAO.queryDataIL03B01UnProcess();
		logger.info("scheduleIL03B01:轄區狀況統計資料 待處理筆數==>" + iltb20OnlineReportList.size());
		for (Iltb20OnlineReport bean : iltb20OnlineReportList) {
			if (!"".equals(bean.getId().getIlRptid()) && bean.getId().getIlRptid() != null) {
				String LOGUID = bean.getId().getIlUid();
				String printUnit = bean.getIlDidnm();
				String unitName = bean.getIlRptnm();
				bean.setIlStatus("2");
				this.myIltb20OnlineReportDAO.goToMerge(bean);
				Integer ilRptid = Integer.valueOf(Integer.parseInt(bean.getId().getIlRptid()));
				StringBuffer whereConditionBuffer = new StringBuffer();
				if (bean.getIlWhere1() != null && !"".equals(bean.getIlWhere1()) && !"NULL".equals(bean.getIlWhere1()))
					whereConditionBuffer.append(bean.getIlWhere1().trim());
				if (bean.getIlWhere2() != null && !"".equals(bean.getIlWhere2()) && !"NULL".equals(bean.getIlWhere2()))
					whereConditionBuffer.append(bean.getIlWhere2().trim());
				if (bean.getIlWhere3() != null && !"".equals(bean.getIlWhere3()) && !"NULL".equals(bean.getIlWhere3()))
					whereConditionBuffer.append(bean.getIlWhere3().trim());
				if (bean.getIlWhere4() != null && !"".equals(bean.getIlWhere4()) && !"NULL".equals(bean.getIlWhere4()))
					whereConditionBuffer.append(bean.getIlWhere4().trim());
				String whereCondition = whereConditionBuffer.toString();
				switch (ilRptid.intValue()) {
				case 1:
					logger.info("01轄區狀況統計資料-自由檢索報表Start" + new Date());
					try {
						int cnt = this.myIltb01MainDAO2.getCountByQuery(whereCondition);
						if (cnt > this.countLimit) {
							bean.setIlStatus("7");
							this.myIltb20OnlineReportDAO.goToMerge(bean);
							continue;
						}
						il03B01Report.IL03B01P01_1P(whereCondition, LOGUID, unitName, printUnit);
						IL04C01Report il04C01Report = new IL04C01Report();
						logger.info("create txt...");
						il04C01Report.IL04C01_01(whereCondition, ",1,3,4,5,7,8,9,10,12,15,17,18,20,21,",
								bean.getId().getIlRptid() + bean.getId().getIlUid());
						logger.info("ok!");
						logger.info("create csv...");
						il04C01Report.IL04C01_01_csv(whereCondition, ",1,3,4,5,7,8,9,10,12,15,17,18,20,21,",
								bean.getId().getIlRptid() + bean.getId().getIlUid());
						logger.info("ok!");
						bean.setIlStatus("1");
						this.myIltb20OnlineReportDAO.goToMerge(bean);
					} catch (Exception e) {
						e.printStackTrace();
						bean.setIlStatus("3");
						this.myIltb20OnlineReportDAO.goToMerge(bean);
					}
					continue;
				case 2:
					logger.info("02轄區狀況統計資料-居留外僑統計表(按國籍及職業分)Start" + new Date());
					try {
						il03B01Report.IL03B01P01_2P(whereCondition, LOGUID, unitName, printUnit);
						bean.setIlStatus("1");
						this.myIltb20OnlineReportDAO.goToMerge(bean);
					} catch (Exception e) {
						e.printStackTrace();
						bean.setIlStatus("3");
						this.myIltb20OnlineReportDAO.goToMerge(bean);
					}
					continue;
				case 3:
					logger.info("03轄區狀況統計資料-外籍男性幫傭名冊Start" + new Date());
					try {
						il03B01Report.IL03B01P01_3P(whereCondition, LOGUID, unitName, printUnit);
						bean.setIlStatus("1");
						this.myIltb20OnlineReportDAO.goToMerge(bean);
					} catch (Exception e) {
						e.printStackTrace();
						bean.setIlStatus("3");
						this.myIltb20OnlineReportDAO.goToMerge(bean);
					}
					continue;
				case 4:
					logger.info("04轄區狀況統計資料-東南亞女子與國人結婚名冊Start" + new Date());
					try {
						il03B01Report.IL03B01P01_4P(whereCondition, LOGUID, unitName, printUnit);
						bean.setIlStatus("1");
						this.myIltb20OnlineReportDAO.goToMerge(bean);
					} catch (Exception e) {
						e.printStackTrace();
						bean.setIlStatus("3");
						this.myIltb20OnlineReportDAO.goToMerge(bean);
					}
					continue;
				case 5:
					logger.info("05轄區狀況統計資料-行方不明外勞協尋名冊Start" + new Date());
					try {
						il03B01Report.IL03B01P01_5P(whereCondition, LOGUID, unitName, printUnit);
						bean.setIlStatus("1");
						this.myIltb20OnlineReportDAO.goToMerge(bean);
					} catch (Exception e) {
						e.printStackTrace();
						bean.setIlStatus("3");
						this.myIltb20OnlineReportDAO.goToMerge(bean);
					}
					continue;
				case 6:
					logger.info("06轄區狀況統計資料-逾期居留外僑名冊Start" + new Date());
					try {
						il03B01Report.IL03B01P01_6P(whereCondition, LOGUID, unitName, printUnit);
						bean.setIlStatus("1");
						this.myIltb20OnlineReportDAO.goToMerge(bean);
					} catch (Exception e) {
						e.printStackTrace();
						bean.setIlStatus("3");
						this.myIltb20OnlineReportDAO.goToMerge(bean);
					}
					continue;
				}
				logger.debug("scheduleIL03B01: 轄區狀況統計資料 無此報表ID");
				continue;
			}
			logger.debug("scheduleIL03B01: 轄區狀況統計資料 報表ID為空");
		}
	}

	public void scheduleIL04B01(WSUtil wsUtil) {
		IL04B01Report il04B01Report = new IL04B01Report();
		IL04C01Report il04C01Report = new IL04C01Report();
		List<Iltb20OnlineReport> iltb20OnlineReportList = this.myIltb20OnlineReportDAO.queryDataB01UnProcess();
		logger.info("scheduleIL04B01:自由檢索報表(固定欄項)、自由檢索(無固定欄項) 待處理筆數=" + iltb20OnlineReportList.size());
		logger.info("for loop");
		for (Iltb20OnlineReport bean : iltb20OnlineReportList) {
			if (!"".equals(bean.getId().getIlRptid()) && bean.getId().getIlRptid() != null) {
				String logUid = bean.getId().getIlUid();
				String logCn = "";
				if(logUid.equals("TESTTEST")) {
					logCn = "陳測試";
				} else {
//					try {
						//logCn = wsUtil.getUserAttribute(logUid, "fullName");
						logCn = logUid;
//					} catch(RemoteException e) {
//						logger.error(e.getMessage(), e);
//					}
				}
				String logDidNM = bean.getIlDidnm();
				logger.info("報表種類:" + Integer.parseInt(bean.getId().getIlRptid()));
				bean.setIlStatus("2");
				this.myIltb20OnlineReportDAO.goToMerge(bean);
				String fileName = bean.getId().getIlRptid() + bean.getId().getIlUid();
				Integer ilRptid = Integer.valueOf(Integer.parseInt(bean.getId().getIlRptid()));
				StringBuffer whereConditionBuffer = new StringBuffer();
				if (bean.getIlWhere1() != null && !"".equals(bean.getIlWhere1()))
					whereConditionBuffer.append(bean.getIlWhere1().trim());
				if (bean.getIlWhere2() != null && !"".equals(bean.getIlWhere2()))
					whereConditionBuffer.append(bean.getIlWhere2().trim());
				if (bean.getIlWhere3() != null && !"".equals(bean.getIlWhere3()))
					whereConditionBuffer.append(bean.getIlWhere3().trim());
				if (bean.getIlWhere4() != null && !"".equals(bean.getIlWhere4()))
					whereConditionBuffer.append(bean.getIlWhere4().trim());
				String whereCondition = whereConditionBuffer.toString();
				switch (ilRptid.intValue()) {
				case 11:
					logger.info("自由檢索報表（固定欄項）－按國籍及職業分(11)Start" + new Date());
					try {
						il04B01Report.IL04B01_01(whereCondition, fileName, logCn, logDidNM);
						bean.setIlStatus("1");
						this.myIltb20OnlineReportDAO.goToMerge(bean);
					} catch (Exception e) {
						e.printStackTrace();
						bean.setIlStatus("3");
						this.myIltb20OnlineReportDAO.goToMerge(bean);
					}
					continue;
				case 12:
					logger.info("自由檢索報表（固定欄項）－按國籍及區域分(12)Start" + new Date());
					try {
						il04B01Report.IL04B01_02(whereCondition, fileName, logCn, logDidNM);
						bean.setIlStatus("1");
						this.myIltb20OnlineReportDAO.goToMerge(bean);
					} catch (Exception e) {
						e.printStackTrace();
						bean.setIlStatus("3");
						this.myIltb20OnlineReportDAO.goToMerge(bean);
					}
					continue;
				case 13:
					logger.info("自由檢索報表（固定欄項）－按職業及區域分(13)Start" + new Date());
					try {
						il04B01Report.IL04B01_03(whereCondition, fileName, logCn, logDidNM);
						bean.setIlStatus("1");
						this.myIltb20OnlineReportDAO.goToMerge(bean);
					} catch (Exception e) {
						e.printStackTrace();
						bean.setIlStatus("3");
						this.myIltb20OnlineReportDAO.goToMerge(bean);
					}
					continue;
				case 17:
					logger.info("自由檢索報表（固定欄項）－按居留目的及職業分(17)Start" + new Date());
					try {
						il04B01Report.IL04B01_04(whereCondition, fileName, logCn, logDidNM);
						bean.setIlStatus("1");
						this.myIltb20OnlineReportDAO.goToMerge(bean);
					} catch (Exception e) {
						e.printStackTrace();
						bean.setIlStatus("3");
						this.myIltb20OnlineReportDAO.goToMerge(bean);
					}
					continue;
				case 18:
					logger.info("自由檢索報表（固定欄項）－按居留目的及區域分(18)Start" + new Date());
					try {
						il04B01Report.IL04B01_05(whereCondition, fileName, logCn, logDidNM);
						bean.setIlStatus("1");
						this.myIltb20OnlineReportDAO.goToMerge(bean);
					} catch (Exception e) {
						e.printStackTrace();
						bean.setIlStatus("3");
						this.myIltb20OnlineReportDAO.goToMerge(bean);
					}
					continue;
				case 19:
					logger.info("自由檢索報表（固定欄項）－按國籍及居留目的分(19)Start" + new Date());
					try {
						il04B01Report.IL04B01_06(whereCondition, fileName, logCn, logDidNM);
						bean.setIlStatus("1");
						this.myIltb20OnlineReportDAO.goToMerge(bean);
					} catch (Exception e) {
						e.printStackTrace();
						bean.setIlStatus("3");
						this.myIltb20OnlineReportDAO.goToMerge(bean);
					}
					continue;
				case 22:
					logger.info("自由檢索報表（固定欄項）－臺閩地區外僑持續居留年限統計報表及名冊(22)Start" + new Date());
					try {
						il04B01Report.IL04B01_07(whereCondition, fileName, logCn, logDidNM);
						bean.setIlStatus("1");
						this.myIltb20OnlineReportDAO.goToMerge(bean);
					} catch (Exception e) {
						e.printStackTrace();
						bean.setIlStatus("3");
						this.myIltb20OnlineReportDAO.goToMerge(bean);
					}
					continue;
				case 20:
					logger.info("自由檢索報表（無固定欄項）Start" + new Date());
					try {
						logger.info("計算筆數...");
						int cnt = this.myIltb01MainDAO2.getCountByQuery(whereCondition);
						logger.info("cnt=" + cnt);
						if (cnt > this.countLimit) {
							bean.setIlStatus("7");
							this.myIltb20OnlineReportDAO.goToMerge(bean);
							continue;
						}
						logger.info("create txt...");
						il04C01Report.IL04C01_01(whereCondition, bean.getIlShow(), fileName);
						logger.info("ok!");
						logger.info("create csv...");
						il04C01Report.IL04C01_01_csv(whereCondition, bean.getIlShow(), fileName);
						logger.info("ok!");
						bean.setIlStatus("1");
						this.myIltb20OnlineReportDAO.goToMerge(bean);
					} catch (Exception e) {
						e.printStackTrace();
						logger.info(e.toString());
						logger.info("執行失敗");
						bean.setIlStatus("3");
						this.myIltb20OnlineReportDAO.goToMerge(bean);
					}
					continue;
				}
				logger.debug("scheduleIL04B01: 自由檢索報表(固定欄項)、(無固定欄項) 無此報表ID");
				continue;
			}
			logger.debug("scheduleIL04B01: 自由檢索報表(固定欄項)、(無固定欄項) 報表ID為空");
		}
	}

}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\schedule\
 * ReportScheduler.class Java compiler version: 5 (49.0) JD-Core Version: 1.1.3
 */