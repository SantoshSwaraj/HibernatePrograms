package co.santosh.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.santosh.hbm.ContractEmployee;
import co.santosh.hbm.PermanentEmployee;


public class HibernateTest {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try{
			SessionFactory sessionfactory = HibernateUtils.getSessionFactory();
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			
			ContractEmployee ce1 = new ContractEmployee();
			ce1.setName("Santosh");
			ce1.setHourlyPayment(8000);
			
			
			ContractEmployee ce2 = new ContractEmployee();
			ce2.setName("Pradeep");
			ce2.setHourlyPayment(8500);
			
			
			PermanentEmployee pe1 = new PermanentEmployee();
			pe1.setName("Ashok");
			pe1.setMonthlySal(15000);
			
			
			PermanentEmployee pe2 = new PermanentEmployee();
			pe2.setName("Rakesh");
			pe2.setMonthlySal(20000);
		
			session.save(ce1);
			session.save(ce2);
			session.save(pe1);
			session.save(pe2);
		
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

