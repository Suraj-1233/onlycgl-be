package com.onlycgl.cgl.auth.service;

import com.onlycgl.cgl.auth.dto.LoginRequest;
import com.onlycgl.cgl.auth.dto.SignupRequest;
import com.onlycgl.cgl.auth.entity.Role;
import com.onlycgl.cgl.auth.entity.User;
import com.onlycgl.cgl.auth.repository.UserRepository;
import com.onlycgl.cgl.common.exception.UserAlreadyExistsException;
import com.onlycgl.cgl.common.exception.AuthenticationFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Handles user registration
    public User signup(SignupRequest signupRequest) {
        // Check if the username already exists
        if (userRepository.findByUsername(signupRequest.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException(
                    "User already exists with username: " + signupRequest.getUsername());
        }

        // Default role to USER if none is specified
        Role role = signupRequest.getRole() != null ? signupRequest.getRole() : Role.USER;

        // Create and populate the User entity
        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setRole(role);
        return userRepository.save(user);
    }

    // Handles user authentication
    public User authenticate(LoginRequest loginRequest) {
        // Retrieve the user by username
        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new AuthenticationFailedException("Invalid username or password"));

        // Validate the password
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new AuthenticationFailedException("Invalid username or password");
        }

        return user;
    }
}
