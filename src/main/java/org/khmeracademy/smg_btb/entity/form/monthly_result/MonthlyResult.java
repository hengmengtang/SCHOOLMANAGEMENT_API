package org.khmeracademy.smg_btb.entity.form.monthly_result;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MonthlyResult {

	@JsonProperty("STUDENT_ID")
	private String stu_id;
	
	@JsonProperty("STUDENT_NMAE")
	private String stu_name;
	
	@JsonProperty("CLASS_NAME")
	private String class_name;
	
	public String getStu_id() {
		return stu_id;
	}
	
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	
	public String getStu_name() {
		return stu_name;
	}
	
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	
	public String getClass_name() {
		return class_name;
	}
	
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	
}
