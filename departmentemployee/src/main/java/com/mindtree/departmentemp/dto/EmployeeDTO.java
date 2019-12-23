package com.mindtree.departmentemp.dto;

import com.mindtree.departmentemp.entity.Department;

public class EmployeeDTO {
	private int empId;
	private String empName;
	private int experience;
	private int Salary;
	private DepartmentDTO department;

	public EmployeeDTO() {
		super();
	}

	public EmployeeDTO(int empId, String empName, int experience, int salary, DepartmentDTO department) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.experience = experience;
		Salary = salary;
		this.department = department;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int salary) {
		Salary = salary;
	}

	public DepartmentDTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}

}
