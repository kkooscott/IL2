package tw.gov.npa.il.myDao;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
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
		List<Iltb01Main> list = new ArrayList<>();
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
					byte b;
					int i;
					String[] arrayOfString;
					for (i = (arrayOfString = ilArccsArr).length, b = 0; b < i;) {
						String ilArccs = arrayOfString[b];
						if (ilArccs.equals(Integer.valueOf(0))) {
							sqlStr.append(" AND IL_ARCCS in ('0')");
						} else if (ilArccs.equals(Integer.valueOf(1))) {
							sqlStr.append(" AND IL_ARCCS in ('1')");
						}
						b++;
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
		List<IL03A01Q02Bean> list = new ArrayList<>();
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
					bean.setIlArcid(Integer.valueOf(IL_ARCID));
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
		List<IL03A01Q02Bean> list = new ArrayList<>();
		try {
			StringBuffer sqlStr = new StringBuffer();

			sqlStr.append("SELECT a.IL_ARCID, ");
			if ("1".equals(chkILARCNO))
				sqlStr.append("a.IL_ARCNO, ");
			if ("1".equals(chkILPSPT))
				sqlStr.append("a.IL_PSPT, ");
			if ("1".equals(chkILENM))
				sqlStr.append("a.IL_ENM, ");
			if ("1".equals(chkNT))
				sqlStr.append("a.IL_NTCD, ");
			if ("1".equals(chkLBLBTHDTFM)) {
				sqlStr.append("a.IL_BTHDT, ");
			}

			sqlStr.append(" b.IL_NTNM FROM ILTB_01_MAIN a, ILTB_15_COUNTRY_CODE b WHERE a.IL_NTCD = b.IL_NTCD");
			if (!"".equals(ilArcno) || ilArcno == null)
				sqlStr.append(" AND a.IL_ARCNO = '" + ilArcno + "'");
			if (!"".equals(ilPspt) || ilPspt == null)
				sqlStr.append(" AND a.IL_PSPT = '" + ilPspt + "'");
			if (!"".equals(ilEnm) || ilEnm == null)
				sqlStr.append(" AND a.IL_ENM like '" + ilEnm + "%'");
			if (!"".equals(ilCnm) || ilCnm == null)
				sqlStr.append(" AND a.IL_CNM = '" + ilCnm + "'");
			if (!"".equals(ilOfnm) || ilOfnm == null) {
				sqlStr.append(" AND a.IL_OFNM = '" + ilOfnm + "'");
			}
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
				sqlStr.append("AND a.IL_APYDT >= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(txtAPY_FROM)) + "'");
			if (!"".equals(txtAPY_TO) || txtAPY_TO == null)
				sqlStr.append("AND a.IL_APYDT <= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(txtAPY_TO)) + "'");
			if (!"".equals(txtARC_FROM) || txtARC_FROM == null)
				sqlStr.append("AND a.IL_ARCTO >= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(txtARC_FROM)) + "'");
			if (!"".equals(txtARC_TO) || txtARC_TO == null)
				sqlStr.append("AND a.IL_ARCTO <= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(txtARC_TO)) + "'");
			if (!"".equals(txtREAPY_FROM) || txtREAPY_FROM == null)
				sqlStr.append("AND a.IL_REAPYDT >= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(txtREAPY_FROM)) + "'");
			if (!"".equals(txtREAPY_TO) || txtREAPY_TO == null)
				sqlStr.append("AND a.IL_REAPYDT <= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(txtREAPY_TO)) + "'");
			if (!"".equals(txtMISS_FROM) || txtMISS_FROM == null)
				sqlStr.append("AND a.IL_MISSDT >= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(txtMISS_FROM)) + "'");
			if (!"".equals(txtMISS_TO) || txtMISS_TO == null)
				sqlStr.append("AND a.IL_MISSDT <= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(txtMISS_TO)) + "'");
			if (!"".equals(txtSBMT_FROM) || txtSBMT_FROM == null)
				sqlStr.append("AND a.IL_SBMTDT >= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(txtSBMT_FROM)) + "'");
			if (!"".equals(txtSBMT_TO) || txtSBMT_TO == null) {
				sqlStr.append("AND a.IL_SBMTDT <= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(txtSBMT_TO)) + "'");
			}
			if (!"".equals(txtFIND_FROM) || txtFIND_FROM == null)
				sqlStr.append("AND a.IL_FNDDT >= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(txtFIND_FROM)) + "'");
			if (!"".equals(txtFIND_TO) || txtFIND_TO == null)
				sqlStr.append("AND a.IL_FNDDT <= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(txtFIND_TO)) + "'");
			if (!"".equals(txtIN_FROM) || txtIN_FROM == null)
				sqlStr.append("AND a.IL_INDT >= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(txtIN_FROM)) + "'");
			if (!"".equals(txtIN_TO) || txtIN_TO == null)
				sqlStr.append("AND a.IL_INDT <= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(txtIN_TO)) + "'");
			if (!"".equals(txtEXIT_FROM) || txtEXIT_FROM == null)
				sqlStr.append("AND a.IL_EXDT >= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(txtEXIT_FROM)) + "'");
			if (!"".equals(txtEXIT_TO) || txtEXIT_TO == null) {
				sqlStr.append("AND a.IL_EXDT <= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(txtEXIT_TO)) + "'");
			}
			if (!"".equals(FNDDID) || FNDDID == null) {
				sqlStr.append(" AND a.IL_FNDDID = '" + FNDDID + "'");
			}
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
					bean.setIlArcid(Integer.valueOf(IL_ARCID));
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
		List<IL03A01Q02Bean> list = new ArrayList<>();
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
				for (int i = 0; i < pspt.length; i++) {
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
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(bean.getIlApydtFrom())) + "'");
			if (!"".equals(bean.getIlApydtTo()) || bean.getIlApydtTo() == null)
				sqlStr.append("AND a.IL_APYDT <= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(bean.getIlApydtTo())) + "'");
			if (!"".equals(bean.getIlArcfm()) || bean.getIlArcfm() == null)
				sqlStr.append("AND a.IL_ARCTO >= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(bean.getIlArcfm())) + "'");
			if (!"".equals(bean.getIlArcto()) || bean.getIlArcto() == null)
				sqlStr.append("AND a.IL_ARCTO <= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(bean.getIlArcto())) + "'");
			if (!"".equals(bean.getIlReapydtFrom()) || bean.getIlReapydtFrom() == null)
				sqlStr.append("AND a.IL_REAPYDT >= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(bean.getIlReapydtFrom())) + "'");
			if (!"".equals(bean.getIlReapydtTo()) || bean.getIlReapydtTo() == null)
				sqlStr.append("AND a.IL_REAPYDT <= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(bean.getIlReapydtTo())) + "'");
			if (!"".equals(bean.getIlMissdtFrom()) || bean.getIlMissdtFrom() == null)
				sqlStr.append("AND a.IL_MISSDT >= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(bean.getIlMissdtFrom())) + "'");
			if (!"".equals(bean.getIlMissdtTo()) || bean.getIlMissdtTo() == null)
				sqlStr.append("AND a.IL_MISSDT <= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(bean.getIlMissdtTo())) + "'");
			if (!"".equals(bean.getIlSbmtdtFrom()) || bean.getIlSbmtdtFrom() == null)
				sqlStr.append("AND a.IL_SBMTDT >= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(bean.getIlSbmtdtFrom())) + "'");
			if (!"".equals(bean.getIlSbmtdtTo()) || bean.getIlSbmtdtTo() == null)
				sqlStr.append("AND a.IL_SBMTDT <= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(bean.getIlSbmtdtTo())) + "'");
			if (!"".equals(bean.getIlFinddtFrom()) || bean.getIlFinddtFrom() == null)
				sqlStr.append("AND a.IL_FNDDT >= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(bean.getIlFinddtFrom())) + "'");
			if (!"".equals(bean.getIlFinddtTo()) || bean.getIlFinddtTo() == null)
				sqlStr.append("AND a.IL_FNDDT <= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(bean.getIlFinddtTo())) + "'");
			if (!"".equals(bean.getIlIndtFrom()) || bean.getIlIndtFrom() == null)
				sqlStr.append("AND a.IL_INDT >= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(bean.getIlIndtFrom())) + "'");
			if (!"".equals(bean.getIlIndtTo()) || bean.getIlIndtTo() == null)
				sqlStr.append("AND a.IL_INDT <= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(bean.getIlIndtTo())) + "'");
			if (!"".equals(bean.getIlExdtFrom()) || bean.getIlExdtFrom() == null)
				sqlStr.append("AND a.IL_EXDT >= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(bean.getIlExdtFrom())) + "'");
			if (!"".equals(bean.getIlExdtTo()) || bean.getIlExdtTo() == null)
				sqlStr.append("AND a.IL_EXDT <= '")
						.append(String.valueOf(this.getDateUtil.getSepSpiltDateStart(bean.getIlExdtTo())) + "'");
			if (!"".equals(bean.getIlFnddid()) || bean.getIlFnddid() == null)
				sqlStr.append(" AND a.IL_FNDDID = '" + bean.getIlFnddid() + "'");
			if (!"0".equals(bean.getIlMANTYPE()) || bean.getIlMANTYPE() == null) {
				sqlStr.append(" AND c.IL_MANTYPE = '" + bean.getIlMANTYPE() + "'");
			}
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
					iL03A01Q02Bean.setIlArcid(Integer.valueOf(
							(!"".equals(objArr[0]) && objArr[0] != null) ? ((Integer) objArr[0]).intValue() : 0));
					iL03A01Q02Bean.setIlArctp((!"".equals(objArr[1]) && objArr[1] != null) ? (String) objArr[1] : "");
					iL03A01Q02Bean.setIlArccs((!"".equals(objArr[2]) && objArr[2] != null) ? (String) objArr[2] : "");
					iL03A01Q02Bean.setIlEnm((!"".equals(objArr[3]) && objArr[3] != null) ? (String) objArr[3] : "");
					iL03A01Q02Bean.setIlCnm((!"".equals(objArr[4]) && objArr[4] != null) ? (String) objArr[4] : "");
					iL03A01Q02Bean.setIlSex((!"".equals(objArr[5]) && objArr[5] != null) ? (String) objArr[5] : "");
					iL03A01Q02Bean.setIlBthdt((!"".equals(objArr[6]) && objArr[6] != null) ? (String) objArr[6] : "");
					iL03A01Q02Bean.setIlNtcd((!"".equals(objArr[7]) && objArr[7] != null) ? (String) objArr[7] : "");
					iL03A01Q02Bean.setIlPspt((!"".equals(objArr[8]) && objArr[8] != null) ? (String) objArr[8] : "");
					iL03A01Q02Bean.setIlPsdt((!"".equals(objArr[9]) && objArr[9] != null) ? (String) objArr[9] : "");
					iL03A01Q02Bean.setIlMst((!"".equals(objArr[10]) && objArr[10] != null) ? (String) objArr[10] : "");
					if (!"".equals(objArr[11]) && objArr[11] != null) {
						String str;
						switch ((str = (String) objArr[11]).hashCode()) {
						case 1536:
							if (!str.equals("00"))
								break;
							iL03A01Q02Bean.setIlEdu("");
							break;
						case 1537:
							if (!str.equals("01"))
								break;
							iL03A01Q02Bean.setIlEdu("��ㄚ");
							break;
						case 1538:
							if (!str.equals("02"))
								break;
							iL03A01Q02Bean.setIlEdu("蝣拙ㄚ");
							break;
						case 1539:
							if (!str.equals("03"))
								break;
							iL03A01Q02Bean.setIlEdu("憭批飛�璆�");
							break;
						case 1540:
							if (!str.equals("04"))
								break;
							iL03A01Q02Bean.setIlEdu("憭批飛��平");
							break;
						case 1541:
							if (!str.equals("05"))
								break;
							iL03A01Q02Bean.setIlEdu("撠�璆�");
							break;
						case 1542:
							if (!str.equals("06"))
								break;
							iL03A01Q02Bean.setIlEdu("撠��平");
							break;
						case 1543:
							if (!str.equals("07"))
								break;
							iL03A01Q02Bean.setIlEdu("擃葉�璆�");
							break;
						case 1544:
							if (!str.equals("08"))
								break;
							iL03A01Q02Bean.setIlEdu("擃葉��平");
							break;
						case 1545:
							if (!str.equals("09"))
								break;
							iL03A01Q02Bean.setIlEdu("��葉�璆�");
							break;
						case 1567:
							if (!str.equals("10"))
								break;
							iL03A01Q02Bean.setIlEdu("��葉��平");
							break;
						case 1568:
							if (!str.equals("11"))
								break;
							iL03A01Q02Bean.setIlEdu("撠飛�璆�");
							break;
						case 1569:
							if (!str.equals("12"))
								break;
							iL03A01Q02Bean.setIlEdu("撠飛��平");
							break;
						case 1570:
							if (!str.equals("13"))
								break;
							iL03A01Q02Bean.setIlEdu("霅��");
							break;
						case 1571:
							if (!str.equals("14"))
								break;
							iL03A01Q02Bean.setIlEdu("銝���");
							break;
						case 1572:
							if (!str.equals("15"))
								break;
							iL03A01Q02Bean.setIlEdu("銝��");
							break;
						}

					} else {
						iL03A01Q02Bean.setIlEdu("");
					}
					iL03A01Q02Bean.setIlIndt((!"".equals(objArr[12]) && objArr[12] != null) ? (String) objArr[12] : "");
					iL03A01Q02Bean.setIlExdt((!"".equals(objArr[13]) && objArr[13] != null) ? (String) objArr[13] : "");
					if (!"".equals(objArr[14]) && objArr[14] != null) {
						String str;
						switch ((str = (String) objArr[14]).hashCode()) {
						case 48:
							if (!str.equals("0"))
								break;
							iL03A01Q02Bean.setIlArcrsn("");
							break;
						case 49:
							if (!str.equals("1"))
								break;
							iL03A01Q02Bean.setIlArcrsn("靘扛");
							break;
						case 50:
							if (!str.equals("2"))
								break;
							iL03A01Q02Bean.setIlArcrsn("撠勗飛");
							break;
						case 51:
							if (!str.equals("3"))
								break;
							iL03A01Q02Bean.setIlArcrsn("����");
							break;
						case 52:
							if (!str.equals("4"))
								break;
							iL03A01Q02Bean.setIlArcrsn("����");
							break;
						case 53:
							if (!str.equals("5"))
								break;
							iL03A01Q02Bean.setIlArcrsn("����");
							break;
						case 54:
							if (!str.equals("6"))
								break;
							iL03A01Q02Bean.setIlArcrsn("�隞�");
							break;
						case 55:
							if (!str.equals("7"))
								break;
							iL03A01Q02Bean.setIlArcrsn("憭��");
							break;
						case 56:
							if (!str.equals("8"))
								break;
							iL03A01Q02Bean.setIlArcrsn("瘞詨��(��蝥���僑)");
							break;
						case 57:
							if (!str.equals("9"))
								break;
							iL03A01Q02Bean.setIlArcrsn("瘞詨��(靘扛鈭僑��)");
							break;
						case 65:
							if (!str.equals("A"))
								break;
							iL03A01Q02Bean.setIlArcrsn("瘞詨��(靘扛鈭僑摮戊)");
							break;
						case 66:
							if (!str.equals("B"))
								break;
							iL03A01Q02Bean.setIlArcrsn("瘞詨��(靘扛撅���僑)");
							break;
						case 67:
							if (!str.equals("C"))
								break;
							iL03A01Q02Bean.setIlArcrsn("瘞詨��(靘扛撅��僑)");
							break;
						case 68:
							if (!str.equals("D"))
								break;
							iL03A01Q02Bean.setIlArcrsn("瘞詨��(撅���僑��)");
							break;
						case 69:
							if (!str.equals("E"))
								break;
							iL03A01Q02Bean.setIlArcrsn("瘞詨��(擃��鈭箏ㄚ)");
							break;
						case 70:
							if (!str.equals("F"))
								break;
							iL03A01Q02Bean.setIlArcrsn("瘞詨��(�畾甜���)");
							break;
						case 71:
							if (!str.equals("G"))
								break;
							iL03A01Q02Bean.setIlArcrsn("瘞詨��(�隞�)");
							break;
						}

					} else {
						iL03A01Q02Bean.setIlArcrsn("");
					}
					if (!"".equals(objArr[15]) && objArr[15] != null) {
						String str;
						switch ((str = (String) objArr[15]).hashCode()) {
						case 49:
							if (!str.equals("1"))
								break;
							iL03A01Q02Bean.setIlArcst("�霈���(��������)");
							break;
						case 50:
							if (!str.equals("2"))
								break;
							iL03A01Q02Bean.setIlArcst("��");
							break;
						case 51:
							if (!str.equals("3"))
								break;
							iL03A01Q02Bean.setIlArcst("��");
							break;
						case 52:
							if (!str.equals("4"))
								break;
							iL03A01Q02Bean.setIlArcst("甇颱滿");
							break;
						case 53:
							if (!str.equals("5"))
								break;
							iL03A01Q02Bean.setIlArcst("閮駁撅���");
							break;
						case 54:
							if (!str.equals("6"))
								break;
							iL03A01Q02Bean.setIlArcst("璉��������");
							break;
						}

					} else {
						iL03A01Q02Bean.setIlArcst("");
					}
					iL03A01Q02Bean.setIlJbcd((!"".equals(objArr[16]) && objArr[16] != null) ? (String) objArr[16] : "");
					iL03A01Q02Bean
							.setIlJbpsn((!"".equals(objArr[17]) && objArr[17] != null) ? (String) objArr[17] : "");
					iL03A01Q02Bean.setIlOfcd((!"".equals(objArr[18]) && objArr[18] != null) ? (String) objArr[18] : "");
					iL03A01Q02Bean.setIlOfnm((!"".equals(objArr[19]) && objArr[19] != null) ? (String) objArr[19] : "");
					iL03A01Q02Bean
							.setIlOftel((!"".equals(objArr[20]) && objArr[20] != null) ? (String) objArr[20] : "");
					iL03A01Q02Bean
							.setIlOfnmbf((!"".equals(objArr[21]) && objArr[21] != null) ? (String) objArr[21] : "");
					iL03A01Q02Bean
							.setIlJbpzone((!"".equals(objArr[22]) && objArr[22] != null) ? (String) objArr[22] : "");
					iL03A01Q02Bean
							.setIlJbaddr((!"".equals(objArr[23]) && objArr[23] != null) ? (String) objArr[23] : "");
					iL03A01Q02Bean
							.setIlJbtel((!"".equals(objArr[24]) && objArr[24] != null) ? (String) objArr[24] : "");
					iL03A01Q02Bean
							.setIlArpzone((!"".equals(objArr[25]) && objArr[25] != null) ? (String) objArr[25] : "");
					iL03A01Q02Bean
							.setIlAraddr((!"".equals(objArr[26]) && objArr[26] != null) ? (String) objArr[26] : "");
					iL03A01Q02Bean
							.setIlArtel((!"".equals(objArr[27]) && objArr[27] != null) ? (String) objArr[27] : "");
					iL03A01Q02Bean
							.setIlAgnco((!"".equals(objArr[28]) && objArr[28] != null) ? (String) objArr[28] : "");
					iL03A01Q02Bean
							.setIlAgntel((!"".equals(objArr[29]) && objArr[29] != null) ? (String) objArr[29] : "");
					if (!"".equals(objArr[30]) && objArr[30] != null) {
						String str;
						switch ((str = (String) objArr[30]).hashCode()) {
						case 45:
							if (!str.equals("-")) {
								break;
							}

							iL03A01Q02Bean.setIlJbpmcd("銵�蔡");
							break;
						case 48:
							if (!str.equals("0"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("");
							break;
						case 49:
							if (!str.equals("1"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("���");
							break;
						case 50:
							if (!str.equals("2"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("���");
							break;
						case 51:
							if (!str.equals("3"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("蝬�");
							break;
						case 52:
							if (!str.equals("4"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("蝬���祟���");
							break;
						case 53:
							if (!str.equals("5"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("蝘飛���蝞∠��");
							break;
						case 54:
							if (!str.equals("6"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("���");
							break;
						case 55:
							if (!str.equals("7"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("鈭日�");
							break;
						case 56:
							if (!str.equals("8"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("���");
							break;
						case 57:
							if (!str.equals("9"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("����");
							break;
						case 65:
							if (!str.equals("A"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("����摨�");
							break;
						case 66:
							if (!str.equals("B"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("�銝剖�摨�");
							break;
						case 67:
							if (!str.equals("C"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("����摨�");
							break;
						case 68:
							if (!str.equals("D"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("����摨�");
							break;
						case 69:
							if (!str.equals("E"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("擃��摨�");
							break;
						case 70:
							if (!str.equals("F"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("���腦�摨�");
							break;
						case 71:
							if (!str.equals("G"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("摰蝮��摨�");
							break;
						case 72:
							if (!str.equals("H"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("獢�腦�摨�");
							break;
						case 73:
							if (!str.equals("I"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("��儔撣摨�");
							break;
						case 74:
							if (!str.equals("J"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("�蝡寧腦�摨�");
							break;
						case 75:
							if (!str.equals("K"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("���腦�摨�");
							break;
						case 76:
							if (!str.equals("L"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("�銝剔腦�摨�");
							break;
						case 77:
							if (!str.equals("M"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("���腦�摨�");
							break;
						case 78:
							if (!str.equals("N"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("敶啣�腦�摨�");
							break;
						case 79:
							if (!str.equals("O"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("�蝡孵�摨�");
							break;
						case 80:
							if (!str.equals("P"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("���腦�摨�");
							break;
						case 81:
							if (!str.equals("Q"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("��儔蝮��摨�");
							break;
						case 82:
							if (!str.equals("R"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("���腦�摨�");
							break;
						case 83:
							if (!str.equals("S"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("擃�腦�摨�");
							break;
						case 84:
							if (!str.equals("T"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("撅蝮��摨�");
							break;
						case 85:
							if (!str.equals("U"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("��蝮��摨�");
							break;
						case 86:
							if (!str.equals("V"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("��蝮��摨�");
							break;
						case 87:
							if (!str.equals("W"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("���蝮��摨�");
							break;
						case 88:
							if (!str.equals("X"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("瞉�腦�摨�");
							break;
						case 89:
							if (!str.equals("Y"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("��瘙腦�摨�");
							break;
						case 90:
							if (!str.equals("Z"))
								break;
							iL03A01Q02Bean.setIlJbpmcd("�隞�");
							break;
						}

					} else {
						iL03A01Q02Bean.setIlJbpmcd("");
					}

					iL03A01Q02Bean
							.setIlJbpmdc((!"".equals(objArr[31]) && objArr[31] != null) ? (String) objArr[31] : "");
					iL03A01Q02Bean
							.setIlJbpmdt((!"".equals(objArr[32]) && objArr[32] != null) ? (String) objArr[32] : "");
					iL03A01Q02Bean
							.setIlJbpmfm((!"".equals(objArr[33]) && objArr[33] != null) ? (String) objArr[33] : "");
					iL03A01Q02Bean
							.setIlJbpmto((!"".equals(objArr[34]) && objArr[34] != null) ? (String) objArr[34] : "");
					iL03A01Q02Bean
							.setIlMicro((!"".equals(objArr[35]) && objArr[35] != null) ? (String) objArr[35] : "");
					iL03A01Q02Bean
							.setIlApydt((!"".equals(objArr[36]) && objArr[36] != null) ? (String) objArr[36] : "");
					iL03A01Q02Bean
							.setIlArcrcp((!"".equals(objArr[37]) && objArr[37] != null) ? (String) objArr[37] : "");
					iL03A01Q02Bean
							.setIlArcno((!"".equals(objArr[38]) && objArr[38] != null) ? (String) objArr[38] : "");
					iL03A01Q02Bean
							.setIlArcfm((!"".equals(objArr[39]) && objArr[39] != null) ? (String) objArr[39] : "");
					iL03A01Q02Bean
							.setIlArcto((!"".equals(objArr[40]) && objArr[40] != null) ? (String) objArr[40] : "");
					iL03A01Q02Bean.setIlPst((!"".equals(objArr[41]) && objArr[41] != null) ? (String) objArr[41] : "");
					iL03A01Q02Bean.setIlPhq((!"".equals(objArr[42]) && objArr[42] != null) ? (String) objArr[42] : "");
					iL03A01Q02Bean
							.setIlPstext((!"".equals(objArr[43]) && objArr[43] != null) ? (String) objArr[43] : "");
					iL03A01Q02Bean
							.setIlRemrk((!"".equals(objArr[44]) && objArr[44] != null) ? (String) objArr[44] : "");
					iL03A01Q02Bean
							.setIlArcisu((!"".equals(objArr[45]) && objArr[45] != null) ? (String) objArr[45] : "");
					if (!"".equals(objArr[46]) && objArr[46] != null) {
						String str;
						switch ((str = (String) objArr[46]).hashCode()) {
						case 1536:
							if (!str.equals("00"))
								break;
							iL03A01Q02Bean.setIlFrshp("");
							break;
						case 1537:
							if (!str.equals("01"))
								break;
							iL03A01Q02Bean.setIlFrshp("憭�");
							break;
						case 1538:
							if (!str.equals("02"))
								break;
							iL03A01Q02Bean.setIlFrshp("憒�");
							break;
						case 1539:
							if (!str.equals("03"))
								break;
							iL03A01Q02Bean.setIlFrshp("�");
							break;
						case 1540:
							if (!str.equals("04"))
								break;
							iL03A01Q02Bean.setIlFrshp("瘥�");
							break;
						case 1541:
							if (!str.equals("05"))
								break;
							iL03A01Q02Bean.setIlFrshp("摮�");
							break;
						case 1542:
							if (!str.equals("06"))
								break;
							iL03A01Q02Bean.setIlFrshp("憟�");
							break;
						case 1543:
							if (!str.equals("07"))
								break;
							iL03A01Q02Bean.setIlFrshp("蟡");
							break;
						case 1544:
							if (!str.equals("08"))
								break;
							iL03A01Q02Bean.setIlFrshp("蟡��");
							break;
						case 1545:
							if (!str.equals("09"))
								break;
							iL03A01Q02Bean.setIlFrshp("���");
							break;
						case 1567:
							if (!str.equals("10"))
								break;
							iL03A01Q02Bean.setIlFrshp("撘�");
							break;
						case 1568:
							if (!str.equals("11"))
								break;
							iL03A01Q02Bean.setIlFrshp("憪�");
							break;
						case 1569:
							if (!str.equals("12"))
								break;
							iL03A01Q02Bean.setIlFrshp("憒�");
							break;
						case 1570:
							if (!str.equals("13"))
								break;
							iL03A01Q02Bean.setIlFrshp("�隞�");
							break;
						}

					} else {
						iL03A01Q02Bean.setIlFrshp("");
					}
					iL03A01Q02Bean.setIlFnm((!"".equals(objArr[47]) && objArr[47] != null) ? (String) objArr[47] : "");
					iL03A01Q02Bean.setIlFpid((!"".equals(objArr[48]) && objArr[48] != null) ? (String) objArr[48] : "");
					iL03A01Q02Bean
							.setIlFntcd((!"".equals(objArr[49]) && objArr[49] != null) ? (String) objArr[49] : "");
					iL03A01Q02Bean
							.setIlFrcexit((!"".equals(objArr[50]) && objArr[50] != null) ? (String) objArr[50] : "");
					iL03A01Q02Bean
							.setIlReapydt((!"".equals(objArr[51]) && objArr[51] != null) ? (String) objArr[51] : "");
					if (!"".equals(objArr[52]) && objArr[52] != null) {
						if ("1".equals(iL03A01Q02Bean.getIlRetp())) {
							iL03A01Q02Bean.setIlRetp("�甈�");
						} else if ("2".equals(iL03A01Q02Bean.getIlRetp())) {
							iL03A01Q02Bean.setIlRetp("憭活");
						}
					} else {
						iL03A01Q02Bean.setIlRetp("");
					}
					iL03A01Q02Bean
							.setIlRepmdc((!"".equals(objArr[53]) && objArr[53] != null) ? (String) objArr[53] : "");
					iL03A01Q02Bean
							.setIlRepmdt((!"".equals(objArr[54]) && objArr[54] != null) ? (String) objArr[54] : "");
					iL03A01Q02Bean
							.setIlRrnote((!"".equals(objArr[55]) && objArr[55] != null) ? (String) objArr[55] : "");
					iL03A01Q02Bean
							.setIlMrkcs((!"".equals(objArr[56]) && objArr[56] != null) ? (String) objArr[56] : "");
					if (!"".equals(objArr[57]) && objArr[57] != null) {
						String str;
						switch ((str = (String) objArr[57]).hashCode()) {
						case 48:
							if (!str.equals("0"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("");
							break;
						case 49:
							if (!str.equals("1"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("�隢���(霈�)���");
							break;
						case 50:
							if (!str.equals("2"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("蝬���撟港誑銝����");
							break;
						case 51:
							if (!str.equals("3"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("瘥僑撅����183憭抵��");
							break;
						case 52:
							if (!str.equals("4"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("��儔����������");
							break;
						case 53:
							if (!str.equals("5"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("撌脣����偶銋�����");
							break;
						case 54:
							if (!str.equals("6"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("蝬���閮勗銝阡�誘�����");
							break;
						case 55:
							if (!str.equals("7"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("�隞�");
							break;
						case 56:
							if (!str.equals("8"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("隡飛");
							break;
						case 57:
							if (!str.equals("9"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("��摮�");
							break;
						case 65:
							if (!str.equals("A"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("�璆�");
							break;
						case 66:
							if (!str.equals("B"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("�隢������祕");
							break;
						case 67:
							if (!str.equals("C"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("��銝����������辣");
							break;
						case 68:
							if (!str.equals("D"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("��儔�����");
							break;
						case 69:
							if (!str.equals("E"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("�������");
							break;
						case 70:
							if (!str.equals("F"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("�������誑���澈������������");
							break;
						case 71:
							if (!str.equals("G"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("�������");
							break;
						case 72:
							if (!str.equals("H"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("蝬迂�摰��");
							break;
						case 73:
							if (!str.equals("I"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("�憍�");
							break;
						case 74:
							if (!str.equals("J"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("�憍��憭勗�戊�擗��");
							break;
						case 75:
							if (!str.equals("K"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("靘扛撠情撅��瘨仃��");
							break;
						case 76:
							if (!str.equals("L"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("�鈭犖銝餃��");
							break;
						case 77:
							if (!str.equals("M"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("蝬��誥甇Ｗ��迂�(撅����仃)-銝剝�圾蝝�");
							break;
						case 78:
							if (!str.equals("N"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("蝬��誥甇Ｗ��迂�(撅����仃)-��蝥���");
							break;
						case 79:
							if (!str.equals("O"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("蝬��誥甇Ｗ��迂�(撅����仃)-���極雿�");
							break;
						case 80:
							if (!str.equals("P"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("蝬��誥甇Ｗ��迂�(撅����仃)-�瑼Ｖ��");
							break;
						case 81:
							if (!str.equals("Q"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("蝬��誥甇Ｗ��迂�(撅����仃)-頧��蜓銝���");
							break;
						case 82:
							if (!str.equals("R"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("蝬��誥甇Ｗ��迂�(撅����仃)-����");
							break;
						case 83:
							if (!str.equals("S"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("蝬��誥甇Ｗ��迂�(撅����仃)-����");
							break;
						case 84:
							if (!str.equals("T"))
								break;
							iL03A01Q02Bean.setIlFbdrsn("甇颱滿");
							break;
						}

					} else {
						iL03A01Q02Bean.setIlFbdrsn("");
					}
					iL03A01Q02Bean
							.setIlMrkdt((!"".equals(objArr[58]) && objArr[58] != null) ? (String) objArr[58] : "");
					iL03A01Q02Bean
							.setIlMrkdc((!"".equals(objArr[59]) && objArr[59] != null) ? (String) objArr[59] : "");
					if (!"".equals(objArr[60]) && objArr[60] != null) {
						String str;
						switch ((str = (String) objArr[60]).hashCode()) {
						case 48:
							if (!str.equals("0"))
								break;
							iL03A01Q02Bean.setIlSbmttp("");
							break;
						case 49:
							if (!str.equals("1"))
								break;
							iL03A01Q02Bean.setIlSbmttp("���犖�獢�");
							break;
						case 50:
							if (!str.equals("2"))
								break;
							iL03A01Q02Bean.setIlSbmttp("霅血�銝餃�酉閮�");
							break;
						case 51:
							if (!str.equals("3"))
								break;
							iL03A01Q02Bean.setIlSbmttp("��蜓���");
							break;
						}

					} else {
						iL03A01Q02Bean.setIlSbmttp("");
					}
					iL03A01Q02Bean
							.setIlMissdt((!"".equals(objArr[61]) && objArr[61] != null) ? (String) objArr[61] : "");
					iL03A01Q02Bean
							.setIlSbmtdt((!"".equals(objArr[62]) && objArr[62] != null) ? (String) objArr[62] : "");
					if (!"".equals(objArr[63]) && objArr[63] != null) {
						String srchstnm = (String) objArr[63];
						for (int j = 0; j < srchstList.size(); j++) {
							if (srchstnm.equals(((IL07D) srchstList.get(j)).getSRCHST())) {
								iL03A01Q02Bean.setIlSrchst(((IL07D) srchstList.get(j)).getSRCHSTNM());
							}
						}
					} else {
						iL03A01Q02Bean.setIlSrchst("��畾澈隞�");
					}
					iL03A01Q02Bean
							.setIlFnddid((!"".equals(objArr[64]) && objArr[64] != null) ? (String) objArr[64] : "");
					iL03A01Q02Bean
							.setIlFnddt((!"".equals(objArr[65]) && objArr[65] != null) ? (String) objArr[65] : "");
					iL03A01Q02Bean
							.setIlOldarc((!"".equals(objArr[66]) && objArr[66] != null) ? (String) objArr[66] : "");
					iL03A01Q02Bean.setIlHcst((!"".equals(objArr[67]) && objArr[67] != null) ? (String) objArr[67] : "");
					iL03A01Q02Bean
							.setIlHcctr((!"".equals(objArr[68]) && objArr[68] != null) ? (String) objArr[68] : "");
					iL03A01Q02Bean.setIlLmd((!"".equals(objArr[69]) && objArr[69] != null) ? (String) objArr[69] : "");
					iL03A01Q02Bean
							.setIlFstapydt((!"".equals(objArr[70]) && objArr[70] != null) ? (String) objArr[70] : "");
					iL03A01Q02Bean
							.setIlRepmdcNic((!"".equals(objArr[71]) && objArr[71] != null) ? (String) objArr[71] : "");
					iL03A01Q02Bean
							.setIlForfere((!"".equals(objArr[72]) && objArr[72] != null) ? (String) objArr[72] : "");
					iL03A01Q02Bean
							.setIl12ArcId((!"".equals(objArr[73]) && objArr[73] != null) ? (String) objArr[73] : "");
					iL03A01Q02Bean.setIlNTNM((!"".equals(objArr[74]) && objArr[74] != null) ? (String) objArr[74] : "");
					iL03A01Q02Bean
							.setIlMANTYPE((!"".equals(objArr[75]) && objArr[75] != null) ? (String) objArr[75] : "");
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
		List<Iltb01Main> list = new ArrayList<>();
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
		List<Iltb01Main> list = new ArrayList<>();
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
		List<Iltb01Main> list = new ArrayList<>();
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
		List<Iltb01Main> list = new ArrayList<>();
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
			if (!"".equals(ilPstext) && ilPstext != null) {
				sqlStr.append(" AND IL_PSTEXT='" + ilPstext + "'");
			}
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
		List<Iltb01Main> list = new ArrayList<>();
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
		List<Iltb01Main> list = new ArrayList<>();
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
		List<Iltb01Main> list = new ArrayList<>();
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
