package org.khmeracademy.smg_btb.controller.result;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.form.monthly_result.ParamViewResult;
import org.khmeracademy.smg_btb.entity.form.monthly_result.ResultStudentEachMonth;
import org.khmeracademy.smg_btb.entity.form.monthly_result.Subject;
import org.khmeracademy.smg_btb.entity.form.monthly_result.SubjectAdvance;
import org.khmeracademy.smg_btb.entity.form.monthly_result.SubjectBasic;
import org.khmeracademy.smg_btb.entity.form.statistic.ClassName;
import org.khmeracademy.smg_btb.entity.form.view_score.ParamViewScore;
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
	
	@RequestMapping(value="/monthly-result-basic-course",method=RequestMethod.POST)
	public ResponseList<SubjectBasic> resultBasic(@RequestBody ParamViewScore viewScore){
		ResponseList<SubjectBasic> response=new ResponseList<>();
	
		ArrayList<SubjectBasic> resultList=resultService.resultBasic(viewScore);
		if(resultList.isEmpty()){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(resultList);
		
		return response;
	}
	
	@RequestMapping(value="/monthly-result-advance-course",method=RequestMethod.POST)
	public ResponseList<SubjectAdvance> resultAdvance(@RequestBody ParamViewScore viewScore){
		ResponseList<SubjectAdvance> response=new ResponseList<>();
	
		ArrayList<SubjectAdvance> resultList=resultService.resultAdvance(viewScore);
		if(resultList.isEmpty()){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(resultList);
		
		return response;
	}
	
	@RequestMapping(value="/monthly-result-on-month",method=RequestMethod.POST)
	public ResponseList<Subject.basic> monthlyResultOnMonth(@RequestBody ParamViewResult result){
		ResponseList<Subject.basic> response=new ResponseList<>();
		
		ArrayList<Subject.basic> monthlyResult=resultService.resultBasicOnMonth(result);
		if(monthlyResult.isEmpty()){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(monthlyResult);
		
		return response;
	}
	
	@RequestMapping(value="/student-result-each-month/{student_name}",method=RequestMethod.POST)
	public ResponseList<ResultStudentEachMonth> studentResultEachMonth(@PathVariable("student_name") String student_name){
		ResponseList<ResultStudentEachMonth> response=new ResponseList<>();
		
		ArrayList<ResultStudentEachMonth> monthlyResult=resultService.studentResultEachMonth(student_name);
		if(monthlyResult.isEmpty()){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(monthlyResult);
		
		return response;
	}
	
	@RequestMapping(value="/get-month/{student_name}",method=RequestMethod.POST)
	public ResponseList<ResultStudentEachMonth> getMonth(@PathVariable("student_name") String student_name){
		ResponseList<ResultStudentEachMonth> response=new ResponseList<>();
		
		ArrayList<ResultStudentEachMonth> month=resultService.getMonth(student_name);
		if(month.isEmpty()){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(month);
		
		return response;
	}
	
	@RequestMapping(value="/get-summery-result/{generation_name}",method=RequestMethod.GET)
	public ResponseList<ClassName> summeryResult(@PathVariable("generation_name") String generation_name){
		ResponseList<ClassName> response=new ResponseList<>();
		
		ArrayList<ClassName> summeryResult=resultService.summeryResult(generation_name);
		if(summeryResult.isEmpty()){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(summeryResult);
		
		return response;
	}
}
