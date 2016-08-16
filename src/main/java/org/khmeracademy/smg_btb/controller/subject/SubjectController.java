package org.khmeracademy.smg_btb.controller.subject;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.form.max_id.MaxId;
import org.khmeracademy.smg_btb.entity.student.Student;
import org.khmeracademy.smg_btb.entity.subject.Subject;
import org.khmeracademy.smg_btb.service.subject.SubjectService;
import org.khmeracademy.smg_btb.utils.Response;
import org.khmeracademy.smg_btb.utils.ResponseCode;
import org.khmeracademy.smg_btb.utils.ResponseList;
import org.khmeracademy.smg_btb.utils.ResponseRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

	@Autowired
	SubjectService subjectService;
	
	@RequestMapping(value="/find-all-subject",method=RequestMethod.GET)
	public ResponseList<Subject> findAll(){
		ResponseList<Subject> response=new ResponseList<>();
	
		ArrayList<Subject> subjectList=subjectService.findAll();
		if(subjectList.isEmpty()){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(subjectList);
		
		return response;
	}
	
	@RequestMapping(value="/add-subject",method=RequestMethod.POST)
	public Response insertSubject(@RequestBody Subject subject){
		Response response=new Response();
		try{
			if(subjectService.insert(subject))
				response.setCode(ResponseCode.INSERT_SUCCESS);
			else
				response.setCode(ResponseCode.INSERT_FAIL);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return response;
	}
	
	@RequestMapping(value="/auto-subject-id",method=RequestMethod.GET)
	public ResponseRecord<MaxId> selectMaxId(){
		ResponseRecord<MaxId> response=new ResponseRecord<>();
		
		MaxId maxId=subjectService.selectMax();
		if(maxId==null)
			response.setCode(ResponseCode.FAIL);
		else
			response.setCode(ResponseCode.SUCCESS);
		
		response.setData(maxId);
		
		return response;
	}
	
	
	@RequestMapping(value="/get-current-subject-in-course",method=RequestMethod.POST)
	public ResponseList<Subject> getSubjectInCourse(@RequestBody Student.getGenerationCourse generationCourse){
		ResponseList<Subject> response=new ResponseList<>();
	
		ArrayList<Subject> subjectList=subjectService.getSubjectInCourse(generationCourse);
		if(subjectList.isEmpty()){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(subjectList);
		
		return response;
	}
	
}
