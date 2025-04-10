package com.dev.kevin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.kevin.model.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{


}
