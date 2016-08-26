package org.khmeracademy.smg_btb.repository.generation;

import java.util.ArrayList;

import javax.ws.rs.OPTIONS;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;
import org.khmeracademy.smg_btb.entity.form.close_generation.CloseGeneration;
import org.khmeracademy.smg_btb.entity.form.max_id.MaxId;
import org.khmeracademy.smg_btb.entity.generation.CountStudentByGeneration;
import org.khmeracademy.smg_btb.entity.generation.Generation;
import org.springframework.stereotype.Repository;

@Repository
public interface GenerationRepository {

	interface SQL{
		
		final String R_GENERATION="SELECT * FROM smg_generation;";
		
		final String C_COURSE="INSERT INTO smg_generation("
				+ " gen_id,"
				+ " gen_name,"
				+ " gen_start_date,"
				+ " gen_end_date,"
				+ " status)"
				+ " VALUES("
				+ " #{gen_id},"
				+ " #{gen_name},"
				+ " to_timestamp(#{gen_start_date}, 'YYYY-MM-DD')::DATE::TEXT," 
				+ " to_timestamp(#{gen_end_date}, 'YYYY-MM-DD')::DATE::TEXT," 
				+ " #{status})";
		
		final String R_SELECT_MAX="SELECT 'gen' || lpad(MAX(split_part(gen_id, 'gen', 2)::int + 1)::text,3,'0') "
				+ "AS max_gen_id FROM smg_generation";
		
		final String R_LAST_GENERATION="SELECT gen_id,gen_name,status FROM smg_generation WHERE status='t'"
				+ " AND gen_end_date>=now()::DATE::TEXT;";
		
		final String U_STATUS_GENERATION_TRUE="UPDATE smg_generation SET status='f' WHERE gen_id=#{gen_id}";
		
		final String R_GENERATION_STATUS_TRUE="SELECT status FROM smg_generation WHERE status='t'";
		
		final String R_CLOSE_GENERATION="{CALL change_status_generation()}";
		
		final String R_COUNT_STUDENT_BY_GENERATION="SELECT gen.gen_name as generation_name,COUNT(en.stu_id) "
				+ " as total_student FROM smg_enrollment en "
				+ " INNER JOIN smg_generation gen ON en.gen_id=gen.gen_id"
				+ " GROUP BY gen.gen_id ORDER BY gen.gen_id";
		
		final String R_GENERATION_YEAR="SELECT to_char(gen.gen_start_date::date, 'YYYY')"
				+ " as start FROM smg_generation gen ORDER BY gen.gen_id;";
		
		final String R_COUNT_STUDENT_IN_COURSE="SELECT * FROM count_student_with_generation_in_course;";
	}
	
	@Select(SQL.R_GENERATION)
	@Results({
		@Result(property="gen_id" ,column="gen_id"),
		@Result(property="gen_name" ,column="gen_name"),
		@Result(property="gen_start_date" ,column="gen_start_date"),
		@Result(property="gen_end_date" ,column="gen_end_date")
	})
	public ArrayList<Generation> findAll();
	
	@Insert(SQL.C_COURSE)
	public boolean registerGeneration(Generation generation);
	
	@Select(SQL.R_SELECT_MAX)
	@Results({
		@Result(property="maxId",column="max_gen_id")
	})
	public MaxId selectMax();
	
	@Select(SQL.R_LAST_GENERATION)
	public Generation getLastGeneration();
	
	@Update(SQL.U_STATUS_GENERATION_TRUE)
	public boolean changeStatusTrue(String gen_id);
	
	@Select(SQL.R_GENERATION_STATUS_TRUE)
	public Generation getGenerationStatusTrue();
	
	@Select(SQL.R_CLOSE_GENERATION)
	@Options(statementType=StatementType.CALLABLE)
	public boolean closeGeneration();
	
	@Select(SQL.R_COUNT_STUDENT_BY_GENERATION)
	public ArrayList<CountStudentByGeneration> countStudent();
	
	@Select(SQL.R_GENERATION_YEAR)
	@Results({
		@Result(property="gen_start_date",column="start")
	})
	public ArrayList<Generation> generationYear();
	
	@Select(SQL.R_COUNT_STUDENT_IN_COURSE)
	public ArrayList<CountStudentByGeneration> countStudentInEachCourse();
}
