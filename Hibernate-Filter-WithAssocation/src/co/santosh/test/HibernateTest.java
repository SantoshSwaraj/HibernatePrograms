package co.santosh.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Filter;
import org.hibernate.Session;

import co.santosh.hbm.Branch;
import co.santosh.hbm.BranchAddress;

public class HibernateTest {
	
	private void populateBranches() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Branch branch=new Branch("TestBranch", true);
			BranchAddress branchAddress=new BranchAddress("branchstreet","branchcity", "branchstate", 123);
			BranchAddress branchAddress1=new BranchAddress("branchstreet1","branchcity1", "branchstate1", 1234);
			BranchAddress branchAddress2=new BranchAddress("branchstreet1","branchcity1", "branchstate1", 2345);
			Set<BranchAddress> branchAddressess=new HashSet<>();
			branchAddressess.add(branchAddress);
			branchAddressess.add(branchAddress1);
			branchAddressess.add(branchAddress2);
			branch.setBranchAddress(branchAddressess);
			session.save(branch);
			session.save(new Branch("TestBranch2", true));
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
	}
	
	private void testFilter() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			System.out.println("****** Enabling Filter branchNameFilte******");

			Filter filter = session.enableFilter("branchNameFilter");
			filter.setParameter("branchNameFilterParam", "TestBranch");
			Filter filter1=session.enableFilter("branchAddressFilter");
			filter1.setParameter("branchAddressFilterParam", 123);
			List<Branch> branchList = session.createQuery("from Branch").list();
			for (Branch b : branchList) {
				System.out.println(" Branch Name " + b.getBranchName());
				for(BranchAddress address:b.getBranchAddress()){
					System.out.println("Branch Adress Zip Code " + address.getZipcode() );
				}
			}

			System.out.println("****** Disabled Filter ******");

			
		} catch (Exception e) {
		} finally {
			session.close();
		}
	}

	public static void main(String[] args) {
		HibernateTest test = new HibernateTest();
		try{
			test.populateBranches();
			test.testFilter();
		}
		finally{
			HibernateUtils.shutdown();
		}
	}
}
