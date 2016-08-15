package org.khmeracademy.smg_btb.repository.course;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.khmeracademy.smg_btb.entity.course.Course;
import org.khmeracademy.smg_btb.entity.form.max_id.MaxId;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository {

	interface SQL{
		final String R_COURSE="SELECT * FROM smg_course;";
		
		final String C_COURSE="INSERT INTO smg_course("
					+ " cou_id,"
					+ " cou_name,"
					+ " start_date,"
					+ " end_date,"
					+ " active)"
					+ " VALUES("
					+ " #{course_id},"
					+ " #{course_name},"
					+ " #{cou_start_date},"
					+ " #{cou_end_date},"
					+ " #{status})";
		
		final String R_SELECT_MAX="SELECT 'cou' || lpad(MAX(split_part(cou_id, 'cou', 2)::int + 1)::text,4,'0') "
				+ "AS max_cou_id FROM smg_course";
		
		final String R_SELECT_LAST_COURSE="SELECT cou_id,cou_name FROM smg_course WHERE active='t'"
				+ "AND end_date>=now()::DATE::TEXT;";
	}
	
	@Select(SQL.R_COURSE)
	@Results({
		@Result(property="course_id" ,column="cou_id"),
		@Result(property="course_name" ,column="cou_name"),
		@Result(property="cou_start_date" ,column="start_date"),
		@Result(property="cou_end_date" ,column="end_date"),
		@Result(property="status" ,column="active")
	})
	public ArrayList<Course> findAll();
	
	@Insert(SQL.C_COURSE)
	public boolean registerCourse(Course course);
	
	@Select(SQL.R_SELECT_MAX)
	@Results({
		@Result(property="maxId",column="max_cou_id")
	})
	public MaxId selectMax();
	
	@Select(SQL.R_SELECT_LAST_COURSE)
	@Results({
		@Result(property="course_id" ,column="cou_id"),
		@Result(property="course_name" ,column="cou_name"),
		@Result(property="cou_start_date" ,column="start_date"),
		@Result(property="cou_end_date" ,column="end_date"),
		@Result(property="status" ,column="active")
	})
	public ArrayList<Course> getLastCourse();
}
