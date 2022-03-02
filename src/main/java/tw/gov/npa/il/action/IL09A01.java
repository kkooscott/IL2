package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import tw.gov.npa.il.e0db.myDao.CW08ADAO;
import tw.gov.npa.il.entity.basic.TbFuncRole;
import tw.gov.npa.il.entity.basic.TbRole;
import tw.gov.npa.il.entity.basic.TbSystemFlowStepConfig;

public class IL09A01 extends ActionSupport {
  private static Logger logger = Logger.getLogger(IL09A01.class);
  
  private CW08ADAO il09A01Dao;
  
  private String result;
  
  private List<TbSystemFlowStepConfig> tbFuncGroupList = new ArrayList<TbSystemFlowStepConfig>();
  
  private List<TbSystemFlowStepConfig> tbFuncList = new ArrayList<TbSystemFlowStepConfig>();
  
  private List<TbRole> tbRoleList = new ArrayList<TbRole>();
  
  private List<TbFuncRole> tbFuncRoleGroupList = new ArrayList<TbFuncRole>();
  
  private String stepid;
  
  private String funcDisable;
  
  public String toCW08A00M() {
    logger.debug("Enter toCW08A00M");
    this.tbFuncList = this.il09A01Dao.findAllSysFlowStepConfig();
    this.tbRoleList = this.il09A01Dao.findAllRole();
    this.tbFuncRoleGroupList = this.il09A01Dao.findAllFuncRole();
    return "success";
  }
  
  public String doUpdate08A() {
    logger.info("stepid=" + this.stepid);
    logger.info("funcDisable: " + this.funcDisable);
    int updateRes = 0;
    boolean resultBoo = false;
    String[] names = this.funcDisable.split(",");
    List<TbFuncRole> tbFuncRoleList = this.il09A01Dao.searchFuncRoleByFuncNo(Integer.parseInt(this.stepid));
    for (TbFuncRole e : tbFuncRoleList) {
      TbFuncRole tbFuncRole = new TbFuncRole();
      tbFuncRole = this.il09A01Dao.findFuncRoleById(e.getFuncRoleNo());
      boolean changeBoo = false;
      byte b;
      int i;
      String[] arrayOfString;
      for (i = (arrayOfString = names).length, b = 0; b < i; ) {
        String name = arrayOfString[b];
        if (Integer.toString(tbFuncRole.getFuncRoleNo()).equals(name))
          changeBoo = true; 
        b++;
      } 
      if (changeBoo) {
        tbFuncRole.setEnable("1");
      } else {
        tbFuncRole.setEnable("0");
      } 
      updateRes = this.il09A01Dao.updateTbFuncRole(tbFuncRole);
    } 
    resultBoo = (updateRes > 0);
    this.result = (new StringBuilder(String.valueOf(resultBoo))).toString();
    return "success";
  }
  
  public CW08ADAO getIl09A01Dao() {
    return this.il09A01Dao;
  }
  
  public void setIl09A01Dao(CW08ADAO il09a01Dao) {
    this.il09A01Dao = il09a01Dao;
  }
  
  public String getResult() {
    return this.result;
  }
  
  public void setResult(String result) {
    this.result = result;
  }
  
  public List<TbSystemFlowStepConfig> getTbFuncGroupList() {
    return this.tbFuncGroupList;
  }
  
  public void setTbFuncGroupList(List<TbSystemFlowStepConfig> tbFuncGroupList) {
    this.tbFuncGroupList = tbFuncGroupList;
  }
  
  public List<TbSystemFlowStepConfig> getTbFuncList() {
    return this.tbFuncList;
  }
  
  public void setTbFuncList(List<TbSystemFlowStepConfig> tbFuncList) {
    this.tbFuncList = tbFuncList;
  }
  
  public List<TbRole> getTbRoleList() {
    return this.tbRoleList;
  }
  
  public void setTbRoleList(List<TbRole> tbRoleList) {
    this.tbRoleList = tbRoleList;
  }
  
  public List<TbFuncRole> getTbFuncRoleGroupList() {
    return this.tbFuncRoleGroupList;
  }
  
  public void setTbFuncRoleGroupList(List<TbFuncRole> tbFuncRoleGroupList) {
    this.tbFuncRoleGroupList = tbFuncRoleGroupList;
  }
  
  public String getStepid() {
    return this.stepid;
  }
  
  public void setStepid(String stepid) {
    this.stepid = stepid;
  }
  
  public String getFuncDisable() {
    return this.funcDisable;
  }
  
  public void setFuncDisable(String funcDisable) {
    this.funcDisable = funcDisable;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL09A01.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */