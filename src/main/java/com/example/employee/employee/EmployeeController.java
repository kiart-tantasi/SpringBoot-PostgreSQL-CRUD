package com.example.employee.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @PostMapping
    public void addNewEmployee(@RequestBody Employee employee) {
        employeeService.addNewEmployee(employee);
    }

    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping("{id}")
    public void updateEmployee(@PathVariable("id") Long id,
                               @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee.getPosition(), employee.getSalary());
    }

    // FOR TESTING
    @GetMapping("position")
    public Employee getEmployeeByPosition(@RequestBody Employee employee) throws Exception {
        String positionInput = employee.getPosition();
        return employeeService.findByPosition(positionInput);
    }

}
