package tw.gov.npa.il.myDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;
import org.jfree.util.Log;

import tw.gov.npa.il.action.bean.IL03A01Q02Bean;
import tw.gov.npa.il.action.bean.IL03A01Query02Bean;
import tw.gov.npa.il.dao.HibernateSessionFactory;
import tw.gov.npa.il.dao.Iltb01Main;
import tw.gov.npa.il.dao.Iltb01MainDAO;
import tw.gov.npa.il.entity.IL07D;
import tw.gov.npa.il.util.GetDateUtil;

public class MyIltb01MainDAO2 extends Iltb01MainDAO {
	private static final Logger logger = Logger.getLogger(MyIltb01MainDAO2.class);

	public static final int MAX_RESULT = 30000;

	private GetDateUtil getDateUtil = new GetDateUtil();

	public void tryToCloseSession() {
		try {
			HibernateSessionFactory.getSession().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getCountByQuery(String whereCondition) {
		int cnt = 0;
		try {
			StringBuffer sqlStr = new StringBuffer();
			sqlStr.append("SELECT count(*) as cnt from ILTB_01_MAIN");
			if (whereCondition != null && whereCondition.length() > 0) {
				sqlStr.append(" WHERE ");
				sqlStr.append(whereCondition);
			}
			System.out.println("sqlStr=" + sqlStr);
			SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
			q.addScalar("cnt", (Type) Hibernate.INTEGER);
			cnt = ((Integer) q.list().get(0)).intValue();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tryToCloseSession();
		}
		return cnt;
	}

	public List<Iltb01Main> getIL02C01U02Q(String[] ilPstArr, String ilZipCode, String txtBEGIN_DT, String txtBEGIN_DF,
			String ilPstext, String[] ilArccsArr) {
		List<Iltb01Main> list = new ArrayList<Iltb01Main>();
		try {
			StringBuffer sqlStr = new StringBuffer();
			sqlStr.append("SELECT * FROM ILTB_01_MAIN");
			sqlStr.append(" WHERE IL_ARPZONE='" + ilZipCode + "'");
			if (ilPstArr != null) {
				sqlStr.append(" AND(");
				for (int i = 0; i < ilPstArr.length; i++) {
					if (i == 0) {
						sqlStr.append("IL_PHQ='" + ilPstArr[i] + "'");
					} else {
						sqlStr.append(" OR IL_PHQ='" + ilPstArr[i] + "'");
					}
				}
				sqlStr.append(")");
			}
			sqlStr.append(" AND IL_APYDT>= '2010-01-01 00:00:00'");
			sqlStr.append(" AND IL_APYDT<= '2013-12-31 00:00:00'");
			if (!"".equals(ilPstext) && ilPstext != null)
				sqlStr.append(" AND IL_PSTEXT='" + ilPstext + "'");
			if (!"".equals(ilArccsArr) && ilArccsArr != null)
				if (ilArccsArr.length == 2) {
					sqlStr.append(" AND IL_ARCCS in ('0','1')");
				} else {
					for (String ilArccs : ilArccsArr) {
						if (ilArccs.equals(Integer.valueOf(0))) {
							sqlStr.append(" AND IL_ARCCS in ('0')");
						} else if (ilArccs.equals(Integer.valueOf(1))) {
							sqlStr.append(" AND IL_ARCCS in ('1')");
						}
					}
				}
			sqlStr.append(" ORDER BY IL_ARADDR");
			SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
			q.addEntity(Iltb01Main.class);
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tryToCloseSession();
		}
		return list;
	}

	public List<IL03A01Q02Bean> getIL03A01Q02A(String ilMicro, String ilRepmdc, String ilRepmdcNic) {
		List<IL03A01Q02Bean> list = new ArrayList<IL03A01Q02Bean>();
		try {
			StringBuffer sqlStr = new StringBuffer();
			sqlStr.append(
					"SELECT a.IL_ARCID, a.IL_PSPT, a.IL_ENM, a.IL_NTCD, a.IL_BTHDT, b.IL_NTNM FROM ILTB_01_MAIN a, ILTB_15_COUNTRY_CODE b");
			sqlStr.append(" WHERE a.IL_NTCD = b.IL_NTCD");
			if (!"".equals(ilMicro) || ilMicro == null)
				sqlStr.append(" AND a.IL_MICRO='" + ilMicro + "'");
			if (!"".equals(ilRepmdc) || ilRepmdc == null)
				sqlStr.append(" AND a.IL_REPMDC = '" + ilRepmdc + "'");
			if (!"".equals(ilRepmdcNic) || ilRepmdcNic == null)
				sqlStr.append(" AND a.IL_REPMDC_NIC = '" + ilRepmdcNic + "'");
			System.out.println("sqlStr=" + sqlStr);
			SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
			q.addScalar("IL_ARCID", (Type) Hibernate.INTEGER);
			q.addScalar("IL_PSPT", (Type) Hibernate.STRING);
			q.addScalar("IL_ENM", (Type) Hibernate.STRING);
			q.addScalar("IL_NTCD", (Type) Hibernate.STRING);
			q.addScalar("IL_BTHDT", (Type) Hibernate.STRING);
			q.addScalar("IL_NTNM", (Type) Hibernate.STRING);
			List<Object[]> objList = q.list();
			if (objList.size() > 0)
				for (int i = 0; i < objList.size(); i++) {
					IL03A01Q02Bean bean = new IL03A01Q02Bean();
					int IL_ARCID = 0;
					String IL_PSPT = null;
					String IL_ENM = null;
					String IL_NTCD = null;
					String IL_BTHDT = null;
					String IL_NTNM = null;
					Object[] objArr = objList.get(i);
					if (!"".equals(objArr[0]) && objArr[0] != null)
						IL_ARCID = ((Integer) objArr[0]).intValue();
					if (!"".equals(objArr[1]) && objArr[1] != null)
						IL_PSPT = (String) objArr[1];
					if (!"".equals(objArr[2]) && objArr[2] != null)
						IL_ENM = (String) objArr[2];
					if (!"".equals(objArr[3]) && objArr[3] != null)
						IL_NTCD = (String) objArr[3];
					if (!"".equals(objArr[4]) && objArr[4] != null)
						IL_BTHDT = (String) objArr[4];
					if (!"".equals(objArr[5]) && objArr[5] != null)
						IL_NTNM = (String) objArr[5];
					bean.setId(i + 1);
					bean.setIlArcid(IL_ARCID);
					bean.setIlBthdt(IL_BTHDT);
					bean.setIlEnm(IL_ENM);
					bean.setIlNtcd(IL_NTCD);
					bean.setIlNTNM(IL_NTNM);
					bean.setIlPspt(IL_PSPT);
					list.add(i, bean);
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tryToCloseSession();
		}
		return list;
	}

	public List<IL03A01Q02Bean> getIL03A01Q02(String ilArcno, String ilPspt, String ilEnm, String ilCnm, String ilOfnm,
			String[] ilPhqArr, String ilJbpmdt, String ilJbpmdc, String txtBthdFrom, String txtBthdTo, String ilRepmdc,
			String ilRepmdcNic, String ilMicro, String SRCHST, String PSTEXT, String SEX, String UV, String OP_LIST,
			String NT_LIST, String ARCST_LIST, String EDU_LIST, String MST, String FBDRSN, String txtAPY_FROM,
			String txtAPY_TO, String FRCEXIT, String txtARC_FROM, String txtARC_TO, String txtREAPY_FROM,
			String txtREAPY_TO, String txtMISS_FROM, String txtMISS_TO, String txtSBMT_FROM, String txtSBMT_TO,
			String FNDDID, String txtFIND_FROM, String txtFIND_TO, String txtIN_FROM, String txtIN_TO, String MANTYPE,
			String txtEXIT_FROM, String txtEXIT_TO, String chkILARCNO, String chkILPSPT, String chkILENM, String chkNT,
			String chkLBLBTHDTFM, String chkILCNM, String chkARC_FROM, String chkSEX, String chkOP, String chkARCST) {
		List<IL03A01Q02Bean> list = new ArrayList<IL03A01Q02Bean>();
		try {
			StringBuffer sqlStr = new StringBuffer();
//			sqlStr.append("SELECT a.IL_ARCID, a.IL_PSPT, a.IL_ENM, a.IL_NTCD, a.IL_BTHDT, b.IL_NTNM FROM ILTB_01_MAIN a, ILTB_15_COUNTRY_CODE b");
			sqlStr.append("SELECT a.IL_ARCID, ");
			if ("1".equals(chkILARCNO)) // 外來人口證號
				sqlStr.append("a.IL_ARCNO, ");
			if ("1".equals(chkILPSPT)) // 護照號碼
				sqlStr.append("a.IL_PSPT, ");
			if ("1".equals(chkILENM)) // 英文姓名
				sqlStr.append("a.IL_ENM, ");
			if ("1".equals(chkNT)) // 國籍
				sqlStr.append("a.IL_NTCD, ");
			if ("1".equals(chkLBLBTHDTFM)) // 出生日期
				sqlStr.append("a.IL_BTHDT, ");

//			a.IL_ARCID, a.IL_PSPT, a.IL_ENM, a.IL_NTCD, a.IL_BTHDT, b.IL_NTNM FROM ILTB_01_MAIN a, ILTB_15_COUNTRY_CODE b");
			sqlStr.append(" b.IL_NTNM FROM ILTB_01_MAIN a, ILTB_15_COUNTRY_CODE b WHERE a.IL_NTCD = b.IL_NTCD");
			if (!"".equals(ilArcno) || ilArcno == null)
				sqlStr.append(" AND a.IL_ARCNO = '" + ilArcno + "'");
			if (!"".equals(ilPspt) || ilPspt == null)
				sqlStr.append(" AND a.IL_PSPT = '" + ilPspt + "'");
			if (!"".equals(ilEnm) || ilEnm == null)
				sqlStr.append(" AND a.IL_ENM like '" + ilEnm + "%'");
			if (!"".equals(ilCnm) || ilCnm == null)
				sqlStr.append(" AND a.IL_CNM = '" + ilCnm + "'");
			if (!"".equals(ilOfnm) || ilOfnm == null)
				sqlStr.append(" AND a.IL_OFNM = '" + ilOfnm + "'");

			if (!"".equals(txtBthdFrom) || txtBthdFrom == null) {
				sqlStr.append(" AND a.IL_BTHDT >= '" + this.getDateUtil.getNoSpiltDate(txtBthdFrom) + "'");
			}
			if (!"".equals(txtBthdTo) || txtBthdTo == null) {
				sqlStr.append(" AND a.IL_BTHDT <= '" + this.getDateUtil.getNoSpiltDate(txtBthdTo) + "'");
			}
			if (!"".equals(ilRepmdc) || ilRepmdc == null)
				sqlStr.append(" AND a.IL_REPMDC = '" + ilRepmdc + "'");
			if (!"".equals(ilRepmdcNic) || ilRepmdcNic == null)
				sqlStr.append(" AND a.IL_REPMDC_NIC = '" + ilRepmdcNic + "'");
			if (!"".equals(ilMicro) || ilMicro == null)
				sqlStr.append(" AND a.IL_MICRO='" + ilMicro + "'");
			if (ilPhqArr != null) {
				sqlStr.append(" AND(");
				for (int i = 0; i < ilPhqArr.length; i++) {
					if (i == 0) {
						sqlStr.append("IL_PHQ='" + ilPhqArr[i] + "'");
					} else {
						sqlStr.append(" OR IL_PHQ='" + ilPhqArr[i] + "'");
					}
				}
				sqlStr.append(")");
			}
			if (!"".equals(ilJbpmdt) || ilJbpmdt == null)
				sqlStr.append(" AND a.IL_JBPMDT ='" + ilJbpmdt + "'");
			if (!"".equals(ilJbpmdc) || ilJbpmdc == null)
				sqlStr.append(" AND a.IL_JBPMDC ='" + ilJbpmdc + "'");
			if (!"".equals(SRCHST) || SRCHST == null)
				sqlStr.append(" AND a.IL_SRCHST ='" + SRCHST + "'");
			if (!"".equals(PSTEXT) || PSTEXT == null)
				sqlStr.append(" AND a.IL_PSTEXT ='" + PSTEXT + "'");
			if (!"".equals(SEX) || SEX == null)
				sqlStr.append(" AND a.IL_SEX ='" + SEX + "'");
			if (!"".equals(UV) || UV == null)
				sqlStr.append(" AND a.IL_OFCD ='" + UV + "'");
			if (!"".equals(OP_LIST) || OP_LIST == null)
				sqlStr.append("AND a.IL_JBCD in (").append(OP_LIST).append(") ");
			if (!"".equals(NT_LIST) || NT_LIST == null)
				sqlStr.append("AND a.IL_NTCD in (").append(NT_LIST).append(") ");
			if (!"".equals(ARCST_LIST) || ARCST_LIST == null)
				sqlStr.append("AND a.IL_ARCST in (").append(ARCST_LIST).append(") ");
			if (!"".equals(EDU_LIST) || EDU_LIST == null)
				sqlStr.append("AND a.IL_EDU in (").append(EDU_LIST).append(") ");
			if (!"".equals(MST) || MST == null)
				sqlStr.append(" AND a.IL_MST ='" + MST + "'");
			if (!"".equals(FBDRSN) || FBDRSN == null)
				sqlStr.append(" AND a.IL_FBDRSN ='" + FBDRSN + "'");
			if (!"".equals(FRCEXIT) || FRCEXIT == null)
				sqlStr.append(" AND a.IL_FRCEXIT ='" + FRCEXIT + "'");
			if (!"".equals(txtAPY_FROM) || txtAPY_FROM == null)
				sqlStr.append("AND a.IL_APYDT >= '").append(this.getDateUtil.getSepSpiltDateStart(txtAPY_FROM) + "'");
			if (!"".equals(txtAPY_TO) || txtAPY_TO == null)
				sqlStr.append("AND a.IL_APYDT <= '").append(this.getDateUtil.getSepSpiltDateStart(txtAPY_TO) + "'");
			if (!"".equals(txtARC_FROM) || txtARC_FROM == null)
				sqlStr.append("AND a.IL_ARCTO >= '").append(this.getDateUtil.getSepSpiltDateStart(txtARC_FROM) + "'");
			if (!"".equals(txtARC_TO) || txtARC_TO == null)
				sqlStr.append("AND a.IL_ARCTO <= '").append(this.getDateUtil.getSepSpiltDateStart(txtARC_TO) + "'");
			if (!"".equals(txtREAPY_FROM) || txtREAPY_FROM == null)
				sqlStr.append("AND a.IL_REAPYDT >= '")
						.append(this.getDateUtil.getSepSpiltDateStart(txtREAPY_FROM) + "'");
			if (!"".equals(txtREAPY_TO) || txtREAPY_TO == null)
				sqlStr.append("AND a.IL_REAPYDT <= '").append(this.getDateUtil.getSepSpiltDateStart(txtREAPY_TO) + "'");
			if (!"".equals(txtMISS_FROM) || txtMISS_FROM == null)
				sqlStr.append("AND a.IL_MISSDT >= '").append(this.getDateUtil.getSepSpiltDateStart(txtMISS_FROM) + "'");
			if (!"".equals(txtMISS_TO) || txtMISS_TO == null)
				sqlStr.append("AND a.IL_MISSDT <= '").append(this.getDateUtil.getSepSpiltDateStart(txtMISS_TO) + "'");
			if (!"".equals(txtSBMT_FROM) || txtSBMT_FROM == null)
				sqlStr.append("AND a.IL_SBMTDT >= '").append(this.getDateUtil.getSepSpiltDateStart(txtSBMT_FROM) + "'");
			if (!"".equals(txtSBMT_TO) || txtSBMT_TO == null)
				sqlStr.append("AND a.IL_SBMTDT <= '").append(this.getDateUtil.getSepSpiltDateStart(txtSBMT_TO) + "'");

			if (!"".equals(txtFIND_FROM) || txtFIND_FROM == null)
				sqlStr.append("AND a.IL_FNDDT >= '").append(this.getDateUtil.getSepSpiltDateStart(txtFIND_FROM) + "'");
			if (!"".equals(txtFIND_TO) || txtFIND_TO == null)
				sqlStr.append("AND a.IL_FNDDT <= '").append(this.getDateUtil.getSepSpiltDateStart(txtFIND_TO) + "'");
			if (!"".equals(txtIN_FROM) || txtIN_FROM == null)
				sqlStr.append("AND a.IL_INDT >= '").append(this.getDateUtil.getSepSpiltDateStart(txtIN_FROM) + "'");
			if (!"".equals(txtIN_TO) || txtIN_TO == null)
				sqlStr.append("AND a.IL_INDT <= '").append(this.getDateUtil.getSepSpiltDateStart(txtIN_TO) + "'");
			if (!"".equals(txtEXIT_FROM) || txtEXIT_FROM == null)
				sqlStr.append("AND a.IL_EXDT >= '").append(this.getDateUtil.getSepSpiltDateStart(txtEXIT_FROM) + "'");
			if (!"".equals(txtEXIT_TO) || txtEXIT_TO == null)
				sqlStr.append("AND a.IL_EXDT <= '").append(this.getDateUtil.getSepSpiltDateStart(txtEXIT_TO) + "'");

			if (!"".equals(FNDDID) || FNDDID == null)
				sqlStr.append(" AND a.IL_FNDDID = '" + FNDDID + "'");

			Log.info("sqlStr=" + sqlStr);
			SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
			q.addScalar("IL_ARCID", (Type) Hibernate.INTEGER);
			q.addScalar("IL_PSPT", (Type) Hibernate.STRING);
			q.addScalar("IL_ENM", (Type) Hibernate.STRING);
			q.addScalar("IL_NTCD", (Type) Hibernate.STRING);
			q.addScalar("IL_BTHDT", (Type) Hibernate.STRING);
			q.addScalar("IL_NTNM", (Type) Hibernate.STRING);
			List<Object[]> objList = q.list();
			if (objList.size() > 0)
				for (int i = 0; i < objList.size(); i++) {
					IL03A01Q02Bean bean = new IL03A01Q02Bean();
					int IL_ARCID = 0;
					String IL_PSPT = null;
					String IL_ENM = null;
					String IL_NTCD = null;
					String IL_BTHDT = null;
					String IL_NTNM = null;
					Object[] objArr = objList.get(i);
					if (!"".equals(objArr[0]) && objArr[0] != null)
						IL_ARCID = ((Integer) objArr[0]).intValue();
					if (!"".equals(objArr[1]) && objArr[1] != null)
						IL_PSPT = (String) objArr[1];
					if (!"".equals(objArr[2]) && objArr[2] != null)
						IL_ENM = (String) objArr[2];
					if (!"".equals(objArr[3]) && objArr[3] != null)
						IL_NTCD = (String) objArr[3];
					if (!"".equals(objArr[4]) && objArr[4] != null)
						IL_BTHDT = (String) objArr[4];
					if (!"".equals(objArr[5]) && objArr[5] != null)
						IL_NTNM = (String) objArr[5];
					bean.setId(i + 1);
					bean.setIlArcid(IL_ARCID);
					bean.setIlBthdt(IL_BTHDT);
					bean.setIlEnm(IL_ENM);
					bean.setIlNtcd(IL_NTCD);
					bean.setIlNTNM(IL_NTNM);
					bean.setIlPspt(IL_PSPT);
					list.add(i, bean);
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tryToCloseSession();
		}
		return list;
	}

	public List<IL03A01Q02Bean> getIL03A01Q02ToSQL(IL03A01Query02Bean bean, String[] ilPhqArr, List<IL07D> srchstList) {
		List<IL03A01Q02Bean> list = new ArrayList<IL03A01Q02Bean>();
		try {
			StringBuffer sqlStr = new StringBuffer();
			sqlStr.append(
					"SELECT a.*, b.IL_NTNM, c.IL_MANTYPE FROM ILTB_01_MAIN a LEFT JOIN ILTB_15_COUNTRY_CODE b ON  a.IL_NTCD = b.IL_NTCD LEFT JOIN ILTB_04_IN_RECORD c ON a.IL_ARCID = c.IL_ARCID  WHERE 1=1  ");
			if (!"".equals(bean.getIlArcno()) || bean.getIlArcno() == null) {
				String[] arcno = bean.getIlArcno().split(",");
				sqlStr.append(" AND(");
				for (int i = 0; i < arcno.length; i++) {
					if (i == 0) {
						sqlStr.append("a.IL_ARCNO='" + arcno[i].trim() + "'");
					} else {
						sqlStr.append(" OR a.IL_ARCNO='" + arcno[i].trim() + "'");
					}

					sqlStr.append(" OR a.IL_OLDARCNO='" + arcno[i].trim() + "'");
				}
				sqlStr.append(")");
			}
			
			if (!"".equals(bean.getIlPspt()) || bean.getIlPspt() == null) {
				String[] pspt = bean.getIlPspt().split(",");
				sqlStr.append(" AND(");
				for(int i = 0 ; i < pspt.length ; i++) {
					if (i == 0) {
						sqlStr.append("a.IL_PSPT='" + pspt[i].trim() + "'");
					} else {
						sqlStr.append(" OR a.IL_PSPT='" + pspt[i].trim() + "'");
					}
				}
				sqlStr.append(")");
			}
			if (!"".equals(bean.getIlEnm()) || bean.getIlEnm() == null)
				sqlStr.append(" AND a.IL_ENM like '" + bean.getIlEnm() + "%'");
			if (!"".equals(bean.getIlCnm()) || bean.getIlCnm() == null)
				sqlStr.append(" AND a.IL_CNM = '" + bean.getIlCnm() + "'");
			if (!"".equals(bean.getIlOfnm()) || bean.getIlOfnm() == null)
				sqlStr.append(" AND a.IL_OFNM = '" + bean.getIlOfnm() + "'");
			if (!"".equals(bean.getIlBthdt()) || bean.getIlBthdt() == null) {
				sqlStr.append(" AND a.IL_BTHDT = '" + this.getDateUtil.getNoSpiltDate(bean.getIlBthdt()) + "'");
			}
			if (!"".equals(bean.getIlBthdtFrom()) || bean.getIlBthdtFrom() == null) {
				sqlStr.append(" AND a.IL_BTHDT >= '" + this.getDateUtil.getNoSpiltDate(bean.getIlBthdtFrom()) + "'");
			}
			if (!"".equals(bean.getIlBthdtTo()) || bean.getIlBthdtTo() == null) {
				sqlStr.append(" AND a.IL_BTHDT <= '" + this.getDateUtil.getNoSpiltDate(bean.getIlBthdtTo()) + "'");
			}
			if (!"".equals(bean.getIlRepmdc()) || bean.getIlRepmdc() == null)
				sqlStr.append(" AND a.IL_REPMDC = '" + bean.getIlRepmdc() + "'");
			if (!"".equals(bean.getIlRepmdcNic()) || bean.getIlRepmdcNic() == null)
				sqlStr.append(" AND a.IL_REPMDC_NIC = '" + bean.getIlRepmdcNic() + "'");
			if (!"".equals(bean.getIlMicro()) || bean.getIlMicro() == null)
				sqlStr.append(" AND a.IL_MICRO='" + bean.getIlMicro() + "'");
			if (ilPhqArr != null) {
				sqlStr.append(" AND(");
				for (int i = 0; i < ilPhqArr.length; i++) {
					if (i == 0) {
						sqlStr.append("IL_PHQ='" + ilPhqArr[i] + "'");
					} else {
						sqlStr.append(" OR IL_PHQ='" + ilPhqArr[i] + "'");
					}
				}
				sqlStr.append(")");
			}
			if (!"".equals(bean.getIlJbpmdt()) || bean.getIlJbpmdt() == null)
				sqlStr.append(" AND a.IL_JBPMDT ='" + bean.getIlJbpmdt() + "'");
			if (!"".equals(bean.getIlJbpmdc()) || bean.getIlJbpmdc() == null)
				sqlStr.append(" AND a.IL_JBPMDC ='" + bean.getIlJbpmdc() + "'");
			if (!"".equals(bean.getIlSrchst()) || bean.getIlSrchst() == null)
				sqlStr.append(" AND a.IL_SRCHST ='" + bean.getIlSrchst() + "'");
			if (!"".equals(bean.getIlPstext()) || bean.getIlPstext() == null)
				sqlStr.append(" AND a.IL_PSTEXT ='" + bean.getIlPstext() + "'");
			if (!"".equals(bean.getIlSex()) || bean.getIlSex() == null)
				sqlStr.append(" AND a.IL_SEX ='" + bean.getIlSex() + "'");
			if (!"".equals(bean.getIlOfcd()) || bean.getIlOfcd() == null)
				sqlStr.append(" AND a.IL_OFCD ='" + bean.getIlOfcd() + "'");
			if (!"".equals(bean.getIlJbcd()) || bean.getIlJbcd() == null)
				sqlStr.append("AND a.IL_JBCD in (").append(bean.getIlJbcd()).append(") ");
			if (!"".equals(bean.getIlNtcd()) || bean.getIlNtcd() == null)
				sqlStr.append("AND a.IL_NTCD in (").append(bean.getIlNtcd()).append(") ");
			if (!"".equals(bean.getIlArcst()) || bean.getIlArcst() == null)
				sqlStr.append("AND a.IL_ARCST in (").append(bean.getIlArcst()).append(") ");
			if (!"".equals(bean.getIlEdu()) || bean.getIlEdu() == null)
				sqlStr.append("AND a.IL_EDU in (").append(bean.getIlEdu()).append(") ");
			if (!"".equals(bean.getIlMst()) || bean.getIlMst() == null)
				sqlStr.append(" AND a.IL_MST ='" + bean.getIlMst() + "'");
			if (!"".equals(bean.getIlFbdrsn()) || bean.getIlFbdrsn() == null)
				sqlStr.append(" AND a.IL_FBDRSN ='" + bean.getIlFbdrsn() + "'");
			if (!"".equals(bean.getIlFrcexit()) || bean.getIlFrcexit() == null)
				sqlStr.append(" AND a.IL_FRCEXIT ='" + bean.getIlFrcexit() + "'");
			if (!"".equals(bean.getIlApydtFrom()) || bean.getIlApydtFrom() == null)
				sqlStr.append("AND a.IL_APYDT >= '")
						.append(this.getDateUtil.getSepSpiltDateStart(bean.getIlApydtFrom()) + "'");
			if (!"".equals(bean.getIlApydtTo()) || bean.getIlApydtTo() == null)
				sqlStr.append("AND a.IL_APYDT <= '")
						.append(this.getDateUtil.getSepSpiltDateStart(bean.getIlApydtTo()) + "'");
			if (!"".equals(bean.getIlArcfm()) || bean.getIlArcfm() == null)
				sqlStr.append("AND a.IL_ARCTO >= '")
						.append(this.getDateUtil.getSepSpiltDateStart(bean.getIlArcfm()) + "'");
			if (!"".equals(bean.getIlArcto()) || bean.getIlArcto() == null)
				sqlStr.append("AND a.IL_ARCTO <= '")
						.append(this.getDateUtil.getSepSpiltDateStart(bean.getIlArcto()) + "'");
			if (!"".equals(bean.getIlReapydtFrom()) || bean.getIlReapydtFrom() == null)
				sqlStr.append("AND a.IL_REAPYDT >= '")
						.append(this.getDateUtil.getSepSpiltDateStart(bean.getIlReapydtFrom()) + "'");
			if (!"".equals(bean.getIlReapydtTo()) || bean.getIlReapydtTo() == null)
				sqlStr.append("AND a.IL_REAPYDT <= '")
						.append(this.getDateUtil.getSepSpiltDateStart(bean.getIlReapydtTo()) + "'");
			if (!"".equals(bean.getIlMissdtFrom()) || bean.getIlMissdtFrom() == null)
				sqlStr.append("AND a.IL_MISSDT >= '")
						.append(this.getDateUtil.getSepSpiltDateStart(bean.getIlMissdtFrom()) + "'");
			if (!"".equals(bean.getIlMissdtTo()) || bean.getIlMissdtTo() == null)
				sqlStr.append("AND a.IL_MISSDT <= '")
						.append(this.getDateUtil.getSepSpiltDateStart(bean.getIlMissdtTo()) + "'");
			if (!"".equals(bean.getIlSbmtdtFrom()) || bean.getIlSbmtdtFrom() == null)
				sqlStr.append("AND a.IL_SBMTDT >= '")
						.append(this.getDateUtil.getSepSpiltDateStart(bean.getIlSbmtdtFrom()) + "'");
			if (!"".equals(bean.getIlSbmtdtTo()) || bean.getIlSbmtdtTo() == null)
				sqlStr.append("AND a.IL_SBMTDT <= '")
						.append(this.getDateUtil.getSepSpiltDateStart(bean.getIlSbmtdtTo()) + "'");
			if (!"".equals(bean.getIlFinddtFrom()) || bean.getIlFinddtFrom() == null)
				sqlStr.append("AND a.IL_FNDDT >= '")
						.append(this.getDateUtil.getSepSpiltDateStart(bean.getIlFinddtFrom()) + "'");
			if (!"".equals(bean.getIlFinddtTo()) || bean.getIlFinddtTo() == null)
				sqlStr.append("AND a.IL_FNDDT <= '")
						.append(this.getDateUtil.getSepSpiltDateStart(bean.getIlFinddtTo()) + "'");
			if (!"".equals(bean.getIlIndtFrom()) || bean.getIlIndtFrom() == null)
				sqlStr.append("AND a.IL_INDT >= '")
						.append(this.getDateUtil.getSepSpiltDateStart(bean.getIlIndtFrom()) + "'");
			if (!"".equals(bean.getIlIndtTo()) || bean.getIlIndtTo() == null)
				sqlStr.append("AND a.IL_INDT <= '")
						.append(this.getDateUtil.getSepSpiltDateStart(bean.getIlIndtTo()) + "'");
			if (!"".equals(bean.getIlExdtFrom()) || bean.getIlExdtFrom() == null)
				sqlStr.append("AND a.IL_EXDT >= '")
						.append(this.getDateUtil.getSepSpiltDateStart(bean.getIlExdtFrom()) + "'");
			if (!"".equals(bean.getIlExdtTo()) || bean.getIlExdtTo() == null)
				sqlStr.append("AND a.IL_EXDT <= '")
						.append(this.getDateUtil.getSepSpiltDateStart(bean.getIlExdtTo()) + "'");
			if (!"".equals(bean.getIlFnddid()) || bean.getIlFnddid() == null)
				sqlStr.append(" AND a.IL_FNDDID = '" + bean.getIlFnddid() + "'");
			if (!"0".equals(bean.getIlMANTYPE()) || bean.getIlMANTYPE() == null)
				sqlStr.append(" AND c.IL_MANTYPE = '" + bean.getIlMANTYPE() + "'");

			System.out.println("sqlStr=" + sqlStr);
			SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
			q.addScalar("IL_ARCID", (Type) Hibernate.INTEGER);
			q.addScalar("IL_ARCTP", (Type) Hibernate.STRING);
			q.addScalar("IL_ARCCS", (Type) Hibernate.STRING);
			q.addScalar("IL_ENM", (Type) Hibernate.STRING);
			q.addScalar("IL_CNM", (Type) Hibernate.STRING);
			q.addScalar("IL_SEX", (Type) Hibernate.STRING);
			q.addScalar("IL_BTHDT", (Type) Hibernate.STRING);
			q.addScalar("IL_NTCD", (Type) Hibernate.STRING);
			q.addScalar("IL_PSPT", (Type) Hibernate.STRING);
			q.addScalar("IL_PSDT", (Type) Hibernate.STRING);
			q.addScalar("IL_MST", (Type) Hibernate.STRING);
			q.addScalar("IL_EDU", (Type) Hibernate.STRING);
			q.addScalar("IL_INDT", (Type) Hibernate.STRING);
			q.addScalar("IL_EXDT", (Type) Hibernate.STRING);
			q.addScalar("IL_ARCRSN", (Type) Hibernate.STRING);
			q.addScalar("IL_ARCST", (Type) Hibernate.STRING);
			q.addScalar("IL_JBCD", (Type) Hibernate.STRING);
			q.addScalar("IL_JBPSN", (Type) Hibernate.STRING);
			q.addScalar("IL_OFCD", (Type) Hibernate.STRING);
			q.addScalar("IL_OFNM", (Type) Hibernate.STRING);
			q.addScalar("IL_OFTEL", (Type) Hibernate.STRING);
			q.addScalar("IL_OFNMBF", (Type) Hibernate.STRING);
			q.addScalar("IL_JBPZONE", (Type) Hibernate.STRING);
			q.addScalar("IL_JBADDR", (Type) Hibernate.STRING);
			q.addScalar("IL_JBTEL", (Type) Hibernate.STRING);
			q.addScalar("IL_ARPZONE", (Type) Hibernate.STRING);
			q.addScalar("IL_ARADDR", (Type) Hibernate.STRING);
			q.addScalar("IL_ARTEL", (Type) Hibernate.STRING);
			q.addScalar("IL_AGNCO", (Type) Hibernate.STRING);
			q.addScalar("IL_AGNTEL", (Type) Hibernate.STRING);
			q.addScalar("IL_JBPMCD", (Type) Hibernate.STRING);
			q.addScalar("IL_JBPMDC", (Type) Hibernate.STRING);
			q.addScalar("IL_JBPMDT", (Type) Hibernate.STRING);
			q.addScalar("IL_JBPMFM", (Type) Hibernate.STRING);
			q.addScalar("IL_JBPMTO", (Type) Hibernate.STRING);
			q.addScalar("IL_MICRO", (Type) Hibernate.STRING);
			q.addScalar("IL_APYDT", (Type) Hibernate.STRING);
			q.addScalar("IL_ARCRCP", (Type) Hibernate.STRING);
			q.addScalar("IL_ARCNO", (Type) Hibernate.STRING);
			q.addScalar("IL_ARCFM", (Type) Hibernate.STRING);
			q.addScalar("IL_ARCTO", (Type) Hibernate.STRING);
			q.addScalar("IL_PST", (Type) Hibernate.STRING);
			q.addScalar("IL_PHQ", (Type) Hibernate.STRING);
			q.addScalar("IL_PSTEXT", (Type) Hibernate.STRING);
			q.addScalar("IL_REMRK", (Type) Hibernate.STRING);
			q.addScalar("IL_ARCISU", (Type) Hibernate.STRING);
			q.addScalar("IL_FRSHP", (Type) Hibernate.STRING);
			q.addScalar("IL_FNM", (Type) Hibernate.STRING);
			q.addScalar("IL_FPID", (Type) Hibernate.STRING);
			q.addScalar("IL_FNTCD", (Type) Hibernate.STRING);
			q.addScalar("IL_FRCEXIT", (Type) Hibernate.STRING);
			q.addScalar("IL_REAPYDT", (Type) Hibernate.STRING);
			q.addScalar("IL_RETP", (Type) Hibernate.STRING);
			q.addScalar("IL_REPMDC", (Type) Hibernate.STRING);
			q.addScalar("IL_REPMDT", (Type) Hibernate.STRING);
			q.addScalar("IL_RRNOTE", (Type) Hibernate.STRING);
			q.addScalar("IL_MRKCS", (Type) Hibernate.STRING);
			q.addScalar("IL_FBDRSN", (Type) Hibernate.STRING);
			q.addScalar("IL_MRKDT", (Type) Hibernate.STRING);
			q.addScalar("IL_MRKDC", (Type) Hibernate.STRING);
			q.addScalar("IL_SBMTTP", (Type) Hibernate.STRING);
			q.addScalar("IL_MISSDT", (Type) Hibernate.STRING);
			q.addScalar("IL_SBMTDT", (Type) Hibernate.STRING);
			q.addScalar("IL_SRCHST", (Type) Hibernate.STRING);
			q.addScalar("IL_FNDDID", (Type) Hibernate.STRING);
			q.addScalar("IL_FNDDT", (Type) Hibernate.STRING);
			q.addScalar("IL_OLDARC", (Type) Hibernate.STRING);
			q.addScalar("IL_HCST", (Type) Hibernate.STRING);
			q.addScalar("IL_HCCTR", (Type) Hibernate.STRING);
			q.addScalar("IL_LMD", (Type) Hibernate.STRING);
			q.addScalar("IL_FSTAPYDT", (Type) Hibernate.STRING);
			q.addScalar("IL_REPMDC_NIC", (Type) Hibernate.STRING);
			q.addScalar("IL_FORFERE", (Type) Hibernate.STRING);
			q.addScalar("IL_12ARCID", (Type) Hibernate.STRING);
			q.addScalar("IL_NTNM", (Type) Hibernate.STRING);
			q.addScalar("IL_MANTYPE", (Type) Hibernate.STRING);
			q.addScalar("IL_OLDARCNO", (Type) Hibernate.STRING);

			List<Object[]> objList = q.list();
			if (objList.size() > 0)
				for (int i = 0; i < objList.size(); i++) {
					IL03A01Q02Bean iL03A01Q02Bean = new IL03A01Q02Bean();
					int IL_ARCID = 0;

					Object[] objArr = objList.get(i);
					iL03A01Q02Bean.setId(i + 1);
					iL03A01Q02Bean.setIlArcid(
							!"".equals(objArr[0]) && objArr[0] != null ? ((Integer) objArr[0]).intValue() : 0);
					iL03A01Q02Bean.setIlArctp(!"".equals(objArr[1]) && objArr[1] != null ? (String) objArr[1] : "");
					iL03A01Q02Bean.setIlArccs(!"".equals(objArr[2]) && objArr[2] != null ? (String) objArr[2] : "");
					iL03A01Q02Bean.setIlEnm(!"".equals(objArr[3]) && objArr[3] != null ? (String) objArr[3] : "");
					iL03A01Q02Bean.setIlCnm(!"".equals(objArr[4]) && objArr[4] != null ? (String) objArr[4] : "");
					iL03A01Q02Bean.setIlSex(!"".equals(objArr[5]) && objArr[5] != null ? (String) objArr[5] : "");
					iL03A01Q02Bean.setIlBthdt(!"".equals(objArr[6]) && objArr[6] != null ? (String) objArr[6] : "");
					iL03A01Q02Bean.setIlNtcd(!"".equals(objArr[7]) && objArr[7] != null ? (String) objArr[7] : "");
					iL03A01Q02Bean.setIlPspt(!"".equals(objArr[8]) && objArr[8] != null ? (String) objArr[8] : "");
					iL03A01Q02Bean.setIlPsdt(!"".equals(objArr[9]) && objArr[9] != null ? (String) objArr[9] : "");
					iL03A01Q02Bean.setIlMst(!"".equals(objArr[10]) && objArr[10] != null ? (String) objArr[10] : "");
					if(!"".equals(objArr[11]) && objArr[11] != null) {
						switch ((String)objArr[11]) {
						case "00":
							iL03A01Q02Bean.setIlEdu("");
							break;
						case "01":
							iL03A01Q02Bean.setIlEdu("博士");
							break;
						case "02":
							iL03A01Q02Bean.setIlEdu("碩士");
							break;
						case "03":
							iL03A01Q02Bean.setIlEdu("大學畢業");
							break;
						case "04":
							iL03A01Q02Bean.setIlEdu("大學肄業");
							break;
						case "05":
							iL03A01Q02Bean.setIlEdu("專科畢業");
							break;
						case "06":
							iL03A01Q02Bean.setIlEdu("專科肄業");
							break;
						case "07":
							iL03A01Q02Bean.setIlEdu("高中畢業");
							break;
						case "08":
							iL03A01Q02Bean.setIlEdu("高中肄業");
							break;
						case "09":
							iL03A01Q02Bean.setIlEdu("初中畢業");
							break;
						case "10":
							iL03A01Q02Bean.setIlEdu("初中肄業");
							break;
						case "11":
							iL03A01Q02Bean.setIlEdu("小學畢業");
							break;
						case "12":
							iL03A01Q02Bean.setIlEdu("小學肄業");
							break;
						case "13":
							iL03A01Q02Bean.setIlEdu("識字");
							break;
						case "14":
							iL03A01Q02Bean.setIlEdu("不識字");
							break;
						case "15":
							iL03A01Q02Bean.setIlEdu("不明");
							break;
						}
					}else {
						iL03A01Q02Bean.setIlEdu("");
					}
					iL03A01Q02Bean.setIlIndt(!"".equals(objArr[12]) && objArr[12] != null ? (String) objArr[12] : "");
					iL03A01Q02Bean.setIlExdt(!"".equals(objArr[13]) && objArr[13] != null ? (String) objArr[13] : "");
					if(!"".equals(objArr[14]) && objArr[14] != null) {
						
						switch ((String)objArr[14]) {
						case "0":
							iL03A01Q02Bean.setIlArcrsn("");
							break;
						case "1":
							iL03A01Q02Bean.setIlArcrsn("依親");
							break;
						case "2":
							iL03A01Q02Bean.setIlArcrsn("就學");
							break;
						case "3":
							iL03A01Q02Bean.setIlArcrsn("應聘");
							break;
						case "4":
							iL03A01Q02Bean.setIlArcrsn("投資");
							break;
						case "5":
							iL03A01Q02Bean.setIlArcrsn("傳教");
							break;
						case "6":
							iL03A01Q02Bean.setIlArcrsn("其他");
							break;
						case "7":
							iL03A01Q02Bean.setIlArcrsn("外勞");
							break;
						case "8":
							iL03A01Q02Bean.setIlArcrsn("永居(連續居留七年)");
							break;
						case "9":
							iL03A01Q02Bean.setIlArcrsn("永居(依親五年配偶)");
							break;
						case "A":
							iL03A01Q02Bean.setIlArcrsn("永居(依親五年子女)");
							break;
						case "B":
							iL03A01Q02Bean.setIlArcrsn("永居(依親居住十五年)");
							break;
						case "C":
							iL03A01Q02Bean.setIlArcrsn("永居(依親居住十年)");
							break;
						case "D":
							iL03A01Q02Bean.setIlArcrsn("永居(居住二十年者)");
							break;
						case "E":
							iL03A01Q02Bean.setIlArcrsn("永居(高科技人士)");
							break;
						case "F":
							iL03A01Q02Bean.setIlArcrsn("永居(特殊貢獻者)");
							break;
						case "G":
							iL03A01Q02Bean.setIlArcrsn("永居(其他)");
							break;
						}
					}else {
						iL03A01Q02Bean.setIlArcrsn("");
					}
					if(!"".equals(objArr[15]) && objArr[15] != null) {
						switch ((String)objArr[15]) {
						case "1":
							iL03A01Q02Bean.setIlArcst("改變國籍(原具我國籍者)");
							break;
						case "2":
							iL03A01Q02Bean.setIlArcst("在台");
							break;
						case "3":
							iL03A01Q02Bean.setIlArcst("離台");
							break;
						case "4":
							iL03A01Q02Bean.setIlArcst("死亡");
							break;
						case "5":
							iL03A01Q02Bean.setIlArcst("註銷居留證");
							break;
						case "6":
							iL03A01Q02Bean.setIlArcst("棄原國籍取我國籍");
							break;
						}
					}else {
						iL03A01Q02Bean.setIlArcst("");
					}
					iL03A01Q02Bean.setIlJbcd(!"".equals(objArr[16]) && objArr[16] != null ? (String) objArr[16] : "");
					iL03A01Q02Bean.setIlJbpsn(!"".equals(objArr[17]) && objArr[17] != null ? (String) objArr[17] : "");
					iL03A01Q02Bean.setIlOfcd(!"".equals(objArr[18]) && objArr[18] != null ? (String) objArr[18] : "");
					iL03A01Q02Bean.setIlOfnm(!"".equals(objArr[19]) && objArr[19] != null ? (String) objArr[19] : "");
					iL03A01Q02Bean.setIlOftel(!"".equals(objArr[20]) && objArr[20] != null ? (String) objArr[20] : "");
					iL03A01Q02Bean.setIlOfnmbf(!"".equals(objArr[21]) && objArr[21] != null ? (String) objArr[21] : "");
					iL03A01Q02Bean.setIlJbpzone(!"".equals(objArr[22]) && objArr[22] != null ? (String) objArr[22] : "");
					iL03A01Q02Bean.setIlJbaddr(!"".equals(objArr[23]) && objArr[23] != null ? (String) objArr[23] : "");
					iL03A01Q02Bean.setIlJbtel(!"".equals(objArr[24]) && objArr[24] != null ? (String) objArr[24] : "");
					iL03A01Q02Bean.setIlArpzone(!"".equals(objArr[25]) && objArr[25] != null ? (String) objArr[25] : "");
					iL03A01Q02Bean.setIlAraddr(!"".equals(objArr[26]) && objArr[26] != null ? (String) objArr[26] : "");
					iL03A01Q02Bean.setIlArtel(!"".equals(objArr[27]) && objArr[27] != null ? (String) objArr[27] : "");
					iL03A01Q02Bean.setIlAgnco(!"".equals(objArr[28]) && objArr[28] != null ? (String) objArr[28] : "");
					iL03A01Q02Bean.setIlAgntel(!"".equals(objArr[29]) && objArr[29] != null ? (String) objArr[29] : "");
					if(!"".equals(objArr[30]) && objArr[30] != null) {
						switch ((String)objArr[30]) {
						case "0":
							iL03A01Q02Bean.setIlJbpmcd("");
							break;
						case "1":
							iL03A01Q02Bean.setIlJbpmcd("勞動部");
							break;
						case "2":
							iL03A01Q02Bean.setIlJbpmcd("內政部");
							break;
						case "3":
							iL03A01Q02Bean.setIlJbpmcd("經濟部");
							break;
						case "4":
							iL03A01Q02Bean.setIlJbpmcd("經濟部投審會");
							break;
						case "5":
							iL03A01Q02Bean.setIlJbpmcd("科學園區管理局");
							break;
						case "6":
							iL03A01Q02Bean.setIlJbpmcd("教育部");
							break;
						case "7":
							iL03A01Q02Bean.setIlJbpmcd("交通部");
							break;
						case "8":
							iL03A01Q02Bean.setIlJbpmcd("國防部");
							break;
						case "9":
							iL03A01Q02Bean.setIlJbpmcd("新聞局");
							break;
						case "-":
							iL03A01Q02Bean.setIlJbpmcd("衛生署");
							break;
						case "A":
							iL03A01Q02Bean.setIlJbpmcd("台北市政府");
							break;
						case "B":
							iL03A01Q02Bean.setIlJbpmcd("台中市政府");
							break;
						case "C":
							iL03A01Q02Bean.setIlJbpmcd("基隆市政府");
							break;
						case "D":
							iL03A01Q02Bean.setIlJbpmcd("台南市政府");
							break;
						case "E":
							iL03A01Q02Bean.setIlJbpmcd("高雄市政府");
							break;
						case "F":
							iL03A01Q02Bean.setIlJbpmcd("台北縣政府");
							break;
						case "G":
							iL03A01Q02Bean.setIlJbpmcd("宜蘭縣政府");
							break;
						case "H":
							iL03A01Q02Bean.setIlJbpmcd("桃園縣政府");
							break;
						case "I":
							iL03A01Q02Bean.setIlJbpmcd("嘉義市政府");
							break;
						case "J":
							iL03A01Q02Bean.setIlJbpmcd("新竹縣政府");
							break;
						case "K":
							iL03A01Q02Bean.setIlJbpmcd("苗栗縣政府");
							break;
						case "L":
							iL03A01Q02Bean.setIlJbpmcd("台中縣政府");
							break;
						case "M":
							iL03A01Q02Bean.setIlJbpmcd("南投縣政府");
							break;
						case "N":
							iL03A01Q02Bean.setIlJbpmcd("彰化縣政府");
							break;
						case "O":
							iL03A01Q02Bean.setIlJbpmcd("新竹市政府");
							break;
						case "P":
							iL03A01Q02Bean.setIlJbpmcd("雲林縣政府");
							break;
						case "Q":
							iL03A01Q02Bean.setIlJbpmcd("嘉義縣政府");
							break;
						case "R":
							iL03A01Q02Bean.setIlJbpmcd("台南縣政府");
							break;
						case "S":
							iL03A01Q02Bean.setIlJbpmcd("高雄縣政府");
							break;
						case "T":
							iL03A01Q02Bean.setIlJbpmcd("屏東縣政府");
							break;
						case "U":
							iL03A01Q02Bean.setIlJbpmcd("花蓮縣政府");
							break;
						case "V":
							iL03A01Q02Bean.setIlJbpmcd("台東縣政府");
							break;
						case "W":
							iL03A01Q02Bean.setIlJbpmcd("金門縣政府");
							break;
						case "X":
							iL03A01Q02Bean.setIlJbpmcd("澎湖縣政府");
							break;
						case "Y":
							iL03A01Q02Bean.setIlJbpmcd("連江縣政府");
							break;
						case "Z":
							iL03A01Q02Bean.setIlJbpmcd("其他");
							break;
						}
					}else {
						iL03A01Q02Bean.setIlJbpmcd("");
					}
					
					iL03A01Q02Bean.setIlJbpmdc(!"".equals(objArr[31]) && objArr[31] != null ? (String) objArr[31] : "");
					iL03A01Q02Bean.setIlJbpmdt(!"".equals(objArr[32]) && objArr[32] != null ? (String) objArr[32] : "");
					iL03A01Q02Bean.setIlJbpmfm(!"".equals(objArr[33]) && objArr[33] != null ? (String) objArr[33] : "");
					iL03A01Q02Bean.setIlJbpmto(!"".equals(objArr[34]) && objArr[34] != null ? (String) objArr[34] : "");
					iL03A01Q02Bean.setIlMicro(!"".equals(objArr[35]) && objArr[35] != null ? (String) objArr[35] : "");
					iL03A01Q02Bean.setIlApydt(!"".equals(objArr[36]) && objArr[36] != null ? (String) objArr[36] : "");
					iL03A01Q02Bean.setIlArcrcp(!"".equals(objArr[37]) && objArr[37] != null ? (String) objArr[37] : "");
					iL03A01Q02Bean.setIlArcno(!"".equals(objArr[38]) && objArr[38] != null ? (String) objArr[38] : "");
					iL03A01Q02Bean.setIlArcfm(!"".equals(objArr[39]) && objArr[39] != null ? (String) objArr[39] : "");
					iL03A01Q02Bean.setIlArcto(!"".equals(objArr[40]) && objArr[40] != null ? (String) objArr[40] : "");
					iL03A01Q02Bean.setIlPst(!"".equals(objArr[41]) && objArr[41] != null ? (String) objArr[41] : "");
					iL03A01Q02Bean.setIlPhq(!"".equals(objArr[42]) && objArr[42] != null ? (String) objArr[42] : "");
					iL03A01Q02Bean.setIlPstext(!"".equals(objArr[43]) && objArr[43] != null ? (String) objArr[43] : "");
					iL03A01Q02Bean.setIlRemrk(!"".equals(objArr[44]) && objArr[44] != null ? (String) objArr[44] : "");
					iL03A01Q02Bean.setIlArcisu(!"".equals(objArr[45]) && objArr[45] != null ? (String) objArr[45] : "");
					if(!"".equals(objArr[46]) && objArr[46] != null) {
						switch ((String)objArr[46]) {
						case "00":
							iL03A01Q02Bean.setIlFrshp("");
							break;
						case "01":
							iL03A01Q02Bean.setIlFrshp("夫");
							break;
						case "02":
							iL03A01Q02Bean.setIlFrshp("妻");
							break;
						case "03":
							iL03A01Q02Bean.setIlFrshp("父");
							break;
						case "04":
							iL03A01Q02Bean.setIlFrshp("母");
							break;
						case "05":
							iL03A01Q02Bean.setIlFrshp("子");
							break;
						case "06":
							iL03A01Q02Bean.setIlFrshp("女");
							break;
						case "07":
							iL03A01Q02Bean.setIlFrshp("祖父");
							break;
						case "08":
							iL03A01Q02Bean.setIlFrshp("祖母");
							break;
						case "09":
							iL03A01Q02Bean.setIlFrshp("兄");
							break;
						case "10":
							iL03A01Q02Bean.setIlFrshp("弟");
							break;
						case "11":
							iL03A01Q02Bean.setIlFrshp("姊");
							break;
						case "12":
							iL03A01Q02Bean.setIlFrshp("妹");
							break;
						case "13":
							iL03A01Q02Bean.setIlFrshp("其他");
							break;
						}
					}else {
						iL03A01Q02Bean.setIlFrshp("");
					}
					iL03A01Q02Bean.setIlFnm(!"".equals(objArr[47]) && objArr[47] != null ? (String) objArr[47] : "");
					iL03A01Q02Bean.setIlFpid(!"".equals(objArr[48]) && objArr[48] != null ? (String) objArr[48] : "");
					iL03A01Q02Bean.setIlFntcd(!"".equals(objArr[49]) && objArr[49] != null ? (String) objArr[49] : "");
					iL03A01Q02Bean.setIlFrcexit(!"".equals(objArr[50]) && objArr[50] != null ? (String) objArr[50] : "");
					iL03A01Q02Bean.setIlReapydt(!"".equals(objArr[51]) && objArr[51] != null ? (String) objArr[51] : "");
					if(!"".equals(objArr[52]) && objArr[52] != null) {
						if ("1".equals(iL03A01Q02Bean.getIlRetp())) {
							iL03A01Q02Bean.setIlRetp("單次");
						} else if ("2".equals(iL03A01Q02Bean.getIlRetp())) {
							iL03A01Q02Bean.setIlRetp("多次");
						}
					}else {
						iL03A01Q02Bean.setIlRetp("");
					}
					iL03A01Q02Bean.setIlRepmdc(!"".equals(objArr[53]) && objArr[53] != null ? (String) objArr[53] : "");
					iL03A01Q02Bean.setIlRepmdt(!"".equals(objArr[54]) && objArr[54] != null ? (String) objArr[54] : "");
					iL03A01Q02Bean.setIlRrnote(!"".equals(objArr[55]) && objArr[55] != null ? (String) objArr[55] : "");
					iL03A01Q02Bean.setIlMrkcs(!"".equals(objArr[56]) && objArr[56] != null ? (String) objArr[56] : "");
					if(!"".equals(objArr[57]) && objArr[57] != null) {
						switch ((String)objArr[57]) {
						case "0":
							iL03A01Q02Bean.setIlFbdrsn("");
							break;
						case "1":
							iL03A01Q02Bean.setIlFbdrsn("申請資料係偽(變)造者");
							break;
						case "2":
							iL03A01Q02Bean.setIlFbdrsn("經判處一年以上刑期者");
							break;
						case "3":
							iL03A01Q02Bean.setIlFbdrsn("每年居住未達183天者");
							break;
						case "4":
							iL03A01Q02Bean.setIlFbdrsn("回復或取得我國國籍者");
							break;
						case "5":
							iL03A01Q02Bean.setIlFbdrsn("已取得外僑永久居留證者");
							break;
						case "6":
							iL03A01Q02Bean.setIlFbdrsn("經撤銷聘僱許可並限令出國者");
							break;
						case "7":
							iL03A01Q02Bean.setIlFbdrsn("其他");
							break;
						case "8":
							iL03A01Q02Bean.setIlFbdrsn("休學");
							break;
						case "9":
							iL03A01Q02Bean.setIlFbdrsn("退學");
							break;
						case "A":
							iL03A01Q02Bean.setIlFbdrsn("畢業");
							break;
						case "B":
							iL03A01Q02Bean.setIlFbdrsn("申請資料虛偽或不實");
							break;
						case "C":
							iL03A01Q02Bean.setIlFbdrsn("持用不法取得、偽造或變造之證件");
							break;
						case "D":
							iL03A01Q02Bean.setIlFbdrsn("回復我國籍");
							break;
						case "E":
							iL03A01Q02Bean.setIlFbdrsn("取得我國籍");
							break;
						case "F":
							iL03A01Q02Bean.setIlFbdrsn("兼具我國籍，以國民身分入出國、居留或定居");
							break;
						case "G":
							iL03A01Q02Bean.setIlFbdrsn("受驅逐出國");
							break;
						case "H":
							iL03A01Q02Bean.setIlFbdrsn("經許可定居");
							break;
						case "I":
							iL03A01Q02Bean.setIlFbdrsn("離婚");
							break;
						case "J":
							iL03A01Q02Bean.setIlFbdrsn("離婚配偶喪失子女扶養權");
							break;
						case "K":
							iL03A01Q02Bean.setIlFbdrsn("依親對象居留事由消失者");
							break;
						case "L":
							iL03A01Q02Bean.setIlFbdrsn("當事人主動撤銷");
							break;
						case "M":
							iL03A01Q02Bean.setIlFbdrsn("經撤銷、廢止居留許可(居留原因消失)-中途解約");
							break;
						case "N":
							iL03A01Q02Bean.setIlFbdrsn("經撤銷、廢止居留許可(居留原因消失)-連續三日曠職");
							break;
						case "O":
							iL03A01Q02Bean.setIlFbdrsn("經撤銷、廢止居留許可(居留原因消失)-非法工作");
							break;
						case "P":
							iL03A01Q02Bean.setIlFbdrsn("經撤銷、廢止居留許可(居留原因消失)-健檢不合格");
							break;
						case "Q":
							iL03A01Q02Bean.setIlFbdrsn("經撤銷、廢止居留許可(居留原因消失)-轉換雇主不成功");
							break;
						case "R":
							iL03A01Q02Bean.setIlFbdrsn("經撤銷、廢止居留許可(居留原因消失)-投資");
							break;
						case "S":
							iL03A01Q02Bean.setIlFbdrsn("經撤銷、廢止居留許可(居留原因消失)-傳教");
							break;
						case "T":
							iL03A01Q02Bean.setIlFbdrsn("死亡");
							break;
						}
					}else {
						iL03A01Q02Bean.setIlFbdrsn("");
					}
					iL03A01Q02Bean.setIlMrkdt(!"".equals(objArr[58]) && objArr[58] != null ? (String) objArr[58] : "");
					iL03A01Q02Bean.setIlMrkdc(!"".equals(objArr[59]) && objArr[59] != null ? (String) objArr[59] : "");
					if(!"".equals(objArr[60]) && objArr[60] != null) {
						switch ((String)objArr[60]) {
						case "0":
							iL03A01Q02Bean.setIlSbmttp("");
							break;
						case "1":
							iL03A01Q02Bean.setIlSbmttp("關係人報案");
							break;
						case "2":
							iL03A01Q02Bean.setIlSbmttp("警局主動註記");
							break;
						case "3":
							iL03A01Q02Bean.setIlSbmttp("雇主書面通知");
							break;
						}
					}else {
						iL03A01Q02Bean.setIlSbmttp("");
					}
					iL03A01Q02Bean.setIlMissdt(!"".equals(objArr[61]) && objArr[61] != null ? (String) objArr[61] : "");
					iL03A01Q02Bean.setIlSbmtdt(!"".equals(objArr[62]) && objArr[62] != null ? (String) objArr[62] : "");
					if(!"".equals(objArr[63]) && objArr[63] != null) {
						String srchstnm = (String)objArr[63];
						for(int j = 0; j<srchstList.size(); j++) {
							if(srchstnm.equals(srchstList.get(j).getSRCHST())) {
								iL03A01Q02Bean.setIlSrchst(srchstList.get(j).getSRCHSTNM());
							}
						}
					}else {
						iL03A01Q02Bean.setIlSrchst("無特殊身份");
					}
					iL03A01Q02Bean.setIlFnddid(!"".equals(objArr[64]) && objArr[64] != null ? (String) objArr[64] : "");
					iL03A01Q02Bean.setIlFnddt(!"".equals(objArr[65]) && objArr[65] != null ? (String) objArr[65] : "");
					iL03A01Q02Bean.setIlOldarc(!"".equals(objArr[66]) && objArr[66] != null ? (String) objArr[66] : "");
					iL03A01Q02Bean.setIlHcst(!"".equals(objArr[67]) && objArr[67] != null ? (String) objArr[67] : "");
					iL03A01Q02Bean.setIlHcctr(!"".equals(objArr[68]) && objArr[68] != null ? (String) objArr[68] : "");
					iL03A01Q02Bean.setIlLmd(!"".equals(objArr[69]) && objArr[69] != null ? (String) objArr[69] : "");
					iL03A01Q02Bean.setIlFstapydt(!"".equals(objArr[70]) && objArr[70] != null ? (String) objArr[70] : "");
					iL03A01Q02Bean.setIlRepmdcNic(!"".equals(objArr[71]) && objArr[71] != null ? (String) objArr[71] : "");
					iL03A01Q02Bean.setIlForfere(!"".equals(objArr[72]) && objArr[72] != null ? (String) objArr[72] : "");
					iL03A01Q02Bean.setIl12ArcId(!"".equals(objArr[73]) && objArr[73] != null ? (String) objArr[73] : "");
					iL03A01Q02Bean.setIlNTNM(!"".equals(objArr[74]) && objArr[74] != null ? (String) objArr[74] : "");
					iL03A01Q02Bean
							.setIlMANTYPE(!"".equals(objArr[75]) && objArr[75] != null ? (String) objArr[75] : "");
					if ("1".equals(bean.getChkARCNO()))
						iL03A01Q02Bean.setChkARCNO("ilArcno");
					if ("1".equals(bean.getChkPSPT()))
						iL03A01Q02Bean.setChkPSPT("ilPspt");
					if ("1".equals(bean.getChkENM()))
						iL03A01Q02Bean.setChkENM("ilEnm");
					if ("1".equals(bean.getChkNTCD()))
						iL03A01Q02Bean.setChkNTCD("ilNtcd");
					if ("1".equals(bean.getChkBTHDT()))
						iL03A01Q02Bean.setChkBTHDT("ilBthdt");
					if ("1".equals(bean.getChkCNM()))
						iL03A01Q02Bean.setChkCNM("ilCnm");
					if ("1".equals(bean.getChkARCFM()))
						iL03A01Q02Bean.setChkARCFM("ilArcfm");
					if ("1".equals(bean.getChkARCTO()))
						iL03A01Q02Bean.setChkARCTO("ilArcto");
					if ("1".equals(bean.getChkSEX()))
						iL03A01Q02Bean.setChkSEX("ilSex");
					if ("1".equals(bean.getChkJBCD()))
						iL03A01Q02Bean.setChkJBCD("ilJbcd");
					if ("1".equals(bean.getChkARCST()))
						iL03A01Q02Bean.setChkARCST("ilArcst");
					if ("1".equals(bean.getChkARCRSN()))
						iL03A01Q02Bean.setChkARCRSN("ilArcrsn");
					if ("1".equals(bean.getChkEDU()))
						iL03A01Q02Bean.setChkEDU("ilEdu");
					if ("1".equals(bean.getChkOFCD()))
						iL03A01Q02Bean.setChkOFCD("ilOfcd");
					if ("1".equals(bean.getChkOFNM()))
						iL03A01Q02Bean.setChkOFNM("ilOfnm");
					if ("1".equals(bean.getChkOFTEL()))
						iL03A01Q02Bean.setChkOFTEL("ilOftel");
					if ("1".equals(bean.getChkJBADDR()))
						iL03A01Q02Bean.setChkJBADDR("ilJbaddr");
					if ("1".equals(bean.getChkJBTEL()))
						iL03A01Q02Bean.setChkJBTEL("ilJbtel");
					if ("1".equals(bean.getChkARPZONE()))
						iL03A01Q02Bean.setChkARPZONE("ilArpzone");
					if ("1".equals(bean.getChkARADDR()))
						iL03A01Q02Bean.setChkARADDR("ilAraddr");
					if ("1".equals(bean.getChkARTEL()))
						iL03A01Q02Bean.setChkARTEL("ilArtel");
					if ("1".equals(bean.getChkPHQ()))
						iL03A01Q02Bean.setChkPHQ("ilPhq");
					if ("1".equals(bean.getChkPSTEXT()))
						iL03A01Q02Bean.setChkPSTEXT("ilPstext");
					if ("1".equals(bean.getChkFRSHP()))
						iL03A01Q02Bean.setChkFRSHP("ilFrshp");
					if ("1".equals(bean.getChkFNTCD()))
						iL03A01Q02Bean.setChkFNTCD("ilFntcd");
					if ("1".equals(bean.getChkMISSDT()))
						iL03A01Q02Bean.setChkMISSDT("ilMissdt");
					if ("1".equals(bean.getChkSBMTDT()))
						iL03A01Q02Bean.setChkSBMTDT("ilSbmtdt");
					if ("1".equals(bean.getChkFNDDT()))
						iL03A01Q02Bean.setChkFNDDT("ilFnddt");
					if ("1".equals(bean.getChkSRCHST()))
						iL03A01Q02Bean.setChkSRCHST("ilSrchst");
					if ("1".equals(bean.getChkINDT()))
						iL03A01Q02Bean.setChkINDT("ilIndt");
					if ("1".equals(bean.getChkEXDT()))
						iL03A01Q02Bean.setChkEXDT("ilExdt");
					if ("1".equals(bean.getChkFPID()))
						iL03A01Q02Bean.setChkFPID("ilFpid");
					if ("1".equals(bean.getChkFNM()))
						iL03A01Q02Bean.setChkFNM("ilFnm");
					if ("1".equals(bean.getChkAPYDT()))
						iL03A01Q02Bean.setChkAPYDT("ilApydt");
					if ("1".equals(bean.getChkARCRCP()))
						iL03A01Q02Bean.setChkARCRCP("ilArcrcp");
					if ("1".equals(bean.getChkMICRO()))
						iL03A01Q02Bean.setChkMICRO("ilMicro");
					if ("1".equals(bean.getChkOLDARCNO()))
						iL03A01Q02Bean.setChkOLDARCNO("ilOldarc");
					if ("1".equals(bean.getChkilNTNM()))
						iL03A01Q02Bean.setChkilNTNM("ilNTNM");
					if ("1".equals(bean.getChkMANTYPE()))
						iL03A01Q02Bean.setChkMANTYPE("ilMANTYPE");
					list.add(i, iL03A01Q02Bean);
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tryToCloseSession();
		}
		return list;
	}


	public List<Iltb01Main> getIL03ByDBQueryA(String whereCondition) {
		List<Iltb01Main> list = new ArrayList<Iltb01Main>();
		try {
			StringBuffer sqlStr = new StringBuffer();
			sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN");
			if (whereCondition != null && whereCondition.length() > 0) {
				sqlStr.append(" WHERE ");
				sqlStr.append(whereCondition);
			}
			System.out.println("sqlStr=" + sqlStr);
			SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
			q.addScalar("IL_SEX", (Type) Hibernate.STRING);
			q.addScalar("IL_BTHDT", (Type) Hibernate.STRING);
			q.addScalar("IL_NTCD", (Type) Hibernate.STRING);
			q.addScalar("IL_ARCRSN", (Type) Hibernate.STRING);
			q.addScalar("IL_JBCD", (Type) Hibernate.STRING);
			List<Object[]> objList = q.list();
			if (objList.size() > 0)
				for (int i = 0; i < objList.size(); i++) {
					Iltb01Main bean = new Iltb01Main();
					String IL_SEX = null;
					String IL_BTHDT = null;
					String IL_NTCD = null;
					String IL_ARCRSN = null;
					String IL_JBCD = null;
					Object[] objArr = objList.get(i);
					if (!"".equals(objArr[0]) && objArr[0] != null)
						IL_SEX = (String) objArr[0];
					if (!"".equals(objArr[1]) && objArr[1] != null)
						IL_BTHDT = (String) objArr[1];
					if (!"".equals(objArr[2]) && objArr[2] != null)
						IL_NTCD = (String) objArr[2];
					if (!"".equals(objArr[3]) && objArr[3] != null)
						IL_ARCRSN = (String) objArr[3];
					if (!"".equals(objArr[4]) && objArr[4] != null)
						IL_JBCD = (String) objArr[4];
					bean.setIlSex(IL_SEX);
					bean.setIlBthdt(IL_BTHDT);
					bean.setIlNtcd(IL_NTCD);
					bean.setIlArcrsn(IL_ARCRSN);
					bean.setIlJbcd(IL_JBCD);
					list.add(i, bean);
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tryToCloseSession();
		}
		return list;
	}

	public List<Iltb01Main> getIL03ByDBQueryB(String whereCondition) {
		List<Iltb01Main> list = new ArrayList<Iltb01Main>();
		try {
			StringBuffer sqlStr = new StringBuffer();
			sqlStr.append("SELECT * from ILTB_01_MAIN");
			if (whereCondition != null && whereCondition.length() > 0) {
				sqlStr.append(" WHERE ");
				sqlStr.append(whereCondition);
			}
			System.out.println("sqlStr=" + sqlStr);
			SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
			q.addEntity(Iltb01Main.class);
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tryToCloseSession();
		}
		return list;
	}

	public List<Iltb01Main> getIL03B01P01_2P(String[] ilPstArr, String[] ilZipCodeArr, String ilPstext) {
		List<Iltb01Main> list = new ArrayList<Iltb01Main>();
		try {
			StringBuffer sqlStr = new StringBuffer();
			sqlStr.append("SELECT IL_SEX, IL_BTHDT, IL_NTCD, IL_ARCRSN, IL_JBCD from ILTB_01_MAIN WHERE ");
			if (ilPstArr != null) {
				sqlStr.append("(");
				for (int i = 0; i < ilPstArr.length; i++) {
					if (i == 0) {
						sqlStr.append("IL_PHQ='" + ilPstArr[i] + "'");
					} else {
						sqlStr.append(" OR IL_PHQ='" + ilPstArr[i] + "'");
					}
				}
				sqlStr.append(")");
			}
			if (ilZipCodeArr != null) {
				sqlStr.append(" AND (");
				for (int i = 0; i < ilZipCodeArr.length; i++) {
					if (i == 0) {
						sqlStr.append("IL_ARPZONE='" + ilZipCodeArr[i] + "'");
					} else {
						sqlStr.append(" OR IL_ARPZONE='" + ilZipCodeArr[i] + "'");
					}
				}
				sqlStr.append(")");
			}
			if (!"".equals(ilPstext) && ilPstext != null)
				sqlStr.append(" AND IL_PSTEXT='" + ilPstext + "'");
			sqlStr.append(" AND IL_ARCTO > getdate()");
			sqlStr.append(" AND IL_ARCST = '2'");
			sqlStr.append(" AND IL_NTCD <> '35'");
			sqlStr.append(" GROUP BY IL_NTCD, IL_JBCD, IL_SEX");
			sqlStr.append(" ORDER BY IL_NTCD, IL_JBCD, IL_SEX");
			SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
			q.addScalar("IL_SEX", (Type) Hibernate.STRING);
			q.addScalar("IL_BTHDT", (Type) Hibernate.STRING);
			q.addScalar("IL_NTCD", (Type) Hibernate.STRING);
			q.addScalar("IL_ARCRSN", (Type) Hibernate.STRING);
			q.addScalar("IL_JBCD", (Type) Hibernate.STRING);
			List<Object[]> objList = q.list();
			if (objList.size() > 0)
				for (int i = 0; i < objList.size(); i++) {
					Iltb01Main bean = new Iltb01Main();
					String IL_SEX = null;
					String IL_BTHDT = null;
					String IL_NTCD = null;
					String IL_ARCRSN = null;
					String IL_JBCD = null;
					Object[] objArr = objList.get(i);
					if (!"".equals(objArr[0]) && objArr[0] != null)
						IL_SEX = (String) objArr[0];
					if (!"".equals(objArr[1]) && objArr[1] != null)
						IL_BTHDT = (String) objArr[1];
					if (!"".equals(objArr[2]) && objArr[2] != null)
						IL_NTCD = (String) objArr[2];
					if (!"".equals(objArr[3]) && objArr[3] != null)
						IL_ARCRSN = (String) objArr[3];
					if (!"".equals(objArr[4]) && objArr[4] != null)
						IL_JBCD = (String) objArr[4];
					bean.setIlSex(IL_SEX);
					bean.setIlBthdt(IL_BTHDT);
					bean.setIlNtcd(IL_NTCD);
					bean.setIlArcrsn(IL_ARCRSN);
					bean.setIlJbcd(IL_JBCD);
					list.add(i, bean);
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tryToCloseSession();
		}
		return list;
	}

	public List<Iltb01Main> getIL03B01P01_3P(String[] ilPstArr, String[] ilZipCodeArr, String ilPstext) {
		List<Iltb01Main> list = new ArrayList<Iltb01Main>();
		try {
			StringBuffer sqlStr = new StringBuffer();
			sqlStr.append("SELECT * FROM ILTB_01_MAIN WHERE");
			if (ilPstArr != null) {
				sqlStr.append("(");
				for (int i = 0; i < ilPstArr.length; i++) {
					if (i == 0) {
						sqlStr.append("IL_PHQ='" + ilPstArr[i] + "'");
					} else {
						sqlStr.append(" OR IL_PHQ='" + ilPstArr[i] + "'");
					}
				}
				sqlStr.append(")");
			}
			if (ilZipCodeArr != null) {
				sqlStr.append(" AND (");
				for (int i = 0; i < ilZipCodeArr.length; i++) {
					if (i == 0) {
						sqlStr.append("IL_ARPZONE='" + ilZipCodeArr[i] + "'");
					} else {
						sqlStr.append(" OR IL_ARPZONE='" + ilZipCodeArr[i] + "'");
					}
				}
				sqlStr.append(")");
			}
			if (!"".equals(ilPstext) && ilPstext != null)
				sqlStr.append(" AND IL_PSTEXT='" + ilPstext + "'");
			sqlStr.append(" AND IL_SEX = '1'");
			sqlStr.append(" AND IL_ARCST <> '4'");
			sqlStr.append(" AND IL_JBCD = '37'");
			sqlStr.append(" AND convert(char(8), isnull(IL_ARCTO, ''), 112) >= convert(char(8), getdate(), 112)");
			System.out.println("sqlStr=" + sqlStr);
			SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
			q.addEntity(Iltb01Main.class);
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tryToCloseSession();
		}
		return list;
	}

	public List<Iltb01Main> getIL03B01P01_4P(String[] ilPstArr, String[] ilZipCodeArr, String ilPstext) {
		List<Iltb01Main> list = new ArrayList<Iltb01Main>();
		try {
			StringBuffer sqlStr = new StringBuffer();
			sqlStr.append("SELECT * FROM ILTB_01_MAIN WHERE ");
			sqlStr.append("IL_SEX = '2' ");
			sqlStr.append("AND IL_NTCD in ('004' , '009' , '017' , '019' , '024' , '027' , '030') ");
			sqlStr.append("AND IL_ARCRSN in ('1','8','9','A','B') ");
			sqlStr.append(
					"AND ((IL_ARCTO >= getdate() AND (IL_ARCST = '2' OR (IL_ARCST = '3' AND (IL_MISSDT IS NULL)))) OR (IL_ARCTO < getdate() AND IL_ARCST = '2')) ");
			sqlStr.append("AND IL_FRSHP = '01' ");
			sqlStr.append("AND IL_FNTCD = '035' ");
			if (ilPstArr != null) {
				sqlStr.append(" AND (");
				for (int i = 0; i < ilPstArr.length; i++) {
					if (i == 0) {
						sqlStr.append("IL_PHQ='" + ilPstArr[i] + "'");
					} else {
						sqlStr.append(" OR IL_PHQ='" + ilPstArr[i] + "'");
					}
				}
			}
			sqlStr.append(")");
			if (ilZipCodeArr != null) {
				sqlStr.append(" AND (");
				for (int i = 0; i < ilZipCodeArr.length; i++) {
					if (i == 0) {
						sqlStr.append("IL_ARPZONE='" + ilZipCodeArr[i] + "'");
					} else {
						sqlStr.append(" OR IL_ARPZONE='" + ilZipCodeArr[i] + "'");
					}
				}
				sqlStr.append(")");
				System.out.println("sqlStr=" + sqlStr);
				logger.info(sqlStr);
				SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
				q.addEntity(Iltb01Main.class);
				list = q.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tryToCloseSession();
		}
		return list;
	}

	public List<Iltb01Main> getIL03B01P01_5P(String[] ilPstArr, String[] ilZipCodeArr, String ilPstext) {
		List<Iltb01Main> list = new ArrayList<Iltb01Main>();
		try {
			StringBuffer sqlStr = new StringBuffer();
			sqlStr.append("SELECT * FROM ILTB_01_MAIN WHERE");
			sqlStr.append(" IL_ARCCS = '1' AND IL_ARCST = '2' AND IL_MISSDT IS NOT NULL ");
			if (ilPstArr != null) {
				sqlStr.append(" AND (");
				for (int i = 0; i < ilPstArr.length; i++) {
					if (i == 0) {
						sqlStr.append("IL_PHQ='" + ilPstArr[i] + "'");
					} else {
						sqlStr.append(" OR IL_PHQ='" + ilPstArr[i] + "'");
					}
				}
			}
			sqlStr.append(")");
			if (ilZipCodeArr != null) {
				sqlStr.append(" AND (");
				for (int i = 0; i < ilZipCodeArr.length; i++) {
					if (i == 0) {
						sqlStr.append("IL_ARPZONE='" + ilZipCodeArr[i] + "'");
					} else {
						sqlStr.append(" OR IL_ARPZONE='" + ilZipCodeArr[i] + "'");
					}
				}
				sqlStr.append(")");
				System.out.println("sqlStr=" + sqlStr);
				SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
				q.addEntity(Iltb01Main.class);
				list = q.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tryToCloseSession();
		}
		return list;
	}

	public List<Iltb01Main> getIL03B01P01_6P(String[] ilPstArr, String[] ilZipCodeArr, String ilPstext) {
		List<Iltb01Main> list = new ArrayList<Iltb01Main>();
		try {
			StringBuffer sqlStr = new StringBuffer();
			sqlStr.append("SELECT * FROM ILTB_01_MAIN WHERE");
			if (ilPstArr != null) {
				sqlStr.append("(");
				for (int i = 0; i < ilPstArr.length; i++) {
					if (i == 0) {
						sqlStr.append("IL_PHQ='" + ilPstArr[i] + "'");
					} else {
						sqlStr.append(" OR IL_PHQ='" + ilPstArr[i] + "'");
					}
				}
				sqlStr.append(")");
			}
			if (ilZipCodeArr != null) {
				sqlStr.append(" AND (");
				for (int i = 0; i < ilZipCodeArr.length; i++) {
					if (i == 0) {
						sqlStr.append("IL_ARPZONE='" + ilZipCodeArr[i] + "'");
					} else {
						sqlStr.append(" OR IL_ARPZONE='" + ilZipCodeArr[i] + "'");
					}
				}
				sqlStr.append(")");
			}
			if (!"".equals(ilPstext) && ilPstext != null)
				sqlStr.append(" AND IL_PSTEXT='" + ilPstext + "'");
			sqlStr.append(" AND IL_ARCST = '2'");
			sqlStr.append(" AND IL_ARCTO IS NOT NULL");
			sqlStr.append(" AND IL_ARCTO < getdate()");
			System.out.println("sqlStr=" + sqlStr);
			SQLQuery q = HibernateSessionFactory.getSession().createSQLQuery(sqlStr.toString());
			q.addEntity(Iltb01Main.class);
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			tryToCloseSession();
		}
		return list;
	}
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\myDao\
 * MyIltb01MainDAO2.class Java compiler version: 5 (49.0) JD-Core Version: 1.1.3
 */