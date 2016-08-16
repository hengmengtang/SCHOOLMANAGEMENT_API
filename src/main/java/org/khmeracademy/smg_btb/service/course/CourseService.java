package org.khmeracademy.smg_btb.service.course;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.course.Course;
import org.khmeracademy.smg_btb.entity.form.max_id.MaxId;

public interface CourseService {

	public ArrayList<Course> findAll();
	public boolean registerCourse(Course course);
	public MaxId selectMax();
	public Course getLastCourse();
}
