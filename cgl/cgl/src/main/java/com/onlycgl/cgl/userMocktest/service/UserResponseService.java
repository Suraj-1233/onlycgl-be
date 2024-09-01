package com.onlycgl.cgl.userMocktest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlycgl.cgl.auth.entity.User;
import com.onlycgl.cgl.auth.repository.UserRepository;
import com.onlycgl.cgl.createMocktest.entity.MockTest;
import com.onlycgl.cgl.createMocktest.entity.Question;
import com.onlycgl.cgl.createMocktest.repository.MockTestRepository;
import com.onlycgl.cgl.createMocktest.repository.QuestionRepository;
import com.onlycgl.cgl.userMocktest.dto.UserMockTestResponseDTO;
import com.onlycgl.cgl.userMocktest.dto.UserResponseDTO;
import com.onlycgl.cgl.userMocktest.entity.*;
import com.onlycgl.cgl.userMocktest.repository.*;

@Service
public class UserResponseService {

    @Autowired
    private UserResponseRepository userResponseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MockTestRepository mockTestRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public void saveUserMockTestResponse(UserMockTestResponseDTO userMockTestResponseDTO) {
        try {
             System.out.println(userRepository+" dfgijdfg");
             System.out.println(mockTestRepository+" dfgijdfg");
             System.out.println(questionRepository+" dfgijdfg");
            // Retrieve user by ID
            User user = userRepository.findById(userMockTestResponseDTO.getUserId())
                    .orElseThrow(() -> new RuntimeException("User with ID " + userMockTestResponseDTO.getUserId() + " not found"));

            // Retrieve mock test by ID
            MockTest mockTest = mockTestRepository.findById(userMockTestResponseDTO.getMockTestId())
                    .orElseThrow(() -> new RuntimeException("Mock test with ID " + userMockTestResponseDTO.getMockTestId() + " not found"));

            // Loop through each user response and process
            for (UserResponseDTO responseDTO : userMockTestResponseDTO.getResponses()) {
                Question question = questionRepository.findById(responseDTO.getQuestionId())
                        .orElseThrow(() -> new RuntimeException("Question with ID " + responseDTO.getQuestionId() + " not found"));


                Optional<UserResponse> existingResponseOpt = userResponseRepository.findByUserAndMockTestAndQuestion(user, mockTest, question);
System.out.println(" tt" + existingResponseOpt);
                // Determine if the user's selected option is correct
                // boolean isCorrect = question.getCorrectOption().equalsIgnoreCase(responseDTO.getSelectedOption());

                // Create and populate UserResponse entity
                UserResponse userResponse;
                if (existingResponseOpt.isPresent()) {
                    // If it exists, update the existing response
                    userResponse = existingResponseOpt.get();
                    userResponse.setSelectedOption(responseDTO.getSelectedOption());
                    userResponse.setIsCorrect(responseDTO.getIsCorrect());
                    userResponse.setMarksAwarded(responseDTO.getIsCorrect() ? question.getMarks() : -1);
                    userResponse.setTimeTaken(responseDTO.getTimeTaken());
                } else {
                    // If it doesn't exist, create a new response
                    userResponse = new UserResponse();
                    userResponse.setUser(user);
                    userResponse.setMockTest(mockTest);
                    userResponse.setQuestion(question);
                    userResponse.setSelectedOption(responseDTO.getSelectedOption());
                    userResponse.setIsCorrect(responseDTO.getIsCorrect());
                    userResponse.setMarksAwarded(responseDTO.getIsCorrect() ? question.getMarks() : -1);
                    userResponse.setTimeTaken(responseDTO.getTimeTaken());
                }

                // Save the UserResponse entity
                userResponseRepository.save(userResponse);
            }

        } catch (RuntimeException e) {
            System.err.println("Runtime error occurred: " + e.getMessage());
            throw new RuntimeException("Failed to save user mock test responses: " + e.getMessage(), e);

        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            throw new RuntimeException("An unexpected error occurred while saving user mock test responses: " + e.getMessage(), e);
        }
    }
}
