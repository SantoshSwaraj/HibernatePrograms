package co.santosh.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.santosh.hbm.Student;

public class HibernateTest {
	public static void main(String []args){
		SessionFactory sessionfactory = HibernateUtils.getSessionFactory();
		Session session = null;
		Transaction transaction = null;
		try{
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			
			Student stud1 = new Student();
			stud1.setName("Amit");
			stud1.setDept("Maths");
			session.save(stud1);
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