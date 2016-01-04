package com.xoriant.resources;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

import com.xoriant.dataaccessobject.EmployeeSurveyDao;
import com.xoriant.dataaccessobject.SurveyDAO.SurveyDao;
import com.xoriant.model.EmployeeSurvey;
import com.xoriant.model.Survey;
import com.xoriant.model.SurveyResult;

@Path("/")
public class EmployeeSurveyResource {

	// 9) Store Survey given by employee along with his details.

	@POST
	@Path("AddSurvey")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void storeEmployeeSurvey(@FormParam("empId") String empId,
			@FormParam("ename") String ename, @FormParam("surveyId") String surveyId,
			@FormParam("title") String title,
			@FormParam("finalChoice") String finalChoice,
			@FormParam("status") String status,
			@Context HttpServletResponse servletResponse) throws IOException, SQLException {
		EmployeeSurvey emp = new EmployeeSurvey(empId + surveyId, empId, ename, surveyId,
				title, finalChoice, status);
		EmployeeSurveyDao.getAllSurveyConduced().put(empId + surveyId, emp);
		
		servletResponse.sendRedirect("../thanks.html");

	}

	// 10) List the Survey given by Employee
	@GET
	@Path("SurveyResult")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<EmployeeSurvey> getAllSurveyResultList() throws SQLException {
		List<EmployeeSurvey> EmpList = new ArrayList<EmployeeSurvey>();
		EmpList.addAll(EmployeeSurveyDao.getAllSurveyConduced()
				.values());
		return EmpList;
	}

	@GET
	@Path("SurveyResult/{SurveyId}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public SurveyResult getAllSurveyResulById(
			@PathParam("SurveyId") String surveyId) throws SQLException {
		int countChoice1 = 0, countChoice2 = 0;
		Survey surveyTemplate = SurveyDao.getAllSurvey().get(surveyId);
		List<EmployeeSurvey> empList = new ArrayList<EmployeeSurvey>();
		empList.addAll(EmployeeSurveyDao.getAllSurveyConduced()
				.values());
		
		for (EmployeeSurvey survey : empList) {
			if (survey.getSurveyId().equals(surveyId)) {

				if (survey.getFinalChoice().equals(surveyTemplate.getChoice1())) {
					countChoice1++;
				} else {
					countChoice2++;
				}

			}
		}

		return new SurveyResult(surveyId, surveyTemplate.getChoice1(),
				countChoice1, surveyTemplate.getChoice2(), countChoice2);
	}
	
	
	@GET
	@Path("AttemptedSurvey/{empId}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Survey> getAttemptedSurveyListByEmployee(@PathParam("empId") String empId){
		
		
		return null;
		
	}
}
