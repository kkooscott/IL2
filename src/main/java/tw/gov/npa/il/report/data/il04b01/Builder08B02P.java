package tw.gov.npa.il.report.data.il04b01;

import java.util.List;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import tw.gov.npa.il.dao.Iltb01Main;
import tw.gov.npa.il.dao.Iltb15CountryCode;
import tw.gov.npa.il.myDao.MyIltb01MainDAO;
import tw.gov.npa.il.report.CommonDataBuilder;
import tw.gov.npa.il.report.CommonDataGetter;
import tw.gov.npa.il.report.bean.AreaCodeBean;

public class Builder08B02P {
  public static JRBeanCollectionDataSource build(String whereCondition) {
    MyIltb01MainDAO myIltb01MainDAO = new MyIltb01MainDAO();
    List<Iltb01Main> iltb01MainList = myIltb01MainDAO.getIL08B02P(whereCondition);
    System.out.println("iltb01MainList=" + iltb01MainList.size());
    List<Iltb15CountryCode> iltb15CountryCodeList = CommonDataGetter.getCountryCode();
    List<AreaCodeBean> areaCodes = CommonDataGetter.getAreaCode();
    return CommonDataBuilder.buildByCountryAndArea(iltb01MainList, iltb15CountryCodeList, areaCodes);
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\report\data\il04b01\Builder08B02P.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */