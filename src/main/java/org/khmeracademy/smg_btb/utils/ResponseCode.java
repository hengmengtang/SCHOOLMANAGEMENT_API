package org.khmeracademy.smg_btb.utils;

/**
 * for response code to client
 * @author Tang
 *
 */
public interface ResponseCode {

	String FAIL = "401";
	String SUCCESS = "200";

	String INSERT_SUCCESS = "201";
	String INSERT_FAIL = "406";

	String DELETE_SUCCESS = "202";
	String DELETE_FAIL = "407";

	String UPDATE_SUCCESS = "3000";
	String UPDATE_FAIL = "3001";

	String RECORD_FOUND = "4000";
	String RECORD_NOT_FOUND = "4001";
}
