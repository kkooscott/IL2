package tw.gov.npa.il.dao;

import java.io.Serializable;
import java.sql.Timestamp;

public class Iltb23ImgIdx implements Serializable {
  private Iltb23ImgIdxId id;
  
  private String ilName;
  
  private String ilBthdt;
  
  private String ilUnc;
  
  private String ilUrl;
  
  private String ilAp;
  
  private Timestamp ilModified;
  
  public Iltb23ImgIdx() {}
  
  public Iltb23ImgIdx(Iltb23ImgIdxId id, String ilName, String ilBthdt, String ilUnc, String ilUrl, String ilAp) {
    this.id = id;
    this.ilName = ilName;
    this.ilBthdt = ilBthdt;
    this.ilUnc = ilUnc;
    this.ilUrl = ilUrl;
    this.ilAp = ilAp;
  }
  
  public Iltb23ImgIdx(Iltb23ImgIdxId id, String ilName, String ilBthdt, String ilUnc, String ilUrl, String ilAp, Timestamp ilModified) {
    this.id = id;
    this.ilName = ilName;
    this.ilBthdt = ilBthdt;
    this.ilUnc = ilUnc;
    this.ilUrl = ilUrl;
    this.ilAp = ilAp;
    this.ilModified = ilModified;
  }
  
  public Iltb23ImgIdxId getId() {
    return this.id;
  }
  
  public void setId(Iltb23ImgIdxId id) {
    this.id = id;
  }
  
  public String getIlName() {
    return this.ilName;
  }
  
  public void setIlName(String ilName) {
    this.ilName = ilName;
  }
  
  public String getIlBthdt() {
    return this.ilBthdt;
  }
  
  public void setIlBthdt(String ilBthdt) {
    this.ilBthdt = ilBthdt;
  }
  
  public String getIlUnc() {
    return this.ilUnc;
  }
  
  public void setIlUnc(String ilUnc) {
    this.ilUnc = ilUnc;
  }
  
  public String getIlUrl() {
    return this.ilUrl;
  }
  
  public void setIlUrl(String ilUrl) {
    this.ilUrl = ilUrl;
  }
  
  public String getIlAp() {
    return this.ilAp;
  }
  
  public void setIlAp(String ilAp) {
    this.ilAp = ilAp;
  }
  
  public Timestamp getIlModified() {
    return this.ilModified;
  }
  
  public void setIlModified(Timestamp ilModified) {
    this.ilModified = ilModified;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\Iltb23ImgIdx.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */