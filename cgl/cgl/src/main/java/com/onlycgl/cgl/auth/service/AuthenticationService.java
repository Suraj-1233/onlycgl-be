package com.onlycgl.cgl.auth.service;
import com.onlycgl.cgl.common.exception.UserAlreadyExistsException;
import com.onlycgl.cgl.auth.dto.LoginRequest;
import com.onlycgl.cgl.auth.dto.SignupRequest;
import com.onlycgl.cgl.auth.entity.User;
import com.onlycgl.cgl.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.onlycgl.cgl.common.exception.AuthenticationFailedException;
@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User signup(SignupRequest signupRequest) {
        if (userRepository.findByUsername(signupRequest.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException("User already exists with username: " + signupRequest.getUsername());
        }

        User user = new User();
        user.setUserName(signupRequest.getUsername());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setRole("ROLE_USER");
        return userRepository.save(user);
    }

    public User authenticate(LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new AuthenticationFailedException("Invalid username or password"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new AuthenticationFailedException("Invalid username or password");
        }

        return user;
    }
}
