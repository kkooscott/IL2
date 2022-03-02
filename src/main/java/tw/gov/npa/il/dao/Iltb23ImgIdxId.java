package tw.gov.npa.il.dao;

import java.io.Serializable;

public class Iltb23ImgIdxId implements Serializable {
  private String ilImgid;
  
  private String ilIdno;
  
  private String ilIdseq;
  
  private String ilNtcd;
  
  public Iltb23ImgIdxId() {}
  
  public Iltb23ImgIdxId(String ilImgid, String ilIdno, String ilIdseq, String ilNtcd) {
    this.ilImgid = ilImgid;
    this.ilIdno = ilIdno;
    this.ilIdseq = ilIdseq;
    this.ilNtcd = ilNtcd;
  }
  
  public String getIlImgid() {
    return this.ilImgid;
  }
  
  public void setIlImgid(String ilImgid) {
    this.ilImgid = ilImgid;
  }
  
  public String getIlIdno() {
    return this.ilIdno;
  }
  
  public void setIlIdno(String ilIdno) {
    this.ilIdno = ilIdno;
  }
  
  public String getIlIdseq() {
    return this.ilIdseq;
  }
  
  public void setIlIdseq(String ilIdseq) {
    this.ilIdseq = ilIdseq;
  }
  
  public String getIlNtcd() {
    return this.ilNtcd;
  }
  
  public void setIlNtcd(String ilNtcd) {
    this.ilNtcd = ilNtcd;
  }
  
  public boolean equals(Object other) {
    if (this == other)
      return true; 
    if (other == null)
      return false; 
    if (!(other instanceof Iltb23ImgIdxId))
      return false; 
    Iltb23ImgIdxId castOther = (Iltb23ImgIdxId)other;
    return ((getIlImgid() == castOther.getIlImgid() || (getIlImgid() != null && castOther.getIlImgid() != null && getIlImgid().equals(castOther.getIlImgid()))) && (getIlIdno() == castOther.getIlIdno() || (getIlIdno() != null && castOther.getIlIdno() != null && getIlIdno().equals(castOther.getIlIdno()))) && (getIlIdseq() == castOther.getIlIdseq() || (getIlIdseq() != null && castOther.getIlIdseq() != null && getIlIdseq().equals(castOther.getIlIdseq()))) && (getIlNtcd() == castOther.getIlNtcd() || (getIlNtcd() != null && castOther.getIlNtcd() != null && getIlNtcd().equals(castOther.getIlNtcd()))));
  }
  
  public int hashCode() {
    int result = 17;
    result = 37 * result + ((getIlImgid() == null) ? 0 : getIlImgid().hashCode());
    result = 37 * result + ((getIlIdno() == null) ? 0 : getIlIdno().hashCode());
    result = 37 * result + ((getIlIdseq() == null) ? 0 : getIlIdseq().hashCode());
    result = 37 * result + ((getIlNtcd() == null) ? 0 : getIlNtcd().hashCode());
    return result;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\Iltb23ImgIdxId.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */