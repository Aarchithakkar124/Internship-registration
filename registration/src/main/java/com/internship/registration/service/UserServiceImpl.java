package com.internship.registration.service;

import com.internship.registration.dto.UserDto;
import com.internship.registration.entity.User;
import com.internship.registration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;


    public String userlogin(UserDto userDto){
        Optional<User> userOptional = userRepository.findByUsername(userDto.getUsername());
        if(userOptional.isPresent()){
            if(userOptional.get().getPassword().equals(userDto.getPassword())){
                return "login successful";
            }
            return "invalid password";
        }
        return "login failed";


    }
    public String userregister(UserDto userDto){
        Optional<User> userOptional = userRepository.findByUsername(userDto.getUsername());
        if(userOptional.isPresent()){
            return "Username already in use";
        }
        User user = new User(userDto.getId(), userDto.getUsername(), userDto.getPassword());
        userRepository.save(user);
        return "Register successfully";
    }
}
