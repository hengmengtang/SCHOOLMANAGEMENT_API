package org.khmeracademy.smg_btb.entity.form.monthly_result;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubjectBasic {

	@JsonProperty("MONTHLY_RESULT")
	private MonthlyResult monthlyResult=new MonthlyResult();
	
	@JsonProperty("SCORE")
	private float score;
	
	/*@JsonProperty("JAVA")
	private float java;
	
	@JsonProperty("WEB")
	private float web;
	
	@JsonProperty("KOREAN")
	private float korean;
	
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
	}*/
	
	public MonthlyResult getMonthlyResult() {
		return monthlyResult;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}
	
	
}
