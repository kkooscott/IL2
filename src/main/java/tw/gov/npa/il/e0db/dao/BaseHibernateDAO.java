package tw.gov.npa.il.e0db.dao;

import org.hibernate.Session;
import tw.gov.npa.il.dao.IBaseHibernateDAO;

public class BaseHibernateDAO implements IBaseHibernateDAO {
  public Session getSession() {
    return HibernateSessionFactoryE0DB.getSession();
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\e0db\dao\BaseHibernateDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */