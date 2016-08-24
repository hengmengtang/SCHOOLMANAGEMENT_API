package org.khmeracademy.smg_btb.controller.file_upload;

import java.util.List;

import org.khmeracademy.smg_btb.entity.file_upload.File;
import org.khmeracademy.smg_btb.service.file_upload.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

	@Autowired
	private FileUploadService uploadService;
	
	/***
	 * 
	 * Upload to default folder or to specific folder
	 * @param files
	 * @return
	 */
	@RequestMapping(value="/upload-file", method = RequestMethod.POST)
	public File upload(@RequestParam("files") List<MultipartFile> files, 
					   @RequestParam(value="folder", required=false) String folder){
		return uploadService.upload(files, folder);
	}
}
