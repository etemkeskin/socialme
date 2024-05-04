package com.project.socialme.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.socialme.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	// JPA handle this method
	List<Post> findByUserId(Long userId);



	
}
