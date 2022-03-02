package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import tw.gov.npa.il.entity.IL07D;
import tw.gov.npa.il.myDao.IL07DDao;

public class IL07D02U02 extends ActionSupport {
	private static final Logger logger = Logger.getLogger(IL07D02U02.class);

	private Date nowDate = new Date();

	private IL07DDao il07DDao;

	private List<IL07D> queryList;

	private String txtSRCHSTBegin;

	private String txtSRCHSTEnd;

	private String txtSRCHST;

	public String toMain() throws Exception {
		doRealQuery();
		return "success";
	}

	private void doRealQuery() {
		this.queryList = this.il07DDao.viewData(this.txtSRCHSTBegin, this.txtSRCHSTEnd);
	}

	public Date getNowDate() {
		return this.nowDate;
	}

	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}

	public IL07DDao getIl07DDao() {
		return this.il07DDao;
	}

	public void setIl07DDao(IL07DDao il07dDao) {
		this.il07DDao = il07dDao;
	}

	public List<IL07D> getQueryList() {
		return this.queryList;
	}

	public void setQueryList(List<IL07D> queryList) {
		this.queryList = queryList;
	}

	public String getTxtSRCHSTBegin() {
		return this.txtSRCHSTBegin;
	}

	public void setTxtSRCHSTBegin(String txtSRCHSTBegin) {
		this.txtSRCHSTBegin = txtSRCHSTBegin;
	}

	public String getTxtSRCHSTEnd() {
		return this.txtSRCHSTEnd;
	}

	public void setTxtSRCHSTEnd(String txtSRCHSTEnd) {
		this.txtSRCHSTEnd = txtSRCHSTEnd;
	}

	public String getTxtSRCHST() {
		return this.txtSRCHST;
	}

	public void setSRCHST(String txtSRCHST) {
		this.txtSRCHST = txtSRCHST;
	}
}
