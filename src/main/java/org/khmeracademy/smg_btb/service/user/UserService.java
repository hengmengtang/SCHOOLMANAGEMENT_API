package org.khmeracademy.smg_btb.service.user;

import java.util.ArrayList;
import java.util.List;

import org.khmeracademy.smg_btb.entity.file_upload.File;
import org.khmeracademy.smg_btb.entity.form.studentlogin.UserLogin;
import org.khmeracademy.smg_btb.entity.form.user.ParamRegisterUser;
import org.khmeracademy.smg_btb.entity.user.User;
import org.springframework.web.multipart.MultipartFile;


public interface UserService {

	public ArrayList<User> findAll();
	public int save(ParamRegisterUser user);
	public boolean changePassword(UserLogin.changePassword changePassword);
	public boolean changeStatus(int user_id,String username);
	public User findUserByEmail(String email);
	public File upload(List<MultipartFile> file,String email);
}
