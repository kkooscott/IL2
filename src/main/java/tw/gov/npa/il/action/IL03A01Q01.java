package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;

import tw.gov.npa.il.dao.E0dtNpaunitDAO;
import tw.gov.npa.il.dao.Iltb15CountryCode;
import tw.gov.npa.il.dao.Iltb15CountryCodeDAO;
import tw.gov.npa.il.dao.Iltb16JobCode;
import tw.gov.npa.il.dao.Iltb17SchoolCode;
import tw.gov.npa.il.dao.Iltb17SchoolCodeDAO;
import tw.gov.npa.il.dao.Iltb20OnlineReport;
import tw.gov.npa.il.entity.IL07D;
import tw.gov.npa.il.myDao.IL07DDao;
import tw.gov.npa.il.myDao.MyIltb16JobCodeDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

public class IL03A01Q01 extends ActionSupport {
	private static final Logger logger = Logger.getLogger(IL03A01Q01.class);
	
	private IL07DDao il07DDao;

	List<Iltb17SchoolCode> schoolCodes = new ArrayList<Iltb17SchoolCode>();

	List<Iltb15CountryCode> countryCodes = new ArrayList<Iltb15CountryCode>();

	List<Iltb16JobCode> jobCodes = new ArrayList<Iltb16JobCode>();
	
	List<E0dtNpaunitDAO> e0dtUints = new ArrayList<E0dtNpaunitDAO>();
	
	List<IL07D> srchstCodes = new ArrayList<IL07D>();
	
	String LOGPHQ = "";

	public List<Iltb17SchoolCode> getSchoolCodes() {
		return this.schoolCodes;
	}

	public void setSchoolCodes(List<Iltb17SchoolCode> schoolCodes) {
		this.schoolCodes = schoolCodes;
	}

	public List<Iltb15CountryCode> getCountryCodes() {
		return this.countryCodes;
	}

	public void setCountryCodes(List<Iltb15CountryCode> countryCodes) {
		this.countryCodes = countryCodes;
	}

	public List<Iltb16JobCode> getJobCodes() {
		return this.jobCodes;
	}

	public void setJobCodes(List<Iltb16JobCode> jobCodes) {
		this.jobCodes = jobCodes;
	}
	
	public List<E0dtNpaunitDAO> getE0dtUints() {
		return this.e0dtUints;
	}

	public void setE0dtUints(List<E0dtNpaunitDAO> e0dtUints) {
		this.e0dtUints = e0dtUints;
	}
	
	

	public List<IL07D> getSrchstCodes() {
		return srchstCodes;
	}

	public void setSrchstCodes(List<IL07D> srchstCodes) {
		this.srchstCodes = srchstCodes;
	}



	private Date nowDate = new Date();

	public Date getNowDate() {
		return this.nowDate;
	}

	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}
	
	public String getLOGPHQ() {
		return LOGPHQ;
	}

	public void setLOGPHQ(String lOGPHQ) {
		LOGPHQ = lOGPHQ;
	}
	
	

	public IL07DDao getIl07DDao() {
		return il07DDao;
	}

	public void setIl07DDao(IL07DDao il07dDao) {
		il07DDao = il07dDao;
	}

	public String toMain() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("flag", "R");
		session.setAttribute("ilArcno", "");
		session.setAttribute("ilPspt", "");
		session.setAttribute("ilEnm", "");
		session.setAttribute("ilCnm", "");
		session.setAttribute("ilOfnm", "");
		session.setAttribute("ilPhq", "");
		session.setAttribute("ilJbpmdt", "");
		session.setAttribute("ilJbpmdc", "");
		Iltb17SchoolCodeDAO iltb17SchoolCodeDAO = new Iltb17SchoolCodeDAO();
		this.schoolCodes = iltb17SchoolCodeDAO.findAll();
		MyIltb16JobCodeDAO myIltb16JobCodeDAO = new MyIltb16JobCodeDAO();
		this.jobCodes = myIltb16JobCodeDAO.getDataByIlNtprsq();
		Iltb15CountryCodeDAO iltb15CountryCodeDAO = new Iltb15CountryCodeDAO();
		this.countryCodes = iltb15CountryCodeDAO.findAll();
		E0dtNpaunitDAO e0dtNpaunitDAO = new E0dtNpaunitDAO();
		this.e0dtUints = e0dtNpaunitDAO.findByE0UnitFlagSQL("10");
		this.LOGPHQ = (String)session.getAttribute("LOGPHQ");
		this.srchstCodes = il07DDao.findAll();
		return "success";
	}

	public String toQuery() throws Exception {
		return "success";
	}
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL03A01Q01.
 * class Java compiler version: 5 (49.0) JD-Core Version: 1.1.3
 */