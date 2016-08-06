package org.khmeracademy.smg_btb.service.impl.user;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.user.User;
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
	public boolean save(User user) {
		return userRepository.save(user);
	}

	@Override
	public boolean changePassword(String old_password, String new_password) {
		return userRepository.changePassword(old_password, new_password);
	}

	@Override
	public boolean changeStatus(int user_id, String username) {
		return userRepository.changeStatus(user_id, username);
	}
}
