package tw.gov.npa.il.dao;

import java.io.Serializable;
import java.sql.Timestamp;

public class TmpIltb01 implements Serializable {
  private Integer ilArcid;
  
  private String ilArctp;
  
  private String ilArccs;
  
  private String ilEnm;
  
  private String ilCnm;
  
  private String ilSex;
  
  private String ilBthdt;
  
  private String ilNtcd;
  
  private String ilPspt;
  
  private Timestamp ilPsdt;
  
  private String ilMst;
  
  private String ilEdu;
  
  private Timestamp ilIndt;
  
  private Timestamp ilExdt;
  
  private String ilArcrsn;
  
  private String ilArcst;
  
  private String ilJbcd;
  
  private String ilJbpsn;
  
  private String ilOfcd;
  
  private String ilOfnm;
  
  private String ilOftel;
  
  private String ilOfnmbf;
  
  private String ilJbpzone;
  
  private String ilJbaddr;
  
  private String ilJbtel;
  
  private String ilArpzone;
  
  private String ilAraddr;
  
  private String ilArtel;
  
  private String ilAgnco;
  
  private String ilAgntel;
  
  private String ilJbpmcd;
  
  private String ilJbpmdc;
  
  private Timestamp ilJbpmdt;
  
  private Timestamp ilJbpmfm;
  
  private Timestamp ilJbpmto;
  
  private String ilMicro;
  
  private Timestamp ilApydt;
  
  private String ilArcrcp;
  
  private String ilArcno;
  
  private Timestamp ilArcfm;
  
  private Timestamp ilArcto;
  
  private String ilPst;
  
  private String ilPhq;
  
  private String ilPstext;
  
  private String ilRemrk;
  
  private String ilArcisu;
  
  private String ilFrshp;
  
  private String ilFnm;
  
  private String ilFpid;
  
  private String ilFntcd;
  
  private String ilFrcexit;
  
  private Timestamp ilReapydt;
  
  private String ilRetp;
  
  private String ilRepmdc;
  
  private Timestamp ilRepmdt;
  
  private String ilRrnote;
  
  private String ilMrkcs;
  
  private String ilFbdrsn;
  
  private Timestamp ilMrkdt;
  
  private String ilMrkdc;
  
  private String ilSbmttp;
  
  private Timestamp ilMissdt;
  
  private Timestamp ilSbmtdt;
  
  private String ilSrchst;
  
  private String ilFnddid;
  
  private Timestamp ilFnddt;
  
  private String ilOldarc;
  
  private String ilHcst;
  
  private Short ilHcctr;
  
  private Timestamp ilLmd;
  
  private Timestamp ilFstapydt;
  
  private String ilRepmdcNic;
  
  private String ilForfere;
  
  public TmpIltb01() {}
  
  public TmpIltb01(String ilArctp, String ilArccs, String ilEnm, String ilSex, String ilBthdt, String ilNtcd, String ilMst, String ilEdu, Timestamp ilIndt, String ilArcrsn, String ilArcst, String ilJbcd, String ilArpzone, String ilAraddr, String ilJbpmcd, Timestamp ilApydt, String ilArcrcp, String ilArcno, Timestamp ilArcfm, String ilPst, String ilPhq, String ilArcisu, String ilFrshp, String ilFrcexit, String ilRetp, String ilMrkcs, String ilFbdrsn, String ilSbmttp, String ilSrchst, String ilOldarc, Timestamp ilLmd, Timestamp ilFstapydt) {
    this.ilArctp = ilArctp;
    this.ilArccs = ilArccs;
    this.ilEnm = ilEnm;
    this.ilSex = ilSex;
    this.ilBthdt = ilBthdt;
    this.ilNtcd = ilNtcd;
    this.ilMst = ilMst;
    this.ilEdu = ilEdu;
    this.ilIndt = ilIndt;
    this.ilArcrsn = ilArcrsn;
    this.ilArcst = ilArcst;
    this.ilJbcd = ilJbcd;
    this.ilArpzone = ilArpzone;
    this.ilAraddr = ilAraddr;
    this.ilJbpmcd = ilJbpmcd;
    this.ilApydt = ilApydt;
    this.ilArcrcp = ilArcrcp;
    this.ilArcno = ilArcno;
    this.ilArcfm = ilArcfm;
    this.ilPst = ilPst;
    this.ilPhq = ilPhq;
    this.ilArcisu = ilArcisu;
    this.ilFrshp = ilFrshp;
    this.ilFrcexit = ilFrcexit;
    this.ilRetp = ilRetp;
    this.ilMrkcs = ilMrkcs;
    this.ilFbdrsn = ilFbdrsn;
    this.ilSbmttp = ilSbmttp;
    this.ilSrchst = ilSrchst;
    this.ilOldarc = ilOldarc;
    this.ilLmd = ilLmd;
    this.ilFstapydt = ilFstapydt;
  }
  
  public TmpIltb01(String ilArctp, String ilArccs, String ilEnm, String ilCnm, String ilSex, String ilBthdt, String ilNtcd, String ilPspt, Timestamp ilPsdt, String ilMst, String ilEdu, Timestamp ilIndt, Timestamp ilExdt, String ilArcrsn, String ilArcst, String ilJbcd, String ilJbpsn, String ilOfcd, String ilOfnm, String ilOftel, String ilOfnmbf, String ilJbpzone, String ilJbaddr, String ilJbtel, String ilArpzone, String ilAraddr, String ilArtel, String ilAgnco, String ilAgntel, String ilJbpmcd, String ilJbpmdc, Timestamp ilJbpmdt, Timestamp ilJbpmfm, Timestamp ilJbpmto, String ilMicro, Timestamp ilApydt, String ilArcrcp, String ilArcno, Timestamp ilArcfm, Timestamp ilArcto, String ilPst, String ilPhq, String ilPstext, String ilRemrk, String ilArcisu, String ilFrshp, String ilFnm, String ilFpid, String ilFntcd, String ilFrcexit, Timestamp ilReapydt, String ilRetp, String ilRepmdc, Timestamp ilRepmdt, String ilRrnote, String ilMrkcs, String ilFbdrsn, Timestamp ilMrkdt, String ilMrkdc, String ilSbmttp, Timestamp ilMissdt, Timestamp ilSbmtdt, String ilSrchst, String ilFnddid, Timestamp ilFnddt, String ilOldarc, String ilHcst, Short ilHcctr, Timestamp ilLmd, Timestamp ilFstapydt, String ilRepmdcNic, String ilForfere) {
    this.ilArctp = ilArctp;
    this.ilArccs = ilArccs;
    this.ilEnm = ilEnm;
    this.ilCnm = ilCnm;
    this.ilSex = ilSex;
    this.ilBthdt = ilBthdt;
    this.ilNtcd = ilNtcd;
    this.ilPspt = ilPspt;
    this.ilPsdt = ilPsdt;
    this.ilMst = ilMst;
    this.ilEdu = ilEdu;
    this.ilIndt = ilIndt;
    this.ilExdt = ilExdt;
    this.ilArcrsn = ilArcrsn;
    this.ilArcst = ilArcst;
    this.ilJbcd = ilJbcd;
    this.ilJbpsn = ilJbpsn;
    this.ilOfcd = ilOfcd;
    this.ilOfnm = ilOfnm;
    this.ilOftel = ilOftel;
    this.ilOfnmbf = ilOfnmbf;
    this.ilJbpzone = ilJbpzone;
    this.ilJbaddr = ilJbaddr;
    this.ilJbtel = ilJbtel;
    this.ilArpzone = ilArpzone;
    this.ilAraddr = ilAraddr;
    this.ilArtel = ilArtel;
    this.ilAgnco = ilAgnco;
    this.ilAgntel = ilAgntel;
    this.ilJbpmcd = ilJbpmcd;
    this.ilJbpmdc = ilJbpmdc;
    this.ilJbpmdt = ilJbpmdt;
    this.ilJbpmfm = ilJbpmfm;
    this.ilJbpmto = ilJbpmto;
    this.ilMicro = ilMicro;
    this.ilApydt = ilApydt;
    this.ilArcrcp = ilArcrcp;
    this.ilArcno = ilArcno;
    this.ilArcfm = ilArcfm;
    this.ilArcto = ilArcto;
    this.ilPst = ilPst;
    this.ilPhq = ilPhq;
    this.ilPstext = ilPstext;
    this.ilRemrk = ilRemrk;
    this.ilArcisu = ilArcisu;
    this.ilFrshp = ilFrshp;
    this.ilFnm = ilFnm;
    this.ilFpid = ilFpid;
    this.ilFntcd = ilFntcd;
    this.ilFrcexit = ilFrcexit;
    this.ilReapydt = ilReapydt;
    this.ilRetp = ilRetp;
    this.ilRepmdc = ilRepmdc;
    this.ilRepmdt = ilRepmdt;
    this.ilRrnote = ilRrnote;
    this.ilMrkcs = ilMrkcs;
    this.ilFbdrsn = ilFbdrsn;
    this.ilMrkdt = ilMrkdt;
    this.ilMrkdc = ilMrkdc;
    this.ilSbmttp = ilSbmttp;
    this.ilMissdt = ilMissdt;
    this.ilSbmtdt = ilSbmtdt;
    this.ilSrchst = ilSrchst;
    this.ilFnddid = ilFnddid;
    this.ilFnddt = ilFnddt;
    this.ilOldarc = ilOldarc;
    this.ilHcst = ilHcst;
    this.ilHcctr = ilHcctr;
    this.ilLmd = ilLmd;
    this.ilFstapydt = ilFstapydt;
    this.ilRepmdcNic = ilRepmdcNic;
    this.ilForfere = ilForfere;
  }
  
  public Integer getIlArcid() {
    return this.ilArcid;
  }
  
  public void setIlArcid(Integer ilArcid) {
    this.ilArcid = ilArcid;
  }
  
  public String getIlArctp() {
    return this.ilArctp;
  }
  
  public void setIlArctp(String ilArctp) {
    this.ilArctp = ilArctp;
  }
  
  public String getIlArccs() {
    return this.ilArccs;
  }
  
  public void setIlArccs(String ilArccs) {
    this.ilArccs = ilArccs;
  }
  
  public String getIlEnm() {
    return this.ilEnm;
  }
  
  public void setIlEnm(String ilEnm) {
    this.ilEnm = ilEnm;
  }
  
  public String getIlCnm() {
    return this.ilCnm;
  }
  
  public void setIlCnm(String ilCnm) {
    this.ilCnm = ilCnm;
  }
  
  public String getIlSex() {
    return this.ilSex;
  }
  
  public void setIlSex(String ilSex) {
    this.ilSex = ilSex;
  }
  
  public String getIlBthdt() {
    return this.ilBthdt;
  }
  
  public void setIlBthdt(String ilBthdt) {
    this.ilBthdt = ilBthdt;
  }
  
  public String getIlNtcd() {
    return this.ilNtcd;
  }
  
  public void setIlNtcd(String ilNtcd) {
    this.ilNtcd = ilNtcd;
  }
  
  public String getIlPspt() {
    return this.ilPspt;
  }
  
  public void setIlPspt(String ilPspt) {
    this.ilPspt = ilPspt;
  }
  
  public Timestamp getIlPsdt() {
    return this.ilPsdt;
  }
  
  public void setIlPsdt(Timestamp ilPsdt) {
    this.ilPsdt = ilPsdt;
  }
  
  public String getIlMst() {
    return this.ilMst;
  }
  
  public void setIlMst(String ilMst) {
    this.ilMst = ilMst;
  }
  
  public String getIlEdu() {
    return this.ilEdu;
  }
  
  public void setIlEdu(String ilEdu) {
    this.ilEdu = ilEdu;
  }
  
  public Timestamp getIlIndt() {
    return this.ilIndt;
  }
  
  public void setIlIndt(Timestamp ilIndt) {
    this.ilIndt = ilIndt;
  }
  
  public Timestamp getIlExdt() {
    return this.ilExdt;
  }
  
  public void setIlExdt(Timestamp ilExdt) {
    this.ilExdt = ilExdt;
  }
  
  public String getIlArcrsn() {
    return this.ilArcrsn;
  }
  
  public void setIlArcrsn(String ilArcrsn) {
    this.ilArcrsn = ilArcrsn;
  }
  
  public String getIlArcst() {
    return this.ilArcst;
  }
  
  public void setIlArcst(String ilArcst) {
    this.ilArcst = ilArcst;
  }
  
  public String getIlJbcd() {
    return this.ilJbcd;
  }
  
  public void setIlJbcd(String ilJbcd) {
    this.ilJbcd = ilJbcd;
  }
  
  public String getIlJbpsn() {
    return this.ilJbpsn;
  }
  
  public void setIlJbpsn(String ilJbpsn) {
    this.ilJbpsn = ilJbpsn;
  }
  
  public String getIlOfcd() {
    return this.ilOfcd;
  }
  
  public void setIlOfcd(String ilOfcd) {
    this.ilOfcd = ilOfcd;
  }
  
  public String getIlOfnm() {
    return this.ilOfnm;
  }
  
  public void setIlOfnm(String ilOfnm) {
    this.ilOfnm = ilOfnm;
  }
  
  public String getIlOftel() {
    return this.ilOftel;
  }
  
  public void setIlOftel(String ilOftel) {
    this.ilOftel = ilOftel;
  }
  
  public String getIlOfnmbf() {
    return this.ilOfnmbf;
  }
  
  public void setIlOfnmbf(String ilOfnmbf) {
    this.ilOfnmbf = ilOfnmbf;
  }
  
  public String getIlJbpzone() {
    return this.ilJbpzone;
  }
  
  public void setIlJbpzone(String ilJbpzone) {
    this.ilJbpzone = ilJbpzone;
  }
  
  public String getIlJbaddr() {
    return this.ilJbaddr;
  }
  
  public void setIlJbaddr(String ilJbaddr) {
    this.ilJbaddr = ilJbaddr;
  }
  
  public String getIlJbtel() {
    return this.ilJbtel;
  }
  
  public void setIlJbtel(String ilJbtel) {
    this.ilJbtel = ilJbtel;
  }
  
  public String getIlArpzone() {
    return this.ilArpzone;
  }
  
  public void setIlArpzone(String ilArpzone) {
    this.ilArpzone = ilArpzone;
  }
  
  public String getIlAraddr() {
    return this.ilAraddr;
  }
  
  public void setIlAraddr(String ilAraddr) {
    this.ilAraddr = ilAraddr;
  }
  
  public String getIlArtel() {
    return this.ilArtel;
  }
  
  public void setIlArtel(String ilArtel) {
    this.ilArtel = ilArtel;
  }
  
  public String getIlAgnco() {
    return this.ilAgnco;
  }
  
  public void setIlAgnco(String ilAgnco) {
    this.ilAgnco = ilAgnco;
  }
  
  public String getIlAgntel() {
    return this.ilAgntel;
  }
  
  public void setIlAgntel(String ilAgntel) {
    this.ilAgntel = ilAgntel;
  }
  
  public String getIlJbpmcd() {
    return this.ilJbpmcd;
  }
  
  public void setIlJbpmcd(String ilJbpmcd) {
    this.ilJbpmcd = ilJbpmcd;
  }
  
  public String getIlJbpmdc() {
    return this.ilJbpmdc;
  }
  
  public void setIlJbpmdc(String ilJbpmdc) {
    this.ilJbpmdc = ilJbpmdc;
  }
  
  public Timestamp getIlJbpmdt() {
    return this.ilJbpmdt;
  }
  
  public void setIlJbpmdt(Timestamp ilJbpmdt) {
    this.ilJbpmdt = ilJbpmdt;
  }
  
  public Timestamp getIlJbpmfm() {
    return this.ilJbpmfm;
  }
  
  public void setIlJbpmfm(Timestamp ilJbpmfm) {
    this.ilJbpmfm = ilJbpmfm;
  }
  
  public Timestamp getIlJbpmto() {
    return this.ilJbpmto;
  }
  
  public void setIlJbpmto(Timestamp ilJbpmto) {
    this.ilJbpmto = ilJbpmto;
  }
  
  public String getIlMicro() {
    return this.ilMicro;
  }
  
  public void setIlMicro(String ilMicro) {
    this.ilMicro = ilMicro;
  }
  
  public Timestamp getIlApydt() {
    return this.ilApydt;
  }
  
  public void setIlApydt(Timestamp ilApydt) {
    this.ilApydt = ilApydt;
  }
  
  public String getIlArcrcp() {
    return this.ilArcrcp;
  }
  
  public void setIlArcrcp(String ilArcrcp) {
    this.ilArcrcp = ilArcrcp;
  }
  
  public String getIlArcno() {
    return this.ilArcno;
  }
  
  public void setIlArcno(String ilArcno) {
    this.ilArcno = ilArcno;
  }
  
  public Timestamp getIlArcfm() {
    return this.ilArcfm;
  }
  
  public void setIlArcfm(Timestamp ilArcfm) {
    this.ilArcfm = ilArcfm;
  }
  
  public Timestamp getIlArcto() {
    return this.ilArcto;
  }
  
  public void setIlArcto(Timestamp ilArcto) {
    this.ilArcto = ilArcto;
  }
  
  public String getIlPst() {
    return this.ilPst;
  }
  
  public void setIlPst(String ilPst) {
    this.ilPst = ilPst;
  }
  
  public String getIlPhq() {
    return this.ilPhq;
  }
  
  public void setIlPhq(String ilPhq) {
    this.ilPhq = ilPhq;
  }
  
  public String getIlPstext() {
    return this.ilPstext;
  }
  
  public void setIlPstext(String ilPstext) {
    this.ilPstext = ilPstext;
  }
  
  public String getIlRemrk() {
    return this.ilRemrk;
  }
  
  public void setIlRemrk(String ilRemrk) {
    this.ilRemrk = ilRemrk;
  }
  
  public String getIlArcisu() {
    return this.ilArcisu;
  }
  
  public void setIlArcisu(String ilArcisu) {
    this.ilArcisu = ilArcisu;
  }
  
  public String getIlFrshp() {
    return this.ilFrshp;
  }
  
  public void setIlFrshp(String ilFrshp) {
    this.ilFrshp = ilFrshp;
  }
  
  public String getIlFnm() {
    return this.ilFnm;
  }
  
  public void setIlFnm(String ilFnm) {
    this.ilFnm = ilFnm;
  }
  
  public String getIlFpid() {
    return this.ilFpid;
  }
  
  public void setIlFpid(String ilFpid) {
    this.ilFpid = ilFpid;
  }
  
  public String getIlFntcd() {
    return this.ilFntcd;
  }
  
  public void setIlFntcd(String ilFntcd) {
    this.ilFntcd = ilFntcd;
  }
  
  public String getIlFrcexit() {
    return this.ilFrcexit;
  }
  
  public void setIlFrcexit(String ilFrcexit) {
    this.ilFrcexit = ilFrcexit;
  }
  
  public Timestamp getIlReapydt() {
    return this.ilReapydt;
  }
  
  public void setIlReapydt(Timestamp ilReapydt) {
    this.ilReapydt = ilReapydt;
  }
  
  public String getIlRetp() {
    return this.ilRetp;
  }
  
  public void setIlRetp(String ilRetp) {
    this.ilRetp = ilRetp;
  }
  
  public String getIlRepmdc() {
    return this.ilRepmdc;
  }
  
  public void setIlRepmdc(String ilRepmdc) {
    this.ilRepmdc = ilRepmdc;
  }
  
  public Timestamp getIlRepmdt() {
    return this.ilRepmdt;
  }
  
  public void setIlRepmdt(Timestamp ilRepmdt) {
    this.ilRepmdt = ilRepmdt;
  }
  
  public String getIlRrnote() {
    return this.ilRrnote;
  }
  
  public void setIlRrnote(String ilRrnote) {
    this.ilRrnote = ilRrnote;
  }
  
  public String getIlMrkcs() {
    return this.ilMrkcs;
  }
  
  public void setIlMrkcs(String ilMrkcs) {
    this.ilMrkcs = ilMrkcs;
  }
  
  public String getIlFbdrsn() {
    return this.ilFbdrsn;
  }
  
  public void setIlFbdrsn(String ilFbdrsn) {
    this.ilFbdrsn = ilFbdrsn;
  }
  
  public Timestamp getIlMrkdt() {
    return this.ilMrkdt;
  }
  
  public void setIlMrkdt(Timestamp ilMrkdt) {
    this.ilMrkdt = ilMrkdt;
  }
  
  public String getIlMrkdc() {
    return this.ilMrkdc;
  }
  
  public void setIlMrkdc(String ilMrkdc) {
    this.ilMrkdc = ilMrkdc;
  }
  
  public String getIlSbmttp() {
    return this.ilSbmttp;
  }
  
  public void setIlSbmttp(String ilSbmttp) {
    this.ilSbmttp = ilSbmttp;
  }
  
  public Timestamp getIlMissdt() {
    return this.ilMissdt;
  }
  
  public void setIlMissdt(Timestamp ilMissdt) {
    this.ilMissdt = ilMissdt;
  }
  
  public Timestamp getIlSbmtdt() {
    return this.ilSbmtdt;
  }
  
  public void setIlSbmtdt(Timestamp ilSbmtdt) {
    this.ilSbmtdt = ilSbmtdt;
  }
  
  public String getIlSrchst() {
    return this.ilSrchst;
  }
  
  public void setIlSrchst(String ilSrchst) {
    this.ilSrchst = ilSrchst;
  }
  
  public String getIlFnddid() {
    return this.ilFnddid;
  }
  
  public void setIlFnddid(String ilFnddid) {
    this.ilFnddid = ilFnddid;
  }
  
  public Timestamp getIlFnddt() {
    return this.ilFnddt;
  }
  
  public void setIlFnddt(Timestamp ilFnddt) {
    this.ilFnddt = ilFnddt;
  }
  
  public String getIlOldarc() {
    return this.ilOldarc;
  }
  
  public void setIlOldarc(String ilOldarc) {
    this.ilOldarc = ilOldarc;
  }
  
  public String getIlHcst() {
    return this.ilHcst;
  }
  
  public void setIlHcst(String ilHcst) {
    this.ilHcst = ilHcst;
  }
  
  public Short getIlHcctr() {
    return this.ilHcctr;
  }
  
  public void setIlHcctr(Short ilHcctr) {
    this.ilHcctr = ilHcctr;
  }
  
  public Timestamp getIlLmd() {
    return this.ilLmd;
  }
  
  public void setIlLmd(Timestamp ilLmd) {
    this.ilLmd = ilLmd;
  }
  
  public Timestamp getIlFstapydt() {
    return this.ilFstapydt;
  }
  
  public void setIlFstapydt(Timestamp ilFstapydt) {
    this.ilFstapydt = ilFstapydt;
  }
  
  public String getIlRepmdcNic() {
    return this.ilRepmdcNic;
  }
  
  public void setIlRepmdcNic(String ilRepmdcNic) {
    this.ilRepmdcNic = ilRepmdcNic;
  }
  
  public String getIlForfere() {
    return this.ilForfere;
  }
  
  public void setIlForfere(String ilForfere) {
    this.ilForfere = ilForfere;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\TmpIltb01.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */