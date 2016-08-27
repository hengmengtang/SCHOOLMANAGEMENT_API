package org.khmeracademy.smg_btb.controller.classroom;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.class_room.ClassRoom;
import org.khmeracademy.smg_btb.entity.form.list_class.ListClassInCourse;
import org.khmeracademy.smg_btb.entity.form.list_course.ListCourse;
import org.khmeracademy.smg_btb.entity.form.max_id.MaxId;
import org.khmeracademy.smg_btb.entity.student.Student;
import org.khmeracademy.smg_btb.service.classroom.ClassService;
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
@RequestMapping("/api/class")
public class ClassRoomController {

	@Autowired
	ClassService classService;
	
	@RequestMapping(value="/find-all-class",method=RequestMethod.GET)
	public ResponseList<ClassRoom> findAll(){
		ResponseList<ClassRoom> response=new ResponseList<>();
	
		ArrayList<ClassRoom> classRoomList=classService.findAll();
		if(classRoomList.isEmpty()){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(classRoomList);
		
		return response;
	}
	
	@RequestMapping(value="/add-class",method=RequestMethod.POST)
	public Response insert(@RequestBody ClassRoom classRoom){
		Response response=new Response();
		if(!classService.insert(classRoom))
			response.setCode(ResponseCode.INSERT_SUCCESS);
		else
			response.setCode(ResponseCode.INSERT_FAIL);
		
		return response;
	}
	
	@RequestMapping(value="/auto-class-id",method=RequestMethod.GET)
	public ResponseRecord<MaxId> selectMaxId(){
		ResponseRecord<MaxId> response=new ResponseRecord<>();
		
		MaxId maxId=classService.selectMax();
		if(maxId==null)
			response.setCode(ResponseCode.FAIL);
		else
			response.setCode(ResponseCode.SUCCESS);
		
		response.setData(maxId);
		
		return response;
	}
	
	@RequestMapping(value="/get-class-by-staff-generation-course",method=RequestMethod.POST)
	public ResponseList<ClassRoom> getClassByStaffgenerationCourse(@RequestBody Student.getCourseByStaffGenerationCourse course){
		ResponseList<ClassRoom> response=new ResponseList<>();
		
		ArrayList<ClassRoom> classRoomList=classService.getClassByStaffGenerationCourse(course);
		
		if(classRoomList.isEmpty()){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(classRoomList);
		
		return response;
	}
	
	@RequestMapping(value="/get-class-not-yet-enroll-student",method=RequestMethod.GET)
	public ResponseList<ClassRoom> getClassNotYetEnrollStudent(){
		ResponseList<ClassRoom> response=new ResponseList<>();
	
		ArrayList<ClassRoom> classRoomList=classService.getClassNotYetEnrollStudent();
		
		if(classRoomList.isEmpty()){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(classRoomList);
		
		return response;
	}
	
	@RequestMapping(value="/get-class-by-generation-course",method=RequestMethod.POST)
	public ResponseList<ClassRoom> getClassBygenerationCourse(@RequestBody Student.getCourseByGenerationCourse genCourse){
		ResponseList<ClassRoom> response=new ResponseList<>();
		
		ArrayList<ClassRoom> classRoomList=classService.getClassByGenerationCourse(genCourse);
		
		if(classRoomList.isEmpty()){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(classRoomList);
		
		return response;
	}
	
	@RequestMapping(value="/list-class-in-all-generation",method=RequestMethod.GET)
	public ResponseList<ListClassInCourse> listClass(){
		ResponseList<ListClassInCourse> response=new ResponseList<>();
	
		ArrayList<ListClassInCourse> classList=classService.listClass();
		if(classList.isEmpty()){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(classList);
		
		return response;
	}
	
	@RequestMapping(value="/change-status-class/{class_name}",method=RequestMethod.GET)
	public Response channgeStatusClass(@PathVariable("class_name") String class_name){
		Response response=new Response();
	
		if(classService.changeStatusClass(class_name)==false)
			response.setCode(ResponseCode.UPDATE_SUCCESS);
		
		return response;
	}
	
	@RequestMapping(value="/open-class/{class_id}",method=RequestMethod.GET)
	public Response openClass(@PathVariable("class_id") String class_id){
		Response response=new Response();
	
		if(classService.openClass(class_id))
			response.setCode(ResponseCode.UPDATE_SUCCESS);
		else
			response.setCode(ResponseCode.UPDATE_FAIL);
		
		return response;
	}
	
	@RequestMapping(value="/get-class-status-true",method=RequestMethod.GET)
	public ResponseList<ClassRoom> getClassStatusTrue(){
		ResponseList<ClassRoom> response=new ResponseList<>();
	
		ArrayList<ClassRoom> classRoomList=classService.getClassStatusTrue();
		if(classRoomList.isEmpty()){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(classRoomList);
		
		return response;
	}
}
