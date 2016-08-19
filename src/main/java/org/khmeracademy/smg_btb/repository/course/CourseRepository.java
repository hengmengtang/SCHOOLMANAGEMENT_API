package org.khmeracademy.smg_btb.repository.course;

import java.util.ArrayList;

import javax.ws.rs.OPTIONS;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;
import org.khmeracademy.smg_btb.entity.course.Course;
import org.khmeracademy.smg_btb.entity.form.close_course.CloseCourse;
import org.khmeracademy.smg_btb.entity.form.list_course.ListCourse;
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
		
		final String R_SELECT_LAST_COURSE="SELECT cou_id,cou_name,active FROM smg_course WHERE active='t'"
				+ "AND end_date>=now()::DATE::TEXT;";
		
		final String R_SELECT_LIST_COURSE="SELECT DISTINCT cou.cou_id,gen.gen_name,cou.cou_name,cou.start_date,cou.end_date,cou.active"
				+ " FROM smg_course cou"
				+ " INNER JOIN smg_enrollment en ON cou.cou_id=en.course_id"
				+ " INNER JOIN smg_generation gen ON en.gen_id=gen.gen_id"
				+ " ORDER BY gen.gen_name,cou.start_date";
		
		final String R_CHANGE_STATUS_COURSE="UPDATE smg_course SET active=CASE WHEN active='t' THEN active='f' ELSE"
				+ " active='f' END WHERE cou_id=#{course_id};";
		
		final String U_STATUS_COURSE="{CALL change_status_course("
				+ "#{generation_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{course_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{success,jdbcType=INTEGER,mode=OUT})}";
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
	public Course getLastCourse();
	
	@Select(SQL.R_SELECT_LIST_COURSE)
	public ArrayList<ListCourse> listCourseTamGeneration();
	
	@Update(SQL.R_CHANGE_STATUS_COURSE)
	public boolean changeStatusCourse(String course_id);
	
	@Update(SQL.U_STATUS_COURSE)
	@Options(statementType=StatementType.CALLABLE)
	public int changeStatusCourseWithClass(CloseCourse.paramCloseCorse closeCourse);
}
