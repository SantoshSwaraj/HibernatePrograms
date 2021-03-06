package co.santosh.test;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sessionfactory = null;
	static{
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder.applySettings(configuration.getProperties());
		sessionfactory = configuration.buildSessionFactory(builder.build()); 
	}
	public static SessionFactory getSessionFactory(){
		return sessionfactory;
	}
}


