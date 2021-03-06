package co.santosh.hbm;


import java.util.HashSet;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import co.santosh.hbm.Customer;


@Entity @Table(name = "branch")
public class Branch {
	
	
	public Branch() {
	}
	
	public Branch(String branchName, Boolean branchStatus){
		this.branchName = branchName;
		this.branchStatus = branchStatus;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "branch_id")
	private int  branchId;
	
	@Column (name = "branch_name")
	private String branchName;
	
	@Column (name = "branch_status")
	private boolean branchStatus;
	
	@ManyToMany
	@JoinTable(name = "branch_customer" , joinColumns = {@JoinColumn (name = "branch_id")}, 
	inverseJoinColumns = {@JoinColumn(name = "customer_id")})
	@Cascade({CascadeType.SAVE_UPDATE})
	private Set<Customer> customer = new HashSet<Customer>() ;
	
	
	
	public int getBranchId() {
		return branchId;
	}
	
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	
	
	public String getBranchName() {
		return branchName;
	}
	
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	
	public boolean isBranchStatus() {
		return branchStatus;
	}
	public void setBranchStatus(boolean branchStatus) {
		this.branchStatus = branchStatus;
	}

	public Set<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(Set<Customer> customer) {
		this.customer = customer;
	}
		
}

