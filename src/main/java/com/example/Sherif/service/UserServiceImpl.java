package com.example.Sherif.service;

import com.example.Sherif.model.Role;
import com.example.Sherif.model.User;
import com.example.Sherif.repository.UserRepository;
import com.example.Sherif.dto.UserRegistrationDto;
import org.hibernate.sql.ast.tree.expression.Collation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException("Invalid username or password");

        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
    }
    private Collection<?extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
