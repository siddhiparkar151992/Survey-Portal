package com.xoriant.dataaccessobject.SurveyDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;




import com.xoriant.dataaccessobject.DatabaseConnection;
import com.xoriant.model.Survey;

public class SurveyDao {
/*
	 * Add a new survey
	 */
	static Connection connection = DatabaseConnection.getConnection();
	public static void addSurvey(Survey survey) throws SQLException {
		String query = "insert into SurveyList values(?,?,?,?,?)";
		PreparedStatement preStatement = connection.prepareStatement(query);
		preStatement.setLong(1, survey.getSurveyId());
		preStatement.setString(2, survey.getTitle());
		preStatement.setString(3, survey.getChoice1());
		preStatement.setString(4, survey.getChoice2());
		preStatement.setString(5, survey.getStatus());
		preStatement.executeUpdate();

	}

	public static Map<Integer, Survey> getAllSurvey() throws SQLException {
		
		Map<Integer, Survey> surveyList = new HashMap<Integer, Survey>();
		PreparedStatement preStatement = connection.prepareStatement("SELECT * FROM SurveyList");
		ResultSet rs = preStatement.executeQuery();
		int id=rs.getInt("SurveyId");
		String title=rs.getString("title");
		String choice1=rs.getString("choice1");
		String choice2=rs.getString("choice2");
		String status=rs.getString("status");
		while (rs.next()&&title!=null&&choice1!=null&&choice2!=null&&status!=null) {
			surveyList.put(id,
					new Survey(id,title,choice1,choice2,status));
		}

		return surveyList;
	}
}
