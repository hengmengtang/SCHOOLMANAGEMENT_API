package org.khmeracademy.smg_btb.entity.mark;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Mark {

	@JsonProperty("MARK_ID")
	private int mark_id;
	
	@JsonProperty("DATE")
	private Date date;
	
	@JsonProperty("MARK")
	private float mark;
	
	public Mark(){};
	
	public Mark(int mark_id,Date date,float mark){
		super();
		this.mark_id=mark_id;
		this.date=date;
		this.mark=mark;
	}
	
	public int getMark_id() {
		return mark_id;
	}
	
	public void setMark_id(int mark_id) {
		this.mark_id = mark_id;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public float getMark() {
		return mark;
	}
	
	public void setMark(float mark) {
		this.mark = mark;
	}
	
}
