package tw.gov.npa.il.test;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import org.apache.log4j.Logger;
import tw.gov.npa.il.util.NTPCUtil;

public class PeopleActionOld extends ActionSupport {
  private static final Logger logger = Logger.getLogger(PeopleActionOld.class);
  
  private String idno;
  
  private NTPCUtil ntpcUtil = new NTPCUtil();
  
  private String jasperFile;
  
  private String jasperFileName;
  
  private String jrprintFile;
  
  private String jrprintFileName;
  
  private String pdfFileName;
  
  private String pdfFile;
  
  private InputStream pdfStream;
  
  private String contentDisposition;
  
  public String toMain() throws Exception {
    return "success";
  }
  
  public String doAddress() {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    String dateTime = dateFormat.format(new Date());
    Map<String, String> param = new HashMap<String, String>();
    param.put("address", "新北市中和區永和路300號");
    param.put("dateTime", "2013/08/07");
    ActionContext context = ActionContext.getContext();
    HttpServletRequest request = (HttpServletRequest)context.get("com.opensymphony.xwork2.dispatcher.HttpServletRequest");
    String contextPath = request.getSession().getServletContext().getRealPath("/");
    this.jasperFileName = "jrxml" + File.separator + "address.jasper";
    this.jasperFile = String.valueOf(contextPath) + this.jasperFileName;
    this.jrprintFileName = "jrxml" + File.separator + "address.jrprint";
    this.jrprintFile = String.valueOf(contextPath) + this.jrprintFileName;
    this.pdfFileName = String.valueOf(this.ntpcUtil.appendDateString("address")) + ".pdf";
    this.pdfFile = String.valueOf(contextPath) + this.pdfFileName;
    List<Address1> addressList = getAddress1List();
    System.out.println("addressList=" + addressList.size());
    System.out.println("jasperFileName=" + this.jasperFileName);
    System.out.println("jasperFile=" + this.jasperFile);
    System.out.println("jrprintFileName=" + this.jrprintFileName);
    System.out.println("jrprintFile=" + this.jrprintFile);
    System.out.println("pdfFileName=" + this.jasperFile);
    System.out.println("pdfFile=" + this.pdfFile);
    try {
      JRBeanCollectionDataSource jRBeanCollectionDataSource = new JRBeanCollectionDataSource(null);
      System.out.println(jRBeanCollectionDataSource.toString());
      JasperPrint jprint = JasperFillManager.fillReport(this.jasperFile, null, (JRDataSource)jRBeanCollectionDataSource);
      System.out.println("1");
      JRPdfExporter pdfExporter = new JRPdfExporter();
      pdfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jprint);
      pdfExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, 
          this.pdfFile);
      try {
        pdfExporter.exportReport();
      } catch (JRException e) {
        e.printStackTrace();
      } 
      System.out.println("2");
      FileInputStream fis = new FileInputStream(this.pdfFile);
      this.pdfStream = new BufferedInputStream(fis);
      System.out.println("3");
    } catch (JRException e) {
      logger.error(e, (Throwable)e);
      e.printStackTrace();
      return "error";
    } catch (FileNotFoundException e) {
      logger.error(e, e);
      e.printStackTrace();
      return "error";
    } catch (Exception e) {
      e.printStackTrace();
    } 
    System.out.println("4");
    this.contentDisposition = "attachment;  filename=\"" + this.pdfFileName;
    return "downloadPDF";
  }
  
  private List<Address1> getAddress1List() {
    List<Address1> address1List = new ArrayList<Address1>();
    Address1 address_11 = new Address1();
    address_11.setF01("2012/08/05");
    address_11.setF02("2012/08/30");
    address_11.setF03("升級直轄市");
    address_11.setF04("台北縣中和市永和路300號");
    address1List.add(address_11);
    return address1List;
  }
  
  public String convertTWDate(String AD) {
    SimpleDateFormat df4 = new SimpleDateFormat("yyyy/MM/dd");
    SimpleDateFormat df2 = new SimpleDateFormat("/MM/dd HH:mm:ss");
    Calendar cal = Calendar.getInstance();
    String TWDate = "";
    try {
      cal.setTime(df4.parse(AD));
      cal.add(1, -1911);
      TWDate = String.valueOf(Integer.toString(cal.get(1))) + 
        df2.format(cal.getTime());
      return TWDate;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    } 
  }
  
  public String getIdno() {
    return this.idno;
  }
  
  public void setIdno(String idno) {
    this.idno = idno;
  }
  
  public NTPCUtil getNtpcUtil() {
    return this.ntpcUtil;
  }
  
  public void setNtpcUtil(NTPCUtil ntpcUtil) {
    this.ntpcUtil = ntpcUtil;
  }
  
  public String getContentDisposition() {
    return this.contentDisposition;
  }
  
  public InputStream getPdfStream() {
    return this.pdfStream;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\test\PeopleActionOld.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */