package org.khmeracademy.smg_btb.entity.form.add_mark;


import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddMark {

	@JsonProperty("STAFF_NAME")
	private String staff_name;
	
	@JsonProperty("CLASS_ROOM_NAME")
	private String class_room_name;
	
	@JsonProperty("SUBJECT_TYPE_NAME")
	private String subject_type_name;
	
	@JsonProperty("STUDENT_NAME")
	private String student_name;
	
	public String getStaff_name() {
		return staff_name;
	}
	
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	
	public String getClass_room_name() {
		return class_room_name;
	}
	
	public void setClass_room_name(String class_room_name) {
		this.class_room_name = class_room_name;
	}
	
	public String getSubject_type_name() {
		return subject_type_name;
	}
	
	public void setSubject_type_name(String subject_type_name) {
		this.subject_type_name = subject_type_name;
	}
	
	public String getStudent_name() {
		return student_name;
	}
	
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	
}
