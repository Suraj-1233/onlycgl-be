package com.onlycgl.cgl.userMocktest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlycgl.cgl.userMocktest.entity.UserResponse;

@Repository
public interface UserResponseRepository extends JpaRepository<UserResponse, Long> {
    // Custom query methods (if needed)
}
