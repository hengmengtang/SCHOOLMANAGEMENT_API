package org.khmeracademy.smg_btb.repository.result;

import java.util.ArrayList;

import javax.ws.rs.OPTIONS;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.khmeracademy.smg_btb.entity.form.monthly_result.ParamViewResult;
import org.khmeracademy.smg_btb.entity.form.monthly_result.ResultStudentEachMonth;
import org.khmeracademy.smg_btb.entity.form.monthly_result.Subject;
import org.khmeracademy.smg_btb.entity.form.monthly_result.SubjectAdvance;
import org.khmeracademy.smg_btb.entity.form.monthly_result.SubjectBasic;
import org.khmeracademy.smg_btb.entity.form.statistic.ClassName;
import org.khmeracademy.smg_btb.entity.form.view_score.ParamViewScore;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository {

	interface SQL{
		final String R_MONTHLY_RESULT_BASIC_ON_MONTH="{CALL monthly_result_basic("
				+ "#{generation_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{course_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{date,jdbcType=VARCHAR,mode=IN})}";
		
		final String R_MONTHLY_RESULT_BASIC="SELECT"
					+ " stu.stu_id,"
					+ " stu.eng_full_name AS stu_name,"
					+ " cls.class_name,"
					+ " mk.mark_id,"
					+ " MAX ("
					+ "	CASE"
					+ "	WHEN sub.subject_name = #{subject_name} THEN"
					+ "		mk.mark"
					+ "	ELSE"
					+ "		0"
					+ "	END"
					+ " ) AS score"
					+ " FROM"
					+ " smg_mark mk"
				+ " INNER JOIN smg_subject sub ON sub.subject_id = mk.sub_id"
				+ " INNER JOIN smg_student stu ON stu.stu_id = mk.stu_id"
				+ " INNER JOIN smg_class cls ON cls.class_id = mk.class_id"
				+ " INNER JOIN smg_enrollment en ON cls.class_id = en.class_id"
				+ " INNER JOIN smg_generation gen ON gen.gen_id = en.gen_id"
				+ " INNER JOIN smg_course cou ON cou.cou_id = en.course_id"
				+ " INNER JOIN smg_handlings h ON h.cou_id = en.course_id"
				+ " INNER JOIN smg_staff stf ON h.staff_id = stf.staff_id"
				+ " WHERE"
				+ " 	gen.gen_name = ("
				+ " 		SELECT"
				+ " 			gen_name"
				+ "		FROM"
				+ "			smg_generation"
				+ "		WHERE"
				+ "			status = 't'"
				+ "		ORDER BY"
				+ "			gen_id DESC"
				+ "		LIMIT 1"
				+ "	)"
				+ " AND cou.cou_name =#{course_name}"
				+ " AND now()::DATE <= ("
				+ "		(mk.date::DATE + INTERVAL '1 days') :: DATE"
				+ " )"
				+ " AND cls.class_name = #{class_name}"
				+ " AND stf.eng_full_name = #{staff_name} "
				+ " AND sub.subject_name = #{subject_name} "
				+ " GROUP BY "
				+ " 	stu.stu_id,"
				+ " 	stu.eng_full_name,"
				+ " 	cls.class_name,"
				+ "		mk.mark_id "
				+ " ORDER BY stu.stu_id;";
					
		final String R_MONTHLY_RESULT_ADVANCE="{CALL monthly_result_advance("
				+ "#{class_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{staff_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{subject_name,jdbcType=VARCHAR,mode=IN})}";
		
		final String R_RESULT_STUDENT_IN_EACH_MONTH="{CALL result_each_month("
				+ "#{student_name,jdbcType=VARCHAR,mode=IN})}";
		
		final String R_MONTH="SELECT DISTINCT extract('Month' from mk.date::date),to_char(mk.date::date, 'Month') "
				+ "as month FROM smg_mark mk"
				+ " INNER JOIN smg_subject sub ON mk.sub_id=sub.subject_id"
				+ " INNER JOIN smg_student stu ON mk.stu_id=stu.stu_id"
				+ " WHERE stu.eng_full_name=#{student_name}"
				+ " ORDER BY extract('Month' from mk.date::date);";
		
		final String R_SUMMERY_RESULT="{CALL summery_student_result(#{generation_name,jdbcType=VARCHAR,mode=IN})}";
	}
	
	@Select(SQL.R_MONTHLY_RESULT_BASIC)
	@Options(statementType=StatementType.CALLABLE)
	@Results({
		@Result(property="monthlyResult.stu_id",column="stu_id"),
		@Result(property="monthlyResult.stu_name",column="stu_name"),
		@Result(property="monthlyResult.class_name",column="class_name"),
		@Result(property="monthlyResult.mark_id",column="mark_id")
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
	
	@Select(SQL.R_MONTHLY_RESULT_BASIC_ON_MONTH)
	@Options(statementType=StatementType.CALLABLE)
	@Results({
		@Result(property="info.rank",column="rank"),
		@Result(property="info.student_name",column="student_name"),
		@Result(property="info.class_name",column="class_name"),
		@Result(property="info.gender",column="gender"),
		@Result(property="attendance",column="attendance")
	})
	public ArrayList<Subject.basic> resultBasicOnMonth(ParamViewResult result);
	
	@Select(SQL.R_RESULT_STUDENT_IN_EACH_MONTH)
	@Options(statementType=StatementType.CALLABLE)
	public ArrayList<ResultStudentEachMonth> studentResultEachMonth(String student_name);
	
	@Select(SQL.R_MONTH)
	public ArrayList<ResultStudentEachMonth> getMonth(String student_name);
	
	@Select(SQL.R_SUMMERY_RESULT)
	@Options(statementType=StatementType.CALLABLE)
	public ArrayList<ClassName> summeryResult(String generation_name);
}
