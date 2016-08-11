package org.khmeracademy.smg_btb.repository.generation;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.khmeracademy.smg_btb.entity.generation.Generation;
import org.springframework.stereotype.Repository;

@Repository
public interface GenerationRepository {

	interface SQL{
		
		final String R_GENERATION="SELECT * FROM smg_generation;";
	}
	
	@Select(SQL.R_GENERATION)
	@Results({
		@Result(property="gen_id" ,column="gen_id"),
		@Result(property="gen_name" ,column="gen_name"),
		@Result(property="gen_start_date" ,column="gen_start_date"),
		@Result(property="gen_end_date" ,column="gen_end_date")
	})
	public ArrayList<Generation> findAll();
}
