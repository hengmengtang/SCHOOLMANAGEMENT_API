package org.khmeracademy.smg_btb.repository.subject;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.khmeracademy.smg_btb.entity.form.max_id.MaxId;
import org.khmeracademy.smg_btb.entity.subject.Subject;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository {
 
	interface SQL{
		final String R_SUBJECT="SELECT * FROM smg_subject;";
		
		final String C_SUBJECT="INSERT INTO smg_subject("
					+ " subject_id,"
					+ " subject_name,"
					+ " description,"
					+ " active)"
					+ " VALUES("
					+ " #{subject_id},"
					+ " #{subject_name},"
					+ " #{description},"
					+ " #{active})";
		
		final String R_SELECT_MAX="SELECT 'sub' || lpad(MAX(split_part(sub_id, 'sub', 2)::int + 1)::text,4,'0') "
				+ "AS max_sub_id FROM smg_subject";
	}
	
	@Select(SQL.R_SUBJECT)
	@Results({
		@Result(property="subject_id" ,column="sub_id"),
		@Result(property="subject_name" ,column="sub_name"),
		@Result(property="description" ,column="description"),
		@Result(property="active" ,column="active")
	})
	public ArrayList<Subject> findAll();
	
	@Insert(SQL.C_SUBJECT)
	public boolean enrollSubject(Subject subject);
	
	@Select(SQL.R_SELECT_MAX)
	@Results({
		@Result(property="maxId",column="max_sub_id")
	})
	public MaxId selectMax();
}
