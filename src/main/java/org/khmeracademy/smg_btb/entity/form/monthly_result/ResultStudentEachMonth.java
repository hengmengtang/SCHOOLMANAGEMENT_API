package org.khmeracademy.smg_btb.entity.form.monthly_result;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultStudentEachMonth {

	@JsonProperty("SUBJECT_NAME")
	private String subject_name;
	
	@JsonProperty("MARK")
	private float mark;
	
	@JsonProperty("MONTH")
	private String month;

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
	
}
