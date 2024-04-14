package com.project.socialme.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.socialme.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
