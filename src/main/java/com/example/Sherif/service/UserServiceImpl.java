package com.example.Sherif.service;

import com.example.Sherif.model.Role;
import com.example.Sherif.model.User;
import com.example.Sherif.repository.UserRepository;
import com.example.Sherif.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService{
//    @Autowired
    private UserRepository userRepository;

    @Autowired
     public UserServiceImpl (UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }


    @Override
    public User save(UserRegistrationDto userRegistrationDto) {
        User user = new User(userRegistrationDto.getFirstName(),userRegistrationDto.getLastName(),
                userRegistrationDto.getEmail(),userRegistrationDto.getPassword(), Arrays.asList(new Role("Role_User")));
        return userRepository.save(user);

    }
}
