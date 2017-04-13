package co.santosh.hbm.m2m.bi;

import java.util.Set;

public class Employee {
	private Integer EmpId;
	private String EmpName;
	private Set<Project> projects;
	
	public Integer getEmpId() {
		return EmpId;
	}
	public void setEmpId(Integer empId) {
		EmpId = empId;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	
}
