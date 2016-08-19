package org.khmeracademy.smg_btb.controller.result;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.form.monthly_result.SubjectAdvance;
import org.khmeracademy.smg_btb.entity.form.monthly_result.SubjectBasic;
import org.khmeracademy.smg_btb.entity.student.Student;
import org.khmeracademy.smg_btb.service.result.MonthlyResultService;
import org.khmeracademy.smg_btb.utils.ResponseCode;
import org.khmeracademy.smg_btb.utils.ResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/monthly-result")
public class MonthlyResultController {

	@Autowired
	MonthlyResultService resultService;
	
	@RequestMapping(value="/monthly-result-basic-course/{generation_name}",method=RequestMethod.POST)
	public ResponseList<SubjectBasic> resultBasic(@PathVariable("generation_name") String generation_name){
		ResponseList<SubjectBasic> response=new ResponseList<>();
	
		ArrayList<SubjectBasic> resultList=resultService.resultBasic(generation_name);
		if(resultList.isEmpty()){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(resultList);
		
		return response;
	}
	
	@RequestMapping(value="/monthly-result-advance-course/{generation_name}",method=RequestMethod.POST)
	public ResponseList<SubjectAdvance> resultAdvance(@PathVariable("generation_name") String generation_name){
		ResponseList<SubjectAdvance> response=new ResponseList<>();
	
		ArrayList<SubjectAdvance> resultList=resultService.resultAdvance(generation_name);
		if(resultList.isEmpty()){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(resultList);
		
		return response;
	}
}
