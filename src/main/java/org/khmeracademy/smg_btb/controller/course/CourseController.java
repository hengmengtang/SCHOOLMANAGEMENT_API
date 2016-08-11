package org.khmeracademy.smg_btb.controller.course;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.course.Course;
import org.khmeracademy.smg_btb.service.course.CourseService;
import org.khmeracademy.smg_btb.utils.Response;
import org.khmeracademy.smg_btb.utils.ResponseCode;
import org.khmeracademy.smg_btb.utils.ResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@RequestMapping(value="/find-all-course",method=RequestMethod.GET)
	public ResponseList<Course> findAll(){
		ResponseList<Course> response=new ResponseList<>();
	
		ArrayList<Course> courseList=courseService.findAll();
		if(courseList.isEmpty()){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(courseList);
		
		return response;
	}
	
	@RequestMapping(value="/register-course",method=RequestMethod.POST)
	public Response enrollStudent(@RequestBody Course course){
		Response response=new Response();
		
		courseService.registerCourse(course);
		
		if(course.getSuccess()==1)
			response.setCode(ResponseCode.INSERT_SUCCESS);
		else
			response.setCode(ResponseCode.INSERT_FAIL);
		
		return response;
	}
}
