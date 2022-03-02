package tw.gov.npa.il.report.data.il03B01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import tw.gov.npa.il.dao.Iltb01Main;
import tw.gov.npa.il.dao.Iltb15CountryCode;
import tw.gov.npa.il.dao.Iltb16JobCode;
import tw.gov.npa.il.report.CommonDataBuilder;
import tw.gov.npa.il.report.CommonDataGetter;
import tw.gov.npa.il.report.bean.IReportUseIL03B01Bean;
import tw.gov.npa.il.report.bean.JobCodeBean;
import tw.gov.npa.il.util.Constant;

public class Builder03B01 {
	public static JRBeanCollectionDataSource buildBy02P(List<Iltb01Main> iltb01MainList) {
		List<Iltb15CountryCode> iltb15CountryCodeList = CommonDataGetter.getCountryCode();
		List<Iltb16JobCode> iltb16JobCodeList = CommonDataGetter.getJobCode();
		List<JobCodeBean> jodeCodeBeanList = CommonDataGetter.getJobCodeBean(true);
		return CommonDataBuilder.buildByCountryAndJob(iltb01MainList, iltb15CountryCodeList, iltb16JobCodeList,
				jodeCodeBeanList);
	}

	public static JRBeanCollectionDataSource build(List<Iltb01Main> iltb01MainList) {
		Constant constant = new Constant();
		List<IReportUseIL03B01Bean> list = new ArrayList<IReportUseIL03B01Bean>();
		List<Iltb15CountryCode> iltb15CountryCodeList = CommonDataGetter.getCountryCode();
		Map<String, String> map_Code_Name_CountryCode = new HashMap<String, String>();
		for (Iltb15CountryCode iltb15CountryCode : iltb15CountryCodeList)
			map_Code_Name_CountryCode.put(iltb15CountryCode.getIlNtcd(), iltb15CountryCode.getIlNtnm());
		List<Iltb16JobCode> iltb16JobCodeList = CommonDataGetter.getJobCode();
		Map<String, String> map_Code_Name_JobCode = new HashMap<String, String>();
		for (Iltb16JobCode iltb16JobCode : iltb16JobCodeList)
			map_Code_Name_JobCode.put(iltb16JobCode.getIlOpcd(), iltb16JobCode.getIlOpnm());
		for (Iltb01Main i : iltb01MainList) {
			IReportUseIL03B01Bean bean = new IReportUseIL03B01Bean();
			bean.setF01(i.getIlArcno());
			bean.setF02(i.getIlEnm());
			bean.setF03(map_Code_Name_CountryCode.get(i.getIlNtcd()));
			bean.setF04((String) constant.getGenderMap().get(i.getIlSex()));
			bean.setF05(i.getIlBthdt());
			bean.setF06(map_Code_Name_JobCode.get(i.getIlJbcd()));
			bean.setF07((String) constant.getIlArcrsnMap().get(i.getIlArcrsn()));
			bean.setF08(i.getIlOfnm());
			bean.setF09(i.getIlArcto()+"");
			bean.setF10(i.getIlPspt());
			bean.setF11(i.getIlAraddr());
			bean.setF12(i.getIlArtel());
			bean.setF13(i.getIlJbaddr());
			bean.setF14(i.getIlJbtel());
			bean.setF15(i.getIlRemrk());
			list.add(bean);
		}
		JRBeanCollectionDataSource jRMainTotalDS = new JRBeanCollectionDataSource(list);
		return jRMainTotalDS;
	}
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\report\data\il03B01\
 * Builder03B01.class Java compiler version: 5 (49.0) JD-Core Version: 1.1.3
 */