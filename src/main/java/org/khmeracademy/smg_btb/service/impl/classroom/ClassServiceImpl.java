package org.khmeracademy.smg_btb.service.impl.classroom;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.class_room.ClassRoom;
import org.khmeracademy.smg_btb.repository.class_room.ClassRoomRepository;
import org.khmeracademy.smg_btb.service.classroom.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl implements ClassService{

	@Autowired
	ClassRoomRepository classRepository;
	
	@Override
	public ArrayList<ClassRoom> findAll() {
		
		return classRepository.findAll();
	}

}
