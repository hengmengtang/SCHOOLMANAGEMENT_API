package org.khmeracademy.smg_btb.entity.result;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {

	@JsonProperty("RESULT_ID")
	private int result_id;
	
	/**
	 * rank lower for set the lowest score for for rank grade
	 */
	@JsonProperty("RANK_LOWER")
	private int rank_lower;
	
	/**
	 * rank top for set the highest score for rank grade 
	 */
	@JsonProperty("RANK_TOP")
	private int rank_top;
	
	/**
	 * grade can calculate between rank_lower and rank 
	 * top to get grade later for transcript at the last
	 */
	@JsonProperty("GRADE")
	private String grade;
	
	@JsonProperty("DATE")
	private Date date;
	
	@JsonProperty("DESCRIPTION")
	private String description;
	
	public Result(){};
	
	public Result(int result_id,int rank_lower,int rank_top,Date date,String description){
		super();
		this.result_id=result_id;
		this.rank_lower=rank_lower;
		this.rank_top=rank_top;
		this.date=date;
		this.description=description;
	}
	public int getResult_id() {
		return result_id;
	}
	
	public void setResult_id(int result_id) {
		this.result_id = result_id;
	}
	
	public int getRank_lower() {
		return rank_lower;
	}
	
	public void setRank_lower(int rank_lower) {
		this.rank_lower = rank_lower;
	}
	
	public int getRank_top() {
		return rank_top;
	}
	
	public void setRank_top(int rank_top) {
		this.rank_top = rank_top;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
