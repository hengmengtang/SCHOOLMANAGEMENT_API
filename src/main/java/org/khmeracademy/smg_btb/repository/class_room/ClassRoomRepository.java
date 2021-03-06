package org.khmeracademy.smg_btb.repository.class_room;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;
import org.khmeracademy.smg_btb.entity.class_room.ClassRoom;
import org.khmeracademy.smg_btb.entity.form.close_class.CloseClass;
import org.khmeracademy.smg_btb.entity.form.list_class.ListClassInCourse;
import org.khmeracademy.smg_btb.entity.form.list_course.ListCourse;
import org.khmeracademy.smg_btb.entity.form.max_id.MaxId;
import org.khmeracademy.smg_btb.entity.student.Student;
import org.khmeracademy.smg_btb.repository.course.CourseRepository.SQL;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomRepository {

	interface SQL{
		final String R_CLASS="SELECT * FROM smg_class";
		
		final String C_CLASS="{CALL insert_class(#{class_id,jdbcType=INTEGER,mode=IN},"
				+ "#{class_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{active,jdbcType=BOOLEAN,mode=IN})}";
		
		final String R_SELECT_MAX="SELECT 'cls' || lpad(MAX(split_part(class_id, 'cls', 2)::int + 1)::text,4,'0') "
				+ "AS max_class_id FROM smg_class";
		
		final String R_SELECT_CLASS_BY_STAFF_GENERATION_COURSE="SELECT DISTINCT cls.class_name"
				+ " FROM smg_generation gen"
				+ " LEFT JOIN smg_enrollment en ON en.gen_id=gen.gen_id"
				+ " LEFT JOIN smg_course cou ON en.course_id=cou.cou_id"
				+ " LEFT JOIN smg_class cls ON cls.class_id=en.class_id"
				+ " LEFT JOIN smg_handlings h ON h.class_id=cls.class_id"
				+ " LEFT JOIN smg_staff stf ON h.staff_id=stf.staff_id"
				+ " WHERE "
 				+ " gen.gen_name=#{generation_name} AND cou.cou_name=#{course_name}"
 				+ " AND stf.eng_full_name=#{staff_name} AND cls.active='t'"
				+ " AND stf.status='t' AND gen.status='t' AND cou.active='t';";
		
		final String R_SELECT_CLASS_BY_GENERATION_COURSE="SELECT DISTINCT cls.class_name,cls.active"
				+ " FROM smg_generation gen"
				+ " LEFT JOIN smg_handlings h ON h.gen_id=gen.gen_id"
				+ " LEFT JOIN smg_course cou ON h.cou_id=cou.cou_id"
				+ " LEFT JOIN smg_class cls ON cls.class_id=h.class_id"
				+ " LEFT JOIN smg_staff stf ON h.staff_id=stf.staff_id"
				+ " WHERE gen.gen_name=#{generation_name} AND cou.cou_name=#{course_name}";
				//+ " AND gen.status='t' AND cls.active='t' AND stf.status='t'"; 
		
		final String R_SELECT_LIST_CLASS="SELECT DISTINCT cls.class_id,cls.class_name,cou.cou_name,gen.gen_name,cls.active"
				+ " FROM smg_course cou" 
				+ " INNER JOIN smg_enrollment en ON cou.cou_id=en.course_id"
				+ " INNER JOIN smg_generation gen ON en.gen_id=gen.gen_id"
				+ " INNER JOIN smg_class cls ON cls.class_id=en.class_id"
				+ " ORDER BY cls.class_id";
		
		final String R_CLASS_NOT_YET_ENROLL_STUDENT="SELECT * FROM get_class_not_yet_enroll_student";
		
		final String U_CHANGE_STATUS_CLASS="{CALL change_status_class(#{class_name,jdbcType=VARCHAR,mode=IN})}";
		
		final String U_OPEN_CLASS="update smg_class set active=(case when active='t' then active='f' else 't' end)"
				+ " where class_id=#{class_id}";
		
		final String R_CLASS_STATUS_TRUE="select * from smg_class where active='t';";
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
	
	@Select(SQL.R_SELECT_CLASS_BY_STAFF_GENERATION_COURSE)
	public ArrayList<ClassRoom> getClassByStaffGenerationCourse(Student.getCourseByStaffGenerationCourse courseByGenerationCourse);
		
	@Select(SQL.R_CLASS_NOT_YET_ENROLL_STUDENT)
	public ArrayList<ClassRoom>	getClassNotYetEnrollStudent();
	
	@Select(SQL.R_SELECT_CLASS_BY_GENERATION_COURSE)
	public ArrayList<ClassRoom> getClassByGenerationCourse(Student.getCourseByGenerationCourse courseByGenerationCourse);
	
	@Select(SQL.R_SELECT_LIST_CLASS)
	public ArrayList<ListClassInCourse> listClass();
	
	@Update(SQL.U_CHANGE_STATUS_CLASS)
	@Options(statementType=StatementType.CALLABLE)
	public boolean changeStatusClass(String class_name);
	
	@Update(SQL.U_OPEN_CLASS)
	public boolean openClass(String class_id);
	
	@Select(SQL.R_CLASS_STATUS_TRUE)
	@Results({
		@Result(property="class_id",column="class_id"),
		@Result(property="class_name",column="class_name"),
		@Result(property="start_date",column="start_date"),
		@Result(property="end_date",column="end_date"),
		@Result(property="active",column="active")
	})
	public ArrayList<ClassRoom> getClassStatusTrue();
}
