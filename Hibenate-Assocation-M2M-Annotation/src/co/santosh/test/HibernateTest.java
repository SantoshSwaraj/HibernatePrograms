package co.santosh.test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.santosh.hbm.Branch;
import co.santosh.hbm.Customer;

public class HibernateTest {

	// TODO
	// drop database bank_db
	// create database bank_db
	public static void main(String[] args) throws IOException {

		try{
		HibernateTest test = new HibernateTest();

		Branch branch = new Branch("Test1", true);
		Branch branch2 = new Branch("Test2", true);

		Set<Customer> customer = new HashSet<Customer>();
		customer.add(new Customer(1, "Customer1"));
		customer.add(new Customer(2, "Customer2"));
		test.createBranch(branch, branch2, customer);
		// datahandler.readBranchDetails(1);
		// datahandler.updateBranch(1, "New branch");
		//hibernatetest.detleteBranch(2);
		}finally{
			HibernateUtil.shutDown();
		}
	}

	public void createBranch(Branch branch, Branch branch2,
			Set<Customer> customer) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			branch.setCustomer(customer);
			branch2.setCustomer(customer);
			session.save(branch);
			session.save(branch2);

			transaction.commit();
			System.out.println("Dateils Added Successfully");
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void readBranchDetails(int id) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Branch branch = (Branch) session.get(Branch.class, id);
			System.out.println("Branch Details : " + branch.getBranchName());
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void updateBranch(int id, String branchName) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Branch branch = (Branch) session.get(Branch.class, id);
			branch.setBranchName(branchName);
			session.update(branch);
			transaction.commit();
			System.out.println("Branch Updated Successfully ..!");
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void detleteBranch(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Branch branch = (Branch) session.get(Branch.class, id);
			session.delete(branch);
			System.out.println(" deleted Successfully ..!");
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			;
		} finally {
			session.close();
		}

	}

}
