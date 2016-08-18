package org.khmeracademy.smg_btb.controller.staff;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.form.compareHandleSubjectToStaff;
import org.khmeracademy.smg_btb.entity.form.display_staff_in_class.StaffInClass;
import org.khmeracademy.smg_btb.entity.form.max_id.MaxId;
import org.khmeracademy.smg_btb.entity.staff.Staff;
import org.khmeracademy.smg_btb.service.staff.StaffService;
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
@RequestMapping("/api/staff")
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
	
	
	@RequestMapping(value="/add-staff",method=RequestMethod.POST)
	public Response save(@RequestBody Staff staff){
		Response response=new Response();
		if(staffService.save(staff))
			response.setCode(ResponseCode.INSERT_SUCCESS);
		else
			response.setCode(ResponseCode.INSERT_FAIL);
		
		return response;
	}
	
	@RequestMapping(value="/auto-staff-id",method=RequestMethod.GET)
	public ResponseRecord<MaxId> selectMaxId(){
		ResponseRecord<MaxId> response=new ResponseRecord<>();
		
		MaxId maxId=staffService.selectMax();
		if(maxId==null)
			response.setCode(ResponseCode.FAIL);
		else
			response.setCode(ResponseCode.SUCCESS);
		
		response.setData(maxId);
		
		return response;
	}
	
	@RequestMapping(value="/display-staff-in-class",method=RequestMethod.GET)
	public ResponseList<StaffInClass> getStaffInClass(){
		ResponseList<StaffInClass> response=new ResponseList<>();
	
		ArrayList<StaffInClass> staffList=staffService.getStaffInClass();
		
		if(staffList.isEmpty()){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(staffList);
		
		return response;
	}
	
	@RequestMapping(value="/display-staff-subject-to-compare",method=RequestMethod.GET)
	public ResponseList<compareHandleSubjectToStaff> getListStaffToCompare(){
		ResponseList<compareHandleSubjectToStaff> response=new ResponseList<>();
	
		ArrayList<compareHandleSubjectToStaff> staffList=staffService.getListStaff();
		
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
