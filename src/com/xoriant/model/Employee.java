package com.xoriant.model;



public class Employee {
	String empId;
	String ename;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Employee(String empId, String ename) {
		super();
		this.empId = empId;
		this.ename = ename;
	}

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", ename=" + ename + "]";
	}

}
