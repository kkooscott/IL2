package tw.gov.npa.il.e0db.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryE0DB {
	private static String CONFIG_FILE_LOCATION = "/hibernateE0DB.cfg.xml";

	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

	private static Configuration configuration = (Configuration) new AnnotationConfiguration();

	private static SessionFactory sessionFactory;

	private static String configFile = CONFIG_FILE_LOCATION;

	static {
		try {
			configuration.configure(configFile);
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			System.err.println("%%%% Error Creating SessionFactory %%%%");
			e.printStackTrace();
		}
	}

	public static Session getSession() throws HibernateException {
		Session session = (Session) threadLocal.get();

		if (session == null || !session.isOpen()) {
			if (sessionFactory == null) {
				rebuildSessionFactory();
			}
			session = (sessionFactory != null) ? sessionFactory.openSession() : null;
			threadLocal.set(session);
		}

		return session;
	}

	public static void rebuildSessionFactory() {
		try {
			configuration.configure(configFile);
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			System.err.println("%%%% Error Creating SessionFactory %%%%");
			e.printStackTrace();
		}
	}

	public static void closeSession() throws HibernateException {
		Session session = threadLocal.get();
		threadLocal.set(null);
		if (session != null)
			session.close();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void setConfigFile(String configFile) {
		HibernateSessionFactoryE0DB.configFile = configFile;
		sessionFactory = null;
	}

	public static Configuration getConfiguration() {
		return configuration;
	}
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\e0db\dao\
 * HibernateSessionFactoryE0DB.class Java compiler version: 5 (49.0) JD-Core
 * Version: 1.1.3
 */