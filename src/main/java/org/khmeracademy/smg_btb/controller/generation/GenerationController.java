package org.khmeracademy.smg_btb.controller.generation;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.form.max_id.MaxId;
import org.khmeracademy.smg_btb.entity.generation.Generation;
import org.khmeracademy.smg_btb.entity.student.Student;
import org.khmeracademy.smg_btb.service.generation.GenerationService;
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
@RequestMapping("/api/generation")
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
	
	@RequestMapping(value="/add-generation",method=RequestMethod.POST)
	public Response enrollGeneration(@RequestBody Generation generation){
		Response response=new Response();
		
		if(generationService.registerGeneration(generation))
			response.setCode(ResponseCode.INSERT_SUCCESS);
		else
			response.setCode(ResponseCode.INSERT_FAIL);
		
		return response;
	}
	
	@RequestMapping(value="/auto-generation-id",method=RequestMethod.GET)
	public ResponseRecord<MaxId> selectMaxId(){
		ResponseRecord<MaxId> response=new ResponseRecord<>();
		try{
			MaxId maxId=generationService.selectMax();
			if(maxId==null)
				response.setCode(ResponseCode.FAIL);
			else
				response.setCode(ResponseCode.SUCCESS);
			
			response.setData(maxId);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return response;
	}

	@RequestMapping(value="/get-last-generation",method=RequestMethod.GET)
	public ResponseRecord<Generation> getLastGeneration(){
		ResponseRecord<Generation> response=new ResponseRecord<>();
	
		Generation generationList=generationService.getLastGeneration();
		if(generationList==null){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(generationList);
		
		return response;
	}
	
	@RequestMapping(value="/change-status-true/{gen_id}",method=RequestMethod.PUT)
	public Response changeStatusTrue(@PathVariable("gen_id") String gen_id){
		Response response=new Response();
		
		if(generationService.changeStatusTrue(gen_id))
			response.setCode(ResponseCode.UPDATE_SUCCESS);
		else
			response.setCode(ResponseCode.UPDATE_FAIL);
		
		return response;
	}
	
	@RequestMapping(value="/get-generation-status-true",method=RequestMethod.GET)
	public ResponseRecord<Generation> getGenerationStatusTrue(){
		ResponseRecord<Generation> response=new ResponseRecord<>();
		Generation gen=generationService.getGenerationStatusTrue();
		if(gen!=null)
			response.setCode(ResponseCode.RECORD_FOUND);
		else
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		
		response.setData(gen);
		
		return response;
	}
	
}
