package org.khmeracademy.smg_btb.repository.course;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.khmeracademy.smg_btb.entity.course.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository {

	interface SQL{
		final String R_COURSE="SELECT * FROM smg_course;";
	}
	
	@Select(SQL.R_COURSE)
	@Results({
		@Result(property="course_id" ,column="cou_id"),
		@Result(property="course_name" ,column="cou_name"),
		@Result(property="cou_start_date" ,column="cou_start_date"),
		@Result(property="cou_end_date" ,column="cou_end_date")
	})
	public ArrayList<Course> findAll();
}
