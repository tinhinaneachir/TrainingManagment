package com.example.GestionFormationEntreprise.service;

import com.example.GestionFormationEntreprise.dto.Employee;
import com.example.GestionFormationEntreprise.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmplyees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id){
        Optional<Employee> employees = employeeRepository.findById(Long id);
        return employees.orElse(null);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
        Employee employee = optionalEmployee.get();
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());
        return employeeRepository.save(employee);
    }
        return null;
}

    public boolean deleteEmployee(Long id) {
       Optional <Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            employeeRepository.delete(employee.get());
            return true;
        }
        return false;
    }
}
