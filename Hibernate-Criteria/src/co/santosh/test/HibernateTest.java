package co.santosh.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

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
			
			Employee emp4 = new Employee();
			emp4.setEmpName("Sumit");
			emp4.setSalary(25000);
			session.save(emp4);
			
			Employee emp5 = new Employee();
			emp5.setEmpName("Anil");
			emp5.setSalary(30000);
			session.save(emp5);
			
			/*Criteria criteria = session.createCriteria(Employee.class);
			List emplist = criteria.list();
			
			for(Object obj : emplist){
				System.out.println(obj);
			}*/
			
			/*Criteria criteria = session.createCriteria(Employee.class);
			List emplist = (List) criteria.add(Restrictions.idEq(4)).list();
			
			for(Object obj : emplist){
				System.out.println(obj);
			}*/
			
			/*Criteria criteria = session.createCriteria(Employee.class);
			List emplist = criteria.add(Restrictions.between("salary", 15000, 20000)).list();
			
			for(Object obj : emplist){
				System.out.println(obj);
			}*/
			
			/*Criteria criteria = session.createCriteria(Employee.class);
			List emplist = criteria.add(Restrictions.gt("salary",20000)).list();
			
			for(Object obj : emplist){
				System.out.println(obj);
			}*/
			
			/*Criteria criteria = session.createCriteria(Employee.class);
			List emplist = criteria.add(Restrictions.like("empName","%um%",MatchMode.ANYWHERE)).list();
			
			for(Object obj : emplist){
				System.out.println(obj);
			}*/
			
			/*Criteria criteria = session.createCriteria(Employee.class);
			List emplist = criteria.addOrder(Order.desc("salary")).list();
			
			for(Object obj : emplist){
				System.out.println(obj);
			}*/
			
//=================Criteria Projection Demo ===============================
			
			/*Criteria crit = session.createCriteria(Employee.class);
			crit.setProjection(Projections.rowCount());
			List<Long> results = crit.list();
			
			for(Object obj : results){
				System.out.println(obj);
			}*/
			
			Criteria crit = session.createCriteria(Employee.class);
			ProjectionList projList = Projections.projectionList();
			projList.add(Projections.max("salary"));
			projList.add(Projections.min("salary"));
			projList.add(Projections.avg("salary"));
			projList.add(Projections.countDistinct("empName"));
			crit.setProjection(projList);
			
			List<Object[]> results = crit.list();
			for(Object[] obj : results){
				System.out.println("MaxSal:"+obj[0]);
				System.out.println("MinSal:"+obj[1]);
				System.out.println("AvgSal:"+obj[2]);
				System.out.println("No. of Employees:"+obj[3]);
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


