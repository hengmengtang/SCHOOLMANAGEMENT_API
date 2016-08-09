package org.khmeracademy.smg_btb.entity.staff;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Staff {

	@JsonProperty("STAFF_ID")
	private int staff_id;
	
	@JsonProperty("KHMER_FULL_NAME")
	private String khmer_full_name;
	
	@JsonProperty("ENGLIST_FULL_NAME")
	private String eng_full_name;

	@JsonProperty("GENDER")
	private char gender;
	
	@JsonProperty("DATE_OF_BIRTH")
	private String dob;
	
	@JsonProperty("PLACE_OF_BIRTH")
	private String pob;
	
	@JsonProperty("EMAIL")
	private String email;
	
	@JsonProperty("PERMANENT_ADDRESS")
	private String permanent_address;
	
	@JsonProperty("PHONE")
	private String phone;
	
	@JsonProperty("EDUCATION_LEVEL")
	private String education_level;
	
	@JsonProperty("ENGLISH_LEVEL")
	private String english_level;
	
	@JsonProperty("KOREAN_LEVEL")
	private String korean_level;
	
	@JsonProperty("STUDENT_STATUS")
	private String student_status;
	
	@JsonProperty("GRADUATE")
	private String graduate;
	
	@JsonProperty("UNIVERSITY")
	private String university;
	
	@JsonProperty("KHMER_ID_NUMBER")
	private String khmer_id;
	
	@JsonProperty("PHOTO")
	private String photo;
	
	@JsonProperty("FATHER_ENGLISH_NAME")
	private String father_eng_name;
	
	@JsonProperty("FATHER_KHMER_NAME")
	private String father_khmer_name;
	
	@JsonProperty("FATHER_OCCUPATION")
	private String father_occupation;
	
	@JsonProperty("FATHER_ADDRESS")
	private String father_address;
	
	@JsonProperty("FATHER_PHONE")
	private String father_phone;
	
	@JsonProperty("MOTHER_KHMER_NAME")
	private String mother_khmer_name;
	
	@JsonProperty("MOTHER_ENGLISH_NAME")
	private String mother_eng_name;
	
	@JsonProperty("MOTHER_OCCUPATION")
	private String mother_occupation;
	
	@JsonProperty("MOTHER_ADDRESS")
	private String mother_address;
	
	@JsonProperty("MOTHER_PHONE")
	private String mother_phone;
	
	@JsonProperty("STATUS")
	private boolean status;
	
	@JsonProperty("DATE")
	private String date;
	

	public Staff(){}

	public Staff(int staff_id, String khmer_full_name, String eng_full_name, char gender, String dob, String pob,
			String email, String permanent_address, String phone, String education_level, String english_level,
			String korean_level, String student_status, String graduate, String university, String khmer_id,
			String photo, String father_eng_name, String father_khmer_name, String father_occupation,
			String father_address, String father_phone, String mother_khmer_name, String mother_eng_name,
			String mother_occupation, String mother_address, String mother_phone, boolean status, String date) {
		super();
		this.staff_id = staff_id;
		this.khmer_full_name = khmer_full_name;
		this.eng_full_name = eng_full_name;
		this.gender = gender;
		this.dob = dob;
		this.pob = pob;
		this.email = email;
		this.permanent_address = permanent_address;
		this.phone = phone;
		this.education_level = education_level;
		this.english_level = english_level;
		this.korean_level = korean_level;
		this.student_status = student_status;
		this.graduate = graduate;
		this.university = university;
		this.khmer_id = khmer_id;
		this.photo = photo;
		this.father_eng_name = father_eng_name;
		this.father_khmer_name = father_khmer_name;
		this.father_occupation = father_occupation;
		this.father_address = father_address;
		this.father_phone = father_phone;
		this.mother_khmer_name = mother_khmer_name;
		this.mother_eng_name = mother_eng_name;
		this.mother_occupation = mother_occupation;
		this.mother_address = mother_address;
		this.mother_phone = mother_phone;
		this.status = status;
		this.date = date;
	}

	public int getStaff_id() {
		return staff_id;
	}


	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
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


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getPob() {
		return pob;
	}


	public void setPob(String pob) {
		this.pob = pob;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPermanent_address() {
		return permanent_address;
	}


	public void setPermanent_address(String permanent_address) {
		this.permanent_address = permanent_address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEducation_level() {
		return education_level;
	}


	public void setEducation_level(String education_level) {
		this.education_level = education_level;
	}


	public String getGraduate() {
		return graduate;
	}


	public void setGraduate(String graduate) {
		this.graduate = graduate;
	}


	public String getUniversity() {
		return university;
	}


	public void setUniversity(String university) {
		this.university = university;
	}


	public String getKhmer_id() {
		return khmer_id;
	}


	public void setKhmer_id(String khmer_id) {
		this.khmer_id = khmer_id;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String getFather_eng_name() {
		return father_eng_name;
	}


	public void setFather_eng_name(String father_eng_name) {
		this.father_eng_name = father_eng_name;
	}


	public String getFather_khmer_name() {
		return father_khmer_name;
	}


	public void setFather_khmer_name(String father_khmer_name) {
		this.father_khmer_name = father_khmer_name;
	}


	public String getFather_occupation() {
		return father_occupation;
	}


	public void setFather_occupation(String father_occupation) {
		this.father_occupation = father_occupation;
	}


	public String getFather_address() {
		return father_address;
	}


	public void setFather_address(String father_address) {
		this.father_address = father_address;
	}


	public String getFather_phone() {
		return father_phone;
	}


	public void setFather_phone(String father_phone) {
		this.father_phone = father_phone;
	}


	public String getMother_khmer_name() {
		return mother_khmer_name;
	}


	public void setMother_khmer_name(String mother_khmer_name) {
		this.mother_khmer_name = mother_khmer_name;
	}


	public String getMother_eng_name() {
		return mother_eng_name;
	}


	public void setMother_eng_name(String mother_eng_name) {
		this.mother_eng_name = mother_eng_name;
	}


	public String getMother_occupation() {
		return mother_occupation;
	}


	public void setMother_occupation(String mother_occupation) {
		this.mother_occupation = mother_occupation;
	}


	public String getMother_address() {
		return mother_address;
	}


	public void setMother_address(String mother_address) {
		this.mother_address = mother_address;
	}


	public String getMother_phone() {
		return mother_phone;
	}


	public void setMother_phone(String mother_phone) {
		this.mother_phone = mother_phone;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getEnglish_level() {
		return english_level;
	}


	public void setEnglish_level(String english_level) {
		this.english_level = english_level;
	}


	public String getKorean_level() {
		return korean_level;
	}


	public void setKorean_level(String korean_level) {
		this.korean_level = korean_level;
	}


	public String getStudent_status() {
		return student_status;
	}


	public void setStudent_status(String student_status) {
		this.student_status = student_status;
	}
	
	
}
