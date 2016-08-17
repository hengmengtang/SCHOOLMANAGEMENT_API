package org.khmeracademy.smg_btb.entity.form.add_mark;

import org.khmeracademy.smg_btb.entity.student.Student.getCourseByStaffGenerationCourse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParamForGetSubject extends getCourseByStaffGenerationCourse {
	
	@JsonProperty("CLASS_NAME")
	private String class_name;
	
	
	public String getClass_name() {
		return class_name;
	}
	
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	
	
}
