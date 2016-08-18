package org.khmeracademy.smg_btb.entity.form;

import com.fasterxml.jackson.annotation.JsonProperty;

public class compareHandleSubjectToStaff {

	@JsonProperty("STAFF_ID")
	private String staff_id;
	
	@JsonProperty("STAFF_NAME")
	private String gen_name;
	
	@JsonProperty("COURSE_NAME")
	private String cou_name;
	
	@JsonProperty("CLASS_NAME")
	private String class_name;
	
	@JsonProperty("SUBJECT_NAME")
	private String subject_name;
	
	public String getStaff_id() {
		return staff_id;
	}
	
	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
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
	
	public String getClass_name() {
		return class_name;
	}
	
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	
	public String getSubject_name() {
		return subject_name;
	}
	
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	
	
}
