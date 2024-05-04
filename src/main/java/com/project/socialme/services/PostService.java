package com.project.socialme.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.socialme.entities.Post;
import com.project.socialme.entities.User;
import com.project.socialme.repos.PostRepository;
import com.project.socialme.requests.PostCreateRequest;

@Service
public class PostService {

	private PostRepository postRepository;
	private UserService userService;

	public PostService(PostRepository postRepository, UserService userService) {
		this.postRepository = postRepository;
		this.userService = userService;
	}

	public List<Post> getAllPosts(Optional<Long> userId) {
		if (userId.isPresent()) {
			return postRepository.findByUserId(userId.get());
		}
		return postRepository.findAll();
	}

	public Post getOnePostById(Long postId) {
		return postRepository.findById(postId).orElse(null);
	}

	public Post createOnePost(PostCreateRequest newPostRequest) {
		User user = userService.getOneUser(newPostRequest.getUserId());
		if (user == null) {
			return null;
		} else {
			Post toSavePost = new Post();
			toSavePost.setText(newPostRequest.getText());
			toSavePost.setTitle(newPostRequest.getTitle());
			toSavePost.setUser(user);
			return postRepository.save(toSavePost);
		}

	}

}
