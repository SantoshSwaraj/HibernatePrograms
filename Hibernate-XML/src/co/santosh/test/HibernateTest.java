package co.santosh.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.santosh.hbm.Student;

public class HibernateTest {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try{
			SessionFactory sessionfactory = HibernateUtils.getSessionFactory();
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
		
			Student student1 = new Student();
			student1.setName("Santosh");
			student1.setDept("CS");
			
			session.save(student1);
			transaction.commit();
		}
		catch(HibernateException e){
			e.printStackTrace();
			transaction.rollback();
		
		}
		finally{
			session.close();
		}
	}

}
