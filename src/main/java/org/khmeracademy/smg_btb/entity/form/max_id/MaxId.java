package org.khmeracademy.smg_btb.entity.form.max_id;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * class MaxId for used for generate auto student id from database
 * @author Tang
 *
 */
public class MaxId{
	
	@JsonProperty("MAX_ID")
	private String maxId;

	public String getMaxId() {
		return maxId;
	}

	public void setMaxId(String maxId) {
		this.maxId = maxId;
	}
}
