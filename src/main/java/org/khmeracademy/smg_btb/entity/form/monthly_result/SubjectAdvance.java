package org.khmeracademy.smg_btb.entity.form.monthly_result;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubjectAdvance {

	@JsonProperty("MONTHLY_RESULT")
	private MonthlyResult monthlyResult=new MonthlyResult();
	
	@JsonProperty("IOS")
	private float ios;
	
	@JsonProperty("SPRING")
	private float spring;
	
	@JsonProperty("ANDROID")
	private float android;

	public float getIos() {
		return ios;
	}

	public void setIos(float ios) {
		this.ios = ios;
	}

	public float getSpring() {
		return spring;
	}

	public void setSpring(float spring) {
		this.spring = spring;
	}

	public float getAndroid() {
		return android;
	}

	public void setAndroid(float android) {
		this.android = android;
	}

	public MonthlyResult getMonthlyResult() {
		return monthlyResult;
	}

}
