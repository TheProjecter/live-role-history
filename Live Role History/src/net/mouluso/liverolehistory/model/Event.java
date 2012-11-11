package net.mouluso.liverolehistory.model;

import android.location.Location;

public class Event {
	private String description;
	private int order;
	private String question;
	private String answer;
	private String searchTerms;
	private String success;
	private Location location;
	
	public Event(String description, String question, 
			String answer, String searchTerms, String sucess, int order,Location location) {
		this.description = description;
		this.question = question;
		this.answer = answer;
		this.searchTerms = searchTerms;
		this.order = order;
		this.location = location;
		this.success = success;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getSearchTerms() {
		return searchTerms;
	}

	public void setSearchTerms(String searchTerms) {
		this.searchTerms = searchTerms;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	
}
