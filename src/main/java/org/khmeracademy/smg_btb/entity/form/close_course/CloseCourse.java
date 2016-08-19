package org.khmeracademy.smg_btb.entity.form.close_course;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CloseCourse {

	private String end_date;
	private boolean is_finish;
	
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public boolean isIs_finish() {
		return is_finish;
	}
	public void setIs_finish(boolean is_finish) {
		this.is_finish = is_finish;
	}
	
	public static class paramCloseCorse{
		
		@JsonProperty("GENERATION_NAME")
		private String generation_name;
		
		@JsonProperty("COURSE_NAME")
		private String course_name;
		
		@JsonProperty("CLASS_NAME")
		private String class_name;
		
		@JsonProperty("SUCCESS")
		private int success;
		
		public String getGeneration_name() {
			return generation_name;
		}
		
		public void setGeneration_name(String generation_name) {
			this.generation_name = generation_name;
		}
		
		public String getCourse_name() {
			return course_name;
		}
		
		public void setCourse_name(String course_name) {
			this.course_name = course_name;
		}
		
		public String getClass_name() {
			return class_name;
		}
		
		public void setClass_name(String class_name) {
			this.class_name = class_name;
		}

		public int getSuccess() {
			return success;
		}

		public void setSuccess(int success) {
			this.success = success;
		}
		
		
	}
	
}
