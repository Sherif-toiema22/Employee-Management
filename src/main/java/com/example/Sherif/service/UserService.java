package com.example.Sherif.service;

import com.example.Sherif.model.User;
import com.example.Sherif.dto.UserRegistrationDto;

public interface UserService {
    User save(UserRegistrationDto userRegistrationDto);
}
