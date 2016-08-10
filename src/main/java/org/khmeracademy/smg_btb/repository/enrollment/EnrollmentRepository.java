package org.khmeracademy.smg_btb.repository.enrollment;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;
import org.khmeracademy.smg_btb.entity.enrollment.Enrollment;
import org.khmeracademy.smg_btb.entity.form.close_course.CloseCourse;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository {

	interface SQL{
		/*final String R_ENROLLMENT="SELECT * FROM smg_enrollment";*/
		final String C_ENROLLMENT_STUDENT="{CALL enroll_student(#{generation_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{course_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{class_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{student_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{enroll_date,jdbcType=VARCHAR,mode=IN})}";
	}
	/*@Select(SQL.R_ENROLLMENT)
	@Results({
		@Result(property="enrollment_id",column="en_id"),
		@Result(property="",column="start_date"),
		@Result(property="end_date",column="end_date")
	})
	public ArrayList<Enrollment> findAll();
	*/
	@Insert(SQL.C_ENROLLMENT_STUDENT)
	@Options(statementType=StatementType.CALLABLE)
	public int enrollStudent(Enrollment.EnrollmentStudent enrollmentStudent);
	
}
