package com.example.Employee_Manangement_System.Service;

import com.example.Employee_Manangement_System.Dto.Employee_dto;
import com.example.Employee_Manangement_System.Exception.EmployeeNotFoundException;
import com.example.Employee_Manangement_System.Mapper.EmployeeMapper;
import com.example.Employee_Manangement_System.Model.EmpRepo;
import com.example.Employee_Manangement_System.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements EmpSer{
    @Autowired
    private EmpRepo services;
    @Override
    public Employee_dto createEmployees(Employee_dto employeeDto) {
        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee createEmployee=services.save(employee);
         return EmployeeMapper.mapToEmployeeDto(createEmployee);
    }

    @Override
    public List<Employee_dto> employees() {
        List<Employee> employees=services.findAll();
        return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }


    @Override
    public Employee_dto employeeById(long id) {
        Employee employee = services.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Employee not found with id: " + id)
                );

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public Employee_dto UpdateEmployee(Employee_dto employeeDto) {
        Employee employee=EmployeeMapper.mapToEmployee(employeeDto);
        Employee updateEmployee=services.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updateEmployee);
    }

    @Override
    public Employee_dto UpdateEmployeeById(long id, Employee_dto employee_dto) {
        // 1️⃣ Find the existing employee by id
        Employee existingEmployee = services.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));

        // 2️⃣ Update the fields from the DTO
        existingEmployee.setF_name(employee_dto.getF_name());
        existingEmployee.setL_name(employee_dto.getL_name());
        existingEmployee.setEmail(employee_dto.getEmail());

        // 3️⃣ Save the updated employee
        Employee updatedEmployee = services.save(existingEmployee);

        // 4️⃣ Convert back to DTO and return
        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public String deleteEmployee(long id) {
        services.deleteById(id);
        return "Employee deleted";
    }


}
