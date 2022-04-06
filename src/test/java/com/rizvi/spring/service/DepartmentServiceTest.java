package com.rizvi.spring.service;

import com.rizvi.spring.entity.Department;
import com.rizvi.spring.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DepartmentServiceTest {


    //@InjectMocks
    @Autowired
    private DepartmentService departmentService;

    //@MockBean
    @Autowired
    private DepartmentRepository departmentRepository;


    @BeforeEach
    void setUp() {

        Department department = new Department().builder()
                .departmentName("IT")
                .departmentAddress("PAK")
                .departmentCode("IT-001")
                .departmentId(1L)
                .build();

       // Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);

    }

    @Test
    @DisplayName("Get Data Based on Validate Department NameH")
    public void whenValidDepartmentName_thenDepartmentShouldBeFound(){

        String departmentName = "IT";
        Department found = departmentService.getDepartmentByName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());
    }
}