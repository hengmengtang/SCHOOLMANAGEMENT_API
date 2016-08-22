package org.khmeracademy.smg_btb.service.impl.user;

import java.util.ArrayList;

import org.khmeracademy.smg_btb.entity.form.studentlogin.UserLogin;
import org.khmeracademy.smg_btb.entity.form.user.ParamRegisterUser;
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
	public int save(ParamRegisterUser user) {
		return userRepository.save(user);
	}

	@Override
	public boolean changePassword(UserLogin.changePassword changePassword) {
		return userRepository.changePassword(changePassword);
	}

	@Override
	public boolean changeStatus(int user_id, String username) {
		return userRepository.changeStatus(user_id, username);
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}
}
