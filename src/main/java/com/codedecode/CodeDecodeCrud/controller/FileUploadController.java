package com.codedecode.CodeDecodeCrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.codedecode.CodeDecodeCrud.helper.FileUploadHelper;

@RestController
public class FileUploadController {
	
	private final FileUploadHelper helper;

    @Autowired
    public FileUploadController(FileUploadHelper helper) {
        this.helper = helper;
    }


	@PostMapping("/upload")
	public ResponseEntity<String> uploadAll(@RequestParam("file")
	MultipartFile file) {
		
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
//		System.out.println(file.getContentType());
//		System.out.println(file.getName());
		
		try {
		
		if(file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
					body("Request must contain file");
		}
		
//		if(!file.getContentType().equals("images/jpg")) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
//					body("Only Jpeg supported");
//		}
		
		// file upload code
		boolean f = helper.uploadFile(file);
		
		if (f) {
			
//			return ResponseEntity.ok("File is successfully uploaded");
			
			return ResponseEntity.ok(ServletUriComponentsBuilder.
					fromCurrentContextPath().path("/images/").
					path(file.getOriginalFilename()).toUriString());
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
				body("Something went wrong. Try again !!");
	}
}
