package com.thevarungupta.userservice.service;

import com.thevarungupta.userservice.dto.Department;
import com.thevarungupta.userservice.dto.UserResponseDTO;
import com.thevarungupta.userservice.entity.User;
import com.thevarungupta.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public List<User> getAllUser() {
        return repository.findAll();
    }

    public User saveUser(User user) {
        return repository.save(user);
    }

    public UserResponseDTO getUserWithDepartment(Long userId) {
        UserResponseDTO dto = new UserResponseDTO();
        User user = repository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"
                + user.getDepartmentId(), Department.class);
        dto.setDepartment(department);
        dto.setUser(user);
        return dto;
    }

}
