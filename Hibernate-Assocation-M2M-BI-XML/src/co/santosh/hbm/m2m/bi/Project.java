package co.santosh.hbm.m2m.bi;

import java.util.Set;

public class Project {
	private Integer ProjId;
	private String ProjName;
	private Set<Employee> employees;
	
	public Integer getProjId() {
		return ProjId;
	}
	public void setProjId(Integer projId) {
		ProjId = projId;
	}
	public String getProjName() {
		return ProjName;
	}
	public void setProjName(String projName) {
		ProjName = projName;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
