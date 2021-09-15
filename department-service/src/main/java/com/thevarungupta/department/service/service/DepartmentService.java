package com.thevarungupta.department.service.service;

import com.thevarungupta.department.service.entity.Department;
import com.thevarungupta.department.service.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;


    public Department saveDepartment(Department department){
            return repository.save(department);
    }

    public List<Department> getAllDepartment(){
        return  repository.findAll();
    }

    public Department getDepartmentById(Long id){
        return repository.findByDepartmentId(id);
    }
}
