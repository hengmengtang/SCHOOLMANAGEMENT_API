package org.khmeracademy.smg_btb.entity.enrollment;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * enrollment for enroll generation or course or class
 * up on generation and course or class close up on 
 * generation too.
 * @author Tang
 *
 */
public class Enrollment {
	Date today=new Date();
	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	
	@JsonProperty("ENROLLMENT_ID")
	private int enrollment_id;
	
	/**
	 * start_date can be start generation or course or class
	 */
	@JsonProperty("START_DATE")
	private String start_date;
	
	@JsonProperty(value="END_DATE")
	private String end_date;
	
	/**
	 * if isFinish=true mean generation or course or class is active
	 * else closed 
	 */
	@JsonProperty("IS_FINIST")
	private boolean is_finish;
	
	public Enrollment(){};
	
	public Enrollment(int enrollment_id,String start_date,String end_date,boolean isFinish){
		super();
		this.enrollment_id=enrollment_id;
		this.start_date=start_date;
		this.end_date=end_date;
	}
	public int getEnrollment_id() {
		return enrollment_id;
	}
	
	public void setEnrollment_id(int enrollment_id) {
		this.enrollment_id = enrollment_id;
	}
	
	public String getStart_date() {
		return start_date=df.format(today);
	}
	
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	
	public String getEnd_date() {
		return end_date;
	}
	
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public boolean isIs_finish() {
		return is_finish;
	}

	public void setIs_finish(boolean is_finish) {
		this.is_finish = is_finish;
	}
	
}
