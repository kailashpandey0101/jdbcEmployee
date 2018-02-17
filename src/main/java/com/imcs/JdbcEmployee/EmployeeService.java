package com.imcs.JdbcEmployee;

import java.util.List;

public class EmployeeService {
	private EmployeeOperations eo = new EmployeeDaoImpl();

	public boolean addEmployee(Employee e) throws InvalidSalaryException {
		if (e.getSalary() < 5000) {
			throw new InvalidSalaryException("Sorry:: Salary must greater than 5000");

		}

		if (eo.addEmployee(e)) {
			return true;
		}

		return false;
	}

	public boolean deleteEmployee(int employeeId) throws EmployeeNotFoundException {

		Employee e = eo.getEmployee(employeeId);
		if (e == null) {
			throw new EmployeeNotFoundException("There is NO employee with given employee ID");
		}
		if (eo.deleteEmployee(employeeId)) {
			return true;
		}
		return false;
	}

	public boolean updateEmployee(Employee e) throws InvalidSalaryException, EmployeeNotFoundException {
		if (e.getSalary() < 5000) {
			throw new InvalidSalaryException("Sorry:: Salary should be greater than 5000");

		}

		if ((eo.getEmployee(e.getEmployeeId()) == null)) {
			throw new EmployeeNotFoundException("There is NO employee with given employee ID");
		}
		if (eo.updateEmployee(e)) {
			return true;
		}
		return false;
	}

	public Employee getEmployee(int empId) throws EmployeeNotFoundException {
		return (eo.getEmployee(empId));
	}

	public List<Employee> getAllEmployees() {
		return (eo.getAllEmployees());
	}

	public int getHra(int empId) throws EmployeeNotFoundException {
		if (eo.getEmployee(empId) == null) {
			throw new EmployeeNotFoundException("There is NO employee with given employee ID");
		}

		Employee e = eo.getEmployee(empId);
		return (calculateHra(e.getSalary(), e.getAge()));

	}

	// returns Gross salary of a particular employee
	public int getGrossSalary(int empId) throws EmployeeNotFoundException {
		if (eo.getEmployee(empId) == null) {
			throw new EmployeeNotFoundException("There is NO employee with given employee ID");
		}
		Employee e = eo.getEmployee(empId);
		return (calculateGrossSalary(e.getSalary(), e.getAge()));
	}

	public List<Employee> highSalaryIterator(int salary) {
		return (eo.highSalaryIterator(salary));
	}

	public List<Employee> sortAs(String sortingName) {
		String selectSQL;
		if (sortingName.equalsIgnoreCase("salary")) {
			selectSQL = "select *from employeedetails order by salary";
		} else if (sortingName.equalsIgnoreCase("nameAndSalary")) {
			selectSQL = "select *from employeedetails order by name,salary";
		} else if (sortingName.equalsIgnoreCase("departmentNo")) {
			selectSQL = "select *from employeedetails order by departmentno";
		} else if (sortingName.equalsIgnoreCase("employeeId")) {
			selectSQL = "select *from employeedetails order by employeeid";
		} else {
			System.out.println("Wrong choice : Try again");
			return null;
		}
		return eo.sortAs(selectSQL);
	}
	
	public int getSalary(int empId) throws EmployeeNotFoundException {
		if (eo.getEmployee(empId) == null) {
			throw new EmployeeNotFoundException("There is NO employee with given employee ID");
		}

		Employee e = eo.getEmployee(empId);
		return e.getSalary();
	}

	// to exit the application
	public void exit() {

		System.exit(0);
	}

	private int calculateGrossSalary(int salary, int age) {
		if (salary < 10000) {
			return ((int) (salary + 0.08 * salary + calculateHra(salary, age)));

		} else if (salary < 20000) {
			return ((int) (salary + 0.1 * salary + calculateHra(salary, age)));

		} else if (salary < 30000 && age >= 40) {
			return ((int) (salary + 0.15 * salary + calculateHra(salary, age)));

		} else if (salary < 30000 && age < 40) {
			return ((int) (salary + 0.13 * salary + calculateHra(salary, age)));

		} else {
			return ((int) (salary + 0.17 * salary + calculateHra(salary, age)));

		}

	}

	private int calculateHra(int salary, int age) {
		if (salary < 10000) {
			return ((int) (0.15 * salary));

		} else if (salary < 20000) {
			return ((int) (0.2 * salary));

		} else if (salary < 30000 && age >= 40) {
			return ((int) (0.27 * salary));

		} else if (salary < 30000 && age < 40) {
			return ((int) (0.25 * salary));

		} else {
			return ((int) (0.3 * salary));

		}
	}

}
