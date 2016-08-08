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
		final String R_ENROLLMENT="SELECT * FROM smg_enrollment";
		final String C_INSERT_ENROLLMENT="{CALL insert_enrollment(#{enrollment_id,jdbcType=INTEGER,mode=IN},"
				+ "#{start_date,jdbcType=VARCHAR,mode=IN},"
				+ "#{end_date,jdbcType=VARCHAR,mode=IN},"
				+ "#{is_finish,jdbcType=BOOLEAN,mode=IN})}";
		final String U_STATUS_ENROLLMENT="UPDATE smg_enrollment SET is_finish='f' WHERE is_finish='t' AND end_date>#{end_date}";
	}
	@Select(SQL.R_ENROLLMENT)
	@Results({
		@Result(property="enrollment_id",column="en_id"),
		@Result(property="start_date",column="start_date"),
		@Result(property="end_date",column="end_date")
	})
	public ArrayList<Enrollment> findAll();
	
	@Insert(SQL.C_INSERT_ENROLLMENT)
	@Options(statementType=StatementType.CALLABLE)
	public boolean insert(Enrollment enrollment);
	
	@Update(SQL.U_STATUS_ENROLLMENT)
	public boolean changeStatus(CloseCourse closeGeneration);
}
