package com.onlycgl.cgl.createMocktest.repository;

import com.onlycgl.cgl.createMocktest.entity.Question;
import com.onlycgl.cgl.createMocktest.entity.QuestionTranslation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionTranslationRepository extends JpaRepository<QuestionTranslation, Integer> {
    List<QuestionTranslation> findByQuestion(Question question);
}
