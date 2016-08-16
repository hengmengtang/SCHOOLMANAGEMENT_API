package org.khmeracademy.smg_btb.service.classroom;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.class_room.ClassRoom;
import org.khmeracademy.smg_btb.entity.form.max_id.MaxId;
import org.khmeracademy.smg_btb.entity.student.Student;

public interface ClassService {

	public ArrayList<ClassRoom> findAll();
	public boolean insert(ClassRoom classRoom);
	public MaxId selectMax();
	public ArrayList<ClassRoom> getClassGenerationCourse(Student.getGenerationCourse generationCourse);
	public ArrayList<ClassRoom>	getClassNotYetEnrollStudent();
}
