package com.onlycgl.cgl.auth.dto;


public class SignupRequest {
    private String username;
    private String email;
    private String password;
    private  String id;

    // Getters
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
