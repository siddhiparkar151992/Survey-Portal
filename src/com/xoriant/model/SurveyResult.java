package com.xoriant.model;

public class SurveyResult {
	
	private String surveyId;
	private String choice1;
	private int countChoice1;
	private String choice2;
	private int countChoice2;
	
	public SurveyResult(String surveyId, String choice1, int countChoice1,
			String choice2, int countChoice2) {
		super();
		this.surveyId = surveyId;
		this.choice1 = choice1;
		this.countChoice1 = countChoice1;
		this.choice2 = choice2;
		this.countChoice2 = countChoice2;
	}

	public SurveyResult() {
		super();
	}

	public String getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
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

	

	public int getCountChoice1() {
		return countChoice1;
	}

	public void setCountChoice1(int countChoice1) {
		this.countChoice1 = countChoice1;
	}

	public int getCountChoice2() {
		return countChoice2;
	}

	public void setCountChoice2(int countChoice2) {
		this.countChoice2 = countChoice2;
	}

	@Override
	public String toString() {
		return "SurveyResult [surveyId=" + surveyId + ", choice1=" + choice1
				+ ", countChoice1=" + countChoice1 + ", choice2=" + choice2
				+ ", countChoice2=" + countChoice2 + "]";
	}
	
	

}
