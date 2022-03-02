package tw.gov.npa.il.action;

import java.io.IOException;

/**
 * 自由檢索報表(固定欄項)-條件輸入畫面
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;
import tw.gov.npa.il.dao.E0dtNpaunitDAO;
import tw.gov.npa.il.dao.Iltb17SchoolCode;
import tw.gov.npa.il.dao.Iltb17SchoolCodeDAO;
import tw.gov.npa.il.dao.Iltb20OnlineReport;

public class IL04B01Q01 extends ActionSupport {
	private static final Logger logger = Logger.getLogger(IL04B01Q01.class);

	private HttpServletRequest request;

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
	
	List<Iltb17SchoolCode> schoolCodes = new ArrayList<Iltb17SchoolCode>();

	List<E0dtNpaunitDAO> firstUnitCdList = new ArrayList<E0dtNpaunitDAO>();
	
	List<E0dtNpaunitDAO> secondUnitCdList = new ArrayList<E0dtNpaunitDAO>();
	
	private List<Iltb20OnlineReport> iltb20IdList;
	
	private Date nowDate = new Date();
	
	public List<Iltb20OnlineReport> getIltb20IdList() {
		return this.iltb20IdList;
	}
	
	public void setIltb20IdList(List<Iltb20OnlineReport> iltb20IdList) {
		this.iltb20IdList = iltb20IdList;
	}
	
	public List<Iltb17SchoolCode> getSchoolCodes() {
		return this.schoolCodes;
	}
	
	public void setSchoolCodes(List<Iltb17SchoolCode> schoolCodes) {
		this.schoolCodes = schoolCodes;
	}
	
	public Date getNowDate() {
		return this.nowDate;
	}
	
	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}
	
	public List<E0dtNpaunitDAO> getFirstUnitCdList() {
		return firstUnitCdList;
	}

	public void setFirstUnitCdList(List<E0dtNpaunitDAO> firstUnitCdList) {
		this.firstUnitCdList = firstUnitCdList;
	}

	public List<E0dtNpaunitDAO> getSecondUnitCdList() {
		return secondUnitCdList;
	}

	public void setSecondUnitCdList(List<E0dtNpaunitDAO> secondUnitCdList) {
		this.secondUnitCdList = secondUnitCdList;
	}

	public String toMain() throws Exception {
	    Iltb17SchoolCodeDAO iltb17SchoolCodeDAO = new Iltb17SchoolCodeDAO();
	    this.schoolCodes = iltb17SchoolCodeDAO.findAll();
	    E0dtNpaunitDAO e0dtNpaunitDAO = new E0dtNpaunitDAO();
	    this.firstUnitCdList = e0dtNpaunitDAO.findByUnitFlag();
//	    for(E0dtNpaunit vo : firstUnitCdList){
//	    	System.out.println("@@@ getE0DeptCd " + vo.getE0DeptCd());
//	    }
//	    System.out.println("@@@ firstUnitCdList " + firstUnitCdList.size());
	    return "success";
	}
	
	//利用警局代號，取得分局清單
	public void getListByDeptCd() {

		E0dtNpaunitDAO e0dtNpaunitDAO = new E0dtNpaunitDAO();
		this.secondUnitCdList = e0dtNpaunitDAO.findByDeptCd(getHeadUnit());
		JSONObject json = new JSONObject();
		json.put("secondUnitCdList", secondUnitCdList);
		
	    HttpServletResponse response = ServletActionContext.getResponse();
	    response.setContentType("text/html");
	    response.setCharacterEncoding("UTF-8");
	    response.setHeader("Charset", "UTF-8");
	    try {
	      response.getWriter().write(json.toString());
	    } catch (IOException e) {
	      e.printStackTrace();
	    } 
	}
  
	public String toQuery() throws Exception {
		return "success";
	}
	
	private String headUnit;
	
	public String getHeadUnit() {
		return headUnit;
	}

	public void setHeadUnit(String headUnit) {
		this.headUnit = headUnit;
	}
	
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL04B01Q01.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */