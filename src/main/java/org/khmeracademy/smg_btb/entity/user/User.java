package org.khmeracademy.smg_btb.entity.user;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	Date today=new Date();
	
	SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd");
	
	@JsonProperty("USER_ID")
	private int user_id;
	
	@JsonProperty("USERNAME")
	private String username;
	
	@JsonProperty("PASSWORD")
	private String password;
	
	@JsonProperty("POSSITION")
	private String possition;
	
	@JsonProperty(value="DATE")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private String date =time.toString();
	
	@JsonProperty("STATUS")
	private boolean status;
	
	@JsonProperty("PHONE")
	private String phone;
	
	public User(){};
	
	public User(int user_id, String username, String password, String possition, String date, boolean status,
			String phone) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.possition = possition;
		this.date = date;
		this.status = status;
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
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
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
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
	public String getPossition() {
		return possition;
	}
	public void setPossition(String possition) {
		this.possition = possition;
	}
	
	
}
