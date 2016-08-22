package org.khmeracademy.smg_btb.entity.form.mark;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParamUpdateScore {

	@JsonProperty("MARK_ID")
	private int mark_id;
	
	@JsonProperty("MARK")
	private float mark;
	
	public int getMark_id() {
		return mark_id;
	}
	
	public void setMark_id(int mark_id) {
		this.mark_id = mark_id;
	}
	
	public float getMark() {
		return mark;
	}
	
	public void setMark(float mark) {
		this.mark = mark;
	}
	
}
