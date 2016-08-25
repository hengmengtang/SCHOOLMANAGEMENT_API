package org.khmeracademy.smg_btb.entity.class_room;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClassRoom {

	@JsonProperty("CLASS_ID")
	private String class_id;
	
	@JsonProperty("CLASS_NAME")
	private String class_name;
	
	/**
	 * if active =true
	 * mean class is available
	 * Inopportune not available 
	 */
	@JsonProperty("ACTIVE")
	private boolean active;

	public ClassRoom(){};
	
	public ClassRoom(String class_id, String class_name, boolean active) {
		super();
		this.class_id = class_id;
		this.class_name = class_name;
		this.active = active;
	}

	public String getClass_id() {
		return class_id;
	}

	public void setClass_id(String class_id) {
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

}
