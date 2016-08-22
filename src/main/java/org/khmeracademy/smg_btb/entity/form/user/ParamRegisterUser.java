package org.khmeracademy.smg_btb.entity.form.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParamRegisterUser {

	@JsonProperty("USERNAME")
	private String username;
	
	@JsonProperty("PASSWORD")
	private String password;
	
	@JsonProperty("EMAIL")
	private String email;
	
	@JsonProperty("SUCCESS")
	private int success;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	
	
}
