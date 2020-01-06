package com.hamuse.web.proxy;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;



@Component("filemgr")
public class FileProxy extends Proxy {
	/*
	 * public void fileupload(MultipartFile[] uploadFile) { String uploadFolder =
	 * Path.UPLOAD_PATH.toString(); File uploadPath = new
	 * File(uploadFolder,getFoler()); if(uploadPath.exists() == false) {
	 * uploadPath.mkdirs(); } for(MultipartFile f : uploadFile) { String fname =
	 * f.getOriginalFilename(); String extension =
	 * fname.substring(fname.lastIndexOf(".")+1); fname =
	 * fname.substring(fname.lastIndexOf("\\")+1,fname.lastIndexOf(".")); File
	 * savedFile = new
	 * File(uploadPath,fname+"-"+UUID.randomUUID().toString()+"."+extension); try {
	 * f.transferTo(savedFile); } catch (Exception e) { e.printStackTrace(); } } }
	 */
	public String getFoler() {
		return  currentDate().replace("-", File.separator);
	}
}