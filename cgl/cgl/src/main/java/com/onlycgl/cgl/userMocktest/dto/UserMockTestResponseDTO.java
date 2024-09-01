package com.onlycgl.cgl.userMocktest.dto;

import java.util.List;

public class UserMockTestResponseDTO {
    private Long userId;
    private Long mockTestId;
    private List<UserResponseDTO> responses;

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMockTestId() {
        return mockTestId;
    }

    public void setMockTestId(Long mockTestId) {
        this.mockTestId = mockTestId;
    }

    public List<UserResponseDTO> getResponses() {
        return responses;
    }

    public void setResponses(List<UserResponseDTO> responses) {
        this.responses = responses;
    }
}
