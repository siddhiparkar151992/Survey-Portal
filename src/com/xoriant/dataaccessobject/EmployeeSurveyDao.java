package com.xoriant.dataaccessobject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xoriant.dataaccessobject.*;
import com.xoriant.model.EmployeeSurvey;
import com.xoriant.model.Survey;

public class EmployeeSurveyDao {
	
	/*
	 * Adds details of survey taken by a employee.
	 */
	public void addEmployeeSurvey(EmployeeSurvey empSurvey) throws SQLException {
		Connection connection = DatabaseConnection.getConnection();
		String query = "INSERT INTO Survey VALUES(?,?,?,?,?)";
		PreparedStatement pStatement = connection.prepareStatement(query);
		pStatement.setString(1, empSurvey.getEmpSurveyId());
		pStatement.setString(2, empSurvey.getEmpId());
		pStatement.setString(3, empSurvey.getSurveyId());
		pStatement.setString(4, empSurvey.getTitle());
		pStatement.setString(5, empSurvey.getFinalChoice());
		pStatement.executeUpdate();

	}

	/*
	 * Gets details of all the surveys taken by all employees.
	 */
	public static Map<String, EmployeeSurvey> getAllSurveyConduced()
			throws SQLException {

		Connection connection = DatabaseConnection.getConnection();
		Map<String, EmployeeSurvey> employeeSurveyList = new HashMap<String, EmployeeSurvey>();
		String query = "SELECT * FROM EMPLOYEESURVEY";
		PreparedStatement pStatement = connection.prepareStatement(query);
		ResultSet resultSet = pStatement.executeQuery();
		while (resultSet.next()) {
			employeeSurveyList.put(
					resultSet.getString("empSurveyId"),
					new EmployeeSurvey(resultSet.getString("empSurveyId"),
							resultSet.getString("empId"), resultSet
									.getString("surveyId"), resultSet
									.getString("title"), resultSet
									.getString("finalChoice"), query, query));
		}

		return employeeSurveyList;
	}

	/*
	 * Gets all the surveys taken by a particular employee
	 */
	public List<Survey> getAllSurveyConducedByEmpId(String empId)
			throws SQLException {

		Map<String, EmployeeSurvey> employeeSurveyList = 
				this.getAllSurveyConduced();
		List<EmployeeSurvey> employeeSurvey = new ArrayList<>(
				employeeSurveyList.values());
		List<Survey> surveys = new ArrayList<Survey>();
		for (EmployeeSurvey emp : employeeSurvey) {
			if (emp.getEmpId().equals(empId)) {
				surveys.add(new Survey(0, emp.getSurveyId(), emp.getTitle(), emp
						.getFinalChoice(), empId));
			}
		}

		return surveys;
	}
}
