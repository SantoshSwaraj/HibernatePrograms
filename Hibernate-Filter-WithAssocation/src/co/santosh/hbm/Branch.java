package co.santosh.hbm;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.ParamDef;;

@Entity
@Table(name = "branch")

@FilterDefs({
	@FilterDef(name="branchNameFilter", parameters=@ParamDef( name="branchNameFilterParam", type="java.lang.String" ) ),
	@FilterDef(name="branchAddressFilter", parameters=@ParamDef( name="branchAddressFilterParam", type="java.lang.Integer" ) )
})
@Filter(name = "branchNameFilter", condition = "branchName = :branchNameFilterParam")
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

	@OneToMany
	@Cascade({CascadeType.SAVE_UPDATE})
	@Filter(
			name = "branchAddressFilter",
			condition="zipcode > :branchAddressFilterParam"
		)
	private Set<BranchAddress> branchAddress;
	
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

	public Set<BranchAddress> getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(Set<BranchAddress> branchAddress) {
		this.branchAddress = branchAddress;
	}	

}
