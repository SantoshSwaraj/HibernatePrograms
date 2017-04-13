package co.santosh.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.santosh.hbm.m2m.bi.Employee;
import co.santosh.hbm.m2m.bi.Project;



public class HibernateTest {
	static Scanner console = new Scanner(System.in);
	static Session session = null;
	static Transaction transaction = null;
	
	public static void main(String args[]){
		try{
			SessionFactory sessionfactory = HibernateUtils.getSessionFactory();
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			
			Employee emp1 = new Employee();
			emp1.setEmpName("Santosh");
			session.save(emp1);
			
			Employee emp2 = new Employee();
			emp2.setEmpName("Deepak");
			session.save(emp2);
			
			Project proj1 = new Project();
			proj1.setProjName("BankProj");
			session.save(proj1);
			
			Project proj2 = new Project();
			proj2.setProjName("E-Commerce_Proj");
			session.save(proj2);
			
			Set<Project> projects1 = new HashSet<Project>();
			List<Project> projList = new ArrayList<Project>();
			projList.add(proj1);
			projList.add(proj2);
			projects1.addAll(projList);
			
			emp1.setProjects(projects1);
			session.save(emp1);
			
			/*Why employees1 not added in the emp_project table ?? 
			 * I have set inverse="true" in < set name="projects">
			 * But it does works
			 */
			Set<Employee> employees1 = new HashSet<Employee>();
			List<Employee> empList = new ArrayList<Employee>();
			empList.add(emp1);
			employees1.addAll(empList);
			
			proj1.setEmployees(employees1);
			session.save(proj1);
			
			
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



