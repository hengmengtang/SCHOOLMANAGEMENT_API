package org.khmeracademy.smg_btb.entity.handle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HandleSubjectToStaffToClassRoom {

	@JsonProperty("STAFF_HANDLE_NAME")
	private String staff_handle_name;
	
	@JsonProperty("CLASS_ROOM_NAME")
	private String class_room_name;
	
	@JsonProperty("SUBJECT_TYPE_NAME")
	private String subject_type_name;
	
	@JsonProperty("DATE")
	private String date;
	
	@JsonProperty("SUCCESS")
	private int success;
	
	public String getStaff_handle_name() {
		return staff_handle_name;
	}
	
	public void setStaff_handle_name(String staff_handle_name) {
		this.staff_handle_name = staff_handle_name;
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
	
	public int getSuccess() {
		return success;
	}
	
	public void setSuccess(int success) {
		this.success = success;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
		
}
