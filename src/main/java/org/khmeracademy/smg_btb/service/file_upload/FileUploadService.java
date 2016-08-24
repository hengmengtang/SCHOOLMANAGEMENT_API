package org.khmeracademy.smg_btb.service.file_upload;

import java.util.List;

import org.khmeracademy.smg_btb.entity.file_upload.File;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
	
	/***
	 * Upload to default location
	 */
	public File upload(List<MultipartFile> files, String folder);
	
	
}
