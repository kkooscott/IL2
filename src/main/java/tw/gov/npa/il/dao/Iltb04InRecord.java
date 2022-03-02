package tw.gov.npa.il.dao;

import java.io.Serializable;
import java.sql.Timestamp;

public class Iltb04InRecord implements Serializable {
  private Iltb04InRecordId id;
  
  private String ilPtrlst;
  
  private String ilPtrlmrk;
  
  private String ilUid;
  
  private String ilUnm;
  
  private Timestamp ilLmd;
  
  private String ilMantype;
  
  public Iltb04InRecord() {}
  
  public Iltb04InRecord(Iltb04InRecordId id, String ilPtrlst, String ilUid, String ilUnm, Timestamp ilLmd) {
    this.id = id;
    this.ilPtrlst = ilPtrlst;
    this.ilUid = ilUid;
    this.ilUnm = ilUnm;
    this.ilLmd = ilLmd;
  }
  
  public Iltb04InRecord(Iltb04InRecordId id, String ilPtrlst, String ilPtrlmrk, String ilUid, String ilUnm, Timestamp ilLmd, String ilMantype) {
    this.id = id;
    this.ilPtrlst = ilPtrlst;
    this.ilPtrlmrk = ilPtrlmrk;
    this.ilUid = ilUid;
    this.ilUnm = ilUnm;
    this.ilLmd = ilLmd;
    this.ilMantype = ilMantype;
  }
  
  public Iltb04InRecordId getId() {
    return this.id;
  }
  
  public void setId(Iltb04InRecordId id) {
    this.id = id;
  }
  
  public String getIlPtrlst() {
    return this.ilPtrlst;
  }
  
  public void setIlPtrlst(String ilPtrlst) {
    this.ilPtrlst = ilPtrlst;
  }
  
  public String getIlPtrlmrk() {
    return this.ilPtrlmrk;
  }
  
  public void setIlPtrlmrk(String ilPtrlmrk) {
    this.ilPtrlmrk = ilPtrlmrk;
  }
  
  public String getIlUid() {
    return this.ilUid;
  }
  
  public void setIlUid(String ilUid) {
    this.ilUid = ilUid;
  }
  
  public String getIlUnm() {
    return this.ilUnm;
  }
  
  public void setIlUnm(String ilUnm) {
    this.ilUnm = ilUnm;
  }
  
  public Timestamp getIlLmd() {
    return this.ilLmd;
  }
  
  public void setIlLmd(Timestamp ilLmd) {
    this.ilLmd = ilLmd;
  }
  
  public String getIlMantype() {
    return this.ilMantype;
  }
  
  public void setIlMantype(String ilMantype) {
    this.ilMantype = ilMantype;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\Iltb04InRecord.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */