package com.beaver.community.repository;

import com.beaver.community.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRespository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
