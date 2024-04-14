package com.project.socialme.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.socialme.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
