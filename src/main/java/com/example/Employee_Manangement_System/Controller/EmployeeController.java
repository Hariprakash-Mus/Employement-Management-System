package com.example.Employee_Manangement_System.Controller;

import com.example.Employee_Manangement_System.Dto.Employee_dto;
import com.example.Employee_Manangement_System.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @PostMapping("/employees")
    public ResponseEntity<Employee_dto> createEmployee(@RequestBody Employee_dto employee_dto){
        Employee_dto employee=service.createEmployees(employee_dto);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }
    @GetMapping("/employees")
    public ResponseEntity<List<Employee_dto>>getEmployees(){
        List<Employee_dto> employees=service.employees();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee_dto>getById(@PathVariable long id){
        Employee_dto employee=service.employeeById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
    @PutMapping("/employees")
    public ResponseEntity<Employee_dto>updateEmployee(@RequestBody Employee_dto employee_dto){
        Employee_dto employee=service.UpdateEmployee(employee_dto);
        return  new ResponseEntity<>(employee,HttpStatus.OK);
    }
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee_dto> updateEmployee(@PathVariable long id,
                                                       @RequestBody Employee_dto employee_dto) {
        Employee_dto updatedEmployee = service.UpdateEmployeeById(id, employee_dto);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id){
        service.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted",HttpStatus.OK);
    }

}
