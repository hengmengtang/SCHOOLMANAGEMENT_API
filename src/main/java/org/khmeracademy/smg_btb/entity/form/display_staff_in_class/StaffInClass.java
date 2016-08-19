package org.khmeracademy.smg_btb.entity.form.display_staff_in_class;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StaffInClass {

	@JsonProperty("KHMER_FULL_NAME")
	private String khmer_full_name;
	
	@JsonProperty("ENGLISH_FULL_NAME")
	private String eng_full_name;
	
	@JsonProperty("CLASS_NAME")
	private String class_name;
	
	@JsonProperty("SUBJECT_NAME")
	private String subject_name;
	
	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	@JsonProperty("DATE")
	private String date;
	
	public String getKhmer_full_name() {
		return khmer_full_name;
	}
	
	public void setKhmer_full_name(String khmer_full_name) {
		this.khmer_full_name = khmer_full_name;
	}
	
	public String getEng_full_name() {
		return eng_full_name;
	}
	
	public void setEng_full_name(String eng_full_name) {
		this.eng_full_name = eng_full_name;
	}
	
	public String getClass_name() {
		return class_name;
	}
	
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
