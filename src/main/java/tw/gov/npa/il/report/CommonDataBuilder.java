package tw.gov.npa.il.report;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.log4j.Logger;
import tw.gov.npa.il.dao.Iltb01Main;
import tw.gov.npa.il.dao.Iltb15CountryCode;
import tw.gov.npa.il.dao.Iltb16JobCode;
import tw.gov.npa.il.report.bean.AreaCodeBean;
import tw.gov.npa.il.report.bean.IDTypeBean;
import tw.gov.npa.il.report.bean.IReportUseBeanR1C2;
import tw.gov.npa.il.report.bean.IReportUseBeanR1C4;
import tw.gov.npa.il.report.bean.IReportUseBeanR2C1;
import tw.gov.npa.il.report.bean.IReportUseBeanR3C2;
import tw.gov.npa.il.report.bean.JobCodeBean;
import tw.gov.npa.il.report.bean.PeopleNumberTypeBean;
import tw.gov.npa.il.report.bean.PurposeBean;
import tw.gov.npa.il.report.bean.YearBean;
import tw.gov.npa.il.util.GetDateUtil;

public class CommonDataBuilder {
  private static final Logger logger = Logger.getLogger(CommonDataBuilder.class);
  
  public static JRBeanCollectionDataSource buildByCountryAndJob(List<Iltb01Main> iltb01MainList, List<Iltb15CountryCode> iltb15CountryCodeList, List<Iltb16JobCode> iltb16JobCodeList, List<JobCodeBean> jodeCodeBeanList) {
    List<IReportUseBeanR1C2> list = new ArrayList<IReportUseBeanR1C2>();
    int[][] countNumMaleArr = new int[jodeCodeBeanList.size()][iltb15CountryCodeList.size()];
    int[][] countNumFeMaleArr = new int[jodeCodeBeanList.size()][iltb15CountryCodeList.size()];
    int[] row1 = new int[jodeCodeBeanList.size()];
    int[] row2 = new int[jodeCodeBeanList.size()];
    int[] row3 = new int[jodeCodeBeanList.size()];
    int[] column1 = new int[iltb15CountryCodeList.size()];
    int[] column2 = new int[iltb15CountryCodeList.size()];
    for (int i = 0; i < iltb15CountryCodeList.size(); i++) {
      boolean hasMatch = false;
      for (Iltb01Main iltb01Main : iltb01MainList) {
        String ilSex = iltb01Main.getIlSex();
        String ilNtcd = iltb01Main.getIlNtcd();
        String ilJbcd = iltb01Main.getIlJbcd();
        String ilArcrsn = iltb01Main.getIlArcrsn();
        GetDateUtil getDateUtil = new GetDateUtil();
        int nowYear = getDateUtil.getNowDate()[0];
        int birthYear = Integer.parseInt(iltb01Main.getIlBthdt().substring(0, 4));
        int diffYear = nowYear - birthYear;
        if (diffYear < 15) {
          ilJbcd = "99";
        } else if ("".equals(ilJbcd) || ilJbcd == null || ilJbcd == "0") {
          if ("7".equals(ilArcrsn)) {
            ilJbcd = "40";
          } else if ("3".equals(ilArcrsn)) {
            ilJbcd = "24";
          } else {
            ilJbcd = "25";
          } 
        } else if (ilJbcd.equals("08") && ilSex.equals("1")) {
          ilJbcd = "24";
        } else if (ilJbcd.equals("25") && diffYear <= 64) {
          ilJbcd = "98";
        } 
        String ilNtcdCode = ((Iltb15CountryCode)iltb15CountryCodeList.get(i)).getIlNtcd();
        if (ilNtcdCode.equals(ilNtcd)) {
          hasMatch = true;
          for (int i4 = 0; i4 < iltb16JobCodeList.size(); i4++) {
            String ilJbcdCode = ((Iltb16JobCode)iltb16JobCodeList.get(i4)).getIlOpcd();
            String ilopcs = ((Iltb16JobCode)iltb16JobCodeList.get(i4)).getIlOpcs();
            int idx = 0;
            if (ilJbcdCode.equals(ilJbcd)) {
              for (int i5 = 0; i5 < jodeCodeBeanList.size(); i5++) {
                if (((JobCodeBean)jodeCodeBeanList.get(i5)).getCode().equals(ilopcs))
                  idx = i5; 
              } 
              if ("1".equals(ilSex)) {
                countNumMaleArr[idx][i] = countNumMaleArr[idx][i] + 1;
                column1[i] = column1[i] + 1;
                row1[idx] = row1[idx] + 1;
                row2[idx] = row2[idx] + 1;
                if (idx >= 12 && idx <= 17) {
                  countNumMaleArr[11][i] = countNumMaleArr[11][i] + 1;
                  row1[11] = row1[11] + 1;
                  row2[11] = row2[11] + 1;
                } 
              } else if ("2".equals(ilSex)) {
                countNumFeMaleArr[idx][i] = countNumFeMaleArr[idx][i] + 1;
                column2[i] = column2[i] + 1;
                row1[idx] = row1[idx] + 1;
                row3[idx] = row3[idx] + 1;
                if (idx >= 12 && idx <= 17) {
                  countNumFeMaleArr[11][i] = countNumFeMaleArr[11][i] + 1;
                  row1[11] = row1[11] + 1;
                  row3[11] = row3[11] + 1;
                } 
              } 
            } 
          } 
        } 
      } 
      if (!hasMatch) {
        iltb15CountryCodeList.remove(i);
        i--;
      } 
    } 
    int sumAll = 0;
    for (int k = 0; k < row1.length; k++) {
      if (k != 11)
        sumAll += row1[k]; 
    } 
    IReportUseBeanR1C2 iReportUseBeanTop = new IReportUseBeanR1C2();
    iReportUseBeanTop.setColumnTop(formattedIndex(0) + "");
    iReportUseBeanTop.setColumnGroup(formattedIndex(0) + "總    計");
    iReportUseBeanTop.setRowGroup(formattedIndex(0) + "合    計");
    iReportUseBeanTop.setCountNum(Integer.valueOf(sumAll));
    list.add(iReportUseBeanTop);
    for (int j = 0; j < jodeCodeBeanList.size(); j++) {
      String columnTop = formattedIndex(0) + "";
      String columnGroup = formattedIndex(0) + "總    計";
      String rowGroup = formattedIndex(j + 1) + ((JobCodeBean)jodeCodeBeanList.get(j)).getName();
      IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
      iReportUseBean.setColumnTop(columnTop);
      iReportUseBean.setColumnGroup(columnGroup);
      iReportUseBean.setRowGroup(rowGroup);
      iReportUseBean.setCountNum(Integer.valueOf(row1[j]));
      list.add(iReportUseBean);
    } 
    int sumMale = 0;
    for (int m = 0; m < row2.length; m++) {
      if (m != 11)
        sumMale += row2[m]; 
    } 
    IReportUseBeanR1C2 iReportUseBeanTop2 = new IReportUseBeanR1C2();
    iReportUseBeanTop2.setColumnTop(formattedIndex(1) + "合    計");
    iReportUseBeanTop2.setColumnGroup(formattedIndex(0) + "男");
    iReportUseBeanTop2.setRowGroup(formattedIndex(0) + "合    計");
    iReportUseBeanTop2.setCountNum(Integer.valueOf(sumMale));
    list.add(iReportUseBeanTop2);
    for (int n = 0; n < jodeCodeBeanList.size(); n++) {
      String columnTop = formattedIndex(1) + "合    計";
      String columnGroup = formattedIndex(0) + "男";
      String rowGroup = formattedIndex(n + 1) + ((JobCodeBean)jodeCodeBeanList.get(n)).getName();
      IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
      iReportUseBean.setColumnTop(columnTop);
      iReportUseBean.setColumnGroup(columnGroup);
      iReportUseBean.setRowGroup(rowGroup);
      iReportUseBean.setCountNum(Integer.valueOf(row2[n]));
      list.add(iReportUseBean);
    } 
    int sumFeMale = 0;
    for (int i1 = 0; i1 < row2.length; i1++) {
      if (i1 != 11)
        sumFeMale += row3[i1]; 
    } 
    IReportUseBeanR1C2 iReportUseBeanTop3 = new IReportUseBeanR1C2();
    iReportUseBeanTop3.setColumnTop(formattedIndex(1) + "合    計");
    iReportUseBeanTop3.setColumnGroup(formattedIndex(1) + "女");
    iReportUseBeanTop3.setRowGroup(formattedIndex(0) + "合    計");
    iReportUseBeanTop3.setCountNum(Integer.valueOf(sumFeMale));
    list.add(iReportUseBeanTop3);
    for (int i3 = 0; i3 < jodeCodeBeanList.size(); i3++) {
      String columnTop = formattedIndex(1) + "合    計";
      String columnGroup = formattedIndex(1) + "女";
      String rowGroup = formattedIndex(i3 + 1) + ((JobCodeBean)jodeCodeBeanList.get(i3)).getName();
      IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
      iReportUseBean.setColumnTop(columnTop);
      iReportUseBean.setColumnGroup(columnGroup);
      iReportUseBean.setRowGroup(rowGroup);
      iReportUseBean.setCountNum(Integer.valueOf(row3[i3]));
      list.add(iReportUseBean);
    } 
    int i2;
    for (i2 = 0; i2 < iltb15CountryCodeList.size(); i2++) {
      String columnTop = formattedIndex(i2 + 2) + ((Iltb15CountryCode)iltb15CountryCodeList.get(i2)).getIlNtnm();
      String columnGroup = formattedIndex(0) + "男";
      String rowGroup = formattedIndex(0) + "合    計";
      IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
      iReportUseBean.setColumnTop(columnTop);
      iReportUseBean.setColumnGroup(columnGroup);
      iReportUseBean.setRowGroup(rowGroup);
      iReportUseBean.setCountNum(Integer.valueOf(column1[i2]));
      list.add(iReportUseBean);
      columnGroup = formattedIndex(1) + "女";
      IReportUseBeanR1C2 iReportUseBean2 = new IReportUseBeanR1C2();
      iReportUseBean2.setColumnTop(columnTop);
      iReportUseBean2.setColumnGroup(columnGroup);
      iReportUseBean2.setRowGroup(rowGroup);
      iReportUseBean2.setCountNum(Integer.valueOf(column2[i2]));
      list.add(iReportUseBean2);
    } 
    for (i2 = 0; i2 < iltb15CountryCodeList.size(); i2++) {
      for (int i4 = 0; i4 < jodeCodeBeanList.size(); i4++) {
        String columnTop = formattedIndex(i2 + 2) + ((Iltb15CountryCode)iltb15CountryCodeList.get(i2)).getIlNtnm();
        String columnGroup = formattedIndex(0) + "男";
        String rowGroup = formattedIndex(i4 + 1) + ((JobCodeBean)jodeCodeBeanList.get(i4)).getName();
        IReportUseBeanR1C2 iReportUseBeanMale = new IReportUseBeanR1C2();
        iReportUseBeanMale.setColumnTop(columnTop);
        iReportUseBeanMale.setColumnGroup(columnGroup);
        iReportUseBeanMale.setRowGroup(rowGroup);
        iReportUseBeanMale.setCountNum(Integer.valueOf(countNumMaleArr[i4][i2]));
        list.add(iReportUseBeanMale);
        columnGroup = formattedIndex(1) + "女";
        IReportUseBeanR1C2 iReportUseBeanFeMale = new IReportUseBeanR1C2();
        iReportUseBeanFeMale.setColumnTop(columnTop);
        iReportUseBeanFeMale.setColumnGroup(columnGroup);
        iReportUseBeanFeMale.setRowGroup(rowGroup);
        iReportUseBeanFeMale.setCountNum(Integer.valueOf(countNumFeMaleArr[i4][i2]));
        list.add(iReportUseBeanFeMale);
      } 
    } 
    return new JRBeanCollectionDataSource(list);
  }
  
  public static JRBeanCollectionDataSource buildByCountryAndArea(List<Iltb01Main> iltb01MainList, List<Iltb15CountryCode> iltb15CountryCodeList, List<AreaCodeBean> areaCodes) {
    List<IReportUseBeanR1C2> list = new ArrayList<IReportUseBeanR1C2>();
    int[][] countNumMaleArr = new int[areaCodes.size()][iltb15CountryCodeList.size()];
    int[][] countNumFeMaleArr = new int[areaCodes.size()][iltb15CountryCodeList.size()];
    int[] row1 = new int[areaCodes.size()];
    int[] row2 = new int[areaCodes.size()];
    int[] row3 = new int[areaCodes.size()];
    int[] column1 = new int[iltb15CountryCodeList.size()];
    int[] column2 = new int[iltb15CountryCodeList.size()];
    for (int j = 0; j < areaCodes.size(); j++) {
      String areaCode = ((AreaCodeBean)areaCodes.get(j)).getAreaName();
      logger.info(areaCode);
    } 
    for (int i = 0; i < iltb15CountryCodeList.size(); i++) {
      boolean hasMatch = false;
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
        String ilNtcdCode = ((Iltb15CountryCode)iltb15CountryCodeList.get(i)).getIlNtcd();
        if (ilNtcdCode.equals(ilNtcd)) {
          hasMatch = true;
          for (int i5 = 0; i5 < areaCodes.size(); i5++) {
            String areaCode = ((AreaCodeBean)areaCodes.get(i5)).getAreaCode();
            if (IlPhq.equals(areaCode))
              if ("1".equals(ilSex)) {
                countNumMaleArr[i5][i] = countNumMaleArr[i5][i] + 1;
                column1[i] = column1[i] + 1;
                row1[i5] = row1[i5] + 1;
                row2[i5] = row2[i5] + 1;
                if (i5 >= 2 && i5 <= 15) {
                  countNumMaleArr[0][i] = countNumMaleArr[0][i] + 1;
                  row1[0] = row1[0] + 1;
                  row2[0] = row2[0] + 1;
                  countNumMaleArr[1][i] = countNumMaleArr[1][i] + 1;
                  row1[1] = row1[1] + 1;
                  row2[1] = row2[1] + 1;
                } else if (i5 >= 17 && i5 <= 22) {
                  countNumMaleArr[0][i] = countNumMaleArr[0][i] + 1;
                  row1[0] = row1[0] + 1;
                  row2[0] = row2[0] + 1;
                  countNumMaleArr[16][i] = countNumMaleArr[16][i] + 1;
                  row1[16] = row1[16] + 1;
                  row2[16] = row2[16] + 1;
                } else if (i5 >= 24 && i5 <= 25) {
                  countNumMaleArr[23][i] = countNumMaleArr[23][i] + 1;
                  row1[23] = row1[23] + 1;
                  row2[23] = row2[23] + 1;
                } 
              } else if ("2".equals(ilSex)) {
                countNumFeMaleArr[i5][i] = countNumFeMaleArr[i5][i] + 1;
                column2[i] = column2[i] + 1;
                row1[i5] = row1[i5] + 1;
                row3[i5] = row3[i5] + 1;
                if (i5 >= 2 && i5 <= 15) {
                  countNumFeMaleArr[0][i] = countNumFeMaleArr[0][i] + 1;
                  row1[0] = row1[0] + 1;
                  row3[0] = row3[0] + 1;
                  countNumFeMaleArr[1][i] = countNumFeMaleArr[1][i] + 1;
                  row1[1] = row1[1] + 1;
                  row3[1] = row3[1] + 1;
                } else if (i5 >= 17 && i5 <= 22) {
                  countNumFeMaleArr[0][i] = countNumFeMaleArr[0][i] + 1;
                  row1[0] = row1[0] + 1;
                  row3[0] = row3[0] + 1;
                  countNumFeMaleArr[16][i] = countNumFeMaleArr[16][i] + 1;
                  row1[16] = row1[16] + 1;
                  row3[16] = row3[16] + 1;
                } else if (i5 >= 24 && i5 <= 25) {
                  countNumFeMaleArr[23][i] = countNumFeMaleArr[23][i] + 1;
                  row1[23] = row1[23] + 1;
                  row3[23] = row3[23] + 1;
                } 
              }  
          } 
        } 
      } 
      if (!hasMatch) {
        iltb15CountryCodeList.remove(i);
        i--;
      } 
    } 
    int sumAll = 0;
    for (int k = 0; k < row1.length; k++) {
      if (k != 0 && k != 1 && k != 16 && k != 23)
        sumAll += row1[k]; 
    } 
    IReportUseBeanR1C2 iReportUseBeanTop = new IReportUseBeanR1C2();
    iReportUseBeanTop.setColumnTop(formattedIndex(0) + "");
    iReportUseBeanTop.setColumnGroup(formattedIndex(0) + "總    計");
    iReportUseBeanTop.setRowGroup(formattedIndex(0) + "合    計");
    iReportUseBeanTop.setCountNum(Integer.valueOf(sumAll));
    list.add(iReportUseBeanTop);
    for (int m = 0; m < areaCodes.size(); m++) {
      String columnTop = formattedIndex(0) + "";
      String columnGroup = formattedIndex(0) + "總    計";
      String rowGroup = formattedIndex(m + 1) + ((AreaCodeBean)areaCodes.get(m)).getAreaName();
      IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
      iReportUseBean.setColumnTop(columnTop);
      iReportUseBean.setColumnGroup(columnGroup);
      iReportUseBean.setRowGroup(rowGroup);
      iReportUseBean.setCountNum(Integer.valueOf(row1[m]));
      list.add(iReportUseBean);
    } 
    int sumMale = 0;
    for (int n = 0; n < row2.length; n++) {
      if (n != 0 && n != 1 && n != 16 && n != 23)
        sumMale += row2[n]; 
    } 
    IReportUseBeanR1C2 iReportUseBeanTop2 = new IReportUseBeanR1C2();
    iReportUseBeanTop2.setColumnTop(formattedIndex(1) + "合    計");
    iReportUseBeanTop2.setColumnGroup(formattedIndex(0) + "男");
    iReportUseBeanTop2.setRowGroup(formattedIndex(0) + "合    計");
    iReportUseBeanTop2.setCountNum(Integer.valueOf(sumMale));
    list.add(iReportUseBeanTop2);
    for (int i1 = 0; i1 < areaCodes.size(); i1++) {
      String columnTop = formattedIndex(1) + "合    計";
      String columnGroup = formattedIndex(0) + "男";
      String rowGroup = formattedIndex(i1 + 1) + ((AreaCodeBean)areaCodes.get(i1)).getAreaName();
      IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
      iReportUseBean.setColumnTop(columnTop);
      iReportUseBean.setColumnGroup(columnGroup);
      iReportUseBean.setRowGroup(rowGroup);
      iReportUseBean.setCountNum(Integer.valueOf(row2[i1]));
      list.add(iReportUseBean);
    } 
    int sumFeMale = 0;
    for (int i2 = 0; i2 < row2.length; i2++) {
      if (i2 != 0 && i2 != 1 && i2 != 16 && i2 != 23)
        sumFeMale += row3[i2]; 
    } 
    IReportUseBeanR1C2 iReportUseBeanTop3 = new IReportUseBeanR1C2();
    iReportUseBeanTop3.setColumnTop(formattedIndex(1) + "合    計");
    iReportUseBeanTop3.setColumnGroup(formattedIndex(1) + "女");
    iReportUseBeanTop3.setRowGroup(formattedIndex(0) + "合    計");
    iReportUseBeanTop3.setCountNum(Integer.valueOf(sumFeMale));
    list.add(iReportUseBeanTop3);
    for (int i4 = 0; i4 < areaCodes.size(); i4++) {
      String columnTop = formattedIndex(1) + "合    計";
      String columnGroup = formattedIndex(1) + "女";
      String rowGroup = formattedIndex(i4 + 1) + ((AreaCodeBean)areaCodes.get(i4)).getAreaName();
      IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
      iReportUseBean.setColumnTop(columnTop);
      iReportUseBean.setColumnGroup(columnGroup);
      iReportUseBean.setRowGroup(rowGroup);
      iReportUseBean.setCountNum(Integer.valueOf(row3[i4]));
      list.add(iReportUseBean);
    } 
    int i3;
    for (i3 = 0; i3 < iltb15CountryCodeList.size(); i3++) {
      String columnTop = formattedIndex(i3 + 2) + ((Iltb15CountryCode)iltb15CountryCodeList.get(i3)).getIlNtnm();
      String columnGroup = formattedIndex(0) + "男";
      String rowGroup = formattedIndex(0) + "合    計";
      IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
      iReportUseBean.setColumnTop(columnTop);
      iReportUseBean.setColumnGroup(columnGroup);
      iReportUseBean.setRowGroup(rowGroup);
      iReportUseBean.setCountNum(Integer.valueOf(column1[i3]));
      list.add(iReportUseBean);
      columnGroup = formattedIndex(1) + "女";
      IReportUseBeanR1C2 iReportUseBean2 = new IReportUseBeanR1C2();
      iReportUseBean2.setColumnTop(columnTop);
      iReportUseBean2.setColumnGroup(columnGroup);
      iReportUseBean2.setRowGroup(rowGroup);
      iReportUseBean2.setCountNum(Integer.valueOf(column2[i3]));
      list.add(iReportUseBean2);
    } 
    for (i3 = 0; i3 < iltb15CountryCodeList.size(); i3++) {
      for (int i5 = 0; i5 < areaCodes.size(); i5++) {
        String columnTop = formattedIndex(i3 + 2) + ((Iltb15CountryCode)iltb15CountryCodeList.get(i3)).getIlNtnm();
        String columnGroup = formattedIndex(0) + "男";
        String rowGroup = formattedIndex(i5 + 1) + ((AreaCodeBean)areaCodes.get(i5)).getAreaName();
        IReportUseBeanR1C2 iReportUseBeanMale = new IReportUseBeanR1C2();
        iReportUseBeanMale.setColumnTop(columnTop);
        iReportUseBeanMale.setColumnGroup(columnGroup);
        iReportUseBeanMale.setRowGroup(rowGroup);
        iReportUseBeanMale.setCountNum(Integer.valueOf(countNumMaleArr[i5][i3]));
        list.add(iReportUseBeanMale);
        columnGroup = formattedIndex(1) + "女";
        IReportUseBeanR1C2 iReportUseBeanFeMale = new IReportUseBeanR1C2();
        iReportUseBeanFeMale.setColumnTop(columnTop);
        iReportUseBeanFeMale.setColumnGroup(columnGroup);
        iReportUseBeanFeMale.setRowGroup(rowGroup);
        iReportUseBeanFeMale.setCountNum(Integer.valueOf(countNumFeMaleArr[i5][i3]));
        list.add(iReportUseBeanFeMale);
      } 
    } 
    return new JRBeanCollectionDataSource(list);
  }
  
  public static JRBeanCollectionDataSource buildByPurposeAndArea(List<Iltb01Main> iltb01MainList, List<PurposeBean> purposes, List<AreaCodeBean> areaCodes) {
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
        String areaCode = ((AreaCodeBean)areaCodes.get(i3)).getAreaCode();
        if (IlPhq.equals(areaCode))
          if ("1".equals(ilSex)) {
            countNumMaleArr[i3][idxPurpose] = countNumMaleArr[i3][idxPurpose] + 1;
            column1[idxPurpose] = column1[idxPurpose] + 1;
            row1[i3] = row1[i3] + 1;
            row2[i3] = row2[i3] + 1;
            if (i3 >= 2 && i3 <= 15) {
              countNumMaleArr[0][idxPurpose] = countNumMaleArr[0][idxPurpose] + 1;
              row1[0] = row1[0] + 1;
              row2[0] = row2[0] + 1;
              countNumMaleArr[1][idxPurpose] = countNumMaleArr[1][idxPurpose] + 1;
              row1[1] = row1[1] + 1;
              row2[1] = row2[1] + 1;
            } else if (i3 >= 17 && i3 <= 22) {
              countNumMaleArr[0][idxPurpose] = countNumMaleArr[0][idxPurpose] + 1;
              row1[0] = row1[0] + 1;
              row2[0] = row2[0] + 1;
              countNumMaleArr[16][idxPurpose] = countNumMaleArr[16][idxPurpose] + 1;
              row1[16] = row1[16] + 1;
              row2[16] = row2[16] + 1;
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
            if (i3 >= 2 && i3 <= 15) {
              countNumFeMaleArr[0][idxPurpose] = countNumFeMaleArr[0][idxPurpose] + 1;
              row1[0] = row1[0] + 1;
              row3[0] = row3[0] + 1;
              countNumFeMaleArr[1][idxPurpose] = countNumFeMaleArr[1][idxPurpose] + 1;
              row1[1] = row1[1] + 1;
              row3[1] = row3[1] + 1;
            } else if (i3 >= 17 && i3 <= 22) {
              countNumFeMaleArr[0][idxPurpose] = countNumFeMaleArr[0][idxPurpose] + 1;
              row1[0] = row1[0] + 1;
              row3[0] = row3[0] + 1;
              countNumFeMaleArr[16][idxPurpose] = countNumFeMaleArr[16][idxPurpose] + 1;
              row1[16] = row1[16] + 1;
              row3[16] = row3[16] + 1;
            } else if (i3 >= 24 && i3 <= 25) {
              countNumFeMaleArr[23][idxPurpose] = countNumFeMaleArr[23][idxPurpose] + 1;
              row1[23] = row1[23] + 1;
              row3[23] = row3[23] + 1;
            } 
          }  
      } 
      for (i3 = 0; i3 < areaCodes.size(); i3++) {
        countNumMaleArr[i3][1] = countNumMaleArr[i3][2] + countNumMaleArr[i3][3] + countNumMaleArr[i3][4] + countNumMaleArr[i3][5];
        countNumMaleArr[i3][6] = countNumMaleArr[i3][7] + countNumMaleArr[i3][8] + countNumMaleArr[i3][9] + countNumMaleArr[i3][10];
        countNumMaleArr[i3][0] = countNumMaleArr[i3][1] + countNumMaleArr[i3][6];
        countNumMaleArr[i3][17] = countNumMaleArr[i3][18] + countNumMaleArr[i3][19] + countNumMaleArr[i3][20] + countNumMaleArr[i3][21] + countNumMaleArr[i3][22] + countNumMaleArr[i3][23] + countNumMaleArr[i3][24] + countNumMaleArr[i3][25] + countNumMaleArr[i3][26];
      } 
    } 
    int sumAll = 0;
    for (int i = 0; i < row1.length; i++) {
      if (i != 0 && i != 1 && i != 16 && i != 23)
        sumAll += row1[i]; 
    } 
    IReportUseBeanR1C4 iReportUseBeanTop = new IReportUseBeanR1C4();
    iReportUseBeanTop.setColumnTop(formattedIndex(0) + "");
    iReportUseBeanTop.setColumnTop2(formattedIndex(0) + "");
    iReportUseBeanTop.setColumnTop3(formattedIndex(0) + "");
    iReportUseBeanTop.setColumnGroup(formattedIndex(0) + "總    計");
    iReportUseBeanTop.setRowGroup(formattedIndex(0) + "合    計");
    iReportUseBeanTop.setCountNum(Integer.valueOf(sumAll));
    list.add(iReportUseBeanTop);
    for (int j = 0; j < areaCodes.size(); j++) {
      String columnTop = formattedIndex(0) + "";
      String colunmTop2 = formattedIndex(0) + "";
      String colunmTop3 = formattedIndex(0) + "";
      String columnGroup = formattedIndex(0) + "總    計";
      String rowGroup = formattedIndex(j + 1) + ((AreaCodeBean)areaCodes.get(j)).getAreaName();
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
      if (k != 0 && k != 1 && k != 16 && k != 23)
        sumMale += row2[k]; 
    } 
    IReportUseBeanR1C4 iReportUseBeanTop2 = new IReportUseBeanR1C4();
    iReportUseBeanTop2.setColumnTop(formattedIndex(1) + "");
    iReportUseBeanTop2.setColumnTop2(formattedIndex(1) + "");
    iReportUseBeanTop2.setColumnTop3(formattedIndex(1) + "合    計");
    iReportUseBeanTop2.setColumnGroup(formattedIndex(0) + "男");
    iReportUseBeanTop2.setRowGroup(formattedIndex(0) + "合    計");
    iReportUseBeanTop2.setCountNum(Integer.valueOf(sumMale));
    list.add(iReportUseBeanTop2);
    for (int m = 0; m < areaCodes.size(); m++) {
      String columnTop = formattedIndex(1) + "";
      String colunmTop2 = formattedIndex(1) + "";
      String colunmTop3 = formattedIndex(1) + "合    計";
      String columnGroup = formattedIndex(0) + "男";
      String rowGroup = formattedIndex(m + 1) + ((AreaCodeBean)areaCodes.get(m)).getAreaName();
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
      if (n != 0 && n != 1 && n != 16 && n != 23)
        sumFeMale += row3[n]; 
    } 
    IReportUseBeanR1C4 iReportUseBeanTop3 = new IReportUseBeanR1C4();
    iReportUseBeanTop3.setColumnTop(formattedIndex(1) + "");
    iReportUseBeanTop3.setColumnTop2(formattedIndex(1) + "");
    iReportUseBeanTop3.setColumnTop3(formattedIndex(1) + "合    計");
    iReportUseBeanTop3.setColumnGroup(formattedIndex(1) + "女");
    iReportUseBeanTop3.setRowGroup(formattedIndex(0) + "合    計");
    iReportUseBeanTop3.setCountNum(Integer.valueOf(sumFeMale));
    list.add(iReportUseBeanTop3);
    for (int i2 = 0; i2 < areaCodes.size(); i2++) {
      String columnTop = formattedIndex(1) + "";
      String colunmTop2 = formattedIndex(1) + "";
      String colunmTop3 = formattedIndex(1) + "合    計";
      String columnGroup = formattedIndex(1) + "女";
      String rowGroup = formattedIndex(i2 + 1) + ((AreaCodeBean)areaCodes.get(i2)).getAreaName();
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
      String columnTop = formattedIndex(((PurposeBean)purposes.get(i1)).getSequence1() + 3) + ((PurposeBean)purposes.get(i1)).getLevel1();
      String colunmTop2 = formattedIndex(((PurposeBean)purposes.get(i1)).getSequence2() + 3) + ((PurposeBean)purposes.get(i1)).getLevel2();
      String colunmTop3 = formattedIndex(((PurposeBean)purposes.get(i1)).getSequence() + 3) + ((PurposeBean)purposes.get(i1)).getLevel3();
      String columnGroup = formattedIndex(0) + "男";
      String rowGroup = formattedIndex(0) + "合    計";
      IReportUseBeanR1C4 iReportUseBean = new IReportUseBeanR1C4();
      iReportUseBean.setColumnTop(columnTop);
      iReportUseBean.setColumnTop2(colunmTop2);
      iReportUseBean.setColumnTop3(colunmTop3);
      iReportUseBean.setColumnGroup(columnGroup);
      iReportUseBean.setRowGroup(rowGroup);
      iReportUseBean.setCountNum(Integer.valueOf(column1[i1]));
      list.add(iReportUseBean);
      columnGroup = formattedIndex(1) + "女";
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
        String columnTop = formattedIndex(((PurposeBean)purposes.get(i1)).getSequence1() + 3) + ((PurposeBean)purposes.get(i1)).getLevel1();
        String colunmTop2 = formattedIndex(((PurposeBean)purposes.get(i1)).getSequence2() + 3) + ((PurposeBean)purposes.get(i1)).getLevel2();
        String colunmTop3 = formattedIndex(((PurposeBean)purposes.get(i1)).getSequence() + 3) + ((PurposeBean)purposes.get(i1)).getLevel3();
        String columnGroup = formattedIndex(0) + "男";
        String rowGroup = formattedIndex(i3 + 1) + ((AreaCodeBean)areaCodes.get(i3)).getAreaName();
        IReportUseBeanR1C4 iReportUseBeanMale = new IReportUseBeanR1C4();
        iReportUseBeanMale.setColumnTop(columnTop);
        iReportUseBeanMale.setColumnTop2(colunmTop2);
        iReportUseBeanMale.setColumnTop3(colunmTop3);
        iReportUseBeanMale.setColumnGroup(columnGroup);
        iReportUseBeanMale.setRowGroup(rowGroup);
        iReportUseBeanMale.setCountNum(Integer.valueOf(countNumMaleArr[i3][i1]));
        list.add(iReportUseBeanMale);
        columnGroup = formattedIndex(1) + "女";
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
  
  public static JRBeanCollectionDataSource buildByPurposeAndJob(List<Iltb01Main> iltb01MainList, List<PurposeBean> purposes, List<Iltb16JobCode> iltb16JobCodeList) {
    List<IReportUseBeanR1C4> list = new ArrayList<IReportUseBeanR1C4>();
    int[][] countNumMaleArr = new int[iltb16JobCodeList.size()][purposes.size()];
    int[][] countNumFeMaleArr = new int[iltb16JobCodeList.size()][purposes.size()];
    int[] row1 = new int[iltb16JobCodeList.size()];
    int[] row2 = new int[iltb16JobCodeList.size()];
    int[] row3 = new int[iltb16JobCodeList.size()];
    int[] column1 = new int[purposes.size()];
    int[] column2 = new int[purposes.size()];
    for (Iltb01Main iltb01Main : iltb01MainList) {
      String ilSex = iltb01Main.getIlSex();
      String ilArcrsn = iltb01Main.getIlArcrsn();
      String ilOfnm = iltb01Main.getIlOfnm();
      String ilJbcd = iltb01Main.getIlJbcd();
      GetDateUtil getDateUtil = new GetDateUtil();
      int nowYear = getDateUtil.getNowDate()[0];
      int birthYear = Integer.parseInt(iltb01Main.getIlBthdt().substring(0, 4));
      int diffYear = nowYear - birthYear;
      int idxPurpose = findPurposeSequence(ilArcrsn, ilOfnm);
      int i3;
      for (i3 = 0; i3 < iltb16JobCodeList.size(); i3++) {
        String jbcd = ((Iltb16JobCode)iltb16JobCodeList.get(i3)).getIlOpcd();
        int tempJ = i3;
        if (diffYear < 15)
          i3 = iltb16JobCodeList.size() - 1; 
        if (ilJbcd.equals(jbcd))
          if ("1".equals(ilSex)) {
            countNumMaleArr[i3][idxPurpose] = countNumMaleArr[i3][idxPurpose] + 1;
            column1[idxPurpose] = column1[idxPurpose] + 1;
            row1[i3] = row1[i3] + 1;
            row2[i3] = row2[i3] + 1;
          } else if ("2".equals(ilSex)) {
            countNumFeMaleArr[i3][idxPurpose] = countNumFeMaleArr[i3][idxPurpose] + 1;
            column2[idxPurpose] = column2[idxPurpose] + 1;
            row1[i3] = row1[i3] + 1;
            row3[i3] = row3[i3] + 1;
          }  
        i3 = tempJ;
      } 
      for (i3 = 0; i3 < iltb16JobCodeList.size(); i3++) {
        countNumMaleArr[i3][1] = countNumMaleArr[i3][2] + countNumMaleArr[i3][3] + countNumMaleArr[i3][4] + countNumMaleArr[i3][5];
        countNumMaleArr[i3][6] = countNumMaleArr[i3][7] + countNumMaleArr[i3][8] + countNumMaleArr[i3][9] + countNumMaleArr[i3][10];
        countNumMaleArr[i3][0] = countNumMaleArr[i3][1] + countNumMaleArr[i3][6];
        countNumMaleArr[i3][17] = countNumMaleArr[i3][18] + countNumMaleArr[i3][19] + countNumMaleArr[i3][20] + countNumMaleArr[i3][21] + countNumMaleArr[i3][22] + countNumMaleArr[i3][23] + countNumMaleArr[i3][24] + countNumMaleArr[i3][25] + countNumMaleArr[i3][26];
      } 
    } 
    int sumAll = 0;
    for (int i = 0; i < row1.length; i++) {
      if (i != 0 && i != 1 && i != 6 && i != 16)
        sumAll += row1[i]; 
    } 
    IReportUseBeanR1C4 iReportUseBeanTop = new IReportUseBeanR1C4();
    iReportUseBeanTop.setColumnTop(formattedIndex(0) + "");
    iReportUseBeanTop.setColumnTop2(formattedIndex(0) + "");
    iReportUseBeanTop.setColumnTop3(formattedIndex(0) + "");
    iReportUseBeanTop.setColumnGroup(formattedIndex(0) + "總    計");
    iReportUseBeanTop.setRowGroup(formattedIndex(0) + "合    計");
    iReportUseBeanTop.setCountNum(Integer.valueOf(sumAll));
    list.add(iReportUseBeanTop);
    for (int j = 0; j < iltb16JobCodeList.size(); j++) {
      String columnTop = formattedIndex(0) + "";
      String colunmTop2 = formattedIndex(0) + "";
      String colunmTop3 = formattedIndex(0) + "";
      String columnGroup = formattedIndex(0) + "總    計";
      String rowGroup = formattedIndex(j + 1) + ((Iltb16JobCode)iltb16JobCodeList.get(j)).getIlOpnm();
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
      if (k != 0 && k != 1 && k != 6 && k != 16)
        sumMale += row2[k]; 
    } 
    IReportUseBeanR1C4 iReportUseBeanTop2 = new IReportUseBeanR1C4();
    iReportUseBeanTop2.setColumnTop(formattedIndex(1) + "");
    iReportUseBeanTop2.setColumnTop2(formattedIndex(1) + "");
    iReportUseBeanTop2.setColumnTop3(formattedIndex(1) + "合    計");
    iReportUseBeanTop2.setColumnGroup(formattedIndex(0) + "男");
    iReportUseBeanTop2.setRowGroup(formattedIndex(0) + "合    計");
    iReportUseBeanTop2.setCountNum(Integer.valueOf(sumMale));
    list.add(iReportUseBeanTop2);
    for (int m = 0; m < iltb16JobCodeList.size(); m++) {
      String columnTop = formattedIndex(1) + "";
      String colunmTop2 = formattedIndex(1) + "";
      String colunmTop3 = formattedIndex(1) + "合    計";
      String columnGroup = formattedIndex(0) + "男";
      String rowGroup = formattedIndex(m + 1) + ((Iltb16JobCode)iltb16JobCodeList.get(m)).getIlOpnm();
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
      if (n != 0 && n != 1 && n != 6 && n != 16)
        sumFeMale += row3[n]; 
    } 
    IReportUseBeanR1C4 iReportUseBeanTop3 = new IReportUseBeanR1C4();
    iReportUseBeanTop3.setColumnTop(formattedIndex(1) + "");
    iReportUseBeanTop3.setColumnTop2(formattedIndex(1) + "");
    iReportUseBeanTop3.setColumnTop3(formattedIndex(1) + "合    計");
    iReportUseBeanTop3.setColumnGroup(formattedIndex(1) + "女");
    iReportUseBeanTop3.setRowGroup(formattedIndex(0) + "合    計");
    iReportUseBeanTop3.setCountNum(Integer.valueOf(sumFeMale));
    list.add(iReportUseBeanTop3);
    for (int i2 = 0; i2 < iltb16JobCodeList.size(); i2++) {
      String columnTop = formattedIndex(1) + "";
      String colunmTop2 = formattedIndex(1) + "";
      String colunmTop3 = formattedIndex(1) + "合    計";
      String columnGroup = formattedIndex(1) + "女";
      String rowGroup = formattedIndex(i2 + 1) + ((Iltb16JobCode)iltb16JobCodeList.get(i2)).getIlOpnm();
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
      String columnTop = formattedIndex(((PurposeBean)purposes.get(i1)).getSequence1() + 3) + ((PurposeBean)purposes.get(i1)).getLevel1();
      String colunmTop2 = formattedIndex(((PurposeBean)purposes.get(i1)).getSequence2() + 3) + ((PurposeBean)purposes.get(i1)).getLevel2();
      String colunmTop3 = formattedIndex(((PurposeBean)purposes.get(i1)).getSequence() + 3) + ((PurposeBean)purposes.get(i1)).getLevel3();
      String columnGroup = formattedIndex(0) + "男";
      String rowGroup = formattedIndex(0) + "合    計";
      IReportUseBeanR1C4 iReportUseBean = new IReportUseBeanR1C4();
      iReportUseBean.setColumnTop(columnTop);
      iReportUseBean.setColumnTop2(colunmTop2);
      iReportUseBean.setColumnTop3(colunmTop3);
      iReportUseBean.setColumnGroup(columnGroup);
      iReportUseBean.setRowGroup(rowGroup);
      iReportUseBean.setCountNum(Integer.valueOf(column1[i1]));
      list.add(iReportUseBean);
      columnGroup = formattedIndex(1) + "女";
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
      for (int i3 = 0; i3 < iltb16JobCodeList.size(); i3++) {
        String columnTop = formattedIndex(((PurposeBean)purposes.get(i1)).getSequence1() + 3) + ((PurposeBean)purposes.get(i1)).getLevel1();
        String colunmTop2 = formattedIndex(((PurposeBean)purposes.get(i1)).getSequence2() + 3) + ((PurposeBean)purposes.get(i1)).getLevel2();
        String colunmTop3 = formattedIndex(((PurposeBean)purposes.get(i1)).getSequence() + 3) + ((PurposeBean)purposes.get(i1)).getLevel3();
        String columnGroup = formattedIndex(0) + "男";
        String rowGroup = formattedIndex(i3 + 1) + ((Iltb16JobCode)iltb16JobCodeList.get(i3)).getIlOpnm();
        IReportUseBeanR1C4 iReportUseBeanMale = new IReportUseBeanR1C4();
        iReportUseBeanMale.setColumnTop(columnTop);
        iReportUseBeanMale.setColumnTop2(colunmTop2);
        iReportUseBeanMale.setColumnTop3(colunmTop3);
        iReportUseBeanMale.setColumnGroup(columnGroup);
        iReportUseBeanMale.setRowGroup(rowGroup);
        iReportUseBeanMale.setCountNum(Integer.valueOf(countNumMaleArr[i3][i1]));
        list.add(iReportUseBeanMale);
        columnGroup = formattedIndex(1) + "女";
        IReportUseBeanR1C4 iReportUseBeanFeMale = new IReportUseBeanR1C4();
        iReportUseBeanFeMale.setColumnTop(columnTop);
        iReportUseBeanFeMale.setColumnTop2(colunmTop2);
        iReportUseBeanFeMale.setColumnTop3(colunmTop3);
        iReportUseBeanFeMale.setColumnGroup(columnGroup);
        iReportUseBeanFeMale.setRowGroup(rowGroup);
        iReportUseBeanFeMale.setCountNum(Integer.valueOf(countNumFeMaleArr[i3][i1]));
        list.add(iReportUseBeanFeMale);
      } 
    } 
    return new JRBeanCollectionDataSource(list);
  }
  
  public static JRBeanCollectionDataSource buildByCountryAndPurpose(List<Iltb01Main> iltb01MainList, List<Iltb15CountryCode> iltb15CountryCodeList, List<PurposeBean> purposes) {
    List<IReportUseBeanR3C2> list = new ArrayList<IReportUseBeanR3C2>();
    int[][] countNumMaleArr = new int[purposes.size()][iltb15CountryCodeList.size()];
    int[][] countNumFeMaleArr = new int[purposes.size()][iltb15CountryCodeList.size()];
    int[] row1 = new int[purposes.size()];
    int[] row2 = new int[purposes.size()];
    int[] row3 = new int[purposes.size()];
    int[] column1 = new int[iltb15CountryCodeList.size()];
    int[] column2 = new int[iltb15CountryCodeList.size()];
    int i;
    for (i = 0; i < iltb15CountryCodeList.size(); i++) {
      boolean hasMatch = false;
      for (Iltb01Main iltb01Main : iltb01MainList) {
        String ilSex = iltb01Main.getIlSex();
        String ilNtcd = iltb01Main.getIlNtcd();
        String ilArcrsn = iltb01Main.getIlArcrsn();
        String ilOfnm = iltb01Main.getIlOfnm();
        String ilNtcdCode = ((Iltb15CountryCode)iltb15CountryCodeList.get(i)).getIlNtcd();
        if (ilNtcdCode.equals(ilNtcd)) {
          hasMatch = true;
          int i4 = findPurposeSequence(ilArcrsn, ilOfnm);
          if ("1".equals(ilSex)) {
            countNumMaleArr[i4][i] = countNumMaleArr[i4][i] + 1;
            column1[i] = column1[i] + 1;
            row1[i4] = row1[i4] + 1;
            row2[i4] = row2[i4] + 1;
            continue;
          } 
          if ("2".equals(ilSex)) {
            countNumFeMaleArr[i4][i] = countNumFeMaleArr[i4][i] + 1;
            column2[i] = column2[i] + 1;
            row1[i4] = row1[i4] + 1;
            row3[i4] = row3[i4] + 1;
          } 
        } 
      } 
      if (!hasMatch) {
        iltb15CountryCodeList.remove(i);
        i--;
      } 
    } 
    for (i = 0; i < iltb15CountryCodeList.size(); i++) {
      for (Iltb01Main iltb01Main : iltb01MainList) {
        String ilSex = iltb01Main.getIlSex();
        String ilNtcd = iltb01Main.getIlNtcd();
        String ilArcrsn = iltb01Main.getIlArcrsn();
        String ilOfnm = iltb01Main.getIlOfnm();
        countNumMaleArr[1][i] = countNumMaleArr[2][i] + countNumMaleArr[3][i] + countNumMaleArr[4][i] + countNumMaleArr[5][i];
        countNumFeMaleArr[1][i] = countNumFeMaleArr[2][i] + countNumFeMaleArr[3][i] + countNumFeMaleArr[4][i] + countNumFeMaleArr[5][i];
        countNumMaleArr[6][i] = countNumMaleArr[7][i] + countNumMaleArr[8][i] + countNumMaleArr[9][i] + countNumMaleArr[10][i];
        countNumFeMaleArr[6][i] = countNumFeMaleArr[7][i] + countNumFeMaleArr[8][i] + countNumFeMaleArr[9][i] + countNumFeMaleArr[10][i];
        countNumMaleArr[0][i] = countNumMaleArr[1][i] + countNumMaleArr[6][i];
        countNumFeMaleArr[0][i] = countNumFeMaleArr[1][i] + countNumFeMaleArr[6][i];
        countNumMaleArr[17][i] = countNumMaleArr[18][i] + countNumMaleArr[19][i] + countNumMaleArr[20][i] + countNumMaleArr[21][i] + countNumMaleArr[22][i] + countNumMaleArr[23][i] + countNumMaleArr[24][i] + countNumMaleArr[25][i] + countNumMaleArr[26][i];
        countNumFeMaleArr[17][i] = countNumFeMaleArr[18][i] + countNumFeMaleArr[19][i] + countNumFeMaleArr[20][i] + countNumFeMaleArr[21][i] + countNumFeMaleArr[22][i] + countNumFeMaleArr[23][i] + countNumFeMaleArr[24][i] + countNumFeMaleArr[25][i] + countNumFeMaleArr[26][i];
      } 
    } 
    int sumAll = 0;
    for (int k = 0; k < row1.length; k++) {
      if (k != 0 && k != 1 && k != 6 && k != 16)
        sumAll += row1[k]; 
    } 
    IReportUseBeanR3C2 iReportUseBeanTop = new IReportUseBeanR3C2();
    iReportUseBeanTop.setColumnTop(formattedIndex(0) + "");
    iReportUseBeanTop.setColumnGroup(formattedIndex(0) + "總    計");
    iReportUseBeanTop.setRowTop(formattedIndex(0) + "");
    iReportUseBeanTop.setRowTop2(formattedIndex(0) + "");
    iReportUseBeanTop.setRowGroup(formattedIndex(0) + "合    計");
    iReportUseBeanTop.setCountNum(Integer.valueOf(sumAll));
    list.add(iReportUseBeanTop);
    for (int j = 0; j < purposes.size(); j++) {
      String columnTop = formattedIndex(0) + "";
      String columnGroup = formattedIndex(0) + "總    計";
      String rowTop = formattedIndex(((PurposeBean)purposes.get(j)).getSequence1() + 1) + ((PurposeBean)purposes.get(j)).getLevel1();
      String rowTop2 = formattedIndex(((PurposeBean)purposes.get(j)).getSequence2() + 1) + ((PurposeBean)purposes.get(j)).getLevel2();
      String rowGroup = formattedIndex(((PurposeBean)purposes.get(j)).getSequence() + 1) + ((PurposeBean)purposes.get(j)).getLevel3();
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
    for (int m = 0; m < row2.length; m++) {
      if (m != 0 && m != 1 && m != 6 && m != 16)
        sumMale += row2[m]; 
    } 
    IReportUseBeanR3C2 iReportUseBeanTop2 = new IReportUseBeanR3C2();
    iReportUseBeanTop2.setColumnTop(formattedIndex(1) + "合    計");
    iReportUseBeanTop2.setColumnGroup(formattedIndex(0) + "男");
    iReportUseBeanTop2.setRowTop(formattedIndex(0) + "");
    iReportUseBeanTop2.setRowTop2(formattedIndex(0) + "");
    iReportUseBeanTop2.setRowGroup(formattedIndex(0) + "合    計");
    iReportUseBeanTop2.setCountNum(Integer.valueOf(sumMale));
    list.add(iReportUseBeanTop2);
    for (int n = 0; n < purposes.size(); n++) {
      String columnTop = formattedIndex(1) + "合    計";
      String columnGroup = formattedIndex(0) + "男";
      String rowTop = formattedIndex(((PurposeBean)purposes.get(n)).getSequence1() + 1) + ((PurposeBean)purposes.get(n)).getLevel1();
      String rowTop2 = formattedIndex(((PurposeBean)purposes.get(n)).getSequence2() + 1) + ((PurposeBean)purposes.get(n)).getLevel2();
      String rowGroup = formattedIndex(((PurposeBean)purposes.get(n)).getSequence() + 1) + ((PurposeBean)purposes.get(n)).getLevel3();
      IReportUseBeanR3C2 iReportUseBean = new IReportUseBeanR3C2();
      iReportUseBean.setColumnTop(columnTop);
      iReportUseBean.setColumnGroup(columnGroup);
      iReportUseBean.setRowTop(rowTop);
      iReportUseBean.setRowTop2(rowTop2);
      iReportUseBean.setRowGroup(rowGroup);
      iReportUseBean.setCountNum(Integer.valueOf(row2[n]));
      list.add(iReportUseBean);
    } 
    int sumFeMale = 0;
    for (int i1 = 0; i1 < row2.length; i1++) {
      if (i1 != 0 && i1 != 1 && i1 != 6 && i1 != 16)
        sumFeMale += row3[i1]; 
    } 
    IReportUseBeanR3C2 iReportUseBeanTop3 = new IReportUseBeanR3C2();
    iReportUseBeanTop3.setColumnTop(formattedIndex(1) + "合    計");
    iReportUseBeanTop3.setColumnGroup(formattedIndex(1) + "女");
    iReportUseBeanTop3.setRowTop(formattedIndex(0) + "");
    iReportUseBeanTop3.setRowTop2(formattedIndex(0) + "");
    iReportUseBeanTop3.setRowGroup(formattedIndex(0) + "合    計");
    iReportUseBeanTop3.setCountNum(Integer.valueOf(sumFeMale));
    list.add(iReportUseBeanTop3);
    for (int i3 = 0; i3 < purposes.size(); i3++) {
      String columnTop = formattedIndex(1) + "合    計";
      String columnGroup = formattedIndex(1) + "女";
      String rowTop = formattedIndex(((PurposeBean)purposes.get(i3)).getSequence1() + 1) + ((PurposeBean)purposes.get(i3)).getLevel1();
      String rowTop2 = formattedIndex(((PurposeBean)purposes.get(i3)).getSequence2() + 1) + ((PurposeBean)purposes.get(i3)).getLevel2();
      String rowGroup = formattedIndex(((PurposeBean)purposes.get(i3)).getSequence() + 1) + ((PurposeBean)purposes.get(i3)).getLevel3();
      IReportUseBeanR3C2 iReportUseBean = new IReportUseBeanR3C2();
      iReportUseBean.setColumnTop(columnTop);
      iReportUseBean.setColumnGroup(columnGroup);
      iReportUseBean.setRowTop(rowTop);
      iReportUseBean.setRowTop2(rowTop2);
      iReportUseBean.setRowGroup(rowGroup);
      iReportUseBean.setCountNum(Integer.valueOf(row3[i3]));
      list.add(iReportUseBean);
    } 
    int i2;
    for (i2 = 0; i2 < iltb15CountryCodeList.size(); i2++) {
      String columnTop = formattedIndex(i2 + 2) + ((Iltb15CountryCode)iltb15CountryCodeList.get(i2)).getIlNtnm();
      String columnGroup = formattedIndex(0) + "男";
      String rowTop = formattedIndex(0) + "";
      String rowTop2 = formattedIndex(0) + "";
      String rowGroup = formattedIndex(0) + "合    計";
      IReportUseBeanR3C2 iReportUseBean = new IReportUseBeanR3C2();
      iReportUseBean.setColumnTop(columnTop);
      iReportUseBean.setColumnGroup(columnGroup);
      iReportUseBean.setRowTop(rowTop);
      iReportUseBean.setRowTop2(rowTop2);
      iReportUseBean.setRowGroup(rowGroup);
      iReportUseBean.setCountNum(Integer.valueOf(column1[i2]));
      list.add(iReportUseBean);
      columnGroup = formattedIndex(1) + "女";
      IReportUseBeanR3C2 iReportUseBean2 = new IReportUseBeanR3C2();
      iReportUseBean2.setColumnTop(columnTop);
      iReportUseBean2.setColumnGroup(columnGroup);
      iReportUseBean2.setRowTop(rowTop);
      iReportUseBean2.setRowTop2(rowTop2);
      iReportUseBean2.setRowGroup(rowGroup);
      iReportUseBean2.setCountNum(Integer.valueOf(column2[i2]));
      list.add(iReportUseBean2);
    } 
    for (i2 = 0; i2 < iltb15CountryCodeList.size(); i2++) {
      for (int i4 = 0; i4 < purposes.size(); i4++) {
        String columnTop = formattedIndex(i2 + 2) + ((Iltb15CountryCode)iltb15CountryCodeList.get(i2)).getIlNtnm();
        String columnGroup = formattedIndex(0) + "男";
        String rowTop = formattedIndex(((PurposeBean)purposes.get(i4)).getSequence1() + 1) + ((PurposeBean)purposes.get(i4)).getLevel1();
        String rowTop2 = formattedIndex(((PurposeBean)purposes.get(i4)).getSequence2() + 1) + ((PurposeBean)purposes.get(i4)).getLevel2();
        String rowGroup = formattedIndex(((PurposeBean)purposes.get(i4)).getSequence() + 1) + ((PurposeBean)purposes.get(i4)).getLevel3();
        IReportUseBeanR3C2 iReportUseBeanMale = new IReportUseBeanR3C2();
        iReportUseBeanMale.setColumnTop(columnTop);
        iReportUseBeanMale.setColumnGroup(columnGroup);
        iReportUseBeanMale.setRowTop(rowTop);
        iReportUseBeanMale.setRowTop2(rowTop2);
        iReportUseBeanMale.setRowGroup(rowGroup);
        iReportUseBeanMale.setCountNum(Integer.valueOf(countNumMaleArr[i4][i2]));
        list.add(iReportUseBeanMale);
        columnGroup = formattedIndex(1) + "女";
        IReportUseBeanR3C2 iReportUseBeanFeMale = new IReportUseBeanR3C2();
        iReportUseBeanFeMale.setColumnTop(columnTop);
        iReportUseBeanFeMale.setColumnGroup(columnGroup);
        iReportUseBeanFeMale.setRowTop(rowTop);
        iReportUseBeanFeMale.setRowTop2(rowTop2);
        iReportUseBeanFeMale.setRowGroup(rowGroup);
        iReportUseBeanFeMale.setCountNum(Integer.valueOf(countNumFeMaleArr[i4][i2]));
        list.add(iReportUseBeanFeMale);
      } 
    } 
    System.out.println("list=" + list.size());
    return new JRBeanCollectionDataSource(list);
  }
  
  public static JRBeanCollectionDataSource buildByJobAndArea(List<Iltb01Main> iltb01MainList, List<Iltb16JobCode> iltb16JobCodeList, List<AreaCodeBean> areaCodes) {
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
        String ilJbcdCode = ((Iltb16JobCode)iltb16JobCodeList.get(i3)).getIlOpcd();
        int tempI = i3;
        if (diffYear < 15)
          i3 = iltb16JobCodeList.size() - 1; 
        if (ilJbcdCode.equals(ilJbcd))
          for (int i4 = 0; i4 < areaCodes.size(); i4++) {
            String areaCode = ((AreaCodeBean)areaCodes.get(i4)).getAreaCode();
            if (IlPhq.equals(areaCode))
              if ("1".equals(ilSex)) {
                countNumMaleArr[i4][i3] = countNumMaleArr[i4][i3] + 1;
                column1[i3] = column1[i3] + 1;
                row1[i4] = row1[i4] + 1;
                row2[i4] = row2[i4] + 1;
                if (i4 >= 2 && i4 <= 15) {
                  countNumMaleArr[0][i3] = countNumMaleArr[0][i3] + 1;
                  row1[0] = row1[0] + 1;
                  row2[0] = row2[0] + 1;
                  countNumMaleArr[1][i3] = countNumMaleArr[1][i3] + 1;
                  row1[1] = row1[1] + 1;
                  row2[1] = row2[1] + 1;
                } else if (i4 >= 17 && i4 <= 22) {
                  countNumMaleArr[0][i3] = countNumMaleArr[0][i3] + 1;
                  row1[0] = row1[0] + 1;
                  row2[0] = row2[0] + 1;
                  countNumMaleArr[16][i3] = countNumMaleArr[16][i3] + 1;
                  row1[16] = row1[16] + 1;
                  row2[16] = row2[16] + 1;
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
                if (i4 >= 2 && i4 <= 15) {
                  countNumFeMaleArr[0][i3] = countNumFeMaleArr[0][i3] + 1;
                  row1[0] = row1[0] + 1;
                  row3[0] = row3[0] + 1;
                  countNumFeMaleArr[1][i3] = countNumFeMaleArr[1][i3] + 1;
                  row1[1] = row1[1] + 1;
                  row3[1] = row3[1] + 1;
                } else if (i4 >= 17 && i4 <= 22) {
                  countNumFeMaleArr[0][i3] = countNumFeMaleArr[0][i3] + 1;
                  row1[0] = row1[0] + 1;
                  row3[0] = row3[0] + 1;
                  countNumFeMaleArr[16][i3] = countNumFeMaleArr[16][i3] + 1;
                  row1[16] = row1[16] + 1;
                  row3[16] = row3[16] + 1;
                } else if (i4 >= 24 && i4 <= 25) {
                  countNumFeMaleArr[23][i3] = countNumFeMaleArr[23][i3] + 1;
                  row1[23] = row1[23] + 1;
                  row3[23] = row3[23] + 1;
                } 
              }  
          }  
        i3 = tempI;
      } 
    } 
    int sumAll = 0;
    for (int i = 0; i < row1.length; i++) {
      if (i != 0 && i != 1 && i != 16 && i != 23)
        sumAll += row1[i]; 
    } 
    IReportUseBeanR1C2 iReportUseBeanTop = new IReportUseBeanR1C2();
    iReportUseBeanTop.setColumnTop(formattedIndex(0) + "");
    iReportUseBeanTop.setColumnGroup(formattedIndex(0) + "總    計");
    iReportUseBeanTop.setRowGroup(formattedIndex(0) + "合    計");
    iReportUseBeanTop.setCountNum(Integer.valueOf(sumAll));
    list.add(iReportUseBeanTop);
    for (int j = 0; j < areaCodes.size(); j++) {
      String columnTop = formattedIndex(0) + "";
      String columnGroup = formattedIndex(0) + "總    計";
      String rowGroup = formattedIndex(j + 1) + ((AreaCodeBean)areaCodes.get(j)).getAreaName();
      IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
      iReportUseBean.setColumnTop(columnTop);
      iReportUseBean.setColumnGroup(columnGroup);
      iReportUseBean.setRowGroup(rowGroup);
      iReportUseBean.setCountNum(Integer.valueOf(row1[j]));
      list.add(iReportUseBean);
    } 
    int sumMale = 0;
    for (int k = 0; k < row2.length; k++) {
      if (k != 0 && k != 1 && k != 16 && k != 23)
        sumMale += row2[k]; 
    } 
    IReportUseBeanR1C2 iReportUseBeanTop2 = new IReportUseBeanR1C2();
    iReportUseBeanTop2.setColumnTop(formattedIndex(1) + "合    計");
    iReportUseBeanTop2.setColumnGroup(formattedIndex(0) + "男");
    iReportUseBeanTop2.setRowGroup(formattedIndex(0) + "合    計");
    iReportUseBeanTop2.setCountNum(Integer.valueOf(sumMale));
    list.add(iReportUseBeanTop2);
    for (int m = 0; m < areaCodes.size(); m++) {
      String columnTop = formattedIndex(1) + "合    計";
      String columnGroup = formattedIndex(0) + "男";
      String rowGroup = formattedIndex(m + 1) + ((AreaCodeBean)areaCodes.get(m)).getAreaName();
      IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
      iReportUseBean.setColumnTop(columnTop);
      iReportUseBean.setColumnGroup(columnGroup);
      iReportUseBean.setRowGroup(rowGroup);
      iReportUseBean.setCountNum(Integer.valueOf(row2[m]));
      list.add(iReportUseBean);
    } 
    int sumFeMale = 0;
    for (int n = 0; n < row2.length; n++) {
      if (n != 0 && n != 1 && n != 16 && n != 23)
        sumFeMale += row3[n]; 
    } 
    IReportUseBeanR1C2 iReportUseBeanTop3 = new IReportUseBeanR1C2();
    iReportUseBeanTop3.setColumnTop(formattedIndex(1) + "合    計");
    iReportUseBeanTop3.setColumnGroup(formattedIndex(1) + "女");
    iReportUseBeanTop3.setRowGroup(formattedIndex(0) + "合    計");
    iReportUseBeanTop3.setCountNum(Integer.valueOf(sumFeMale));
    list.add(iReportUseBeanTop3);
    for (int i2 = 0; i2 < areaCodes.size(); i2++) {
      String columnTop = formattedIndex(1) + "合    計";
      String columnGroup = formattedIndex(1) + "女";
      String rowGroup = formattedIndex(i2 + 1) + ((AreaCodeBean)areaCodes.get(i2)).getAreaName();
      IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
      iReportUseBean.setColumnTop(columnTop);
      iReportUseBean.setColumnGroup(columnGroup);
      iReportUseBean.setRowGroup(rowGroup);
      iReportUseBean.setCountNum(Integer.valueOf(row3[i2]));
      list.add(iReportUseBean);
    } 
    int i1;
    for (i1 = 0; i1 < iltb16JobCodeList.size(); i1++) {
      String columnTop = formattedIndex(i1 + 2) + ((Iltb16JobCode)iltb16JobCodeList.get(i1)).getIlOpnm();
      String columnGroup = formattedIndex(0) + "男";
      String rowGroup = formattedIndex(0) + "合    計";
      IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
      iReportUseBean.setColumnTop(columnTop);
      iReportUseBean.setColumnGroup(columnGroup);
      iReportUseBean.setRowGroup(rowGroup);
      iReportUseBean.setCountNum(Integer.valueOf(column1[i1]));
      list.add(iReportUseBean);
      columnGroup = formattedIndex(1) + "女";
      IReportUseBeanR1C2 iReportUseBean2 = new IReportUseBeanR1C2();
      iReportUseBean2.setColumnTop(columnTop);
      iReportUseBean2.setColumnGroup(columnGroup);
      iReportUseBean2.setRowGroup(rowGroup);
      iReportUseBean2.setCountNum(Integer.valueOf(column2[i1]));
      list.add(iReportUseBean2);
    } 
    for (i1 = 0; i1 < iltb16JobCodeList.size(); i1++) {
      for (int i3 = 0; i3 < areaCodes.size(); i3++) {
        String columnTop = formattedIndex(i1 + 2) + ((Iltb16JobCode)iltb16JobCodeList.get(i1)).getIlOpnm();
        String columnGroup = formattedIndex(0) + "男";
        String rowGroup = formattedIndex(i3 + 1) + ((AreaCodeBean)areaCodes.get(i3)).getAreaName();
        IReportUseBeanR1C2 iReportUseBeanMale = new IReportUseBeanR1C2();
        iReportUseBeanMale.setColumnTop(columnTop);
        iReportUseBeanMale.setColumnGroup(columnGroup);
        iReportUseBeanMale.setRowGroup(rowGroup);
        iReportUseBeanMale.setCountNum(Integer.valueOf(countNumMaleArr[i3][i1]));
        list.add(iReportUseBeanMale);
        columnGroup = formattedIndex(1) + "女";
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
  
  public static JRBeanCollectionDataSource buildByIDTypeAndArea(List<Iltb01Main> iltb01MainList, List<IDTypeBean> idTypes, List<AreaCodeBean> areaCodes) {
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
        String ilIDCode = String.valueOf(((IDTypeBean)idTypes.get(i3)).getSequence());
        if (ilArctp.equals(ilIDCode))
          for (int i4 = 0; i4 < areaCodes.size(); i4++) {
            String areaCode = ((AreaCodeBean)areaCodes.get(i4)).getAreaCode();
            if (IlPhq.equals(areaCode))
              if ("1".equals(ilSex)) {
                countNumMaleArr[i4][i3] = countNumMaleArr[i4][i3] + 1;
                column1[i3] = column1[i3] + 1;
                row1[i4] = row1[i4] + 1;
                row2[i4] = row2[i4] + 1;
                if (i4 >= 2 && i4 <= 15) {
                  countNumMaleArr[0][i3] = countNumMaleArr[0][i3] + 1;
                  row1[0] = row1[0] + 1;
                  row2[0] = row2[0] + 1;
                  countNumMaleArr[1][i3] = countNumMaleArr[1][i3] + 1;
                  row1[1] = row1[1] + 1;
                  row2[1] = row2[1] + 1;
                } else if (i4 >= 17 && i4 <= 22) {
                  countNumMaleArr[0][i3] = countNumMaleArr[0][i3] + 1;
                  row1[0] = row1[0] + 1;
                  row2[0] = row2[0] + 1;
                  countNumMaleArr[16][i3] = countNumMaleArr[16][i3] + 1;
                  row1[16] = row1[16] + 1;
                  row2[16] = row2[16] + 1;
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
                if (i4 >= 2 && i4 <= 15) {
                  countNumFeMaleArr[0][i3] = countNumFeMaleArr[0][i3] + 1;
                  row1[0] = row1[0] + 1;
                  row3[0] = row3[0] + 1;
                  countNumFeMaleArr[1][i3] = countNumFeMaleArr[1][i3] + 1;
                  row1[1] = row1[1] + 1;
                  row3[1] = row3[1] + 1;
                } else if (i4 >= 17 && i4 <= 22) {
                  countNumFeMaleArr[0][i3] = countNumFeMaleArr[0][i3] + 1;
                  row1[0] = row1[0] + 1;
                  row3[0] = row3[0] + 1;
                  countNumFeMaleArr[16][i3] = countNumFeMaleArr[16][i3] + 1;
                  row1[16] = row1[16] + 1;
                  row3[16] = row3[16] + 1;
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
      if (i != 0 && i != 1 && i != 16 && i != 23)
        sumAll += row1[i]; 
    } 
    IReportUseBeanR1C2 iReportUseBeanTop = new IReportUseBeanR1C2();
    iReportUseBeanTop.setColumnTop(formattedIndex(0) + "");
    iReportUseBeanTop.setColumnGroup(formattedIndex(0) + "總    計");
    iReportUseBeanTop.setRowGroup(formattedIndex(0) + "合    計");
    iReportUseBeanTop.setCountNum(Integer.valueOf(sumAll));
    list.add(iReportUseBeanTop);
    for (int j = 0; j < areaCodes.size(); j++) {
      String columnTop = formattedIndex(0) + "";
      String columnGroup = formattedIndex(0) + "總    計";
      String rowGroup = formattedIndex(j + 1) + ((AreaCodeBean)areaCodes.get(j)).getAreaName();
      IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
      iReportUseBean.setColumnTop(columnTop);
      iReportUseBean.setColumnGroup(columnGroup);
      iReportUseBean.setRowGroup(rowGroup);
      iReportUseBean.setCountNum(Integer.valueOf(row1[j]));
      list.add(iReportUseBean);
    } 
    int sumMale = 0;
    for (int k = 0; k < row2.length; k++) {
      if (k != 0 && k != 1 && k != 16 && k != 23)
        sumMale += row2[k]; 
    } 
    IReportUseBeanR1C2 iReportUseBeanTop2 = new IReportUseBeanR1C2();
    iReportUseBeanTop2.setColumnTop(formattedIndex(1) + "合    計");
    iReportUseBeanTop2.setColumnGroup(formattedIndex(0) + "男");
    iReportUseBeanTop2.setRowGroup(formattedIndex(0) + "合    計");
    iReportUseBeanTop2.setCountNum(Integer.valueOf(sumMale));
    list.add(iReportUseBeanTop2);
    for (int m = 0; m < areaCodes.size(); m++) {
      String columnTop = formattedIndex(1) + "合    計";
      String columnGroup = formattedIndex(0) + "男";
      String rowGroup = formattedIndex(m + 1) + ((AreaCodeBean)areaCodes.get(m)).getAreaName();
      IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
      iReportUseBean.setColumnTop(columnTop);
      iReportUseBean.setColumnGroup(columnGroup);
      iReportUseBean.setRowGroup(rowGroup);
      iReportUseBean.setCountNum(Integer.valueOf(row2[m]));
      list.add(iReportUseBean);
    } 
    int sumFeMale = 0;
    for (int n = 0; n < row2.length; n++) {
      if (n != 0 && n != 1 && n != 16 && n != 23)
        sumFeMale += row3[n]; 
    } 
    IReportUseBeanR1C2 iReportUseBeanTop3 = new IReportUseBeanR1C2();
    iReportUseBeanTop3.setColumnTop(formattedIndex(1) + "合    計");
    iReportUseBeanTop3.setColumnGroup(formattedIndex(1) + "女");
    iReportUseBeanTop3.setRowGroup(formattedIndex(0) + "合    計");
    iReportUseBeanTop3.setCountNum(Integer.valueOf(sumFeMale));
    list.add(iReportUseBeanTop3);
    for (int i2 = 0; i2 < areaCodes.size(); i2++) {
      String columnTop = formattedIndex(1) + "合    計";
      String columnGroup = formattedIndex(1) + "女";
      String rowGroup = formattedIndex(i2 + 1) + ((AreaCodeBean)areaCodes.get(i2)).getAreaName();
      IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
      iReportUseBean.setColumnTop(columnTop);
      iReportUseBean.setColumnGroup(columnGroup);
      iReportUseBean.setRowGroup(rowGroup);
      iReportUseBean.setCountNum(Integer.valueOf(row3[i2]));
      list.add(iReportUseBean);
    } 
    int i1;
    for (i1 = 0; i1 < idTypes.size(); i1++) {
      String columnTop = formattedIndex(i1 + 2) + ((IDTypeBean)idTypes.get(i1)).getTypeName();
      String columnGroup = formattedIndex(0) + "男";
      String rowGroup = formattedIndex(0) + "合    計";
      IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
      iReportUseBean.setColumnTop(columnTop);
      iReportUseBean.setColumnGroup(columnGroup);
      iReportUseBean.setRowGroup(rowGroup);
      iReportUseBean.setCountNum(Integer.valueOf(column1[i1]));
      list.add(iReportUseBean);
      columnGroup = formattedIndex(1) + "女";
      IReportUseBeanR1C2 iReportUseBean2 = new IReportUseBeanR1C2();
      iReportUseBean2.setColumnTop(columnTop);
      iReportUseBean2.setColumnGroup(columnGroup);
      iReportUseBean2.setRowGroup(rowGroup);
      iReportUseBean2.setCountNum(Integer.valueOf(column2[i1]));
      list.add(iReportUseBean2);
    } 
    for (i1 = 0; i1 < idTypes.size(); i1++) {
      for (int i3 = 0; i3 < areaCodes.size(); i3++) {
        String columnTop = formattedIndex(i1 + 2) + ((IDTypeBean)idTypes.get(i1)).getTypeName();
        String columnGroup = formattedIndex(0) + "男";
        String rowGroup = formattedIndex(i3 + 1) + ((AreaCodeBean)areaCodes.get(i3)).getAreaName();
        IReportUseBeanR1C2 iReportUseBeanMale = new IReportUseBeanR1C2();
        iReportUseBeanMale.setColumnTop(columnTop);
        iReportUseBeanMale.setColumnGroup(columnGroup);
        iReportUseBeanMale.setRowGroup(rowGroup);
        iReportUseBeanMale.setCountNum(Integer.valueOf(countNumMaleArr[i3][i1]));
        list.add(iReportUseBeanMale);
        columnGroup = formattedIndex(1) + "女";
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
  
  public static JRBeanCollectionDataSource buildByPeopleNumberTypeAndCountry_old(List<Iltb01Main> iltb01MainList, List<PeopleNumberTypeBean> peopleNumberTypes, List<Iltb15CountryCode> iltb15CountryCodeList) {
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
        String ilNtcdCode = ((Iltb15CountryCode)iltb15CountryCodeList.get(j)).getIlNtcd();
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
      String rowGroup = formattedIndex(0) + "總    計";
      String columnGroup = formattedIndex(i) + ((PeopleNumberTypeBean)peopleNumberTypes.get(i)).getTypeName();
      IReportUseBeanR2C1 iReportUseBean = new IReportUseBeanR2C1();
      iReportUseBean.setColumnGroup(columnGroup);
      iReportUseBean.setRowGroup(rowGroup);
      iReportUseBean.setRowTop(rowTop);
      iReportUseBean.setCountNum(Integer.valueOf(row1[i]));
      list.add(iReportUseBean);
    } 
    for (i = 0; i < peopleNumberTypes.size(); i++) {
      String rowTop = "     合    計";
      String rowGroup = formattedIndex(0) + "男";
      String columnGroup = formattedIndex(i) + ((PeopleNumberTypeBean)peopleNumberTypes.get(i)).getTypeName();
      IReportUseBeanR2C1 iReportUseBean = new IReportUseBeanR2C1();
      iReportUseBean.setColumnGroup(columnGroup);
      iReportUseBean.setRowGroup(rowGroup);
      iReportUseBean.setRowTop(rowTop);
      iReportUseBean.setCountNum(Integer.valueOf(row2[i]));
      list.add(iReportUseBean);
    } 
    for (i = 0; i < peopleNumberTypes.size(); i++) {
      String rowTop = "     合    計";
      String rowGroup = formattedIndex(1) + "女";
      String columnGroup = formattedIndex(i) + ((PeopleNumberTypeBean)peopleNumberTypes.get(i)).getTypeName();
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
        String rowTop = formattedIndex(j) + ((Iltb15CountryCode)iltb15CountryCodeList.get(j)).getIlNtnm();
        String rowGroup = formattedIndex(0) + "男";
        String columnGroup = formattedIndex(i) + ((PeopleNumberTypeBean)peopleNumberTypes.get(i)).getTypeName();
        IReportUseBeanR2C1 iReportUseBeanMale = new IReportUseBeanR2C1();
        iReportUseBeanMale.setColumnGroup(columnGroup);
        iReportUseBeanMale.setRowGroup(rowGroup);
        iReportUseBeanMale.setRowTop(rowTop);
        iReportUseBeanMale.setCountNum(Integer.valueOf(countNumMaleArr[j][i]));
        list.add(iReportUseBeanMale);
      } 
      for (j = 0; j < iltb15CountryCodeList.size(); j++) {
        String rowTop = formattedIndex(j) + ((Iltb15CountryCode)iltb15CountryCodeList.get(j)).getIlNtnm();
        String rowGroup = formattedIndex(1) + "女";
        String columnGroup = formattedIndex(i) + ((PeopleNumberTypeBean)peopleNumberTypes.get(i)).getTypeName();
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
  
  public static JRBeanCollectionDataSource buildByPeopleNumberTypeAndCountry(List<Iltb01Main> iltb01MainListIsNew, List<Iltb01Main> iltb01MainListIsFound, List<Iltb01Main> iltb01MainListIsNow, List<PeopleNumberTypeBean> peopleNumberTypes, List<Iltb15CountryCode> iltb15CountryCodeList) {
    List<IReportUseBeanR2C1> list = new ArrayList<IReportUseBeanR2C1>();
    int[][] countNumMaleArr = new int[iltb15CountryCodeList.size()][peopleNumberTypes.size()];
    int[][] countNumFeMaleArr = new int[iltb15CountryCodeList.size()][peopleNumberTypes.size()];
    int[] row1 = new int[peopleNumberTypes.size()];
    int[] row2 = new int[peopleNumberTypes.size()];
    int[] row3 = new int[peopleNumberTypes.size()];
    for (Iltb01Main iltb01Main : iltb01MainListIsNew) {
      String ilSex = iltb01Main.getIlSex();
      String ilNtcd = iltb01Main.getIlNtcd();
      boolean isInFirstSix = false;
      int idx = 0;
      for (int j = 0; j < iltb15CountryCodeList.size(); j++) {
        String ilNtcdCode = ((Iltb15CountryCode)iltb15CountryCodeList.get(j)).getIlNtcd();
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
        continue;
      } 
      if ("2".equals(ilSex)) {
        countNumFeMaleArr[idx][0] = countNumFeMaleArr[idx][0] + 1;
        row1[0] = row1[0] + 1;
        row3[0] = row3[0] + 1;
      } 
    } 
    for (Iltb01Main iltb01Main : iltb01MainListIsFound) {
      String ilSex = iltb01Main.getIlSex();
      String ilNtcd = iltb01Main.getIlNtcd();
      boolean isInFirstSix = false;
      int idx = 0;
      for (int j = 0; j < iltb15CountryCodeList.size(); j++) {
        String ilNtcdCode = ((Iltb15CountryCode)iltb15CountryCodeList.get(j)).getIlNtcd();
        if (ilNtcdCode.equals(ilNtcd)) {
          isInFirstSix = true;
          idx = j;
        } 
      } 
      if (!isInFirstSix)
        idx = peopleNumberTypes.size() - 1; 
      if ("1".equals(ilSex)) {
        countNumMaleArr[idx][1] = countNumMaleArr[idx][1] + 1;
        row1[1] = row1[1] + 1;
        row2[1] = row2[1] + 1;
        continue;
      } 
      if ("2".equals(ilSex)) {
        countNumFeMaleArr[idx][1] = countNumFeMaleArr[idx][1] + 1;
        row1[1] = row1[1] + 1;
        row3[1] = row3[1] + 1;
      } 
    } 
    for (Iltb01Main iltb01Main : iltb01MainListIsNow) {
      String ilSex = iltb01Main.getIlSex();
      String ilNtcd = iltb01Main.getIlNtcd();
      boolean isInFirstSix = false;
      int idx = 0;
      for (int j = 0; j < iltb15CountryCodeList.size(); j++) {
        String ilNtcdCode = ((Iltb15CountryCode)iltb15CountryCodeList.get(j)).getIlNtcd();
        if (ilNtcdCode.equals(ilNtcd)) {
          isInFirstSix = true;
          idx = j;
        } 
      } 
      if (!isInFirstSix)
        idx = peopleNumberTypes.size() - 1; 
      if ("1".equals(ilSex)) {
        countNumMaleArr[idx][2] = countNumMaleArr[idx][2] + 1;
        row1[2] = row1[2] + 1;
        row2[2] = row2[2] + 1;
        continue;
      } 
      if ("2".equals(ilSex)) {
        countNumFeMaleArr[idx][2] = countNumFeMaleArr[idx][2] + 1;
        row1[2] = row1[2] + 1;
        row3[2] = row3[2] + 1;
      } 
    } 
    int i;
    for (i = 0; i < peopleNumberTypes.size(); i++) {
      String rowTop = "     ";
      String rowGroup = formattedIndex(0) + "總    計";
      String columnGroup = formattedIndex(i) + ((PeopleNumberTypeBean)peopleNumberTypes.get(i)).getTypeName();
      IReportUseBeanR2C1 iReportUseBean = new IReportUseBeanR2C1();
      iReportUseBean.setColumnGroup(columnGroup);
      iReportUseBean.setRowGroup(rowGroup);
      iReportUseBean.setRowTop(rowTop);
      iReportUseBean.setCountNum(Integer.valueOf(row1[i]));
      list.add(iReportUseBean);
    } 
    for (i = 0; i < peopleNumberTypes.size(); i++) {
      String rowTop = "     合    計";
      String rowGroup = formattedIndex(0) + "男";
      String columnGroup = formattedIndex(i) + ((PeopleNumberTypeBean)peopleNumberTypes.get(i)).getTypeName();
      IReportUseBeanR2C1 iReportUseBean = new IReportUseBeanR2C1();
      iReportUseBean.setColumnGroup(columnGroup);
      iReportUseBean.setRowGroup(rowGroup);
      iReportUseBean.setRowTop(rowTop);
      iReportUseBean.setCountNum(Integer.valueOf(row2[i]));
      list.add(iReportUseBean);
    } 
    for (i = 0; i < peopleNumberTypes.size(); i++) {
      String rowTop = "     合    計";
      String rowGroup = formattedIndex(1) + "女";
      String columnGroup = formattedIndex(i) + ((PeopleNumberTypeBean)peopleNumberTypes.get(i)).getTypeName();
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
        String rowTop = formattedIndex(j) + ((Iltb15CountryCode)iltb15CountryCodeList.get(j)).getIlNtnm();
        String rowGroup = formattedIndex(0) + "男";
        String columnGroup = formattedIndex(i) + ((PeopleNumberTypeBean)peopleNumberTypes.get(i)).getTypeName();
        IReportUseBeanR2C1 iReportUseBeanMale = new IReportUseBeanR2C1();
        iReportUseBeanMale.setColumnGroup(columnGroup);
        iReportUseBeanMale.setRowGroup(rowGroup);
        iReportUseBeanMale.setRowTop(rowTop);
        iReportUseBeanMale.setCountNum(Integer.valueOf(countNumMaleArr[j][i]));
        list.add(iReportUseBeanMale);
      } 
      for (j = 0; j < iltb15CountryCodeList.size(); j++) {
        String rowTop = formattedIndex(j) + ((Iltb15CountryCode)iltb15CountryCodeList.get(j)).getIlNtnm();
        String rowGroup = formattedIndex(1) + "女";
        String columnGroup = formattedIndex(i) + ((PeopleNumberTypeBean)peopleNumberTypes.get(i)).getTypeName();
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
  
  public static JRBeanCollectionDataSource buildByYearAndCountry(List<Iltb01Main> iltb01MainList, List<Iltb15CountryCode> iltb15CountryCodeList, List<YearBean> years) {
    List<IReportUseBeanR1C2> list = new ArrayList<IReportUseBeanR1C2>();
    int[][] countNumMaleArr = new int[years.size()][iltb15CountryCodeList.size()];
    int[][] countNumFeMaleArr = new int[years.size()][iltb15CountryCodeList.size()];
    int[] row1 = new int[years.size()];
    int[] row2 = new int[years.size()];
    int[] row3 = new int[years.size()];
    int[] column1 = new int[iltb15CountryCodeList.size()];
    int[] column2 = new int[iltb15CountryCodeList.size()];
    for (Iltb01Main iltb01Main : iltb01MainList) {
      String ilSex = iltb01Main.getIlSex();
      String ilNtcd = iltb01Main.getIlNtcd();
      int i3 = countYear(iltb01Main);
      for (int i4 = 0; i4 < iltb15CountryCodeList.size(); i4++) {
        String ilNtcdCode = ((Iltb15CountryCode)iltb15CountryCodeList.get(i4)).getIlNtcd();
        if (ilNtcdCode.equals(ilNtcd))
          if ("1".equals(ilSex)) {
            countNumMaleArr[i3][i4] = countNumMaleArr[i3][i4] + 1;
            column1[i4] = column1[i4] + 1;
            row1[i3] = row1[i3] + 1;
            row2[i3] = row2[i3] + 1;
          } else if ("2".equals(ilSex)) {
            countNumFeMaleArr[i3][i4] = countNumFeMaleArr[i3][i4] + 1;
            column2[i4] = column2[i4] + 1;
            row1[i3] = row1[i3] + 1;
            row3[i3] = row3[i3] + 1;
          }  
      } 
    } 
    int sumAll = 0;
    for (int i = 0; i < row1.length; i++)
      sumAll += row1[i]; 
    IReportUseBeanR1C2 iReportUseBeanTop = new IReportUseBeanR1C2();
    iReportUseBeanTop.setColumnTop(formattedIndex(0) + "");
    iReportUseBeanTop.setColumnGroup(formattedIndex(0) + "總    計");
    iReportUseBeanTop.setRowGroup(formattedIndex(0) + "合    計");
    iReportUseBeanTop.setCountNum(Integer.valueOf(sumAll));
    list.add(iReportUseBeanTop);
    for (int j = 0; j < years.size(); j++) {
      String columnTop = formattedIndex(0) + "";
      String columnGroup = formattedIndex(0) + "總    計";
      String rowGroup = formattedIndex(j + 1) + ((YearBean)years.get(j)).getYearName();
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
    iReportUseBeanTop2.setColumnTop(formattedIndex(1) + "合    計");
    iReportUseBeanTop2.setColumnGroup(formattedIndex(0) + "男");
    iReportUseBeanTop2.setRowGroup(formattedIndex(0) + "合    計");
    iReportUseBeanTop2.setCountNum(Integer.valueOf(sumMale));
    list.add(iReportUseBeanTop2);
    for (int m = 0; m < years.size(); m++) {
      String columnTop = formattedIndex(1) + "合    計";
      String columnGroup = formattedIndex(0) + "男";
      String rowGroup = formattedIndex(m + 1) + ((YearBean)years.get(m)).getYearName();
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
    iReportUseBeanTop3.setColumnTop(formattedIndex(1) + "合    計");
    iReportUseBeanTop3.setColumnGroup(formattedIndex(1) + "女");
    iReportUseBeanTop3.setRowGroup(formattedIndex(0) + "合    計");
    iReportUseBeanTop3.setCountNum(Integer.valueOf(sumFeMale));
    list.add(iReportUseBeanTop3);
    for (int i2 = 0; i2 < years.size(); i2++) {
      String columnTop = formattedIndex(1) + "合    計";
      String columnGroup = formattedIndex(1) + "女";
      String rowGroup = formattedIndex(i2 + 1) + ((YearBean)years.get(i2)).getYearName();
      IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
      iReportUseBean.setColumnTop(columnTop);
      iReportUseBean.setColumnGroup(columnGroup);
      iReportUseBean.setRowGroup(rowGroup);
      iReportUseBean.setCountNum(Integer.valueOf(row3[i2]));
      list.add(iReportUseBean);
    } 
    int i1;
    for (i1 = 0; i1 < iltb15CountryCodeList.size(); i1++) {
      String columnTop = formattedIndex(i1 + 2) + ((Iltb15CountryCode)iltb15CountryCodeList.get(i1)).getIlNtnm();
      String columnGroup = formattedIndex(0) + "男";
      String rowGroup = formattedIndex(0) + "合    計";
      IReportUseBeanR1C2 iReportUseBean = new IReportUseBeanR1C2();
      iReportUseBean.setColumnTop(columnTop);
      iReportUseBean.setColumnGroup(columnGroup);
      iReportUseBean.setRowGroup(rowGroup);
      iReportUseBean.setCountNum(Integer.valueOf(column1[i1]));
      list.add(iReportUseBean);
      columnGroup = formattedIndex(1) + "女";
      IReportUseBeanR1C2 iReportUseBean2 = new IReportUseBeanR1C2();
      iReportUseBean2.setColumnTop(columnTop);
      iReportUseBean2.setColumnGroup(columnGroup);
      iReportUseBean2.setRowGroup(rowGroup);
      iReportUseBean2.setCountNum(Integer.valueOf(column2[i1]));
      list.add(iReportUseBean2);
    } 
    for (i1 = 0; i1 < iltb15CountryCodeList.size(); i1++) {
      for (int i3 = 0; i3 < years.size(); i3++) {
        String columnTop = formattedIndex(i1 + 2) + ((Iltb15CountryCode)iltb15CountryCodeList.get(i1)).getIlNtnm();
        String columnGroup = formattedIndex(0) + "男";
        String rowGroup = formattedIndex(i3 + 1) + ((YearBean)years.get(i3)).getYearName();
        IReportUseBeanR1C2 iReportUseBeanMale = new IReportUseBeanR1C2();
        iReportUseBeanMale.setColumnTop(columnTop);
        iReportUseBeanMale.setColumnGroup(columnGroup);
        iReportUseBeanMale.setRowGroup(rowGroup);
        iReportUseBeanMale.setCountNum(Integer.valueOf(countNumMaleArr[i3][i1]));
        list.add(iReportUseBeanMale);
        columnGroup = formattedIndex(1) + "女";
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
    String nowString = getDateString(c);
    c.setTimeInMillis(testDate.getTime());
    String testString = getDateString(c);
    return nowString.equals(testString);
  }
  
  private static int countYear(Iltb01Main iltb01Main) {
    long countLong = 0L;
    if (iltb01Main.getIlArcfm() != null) {
      countLong = iltb01Main.getIlArcfm().getTime();
    } else if (iltb01Main.getIlApydt() != null) {
      countLong = iltb01Main.getIlApydt().getTime();
    } 
    long nowLong = System.currentTimeMillis();
    Long years = Long.valueOf((nowLong - countLong) / 1471228928L);
    int back = years.intValue();
    if (back < 0) {
      back = 0;
    } else if (back >= 21) {
      back = 21;
    } 
    return back;
  }
  
  private static String getDateString(Calendar c) {
    return "" + c.get(1) + "" + c.get(2);
  }
  
  private static String formattedIndex(int idx) {
    DecimalFormat df = new DecimalFormat("00000");
    return df.format(idx);
  }
  
  public static void main(String[] args) {
    System.out.println(getDateString(Calendar.getInstance()));
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\report\CommonDataBuilder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */