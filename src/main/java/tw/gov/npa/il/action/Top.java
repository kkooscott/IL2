package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.Enumeration;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class Top extends ActionSupport {
  private static final Logger logger = Logger.getLogger(Top.class);
  
  private Date nowDate = new Date();
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
  }

  private String notNullString(String str) {
    if ( str == null ) {
      str = "";
    }

    return str;
  }

  public String toMain() throws Exception {
    ActionContext context = ActionContext.getContext();
    if (context.getSession().get("LOGCN") == null || "".equals(context.getSession().get("LOGCN"))) {
      HttpServletRequest request = ServletActionContext.getRequest();
      String LOGCN = notNullString(request.getHeader("logcn"));
      if (null ==LOGCN || LOGCN.isEmpty()) {
        LOGCN = "";
      }
      context.getSession().put("LOGCN", LOGCN);
    }

    return "success";
  }
  
  public String toQuery() throws Exception {
    return "success";
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\Top.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */