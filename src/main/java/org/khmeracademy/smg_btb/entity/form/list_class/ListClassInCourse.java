package org.khmeracademy.smg_btb.entity.form.list_class;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListClassInCourse {

	@JsonProperty("CLASS_ID")
	private String class_id;
	
	@JsonProperty("CLASS_NAME")
	private String class_name;
	
	@JsonProperty("COURSE_NAME")
	private String cou_name;
	
	@JsonProperty("GENERATION_NAME")
	private String gen_name;
	
	@JsonProperty("ACTIVE")
	private boolean active;
	
	public String getClass_id() {
		return class_id;
	}
	
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	
	public String getClass_name() {
		return class_name;
	}
	
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	
	public String getCou_name() {
		return cou_name;
	}
	
	public void setCou_name(String cou_name) {
		this.cou_name = cou_name;
	}
	
	public String getGen_name() {
		return gen_name;
	}
	
	public void setGen_name(String gen_name) {
		this.gen_name = gen_name;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
