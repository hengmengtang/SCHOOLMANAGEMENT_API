package org.khmeracademy.smg_btb.entity.enrollment;

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

	@JsonProperty("ENROLLMENT_ID")
	private int enrollment_id;
	
	/**
	 * start_date can be start generation or course or class
	 */
	@JsonProperty("START_DATE")
	private Date start_date;
	
	@JsonProperty("END_DATE")
	private Date end_date;
	
	/**
	 * if isFinish=true mean generation or course or class is active
	 * else closed 
	 */
	@JsonProperty("IS_FINIST")
	private boolean isFinish;
	
	public Enrollment(){};
	
	public Enrollment(int enrollment_id,Date start_date,Date end_date,boolean isFinish){
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
	
	public Date getStart_date() {
		return start_date;
	}
	
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	
	public Date getEnd_date() {
		return end_date;
	}
	
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	
	public boolean isFinish() {
		return isFinish;
	}
	
	public void setFinish(boolean isFinish) {
		this.isFinish = isFinish;
	}
	
}
