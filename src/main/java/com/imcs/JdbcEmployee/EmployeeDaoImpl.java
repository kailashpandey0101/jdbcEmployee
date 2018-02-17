package com.imcs.JdbcEmployee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

public class EmployeeDaoImpl implements EmployeeOperations {

	BasicDataSource ds = MyDataSourceFactory.getMySqlDataSource();
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// adding employee
	public boolean addEmployee(Employee e) {
		try {
			con = ds.getConnection();
			String sql = "INSERT INTO employeedetails(Name, Age, PhoneNo, Salary, Company, DepartmentNo, StartDate, EndDate)"
					+ "VALUES(?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(2, e.getName());
			ps.setInt(3, e.getAge());
			ps.setString(4, e.getPhoneNo());
			ps.setInt(5, e.getSalary());
			ps.setString(6, e.getCompanyName());
			ps.setInt(7, e.getDeptNo());
			ps.setDate(8, new java.sql.Date(e.getStartDate().getTime()));
			ps.setDate(9, new java.sql.Date(e.getEndDate().getTime()));
			ps.executeUpdate();

			return true;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return false;
	}

	public boolean deleteEmployee(int employeeId) {

		try {
			con = ds.getConnection();
			String selectSQL = "select *from employeedetails where EmployeeId=?";
			ps = con.prepareStatement(selectSQL);
			ps.setInt(1, employeeId);
			rs = ps.executeQuery();
			if (rs.next()) {
				String sql = "delete from employeedetails where EmployeeId=?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, employeeId);
				ps.executeUpdate();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean updateEmployee(Employee e) {
		try {
			con = ds.getConnection();
			String selectSQL = "select *from employeedetails where EmployeeId=?";
			ps = con.prepareStatement(selectSQL);
			ps.setInt(1, e.getEmployeeId());
			rs = ps.executeQuery();
			if (rs.next()) {

				String sql = "update employeedetails Name=?,Age=?, PhoneNo=?, Salary=?, Company=?, DepartmentNo=?, StartDate=?, EndDate=? where EmployeeId=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, e.getName());
				ps.setInt(2, e.getAge());
				ps.setString(3, e.getPhoneNo());
				ps.setInt(4, e.getSalary());
				ps.setString(5, e.getCompanyName());
				ps.setInt(6, e.getDeptNo());
				ps.setDate(7, new java.sql.Date(e.getStartDate().getTime()));
				ps.setDate(8, new java.sql.Date(e.getEndDate().getTime()));
				ps.setInt(9, e.getEmployeeId());
				ps.executeUpdate();
				return true;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;

	}

	// returning the employee by their id
	public Employee getEmployee(int empId) throws EmployeeNotFoundException {
		try {
			con = ds.getConnection();
			String selectSQL = "select *from employeedetails where EmployeeId=?";
			ps = con.prepareStatement(selectSQL);
			ps.setInt(1, empId);
			rs = ps.executeQuery();
			if (rs.next()) {
				Employee e = new Employee(rs.getInt("EmployeeId"), rs.getString("Name"), rs.getInt("Age"),
						rs.getString("PhoneNo"), rs.getInt("Salary"), rs.getString("Company"),
						rs.getInt("DepartmentNo"), new Date(rs.getDate("StartDate").getTime()),
						new Date(rs.getDate("EndDate").getTime()));
				return e;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new EmployeeNotFoundException("There is NO employee with given employee ID");
	}

	// displaying all employees information
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = new ArrayList<>();
		try {
			con = ds.getConnection();
			String selectSQL = "select *from employeedetails";
			ps = con.prepareStatement(selectSQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				Employee e = new Employee(rs.getInt("EmployeeId"), rs.getString("Name"), rs.getInt("Age"),
						rs.getString("PhoneNo"), rs.getInt("Salary"), rs.getString("Company"),
						rs.getInt("DepartmentNo"), new Date(rs.getDate("StartDate").getTime()),
						new Date(rs.getDate("EndDate").getTime()));
				employeeList.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	public List<Employee> sortAs(String selectSQL) {
		try {
			con = ds.getConnection();
			List<Employee> emp = new ArrayList<>();

			ps = con.prepareStatement(selectSQL);
			rs = ps.executeQuery();

			while (rs.next()) {
				Employee e = new Employee(rs.getInt("EmployeeId"), rs.getString("Name"), rs.getInt("Age"),
						rs.getString("PhoneNo"), rs.getInt("Salary"), rs.getString("Company"),
						rs.getInt("DepartmentNo"), new Date(rs.getDate("StartDate").getTime()),
						new Date(rs.getDate("EndDate").getTime()));
				emp.add(e);
			}
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<Employee> highSalaryIterator(int salary) {

		try {
			List<Employee> empList = new ArrayList<>();
			con = ds.getConnection();
			String selectSQL = "select *from employeedetails where salary>?";
			ps = con.prepareStatement(selectSQL);
			ps.setInt(1, salary);
			rs = ps.executeQuery();
			while (rs.next()) {
				Employee e = new Employee(rs.getInt("EmployeeId"), rs.getString("Name"), rs.getInt("Age"),
						rs.getString("PhoneNo"), rs.getInt("Salary"), rs.getString("Company"),
						rs.getInt("DepartmentNo"), new Date(rs.getDate("StartDate").getTime()),
						new Date(rs.getDate("EndDate").getTime()));
				empList.add(e);
			}
			return empList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
}