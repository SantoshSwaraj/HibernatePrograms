package co.santosh.test;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.santosh.hbm.o2o.uni.Passport;
import co.santosh.hbm.o2o.uni.Person;

public class HibernateTest {
	static Scanner console = new Scanner(System.in);
	static Session session = null;
	static Transaction transaction = null;
	
	public static void main(String args[]){
		try{
			SessionFactory sessionfactory = HibernateUtils.getSessionFactory();
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			
			Passport passport1 = new Passport();
			passport1.setNationality("Indian");
			session.save(passport1);
			
			Person person1 = new Person();
			person1.setName("Santosh");
			person1.setPassport(passport1);
			
			/*Person person2 = new Person();
			person2.setName("Ayush");
			person2.setPassport(passport1);*/
			  
			session.save(person1);
			// session.save(person2);
			transaction.commit();
			
		}
		catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}
		finally{
			
		}
	}
}

