package tw.gov.npa.il.report.data.il04a01;

import java.util.List;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import tw.gov.npa.il.dao.Iltb01Main;
import tw.gov.npa.il.dao.Iltb15CountryCode;
import tw.gov.npa.il.dao.Iltb16JobCode;
import tw.gov.npa.il.myDao.MyIltb01MainDAO;
import tw.gov.npa.il.report.CommonDataBuilder;
import tw.gov.npa.il.report.CommonDataGetter;
import tw.gov.npa.il.report.bean.JobCodeBean;

public class Builder08A14_10P {
	/**
	 * 臺南市居留外僑統計(按國籍及職業分)
	 * @return
	 */
	public static JRBeanCollectionDataSource build(){		
    	//撈主檔資料
		MyIltb01MainDAO myIltb01MainDAO = new MyIltb01MainDAO();
    	List<Iltb01Main> iltb01MainList = myIltb01MainDAO.getIL08A14_10P();    	
    	System.out.println("iltb01MainList="+iltb01MainList.size());//test
    	
    	//撈國籍代碼表
    	List<Iltb15CountryCode> iltb15CountryCodeList = CommonDataGetter.getCountryCode();
    	
    	//撈職業代碼表
    	List<Iltb16JobCode> iltb16JobCodeList = CommonDataGetter.getJobCode();
    	
    	//撈職業列印表
    	List<JobCodeBean> jodeCodeBeanList = CommonDataGetter.getJobCodeBean(true);
    	
    	//產出報表
    	return CommonDataBuilder.buildByCountryAndJob(iltb01MainList, iltb15CountryCodeList, iltb16JobCodeList, jodeCodeBeanList);
	}
}
