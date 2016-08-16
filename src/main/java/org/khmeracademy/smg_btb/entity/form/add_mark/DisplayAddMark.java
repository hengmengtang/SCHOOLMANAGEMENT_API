package org.khmeracademy.smg_btb.entity.form.add_mark;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DisplayAddMark {

	@JsonProperty("ENGLISH_FULL_NAME")
	private String eng_full_name;
	
	@JsonProperty("COURSE_NAME")
	private String cou_name;
	
	@JsonProperty("CLASS_NAME")
	private String class_name;
	
	public String getEng_full_name() {
		return eng_full_name;
	}
	
	public void setEng_full_name(String eng_full_name) {
		this.eng_full_name = eng_full_name;
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
	
}
