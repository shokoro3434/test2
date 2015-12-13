package com.eitax.recall.front.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eitax.recall.front.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
}
