package org.khmeracademy.smg_btb.service.classroom;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.class_room.ClassRoom;
import org.khmeracademy.smg_btb.entity.form.max_id.MaxId;

public interface ClassService {

	public ArrayList<ClassRoom> findAll();
	public boolean insert(ClassRoom classRoom);
	public MaxId selectMax();
}
