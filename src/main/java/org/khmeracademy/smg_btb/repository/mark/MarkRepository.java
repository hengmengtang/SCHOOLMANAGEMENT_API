package org.khmeracademy.smg_btb.repository.mark;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.khmeracademy.smg_btb.entity.form.add_mark.DisplayAddMark;
import org.khmeracademy.smg_btb.entity.mark.Mark;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepository {

	interface SQL{
		final String ADD_MARK="{CALL add_mark("
				+ "#{paramMark.staff_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{paramMark.class_room_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{paramMark.subject_type_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{paramMark.student_id,jdbcType=VARCHAR,mode=IN},"
				+ "#{mark,jdbcType=DOUBLE,mode=IN},"
				+ "#{success,jdbcType=INTEGER,mode=OUT})}";
		
		final String R_STUDENT_CLASS_TO_ADD_SCORE="SELECT * FROM get_student_to_add_score";
	}
	
	@Insert(SQL.ADD_MARK)
	@Options(statementType=StatementType.CALLABLE)
	public int addMark(Mark mark);
	
	@Select(SQL.R_STUDENT_CLASS_TO_ADD_SCORE)
	public ArrayList<DisplayAddMark> displayStudentToAddScore();
}
