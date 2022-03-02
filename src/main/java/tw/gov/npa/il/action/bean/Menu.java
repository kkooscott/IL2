package tw.gov.npa.il.action.bean;

import java.util.ArrayList;
import java.util.List;

public class Menu {
  private String stepName;
  
  private String step;
  
  private String index;
  
  private String url;
  
  private String stepId;
  
  private String parentId;
  
  private ArrayList childList;
  
  private int level;
  
  private int seq;
  
  public String getStepName() {
    return this.stepName;
  }
  
  public String getStep() {
    return this.step;
  }
  
  public String getIndex() {
    return this.index;
  }
  
  public String getUrl() {
    return this.url;
  }
  
  public String getStepId() {
    return this.stepId;
  }
  
  public String getParentId() {
    return this.parentId;
  }
  
  public int getLevel() {
    return this.level;
  }
  
  public int getSeq() {
    return this.seq;
  }
  
  public void setStepName(String stepName) {
    this.stepName = stepName;
  }
  
  public void setStep(String step) {
    this.step = step;
  }
  
  public void setIndex(String index) {
    this.index = index;
  }
  
  public void setUrl(String url) {
    this.url = url;
  }
  
  public void setStepId(String stepId) {
    this.stepId = stepId;
  }
  
  public void setParentId(String parentId) {
    this.parentId = parentId;
  }
  
  public void setLevel(int level) {
    this.level = level;
  }
  
  public void setSeq(int seq) {
    this.seq = seq;
  }
  
  public void addChild(Menu menu) {
    if (this.childList == null)
      this.childList = new ArrayList(); 
    this.childList.add(menu);
  }
  
  public List getChildList() {
    return this.childList;
  }
  
  public String toString() {
    return "stepName=" + this.stepName + "index=" + this.index + "  parentId=" + this.parentId + " level=" + this.level;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\bean\Menu.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */