package org.khmeracademy.smg_btb.entity.generation;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountStudentByGeneration {

	@JsonProperty("GENERATION_NAME")
	private String generation_name;
	
	@JsonProperty("COURSE_NAME")
	private String course_name;
	
	@JsonProperty("TOTAL_STUDENT")
	private String total_student;

	public String getGeneration_name() {
		return generation_name;
	}

	public void setGeneration_name(String generation_name) {
		this.generation_name = generation_name;
	}

	public String getTotal_student() {
		return total_student;
	}

	public void setTotal_student(String total_student) {
		this.total_student = total_student;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	
}
