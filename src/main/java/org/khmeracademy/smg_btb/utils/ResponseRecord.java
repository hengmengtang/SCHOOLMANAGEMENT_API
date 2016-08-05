package org.khmeracademy.smg_btb.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseRecord<T> extends Response{

	@JsonProperty("DATA")
	public T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseRecord [data=" + data + "]";
	}
}
