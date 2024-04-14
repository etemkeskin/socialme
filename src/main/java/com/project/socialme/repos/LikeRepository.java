package com.project.socialme.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.socialme.entities.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {

}
