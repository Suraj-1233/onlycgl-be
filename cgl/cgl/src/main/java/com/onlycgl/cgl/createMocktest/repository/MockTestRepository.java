package com.onlycgl.cgl.createMocktest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlycgl.cgl.createMocktest.entity.MockTest;

public interface MockTestRepository extends JpaRepository<MockTest, Integer> {
}
