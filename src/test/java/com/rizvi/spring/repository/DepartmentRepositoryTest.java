package com.rizvi.spring.repository;

import com.rizvi.spring.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Primary;

import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest
@SpringBootTest
class DepartmentRepositoryTest {


    @Autowired
    private  DepartmentRepository departmentRepository;

    @MockBean
    private TestEntityManager  entityManager;

    @BeforeEach
    void setUp() {

        Department department = Department.builder()
                .departmentName("IT")
                .departmentCode("Me- 011")
                .departmentAddress("Pak").build();

        entityManager.persist(department);
    }
    @Test
    public void whenFindBtId_thenReturnDepartment(){

        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "IT");
    }

}