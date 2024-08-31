package com.onlycgl.cgl.createMocktest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlycgl.cgl.createMocktest.entity.QuestionTranslation;

public interface QuestionTranslationRepository extends JpaRepository<QuestionTranslation, Integer> {
}