package com.rizvi.spring.controller;


import com.rizvi.spring.entity.Department;
import com.rizvi.spring.exception.DepartmentNotFoundException;
import com.rizvi.spring.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);


    @PostMapping("/departments")
    public Department saveDepartment(@Valid  @RequestBody Department department) {

        LOGGER.info("Inside the SaveDepartment of Department Controller");

        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {

        LOGGER.info("Inside Get All Departments of Department Controller");

        return departmentService.getAllDepartments();
    }


    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {

        LOGGER.info("Inside the Get Department by Id  of Department Controller");



        return departmentService.getDepartmentById(departmentId);
    }


    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {

        LOGGER.info("Inside the Delete  Method  of Department Controller");

        departmentService.deleteDepartmentById(departmentId);
        return "Department Deleted Successfully !!!";

    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {

        LOGGER.info("Inside the Update Department Method  of Department Controller");

        return departmentService.updateDepartment(departmentId, department);
    }
    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName){

        LOGGER.info("Inside the Get Department by Name of Department Controller");

        return departmentService.getDepartmentByName(departmentName);
    }




}