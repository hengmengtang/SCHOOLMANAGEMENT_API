package org.khmeracademy.smg_btb.controller.mark;

import org.khmeracademy.smg_btb.entity.mark.Mark;
import org.khmeracademy.smg_btb.service.mark.MarkService;
import org.khmeracademy.smg_btb.utils.Response;
import org.khmeracademy.smg_btb.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
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
}
