package com.example.employee.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // --------------------------- FOR TESTING ------------------------------------------//
    public Employee findByPosition(String position) throws Exception {
        Employee employee = employeeRepository.findByPosition(position)
                .orElseThrow(() -> new IllegalStateException("no employee with position " + position + " found"));
        return employee;
    }
    // ---------------------------------------------------------------------------------//

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void addNewEmployee(Employee newEmployee) {
        if (newEmployee.getFullName() == null || newEmployee.getPosition() == null || newEmployee.getSalary() == null) {
            throw new IllegalStateException("Missing some information.");
        }
        employeeRepository.save(newEmployee);
    }

    public void deleteEmployee(Long id) {
        boolean found = employeeRepository.existsById(id);
        if (!found) {
            throw new IllegalStateException("No employee with id " + id.toString() + " found");
        }
        employeeRepository.deleteById(id);
    }

    @Transactional
    public void updateEmployee(Long id, String newPosition, Integer newSalary) {
        Employee employeeToUpdate = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("No employee with id " + id.toString() + " found"));

        if (newPosition != null && newPosition.length() > 0 && newPosition != employeeToUpdate.getPosition()) {
            employeeToUpdate.setPosition(newPosition);
        }
        if (newSalary != null && newSalary.toString().length() > 0 && newSalary != employeeToUpdate.getSalary()) {
            employeeToUpdate.setSalary(newSalary);
        }
    }

}
