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

import co.santosh.hbm.m2m.uni.Course;
import co.santosh.hbm.m2m.uni.Faculty;


public class HibernateTest {
	static Scanner console = new Scanner(System.in);
	static Session session = null;
	static Transaction transaction = null;
	
	public static void main(String args[]){
		try{
			SessionFactory sessionfactory = HibernateUtils.getSessionFactory();
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			
			
			Course course1 = new Course();
			course1.setCourseName("JAVA");
			session.save(course1);
			
			Course course2 = new Course();
			course2.setCourseName("DesignPatterns");
			session.save(course2);
			
			Course course3 = new Course();
			course3.setCourseName("BigData");
			session.save(course3);
			
			Course course4 = new Course();
			course4.setCourseName("DataScience");
			session.save(course4);
			
			Course course5 = new Course();
			course5.setCourseName("Android");
			session.save(course5);
			
			Faculty faculty1 = new Faculty();
			faculty1.setFacName("Santosh");
			List<Course> facCourse = new ArrayList<Course>();
			facCourse.add(course1);
			facCourse.add(course2);
			facCourse.add(course5);
			Set<Course> courses = new HashSet<Course>();
			courses.addAll(facCourse);
			
			faculty1.setCourse(courses);
			session.save(faculty1);
			
			Faculty faculty2 = new Faculty();
			faculty2.setFacName("Krishna");
			List<Course> facCourse1 = new ArrayList<Course>();
			facCourse1.add(course1);
			facCourse1.add(course3);
			facCourse1.add(course4);
			Set<Course> courses1 = new HashSet<Course>();
			courses1.addAll(facCourse1);
			faculty2.setCourse(courses1);
			session.save(faculty2);
			
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


