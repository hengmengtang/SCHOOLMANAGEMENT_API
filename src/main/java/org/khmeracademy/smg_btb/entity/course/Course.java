package org.khmeracademy.smg_btb.entity.course;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Course {

	@JsonProperty("COURSE_ID")
	private String course_id;
	
	@JsonProperty("COURSE_NAME")
	private String course_name;
	
	@JsonProperty("COURSE_START_DATE")
	private String cou_start_date;
	
	@JsonProperty("COURSE_END_DATE")
	private String cou_end_date;
	
	@JsonProperty("STATUS")
	private boolean status;

	public Course(){};
	
	public Course(String course_id,String course_name){
		super();
		this.course_id=course_id;
		this.course_name=course_name;
	}
	
	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCou_start_date() {
		return cou_start_date;
	}

	public void setCou_start_date(String cou_start_date) {
		this.cou_start_date = cou_start_date;
	}

	public String getCou_end_date() {
		return cou_end_date;
	}

	public void setCou_end_date(String cou_end_date) {
		this.cou_end_date = cou_end_date;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
