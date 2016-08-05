package org.khmeracademy.smg_btb.utils;

public interface JSONResponse {
	/**
	 * 
	 * Key
	 *
	 */
	public interface key {
		public String DATA = "DATA";
		public String COUNT = "COUNT";
		public String MESSAGE = "MESSAGE";
		public String STATUS = "STATUS";
	}

	/**
	 * 
	 * Value
	 *
	 */
	public interface value {
		public String TRASACTION_FAIL = "TRASACTION_FAIL";
		public String RECORD_NOT_FOUND = "RECORD_NOT_FOUND";
		public String TRSACTION_SUCCESS = "TRANSACTION_SUCCESS";
	}
}
