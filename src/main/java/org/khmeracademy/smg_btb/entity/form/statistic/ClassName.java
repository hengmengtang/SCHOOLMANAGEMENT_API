package org.khmeracademy.smg_btb.entity.form.statistic;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClassName {

	@JsonProperty("MONTHLY")
	private String monthly;
	
	@JsonProperty("BTB")
	private float btb;
	
	@JsonProperty("KPS")
	private float kps;
	
	@JsonProperty("PP")
	private float pp;
	
	@JsonProperty("SR")
	private float sr;

	public String getMonthly() {
		return monthly;
	}

	public void setMonthly(String monthly) {
		this.monthly = monthly;
	}

	public float getBtb() {
		return btb;
	}

	public void setBtb(float btb) {
		this.btb = btb;
	}

	public float getKps() {
		return kps;
	}

	public void setKps(float kps) {
		this.kps = kps;
	}

	public float getPp() {
		return pp;
	}

	public void setPp(float pp) {
		this.pp = pp;
	}

	public float getSr() {
		return sr;
	}

	public void setSr(float sr) {
		this.sr = sr;
	}
	
	
}
