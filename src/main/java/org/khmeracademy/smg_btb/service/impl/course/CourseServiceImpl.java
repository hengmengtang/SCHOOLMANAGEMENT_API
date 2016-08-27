package org.khmeracademy.smg_btb.service.impl.course;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.course.Course;
import org.khmeracademy.smg_btb.entity.form.close_course.CloseCourse;
import org.khmeracademy.smg_btb.entity.form.list_course.ListCourse;
import org.khmeracademy.smg_btb.entity.form.max_id.MaxId;
import org.khmeracademy.smg_btb.repository.course.CourseRepository;
import org.khmeracademy.smg_btb.service.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseRepository courseRepository;
	
	
	@Override
	public ArrayList<Course> findAll() {
		return courseRepository.findAll();
	}


	@Override
	public boolean registerCourse(Course course) {
		return courseRepository.registerCourse(course);
	}


	@Override
	public MaxId selectMax() {
		return courseRepository.selectMax();
	}


	@Override
	public Course getLastCourse() {
		return courseRepository.getLastCourse();
	}


	@Override
	public ArrayList<ListCourse> listCourseTamGeneration() {
		return courseRepository.listCourseTamGeneration();
	}


	@Override
	public boolean changeStatusCourse(String course_id) {
		return courseRepository.changeStatusCourse(course_id);
	}


	@Override
	public int changeStatusCourseWithClass(CloseCourse.paramCloseCorse closeCourse) {
		return courseRepository.changeStatusCourseWithClass(closeCourse);
	}


	@Override
	public Course getCurrentCourse() {
		return courseRepository.getCurrentCourse();
	}

}
