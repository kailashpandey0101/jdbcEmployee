package com.imcs.JdbcEmployee;

import java.util.List;

public interface EmployeeOperations {
	boolean addEmployee(Employee e);

	boolean deleteEmployee(int employeeId);

	boolean updateEmployee(Employee e);

	Employee getEmployee(int empId) throws EmployeeNotFoundException;

	List<Employee> getAllEmployees();

	List<Employee> sortAs(String string);

	List<Employee> highSalaryIterator(int salary);

}
