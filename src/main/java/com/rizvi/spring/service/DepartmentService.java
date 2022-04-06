package com.rizvi.spring.service;


import com.rizvi.spring.entity.Department;
import com.rizvi.spring.exception.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {


    public Department saveDepartment(Department department);

    public  List<Department> getAllDepartments();

    public  Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public  Department updateDepartment(Long departmentId, Department department);

    public  Department getDepartmentByName(String departmentName);


}
