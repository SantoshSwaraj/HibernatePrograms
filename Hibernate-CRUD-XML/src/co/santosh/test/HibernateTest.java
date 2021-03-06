package co.santosh.test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.santosh.hbm.Student;

public class HibernateTest {
	static Scanner console = new Scanner(System.in);
	static Session session = null;
	static Transaction transaction = null;
	public static void main(String[] args) {
		try{
			SessionFactory sessionfactory = HibernateUtils.getSessionFactory();
			session = sessionfactory.openSession();
		}
		catch(HibernateException e){
			e.printStackTrace();
		}
		
		String ans = "y";
		while(ans.equalsIgnoreCase("Y")){
			System.out.println("===Perform CRUD Operation on Student_DB===");
			System.out.println("\t1. Insert record");
			System.out.println("\t2. Reterive record");
			System.out.println("\t3. Update record");
			System.out.println("\t4. Delete record");
			System.out.println("\t5. Reterive all records");
			System.out.println("\t6. Exit");
			
			System.out.print("\t\t Enter your choice:");
			int choice = console.nextInt();
			switch(choice){
			case 1:
				insertRecord();
				break;
				
			case 2:
				reteriveRecord();
				break;
				
			case 3:
				updateRecord();
				break;
			
			case 4:
				deleteRecord();
				break;
				
			case 5:
				retervieAll();
				break;
			
			case 6:
				System.out.print("Thanks for using me..");
				session.close();
				System.exit(0);
				
			default:
				System.out.println("Invalid Input\n Please try again..");
			}
		}
		System.out.print("Do you want to perform other operation(Y/N)?");
		ans = console.next();
	}
	
	private static void insertRecord(){
		try{
			transaction = session.beginTransaction();
			Student stud1 = new Student();
			System.out.print("Enter Name: ");
			String name = console.next();
			stud1.setName(name);
			System.out.print("Enter Dept: ");
			String dept = console.next();
			stud1.setDept(dept);
			session.save(stud1);
			transaction.commit();
			System.out.println("Inserted");
		}
		catch(HibernateException e){
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	private static void reteriveRecord(){
		try{
			System.out.print("Enter Rollno: ");
			Integer rollno = console.nextInt();
			Student stud1 = (Student)session.get(Student.class, rollno);
			System.out.println("Rollno: "+stud1.getRollNo()+"\t"+"Name: "+stud1.getName()+"\t"+"Dept: "+stud1.getDept());
		}
		catch(HibernateException e){
			e.printStackTrace();
		}
	}
	
	private static void updateRecord(){
		try{
			transaction = session.beginTransaction();
			System.out.print("Enter Rollno: ");
			Integer rollno = console.nextInt();
			Student stud1 = (Student)session.get(Student.class, rollno);
			System.out.println("Rollno: "+stud1.getRollNo()+"\t"+"Name: "+stud1.getName()+"\t"+"Dept: "+stud1.getDept());
			
			System.out.print("Update Name: ");
			String name = console.next();
			stud1.setName(name);
			System.out.print("Update Dept: ");
			String dept = console.next();
			stud1.setDept(dept);
			session.save(stud1);
			transaction.commit();
			System.out.println("Updated");
		}
		catch(HibernateException e){
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	private static void deleteRecord(){
		try{
			transaction = session.beginTransaction();
			System.out.print("Enter Roll :");
			int roll = console.nextInt();
			Student stud1 = (Student)session.get(Student.class, roll);
			session.delete(stud1);
			transaction.commit();
			System.out.println("Deleted");
		}
		catch(HibernateException e){
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	private static void retervieAll(){
		try{
			Criteria criteria = session.createCriteria(Student.class);
			List students = criteria.list();
			
			System.out.println("Rollno\tName\tDept");
			Iterator itr = students.iterator();
			while (itr.hasNext()) {
				Student stud = (Student) itr.next();
				System.out.println(stud.getRollNo()+"\t"+stud.getName()+"\t"+stud.getDept());
			}
		}
		catch(HibernateException e){
			e.printStackTrace();
		}
	}
}

