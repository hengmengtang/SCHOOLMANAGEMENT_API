package org.khmeracademy.smg_btb.entity.generation;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Generation {

	@JsonProperty("GENERATION_ID")
	private int gen_id;
	
	@JsonProperty("GENERATION_NAME")
	private String gen_name;
	
	public Generation(){};
	
	public Generation(int gen_id,String gen_name){
		super();
		this.gen_id=gen_id;
		this.gen_name=gen_name;
	}
	
	public String getGen_name() {
		return gen_name;
	}
	
	public void setGen_name(String gen_name) {
		this.gen_name = gen_name;
	}
	
	public int getGen_id() {
		return gen_id;
	}
	
	public void setGen_id(int gen_id) {
		this.gen_id = gen_id;
	}
	
}
