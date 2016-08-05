package org.khmeracademy.smg_btb.utils;

public interface ResponseMessage {

	String ERROR = "AN ERROR OCCUR...";
	String SUCCESS = "SUCCESSFULLY...";
	
	String INSERT_SUCCESS = "RECORD ADDED SUCCESSFULLY...";
	String INSERT_FAIL = "RECORD FAILED TO ADD...";
	
	String DELETE_SUCCESS = "RECORD DELETED SUCCESSFULLY...";
	String DELETE_FAIL = "RECORD DELETED FAILED...";
	
	String UPDATE_SUCCESS = "RECORD UPDATED SUCCESSFULLY...";
	String UPDATE_FAIL = "RECORD FAILED TO UPDATE...";
	
	String RECORD_FOUND = "RECORD FOUND...";
	String RECORD_NOT_FOUND = "RECORD NOT FOUND...";
}
