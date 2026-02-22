package com.example.Employee_Manangement_System.Service;

import com.example.Employee_Manangement_System.Dto.Employee_dto;
import com.example.Employee_Manangement_System.Model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmpSer {
    public Employee_dto createEmployees(Employee_dto employeeDto);
    public List<Employee_dto> employees();
    public Employee_dto employeeById(long id);
    public Employee_dto UpdateEmployee(Employee_dto employeeDto);
    public Employee_dto UpdateEmployeeById(long id,Employee_dto employee_dto);
    public String deleteEmployee(long id);
}
