package org.khmeracademy.smg_btb.repository.enrollment;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.mapping.StatementType;
import org.khmeracademy.smg_btb.entity.enrollment.Enrollment;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository {

	interface SQL{
		/*final String R_ENROLLMENT="SELECT * FROM smg_enrollment";*/
		final String C_ENROLLMENT_STUDENT="{CALL enroll_student(#{generation_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{course_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{class_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{student_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{success,jdbcType=INTEGER,mode=OUT})}";
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
