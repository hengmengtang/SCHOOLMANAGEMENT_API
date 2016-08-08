package org.khmeracademy.smg_btb.repository.class_room;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.khmeracademy.smg_btb.entity.class_room.ClassRoom;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomRepository {

	interface SQL{
		final String R_CLASS="SELECT * FROM smg_class";
		final String C_CLASS="{CALL insert_class(#{class_id,jdbcType=INTEGER,mode=IN},"
				+ "#{class_name,jdbcType=VARCHAR,mode=IN},"
				+ "#{start_date,jdbcType=VARCHAR,mode=IN},"
				+ "#{end_date,jdbcType=VARCHAR,mode=IN},"
				+ "#{active,jdbcType=BOOLEAN,mode=IN})}";
	}
	
	@Select(SQL.R_CLASS)
	@Results({
		@Result(property="class_id",column="class_id"),
		@Result(property="class_name",column="class_name"),
		@Result(property="start_date",column="start_date"),
		@Result(property="end_date",column="end_date"),
		@Result(property="active",column="active")
	})
	public ArrayList<ClassRoom> findAll();
	
	@Insert(SQL.C_CLASS)
	@Options(statementType=StatementType.CALLABLE)
	public boolean insert(ClassRoom classRoom);
}
