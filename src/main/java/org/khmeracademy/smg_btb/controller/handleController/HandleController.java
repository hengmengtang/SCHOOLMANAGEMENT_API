package org.khmeracademy.smg_btb.controller.handleController;

import org.khmeracademy.smg_btb.entity.handle.HandleSubjectToStaffToClassRoom;
import org.khmeracademy.smg_btb.service.handle.HandleSubjectToStaffToClassService;
import org.khmeracademy.smg_btb.utils.Response;
import org.khmeracademy.smg_btb.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HandleController {

	@Autowired
	HandleSubjectToStaffToClassService handleSubjectToStaffToClassService;
	
	@RequestMapping(value="/handle-subject-to-staff-to-class",method=RequestMethod.POST)
	public Response handleSubjectToStaffToClass(@RequestBody HandleSubjectToStaffToClassRoom handleSubjectToStaffToClassRoom){
		Response response=new Response();
		handleSubjectToStaffToClassService.handleSubjectToStaffToClass(handleSubjectToStaffToClassRoom);
		
		if(handleSubjectToStaffToClassRoom.getSuccess()==1)
			response.setCode(ResponseCode.INSERT_SUCCESS);
		else
			response.setCode(ResponseCode.INSERT_FAIL);
		
		return response;
	}
}
