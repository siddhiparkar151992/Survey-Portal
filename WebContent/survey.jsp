<%@page import="com.xoriant.model.Survey"%>
<%@page import="com.xoriant.resources.SurveyResources"%>
<%@page import="com.xoriant.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Xoriant Solution Pvt. Ltd.</h1>
	</center>
	<hr>
	<%
		SurveyResources resources = new SurveyResources();
		Survey survey = resources.getRandomSurvey();
	%>
	<form action="../XoriantSurveyPortal/Xoriant/AddSurvey" method="post">
		<table align="center" border="1">
			<tr>
				<td>Employee ID</td>
				<td><%=session.getAttribute("empId")%><input type="hidden"
					name=empId value=<%=session.getAttribute("empId")%>></td>
			</tr>
			<tr>
				<td>Employee Name</td>
				<td><%=session.getAttribute("ename")%><input type="hidden"
					name="ename" value=<%=session.getAttribute("ename")%>> <input
					type="hidden" name="surveyId" value=<%=survey.getSurveyId()%>></td>
			</tr>
			<tr>
				<td>Survey :</td>
				<td><%=survey.getTitle()%><input type="hidden" name="title" 
					value=<%=survey.getTitle()%> /></td>
			</tr>
			<tr>
				<td>Choice 1 :</td>
				<td><input type="radio" name="finalChoice"
					value=<%=survey.getChoice1()%>><%=survey.getChoice1()%></td>
			</tr>
			<tr>
				<td>Choice 2 :</td>
				<td><input type="radio" name=finalChoice
					value=<%=survey.getChoice2()%>><%=survey.getChoice2()%></td>
			</tr>
			<tr>
				<td><input type="hidden" name="status"
					value=<%=survey.getStatus()%>></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="submit" /></td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>