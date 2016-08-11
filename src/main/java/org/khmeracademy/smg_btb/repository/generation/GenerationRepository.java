package org.khmeracademy.smg_btb.repository.generation;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.khmeracademy.smg_btb.entity.form.max_id.MaxId;
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
				+ " #{gen_start_date},"
				+ " #{gen_end_date},"
				+ " #{status})";
		
		final String R_SELECT_MAX="SELECT 'gen' || lpad(MAX(split_part(gen_id, 'gen', 2)::int + 1)::text,4,'0') "
				+ "AS max_gen_id FROM smg_generation";
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
}
