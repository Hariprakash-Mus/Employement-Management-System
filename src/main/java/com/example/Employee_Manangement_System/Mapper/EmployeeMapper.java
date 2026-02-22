package com.example.Employee_Manangement_System.Mapper;

import com.example.Employee_Manangement_System.Dto.Employee_dto;
import com.example.Employee_Manangement_System.Model.Employee;

public class EmployeeMapper {

    public static Employee_dto mapToEmployeeDto(Employee employee){
        return new Employee_dto(
                employee.getId(),employee.getF_name(),employee.getL_name(),employee.getEmail());
    }
    public static Employee mapToEmployee(Employee_dto employee_dto){
        return new Employee(
                employee_dto.getF_name(),employee_dto.getL_name(),employee_dto.getEmail());
    }
}
