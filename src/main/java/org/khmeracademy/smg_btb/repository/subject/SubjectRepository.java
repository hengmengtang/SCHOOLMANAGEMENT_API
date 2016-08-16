package org.khmeracademy.smg_btb.repository.subject;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.khmeracademy.smg_btb.entity.form.max_id.MaxId;
import org.khmeracademy.smg_btb.entity.student.Student;
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
		

		final String R_GET_SUBJECT_IN_COURSE="SELECT sub.subject_name FROM smg_generation gen"
				+ " LEFT JOIN smg_handlings h ON gen.gen_id=h.gen_id"
				+ " LEFT JOIN smg_subject sub ON h.sub_id=sub.subject_id"
				+ " LEFT JOIN smg_course cou ON h.cou_id=cou.cou_id"
				+ " WHERE gen.gen_name=#{generation_name} AND cou.cou_name=#{course_name};";
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
	
	/**
	 * get subject in current generation and course
	 * @param generation_name
	 * @param course_name
	 * @return
	 */
	@Select(SQL.R_GET_SUBJECT_IN_COURSE)
	@Results({
		@Result(property="subject_id" ,column="sub_id"),
		@Result(property="subject_name" ,column="sub_name"),
		@Result(property="description" ,column="description"),
		@Result(property="active" ,column="active")
	})
	public ArrayList<Subject> getSubjectInCourse(Student.getGenerationCourse generationCourse);
}
