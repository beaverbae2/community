package com.beaver.community.repository;

import com.beaver.community.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRespository extends JpaRepository<User, Long> {
}
