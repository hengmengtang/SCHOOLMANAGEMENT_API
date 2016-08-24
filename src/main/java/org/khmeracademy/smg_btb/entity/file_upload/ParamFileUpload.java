package org.khmeracademy.smg_btb.entity.file_upload;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParamFileUpload {

	@JsonProperty("FILE")
	private ArrayList<MultipartFile> file;
	
	@JsonProperty("FOLDER")	
	private String folder;
	
	@JsonProperty("EMAIL")
	private String email;

	public ArrayList<MultipartFile> getFile() {
		return file;
	}

	public void setFile(ArrayList<MultipartFile> file) {
		this.file = file;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
