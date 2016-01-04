package com.xoriant.model;


public class Survey {
	private int surveyId;
	private String title;
	private String choice1;
	private String choice2;
	private String status;
	
	public Survey() {
		super();
	}

	public Survey(int surveyId, String title, String choice1, String choice2,
			String status) {
		super();
		this.surveyId = surveyId;
		this.title = title;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.status = status;
	}
	
	

	public Survey(int surveyId, String title, String choice1, String status) {
		super();
		this.surveyId = surveyId;
		this.title = title;
		this.choice1 = choice1;
		this.status = status;
	}

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getChoice1() {
		return choice1;
	}

	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}

	public String getChoice2() {
		return choice2;
	}

	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Survey [surveyId=" + surveyId + ", title=" + title + ", choice1=" + choice1
				+ ", choice2=" + choice2 + ", status=" + status + "]";
	}
	
	

}
