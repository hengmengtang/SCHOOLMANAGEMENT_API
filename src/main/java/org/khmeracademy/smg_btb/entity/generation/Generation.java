package org.khmeracademy.smg_btb.entity.generation;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Generation {

	@JsonProperty("GENERATION_ID")
	private String gen_id;
	
	@JsonProperty("GENERATION_NAME")
	private String gen_name;
	
	@JsonProperty("GENERATION_START_DATE")
	private String gen_start_date;
	
	@JsonProperty("GENERATION_END_DATE")
	private String gen_end_date;
	
	@JsonProperty("STATUS")
	private boolean status;

	public String getGen_id() {
		return gen_id;
	}

	public void setGen_id(String gen_id) {
		this.gen_id = gen_id;
	}

	public String getGen_name() {
		return gen_name;
	}

	public void setGen_name(String gen_name) {
		this.gen_name = gen_name;
	}

	public String getGen_start_date() {
		return gen_start_date;
	}

	public void setGen_start_date(String gen_start_date) {
		this.gen_start_date = gen_start_date;
	}

	public String getGen_end_date() {
		return gen_end_date;
	}

	public void setGen_end_date(String gen_end_date) {
		this.gen_end_date = gen_end_date;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
