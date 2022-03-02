package tw.gov.npa.il.report.data.il04a01;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import tw.gov.npa.il.dao.Iltb01Main;
import tw.gov.npa.il.dao.Iltb15CountryCode;
import tw.gov.npa.il.dao.Iltb16JobCode;
import tw.gov.npa.il.report.bean.IReportUseBeanR1C2;
import tw.gov.npa.il.report.bean.IReportUseBeanR1C4;
import tw.gov.npa.il.report.bean.IReportUseBeanR2C1;
import tw.gov.npa.il.report.bean.IReportUseBeanR3C2;
import tw.gov.npa.il.util.GetDateUtil;

public class CommonDataBuilder {
	public static JRBeanCollectionDataSource buildByCountryAndJob(List<Iltb01Main> iltb01MainList,
			List<Iltb15CountryCode> iltb15CountryCodeList, List<Iltb16JobCode> iltb16JobCodeList) {
		List<IReportUseBeanR1C2> list = new ArrayList<IReportUseBeanR1C2>();
		int[][] countNumMaleArr = new int[iltb16JobCodeList.size()][iltb15CountryCodeList.size()];
		int[][] countNumFeMaleArr = new int[iltb16JobCodeList.size()][iltb15CountryCodeList.size()];
		int[] row1 = new int[iltb16JobCodeList.size()];
		int[] row2 = new int[iltb16JobCodeList.size()];
		int[] row3 = new int[iltb16JobCodeList.size()];
		int[] column1 = new int[iltb15CountryCodeList.size()];
		int[] column2 = new int[iltb15CountryCodeList.size()];
		for (Iltb01Main iltb01Main : iltb01MainList) {
			String ilSex = iltb01Main.getIlSex();
			String ilNtcd = iltb01Main.getIlNtcd();
			String ilJbcd = iltb01Main.getIlJbcd();
			String ilArcrsn = iltb01Main.getIlArcrsn();
			GetDateUtil getDateUtil = new GetDateUtil();
			int nowYear = getDateUtil.getNowDate()[0];
			int birthYear = Integer.parseInt(iltb01Main.getIlBthdt().substring(0, 4));
			int diffYear = nowYear - birthYear;
			for (int i3 = 0; i3 < iltb15CountryCodeList.size(); i3++) {
				String ilNtcdCode = ((Iltb15CountryCode) iltb15CountryCodeList.get(i3)).getIlNtcd();
				if (ilNtcdCode.equals(ilNtcd))
					for (int i4 = 0; i4 < iltb16JobCodeList.size(); i4++) {
						String ilJbcdCode = ((Iltb16JobCode) iltb16JobCodeList.get(i4)).getIlOpcd();
						int tempJ = i4;
						if (diffYear < 15)
							i4 = iltb16JobCodeList.size() - 1;
						if (ilJbcdCode.equals(ilJbcd)) {
							if ("1".equals(ilSex)) {
								countNumMaleArr[i4][i3] = countNumMaleArr[i4][i3] + 1;
								column1[i3] = column1[i3] + 1;
								row1[i4] = row1[i4] + 1;
								row2[i4] = row2[i4] + 1;
							} else if ("2".equals(ilSex)) {
								countNumFeMaleArr[i4][i3] = countNumFeMaleArr[i4][i3] + 1;
								column2[i3] = column2[i3] + 1;
								row1[i4] = row1[i4] + 1;
								row3[i4] = row3[i4] + 1;
							}
						} else if ("".equals(ilJbcd) || ilJbcd == null || ilJbcd == "0") {
							"7".equals(ilArcrsn);
						}
						i4 = tempJ;
					}
			}
		}
		int sumAll = 0;
		for (int i = 0; i < row1.length; i++)
			sumAll += row1[i];
		IReportUseBeanR1C2 iReportUseBeanTop = new IReportUseBeanR1C2();
		iReportUseBeanTop.setColumnTop((new StringBuilder(String.valueOf(formattedIndex(0)))).toString());
		iReportUseBeanTop.setColumnGroup(String.valueOf(formattedIndex(0)) + "總    計");
		iReportUseBeanTop.setRowGroup(String.valueOf(formattedIndex(0)) + "合    計");
		iReportUseBeanTop.setCountNum(Integer.valueOf(sumAll));
		list.add(iReportUseBeanTop);
		for (int j = 0; j < iltb16JobCodeList.size(); j++) {
			String columnTop = (new StringBuilder(String.valueOf(formattedIndex(0)))).toString();
			String columnGroup = String.valueOf(formattedIndex(0)) + "總    計";
			String rowGroup = String.valueOf(formattedIndex(j + 1))
					+ ((Iltb16JobCode) iltb16JobCodeList.get(j)).getIlOpnm();
			IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
			iReportUseBean.setColumnTop(columnTop);
			iReportUseBean.setColumnGroup(columnGroup);
			iReportUseBean.setRowGroup(rowGroup);
			iReportUseBean.setCountNum(Integer.valueOf(row1[j]));
			list.add(iReportUseBean);
		}
		int sumMale = 0;
		for (int k = 0; k < row2.length; k++)
			sumMale += row2[k];
		IReportUseBeanR1C2 iReportUseBeanTop2 = new IReportUseBeanR1C2();
		iReportUseBeanTop2.setColumnTop(String.valueOf(formattedIndex(1)) + "合    計");
		iReportUseBeanTop2.setColumnGroup(String.valueOf(formattedIndex(0)) + "男");
		iReportUseBeanTop2.setRowGroup(String.valueOf(formattedIndex(0)) + "合    計");
		iReportUseBeanTop2.setCountNum(Integer.valueOf(sumMale));
		list.add(iReportUseBeanTop2);
		for (int m = 0; m < iltb16JobCodeList.size(); m++) {
			String columnTop = String.valueOf(formattedIndex(1)) + "合    計";
			String columnGroup = String.valueOf(formattedIndex(0)) + "男";
			String rowGroup = String.valueOf(formattedIndex(m + 1))
					+ ((Iltb16JobCode) iltb16JobCodeList.get(m)).getIlOpnm();
			IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
			iReportUseBean.setColumnTop(columnTop);
			iReportUseBean.setColumnGroup(columnGroup);
			iReportUseBean.setRowGroup(rowGroup);
			iReportUseBean.setCountNum(Integer.valueOf(row2[m]));
			list.add(iReportUseBean);
		}
		int sumFeMale = 0;
		for (int n = 0; n < row2.length; n++)
			sumFeMale += row3[n];
		IReportUseBeanR1C2 iReportUseBeanTop3 = new IReportUseBeanR1C2();
		iReportUseBeanTop3.setColumnTop(String.valueOf(formattedIndex(1)) + "合    計");
		iReportUseBeanTop3.setColumnGroup(String.valueOf(formattedIndex(1)) + "女");
		iReportUseBeanTop3.setRowGroup(String.valueOf(formattedIndex(0)) + "合    計");
		iReportUseBeanTop3.setCountNum(Integer.valueOf(sumFeMale));
		list.add(iReportUseBeanTop3);
		for (int i2 = 0; i2 < iltb16JobCodeList.size(); i2++) {
			String columnTop = String.valueOf(formattedIndex(1)) + "合    計";
			String columnGroup = String.valueOf(formattedIndex(1)) + "女";
			String rowGroup = String.valueOf(formattedIndex(i2 + 1))
					+ ((Iltb16JobCode) iltb16JobCodeList.get(i2)).getIlOpnm();
			IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
			iReportUseBean.setColumnTop(columnTop);
			iReportUseBean.setColumnGroup(columnGroup);
			iReportUseBean.setRowGroup(rowGroup);
			iReportUseBean.setCountNum(Integer.valueOf(row3[i2]));
			list.add(iReportUseBean);
		}
		int i1;
		for (i1 = 0; i1 < iltb15CountryCodeList.size(); i1++) {
			String columnTop = String.valueOf(formattedIndex(i1 + 2))
					+ ((Iltb15CountryCode) iltb15CountryCodeList.get(i1)).getIlNtnm();
			String columnGroup = String.valueOf(formattedIndex(0)) + "男";
			String rowGroup = String.valueOf(formattedIndex(0)) + "合    計";
			IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
			iReportUseBean.setColumnTop(columnTop);
			iReportUseBean.setColumnGroup(columnGroup);
			iReportUseBean.setRowGroup(rowGroup);
			iReportUseBean.setCountNum(Integer.valueOf(column1[i1]));
			list.add(iReportUseBean);
			columnGroup = String.valueOf(formattedIndex(1)) + "女";
			IReportUseBeanR1C2 iReportUseBean2 = new IReportUseBeanR1C2();
			iReportUseBean2.setColumnTop(columnTop);
			iReportUseBean2.setColumnGroup(columnGroup);
			iReportUseBean2.setRowGroup(rowGroup);
			iReportUseBean2.setCountNum(Integer.valueOf(column2[i1]));
			list.add(iReportUseBean2);
		}
		for (i1 = 0; i1 < iltb15CountryCodeList.size(); i1++) {
			for (int i3 = 0; i3 < iltb16JobCodeList.size(); i3++) {
				String columnTop = String.valueOf(formattedIndex(i1 + 2))
						+ ((Iltb15CountryCode) iltb15CountryCodeList.get(i1)).getIlNtnm();
				String columnGroup = String.valueOf(formattedIndex(0)) + "男";
				String rowGroup = String.valueOf(formattedIndex(i3 + 1))
						+ ((Iltb16JobCode) iltb16JobCodeList.get(i3)).getIlOpnm();
				IReportUseBeanR1C2 iReportUseBeanMale = new IReportUseBeanR1C2();
				iReportUseBeanMale.setColumnTop(columnTop);
				iReportUseBeanMale.setColumnGroup(columnGroup);
				iReportUseBeanMale.setRowGroup(rowGroup);
				iReportUseBeanMale.setCountNum(Integer.valueOf(countNumMaleArr[i3][i1]));
				list.add(iReportUseBeanMale);
				columnGroup = String.valueOf(formattedIndex(1)) + "女";
				IReportUseBeanR1C2 iReportUseBeanFeMale = new IReportUseBeanR1C2();
				iReportUseBeanFeMale.setColumnTop(columnTop);
				iReportUseBeanFeMale.setColumnGroup(columnGroup);
				iReportUseBeanFeMale.setRowGroup(rowGroup);
				iReportUseBeanFeMale.setCountNum(Integer.valueOf(countNumFeMaleArr[i3][i1]));
				list.add(iReportUseBeanFeMale);
			}
		}
		return new JRBeanCollectionDataSource(list);
	}

	public static JRBeanCollectionDataSource buildByCountryAndArea(List<Iltb01Main> iltb01MainList,
			List<Iltb15CountryCode> iltb15CountryCodeList, List<AreaCodeBean> areaCodes) {
		List<IReportUseBeanR1C2> list = new ArrayList<IReportUseBeanR1C2>();
		int[][] countNumMaleArr = new int[areaCodes.size()][iltb15CountryCodeList.size()];
		int[][] countNumFeMaleArr = new int[areaCodes.size()][iltb15CountryCodeList.size()];
		int[] row1 = new int[areaCodes.size()];
		int[] row2 = new int[areaCodes.size()];
		int[] row3 = new int[areaCodes.size()];
		int[] column1 = new int[iltb15CountryCodeList.size()];
		int[] column2 = new int[iltb15CountryCodeList.size()];
		for (Iltb01Main iltb01Main : iltb01MainList) {
			String ilSex = iltb01Main.getIlSex();
			String ilNtcd = iltb01Main.getIlNtcd();
			String IlPhq = iltb01Main.getIlPhq();
			if (IlPhq.equals("P000")) {
				IlPhq = "V000";
			} else if (IlPhq.equals("I000")) {
				IlPhq = "B000";
			} else if (IlPhq.equals("O000")) {
				IlPhq = "C000";
			}
			for (int i3 = 0; i3 < iltb15CountryCodeList.size(); i3++) {
				String ilNtcdCode = ((Iltb15CountryCode) iltb15CountryCodeList.get(i3)).getIlNtcd();
				if (ilNtcdCode.equals(ilNtcd))
					for (int i4 = 0; i4 < areaCodes.size(); i4++) {
						String areaCode = ((AreaCodeBean) areaCodes.get(i4)).getAreaCode();
						if (IlPhq.equals(areaCode))
							if ("1".equals(ilSex)) {
								countNumMaleArr[i4][i3] = countNumMaleArr[i4][i3] + 1;
								column1[i3] = column1[i3] + 1;
								row1[i4] = row1[i4] + 1;
								row2[i4] = row2[i4] + 1;
								countNumMaleArr[0][i3] = countNumMaleArr[0][i3] + 1;
								row1[0] = row1[0] + 1;
								row2[0] = row2[0] + 1;
								if (i4 >= 2 && i4 <= 16) {
									countNumMaleArr[1][i3] = countNumMaleArr[1][i3] + 1;
									row1[1] = row1[1] + 1;
									row2[1] = row2[1] + 1;
								} else if (i4 >= 18 && i4 <= 22) {
									countNumMaleArr[17][i3] = countNumMaleArr[17][i3] + 1;
									row1[17] = row1[17] + 1;
									row2[17] = row2[17] + 1;
								} else if (i4 >= 24 && i4 <= 25) {
									countNumMaleArr[23][i3] = countNumMaleArr[23][i3] + 1;
									row1[23] = row1[23] + 1;
									row2[23] = row2[23] + 1;
								}
							} else if ("2".equals(ilSex)) {
								countNumFeMaleArr[i4][i3] = countNumFeMaleArr[i4][i3] + 1;
								column2[i3] = column2[i3] + 1;
								row1[i4] = row1[i4] + 1;
								row3[i4] = row3[i4] + 1;
								countNumFeMaleArr[0][i3] = countNumFeMaleArr[0][i3] + 1;
								row1[0] = row1[0] + 1;
								row3[0] = row3[0] + 1;
								if (i4 >= 2 && i4 <= 16) {
									countNumFeMaleArr[1][i3] = countNumFeMaleArr[1][i3] + 1;
									row1[1] = row1[1] + 1;
									row3[1] = row3[1] + 1;
								} else if (i4 >= 18 && i4 <= 22) {
									countNumFeMaleArr[17][i3] = countNumFeMaleArr[17][i3] + 1;
									row1[17] = row1[17] + 1;
									row3[17] = row3[17] + 1;
								} else if (i4 >= 24 && i4 <= 25) {
									countNumFeMaleArr[23][i3] = countNumFeMaleArr[23][i3] + 1;
									row1[23] = row1[23] + 1;
									row3[23] = row3[23] + 1;
								}
							}
					}
			}
		}
		int sumAll = 0;
		for (int i = 0; i < row1.length; i++) {
			if (i != 0 && i != 1 && i != 17 && i != 23)
				sumAll += row1[i];
		}
		IReportUseBeanR1C2 iReportUseBeanTop = new IReportUseBeanR1C2();
		iReportUseBeanTop.setColumnTop((new StringBuilder(String.valueOf(formattedIndex(0)))).toString());
		iReportUseBeanTop.setColumnGroup(String.valueOf(formattedIndex(0)) + "總    計");
		iReportUseBeanTop.setRowGroup(String.valueOf(formattedIndex(0)) + "合    計");
		iReportUseBeanTop.setCountNum(Integer.valueOf(sumAll));
		list.add(iReportUseBeanTop);
		for (int j = 0; j < areaCodes.size(); j++) {
			String columnTop = (new StringBuilder(String.valueOf(formattedIndex(0)))).toString();
			String columnGroup = String.valueOf(formattedIndex(0)) + "總    計";
			String rowGroup = String.valueOf(formattedIndex(j + 1)) + ((AreaCodeBean) areaCodes.get(j)).getAreaName();
			IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
			iReportUseBean.setColumnTop(columnTop);
			iReportUseBean.setColumnGroup(columnGroup);
			iReportUseBean.setRowGroup(rowGroup);
			iReportUseBean.setCountNum(Integer.valueOf(row1[j]));
			list.add(iReportUseBean);
		}
		int sumMale = 0;
		for (int k = 0; k < row2.length; k++) {
			if (k != 0 && k != 1 && k != 17 && k != 23)
				sumMale += row2[k];
		}
		IReportUseBeanR1C2 iReportUseBeanTop2 = new IReportUseBeanR1C2();
		iReportUseBeanTop2.setColumnTop(String.valueOf(formattedIndex(1)) + "合    計");
		iReportUseBeanTop2.setColumnGroup(String.valueOf(formattedIndex(0)) + "男");
		iReportUseBeanTop2.setRowGroup(String.valueOf(formattedIndex(0)) + "合    計");
		iReportUseBeanTop2.setCountNum(Integer.valueOf(sumMale));
		list.add(iReportUseBeanTop2);
		for (int m = 0; m < areaCodes.size(); m++) {
			String columnTop = String.valueOf(formattedIndex(1)) + "合    計";
			String columnGroup = String.valueOf(formattedIndex(0)) + "男";
			String rowGroup = String.valueOf(formattedIndex(m + 1)) + ((AreaCodeBean) areaCodes.get(m)).getAreaName();
			IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
			iReportUseBean.setColumnTop(columnTop);
			iReportUseBean.setColumnGroup(columnGroup);
			iReportUseBean.setRowGroup(rowGroup);
			iReportUseBean.setCountNum(Integer.valueOf(row2[m]));
			list.add(iReportUseBean);
		}
		int sumFeMale = 0;
		for (int n = 0; n < row2.length; n++) {
			if (n != 0 && n != 1 && n != 17 && n != 23)
				sumFeMale += row3[n];
		}
		IReportUseBeanR1C2 iReportUseBeanTop3 = new IReportUseBeanR1C2();
		iReportUseBeanTop3.setColumnTop(String.valueOf(formattedIndex(1)) + "合    計");
		iReportUseBeanTop3.setColumnGroup(String.valueOf(formattedIndex(1)) + "女");
		iReportUseBeanTop3.setRowGroup(String.valueOf(formattedIndex(0)) + "合    計");
		iReportUseBeanTop3.setCountNum(Integer.valueOf(sumFeMale));
		list.add(iReportUseBeanTop3);
		for (int i2 = 0; i2 < areaCodes.size(); i2++) {
			String columnTop = String.valueOf(formattedIndex(1)) + "合    計";
			String columnGroup = String.valueOf(formattedIndex(1)) + "女";
			String rowGroup = String.valueOf(formattedIndex(i2 + 1)) + ((AreaCodeBean) areaCodes.get(i2)).getAreaName();
			IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
			iReportUseBean.setColumnTop(columnTop);
			iReportUseBean.setColumnGroup(columnGroup);
			iReportUseBean.setRowGroup(rowGroup);
			iReportUseBean.setCountNum(Integer.valueOf(row3[i2]));
			list.add(iReportUseBean);
		}
		int i1;
		for (i1 = 0; i1 < iltb15CountryCodeList.size(); i1++) {
			String columnTop = String.valueOf(formattedIndex(i1 + 2))
					+ ((Iltb15CountryCode) iltb15CountryCodeList.get(i1)).getIlNtnm();
			String columnGroup = String.valueOf(formattedIndex(0)) + "男";
			String rowGroup = String.valueOf(formattedIndex(0)) + "合    計";
			IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
			iReportUseBean.setColumnTop(columnTop);
			iReportUseBean.setColumnGroup(columnGroup);
			iReportUseBean.setRowGroup(rowGroup);
			iReportUseBean.setCountNum(Integer.valueOf(column1[i1]));
			list.add(iReportUseBean);
			columnGroup = String.valueOf(formattedIndex(1)) + "女";
			IReportUseBeanR1C2 iReportUseBean2 = new IReportUseBeanR1C2();
			iReportUseBean2.setColumnTop(columnTop);
			iReportUseBean2.setColumnGroup(columnGroup);
			iReportUseBean2.setRowGroup(rowGroup);
			iReportUseBean2.setCountNum(Integer.valueOf(column2[i1]));
			list.add(iReportUseBean2);
		}
		for (i1 = 0; i1 < iltb15CountryCodeList.size(); i1++) {
			for (int i3 = 0; i3 < areaCodes.size(); i3++) {
				String columnTop = String.valueOf(formattedIndex(i1 + 2))
						+ ((Iltb15CountryCode) iltb15CountryCodeList.get(i1)).getIlNtnm();
				String columnGroup = String.valueOf(formattedIndex(0)) + "男";
				String rowGroup = String.valueOf(formattedIndex(i3 + 1))
						+ ((AreaCodeBean) areaCodes.get(i3)).getAreaName();
				IReportUseBeanR1C2 iReportUseBeanMale = new IReportUseBeanR1C2();
				iReportUseBeanMale.setColumnTop(columnTop);
				iReportUseBeanMale.setColumnGroup(columnGroup);
				iReportUseBeanMale.setRowGroup(rowGroup);
				iReportUseBeanMale.setCountNum(Integer.valueOf(countNumMaleArr[i3][i1]));
				list.add(iReportUseBeanMale);
				columnGroup = String.valueOf(formattedIndex(1)) + "女";
				IReportUseBeanR1C2 iReportUseBeanFeMale = new IReportUseBeanR1C2();
				iReportUseBeanFeMale.setColumnTop(columnTop);
				iReportUseBeanFeMale.setColumnGroup(columnGroup);
				iReportUseBeanFeMale.setRowGroup(rowGroup);
				iReportUseBeanFeMale.setCountNum(Integer.valueOf(countNumFeMaleArr[i3][i1]));
				list.add(iReportUseBeanFeMale);
			}
		}
		return new JRBeanCollectionDataSource(list);
	}

	public static JRBeanCollectionDataSource buildByPurposeAndArea(List<Iltb01Main> iltb01MainList,
			List<PurposeBean> purposes, List<AreaCodeBean> areaCodes) {
		List<IReportUseBeanR1C4> list = new ArrayList<IReportUseBeanR1C4>();
		int[][] countNumMaleArr = new int[areaCodes.size()][purposes.size()];
		int[][] countNumFeMaleArr = new int[areaCodes.size()][purposes.size()];
		int[] row1 = new int[areaCodes.size()];
		int[] row2 = new int[areaCodes.size()];
		int[] row3 = new int[areaCodes.size()];
		int[] column1 = new int[purposes.size()];
		int[] column2 = new int[purposes.size()];
		for (Iltb01Main iltb01Main : iltb01MainList) {
			String ilSex = iltb01Main.getIlSex();
			String IlPhq = iltb01Main.getIlPhq();
			String ilArcrsn = iltb01Main.getIlArcrsn();
			String ilOfnm = iltb01Main.getIlOfnm();
			if (IlPhq.equals("P000")) {
				IlPhq = "V000";
			} else if (IlPhq.equals("I000")) {
				IlPhq = "B000";
			} else if (IlPhq.equals("O000")) {
				IlPhq = "C000";
			}
			int idxPurpose = findPurposeSequence(ilArcrsn, ilOfnm);
			int i3;
			for (i3 = 0; i3 < areaCodes.size(); i3++) {
				String areaCode = ((AreaCodeBean) areaCodes.get(i3)).getAreaCode();
				if (IlPhq.equals(areaCode))
					if ("1".equals(ilSex)) {
						countNumMaleArr[i3][idxPurpose] = countNumMaleArr[i3][idxPurpose] + 1;
						column1[idxPurpose] = column1[idxPurpose] + 1;
						row1[i3] = row1[i3] + 1;
						row2[i3] = row2[i3] + 1;
						countNumMaleArr[0][idxPurpose] = countNumMaleArr[0][idxPurpose] + 1;
						row1[0] = row1[0] + 1;
						row2[0] = row2[0] + 1;
						if (i3 >= 2 && i3 <= 16) {
							countNumMaleArr[1][idxPurpose] = countNumMaleArr[1][idxPurpose] + 1;
							row1[1] = row1[1] + 1;
							row2[1] = row2[1] + 1;
						} else if (i3 >= 18 && i3 <= 22) {
							countNumMaleArr[17][idxPurpose] = countNumMaleArr[17][idxPurpose] + 1;
							row1[17] = row1[17] + 1;
							row2[17] = row2[17] + 1;
						} else if (i3 >= 24 && i3 <= 25) {
							countNumMaleArr[23][idxPurpose] = countNumMaleArr[23][idxPurpose] + 1;
							row1[23] = row1[23] + 1;
							row2[23] = row2[23] + 1;
						}
					} else if ("2".equals(ilSex)) {
						countNumFeMaleArr[i3][idxPurpose] = countNumFeMaleArr[i3][idxPurpose] + 1;
						column2[idxPurpose] = column2[idxPurpose] + 1;
						row1[i3] = row1[i3] + 1;
						row3[i3] = row3[i3] + 1;
						countNumFeMaleArr[0][idxPurpose] = countNumFeMaleArr[0][idxPurpose] + 1;
						row1[0] = row1[0] + 1;
						row3[0] = row3[0] + 1;
						if (i3 >= 2 && i3 <= 16) {
							countNumFeMaleArr[1][idxPurpose] = countNumFeMaleArr[1][idxPurpose] + 1;
							row1[1] = row1[1] + 1;
							row3[1] = row3[1] + 1;
						} else if (i3 >= 18 && i3 <= 22) {
							countNumFeMaleArr[17][idxPurpose] = countNumFeMaleArr[17][idxPurpose] + 1;
							row1[17] = row1[17] + 1;
							row3[17] = row3[17] + 1;
						} else if (i3 >= 24 && i3 <= 25) {
							countNumFeMaleArr[23][idxPurpose] = countNumFeMaleArr[23][idxPurpose] + 1;
							row1[23] = row1[23] + 1;
							row3[23] = row3[23] + 1;
						}
					}
			}
			for (i3 = 0; i3 < areaCodes.size(); i3++) {
				countNumMaleArr[i3][1] = countNumMaleArr[i3][2] + countNumMaleArr[i3][3] + countNumMaleArr[i3][4]
						+ countNumMaleArr[i3][5];
				countNumMaleArr[i3][6] = countNumMaleArr[i3][7] + countNumMaleArr[i3][8] + countNumMaleArr[i3][9]
						+ countNumMaleArr[i3][10];
				countNumMaleArr[i3][0] = countNumMaleArr[i3][1] + countNumMaleArr[i3][6];
				countNumMaleArr[i3][17] = countNumMaleArr[i3][18] + countNumMaleArr[i3][19] + countNumMaleArr[i3][20]
						+ countNumMaleArr[i3][21] + countNumMaleArr[i3][22] + countNumMaleArr[i3][23]
						+ countNumMaleArr[i3][24] + countNumMaleArr[i3][25] + countNumMaleArr[i3][26];
			}
		}
		int sumAll = 0;
		for (int i = 0; i < row1.length; i++) {
			if (i != 0 && i != 1 && i != 17 && i != 23)
				sumAll += row1[i];
		}
		IReportUseBeanR1C4 iReportUseBeanTop = new IReportUseBeanR1C4();
		iReportUseBeanTop.setColumnTop((new StringBuilder(String.valueOf(formattedIndex(0)))).toString());
		iReportUseBeanTop.setColumnTop2((new StringBuilder(String.valueOf(formattedIndex(0)))).toString());
		iReportUseBeanTop.setColumnTop3((new StringBuilder(String.valueOf(formattedIndex(0)))).toString());
		iReportUseBeanTop.setColumnGroup(String.valueOf(formattedIndex(0)) + "總    計");
		iReportUseBeanTop.setRowGroup(String.valueOf(formattedIndex(0)) + "合    計");
		iReportUseBeanTop.setCountNum(Integer.valueOf(sumAll));
		list.add(iReportUseBeanTop);
		for (int j = 0; j < areaCodes.size(); j++) {
			String columnTop = (new StringBuilder(String.valueOf(formattedIndex(0)))).toString();
			String colunmTop2 = (new StringBuilder(String.valueOf(formattedIndex(0)))).toString();
			String colunmTop3 = (new StringBuilder(String.valueOf(formattedIndex(0)))).toString();
			String columnGroup = String.valueOf(formattedIndex(0)) + "總    計";
			String rowGroup = String.valueOf(formattedIndex(j + 1)) + ((AreaCodeBean) areaCodes.get(j)).getAreaName();
			IReportUseBeanR1C4 iReportUseBean = new IReportUseBeanR1C4();
			iReportUseBean.setColumnTop(columnTop);
			iReportUseBean.setColumnTop2(colunmTop2);
			iReportUseBean.setColumnTop3(colunmTop3);
			iReportUseBean.setColumnGroup(columnGroup);
			iReportUseBean.setRowGroup(rowGroup);
			iReportUseBean.setCountNum(Integer.valueOf(row1[j]));
			list.add(iReportUseBean);
		}
		int sumMale = 0;
		for (int k = 0; k < row2.length; k++) {
			if (k != 0 && k != 1 && k != 17 && k != 23)
				sumMale += row2[k];
		}
		IReportUseBeanR1C4 iReportUseBeanTop2 = new IReportUseBeanR1C4();
		iReportUseBeanTop2.setColumnTop((new StringBuilder(String.valueOf(formattedIndex(1)))).toString());
		iReportUseBeanTop2.setColumnTop2((new StringBuilder(String.valueOf(formattedIndex(1)))).toString());
		iReportUseBeanTop2.setColumnTop3(String.valueOf(formattedIndex(1)) + "合    計");
		iReportUseBeanTop2.setColumnGroup(String.valueOf(formattedIndex(0)) + "男");
		iReportUseBeanTop2.setRowGroup(String.valueOf(formattedIndex(0)) + "合    計");
		iReportUseBeanTop2.setCountNum(Integer.valueOf(sumMale));
		list.add(iReportUseBeanTop2);
		for (int m = 0; m < areaCodes.size(); m++) {
			String columnTop = (new StringBuilder(String.valueOf(formattedIndex(1)))).toString();
			String colunmTop2 = (new StringBuilder(String.valueOf(formattedIndex(1)))).toString();
			String colunmTop3 = String.valueOf(formattedIndex(1)) + "合    計";
			String columnGroup = String.valueOf(formattedIndex(0)) + "男";
			String rowGroup = String.valueOf(formattedIndex(m + 1)) + ((AreaCodeBean) areaCodes.get(m)).getAreaName();
			IReportUseBeanR1C4 iReportUseBean = new IReportUseBeanR1C4();
			iReportUseBean.setColumnTop(columnTop);
			iReportUseBean.setColumnTop2(colunmTop2);
			iReportUseBean.setColumnTop3(colunmTop3);
			iReportUseBean.setColumnGroup(columnGroup);
			iReportUseBean.setRowGroup(rowGroup);
			iReportUseBean.setCountNum(Integer.valueOf(row2[m]));
			list.add(iReportUseBean);
		}
		int sumFeMale = 0;
		for (int n = 0; n < row2.length; n++) {
			if (n != 0 && n != 1 && n != 17 && n != 23)
				sumFeMale += row3[n];
		}
		IReportUseBeanR1C4 iReportUseBeanTop3 = new IReportUseBeanR1C4();
		iReportUseBeanTop3.setColumnTop((new StringBuilder(String.valueOf(formattedIndex(1)))).toString());
		iReportUseBeanTop3.setColumnTop2((new StringBuilder(String.valueOf(formattedIndex(1)))).toString());
		iReportUseBeanTop3.setColumnTop3(String.valueOf(formattedIndex(1)) + "合    計");
		iReportUseBeanTop3.setColumnGroup(String.valueOf(formattedIndex(1)) + "女");
		iReportUseBeanTop3.setRowGroup(String.valueOf(formattedIndex(0)) + "合    計");
		iReportUseBeanTop3.setCountNum(Integer.valueOf(sumFeMale));
		list.add(iReportUseBeanTop3);
		for (int i2 = 0; i2 < areaCodes.size(); i2++) {
			String columnTop = (new StringBuilder(String.valueOf(formattedIndex(1)))).toString();
			String colunmTop2 = (new StringBuilder(String.valueOf(formattedIndex(1)))).toString();
			String colunmTop3 = String.valueOf(formattedIndex(1)) + "合    計";
			String columnGroup = String.valueOf(formattedIndex(1)) + "女";
			String rowGroup = String.valueOf(formattedIndex(i2 + 1)) + ((AreaCodeBean) areaCodes.get(i2)).getAreaName();
			IReportUseBeanR1C4 iReportUseBean = new IReportUseBeanR1C4();
			iReportUseBean.setColumnTop(columnTop);
			iReportUseBean.setColumnTop2(colunmTop2);
			iReportUseBean.setColumnTop3(colunmTop3);
			iReportUseBean.setColumnGroup(columnGroup);
			iReportUseBean.setRowGroup(rowGroup);
			iReportUseBean.setCountNum(Integer.valueOf(row3[i2]));
			list.add(iReportUseBean);
		}
		int i1;
		for (i1 = 0; i1 < purposes.size(); i1++) {
			String columnTop = String.valueOf(formattedIndex(((PurposeBean) purposes.get(i1)).getSequence1() + 3))
					+ ((PurposeBean) purposes.get(i1)).getLevel1();
			String colunmTop2 = String.valueOf(formattedIndex(((PurposeBean) purposes.get(i1)).getSequence2() + 3))
					+ ((PurposeBean) purposes.get(i1)).getLevel2();
			String colunmTop3 = String.valueOf(formattedIndex(((PurposeBean) purposes.get(i1)).getSequence() + 3))
					+ ((PurposeBean) purposes.get(i1)).getLevel3();
			String columnGroup = String.valueOf(formattedIndex(0)) + "男";
			String rowGroup = String.valueOf(formattedIndex(0)) + "合    計";
			IReportUseBeanR1C4 iReportUseBean = new IReportUseBeanR1C4();
			iReportUseBean.setColumnTop(columnTop);
			iReportUseBean.setColumnTop2(colunmTop2);
			iReportUseBean.setColumnTop3(colunmTop3);
			iReportUseBean.setColumnGroup(columnGroup);
			iReportUseBean.setRowGroup(rowGroup);
			iReportUseBean.setCountNum(Integer.valueOf(column1[i1]));
			list.add(iReportUseBean);
			columnGroup = String.valueOf(formattedIndex(1)) + "女";
			IReportUseBeanR1C4 iReportUseBean2 = new IReportUseBeanR1C4();
			iReportUseBean2.setColumnTop(columnTop);
			iReportUseBean2.setColumnTop2(colunmTop2);
			iReportUseBean2.setColumnTop3(colunmTop3);
			iReportUseBean2.setColumnGroup(columnGroup);
			iReportUseBean2.setRowGroup(rowGroup);
			iReportUseBean2.setCountNum(Integer.valueOf(column2[i1]));
			list.add(iReportUseBean2);
		}
		for (i1 = 0; i1 < purposes.size(); i1++) {
			for (int i3 = 0; i3 < areaCodes.size(); i3++) {
				String columnTop = String.valueOf(formattedIndex(((PurposeBean) purposes.get(i1)).getSequence1() + 3))
						+ ((PurposeBean) purposes.get(i1)).getLevel1();
				String colunmTop2 = String.valueOf(formattedIndex(((PurposeBean) purposes.get(i1)).getSequence2() + 3))
						+ ((PurposeBean) purposes.get(i1)).getLevel2();
				String colunmTop3 = String.valueOf(formattedIndex(((PurposeBean) purposes.get(i1)).getSequence() + 3))
						+ ((PurposeBean) purposes.get(i1)).getLevel3();
				String columnGroup = String.valueOf(formattedIndex(0)) + "男";
				String rowGroup = String.valueOf(formattedIndex(i3 + 1))
						+ ((AreaCodeBean) areaCodes.get(i3)).getAreaName();
				IReportUseBeanR1C4 iReportUseBeanMale = new IReportUseBeanR1C4();
				iReportUseBeanMale.setColumnTop(columnTop);
				iReportUseBeanMale.setColumnTop2(colunmTop2);
				iReportUseBeanMale.setColumnTop3(colunmTop3);
				iReportUseBeanMale.setColumnGroup(columnGroup);
				iReportUseBeanMale.setRowGroup(rowGroup);
				iReportUseBeanMale.setCountNum(Integer.valueOf(countNumMaleArr[i3][i1]));
				list.add(iReportUseBeanMale);
				columnGroup = String.valueOf(formattedIndex(1)) + "女";
				IReportUseBeanR1C4 iReportUseBeanFeMale = new IReportUseBeanR1C4();
				iReportUseBeanFeMale.setColumnTop(columnTop);
				iReportUseBeanFeMale.setColumnTop2(colunmTop2);
				iReportUseBeanFeMale.setColumnTop3(colunmTop3);
				iReportUseBeanFeMale.setColumnGroup(columnGroup);
				iReportUseBeanFeMale.setRowGroup(rowGroup);
				iReportUseBeanFeMale.setCountNum(Integer.valueOf(countNumFeMaleArr[i3][i1]));
				if (iReportUseBeanFeMale.getColumnTop2() == null || iReportUseBeanFeMale.getColumnTop2().equals("null"))
					System.out.println("i:" + i1 + ",j:" + i3);
				list.add(iReportUseBeanFeMale);
			}
		}
		return new JRBeanCollectionDataSource(list);
	}

	public static JRBeanCollectionDataSource buildByCountryAndPurpose(List<Iltb01Main> iltb01MainList,
			List<Iltb15CountryCode> iltb15CountryCodeList, List<PurposeBean> purposes) {
		List<IReportUseBeanR3C2> list = new ArrayList<IReportUseBeanR3C2>();
		int[][] countNumMaleArr = new int[purposes.size()][iltb15CountryCodeList.size()];
		int[][] countNumFeMaleArr = new int[purposes.size()][iltb15CountryCodeList.size()];
		int[] row1 = new int[purposes.size()];
		int[] row2 = new int[purposes.size()];
		int[] row3 = new int[purposes.size()];
		int[] column1 = new int[iltb15CountryCodeList.size()];
		int[] column2 = new int[iltb15CountryCodeList.size()];
		for (Iltb01Main iltb01Main : iltb01MainList) {
			String ilSex = iltb01Main.getIlSex();
			String ilNtcd = iltb01Main.getIlNtcd();
			String ilArcrsn = iltb01Main.getIlArcrsn();
			String ilOfnm = iltb01Main.getIlOfnm();
			int i3;
			for (i3 = 0; i3 < iltb15CountryCodeList.size(); i3++) {
				String ilNtcdCode = ((Iltb15CountryCode) iltb15CountryCodeList.get(i3)).getIlNtcd();
				if (ilNtcdCode.equals(ilNtcd)) {
					int i4 = findPurposeSequence(ilArcrsn, ilOfnm);
					if ("1".equals(ilSex)) {
						countNumMaleArr[i4][i3] = countNumMaleArr[i4][i3] + 1;
						column1[i3] = column1[i3] + 1;
						row1[i4] = row1[i4] + 1;
						row2[i4] = row2[i4] + 1;
					} else if ("2".equals(ilSex)) {
						countNumFeMaleArr[i4][i3] = countNumFeMaleArr[i4][i3] + 1;
						column2[i3] = column2[i3] + 1;
						row1[i4] = row1[i4] + 1;
						row3[i4] = row3[i4] + 1;
					}
				}
			}
			for (i3 = 0; i3 < iltb15CountryCodeList.size(); i3++) {
				countNumMaleArr[1][i3] = countNumMaleArr[2][i3] + countNumMaleArr[3][i3] + countNumMaleArr[4][i3]
						+ countNumMaleArr[5][i3];
				countNumFeMaleArr[1][i3] = countNumFeMaleArr[2][i3] + countNumFeMaleArr[3][i3]
						+ countNumFeMaleArr[4][i3] + countNumFeMaleArr[5][i3];
				countNumMaleArr[6][i3] = countNumMaleArr[7][i3] + countNumMaleArr[8][i3] + countNumMaleArr[9][i3]
						+ countNumMaleArr[10][i3];
				countNumFeMaleArr[6][i3] = countNumFeMaleArr[7][i3] + countNumFeMaleArr[8][i3]
						+ countNumFeMaleArr[9][i3] + countNumFeMaleArr[10][i3];
				countNumMaleArr[0][i3] = countNumMaleArr[1][i3] + countNumMaleArr[6][i3];
				countNumFeMaleArr[0][i3] = countNumFeMaleArr[1][i3] + countNumFeMaleArr[6][i3];
				countNumMaleArr[17][i3] = countNumMaleArr[18][i3] + countNumMaleArr[19][i3] + countNumMaleArr[20][i3]
						+ countNumMaleArr[21][i3] + countNumMaleArr[22][i3] + countNumMaleArr[23][i3]
						+ countNumMaleArr[24][i3] + countNumMaleArr[25][i3] + countNumMaleArr[26][i3];
				countNumFeMaleArr[17][i3] = countNumFeMaleArr[18][i3] + countNumFeMaleArr[19][i3]
						+ countNumFeMaleArr[20][i3] + countNumFeMaleArr[21][i3] + countNumFeMaleArr[22][i3]
						+ countNumFeMaleArr[23][i3] + countNumFeMaleArr[24][i3] + countNumFeMaleArr[25][i3]
						+ countNumFeMaleArr[26][i3];
			}
		}
		int sumAll = 0;
		for (int i = 0; i < row1.length; i++) {
			if (i != 0 && i != 1 && i != 6 && i != 17)
				sumAll += row1[i];
		}
		IReportUseBeanR3C2 iReportUseBeanTop = new IReportUseBeanR3C2();
		iReportUseBeanTop.setColumnTop((new StringBuilder(String.valueOf(formattedIndex(0)))).toString());
		iReportUseBeanTop.setColumnGroup(String.valueOf(formattedIndex(0)) + "總    計");
		iReportUseBeanTop.setRowTop((new StringBuilder(String.valueOf(formattedIndex(0)))).toString());
		iReportUseBeanTop.setRowTop2((new StringBuilder(String.valueOf(formattedIndex(0)))).toString());
		iReportUseBeanTop.setRowGroup(String.valueOf(formattedIndex(0)) + "合    計");
		iReportUseBeanTop.setCountNum(Integer.valueOf(sumAll));
		list.add(iReportUseBeanTop);
		for (int j = 0; j < purposes.size(); j++) {
			String columnTop = (new StringBuilder(String.valueOf(formattedIndex(0)))).toString();
			String columnGroup = String.valueOf(formattedIndex(0)) + "總    計";
			String rowTop = String.valueOf(formattedIndex(((PurposeBean) purposes.get(j)).getSequence1() + 1))
					+ ((PurposeBean) purposes.get(j)).getLevel1();
			String rowTop2 = String.valueOf(formattedIndex(((PurposeBean) purposes.get(j)).getSequence2() + 1))
					+ ((PurposeBean) purposes.get(j)).getLevel2();
			String rowGroup = String.valueOf(formattedIndex(((PurposeBean) purposes.get(j)).getSequence() + 1))
					+ ((PurposeBean) purposes.get(j)).getLevel3();
			IReportUseBeanR3C2 iReportUseBean = new IReportUseBeanR3C2();
			iReportUseBean.setColumnTop(columnTop);
			iReportUseBean.setColumnGroup(columnGroup);
			iReportUseBean.setRowTop(rowTop);
			iReportUseBean.setRowTop2(rowTop2);
			iReportUseBean.setRowGroup(rowGroup);
			iReportUseBean.setCountNum(Integer.valueOf(row1[j]));
			list.add(iReportUseBean);
		}
		int sumMale = 0;
		for (int k = 0; k < row2.length; k++) {
			if (k != 0 && k != 1 && k != 6 && k != 17)
				sumMale += row2[k];
		}
		IReportUseBeanR3C2 iReportUseBeanTop2 = new IReportUseBeanR3C2();
		iReportUseBeanTop2.setColumnTop(String.valueOf(formattedIndex(1)) + "合    計");
		iReportUseBeanTop2.setColumnGroup(String.valueOf(formattedIndex(0)) + "男");
		iReportUseBeanTop2.setRowTop((new StringBuilder(String.valueOf(formattedIndex(0)))).toString());
		iReportUseBeanTop2.setRowTop2((new StringBuilder(String.valueOf(formattedIndex(0)))).toString());
		iReportUseBeanTop2.setRowGroup(String.valueOf(formattedIndex(0)) + "合    計");
		iReportUseBeanTop2.setCountNum(Integer.valueOf(sumMale));
		list.add(iReportUseBeanTop2);
		for (int m = 0; m < purposes.size(); m++) {
			String columnTop = String.valueOf(formattedIndex(1)) + "合    計";
			String columnGroup = String.valueOf(formattedIndex(0)) + "男";
			String rowTop = String.valueOf(formattedIndex(((PurposeBean) purposes.get(m)).getSequence1() + 1))
					+ ((PurposeBean) purposes.get(m)).getLevel1();
			String rowTop2 = String.valueOf(formattedIndex(((PurposeBean) purposes.get(m)).getSequence2() + 1))
					+ ((PurposeBean) purposes.get(m)).getLevel2();
			String rowGroup = String.valueOf(formattedIndex(((PurposeBean) purposes.get(m)).getSequence() + 1))
					+ ((PurposeBean) purposes.get(m)).getLevel3();
			IReportUseBeanR3C2 iReportUseBean = new IReportUseBeanR3C2();
			iReportUseBean.setColumnTop(columnTop);
			iReportUseBean.setColumnGroup(columnGroup);
			iReportUseBean.setRowTop(rowTop);
			iReportUseBean.setRowTop2(rowTop2);
			iReportUseBean.setRowGroup(rowGroup);
			iReportUseBean.setCountNum(Integer.valueOf(row2[m]));
			list.add(iReportUseBean);
		}
		int sumFeMale = 0;
		for (int n = 0; n < row2.length; n++) {
			if (n != 0 && n != 1 && n != 6 && n != 17)
				sumFeMale += row3[n];
		}
		IReportUseBeanR3C2 iReportUseBeanTop3 = new IReportUseBeanR3C2();
		iReportUseBeanTop3.setColumnTop(String.valueOf(formattedIndex(1)) + "合    計");
		iReportUseBeanTop3.setColumnGroup(String.valueOf(formattedIndex(1)) + "女");
		iReportUseBeanTop3.setRowTop((new StringBuilder(String.valueOf(formattedIndex(0)))).toString());
		iReportUseBeanTop3.setRowTop2((new StringBuilder(String.valueOf(formattedIndex(0)))).toString());
		iReportUseBeanTop3.setRowGroup(String.valueOf(formattedIndex(0)) + "合    計");
		iReportUseBeanTop3.setCountNum(Integer.valueOf(sumFeMale));
		list.add(iReportUseBeanTop3);
		for (int i2 = 0; i2 < purposes.size(); i2++) {
			String columnTop = String.valueOf(formattedIndex(1)) + "合    計";
			String columnGroup = String.valueOf(formattedIndex(1)) + "女";
			String rowTop = String.valueOf(formattedIndex(((PurposeBean) purposes.get(i2)).getSequence1() + 1))
					+ ((PurposeBean) purposes.get(i2)).getLevel1();
			String rowTop2 = String.valueOf(formattedIndex(((PurposeBean) purposes.get(i2)).getSequence2() + 1))
					+ ((PurposeBean) purposes.get(i2)).getLevel2();
			String rowGroup = String.valueOf(formattedIndex(((PurposeBean) purposes.get(i2)).getSequence() + 1))
					+ ((PurposeBean) purposes.get(i2)).getLevel3();
			IReportUseBeanR3C2 iReportUseBean = new IReportUseBeanR3C2();
			iReportUseBean.setColumnTop(columnTop);
			iReportUseBean.setColumnGroup(columnGroup);
			iReportUseBean.setRowTop(rowTop);
			iReportUseBean.setRowTop2(rowTop2);
			iReportUseBean.setRowGroup(rowGroup);
			iReportUseBean.setCountNum(Integer.valueOf(row3[i2]));
			list.add(iReportUseBean);
		}
		int i1;
		for (i1 = 0; i1 < iltb15CountryCodeList.size(); i1++) {
			String columnTop = String.valueOf(formattedIndex(i1 + 2))
					+ ((Iltb15CountryCode) iltb15CountryCodeList.get(i1)).getIlNtnm();
			String columnGroup = String.valueOf(formattedIndex(0)) + "男";
			String rowTop = (new StringBuilder(String.valueOf(formattedIndex(0)))).toString();
			String rowTop2 = (new StringBuilder(String.valueOf(formattedIndex(0)))).toString();
			String rowGroup = String.valueOf(formattedIndex(0)) + "合    計";
			IReportUseBeanR3C2 iReportUseBean = new IReportUseBeanR3C2();
			iReportUseBean.setColumnTop(columnTop);
			iReportUseBean.setColumnGroup(columnGroup);
			iReportUseBean.setRowTop(rowTop);
			iReportUseBean.setRowTop2(rowTop2);
			iReportUseBean.setRowGroup(rowGroup);
			iReportUseBean.setCountNum(Integer.valueOf(column1[i1]));
			list.add(iReportUseBean);
			columnGroup = String.valueOf(formattedIndex(1)) + "女";
			IReportUseBeanR3C2 iReportUseBean2 = new IReportUseBeanR3C2();
			iReportUseBean2.setColumnTop(columnTop);
			iReportUseBean2.setColumnGroup(columnGroup);
			iReportUseBean2.setRowTop(rowTop);
			iReportUseBean2.setRowTop2(rowTop2);
			iReportUseBean2.setRowGroup(rowGroup);
			iReportUseBean2.setCountNum(Integer.valueOf(column2[i1]));
			list.add(iReportUseBean2);
		}
		for (i1 = 0; i1 < iltb15CountryCodeList.size(); i1++) {
			for (int i3 = 0; i3 < purposes.size(); i3++) {
				String columnTop = String.valueOf(formattedIndex(i1 + 2))
						+ ((Iltb15CountryCode) iltb15CountryCodeList.get(i1)).getIlNtnm();
				String columnGroup = String.valueOf(formattedIndex(0)) + "男";
				String rowTop = String.valueOf(formattedIndex(((PurposeBean) purposes.get(i3)).getSequence1() + 1))
						+ ((PurposeBean) purposes.get(i3)).getLevel1();
				String rowTop2 = String.valueOf(formattedIndex(((PurposeBean) purposes.get(i3)).getSequence2() + 1))
						+ ((PurposeBean) purposes.get(i3)).getLevel2();
				String rowGroup = String.valueOf(formattedIndex(((PurposeBean) purposes.get(i3)).getSequence() + 1))
						+ ((PurposeBean) purposes.get(i3)).getLevel3();
				IReportUseBeanR3C2 iReportUseBeanMale = new IReportUseBeanR3C2();
				iReportUseBeanMale.setColumnTop(columnTop);
				iReportUseBeanMale.setColumnGroup(columnGroup);
				iReportUseBeanMale.setRowTop(rowTop);
				iReportUseBeanMale.setRowTop2(rowTop2);
				iReportUseBeanMale.setRowGroup(rowGroup);
				iReportUseBeanMale.setCountNum(Integer.valueOf(countNumMaleArr[i3][i1]));
				list.add(iReportUseBeanMale);
				columnGroup = String.valueOf(formattedIndex(1)) + "女";
				IReportUseBeanR3C2 iReportUseBeanFeMale = new IReportUseBeanR3C2();
				iReportUseBeanFeMale.setColumnTop(columnTop);
				iReportUseBeanFeMale.setColumnGroup(columnGroup);
				iReportUseBeanFeMale.setRowTop(rowTop);
				iReportUseBeanFeMale.setRowTop2(rowTop2);
				iReportUseBeanFeMale.setRowGroup(rowGroup);
				iReportUseBeanFeMale.setCountNum(Integer.valueOf(countNumFeMaleArr[i3][i1]));
				list.add(iReportUseBeanFeMale);
			}
		}
		return new JRBeanCollectionDataSource(list);
	}

	public static JRBeanCollectionDataSource buildByJobAndArea(List<Iltb01Main> iltb01MainList,
			List<Iltb16JobCode> iltb16JobCodeList, List<AreaCodeBean> areaCodes) {
		List<IReportUseBeanR1C2> list = new ArrayList<IReportUseBeanR1C2>();
		int[][] countNumMaleArr = new int[areaCodes.size()][iltb16JobCodeList.size()];
		int[][] countNumFeMaleArr = new int[areaCodes.size()][iltb16JobCodeList.size()];
		int[] row1 = new int[areaCodes.size()];
		int[] row2 = new int[areaCodes.size()];
		int[] row3 = new int[areaCodes.size()];
		int[] column1 = new int[iltb16JobCodeList.size()];
		int[] column2 = new int[iltb16JobCodeList.size()];
		for (Iltb01Main iltb01Main : iltb01MainList) {
			String ilSex = iltb01Main.getIlSex();
			String IlPhq = iltb01Main.getIlPhq();
			String ilJbcd = iltb01Main.getIlJbcd();
			String ilArcrsn = iltb01Main.getIlArcrsn();
			GetDateUtil getDateUtil = new GetDateUtil();
			int nowYear = getDateUtil.getNowDate()[0];
			int birthYear = Integer.parseInt(iltb01Main.getIlBthdt().substring(0, 4));
			int diffYear = nowYear - birthYear;
			if (IlPhq.equals("P000")) {
				IlPhq = "V000";
			} else if (IlPhq.equals("I000")) {
				IlPhq = "B000";
			} else if (IlPhq.equals("O000")) {
				IlPhq = "C000";
			}
			for (int i3 = 0; i3 < iltb16JobCodeList.size(); i3++) {
				String ilJbcdCode = ((Iltb16JobCode) iltb16JobCodeList.get(i3)).getIlOpcd();
				int tempI = i3;
				if (diffYear < 15)
					i3 = iltb16JobCodeList.size() - 1;
				if (ilJbcdCode.equals(ilJbcd)) {
					for (int i4 = 0; i4 < areaCodes.size(); i4++) {
						String areaCode = ((AreaCodeBean) areaCodes.get(i4)).getAreaCode();
						if (IlPhq.equals(areaCode))
							if ("1".equals(ilSex)) {
								countNumMaleArr[i4][i3] = countNumMaleArr[i4][i3] + 1;
								column1[i3] = column1[i3] + 1;
								row1[i4] = row1[i4] + 1;
								row2[i4] = row2[i4] + 1;
								countNumMaleArr[0][i3] = countNumMaleArr[0][i3] + 1;
								row1[0] = row1[0] + 1;
								row2[0] = row2[0] + 1;
								if (i4 >= 2 && i4 <= 16) {
									countNumMaleArr[1][i3] = countNumMaleArr[1][i3] + 1;
									row1[1] = row1[1] + 1;
									row2[1] = row2[1] + 1;
								} else if (i4 >= 18 && i4 <= 22) {
									countNumMaleArr[17][i3] = countNumMaleArr[17][i3] + 1;
									row1[17] = row1[17] + 1;
									row2[17] = row2[17] + 1;
								} else if (i4 >= 24 && i4 <= 25) {
									countNumMaleArr[23][i3] = countNumMaleArr[23][i3] + 1;
									row1[23] = row1[23] + 1;
									row2[23] = row2[23] + 1;
								}
							} else if ("2".equals(ilSex)) {
								countNumFeMaleArr[i4][i3] = countNumFeMaleArr[i4][i3] + 1;
								column2[i3] = column2[i3] + 1;
								row1[i4] = row1[i4] + 1;
								row3[i4] = row3[i4] + 1;
								countNumFeMaleArr[0][i3] = countNumFeMaleArr[0][i3] + 1;
								row1[0] = row1[0] + 1;
								row3[0] = row3[0] + 1;
								if (i4 >= 2 && i4 <= 16) {
									countNumFeMaleArr[1][i3] = countNumFeMaleArr[1][i3] + 1;
									row1[1] = row1[1] + 1;
									row3[1] = row3[1] + 1;
								} else if (i4 >= 18 && i4 <= 22) {
									countNumFeMaleArr[17][i3] = countNumFeMaleArr[17][i3] + 1;
									row1[17] = row1[17] + 1;
									row3[17] = row3[17] + 1;
								} else if (i4 >= 24 && i4 <= 25) {
									countNumFeMaleArr[23][i3] = countNumFeMaleArr[23][i3] + 1;
									row1[23] = row1[23] + 1;
									row3[23] = row3[23] + 1;
								}
							}
					}
				} else if ("".equals(ilJbcd) || ilJbcd == null || ilJbcd == "0") {
					"7".equals(ilArcrsn);
				}
				i3 = tempI;
			}
		}
		int sumAll = 0;
		for (int i = 0; i < row1.length; i++) {
			if (i != 0 && i != 1 && i != 17 && i != 23)
				sumAll += row1[i];
		}
		IReportUseBeanR1C2 iReportUseBeanTop = new IReportUseBeanR1C2();
		iReportUseBeanTop.setColumnTop((new StringBuilder(String.valueOf(formattedIndex(0)))).toString());
		iReportUseBeanTop.setColumnGroup(String.valueOf(formattedIndex(0)) + "總    計");
		iReportUseBeanTop.setRowGroup(String.valueOf(formattedIndex(0)) + "合    計");
		iReportUseBeanTop.setCountNum(Integer.valueOf(sumAll));
		list.add(iReportUseBeanTop);
		for (int j = 0; j < areaCodes.size(); j++) {
			String columnTop = (new StringBuilder(String.valueOf(formattedIndex(0)))).toString();
			String columnGroup = String.valueOf(formattedIndex(0)) + "總    計";
			String rowGroup = String.valueOf(formattedIndex(j + 1)) + ((AreaCodeBean) areaCodes.get(j)).getAreaName();
			IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
			iReportUseBean.setColumnTop(columnTop);
			iReportUseBean.setColumnGroup(columnGroup);
			iReportUseBean.setRowGroup(rowGroup);
			iReportUseBean.setCountNum(Integer.valueOf(row1[j]));
			list.add(iReportUseBean);
		}
		int sumMale = 0;
		for (int k = 0; k < row2.length; k++) {
			if (k != 0 && k != 1 && k != 17 && k != 23)
				sumMale += row2[k];
		}
		IReportUseBeanR1C2 iReportUseBeanTop2 = new IReportUseBeanR1C2();
		iReportUseBeanTop2.setColumnTop(String.valueOf(formattedIndex(1)) + "合    計");
		iReportUseBeanTop2.setColumnGroup(String.valueOf(formattedIndex(0)) + "男");
		iReportUseBeanTop2.setRowGroup(String.valueOf(formattedIndex(0)) + "合    計");
		iReportUseBeanTop2.setCountNum(Integer.valueOf(sumMale));
		list.add(iReportUseBeanTop2);
		for (int m = 0; m < areaCodes.size(); m++) {
			String columnTop = String.valueOf(formattedIndex(1)) + "合    計";
			String columnGroup = String.valueOf(formattedIndex(0)) + "男";
			String rowGroup = String.valueOf(formattedIndex(m + 1)) + ((AreaCodeBean) areaCodes.get(m)).getAreaName();
			IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
			iReportUseBean.setColumnTop(columnTop);
			iReportUseBean.setColumnGroup(columnGroup);
			iReportUseBean.setRowGroup(rowGroup);
			iReportUseBean.setCountNum(Integer.valueOf(row2[m]));
			list.add(iReportUseBean);
		}
		int sumFeMale = 0;
		for (int n = 0; n < row2.length; n++) {
			if (n != 0 && n != 1 && n != 17 && n != 23)
				sumFeMale += row3[n];
		}
		IReportUseBeanR1C2 iReportUseBeanTop3 = new IReportUseBeanR1C2();
		iReportUseBeanTop3.setColumnTop(String.valueOf(formattedIndex(1)) + "合    計");
		iReportUseBeanTop3.setColumnGroup(String.valueOf(formattedIndex(1)) + "女");
		iReportUseBeanTop3.setRowGroup(String.valueOf(formattedIndex(0)) + "合    計");
		iReportUseBeanTop3.setCountNum(Integer.valueOf(sumFeMale));
		list.add(iReportUseBeanTop3);
		for (int i2 = 0; i2 < areaCodes.size(); i2++) {
			String columnTop = String.valueOf(formattedIndex(1)) + "合    計";
			String columnGroup = String.valueOf(formattedIndex(1)) + "女";
			String rowGroup = String.valueOf(formattedIndex(i2 + 1)) + ((AreaCodeBean) areaCodes.get(i2)).getAreaName();
			IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
			iReportUseBean.setColumnTop(columnTop);
			iReportUseBean.setColumnGroup(columnGroup);
			iReportUseBean.setRowGroup(rowGroup);
			iReportUseBean.setCountNum(Integer.valueOf(row3[i2]));
			list.add(iReportUseBean);
		}
		int i1;
		for (i1 = 0; i1 < iltb16JobCodeList.size(); i1++) {
			String columnTop = String.valueOf(formattedIndex(i1 + 2))
					+ ((Iltb16JobCode) iltb16JobCodeList.get(i1)).getIlOpnm();
			String columnGroup = String.valueOf(formattedIndex(0)) + "男";
			String rowGroup = String.valueOf(formattedIndex(0)) + "合    計";
			IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
			iReportUseBean.setColumnTop(columnTop);
			iReportUseBean.setColumnGroup(columnGroup);
			iReportUseBean.setRowGroup(rowGroup);
			iReportUseBean.setCountNum(Integer.valueOf(column1[i1]));
			list.add(iReportUseBean);
			columnGroup = String.valueOf(formattedIndex(1)) + "女";
			IReportUseBeanR1C2 iReportUseBean2 = new IReportUseBeanR1C2();
			iReportUseBean2.setColumnTop(columnTop);
			iReportUseBean2.setColumnGroup(columnGroup);
			iReportUseBean2.setRowGroup(rowGroup);
			iReportUseBean2.setCountNum(Integer.valueOf(column2[i1]));
			list.add(iReportUseBean2);
		}
		for (i1 = 0; i1 < iltb16JobCodeList.size(); i1++) {
			for (int i3 = 0; i3 < areaCodes.size(); i3++) {
				String columnTop = String.valueOf(formattedIndex(i1 + 2))
						+ ((Iltb16JobCode) iltb16JobCodeList.get(i1)).getIlOpnm();
				String columnGroup = String.valueOf(formattedIndex(0)) + "男";
				String rowGroup = String.valueOf(formattedIndex(i3 + 1))
						+ ((AreaCodeBean) areaCodes.get(i3)).getAreaName();
				IReportUseBeanR1C2 iReportUseBeanMale = new IReportUseBeanR1C2();
				iReportUseBeanMale.setColumnTop(columnTop);
				iReportUseBeanMale.setColumnGroup(columnGroup);
				iReportUseBeanMale.setRowGroup(rowGroup);
				iReportUseBeanMale.setCountNum(Integer.valueOf(countNumMaleArr[i3][i1]));
				list.add(iReportUseBeanMale);
				columnGroup = String.valueOf(formattedIndex(1)) + "女";
				IReportUseBeanR1C2 iReportUseBeanFeMale = new IReportUseBeanR1C2();
				iReportUseBeanFeMale.setColumnTop(columnTop);
				iReportUseBeanFeMale.setColumnGroup(columnGroup);
				iReportUseBeanFeMale.setRowGroup(rowGroup);
				iReportUseBeanFeMale.setCountNum(Integer.valueOf(countNumFeMaleArr[i3][i1]));
				list.add(iReportUseBeanFeMale);
			}
		}
		return new JRBeanCollectionDataSource(list);
	}

	public static JRBeanCollectionDataSource buildByIDTypeAndArea(List<Iltb01Main> iltb01MainList,
			List<IDTypeBean> idTypes, List<AreaCodeBean> areaCodes) {
		List<IReportUseBeanR1C2> list = new ArrayList<IReportUseBeanR1C2>();
		int[][] countNumMaleArr = new int[areaCodes.size()][idTypes.size()];
		int[][] countNumFeMaleArr = new int[areaCodes.size()][idTypes.size()];
		int[] row1 = new int[areaCodes.size()];
		int[] row2 = new int[areaCodes.size()];
		int[] row3 = new int[areaCodes.size()];
		int[] column1 = new int[idTypes.size()];
		int[] column2 = new int[idTypes.size()];
		for (Iltb01Main iltb01Main : iltb01MainList) {
			String ilSex = iltb01Main.getIlSex();
			String IlPhq = iltb01Main.getIlPhq();
			String ilArctp = iltb01Main.getIlArctp();
			if (IlPhq.equals("P000")) {
				IlPhq = "V000";
			} else if (IlPhq.equals("I000")) {
				IlPhq = "B000";
			} else if (IlPhq.equals("O000")) {
				IlPhq = "C000";
			}
			for (int i3 = 0; i3 < idTypes.size(); i3++) {
				String ilIDCode = String.valueOf(((IDTypeBean) idTypes.get(i3)).getSequence());
				if (ilArctp.equals(ilIDCode))
					for (int i4 = 0; i4 < areaCodes.size(); i4++) {
						String areaCode = ((AreaCodeBean) areaCodes.get(i4)).getAreaCode();
						if (IlPhq.equals(areaCode))
							if ("1".equals(ilSex)) {
								countNumMaleArr[i4][i3] = countNumMaleArr[i4][i3] + 1;
								column1[i3] = column1[i3] + 1;
								row1[i4] = row1[i4] + 1;
								row2[i4] = row2[i4] + 1;
								countNumMaleArr[0][i3] = countNumMaleArr[0][i3] + 1;
								row1[0] = row1[0] + 1;
								row2[0] = row2[0] + 1;
								if (i4 >= 2 && i4 <= 16) {
									countNumMaleArr[1][i3] = countNumMaleArr[1][i3] + 1;
									row1[1] = row1[1] + 1;
									row2[1] = row2[1] + 1;
								} else if (i4 >= 18 && i4 <= 22) {
									countNumMaleArr[17][i3] = countNumMaleArr[17][i3] + 1;
									row1[17] = row1[17] + 1;
									row2[17] = row2[17] + 1;
								} else if (i4 >= 24 && i4 <= 25) {
									countNumMaleArr[23][i3] = countNumMaleArr[23][i3] + 1;
									row1[23] = row1[23] + 1;
									row2[23] = row2[23] + 1;
								}
							} else if ("2".equals(ilSex)) {
								countNumFeMaleArr[i4][i3] = countNumFeMaleArr[i4][i3] + 1;
								column2[i3] = column2[i3] + 1;
								row1[i4] = row1[i4] + 1;
								row3[i4] = row3[i4] + 1;
								countNumFeMaleArr[0][i3] = countNumFeMaleArr[0][i3] + 1;
								row1[0] = row1[0] + 1;
								row3[0] = row3[0] + 1;
								if (i4 >= 2 && i4 <= 16) {
									countNumFeMaleArr[1][i3] = countNumFeMaleArr[1][i3] + 1;
									row1[1] = row1[1] + 1;
									row3[1] = row3[1] + 1;
								} else if (i4 >= 18 && i4 <= 22) {
									countNumFeMaleArr[17][i3] = countNumFeMaleArr[17][i3] + 1;
									row1[17] = row1[17] + 1;
									row3[17] = row3[17] + 1;
								} else if (i4 >= 24 && i4 <= 25) {
									countNumFeMaleArr[23][i3] = countNumFeMaleArr[23][i3] + 1;
									row1[23] = row1[23] + 1;
									row3[23] = row3[23] + 1;
								}
							}
					}
			}
		}
		int sumAll = 0;
		for (int i = 0; i < row1.length; i++) {
			if (i != 0 && i != 1 && i != 17 && i != 23)
				sumAll += row1[i];
		}
		IReportUseBeanR1C2 iReportUseBeanTop = new IReportUseBeanR1C2();
		iReportUseBeanTop.setColumnTop((new StringBuilder(String.valueOf(formattedIndex(0)))).toString());
		iReportUseBeanTop.setColumnGroup(String.valueOf(formattedIndex(0)) + "總    計");
		iReportUseBeanTop.setRowGroup(String.valueOf(formattedIndex(0)) + "合    計");
		iReportUseBeanTop.setCountNum(Integer.valueOf(sumAll));
		list.add(iReportUseBeanTop);
		for (int j = 0; j < areaCodes.size(); j++) {
			String columnTop = (new StringBuilder(String.valueOf(formattedIndex(0)))).toString();
			String columnGroup = String.valueOf(formattedIndex(0)) + "總    計";
			String rowGroup = String.valueOf(formattedIndex(j + 1)) + ((AreaCodeBean) areaCodes.get(j)).getAreaName();
			IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
			iReportUseBean.setColumnTop(columnTop);
			iReportUseBean.setColumnGroup(columnGroup);
			iReportUseBean.setRowGroup(rowGroup);
			iReportUseBean.setCountNum(Integer.valueOf(row1[j]));
			list.add(iReportUseBean);
		}
		int sumMale = 0;
		for (int k = 0; k < row2.length; k++) {
			if (k != 0 && k != 1 && k != 17 && k != 23)
				sumMale += row2[k];
		}
		IReportUseBeanR1C2 iReportUseBeanTop2 = new IReportUseBeanR1C2();
		iReportUseBeanTop2.setColumnTop(String.valueOf(formattedIndex(1)) + "合    計");
		iReportUseBeanTop2.setColumnGroup(String.valueOf(formattedIndex(0)) + "男");
		iReportUseBeanTop2.setRowGroup(String.valueOf(formattedIndex(0)) + "合    計");
		iReportUseBeanTop2.setCountNum(Integer.valueOf(sumMale));
		list.add(iReportUseBeanTop2);
		for (int m = 0; m < areaCodes.size(); m++) {
			String columnTop = String.valueOf(formattedIndex(1)) + "合    計";
			String columnGroup = String.valueOf(formattedIndex(0)) + "男";
			String rowGroup = String.valueOf(formattedIndex(m + 1)) + ((AreaCodeBean) areaCodes.get(m)).getAreaName();
			IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
			iReportUseBean.setColumnTop(columnTop);
			iReportUseBean.setColumnGroup(columnGroup);
			iReportUseBean.setRowGroup(rowGroup);
			iReportUseBean.setCountNum(Integer.valueOf(row2[m]));
			list.add(iReportUseBean);
		}
		int sumFeMale = 0;
		for (int n = 0; n < row2.length; n++) {
			if (n != 0 && n != 1 && n != 17 && n != 23)
				sumFeMale += row3[n];
		}
		IReportUseBeanR1C2 iReportUseBeanTop3 = new IReportUseBeanR1C2();
		iReportUseBeanTop3.setColumnTop(String.valueOf(formattedIndex(1)) + "合    計");
		iReportUseBeanTop3.setColumnGroup(String.valueOf(formattedIndex(1)) + "女");
		iReportUseBeanTop3.setRowGroup(String.valueOf(formattedIndex(0)) + "合    計");
		iReportUseBeanTop3.setCountNum(Integer.valueOf(sumFeMale));
		list.add(iReportUseBeanTop3);
		for (int i2 = 0; i2 < areaCodes.size(); i2++) {
			String columnTop = String.valueOf(formattedIndex(1)) + "合    計";
			String columnGroup = String.valueOf(formattedIndex(1)) + "女";
			String rowGroup = String.valueOf(formattedIndex(i2 + 1)) + ((AreaCodeBean) areaCodes.get(i2)).getAreaName();
			IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
			iReportUseBean.setColumnTop(columnTop);
			iReportUseBean.setColumnGroup(columnGroup);
			iReportUseBean.setRowGroup(rowGroup);
			iReportUseBean.setCountNum(Integer.valueOf(row3[i2]));
			list.add(iReportUseBean);
		}
		int i1;
		for (i1 = 0; i1 < idTypes.size(); i1++) {
			String columnTop = String.valueOf(formattedIndex(i1 + 2)) + ((IDTypeBean) idTypes.get(i1)).getTypeName();
			String columnGroup = String.valueOf(formattedIndex(0)) + "男";
			String rowGroup = String.valueOf(formattedIndex(0)) + "合    計";
			IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
			iReportUseBean.setColumnTop(columnTop);
			iReportUseBean.setColumnGroup(columnGroup);
			iReportUseBean.setRowGroup(rowGroup);
			iReportUseBean.setCountNum(Integer.valueOf(column1[i1]));
			list.add(iReportUseBean);
			columnGroup = String.valueOf(formattedIndex(1)) + "女";
			IReportUseBeanR1C2 iReportUseBean2 = new IReportUseBeanR1C2();
			iReportUseBean2.setColumnTop(columnTop);
			iReportUseBean2.setColumnGroup(columnGroup);
			iReportUseBean2.setRowGroup(rowGroup);
			iReportUseBean2.setCountNum(Integer.valueOf(column2[i1]));
			list.add(iReportUseBean2);
		}
		for (i1 = 0; i1 < idTypes.size(); i1++) {
			for (int i3 = 0; i3 < areaCodes.size(); i3++) {
				String columnTop = String.valueOf(formattedIndex(i1 + 2))
						+ ((IDTypeBean) idTypes.get(i1)).getTypeName();
				String columnGroup = String.valueOf(formattedIndex(0)) + "男";
				String rowGroup = String.valueOf(formattedIndex(i3 + 1))
						+ ((AreaCodeBean) areaCodes.get(i3)).getAreaName();
				IReportUseBeanR1C2 iReportUseBeanMale = new IReportUseBeanR1C2();
				iReportUseBeanMale.setColumnTop(columnTop);
				iReportUseBeanMale.setColumnGroup(columnGroup);
				iReportUseBeanMale.setRowGroup(rowGroup);
				iReportUseBeanMale.setCountNum(Integer.valueOf(countNumMaleArr[i3][i1]));
				list.add(iReportUseBeanMale);
				columnGroup = String.valueOf(formattedIndex(1)) + "女";
				IReportUseBeanR1C2 iReportUseBeanFeMale = new IReportUseBeanR1C2();
				iReportUseBeanFeMale.setColumnTop(columnTop);
				iReportUseBeanFeMale.setColumnGroup(columnGroup);
				iReportUseBeanFeMale.setRowGroup(rowGroup);
				iReportUseBeanFeMale.setCountNum(Integer.valueOf(countNumFeMaleArr[i3][i1]));
				list.add(iReportUseBeanFeMale);
			}
		}
		return new JRBeanCollectionDataSource(list);
	}

	public static JRBeanCollectionDataSource buildByPeopleNumberTypeAndCountry(List<Iltb01Main> iltb01MainList,
			List<PeopleNumberTypeBean> peopleNumberTypes, List<Iltb15CountryCode> iltb15CountryCodeList) {
		List<IReportUseBeanR2C1> list = new ArrayList<IReportUseBeanR2C1>();
		int[][] countNumMaleArr = new int[iltb15CountryCodeList.size()][peopleNumberTypes.size()];
		int[][] countNumFeMaleArr = new int[iltb15CountryCodeList.size()][peopleNumberTypes.size()];
		int[] row1 = new int[peopleNumberTypes.size()];
		int[] row2 = new int[peopleNumberTypes.size()];
		int[] row3 = new int[peopleNumberTypes.size()];
		for (Iltb01Main iltb01Main : iltb01MainList) {
			String ilSex = iltb01Main.getIlSex();
			String ilNtcd = iltb01Main.getIlNtcd();
			Timestamp ilSmbtdt = iltb01Main.getIlSbmtdt();
			Timestamp ilFnddt = iltb01Main.getIlFnddt();
			boolean isNew = false;
			if (isOneMonthBefore(ilSmbtdt))
				isNew = true;
			boolean isFound = false;
			if (isOneMonthBefore(ilFnddt))
				isFound = true;
			boolean isInFirstSix = false;
			int idx = 0;
			for (int j = 0; j < iltb15CountryCodeList.size(); j++) {
				String ilNtcdCode = ((Iltb15CountryCode) iltb15CountryCodeList.get(j)).getIlNtcd();
				if (ilNtcdCode.equals(ilNtcd)) {
					isInFirstSix = true;
					idx = j;
				}
			}
			if (!isInFirstSix)
				idx = peopleNumberTypes.size() - 1;
			if ("1".equals(ilSex)) {
				countNumMaleArr[idx][0] = countNumMaleArr[idx][0] + 1;
				row1[0] = row1[0] + 1;
				row2[0] = row2[0] + 1;
				if (isNew) {
					countNumMaleArr[idx][1] = countNumMaleArr[idx][1] + 1;
					row1[1] = row1[1] + 1;
					row2[1] = row2[1] + 1;
				}
				if (isFound) {
					countNumMaleArr[idx][2] = countNumMaleArr[idx][2] + 1;
					row1[2] = row1[2] + 1;
					row2[2] = row2[2] + 1;
				}
				continue;
			}
			if ("2".equals(ilSex)) {
				countNumFeMaleArr[idx][0] = countNumFeMaleArr[idx][0] + 1;
				row1[0] = row1[0] + 1;
				row3[0] = row3[0] + 1;
				if (isNew) {
					countNumFeMaleArr[idx][1] = countNumFeMaleArr[idx][1] + 1;
					row1[1] = row1[1] + 1;
					row2[1] = row2[1] + 1;
				}
				if (isFound) {
					countNumFeMaleArr[idx][2] = countNumFeMaleArr[idx][2] + 1;
					row1[2] = row1[2] + 1;
					row2[2] = row2[2] + 1;
				}
			}
		}
		int i;
		for (i = 0; i < peopleNumberTypes.size(); i++) {
			String rowTop = "     ";
			String rowGroup = "總    計";
			String columnGroup = String.valueOf(formattedIndex(i))
					+ ((PeopleNumberTypeBean) peopleNumberTypes.get(i)).getTypeName();
			IReportUseBeanR2C1 iReportUseBean = new IReportUseBeanR2C1();
			iReportUseBean.setColumnGroup(columnGroup);
			iReportUseBean.setRowGroup(rowGroup);
			iReportUseBean.setRowTop(rowTop);
			iReportUseBean.setCountNum(Integer.valueOf(row1[i]));
			list.add(iReportUseBean);
		}
		for (i = 0; i < peopleNumberTypes.size(); i++) {
			String rowTop = "     合    計";
			String rowGroup = String.valueOf(formattedIndex(0)) + "男";
			String columnGroup = String.valueOf(formattedIndex(i))
					+ ((PeopleNumberTypeBean) peopleNumberTypes.get(i)).getTypeName();
			IReportUseBeanR2C1 iReportUseBean = new IReportUseBeanR2C1();
			iReportUseBean.setColumnGroup(columnGroup);
			iReportUseBean.setRowGroup(rowGroup);
			iReportUseBean.setRowTop(rowTop);
			iReportUseBean.setCountNum(Integer.valueOf(row2[i]));
			list.add(iReportUseBean);
		}
		for (i = 0; i < peopleNumberTypes.size(); i++) {
			String rowTop = "     合    計";
			String rowGroup = String.valueOf(formattedIndex(1)) + "女";
			String columnGroup = String.valueOf(formattedIndex(i))
					+ ((PeopleNumberTypeBean) peopleNumberTypes.get(i)).getTypeName();
			IReportUseBeanR2C1 iReportUseBean = new IReportUseBeanR2C1();
			iReportUseBean.setColumnGroup(columnGroup);
			iReportUseBean.setRowGroup(rowGroup);
			iReportUseBean.setRowTop(rowTop);
			iReportUseBean.setCountNum(Integer.valueOf(row3[i]));
			list.add(iReportUseBean);
		}
		for (i = 0; i < peopleNumberTypes.size(); i++) {
			int j;
			for (j = 0; j < iltb15CountryCodeList.size(); j++) {
				String rowTop = String.valueOf(formattedIndex(j))
						+ ((Iltb15CountryCode) iltb15CountryCodeList.get(j)).getIlNtnm();
				String rowGroup = String.valueOf(formattedIndex(0)) + "男";
				String columnGroup = String.valueOf(formattedIndex(i))
						+ ((PeopleNumberTypeBean) peopleNumberTypes.get(i)).getTypeName();
				IReportUseBeanR2C1 iReportUseBeanMale = new IReportUseBeanR2C1();
				iReportUseBeanMale.setColumnGroup(columnGroup);
				iReportUseBeanMale.setRowGroup(rowGroup);
				iReportUseBeanMale.setRowTop(rowTop);
				iReportUseBeanMale.setCountNum(Integer.valueOf(countNumMaleArr[j][i]));
				list.add(iReportUseBeanMale);
			}
			for (j = 0; j < iltb15CountryCodeList.size(); j++) {
				String rowTop = String.valueOf(formattedIndex(j))
						+ ((Iltb15CountryCode) iltb15CountryCodeList.get(j)).getIlNtnm();
				String rowGroup = String.valueOf(formattedIndex(1)) + "女";
				String columnGroup = String.valueOf(formattedIndex(i))
						+ ((PeopleNumberTypeBean) peopleNumberTypes.get(i)).getTypeName();
				IReportUseBeanR2C1 iReportUseBeanFeMale = new IReportUseBeanR2C1();
				iReportUseBeanFeMale.setColumnGroup(columnGroup);
				iReportUseBeanFeMale.setRowGroup(rowGroup);
				iReportUseBeanFeMale.setRowTop(rowTop);
				iReportUseBeanFeMale.setCountNum(Integer.valueOf(countNumFeMaleArr[j][i]));
				list.add(iReportUseBeanFeMale);
			}
		}
		return new JRBeanCollectionDataSource(list);
	}

	private static int findPurposeSequence(String ilArcrsn, String ilOfnm) {
		int idxPurpose = 0;
		if (ilArcrsn.equals("1")) {
			if (ilOfnm == null || ilOfnm.indexOf("-") < 0) {
				idxPurpose = 10;
			} else {
				int idx1 = ilOfnm.indexOf("-");
				if (ilOfnm.charAt(idx1 + 2) == ' ' || ilOfnm.charAt(idx1 + 2) == '　') {
					if (ilOfnm.indexOf("夫") > 0 || ilOfnm.indexOf("妻") > 0) {
						idxPurpose = 7;
					} else if (ilOfnm.indexOf("子") > 0 || ilOfnm.indexOf("女") > 0) {
						idxPurpose = 8;
					} else if (ilOfnm.indexOf("父") > 0 || ilOfnm.indexOf("母") > 0) {
						idxPurpose = 9;
					} else {
						idxPurpose = 10;
					}
				} else if (ilOfnm.indexOf("夫") > 0 || ilOfnm.indexOf("妻") > 0) {
					idxPurpose = 2;
				} else if (ilOfnm.indexOf("子") > 0 || ilOfnm.indexOf("女") > 0) {
					idxPurpose = 3;
				} else if (ilOfnm.indexOf("父") > 0 || ilOfnm.indexOf("母") > 0) {
					idxPurpose = 4;
				} else {
					idxPurpose = 5;
				}
			}
		} else if (ilArcrsn.equals("2")) {
			idxPurpose = 11;
		} else if (ilArcrsn.equals("3")) {
			idxPurpose = 12;
		} else if (ilArcrsn.equals("4")) {
			idxPurpose = 13;
		} else if (ilArcrsn.equals("5")) {
			idxPurpose = 14;
		} else if (ilArcrsn.equals("7")) {
			idxPurpose = 15;
		} else if (ilArcrsn.equals("6")) {
			idxPurpose = 16;
		} else if (ilArcrsn.equals("8")) {
			idxPurpose = 18;
		} else if (ilArcrsn.equals("9")) {
			idxPurpose = 19;
		} else if (ilArcrsn.equals("A")) {
			idxPurpose = 20;
		} else if (ilArcrsn.equals("B")) {
			idxPurpose = 21;
		} else if (ilArcrsn.equals("C")) {
			idxPurpose = 22;
		} else if (ilArcrsn.equals("D")) {
			idxPurpose = 23;
		} else if (ilArcrsn.equals("E")) {
			idxPurpose = 24;
		} else if (ilArcrsn.equals("F")) {
			idxPurpose = 25;
		} else if (ilArcrsn.equals("G")) {
			idxPurpose = 26;
		}
		return idxPurpose;
	}

	private static boolean isOneMonthBefore(Timestamp testDate) {
		if (testDate == null)
			return false;
		Calendar c = Calendar.getInstance();
		c.add(2, -1);
		String nowString = getDateStrin(c);
		c.setTimeInMillis(testDate.getTime());
		String testString = getDateStrin(c);
		return nowString.equals(testString);
	}

	private static String getDateStrin(Calendar c) {
		return ""+c.get(Calendar.YEAR)+""+c.get(Calendar.MONTH)+""+c.get(Calendar.DAY_OF_MONTH);//反正都轉成一樣的字串來比，也不用管要不要補零
	}

	private static String formattedIndex(int idx) {
		DecimalFormat df = new DecimalFormat("00000");
		return df.format(idx);
	}
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\report\data\il04a01\
 * CommonDataBuilder.class Java compiler version: 5 (49.0) JD-Core Version:
 * 1.1.3
 */