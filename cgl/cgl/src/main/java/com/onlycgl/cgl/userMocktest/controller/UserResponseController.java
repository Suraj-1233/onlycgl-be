package com.onlycgl.cgl.userMocktest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlycgl.cgl.userMocktest.dto.MockTestDetailDTO;
import com.onlycgl.cgl.userMocktest.dto.UserMockTestResponseDTO;
import com.onlycgl.cgl.userMocktest.service.MockTestDetailService;
import com.onlycgl.cgl.userMocktest.service.UserResponseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserResponseController {
    

    @Autowired
    private MockTestDetailService mockTestDetailService;
    @Autowired
private UserResponseService userResponseService;


    @GetMapping("/mocktest/{mockTestId}")
    public ResponseEntity<MockTestDetailDTO> getMockTestDetails(@PathVariable Long mockTestId) {
        MockTestDetailDTO mockTestDetail = mockTestDetailService.getMockTestDetail(mockTestId);
        if (mockTestDetail != null) {
            return new ResponseEntity<>(mockTestDetail, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/user-responses/")
    public ResponseEntity<String> createUserResponse(@RequestBody UserMockTestResponseDTO userMockTestResponseDTO) {
        try {
            userResponseService.saveUserMockTestResponse(userMockTestResponseDTO);

            return new ResponseEntity<>("User responses saved successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    
}


  
    


