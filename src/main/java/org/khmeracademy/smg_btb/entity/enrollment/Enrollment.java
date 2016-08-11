package org.khmeracademy.smg_btb.entity.enrollment;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * enrollment for enroll generation or course or class
 * up on generation and course or class close up on 
 * generation too.
 * @author Tang
 *
 */
public class Enrollment {
	
	@JsonProperty("ENROLLMENT_ID")
	private String enrollment_id;
	
	/**
	 * enrollment_date for know what day that student enroll to generation,class and course
	 */
	
	@JsonProperty(value="ENROLLMENT_DATE")
	private String enroll_date;

	public String getEnrollment_id() {
		return enrollment_id;
	}

	public void setEnrollment_id(String enrollment_id) {
		this.enrollment_id = enrollment_id;
	}

	public String getEnroll_date() {
		return enroll_date;
	}

	public void setEnroll_date(String enroll_date) {
		this.enroll_date = enroll_date;
	}
	
	public static class EnrollmentStudent{
		
		@JsonProperty("GENERATION_NAME")
		private String generation_name;
		
		@JsonProperty("COURSE_NAME")
		private String course_name;
		
		@JsonProperty("CLASS_NAME")
		private String class_name;
		
		@JsonProperty("STUDENT_NAME")
		private String student_name;
		
		@JsonProperty("ENROLL_DATE")
		private String enroll_date;
		
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
		public String getStudent_name() {
			return student_name;
		}
		public void setStudent_name(String student_name) {
			this.student_name = student_name;
		}
		public String getEnroll_date() {
			return enroll_date;
		}
		public void setEnroll_date(String enroll_date) {
			this.enroll_date = enroll_date;
		}
		public int getSuccess() {
			return success;
		}
		public void setSuccess(int success) {
			this.success = success;
		}
		
	}
	
	
}
