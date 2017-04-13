package co.santosh.hbm.o2m.uni;

import java.util.Set;

public class Employee {
	private Integer empId;
	private String empName;
	private Set addresses;
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Set getAddresses() {
		return addresses;
	}
	public void setAddresses(Set addresses) {
		this.addresses = addresses;
	}
	
}
