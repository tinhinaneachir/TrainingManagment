package com.example.GestionFormationEntreprise.controller;


import com.example.GestionFormationEntreprise.dto.Employee;
import com.example.GestionFormationEntreprise.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeurController {

    @Autowired
    EmployeeService employeeService;

    //get all employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employees = employeeService.getAllEmplyees();
        return ResponseEntity.ok(employees);
    }

    //get employees by id
    @GetMapping("/{id]")
    public ResponseEntity<List<Employee>> getEmployeeById(@PathVariable Long id){
        Employee employee = employeeService.getEmployeeById(id);
        return employee != null ? ResponseEntity.ok(Collections.singletonList(employee)) : ResponseEntity.notFound().build();
    }

    //create new employee
    @PostMapping
    public ResponseEntity<Employee> createEmployee (RequestBody Employee employee){
        Employee createEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.status(201).body(createEmployee);
    }

    //Update Employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> putEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
        Employee updateEmployee = employeeService.updateEmployee(id, employeeDetails);
        return updateEmployee != null ? ResponseEntity.ok(updateEmployee) : ResponseEntity.notFound().build();
    }

    //delete employee
    @DeleteMapping
    public RequestEntity<Void> deleteEmployee(@PathVariable Long id){
        boolean isDeleted = employeeService.deleteEmployee(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}
