package com.example.employee.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT x FROM Employee x WHERE x.position = ?1")
    Optional<Employee> findByPosition(String string);

    @Query("SELECT x FROM Employee x WHERE x.firstName = ?1 AND x.lastName = ?2")
    Optional<Employee> findByFirstName(String firstName, String lastName);

}
