package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import tw.gov.npa.il.dao.IltbFuncRole;
import tw.gov.npa.il.dao.IltbRole;
import tw.gov.npa.il.dao.IltbRoleDAO;
import tw.gov.npa.il.dao.IltbSystemFlowStepConfig;
import tw.gov.npa.il.myDao.MyIltbFuncRoleDAO;
import tw.gov.npa.il.myDao.MyIltbSystemFlowStepConfigDAO;

public class IL09B01 extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL09B01.class);
  
  private String result;
  
  private String isFlag;
  
  private MyIltbSystemFlowStepConfigDAO myIltbSystemFlowStepConfigDAO = new MyIltbSystemFlowStepConfigDAO();
  
  private MyIltbFuncRoleDAO myIltbFuncRoleDAO = new MyIltbFuncRoleDAO();
  
  private IltbRoleDAO iltbRoleDAO = new IltbRoleDAO();
  
  private List<IltbSystemFlowStepConfig> iltbSystemFlowStepConfigList = new ArrayList<IltbSystemFlowStepConfig>();
  
  private IltbSystemFlowStepConfig iltbSystemFlowStepConfig = new IltbSystemFlowStepConfig();
  
  private Integer ilStepid;
  
  private String ilStepname;
  
  private String ilIndexid;
  
  private String ilStepurl;
  
  private String ilFunctag;
  
  private String ilLoadtitle;
  
  private String ilFunc;
  
  private String ilFuncDisable;
  
  private String ilModuid;
  
  public String getResult() {
    return this.result;
  }
  
  public void setResult(String result) {
    this.result = result;
  }
  
  public String getIsFlag() {
    return this.isFlag;
  }
  
  public void setIsFlag(String isFlag) {
    this.isFlag = isFlag;
  }
  
  public List<IltbSystemFlowStepConfig> getIltbSystemFlowStepConfigList() {
    return this.iltbSystemFlowStepConfigList;
  }
  
  public void setIltbSystemFlowStepConfigList(List<IltbSystemFlowStepConfig> iltbSystemFlowStepConfigList) {
    this.iltbSystemFlowStepConfigList = iltbSystemFlowStepConfigList;
  }
  
  public IltbSystemFlowStepConfig getIltbSystemFlowStepConfig() {
    return this.iltbSystemFlowStepConfig;
  }
  
  public void setIltbSystemFlowStepConfig(IltbSystemFlowStepConfig iltbSystemFlowStepConfig) {
    this.iltbSystemFlowStepConfig = iltbSystemFlowStepConfig;
  }
  
  public Integer getIlStepid() {
    return this.ilStepid;
  }
  
  public void setIlStepid(Integer ilStepid) {
    this.ilStepid = ilStepid;
  }
  
  public String getIlStepname() {
    return this.ilStepname;
  }
  
  public void setIlStepname(String ilStepname) {
    this.ilStepname = ilStepname;
  }
  
  public String getIlIndexid() {
    return this.ilIndexid;
  }
  
  public void setIlIndexid(String ilIndexid) {
    this.ilIndexid = ilIndexid;
  }
  
  public String getIlStepurl() {
    return this.ilStepurl;
  }
  
  public void setIlStepurl(String ilStepurl) {
    this.ilStepurl = ilStepurl;
  }
  
  public String getIlFunctag() {
    return this.ilFunctag;
  }
  
  public void setIlFunctag(String ilFunctag) {
    this.ilFunctag = ilFunctag;
  }
  
  public String getIlLoadtitle() {
    return this.ilLoadtitle;
  }
  
  public void setIlLoadtitle(String ilLoadtitle) {
    this.ilLoadtitle = ilLoadtitle;
  }
  
  public String getIlFunc() {
    return this.ilFunc;
  }
  
  public void setIlFunc(String ilFunc) {
    this.ilFunc = ilFunc;
  }
  
  public String getIlFuncDisable() {
    return this.ilFuncDisable;
  }
  
  public void setIlFuncDisable(String ilFuncDisable) {
    this.ilFuncDisable = ilFuncDisable;
  }
  
  public String getIlModuid() {
    return this.ilModuid;
  }
  
  public void setIlModuid(String ilModuid) {
    this.ilModuid = ilModuid;
  }
  
  public String toIL09B01() throws Exception {
    return "success";
  }
  
  public String toQuery() throws Exception {
    this.iltbSystemFlowStepConfigList = this.myIltbSystemFlowStepConfigDAO.findAll();
    this.myIltbSystemFlowStepConfigDAO.tryToCloseSession();
    return "success";
  }
  
  public String toNew() throws Exception {
    boolean resultBoo2 = false;
    if ("N".equals(this.isFlag)) {
      List<IltbSystemFlowStepConfig> indexList = this.myIltbSystemFlowStepConfigDAO.searchByIlIndexid(this.ilIndexid);
      System.out.println(String.valueOf(indexList.size()) + "," + ((IltbSystemFlowStepConfig)indexList.get(0)).getIlIndexid());
      String maxIndexStr = ((IltbSystemFlowStepConfig)indexList.get(0)).getIlIndexid().toString();
      int maxIndex = 0;
      for (int i = 0; i < indexList.size(); i++) {
        String[] names = ((IltbSystemFlowStepConfig)indexList.get(i)).getIlIndexid().toString().split("\\.");
        if (Integer.parseInt(names[1]) > maxIndex)
          maxIndex = Integer.parseInt(names[1]); 
      } 
      maxIndex++;
      this.ilIndexid = String.valueOf(this.ilIndexid) + "." + maxIndex;
      this.iltbSystemFlowStepConfig.setIlFunc(this.ilFunc);
      this.iltbSystemFlowStepConfig.setIlStepname(this.ilStepname);
      this.iltbSystemFlowStepConfig.setIlStepurl(this.ilStepurl);
      this.iltbSystemFlowStepConfig.setIlFunctag("1");
      this.iltbSystemFlowStepConfig.setIlFuncDisable(this.ilFuncDisable);
      this.iltbSystemFlowStepConfig.setIlIndexid(this.ilIndexid);
      this.iltbSystemFlowStepConfig.setIlModified(new Timestamp(System.currentTimeMillis()));
      this.iltbSystemFlowStepConfig.setIlModuid(this.ilModuid);
      boolean resultBoo = this.myIltbSystemFlowStepConfigDAO.update(this.iltbSystemFlowStepConfig);
      List<IltbSystemFlowStepConfig> newIltbSystemFlowStepConfigList = this.myIltbSystemFlowStepConfigDAO.searchByIlFunc(this.ilFunc);
      this.ilStepid = ((IltbSystemFlowStepConfig)newIltbSystemFlowStepConfigList.get(0)).getIlStepid();
      List<IltbRole> iltbRoleList = new ArrayList<IltbRole>();
      iltbRoleList = this.iltbRoleDAO.findAll();
      for (IltbRole e : iltbRoleList) {
        IltbFuncRole iltbFuncRole = new IltbFuncRole();
        iltbFuncRole.setIlEnable("1");
        iltbFuncRole.setIlFuncNo(this.ilStepid);
        iltbFuncRole.setIlFuncNm(this.ilStepname);
        iltbFuncRole.setIlFunc(this.ilFunc);
        iltbFuncRole.setIlRole(e.getIlRole());
        iltbFuncRole.setIlRoleNm(e.getIlRoleNm());
        iltbFuncRole.setIlRoleNo(e.getIlRoleNo());
        iltbFuncRole.setIlModified(new Timestamp(System.currentTimeMillis()));
        iltbFuncRole.setIlModuid(this.ilModuid);
        resultBoo2 = this.myIltbFuncRoleDAO.updateIltbFuncRole(iltbFuncRole);
      } 
      if (!resultBoo && !resultBoo2)
        this.isFlag = "F"; 
    } 
    this.iltbSystemFlowStepConfigList = this.myIltbSystemFlowStepConfigDAO.searchByIlFunctag("0");
    this.myIltbFuncRoleDAO.tryToCloseSession();
    this.myIltbSystemFlowStepConfigDAO.tryToCloseSession();
    return "success";
  }
  
  public String toUpdate() throws Exception {
    this.iltbSystemFlowStepConfig = this.myIltbSystemFlowStepConfigDAO.findById(this.ilStepid);
    this.iltbSystemFlowStepConfig.setIlFuncDisable(this.ilFuncDisable);
    boolean resultBoo = this.myIltbSystemFlowStepConfigDAO.update(this.iltbSystemFlowStepConfig);
    this.result = (new StringBuilder(String.valueOf(resultBoo))).toString();
    this.myIltbSystemFlowStepConfigDAO.tryToCloseSession();
    return "success";
  }
  
  public String toDelete() throws Exception {
    return "success";
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL09B01.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */