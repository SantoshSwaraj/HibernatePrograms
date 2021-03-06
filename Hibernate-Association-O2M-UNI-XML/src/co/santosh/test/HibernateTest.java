package co.santosh.test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.santosh.hbm.o2m.uni.Address;
import co.santosh.hbm.o2m.uni.Employee;



public class HibernateTest {
	static Scanner console = new Scanner(System.in);
	static Session session = null;
	static Transaction transaction = null;
	
	public static void main(String args[]){
		try{
			SessionFactory sessionfactory = HibernateUtils.getSessionFactory();
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			

			Set<Address> addresses = new HashSet<Address>();
			Address addr1 = new Address();
			addr1.setHouseName("PremVila");
			addr1.setStreet("Ring Road");
			addr1.setCity("Pune");
			addresses.add(addr1);
			
			Address addr2 = new Address();
			addr2.setHouseName("AkashVihar");
			addr2.setStreet("Pawal");
			addr2.setCity("Mumbai");
			addresses.add(addr2);
			
			Employee emp1 = new Employee();
			emp1.setEmpName("Santosh");
			emp1.setAddresses(addresses);
			
			session.save(emp1);
			transaction.commit();
			
		}
		catch(HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}
		finally{
			session.close();
		}
	}
}

