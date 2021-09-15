package com.thevarungupta.department.service.controller;

import com.thevarungupta.department.service.entity.Department;
import com.thevarungupta.department.service.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping("/")
    public List<Department> getDepartment() {
        log.info("get all departments");
        return service.getAllDepartment();
    }

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("save department");
        return service.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) {
        log.info("get department by id: " + departmentId);
        return service.getDepartmentById(departmentId);
    }
}
