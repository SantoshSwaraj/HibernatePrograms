package co.santosh.test;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.santosh.hbm.m2o.uni.Department;
import co.santosh.hbm.m2o.uni.Student;

public class HibernateTest {
	static Scanner console = new Scanner(System.in);
	static Session session = null;
	static Transaction transaction = null;
	
	public static void main(String args[]){
		try{
			SessionFactory sessionfactory = HibernateUtils.getSessionFactory();
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			
			Department dept1 = new Department();
			dept1.setDeptId(501);
			dept1.setDeptName("CS");
			session.save(dept1);
			
			Student stud1 = new Student();
			stud1.setSid(101);
			stud1.setName("Santosh");
			stud1.setDept(dept1);
			  
			session.save(stud1);
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
