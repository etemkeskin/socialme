package com.project.socialme.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.socialme.entities.PostImage;
import com.project.socialme.repos.PostImageRepository;

@Service
public class PostImageService {

	@Autowired
	private PostImageRepository postImageRepository;

	private final String FOLDER_PATH = System.getProperty("user.home") + File.separator +"Desktop" + File.separator +"MyFiles" + File.separator;

	public String uploadImageToFileSystem(MultipartFile file) throws IOException {
		String filePath = FOLDER_PATH + file.getOriginalFilename();

		System.out.println("====================");
		System.out.println(filePath);
		System.out.println("====================");
		PostImage fileData = postImageRepository.save(PostImage.builder()
				.name(file.getOriginalFilename())
				.type(file.getContentType())
				.filePath(filePath).build());

		file.transferTo(new File(filePath));

		if (fileData != null) {
			return "file uploaded successfully : " + filePath;
		}
		return null;
	}

	public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
		Optional<PostImage> fileData = postImageRepository.findByName(fileName);
		String filePath = fileData.get().getFilePath();
		byte[] images = Files.readAllBytes(new File(filePath).toPath());
		return images;
	}
	
}
