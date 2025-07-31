package com.example.Sherif.service;

import com.example.Sherif.model.User;
import com.example.Sherif.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto userRegistrationDto);
}
