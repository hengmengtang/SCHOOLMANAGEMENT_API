package org.khmeracademy.smg_btb.service.impl.user;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.khmeracademy.smg_btb.entity.file_upload.File;
import org.khmeracademy.smg_btb.entity.form.studentlogin.UserLogin;
import org.khmeracademy.smg_btb.entity.form.user.ParamRegisterUser;
import org.khmeracademy.smg_btb.entity.user.User;
import org.khmeracademy.smg_btb.repository.user.UserRepository;
import org.khmeracademy.smg_btb.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;

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

	/**
	 * upload profile to server
	 */
	@Override
	public File upload(List<MultipartFile> files, String email) {
		File uploadImage = new File();
		if (files.isEmpty()) {

		} else {
			String UPLOAD_PATH = "/opt/project/default";
			String THUMBNAIL_PATH = "/opt/project/thumnail/";

			java.io.File path = new java.io.File(UPLOAD_PATH);
			java.io.File thum_path = new java.io.File(THUMBNAIL_PATH);
			if (!path.exists())
				path.mkdirs();
			if (!thum_path.exists()) {
				thum_path.mkdirs();
			}

			List<String> names = new ArrayList<>();
			for (MultipartFile file : files) {
				
				String fileName = file.getOriginalFilename();
				fileName = UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
				try {
					byte[] bytes = file.getBytes();
					Files.copy(file.getInputStream(), Paths.get(UPLOAD_PATH, fileName)); // copy
																							// path
																							// name
																							// to
																							// server
					try {
						// TODO: USING THUMBNAILS TO RESIZE THE IMAGE

						Thumbnails.of(UPLOAD_PATH + "/" + fileName).forceSize(640, 640).toFiles(thum_path,
								Rename.NO_CHANGE);
					} catch (Exception ex) {
						BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new java.io.File(THUMBNAIL_PATH)+fileName));
						stream.write(bytes);
						stream.close();
					}
					names.add(fileName); // add file name
					userRepository.insert(fileName, email);// upload path to database
				} catch (Exception e) {

				}
			}
			uploadImage.setProjectPath("/resources/");
			uploadImage.setServerPath(UPLOAD_PATH);
			uploadImage.setNames(names);
			uploadImage.setMessage("File has been uploaded successfully!!!");
		}
		return uploadImage;
	}
}
