package org.khmeracademy.smg_btb.controller.staff;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.staff.Staff;
import org.khmeracademy.smg_btb.service.staff.StaffService;
import org.khmeracademy.smg_btb.utils.ResponseCode;
import org.khmeracademy.smg_btb.utils.ResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	StaffService staffService;
	
	@RequestMapping(value="/find-all-staff",method=RequestMethod.GET)
	public ResponseList<Staff> findAll(){
		ResponseList<Staff> response=new ResponseList<>();
	
		ArrayList<Staff> staffList=staffService.findAll();
		if(staffList.isEmpty()){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(staffList);
		
		return response;
	}
	
}
