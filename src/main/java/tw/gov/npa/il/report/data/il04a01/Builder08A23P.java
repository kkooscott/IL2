package tw.gov.npa.il.report.data.il04a01;

import java.util.List;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import tw.gov.npa.il.dao.Iltb01Main;
import tw.gov.npa.il.dao.Iltb15CountryCode;
import tw.gov.npa.il.myDao.MyIltb01MainDAO;
import tw.gov.npa.il.report.CommonDataBuilder;
import tw.gov.npa.il.report.CommonDataGetter;
import tw.gov.npa.il.report.bean.PeopleNumberTypeBean;

public class Builder08A23P {
  public static JRBeanCollectionDataSource build() {
    MyIltb01MainDAO myIltb01MainDAO = new MyIltb01MainDAO();
    List<Iltb01Main> iltb01MainListIsNew = myIltb01MainDAO.getIL08A23PIsNew();
    System.out.println("新增逃逸人數:iltb01MainList=" + iltb01MainListIsNew.size());
    List<Iltb01Main> iltb01MainListIsFound = myIltb01MainDAO.getIL08A23PIsFound();
    System.out.println("當月查獲人數:iltb01MainList=" + iltb01MainListIsFound.size());
    List<Iltb01Main> iltb01MainListIsNow = myIltb01MainDAO.getIL08A23PIsNow();
    System.out.println("目前協尋人數:iltb01MainList=" + iltb01MainListIsNow.size());
    List<PeopleNumberTypeBean> peopleNumberTypes = CommonDataGetter.getPeopleNumberType();
    List<Iltb15CountryCode> iltb15CountryCodeList = CommonDataGetter.getCountryCodeOfWorkers();
    return CommonDataBuilder.buildByPeopleNumberTypeAndCountry(iltb01MainListIsNew, iltb01MainListIsFound, iltb01MainListIsNow, peopleNumberTypes, iltb15CountryCodeList);
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\report\data\il04a01\Builder08A23P.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */