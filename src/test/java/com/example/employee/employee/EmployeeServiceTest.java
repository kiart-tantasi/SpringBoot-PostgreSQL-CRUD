package com.example.employee.employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;
    private EmployeeService underTest;

    @BeforeEach
    public void setUp() {
        underTest = new EmployeeService(employeeRepository);
    }

    @Test
    void canGetAllEmployee() {
        underTest.getEmployees();
        verify(employeeRepository).findAll();
    }
}