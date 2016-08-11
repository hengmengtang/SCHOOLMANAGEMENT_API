package org.khmeracademy.smg_btb.entity.subject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Subject {

	@JsonProperty("SUBJECT_ID")
	private String subject_id;
	
	@JsonProperty("SUBJECT_NAME")
	private String subject_name;
	/**
	 * teacher can have description
	 * for his subject 
	 */
	@JsonProperty("DESCRIPTION")
	private String description;
	
	/**
	 * if active = true then
	 * 	this subject is available
	 * else
	 * 	Unavailable
	 */
	@JsonProperty("ACTIVE")
	private boolean active;
	
	public Subject(){};
	
	public Subject(String subject_id,String subject_name,String description,boolean active){
		super();
		this.subject_id=subject_id;
		this.subject_name=subject_name;
		this.description=description;
		this.active=active;
	}
	public String getSubject_id() {
		return subject_id;
	}
	
	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}
	
	public String getSubject_name() {
		return subject_name;
	}
	
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
}
