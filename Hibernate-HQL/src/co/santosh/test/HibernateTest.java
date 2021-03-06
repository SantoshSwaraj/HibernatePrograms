package co.santosh.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.santosh.pojo.Employee;

public class HibernateTest {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try{
			SessionFactory sessionfactory = HibernateUtils.getSessionFactory();
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
		
			Employee emp1 = new Employee();
			emp1.setEmpName("Keshav");
			emp1.setSalary(15000);
			session.save(emp1);
			
			Employee emp2 = new Employee();
			emp2.setEmpName("Rahul");
			emp2.setSalary(20000);
			session.save(emp2);
			
			Employee emp3 = new Employee();
			emp3.setEmpName("Pradeep");
			emp3.setSalary(25000);
			session.save(emp3);
			
			/*Query query = session.createQuery("from Employee");
			List empList = query.list();
			
			for(Object emp : empList){	  
				System.out.println(emp);
			}*/
			
			Query query1 = session.createQuery("select employee1.empName, employee1.salary from Employee as employee1");
			List empList1 = query1.list();
			
			System.out.println("-------------------------------");
			System.out.println("Emp_Name\t|\tSalary");
			System.out.println("-------------------------------");
			for(Object obj : empList1){
				Object[] result = (Object[])obj;
				System.out.println(""+result[0]+"\t\t"+"|\t"+result[1]);
			}
			
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

