package com.example.employee.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
        return args -> {
            Employee firstEmployee = new Employee(
                    "Tomas",
                    "Cora",
                    "Junior Developer",
                    60000
            );
            Optional<Employee> alreadyExist = employeeRepository.findByFirstName("Tomas", "Cora");
            if (alreadyExist.isEmpty()) employeeRepository.save(firstEmployee);

            Employee secondEmployee = new Employee(
                    "Jona",
                    "Mizza",
                    "Senior Developer",
                    30000
            );
            Optional<Employee> alreadyExistTwo = employeeRepository.findByFirstName("Jona", "Mizza");
            if (alreadyExistTwo.isEmpty()) employeeRepository.save(secondEmployee);
        };
    }
}
