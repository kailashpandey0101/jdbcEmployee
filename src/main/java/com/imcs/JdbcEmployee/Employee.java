package com.imcs.JdbcEmployee;

import java.util.Date;

public class Employee {
	private int employeeId;
	private String name;
	private int age;
	private String phoneNo;
	private int salary;
	private String companyName;
	private Date startDate;
	private Date endDate;
	private int deptNo;

	Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param employeeId
	 * @param name
	 * @param age
	 * @param phoneNo
	 * @param salary
	 * @param companyName
	 * @param startDate
	 * @param endDate
	 */
	public Employee(int employeeId, String name, int age, String phoneNo, int salary, String companyName, int deptNo,
			Date startDate, Date endDate) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.age = age;
		this.phoneNo = phoneNo;
		this.salary = salary;
		this.companyName = companyName;
		this.deptNo = deptNo;
		this.startDate = startDate;
		this.endDate = endDate;

	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("$ [employeeId=");
		builder.append(employeeId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", phoneNo=");
		builder.append(phoneNo);
		builder.append(", salary=");
		builder.append(salary);
		builder.append(", companyName=");
		builder.append(companyName);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", deptNo=");
		builder.append(deptNo);
		builder.append("]");
		return builder.toString();
	}

}
