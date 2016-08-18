package org.khmeracademy.smg_btb.repository.result;

import java.util.ArrayList;

import javax.ws.rs.OPTIONS;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.khmeracademy.smg_btb.entity.form.monthly_result.SubjectAdvance;
import org.khmeracademy.smg_btb.entity.form.monthly_result.SubjectBasic;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository {

	interface SQL{
		final String R_MONTHLY_RESULT_BASIC="{CALL monthly_result_basic("
				+ "#{generation_name,jdbcType=VARCHAR,mode=IN})}";
		
		final String R_MONTHLY_RESULT_ADVANCE="{CALL monthly_result_advance("
				+ "#{generation_name,jdbcType=VARCHAR,mode=IN})}";
	}
	
	@Select(SQL.R_MONTHLY_RESULT_BASIC)
	@Options(statementType=StatementType.CALLABLE)
	public ArrayList<SubjectBasic> resultBasic(String generation_name);
	
	@Select(SQL.R_MONTHLY_RESULT_ADVANCE)
	@Options(statementType=StatementType.CALLABLE)
	public ArrayList<SubjectAdvance> resultAdvance(String generation_name);
}
