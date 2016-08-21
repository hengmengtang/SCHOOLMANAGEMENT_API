package org.khmeracademy.smg_btb.entity.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	
	@JsonProperty("USER_ID")
	private String user_id;
	
	@JsonProperty("USERNAME")
	private String username;
	
	@JsonProperty("PASSWORD")
	private String password;
	
	@JsonProperty(value="DATE")
	private String date;
	
	@JsonProperty("STATUS")
	private boolean status;
	
	@JsonProperty("EMAIL")
	private String email;
	
	@JsonProperty("ROLE")
	private String role;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User(){};
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
