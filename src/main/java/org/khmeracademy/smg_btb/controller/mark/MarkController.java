package org.khmeracademy.smg_btb.controller.mark;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.form.add_mark.DisplayAddMark;
import org.khmeracademy.smg_btb.entity.form.mark.ParamUpdateScore;
import org.khmeracademy.smg_btb.entity.form.monthly_result.ParamViewResult;
import org.khmeracademy.smg_btb.entity.form.monthly_result.Subject;
import org.khmeracademy.smg_btb.entity.generation.Generation;
import org.khmeracademy.smg_btb.entity.mark.Mark;
import org.khmeracademy.smg_btb.service.mark.MarkService;
import org.khmeracademy.smg_btb.utils.Response;
import org.khmeracademy.smg_btb.utils.ResponseCode;
import org.khmeracademy.smg_btb.utils.ResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mark")
public class MarkController {

	@Autowired
	MarkService markService;
	
	@RequestMapping(value="/add-mark",method=RequestMethod.POST)
	public Response addMark(@RequestBody Mark mark){
		Response response=new Response();
		markService.addMark(mark);
		
		if(mark.getSuccess()==1)
			response.setCode(ResponseCode.INSERT_SUCCESS);
		else
			response.setCode(ResponseCode.INSERT_FAIL);
		
		return response;
	}
	
	@RequestMapping(value="/display-student-to-add-score",method=RequestMethod.GET)
	public ResponseList<DisplayAddMark> displayStudentToAddScore(){
		ResponseList<DisplayAddMark> response=new ResponseList<>();
		
		ArrayList<DisplayAddMark> studentList=markService.displayStudentToAddScore();
		if(studentList.isEmpty()){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(studentList);
		
		return response;
	}
	
	@RequestMapping(value="/update-mark",method=RequestMethod.PUT)
	public Response update(@RequestBody ParamUpdateScore updateScore){
		Response response=new Response();
		
		if(markService.update(updateScore))
			response.setCode(ResponseCode.UPDATE_SUCCESS);
		else
			response.setCode(ResponseCode.UPDATE_FAIL);
		
		return response;
	}

}
