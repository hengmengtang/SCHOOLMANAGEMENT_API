package org.khmeracademy.smg_btb.service.impl.user;

import java.util.ArrayList;

import org.apache.catalina.User;
import org.khmeracademy.smg_btb.repository.user.UserRepository;
import org.khmeracademy.smg_btb.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public ArrayList<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public boolean insert(User user) {
		return userRepository.insert(user);
	}

	@Override
	public boolean update(String username, String password) {
		return userRepository.update(username, password);
	}

	@Override
	public boolean changeStatus(int user_id, String username) {
		return userRepository.changeStatus(user_id, username);
	}

}
