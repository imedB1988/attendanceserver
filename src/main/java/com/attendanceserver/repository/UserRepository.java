package com.attendanceserver.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attendanceserver.entities.User;
import com.attendanceserver.enums.UserRole;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findByUserRole(UserRole role);
    Optional<User> findByEmail(String email);

  



}
