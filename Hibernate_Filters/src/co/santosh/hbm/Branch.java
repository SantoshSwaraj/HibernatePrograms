package co.santosh.hbm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@Entity
@Table(name="branch")
@FilterDef(name="branchNameFilter", parameters=@ParamDef(name="branchNameFilterParam",type="java.lang.String"))
@Filter(name="branchNameFilter", condition="branchName=:branchNameFilterParam")
public class Branch {
	public Branch() {
	}

	public Branch(String branchName, Boolean branchStatus) {
		this.branchName = branchName;
		this.branchStatus = branchStatus;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	
	private String branchName;
	private boolean branchStatus;

	@Column(name = "branch_name")
	public String getBranchName() {
		return branchName;
	}

	@Column(name = "branch_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	@Column(name = "branch_status")
	public boolean isBranchStatus() {
		return branchStatus;
	}

	public void setBranchStatus(boolean branchStatus) {
		this.branchStatus = branchStatus;
	}
}
