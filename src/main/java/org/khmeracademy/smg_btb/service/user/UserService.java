package org.khmeracademy.smg_btb.service.user;

import java.util.ArrayList;

import org.apache.catalina.User;

public interface UserService {

	public ArrayList<User> findAll();
	public boolean insert(User user);
	public boolean update(String username,String password);
	public boolean changeStatus(int user_id,String username);
}
