package org.khmeracademy.smg_btb.entity.form.monthly_result;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Subject {

	/**
	 * result information
	 * @author Tang
	 *
	 */
	public static class resultInfo{
		
		@JsonProperty("RANK")
		private int rank;
		
		@JsonProperty("STUDENT_NAME")
		private String student_name;
		
		@JsonProperty("CLASS_NAME")
		private String class_name;
		
		@JsonProperty("GENDER")
		private String gender;

		public int getRank() {
			return rank;
		}

		public void setRank(int rank) {
			this.rank = rank;
		}

		public String getStudent_name() {
			return student_name;
		}

		public void setStudent_name(String student_name) {
			this.student_name = student_name;
		}

		public String getClass_name() {
			return class_name;
		}

		public void setClass_name(String class_name) {
			this.class_name = class_name;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}
		
	}
	
	/**
	 * subject in basic course
	 * @author Tang
	 *
	 */
	public static class basic{
		
		@JsonProperty("INFORMATION")
		private Subject.resultInfo info=new Subject.resultInfo();
		
		@JsonProperty("JAVA")
		private float java;
		
		@JsonProperty("WEB")
		private float web;
		
		@JsonProperty("KOREAN")
		private float korean;
		
		@JsonProperty("ATTENDANCE")
		private int attendance;
		
		@JsonProperty("TOTAL")
		private float total;

		public Subject.resultInfo getInfo() {
			return info;
		}

		public void setInfo(Subject.resultInfo info) {
			this.info = info;
		}

		public float getJava() {
			return java;
		}

		public void setJava(float java) {
			this.java = java;
		}

		public float getWeb() {
			return web;
		}

		public void setWeb(float web) {
			this.web = web;
		}

		public float getKorean() {
			return korean;
		}

		public void setKorean(float korean) {
			this.korean = korean;
		}

		public int getAttendance() {
			return attendance;
		}

		public void setAttendace(int attendance) {
			this.attendance = attendance;
		}

		public float getTotal() {
			return total;
		}

		public void setTotal(float total) {
			this.total = total;
		}
		
	}
}
