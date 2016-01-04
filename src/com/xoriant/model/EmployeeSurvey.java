package com.xoriant.model;


public class EmployeeSurvey {
	private String empSurveyId;
	
	private String empId;
	private String ename;
	
	private String surveyId;
	private String title;
	private String finalChoice;
	private String status;
	public EmployeeSurvey(String empSurveyId, String empId, String ename,
			String surveyId, String title, String finalChoice, String status) {
		super();
		this.empSurveyId = empSurveyId;
		this.empId = empId;
		this.ename = ename;
		this.surveyId = surveyId;
		this.title = title;
		this.finalChoice = finalChoice;
		this.status = status;
	}
	public EmployeeSurvey() {
		super();
	}
	public String getEmpSurveyId() {
		return empSurveyId;
	}
	public void setEmpSurveyId(String empSurveyId) {
		this.empSurveyId = empSurveyId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFinalChoice() {
		return finalChoice;
	}
	public void setFinalChoice(String finalChoice) {
		this.finalChoice = finalChoice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "EmployeeSurvey [empSurveyId=" + empSurveyId + ", empId=" + empId
				+ ", ename=" + ename + ", surveyId=" + surveyId + ", title=" + title
				+ ", finalChoice=" + finalChoice + ", status=" + status + "]";
	}
	
	

}
