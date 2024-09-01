package com.onlycgl.cgl.userMocktest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.io.Serializable;

import com.onlycgl.cgl.auth.entity.User;
import com.onlycgl.cgl.createMocktest.entity.MockTest;
import com.onlycgl.cgl.createMocktest.entity.Question;

@Entity
@Table(name = "user_responses")
public class UserResponse implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long responseId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "mocktest_id", nullable = false)
    private MockTest mockTest;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

   

    private String selectedOption;
    private Boolean isCorrect;
    private Integer marksAwarded;
    private Integer timeTaken; // in seconds

    // Constructors
    public UserResponse() {}

    public UserResponse(User user, MockTest mockTest, Question question, String selectedOption, Boolean isCorrect, Integer marksAwarded, Integer timeTaken) {
        this.user = user;
        this.mockTest = mockTest;
        this.question = question;
        this.selectedOption = selectedOption;
        this.isCorrect = isCorrect;
        this.marksAwarded = marksAwarded;
        this.timeTaken = timeTaken;
    }

    // Getters and Setters
    public Long getResponseId() {
        return responseId;
    }

    public void setResponseId(Long responseId) {
        this.responseId = responseId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MockTest getMockTest() {
        return mockTest;
    }

    public void setMockTest(MockTest mockTest) {
        this.mockTest = mockTest;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }

    public Boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(Boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public Integer getMarksAwarded() {
        return marksAwarded;
    }

    public void setMarksAwarded(Integer marksAwarded) {
        this.marksAwarded = marksAwarded;
    }

    public Integer getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(Integer timeTaken) {
        this.timeTaken = timeTaken;
    }

    // Optional: Override toString for better logging and debugging

}