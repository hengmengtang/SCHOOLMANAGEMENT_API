package org.khmeracademy.smg_btb.controller.generation;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.generation.Generation;
import org.khmeracademy.smg_btb.service.generation.GenerationService;
import org.khmeracademy.smg_btb.utils.ResponseCode;
import org.khmeracademy.smg_btb.utils.ResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generation")
public class GenerationController {
	
	@Autowired
	GenerationService generationService;
	
	@RequestMapping(value="/find-all-generation",method=RequestMethod.GET)
	public ResponseList<Generation> findAll(){
		ResponseList<Generation> response=new ResponseList<>();
	
		ArrayList<Generation> generationList=generationService.findAll();
		if(generationList.isEmpty()){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(generationList);
		
		return response;
	}

}
