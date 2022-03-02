package tw.gov.npa.il.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import tw.gov.npa.il.dao.IltbFuncRole;
import tw.gov.npa.il.dao.IltbRole;
import tw.gov.npa.il.dao.IltbSystemFlowStepConfig;
import tw.gov.npa.il.myDao.MyIltbFuncRoleDAO;
import tw.gov.npa.il.myDao.MyIltbRoleDAO;
import tw.gov.npa.il.myDao.MyIltbSystemFlowStepConfigDAO;

public class InitDataDao {
  public MyIltbSystemFlowStepConfigDAO iltbSystemFlowStepConfigDAO = new MyIltbSystemFlowStepConfigDAO();
  
  public MyIltbFuncRoleDAO iltbFuncRoleDAO = new MyIltbFuncRoleDAO();
  
  public MyIltbRoleDAO iltbRoleDAO = new MyIltbRoleDAO();
  
  private Object[][] initRoleArr = new Object[][] { { "ILN00001", "居留外僑一般權限", "" }, { "ILN00002", "警/分局承辦人", "" }, { "ILN00004", "署承辦人", "" } };
  
  private Object[][] initFuncArr = new Object[][] { 
      { "勤區查察作業", "1", "IL02000M.action", "0", "", "IL02000M", "1", "" }, { "查察記事", "1.1", "IL02A01U01.action", "1", "", "IL02A01U01", "1", "" }, { "外責區註記", "1.2", "IL02C01U01.action", "1", "", "IL02C01U01", "1", "" }, { "居留資料查詢作業", "2", "IL03000M.action", "0", "", "IL03000M.action", "1", "" }, { "外僑居留資料查詢(一)", "2.1", "IL03A01Q01.action", "1", "", "IL03A01Q01", "1", "" }, { "轄區狀況統計資料", "2.3", "IL03B01P00.action", "1", "", "IL03B01P00", "1", "" }, { "線上報表管理作業", "2.4", "IL03D01P01.action", "1", "", "IL03D01P01", "1", "" }, { "統計報表作業", "3", "IL04000M.action", "0", "", "IL04000M", "1", "" }, { "月統計報表下載", "3.1", "IL04A01Q01.action", "1", "", "IL04A01Q01", "1", "" }, 
      { "自由檢索報表(固定欄項)", "3.2", "IL04B01Q01.action", "1", "", "IL04B01Q01", "1", "" }, { "線上報表管理作業", "3.4", "IL04D01P01.action", "1", "", "IL04D01P01", "1", "" }, { "轉出入資料處理作業", "4", "IL05000M.action", "0", "", "IL05000M", "1", "" }, { "移民署轉入資料", "4.1", "IL05A00M.action", "1", "", "IL05A00M", "1", "" }, { "移民署轉出資料", "4.2", "IL05B00M.action", "1", "", "IL05B00M", "1", "" }, { "轉出入結果查詢", "4.3", "IL05C01Q01.action", "1", "", "IL05C01Q01", "1", "" }, { "共用代碼維護作業", "5", "IL07000M.action", "0", "", "IL07000M", "1", "" }, { "國籍代碼維護", "5.1", "IL07A00M.action", "1", "", "IL07A00M", "1", "" }, 
      { "職業類別代碼維護", "5.2", "IL07B00M.action", "1", "", "IL07B00M", "1", "" }, 
      { "大專院校代碼維護", "5.3", "IL07C00M.action", "1", "", "IL07C00M", "1", "" }, 
      { "特殊身份代碼維護", "5.4", "IL07D00M.action", "1", "", "IL07D00M", "1", "" },
      { "系統管理", "9", "", "0", "", "", "1", "" }, { "影像資料匯入", "9.1", "IL08A01U01.action", "1", "", "IL08A01U01", "1", "" }, { "排程狀態管理", "9.2", "IL08B01U01.action", "1", "", "IL08B01U01", "1", "" }, { "權限設定", "9.4", "IL09A01Query.action", "1", "", "IL09A01Query", "1", "" }, { "功能清單維護", "9.5", "IL09B01Query.action", "1", "", "IL09B01Query", "1", "" }, { "登入作業", "9.6", "IL09C01U01.action", "1", "", "IL09C01U01", "1", "" }, { "公告顯示", "9.7", "IL10A01Q01.action", "1", "", "IL10A01Q01", "1", "" }, { "公告維護", "9.8", "IL10A002M.action", "1", "", "IL10A002M", "1", "" } };
  
  private void setInitRoleData() {
    for (int i = 0; i < this.initRoleArr.length; i++) {
      IltbRole iltbRole = new IltbRole();
      iltbRole.setIlRole(this.initRoleArr[i][0].toString());
      iltbRole.setIlRoleNm(this.initRoleArr[i][1].toString());
      iltbRole.setIlModified(new Timestamp(System.currentTimeMillis()));
      this.iltbRoleDAO.save(iltbRole);
    } 
  }
  
  private void setInitFuncData() {
    for (int i = 0; i < this.initFuncArr.length; i++) {
      IltbSystemFlowStepConfig iltbSystemFlowStepConfig = new IltbSystemFlowStepConfig();
      iltbSystemFlowStepConfig.setIlStepname(this.initFuncArr[i][0].toString());
      iltbSystemFlowStepConfig.setIlIndexid(this.initFuncArr[i][1].toString());
      iltbSystemFlowStepConfig.setIlStepurl(this.initFuncArr[i][2].toString());
      iltbSystemFlowStepConfig.setIlFunctag(this.initFuncArr[i][3].toString());
      iltbSystemFlowStepConfig.setIlFunc(this.initFuncArr[i][5].toString());
      iltbSystemFlowStepConfig.setIlFuncDisable(this.initFuncArr[i][6].toString());
      iltbSystemFlowStepConfig.setIlModified(new Timestamp(System.currentTimeMillis()));
      this.iltbSystemFlowStepConfigDAO.update(iltbSystemFlowStepConfig);
    } 
  }
  
  private void setInitFuncRoleData() {
    List<IltbSystemFlowStepConfig> iltbSystemFlowStepConfigList = new ArrayList<IltbSystemFlowStepConfig>();
    iltbSystemFlowStepConfigList = this.iltbSystemFlowStepConfigDAO.findAll();
    for (int i = 0; i < iltbSystemFlowStepConfigList.size(); i++) {
      List<IltbRole> iltbRoleList = new ArrayList<IltbRole>();
      iltbRoleList = this.iltbRoleDAO.findAll();
      for (int j = 0; j < iltbRoleList.size(); j++) {
        IltbFuncRole iltbFuncRole = new IltbFuncRole();
        int id = i + j + 1;
        iltbFuncRole.setIlFuncNo(((IltbSystemFlowStepConfig)iltbSystemFlowStepConfigList.get(i)).getIlStepid());
        iltbFuncRole.setIlRoleNo(((IltbRole)iltbRoleList.get(j)).getIlRoleNo());
        iltbFuncRole.setIlFunc(this.initFuncArr[i][5].toString());
        iltbFuncRole.setIlFuncNm(this.initFuncArr[i][0].toString());
        iltbFuncRole.setIlRole(this.initRoleArr[j][0].toString());
        iltbFuncRole.setIlRoleNm(this.initRoleArr[j][1].toString());
        iltbFuncRole.setIlEnable("1");
        iltbFuncRole.setIlModified(new Timestamp(System.currentTimeMillis()));
        this.iltbFuncRoleDAO.updateIltbFuncRole(iltbFuncRole);
      } 
    } 
  }
  
  public static void main(String[] args) {
    InitDataDao initDataDao = new InitDataDao();
    initDataDao.setInitRoleData();
    initDataDao.setInitFuncData();
    initDataDao.setInitFuncRoleData();
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\i\\util\InitDataDao.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */