package com.techelevator.npgeek.Models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {
	
	private int surveyId;
	private String parkCode;
	
	@NotBlank(message="Email address is required")
	@Email(message="Email must be a valid email address")
	private String emailAddress;
	
	private String state;

	private String activityLevel;
	
	private int votes;
	
	
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getActivityLevel() {
		return activityLevel;
	}
	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	
	

}
