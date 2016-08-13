package org.khmeracademy.smg_btb.entity.form.display_student_to_enroll;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DisplayStudentToEnroll {

	@JsonProperty("STUDENT_ID")
	private String stu_id;
	
	@JsonProperty("KHMER_FULL_NAME")
	private String khmer_full_name;
	
	@JsonProperty("ENGLISH_FULL_NAME")
	private String eng_full_name;
	
	@JsonProperty("GENDER")
	private String gender;
	
	@JsonProperty("EMAIL")
	private String email;
	
	@JsonProperty("UNIVERSITY")
	private String university;
	
	@JsonProperty("ADDRESS")
	private String address;
	
	public String getStu_id() {
		return stu_id;
	}
	
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	
	public String getKhmer_full_name() {
		return khmer_full_name;
	}
	
	public void setKhmer_full_name(String khmer_full_name) {
		this.khmer_full_name = khmer_full_name;
	}
	
	public String getEng_full_name() {
		return eng_full_name;
	}
	
	public void setEng_full_name(String eng_full_name) {
		this.eng_full_name = eng_full_name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUniversity() {
		return university;
	}
	
	public void setUniversity(String university) {
		this.university = university;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
}
