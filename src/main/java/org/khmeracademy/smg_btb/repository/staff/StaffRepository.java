package org.khmeracademy.smg_btb.repository.staff;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.khmeracademy.smg_btb.entity.form.max_id.MaxId;
import org.khmeracademy.smg_btb.entity.staff.Staff;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository {

	interface SQL{
		final String R_SELECT_STAFF="SELECT * FROM smg_staff ORDER BY staff_id";
		final String C_INSERT_STAFF="INSERT INTO smg_staff("
				+ "staff_id,"
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
				+ "#{staff_id},"
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
		
		final String R_SELECT_MAX="SELECT 'stf' || lpad(MAX(split_part(staff_id, 'stf', 2)::int + 1)::text,4,'0') "
				+ " AS max_staff_id FROM smg_staff";
	}
	
	@Select(SQL.R_SELECT_STAFF)
	@Results({
		@Result(property="staff_id" ,column="staff_id"),
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
		@Result(property="korean_level" ,column="korean_level"),
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
	public ArrayList<Staff> findAll();
	
	@Insert(SQL.C_INSERT_STAFF)
	public boolean save(Staff staff);
	
	@Select(SQL.R_SELECT_MAX)
	@Results({
		@Result(property="maxId",column="max_staff_id")
	})
	public MaxId selectMax();
}
