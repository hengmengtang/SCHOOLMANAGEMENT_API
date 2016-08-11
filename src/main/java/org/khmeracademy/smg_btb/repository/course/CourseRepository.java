package org.khmeracademy.smg_btb.repository.course;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.khmeracademy.smg_btb.entity.course.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository {

	interface SQL{
		final String R_COURSE="SELECT * FROM smg_course;";
		
		final String C_COURSE="{CALL enroll_course(#{course_id,jdbcType=VARCHAR,mode=IN},"
				+ "#{course_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{cou_start_date,jdbcType=VARCHAR,mode=IN},"
				+ "#{cou_end_date,jdbcType=VARCHAR,mode=IN},"
				+ "#{status,jdbcType=BOOLEAN,mode=IN},"
				+ "#{success,jdbcType=INTEGER,mode=OUT})}";
	}
	
	@Select(SQL.R_COURSE)
	@Results({
		@Result(property="course_id" ,column="cou_id"),
		@Result(property="course_name" ,column="cou_name"),
		@Result(property="cou_start_date" ,column="cou_start_date"),
		@Result(property="cou_end_date" ,column="cou_end_date"),
		@Result(property="status" ,column="active")
	})
	public ArrayList<Course> findAll();
	
	@Insert(SQL.C_COURSE)
	@Options(statementType=StatementType.CALLABLE)
	public int registerCourse(Course course);
}
