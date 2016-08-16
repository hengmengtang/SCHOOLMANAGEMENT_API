package org.khmeracademy.smg_btb.repository.class_room;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.khmeracademy.smg_btb.entity.class_room.ClassRoom;
import org.khmeracademy.smg_btb.entity.form.max_id.MaxId;
import org.khmeracademy.smg_btb.entity.student.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomRepository {

	interface SQL{
		final String R_CLASS="SELECT * FROM smg_class";
		
		final String C_CLASS="{CALL insert_class(#{class_id,jdbcType=INTEGER,mode=IN},"
				+ "#{class_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{start_date,jdbcType=VARCHAR,mode=IN},"
				+ "#{end_date,jdbcType=VARCHAR,mode=IN},"
				+ "#{active,jdbcType=BOOLEAN,mode=IN})}";
		
		final String R_SELECT_MAX="SELECT 'cls' || lpad(MAX(split_part(class_id, 'cls', 2)::int + 1)::text,4,'0') "
				+ "AS max_class_id FROM smg_class";
		
		final String R_SELECT_CLASS_IN_GENERATION_COURSE="SELECT DISTINCT cls.class_name"
				+ " FROM smg_generation gen"
				+ " LEFT JOIN smg_enrollment en ON gen.gen_id=en.gen_id"
				+ " LEFT JOIN smg_course cou ON en.course_id=cou.cou_id"
				+ " LEFT JOIN smg_class cls ON en.class_id=cls.class_id"
				+ " WHERE gen.gen_name=#{generation_name} AND cou.cou_name=#{course_name};";
		
		final String R_CLASS_NOT_YET_ENROLL_STUDENT="SELECT * FROM get_class_not_yet_enroll_student";
	}
	
	@Select(SQL.R_CLASS)
	@Results({
		@Result(property="class_id",column="class_id"),
		@Result(property="class_name",column="class_name"),
		@Result(property="start_date",column="start_date"),
		@Result(property="end_date",column="end_date"),
		@Result(property="active",column="active")
	})
	public ArrayList<ClassRoom> findAll();
	
	@Insert(SQL.C_CLASS)
	@Options(statementType=StatementType.CALLABLE)
	public boolean insert(ClassRoom classRoom);
	
	@Select(SQL.R_SELECT_MAX)
	@Results({
		@Result(property="maxId",column="max_class_id")
	})
	public MaxId selectMax();
	
	@Select(SQL.R_SELECT_CLASS_IN_GENERATION_COURSE)
	public ArrayList<ClassRoom> getClassGenerationCourse(Student.getGenerationCourse generationCourse);
		
	@Select(SQL.R_CLASS_NOT_YET_ENROLL_STUDENT)
	public ArrayList<ClassRoom>	getClassNotYetEnrollStudent();
}
