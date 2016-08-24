package org.khmeracademy.smg_btb.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.FileUploadException;
import org.khmeracademy.smg_btb.entity.form.studentlogin.UserLogin;
import org.khmeracademy.smg_btb.entity.form.user.ParamRegisterUser;
import org.khmeracademy.smg_btb.entity.user.User;
import org.khmeracademy.smg_btb.service.user.UserService;
import org.khmeracademy.smg_btb.utils.Response;
import org.khmeracademy.smg_btb.utils.ResponseCode;
import org.khmeracademy.smg_btb.utils.ResponseList;
import org.khmeracademy.smg_btb.utils.ResponseRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService userService;
	
	/**
	 * get all student
	 * @return
	 */
	@RequestMapping(value="/find-all-user",method=RequestMethod.GET)
	public ResponseList<User> findAll(){
		ResponseList<User> response=new ResponseList<>();
	
		ArrayList<User> userList=userService.findAll();
		if(userList.isEmpty()){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(userList);
		return response;
	}
	
	/**
	 * save student
	 * @param student
	 * @return
	 */
	@RequestMapping(value="/register-user",method=RequestMethod.POST)
	public Response save(@RequestBody ParamRegisterUser user){
		Response response=new Response();
		userService.save(user);
		if(user.getSuccess()==1)
			response.setCode(ResponseCode.INSERT_SUCCESS);
		else
			response.setCode(ResponseCode.INSERT_FAIL);
		
		return response;
	}
	
	/**
	 * change status in table student by id
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/update-status/{user_id}/{username}",method=RequestMethod.PUT)
	public Response updateStatus(@PathVariable("user_id") int user_id,
			@PathVariable("username") String username){
		Response response=new Response();
		
		if(this.userService.changeStatus(user_id, username))
			response.setCode(ResponseCode.UPDATE_SUCCESS);
		else
			response.setCode(ResponseCode.UPDATE_FAIL);
		
		return response;
	}
	
	/**
	 * update all student by id
	 * @param student
	 * @return
	 */
	@RequestMapping(value="/change-password",method=RequestMethod.PUT)
	public Response changePassword(@RequestBody UserLogin.changePassword changePassword){
		Response response=new Response();
		if(userService.changePassword(changePassword))
			response.setCode(ResponseCode.UPDATE_SUCCESS);
		
		return response;
	}
	
	@RequestMapping(value="/get-user-by-email",method=RequestMethod.POST)
	public ResponseRecord<User> confirmUserLogin(@RequestBody UserLogin login){
		ResponseRecord<User> response=new ResponseRecord<>();
		
		User user=userService.findUserByEmail(login.getEmail());
		if(user==null){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		}
		else{
			response.setCode(ResponseCode.RECORD_FOUND);
		}
		response.setData(user);
		
		return response;
	}
	
	@RequestMapping(value="/upload-profile",method=RequestMethod.POST)
	public Response uploadProfile(@RequestPart("file") List<MultipartFile> file,@RequestPart("email") String email) throws FileUploadException{
		Response response=new Response();
		if(userService.upload(file, email)!=null)
			response.setCode(ResponseCode.INSERT_SUCCESS);
		else
			response.setCode(ResponseCode.INSERT_FAIL);
		
		return response;
	}
}
