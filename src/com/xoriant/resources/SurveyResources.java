package com.xoriant.resources;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.xoriant.dataaccessobject.SurveyDAO.SurveyDao;
import com.xoriant.model.Survey;

//The resource to the URI Surveys
@Path("Surveys")
public class SurveyResources {

	//1)	List all the Survey Conducting by Xoriant
	@GET
	@Produces( MediaType.APPLICATION_JSON)
	public List<Survey> getSurveyList() throws SQLException {
		List<Survey> surveyList = new ArrayList<Survey>();
		surveyList.addAll(SurveyDao.getAllSurvey().values());
		return surveyList;
	}

	// 2)	No of Survey Conducted by Xoriant
	@GET
	@Path("Counts")
	@Produces( MediaType.APPLICATION_JSON)
	public String getCountOfSurvey() throws SQLException {
		int count = SurveyDao.getAllSurvey().size();
		return String.valueOf(count);
	}

	
	
	
	@GET
	@Path("{id}")
	@Produces( MediaType.APPLICATION_JSON)
	public Survey getSurvey(@PathParam("id") String id) throws SQLException {
		ArrayList<Survey> listOfSurvey = new ArrayList<Survey>();
		listOfSurvey.addAll(SurveyDao.getAllSurvey().values());
		return listOfSurvey.get(Integer.valueOf(id));
	}
	
	
	
	//4)	Conduct Survey for the Employee  Randomly
	@GET
	@Path("Random")
	@Produces( MediaType.APPLICATION_JSON)
	public Survey getRandomSurvey() throws SQLException {
		Random random = new Random();
		ArrayList<Survey> listOfSurvey = new ArrayList<Survey>();
		listOfSurvey.addAll(SurveyDao.getAllSurvey().values());
		int index = random.nextInt(listOfSurvey.size());
		return listOfSurvey.get(index);
	}
	
	//5)	Provide the List of Surveys which are Open/Closed
	@GET
	@Path("/Status/{status}")
	@Produces( MediaType.APPLICATION_JSON)
	public List<Survey> getSurveyListByStatus(@PathParam("status") String status) throws SQLException {
		ArrayList<Survey> listOfSurvey = new ArrayList<Survey>();
		listOfSurvey.addAll(SurveyDao.getAllSurvey().values());
		ArrayList<Survey> listOfSurveyStatus = new ArrayList<Survey>();
		for(Survey survey:listOfSurvey){
			if(survey.getStatus().equals(status)){
			listOfSurveyStatus.add(survey);
			}
		}
		
		return listOfSurveyStatus;
	}

	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void addNewSurvey(@FormParam("id") int id,
			@FormParam("title") String title,
			@FormParam("choice1") String choice1,
			@FormParam("choice2") String choice2,
			@FormParam("status") String status,
			@Context HttpServletResponse servletResponse) throws IOException, SQLException {
		Survey survey = new Survey(id, title, choice1, choice2, status);
		SurveyDao.getAllSurvey().put(id, survey);
		servletResponse.sendRedirect("/XoriantSurveyPortal/create_survey.html");
	}
	
	

}










