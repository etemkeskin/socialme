package com.project.socialme.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.socialme.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
