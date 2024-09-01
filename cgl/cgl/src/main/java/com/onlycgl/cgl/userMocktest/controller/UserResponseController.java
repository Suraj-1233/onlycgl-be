package com.onlycgl.cgl.userMocktest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlycgl.cgl.userMocktest.dto.MockTestDetailDTO;
import com.onlycgl.cgl.userMocktest.service.MockTestDetailService;

@RestController
@RequestMapping("/api")
public class UserResponseController {
    

    @Autowired
    private MockTestDetailService mockTestDetailService;

    @GetMapping("/mocktest/{mockTestId}")
    public ResponseEntity<MockTestDetailDTO> getMockTestDetails(@PathVariable Integer mockTestId) {
        MockTestDetailDTO mockTestDetail = mockTestDetailService.getMockTestDetail(mockTestId);
        if (mockTestDetail != null) {
            return new ResponseEntity<>(mockTestDetail, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @PostMapping("/user-responses")
    // public ResponseEntity<UserResponse> createUserResponse(@RequestBody UserResponse userResponse) {
    //     UserResponse savedResponse = userResponseService.saveUserResponse(userResponse);
    //     return new ResponseEntity<>(savedResponse, HttpStatus.CREATED);
    // }

    // // Other endpoints
}

