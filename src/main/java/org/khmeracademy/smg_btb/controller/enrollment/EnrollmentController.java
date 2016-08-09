package org.khmeracademy.smg_btb.controller.enrollment;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.enrollment.Enrollment;
import org.khmeracademy.smg_btb.entity.form.close_course.CloseCourse;
import org.khmeracademy.smg_btb.service.enrollment.EnrollmentService;
import org.khmeracademy.smg_btb.utils.Response;
import org.khmeracademy.smg_btb.utils.ResponseCode;
import org.khmeracademy.smg_btb.utils.ResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

	@Autowired
	EnrollmentService enrollmentService;
	
	@RequestMapping(value="/find-all-enrollment",method=RequestMethod.GET)
	public ResponseList<Enrollment> findAll(){
		ResponseList<Enrollment> response=new ResponseList<>();
	
		ArrayList<Enrollment> enrollmentList=enrollmentService.findAll();
		if(enrollmentList.isEmpty()){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(enrollmentList);
		
		return response;
	}
	
	@RequestMapping(value="/register-generation",method=RequestMethod.POST)
	public Response save(@RequestBody Enrollment enrollment){
		Response response=new Response();
		if(enrollmentService.insert(enrollment))
			response.setCode(ResponseCode.INSERT_SUCCESS);
		else
			response.setCode(ResponseCode.INSERT_FAIL);
		
		return response;
	}
	
	@RequestMapping(value="/change-enrollment-status",method=RequestMethod.PUT)
	public Response changeStatus(@RequestBody CloseCourse closeGeneration){
		Response response=new Response();
		if(enrollmentService.changeStatus(closeGeneration))
			response.setCode(ResponseCode.UPDATE_SUCCESS);
		else
			response.setCode(ResponseCode.UPDATE_FAIL);
		
		return response;
	}
}
