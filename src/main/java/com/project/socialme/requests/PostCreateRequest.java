package com.project.socialme.requests;

import lombok.Data;

@Data
public class PostCreateRequest {

	Long id;
	String text;
	String title;
	Long userId;

}
