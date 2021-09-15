package com.thevarungupta.userservice.controller;

import com.thevarungupta.userservice.dto.UserResponseDTO;
import com.thevarungupta.userservice.entity.User;
import com.thevarungupta.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public List<User> getAllUser(){
        return service.getAllUser();
    }

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        return service.saveUser(user);
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("inside getuserwithdepartment");
        return service.getUserWithDepartment(userId);
    }
}
