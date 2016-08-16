package org.khmeracademy.smg_btb.entity.form.add_mark;

import org.khmeracademy.smg_btb.entity.student.Student.getGenerationCourse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParamForGetSubject extends getGenerationCourse {

	@JsonProperty("STAFF_NAME")
	private String staff_name;
	
	@JsonProperty("CLASS_NAME")
	private String class_name;
	
	public String getStaff_name() {
		return staff_name;
	}
	
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	
	public String getClass_name() {
		return class_name;
	}
	
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	
	
}
