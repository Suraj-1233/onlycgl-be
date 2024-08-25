package com.onlycgl.cgl.auth.dto;

import lombok.Getter;

public class LoginRequest {

    
    @Getter
    private String password;
    @Getter
    private String email;
    @Getter
    private String username;



}
