package com.onlycgl.cgl.createMocktest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlycgl.cgl.createMocktest.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
