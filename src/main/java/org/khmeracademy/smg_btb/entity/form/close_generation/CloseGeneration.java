package org.khmeracademy.smg_btb.entity.form.close_generation;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CloseGeneration {

	@JsonProperty("SUCCESS")
	private int success;

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}
	
	
}
