package com.pfa.repository;

import com.pfa.model.user;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<user, Integer> {
}