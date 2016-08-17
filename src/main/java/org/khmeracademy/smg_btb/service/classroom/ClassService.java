package org.khmeracademy.smg_btb.service.classroom;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.class_room.ClassRoom;
import org.khmeracademy.smg_btb.entity.form.list_class.ListClassInCourse;
import org.khmeracademy.smg_btb.entity.form.max_id.MaxId;
import org.khmeracademy.smg_btb.entity.student.Student;

public interface ClassService {

	public ArrayList<ClassRoom> findAll();
	public boolean insert(ClassRoom classRoom);
	public MaxId selectMax();
	public ArrayList<ClassRoom> getClassByStaffGenerationCourse(Student.getCourseByStaffGenerationCourse courseByStaffGenerationCourse);
	public ArrayList<ClassRoom>	getClassNotYetEnrollStudent();
	public ArrayList<ClassRoom> getClassByGenerationCourse(Student.getCourseByGenerationCourse courseByGenerationCourse);
	public ArrayList<ListClassInCourse> listClass();
}
