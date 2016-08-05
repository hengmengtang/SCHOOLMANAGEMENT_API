package org.khmeracademy.smg_btb.utils;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * for get list of data from database
 * @author Tang
 *
 * @param <T>
 */
public class ResponseList<T> extends Response{

	@JsonProperty("DATA")
	public List<T> data;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}
