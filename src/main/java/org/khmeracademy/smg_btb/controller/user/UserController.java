package org.khmeracademy.smg_btb.controller.user;

import java.util.ArrayList;

import org.apache.catalina.User;
import org.khmeracademy.smg_btb.service.user.UserService;
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
	@RequestMapping(value="/save-user",method=RequestMethod.POST)
	public Response save(@RequestBody User user){
		Response response=new Response();
		if(userService.insert(user))
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
	@RequestMapping(value="/update-user/{username}/{password}",method=RequestMethod.PUT)
	public Response update(@PathVariable("username") String username,
			@PathVariable("password") String password){
		Response response=new Response();
		if(userService.update(username, password))
			response.setCode(ResponseCode.UPDATE_SUCCESS);
		else
			response.setCode(ResponseCode.UPDATE_FAIL);
		
		return response;
	}
	
}
