package org.khmeracademy.smg_btb.service.user;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.form.studentlogin.UserLogin;
import org.khmeracademy.smg_btb.entity.user.User;


public interface UserService {

	public ArrayList<User> findAll();
	public boolean save(User user);
	public boolean changePassword(UserLogin.changePassword changePassword);
	public boolean changeStatus(int user_id,String username);
	public User findUserByEmail(String email);
}
