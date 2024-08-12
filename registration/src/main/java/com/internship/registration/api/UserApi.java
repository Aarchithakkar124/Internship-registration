package com.internship.registration.api;

import com.internship.registration.dto.UserDto;
import com.internship.registration.entity.User;
import com.internship.registration.service.UserService;
import com.internship.registration.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class UserApi {
    @Autowired
    private UserServiceImpl userServiceimpl;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto userDto ) {
        String response = userServiceimpl.userlogin(userDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping ("/register")
    public ResponseEntity<String> register(@RequestBody UserDto userDto ) {
        String response = userServiceimpl.userregister(userDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
