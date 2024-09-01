package com.onlycgl.cgl.createMocktest.repository;

import com.onlycgl.cgl.createMocktest.entity.MockTest;
import com.onlycgl.cgl.createMocktest.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByMockTest(MockTest mockTest);
}
