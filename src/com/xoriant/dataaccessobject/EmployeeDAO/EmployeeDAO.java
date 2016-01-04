package com.xoriant.dataaccessobject.EmployeeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xoriant.dataaccessobject.DatabaseConnection;
import com.xoriant.model.Employee;

public class EmployeeDAO {
	

	/*
	 * Adds employee into the database
	 */
	public void addEmployee(Employee employee) throws SQLException {
		Connection connection = DatabaseConnection.getConnection();
		String query = "INSERT INTO EMPLOYEE VALUES(?,?)";
		PreparedStatement pStatement = connection.prepareStatement(query);
		pStatement.setString(1, employee.getEmpId());
		pStatement.setString(2, employee.getEname());
		pStatement.executeUpdate();

	}

	/*
	 * Retrieves the list of employees from the database
	 */
	public static ArrayList<Employee> getAllEmployee() throws SQLException {
		Connection connection = DatabaseConnection.getConnection();
		ArrayList<Employee> employee = new ArrayList<>();
		String query = "SELECT * FROM EMPLOYEE";
		PreparedStatement pStatement = connection.prepareStatement(query);
		ResultSet resultSet = pStatement.executeQuery();
		while (resultSet.next()) {
			employee.add(new Employee(resultSet.getString("empId"), resultSet
					.getString("ename")));
		}
		return employee;
	}
}
