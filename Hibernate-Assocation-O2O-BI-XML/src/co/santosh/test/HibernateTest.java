package co.santosh.test;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.santosh.hbm.o2o.bi.Number;
import co.santosh.hbm.o2o.bi.Alphabet;

public class HibernateTest {
	static Scanner console = new Scanner(System.in);
	static Session session = null;
	static Transaction transaction = null;
	
	public static void main(String args[]){
		try{
			SessionFactory sessionfactory = HibernateUtils.getSessionFactory();
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			
			Alphabet alpha1 = new Alphabet();
			alpha1.setAlphaName("One");
			session.save(alpha1);
			
			Number num1 = new Number();
			num1.setNumName("1");
			num1.setAlphabet(alpha1);
			session.save(num1);
			
			
			//alpha1.setNumber(num1);
			
			Alphabet alpha2 = new Alphabet();
			alpha2.setAlphaName("Two");
			session.save(alpha2);
			
			Number num2 = new Number();
			num2.setNumName("2");
			num2.setAlphabet(alpha2);
			session.save(num2);
			
			
			//alpha2.setNumber(num2);
			
			
			Alphabet alpha3 = new Alphabet();
			alpha3.setAlphaName("Three");
			session.save(alpha3);
			

			Number num3 = new Number();
			num3.setNumName("3");
			num3.setAlphabet(alpha3);
			session.save(num3);
			
			
			//alpha3.setNumber(num3);
			
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


