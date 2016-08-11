package org.khmeracademy.smg_btb.service.impl.course;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.course.Course;
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

}
