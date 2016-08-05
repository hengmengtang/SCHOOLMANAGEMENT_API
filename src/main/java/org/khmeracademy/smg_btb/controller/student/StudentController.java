package org.khmeracademy.smg_btb.controller.student;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.student.Student;
import org.khmeracademy.smg_btb.service.student.StudentService;
import org.khmeracademy.smg_btb.utils.Response;
import org.khmeracademy.smg_btb.utils.ResponseCode;
import org.khmeracademy.smg_btb.utils.ResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class StudentController {

	@Autowired
	StudentService studentService;
	
	
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
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public void save(@RequestBody Student student){
		System.out.println(student);
		this.studentService.save(student);
	}
	
	@RequestMapping(value="/updateStatus/{id}",method=RequestMethod.PUT)
	public void updateStatus(@PathVariable("id") int id){
		this.studentService.updateStatus(id);
	}
	
	@RequestMapping(value="/updateById",method=RequestMethod.PUT)
	public void updateById(@RequestBody Student student){
		this.studentService.updateById(student);
	}
	
}
