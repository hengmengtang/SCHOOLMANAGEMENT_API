package org.khmeracademy.smg_btb.repository.class_room;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.khmeracademy.smg_btb.entity.class_room.ClassRoom;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomRepository {

	interface SQL{
		final String R_CLASS="SELECT * FROM smg_class";
	}
	
	@Select(SQL.R_CLASS)
	@Results({
		@Result(property="class_id",column="class_id"),
		@Result(property="class_name",column="class_name"),
		@Result(property="active",column="active")
	})
	public ArrayList<ClassRoom> findAll();
}
