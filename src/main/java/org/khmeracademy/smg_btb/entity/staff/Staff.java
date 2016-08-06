package org.khmeracademy.smg_btb.entity.staff;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Staff {

	@JsonProperty("STAFF_ID")
	private int staff_id;
	
	@JsonProperty("KHMER_FULL_NAME")
	private String khmer_full_name;
	
	@JsonProperty("ENGLISH_FULL_NAME")
	private String eng_full_name;
	
	@JsonProperty("DATE_OF_BIRTH")
	private String dob;
	
	@JsonProperty("PLACE_OF_BIRTH")
	private String pob;
	
	@JsonProperty("GENDER")
	private String gender;
	
	@JsonProperty("PHONE")
	private String phone;
	
	@JsonProperty("EMAIL")
	private String email;
	
	@JsonProperty("FATHER_KHMER_FULL_NAME")
	private String father_khmer_full_name;
	
	@JsonProperty("FATHER_ENGLISH_FULL_NAME")
	private String father_eng_full_name;
	
	@JsonProperty("FATHER_OCCUPATION")
	private String father_occupation;
	
	@JsonProperty("PERMANENT_ADDRESS")
	private String permanent_address;
	
	@JsonProperty("FATHER_PHONE")
	private String father_phone;
	
	@JsonProperty("MOTHER_KHMER_FULL_NAME")
	private String mother_khmer_full_name;
	
	@JsonProperty("MOTHER_ENGLISH_FULL_NAME")
	private String mother_eng_full_name;
	
	@JsonProperty("MOTHER_OCCUPATION")
	private String mother_occupation;
	
	@JsonProperty("MOTHER_PERMANENT_ADDRESS")
	private String mother_permanent_address;
	
	@JsonProperty("MOTHER_PHONE")
	private String mother_phone;
	
	@JsonProperty("PHOTO")
	private String photo;
	
	@JsonProperty("STATUS")
	private boolean status;
	
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFather_khmer_full_name() {
		return father_khmer_full_name;
	}
	public void setFather_khmer_full_name(String father_khmer_full_name) {
		this.father_khmer_full_name = father_khmer_full_name;
	}
	public String getFather_eng_full_name() {
		return father_eng_full_name;
	}
	public void setFather_eng_full_name(String father_eng_full_name) {
		this.father_eng_full_name = father_eng_full_name;
	}
	public String getFather_occupation() {
		return father_occupation;
	}
	public void setFather_occupation(String father_occupation) {
		this.father_occupation = father_occupation;
	}
	public String getPermanent_address() {
		return permanent_address;
	}
	public void setPermanent_address(String permanent_address) {
		this.permanent_address = permanent_address;
	}
	public String getFather_phone() {
		return father_phone;
	}
	public void setFather_phone(String father_phone) {
		this.father_phone = father_phone;
	}
	public String getMother_khmer_full_name() {
		return mother_khmer_full_name;
	}
	public void setMother_khmer_full_name(String mother_khmer_full_name) {
		this.mother_khmer_full_name = mother_khmer_full_name;
	}
	public String getMother_eng_full_name() {
		return mother_eng_full_name;
	}
	public void setMother_eng_full_name(String mother_eng_full_name) {
		this.mother_eng_full_name = mother_eng_full_name;
	}
	public String getMother_occupation() {
		return mother_occupation;
	}
	public void setMother_occupation(String mother_occupation) {
		this.mother_occupation = mother_occupation;
	}
	public String getMother_permanent_address() {
		return mother_permanent_address;
	}
	public void setMother_permanent_address(String mother_permanent_address) {
		this.mother_permanent_address = mother_permanent_address;
	}
	public String getMother_phone() {
		return mother_phone;
	}
	public void setMother_phone(String mother_phone) {
		this.mother_phone = mother_phone;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
