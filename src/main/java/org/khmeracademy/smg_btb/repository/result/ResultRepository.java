package org.khmeracademy.smg_btb.repository.result;

import java.util.ArrayList;

import javax.ws.rs.OPTIONS;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.khmeracademy.smg_btb.entity.form.monthly_result.SubjectAdvance;
import org.khmeracademy.smg_btb.entity.form.monthly_result.SubjectBasic;
import org.khmeracademy.smg_btb.entity.form.view_score.ParamViewScore;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository {

	interface SQL{
		final String R_MONTHLY_RESULT_BASIC="{CALL monthly_result_basic("
				+ "#{class_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{staff_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{subject_name,jdbcType=VARCHAR,mode=IN})}";
		
		final String R_MONTHLY_RESULT_ADVANCE="{CALL monthly_result_advance("
				+ "#{class_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{staff_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{subject_name,jdbcType=VARCHAR,mode=IN})}";
	}
	
	@Select(SQL.R_MONTHLY_RESULT_BASIC)
	@Options(statementType=StatementType.CALLABLE)
	@Results({
		@Result(property="monthlyResult.stu_id",column="stu_id"),
		@Result(property="monthlyResult.stu_name",column="stu_name"),
		@Result(property="monthlyResult.class_name",column="class_name")
	})
	public ArrayList<SubjectBasic> resultBasic(ParamViewScore viewScore);
	
	@Select(SQL.R_MONTHLY_RESULT_ADVANCE)
	@Options(statementType=StatementType.CALLABLE)
	@Results({
		@Result(property="monthlyResult.stu_id",column="stu_id"),
		@Result(property="monthlyResult.stu_name",column="stu_name"),
		@Result(property="monthlyResult.class_name",column="class_name")
	})
	public ArrayList<SubjectAdvance> resultAdvance(ParamViewScore viewScore);
}
