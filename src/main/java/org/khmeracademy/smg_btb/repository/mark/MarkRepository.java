package org.khmeracademy.smg_btb.repository.mark;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.mapping.StatementType;
import org.khmeracademy.smg_btb.entity.mark.Mark;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepository {

	interface SQL{
		final String ADD_MARK="{CALL add_mark("
				+ "#{paramMark.staff_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{paramMark.class_room_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{paramMark.subject_type_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{paramMark.student_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{date,jdbcType=VARCHAR,mode=IN},"
				+ "#{mark,jdbcType=DOUBLE,mode=IN},"
				+ "#{success,jdbcType=INTEGER,mode=OUT})}";
	}
	
	@Insert(SQL.ADD_MARK)
	@Options(statementType=StatementType.CALLABLE)
	public int addMark(Mark mark);
	
}
