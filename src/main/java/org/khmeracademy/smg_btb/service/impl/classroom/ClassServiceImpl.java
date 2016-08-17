package org.khmeracademy.smg_btb.service.impl.classroom;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.class_room.ClassRoom;
import org.khmeracademy.smg_btb.entity.form.max_id.MaxId;
import org.khmeracademy.smg_btb.entity.student.Student;
import org.khmeracademy.smg_btb.entity.student.Student.getCourseByGenerationCourse;
import org.khmeracademy.smg_btb.entity.student.Student.getCourseByStaffGenerationCourse;
import org.khmeracademy.smg_btb.entity.student.Student.getCourseByStaffGenerationCourse;
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

	@Override
	public boolean insert(ClassRoom classRoom) {
		return classRepository.insert(classRoom);
	}

	@Override
	public MaxId selectMax() {
		return classRepository.selectMax();
	}

	@Override
	public ArrayList<ClassRoom> getClassNotYetEnrollStudent() {
		return classRepository.getClassNotYetEnrollStudent();
	}

	@Override
	public ArrayList<ClassRoom> getClassByStaffGenerationCourse(getCourseByStaffGenerationCourse courseByStaffGenerationCourse) {
		return classRepository.getClassByStaffGenerationCourse(courseByStaffGenerationCourse);
	}

	@Override
	public ArrayList<ClassRoom> getClassByGenerationCourse(getCourseByGenerationCourse courseByGenerationCourse) {
		return classRepository.getClassByGenerationCourse(courseByGenerationCourse);
	}

}
