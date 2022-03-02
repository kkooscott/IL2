package tw.gov.npa.il.dao;

import org.hibernate.Session;

public class BaseHibernateDAO implements IBaseHibernateDAO {
  public Session getSession() {
    return HibernateSessionFactory.getSession();
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\dao\BaseHibernateDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */