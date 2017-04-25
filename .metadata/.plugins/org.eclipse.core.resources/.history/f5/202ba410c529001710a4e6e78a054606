package co.santosh.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import co.santosh.hbm.Branch;

public class BranchDAO {
	
	private EntityManager em;

	public BranchDAO() {
		em = Persistence.createEntityManagerFactory("primary")
				.createEntityManager();
	}

	public void insert(Branch branch) {
		System.out.println("inserting branch");
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(branch);
		em.flush();
		tx.commit();
		System.out.println("branch inserted successfully");
	}

	
	public void read(String branchId) {
		Branch branch=em.find(Branch.class,branchId );
		System.out.println("branch read successfully");
		System.out.println("Branch Name " + branch.getBranchName());
		System.out.println("Branch Status "+ branch.isBranchStatus());
	}
	
	public void updateBrnach(String branchId) {
		Branch branch=em.find(Branch.class,branchId );
		branch.setBranchName("Changed Branch Name");
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(branch);
		em.flush();
		tx.commit();
		System.out.println("branch updated successfully");
	}

	public void removeBrnach(String branchId) {
		Branch branch=em.find(Branch.class,branchId );
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(branch);
		em.flush();
		tx.commit();
		System.out.println("branch deleted successfully");

	}

}
