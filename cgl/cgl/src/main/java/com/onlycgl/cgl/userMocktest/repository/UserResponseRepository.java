package com.onlycgl.cgl.userMocktest.repository;

import org.springframework.data.repository.CrudRepository;

import com.onlycgl.cgl.auth.entity.User;
import com.onlycgl.cgl.createMocktest.entity.MockTest;
import com.onlycgl.cgl.createMocktest.entity.Question;
import com.onlycgl.cgl.userMocktest.entity.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UserResponseRepository extends CrudRepository<UserResponse, Long> {

    List<UserResponse> findByUserIdAndMockTest_MocktestId(Long userId, Long mocktestId);
    Optional<UserResponse> findByUserAndMockTestAndQuestion(User user, MockTest mockTest, Question question);

}
