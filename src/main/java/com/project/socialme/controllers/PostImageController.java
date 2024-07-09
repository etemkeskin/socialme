package com.project.socialme.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.socialme.services.PostImageService;

@RestController
@RequestMapping("/image")
public class PostImageController {

	@Autowired
	private PostImageService postImageService;
	
	@PostMapping("/post-image")
	public ResponseEntity<?> uploadPostImageToFileSystem(@RequestParam("image") MultipartFile file) throws IOException {
		String uploadImage = postImageService.uploadImageToFileSystem(file);
		return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
	}
	
	@GetMapping("/{fileName}")
	public ResponseEntity<?> getPostImageFromFileSystem(@PathVariable String fileName) throws IOException {
		byte[] imageData = postImageService.downloadImageFromFileSystem(fileName);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageData);
		
	}
}
