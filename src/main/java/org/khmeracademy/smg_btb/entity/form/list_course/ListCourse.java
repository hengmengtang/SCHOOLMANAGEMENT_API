package org.khmeracademy.smg_btb.entity.form.list_course;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListCourse {

	@JsonProperty("COURSE_ID")
	private String cou_id;
	
	@JsonProperty("GENERATION_NAME")
	private String gen_name;
	
	@JsonProperty("COURSE_NAME")
	private String cou_name;
	
	@JsonProperty("START_DATE")
	private String start_date;
	
	@JsonProperty("END_DATE")
	private String end_date;
	
	public String getCou_id() {
		return cou_id;
	}
	
	public void setCou_id(String cou_id) {
		this.cou_id = cou_id;
	}
	
	public String getGen_name() {
		return gen_name;
	}
	
	public void setGen_name(String gen_name) {
		this.gen_name = gen_name;
	}
	
	public String getCou_name() {
		return cou_name;
	}
	
	public void setCou_name(String cou_name) {
		this.cou_name = cou_name;
	}
	
	public String getStart_date() {
		return start_date;
	}
	
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	
	public String getEnd_date() {
		return end_date;
	}
	
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	
	
}
