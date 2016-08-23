package org.khmeracademy.smg_btb.entity.form.monthly_result;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParamViewResult {

	@JsonProperty("GENERATION_NAME")
	private String generation_name;
	
	@JsonProperty("COURSE_NAME")
	private String course_name;
	
	@JsonProperty("DATE")
	private String date;

	public String getGeneration_name() {
		return generation_name;
	}

	public void setGeneration_name(String generation_name) {
		this.generation_name = generation_name;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
