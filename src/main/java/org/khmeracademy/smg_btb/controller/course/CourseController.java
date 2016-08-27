package org.khmeracademy.smg_btb.controller.course;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.course.Course;
import org.khmeracademy.smg_btb.entity.form.close_course.CloseCourse;
import org.khmeracademy.smg_btb.entity.form.list_course.ListCourse;
import org.khmeracademy.smg_btb.entity.form.max_id.MaxId;
import org.khmeracademy.smg_btb.service.course.CourseService;
import org.khmeracademy.smg_btb.utils.Response;
import org.khmeracademy.smg_btb.utils.ResponseCode;
import org.khmeracademy.smg_btb.utils.ResponseList;
import org.khmeracademy.smg_btb.utils.ResponseRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/course")
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
		
		if(courseService.registerCourse(course))
			response.setCode(ResponseCode.INSERT_SUCCESS);
		else
			response.setCode(ResponseCode.INSERT_FAIL);
		
		return response;
	}
	
	@RequestMapping(value="/auto-course-id",method=RequestMethod.GET)
	public ResponseRecord<MaxId> selectMaxId(){
		ResponseRecord<MaxId> response=new ResponseRecord<>();
		
		MaxId maxId=courseService.selectMax();
		if(maxId==null)
			response.setCode(ResponseCode.FAIL);
		else
			response.setCode(ResponseCode.SUCCESS);
		
		response.setData(maxId);
		
		return response;
	}
	
	@RequestMapping(value="/get-last-course",method=RequestMethod.GET)
	public ResponseRecord<Course> getLastCourse(){
		ResponseRecord<Course> response=new ResponseRecord<>();
	
		Course courseList=courseService.getLastCourse();
		if(courseList==null){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(courseList);
		
		return response;
	}
	
	@RequestMapping(value="/list-course-tam-generation",method=RequestMethod.GET)
	public ResponseList<ListCourse> listCourseTamGeneration(){
		ResponseList<ListCourse> response=new ResponseList<>();
	
		ArrayList<ListCourse> courseList=courseService.listCourseTamGeneration();
		if(courseList.isEmpty()){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(courseList);
		
		return response;
	}
	
	@RequestMapping(value="/change-status-course/{course_id}",method=RequestMethod.POST)
	public Response changeStatus(@PathVariable("course_id") String course_id){
		Response response=new Response();
		
		if(courseService.changeStatusCourse(course_id))
			response.setCode(ResponseCode.INSERT_SUCCESS);
		else
			response.setCode(ResponseCode.INSERT_FAIL);
		
		return response;
	}
	
	@RequestMapping(value="/change-status-course-class",method=RequestMethod.POST)
	public Response changeStatusCourseWithClass(@RequestBody CloseCourse.paramCloseCorse closeCourse){
		Response response=new Response();
		courseService.changeStatusCourseWithClass(closeCourse);
		if(closeCourse.getSuccess()==1)
			response.setCode(ResponseCode.UPDATE_SUCCESS);
		else
			response.setCode(ResponseCode.UPDATE_FAIL);
		
		return response;
	}
	
	@RequestMapping(value="/get-current-course",method=RequestMethod.GET)
	public ResponseRecord<Course> getCurrentCourse(){
		ResponseRecord<Course> response=new ResponseRecord<>();
	
		Course courseList=courseService.getCurrentCourse();
		if(courseList==null){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(courseList);
		
		return response;
	}
	
}
