package org.khmeracademy.smg_btb.entity.mark;


import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.form.add_mark.AddMark;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Mark {
	
	@JsonProperty("MARK")
	private float mark;
	
	@JsonProperty("PARAMETER_FOR_ADD_MARK")
	private AddMark paramMark=new AddMark();
	
	@JsonProperty("SUCCESS")
	private int success;
	
	public Mark(){};
	
	public float getMark() {
		return mark;
	}
	
	public void setMark(float mark) {
		this.mark = mark;
	}

	public AddMark getParamMark() {
		return paramMark;
	}

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}
	
	
}
