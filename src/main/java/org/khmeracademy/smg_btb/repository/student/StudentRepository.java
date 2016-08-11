package org.khmeracademy.smg_btb.repository.student;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.khmeracademy.smg_btb.entity.checkUser.CheckUser;
import org.khmeracademy.smg_btb.entity.student.Student;
import org.khmeracademy.smg_btb.entity.student.Student.MaxId;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository {
	
	interface SQL{
		final String C_INSERT_STUDENT="INSERT INTO smg_student("
				+ "stu_id,"
				+ "khmer_full_name,"
				+ "eng_full_name,"
				+ "gender,"
				+ "dob,"
				+ "pob,"
				+ "email,"
				+ "permanent_address,"
				+ "phone,"
				+ "education_level,"
				+ "english_level,"
				+ "korean_level,"
				+ "student_status,"
				+ "graduate,"
				+ "university,"
				+ "khmer_id,"
				+ "photo,"
				+ "father_eng_name,"
				+ "father_khmer_name,"
				+ "father_occupation,"
				+ "father_address,"
				+ "father_phone,"
				+ "mother_khmer_name,"
				+ "mother_eng_name,"
				+ "mother_occupation,"
				+ "mother_address,"
				+ "mother_phone,"
				+ "date,"
				+ "status)"
			+ " VALUES("
				+ "#{stu_id},"
				+ "#{khmer_full_name},"
				+ "#{eng_full_name},"
				+ "#{gender},"
				+ "#{dob},"
				+ "#{pob},"
				+ "#{email},"
				+ "#{permanent_address},"
				+ "#{phone},"
				+ "#{education_level},"
				+ "#{english_level},"
				+ "#{korean_level},"
				+ "#{student_status},"
				+ "#{graduate},"
				+ "#{university},"
				+ "#{khmer_id},"
				+ "#{phone},"
				+ "#{father_eng_name},"
				+ "#{father_khmer_name},"
				+ "#{father_occupation},"
				+ "#{father_address},"
				+ "#{father_phone},"
				+ "#{mother_khmer_name},"
				+ "#{mother_eng_name},"
				+ "#{mother_occupation},"
				+ "#{mother_address},"
				+ "#{mother_phone},"
				+ "#{date},"
				+ "#{status})";
		final String U_STUDENT_STATUS="UPDATE smg_student SET status='f' WHERE status='t' AND stu_id=#{id}";
		final String U_STUDENT_BYID="UPDATE smg_student SET "
				+ "khmer_full_name=#{khmer_full_name},"
				+ "eng_full_name=#{eng_full_name},"
				+ "gender=#{gender},"
				+ "dob=#{dob},"
				+ "pob=#{pob},"
				+ "email=#{email},"
				+ "permanent_address=#{permanent_address},"
				+ "phone=#{phone},"
				+ "education_level=#{education_level},"
				+ "english_level=#{english_level},"
				+ "korean_level=#{korean_level},"
				+ "student_status=#{student_status},"
				+ "graduate=#{graduate},"
				+ "university=#{university},"
				+ "khmer_id=#{khmer_id},"
				+ "photo=#{phone},"
				+ "father_eng_name=#{father_eng_name},"
				+ "father_khmer_name=#{father_khmer_name},"
				+ "father_occupation=#{father_occupation},"
				+ "father_address=#{father_address},"
				+ "father_phone=#{father_phone},"
				+ "mother_khmer_name=#{mother_khmer_name},"
				+ "mother_eng_name=#{mother_eng_name},"
				+ "mother_occupation=#{mother_occupation},"
				+ "mother_address=#{mother_address},"
				+ "mother_phone=#{mother_phone},"
				+ "date=#{date},"
				+ "status=#{status} WHERE stu_id=#{stu_id}";
		final String R_SELECT_STUDENT="SELECT * FROM smg_student ORDER BY stu_id";
		
		final String R_MODIFY_USER="SELECT eng_full_name,phone FROM smg_student "
				+ "WHERE eng_full_name=#{user_name} AND phone=#{phone}";
		final String R_SELECT_MAX="SELECT 'stu' || lpad(MAX(split_part(stu_id, 'stu', 2)::int + 1)::text,5,'0') AS max_stu_id FROM smg_student";
		
		final String R_SELECT_STUDENT_BY_GENERATION_COURSE="SELECT stu.stu_id,stu.khmer_full_name,stu.eng_full_name,"
				+ " stu.gender,stu.dob,stu.permanent_address AS address,stu.email "
				+ " FROM smg_generation gen "
				+ " INNER JOIN smg_enrollment en ON gen.gen_id=en.gen_id "
				+ " INNER JOIN smg_student stu ON en.stu_id=stu.stu_id "
				+ " INNER JOIN smg_course cou ON en.course_id=cou.cou_id;";
	};
	@Select(SQL.R_SELECT_STUDENT)
	@Results({
		@Result(property="stu_id" ,column="stu_id"),
		@Result(property="khmer_full_name" ,column="khmer_full_name"),
		@Result(property="eng_full_name" ,column="eng_full_name"),
		@Result(property="gender" ,column="gender"),
		@Result(property="dob" ,column="dob"),
		@Result(property="pob" ,column="pob"),
		@Result(property="email" ,column="email"),
		@Result(property="permanent_address" ,column="permanent_address"),
		@Result(property="phone" ,column="phone"),
		@Result(property="education_level" ,column="education_level"),
		@Result(property="english_level" ,column="english_level"),
		@Result(property="korean_level" ,column="korean"),
		@Result(property="student_status" ,column="student_status"),
		@Result(property="graduate" ,column="graduate"),
		@Result(property="university" ,column="university"),
		@Result(property="khmer_id" ,column="khmer_id"),
		@Result(property="photo" ,column="photo"),
		@Result(property="father_eng_name" ,column="father_eng_name"),
		@Result(property="father_khmer_name" ,column="father_khmer_name"),
		@Result(property="father_occupation" ,column="father_occupation"),
		@Result(property="father_address" ,column="father_address"),
		@Result(property="father_phone" ,column="father_phone"),
		@Result(property="mother_khmer_name" ,column="mother_khmer_name"),
		@Result(property="mother_eng_name" ,column="mother_eng_name"),
		@Result(property="mother_occupation" ,column="mother_occupation"),
		@Result(property="mother_address" ,column="mother_address"),
		@Result(property="mother_phone" ,column="mother_phone"),
		@Result(property="date" ,column="date")
	})
	public ArrayList<Student> findAll();
	
	@Insert(SQL.C_INSERT_STUDENT)
	public boolean save(Student student);
	@Update(SQL.U_STUDENT_STATUS)
	public boolean updateStatus(String id);
	@Update(SQL.U_STUDENT_BYID)
	public boolean updateById(Student student);
	
	@Select(SQL.R_MODIFY_USER)
	@Results({
		@Result(property="user_name" ,column="eng_full_name"),
		@Result(property="phone",column="phone")
	})
	public CheckUser checkUser(CheckUser checkUser);
	
	@Select(SQL.R_SELECT_MAX)
	@Results({
		@Result(property="maxStuId",column="max_stu_id")
	})
	public MaxId selectMax();
	
	@Select(SQL.R_SELECT_STUDENT_BY_GENERATION_COURSE)
	@Results({
		@Result(property="stu_id" ,column="stu_id"),
		@Result(property="khmer_full_name" ,column="khmer_full_name"),
		@Result(property="eng_full_name" ,column="eng_full_name"),
		@Result(property="gender" ,column="gender"),
		@Result(property="dob" ,column="dob"),
		@Result(property="permanent_address" ,column="address"),
		@Result(property="email" ,column="email")
	})
	public ArrayList<Student> select_student_by_generation_course();
}
