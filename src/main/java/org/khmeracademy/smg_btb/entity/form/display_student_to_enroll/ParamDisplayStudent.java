package org.khmeracademy.smg_btb.entity.form.display_student_to_enroll;

import org.khmeracademy.smg_btb.entity.student.Student.getCourseByStaffGenerationCourse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParamDisplayStudent extends getCourseByStaffGenerationCourse{

	@JsonProperty("CLASS_NAME")
	private String class_name;
	
	@JsonProperty("SUBJECT_NAME")
	private String subject_name;
	
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
