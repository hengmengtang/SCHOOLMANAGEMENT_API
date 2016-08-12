package org.khmeracademy.smg_btb.repository.handle;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.mapping.StatementType;
import org.khmeracademy.smg_btb.entity.handle.HandleSubjectToStaffToClassRoom;
import org.springframework.stereotype.Repository;

@Repository
public interface HandleSubjectToStaffToClassRepository {

	interface SQL{
		final String HANDLE_SUBJECT_TO_STAFF_TO_CLASS="{CALL handle_subject_to_staff_to_class("
				+ "#{staff_handle_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{class_room_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{subject_type_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{success,jdbcType=INTEGER,mode=OUT})}";
	}
	
	@Insert(SQL.HANDLE_SUBJECT_TO_STAFF_TO_CLASS)
	@Options(statementType=StatementType.CALLABLE)
	public int handleSubjectToStaffToClass(HandleSubjectToStaffToClassRoom handle);
}
