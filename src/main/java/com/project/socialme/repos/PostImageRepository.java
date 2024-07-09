package com.project.socialme.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.socialme.entities.PostImage;

public interface PostImageRepository extends JpaRepository<PostImage, Long> {

	Optional<PostImage> findByName(String fileName);

}
