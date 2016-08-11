package org.khmeracademy.smg_btb.controller.student;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.checkUser.CheckUser;
import org.khmeracademy.smg_btb.entity.form.max_id.MaxId;
import org.khmeracademy.smg_btb.entity.student.Student;
import org.khmeracademy.smg_btb.service.student.StudentService;
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
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	/**
	 * get all student
	 * @return
	 */
	@RequestMapping(value="/find-all",method=RequestMethod.GET)
	public ResponseList<Student> findAll(){
		ResponseList<Student> response=new ResponseList<>();
	
		ArrayList<Student> studentList=studentService.findAll();
		if(studentList.isEmpty()){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(studentList);
		return response;
	}
	
	/**
	 * save student
	 * @param student
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Response save(@RequestBody Student student){
		Response response=new Response();
		if(studentService.save(student))
			response.setCode(ResponseCode.INSERT_SUCCESS);
		else
			response.setCode(ResponseCode.INSERT_FAIL);
		
		return response;
	}
	
	/**
	 * change status in table student by id
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/updateStatus/{id}",method=RequestMethod.PUT)
	public Response updateStatus(@PathVariable("id") String id){
		Response response=new Response();
		
		if(this.studentService.updateStatus(id))
			response.setCode(ResponseCode.UPDATE_SUCCESS);
		else
			response.setCode(ResponseCode.UPDATE_FAIL);
		
		return response;
	}
	
	/**
	 * update all student by id
	 * @param student
	 * @return
	 */
	@RequestMapping(value="/updateById",method=RequestMethod.PUT)
	public Response updateById(@RequestBody Student student){
		Response response=new Response();
		if(studentService.updateById(student))
			response.setCode(ResponseCode.UPDATE_SUCCESS);
		else
			response.setCode(ResponseCode.UPDATE_FAIL);
		
		return response;
	}
	
	/**
	 * checking user available in db or not. if had them can register to a user
	 * @param user_name
	 * @param phone
	 * @return
	 */
	@RequestMapping(value="/check-user-is-exist",method=RequestMethod.POST)
	public ResponseRecord<CheckUser> checkUser(@RequestBody CheckUser checkUser){
		ResponseRecord<CheckUser> response=new ResponseRecord<>();
		CheckUser foundUser=studentService.checkUser(checkUser);
		if(foundUser==null)
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		else
			response.setCode(ResponseCode.RECORD_FOUND);
		
		response.setData(foundUser);
		
		return response;
	}
	
	@RequestMapping(value="/auto-student-id",method=RequestMethod.GET)
	public ResponseRecord<MaxId> selectMaxId(){
		ResponseRecord<MaxId> response=new ResponseRecord<>();
		
		MaxId maxId=studentService.selectMaxId();
		if(maxId==null)
			response.setCode(ResponseCode.FAIL);
		else
			response.setCode(ResponseCode.SUCCESS);
		
		response.setData(maxId);
		
		return response;
	}
	
	@RequestMapping(value="/select_student-by-generation-and-course",method=RequestMethod.POST)
	public ResponseList<Student.subStudent> selectStudentByGenerationCourse(@RequestBody Student.getGenerationCourse getGenerationCourse){
		ResponseList<Student.subStudent> response=new ResponseList<>();
		try{
		ArrayList<Student.subStudent> subStudentList=studentService.select_student_by_generation_course(getGenerationCourse);
		
		if(subStudentList==null)
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		else
			response.setCode(ResponseCode.RECORD_FOUND);
		
		response.setData(subStudentList);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return response;
	}
	
	@RequestMapping(value="/select-student-by-id/{stu_id}",method=RequestMethod.POST)
	public ResponseRecord<Student> selectStudentById(@PathVariable("stu_id") String stu_id){
		ResponseRecord<Student> response=new ResponseRecord<>();
		Student recordStudent=studentService.selectStudentById(stu_id);
		if(recordStudent==null)
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		else
			response.setCode(ResponseCode.RECORD_FOUND);
		
		response.setData(recordStudent);
		
		return response;
	}
	
}
