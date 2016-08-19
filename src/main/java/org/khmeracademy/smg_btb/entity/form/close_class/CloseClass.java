package org.khmeracademy.smg_btb.entity.form.close_class;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CloseClass {

	@JsonProperty("CLASS_NAME")
	private String class_name;
	
	@JsonProperty("SUCCESS")
	private String success;

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	
}
