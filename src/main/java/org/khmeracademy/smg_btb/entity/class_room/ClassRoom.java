package org.khmeracademy.smg_btb.entity.class_room;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClassRoom {

	@JsonProperty("CLASS_ID")
	private int class_id;
	
	@JsonProperty("CLASS_NAME")
	private String class_name;
	
	@JsonProperty("CLASS_START_DATE")
	private String start_date;
	
	@JsonProperty("CLASS_END_DATE")
	private String end_date;
	
	/**
	 * if active =true
	 * mean class is available
	 * Inopportune not available 
	 */
	@JsonProperty("ACTIVE")
	private boolean active;

	public ClassRoom(){};
	
	public ClassRoom(int class_id, String class_name, String start_date, String end_date, boolean active) {
		super();
		this.class_id = class_id;
		this.class_name = class_name;
		this.start_date = start_date;
		this.end_date = end_date;
		this.active = active;
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	
}
