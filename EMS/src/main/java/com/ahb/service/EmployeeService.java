package com.ahb.service;

import com.ahb.model.EmployeeDto;

public interface EmployeeService {

    EmployeeDto createNewEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployee(int empId);

    EmployeeDto updateEmployeeById(int empId, EmployeeDto employeeDto);

    Boolean deleteEmployeeById(int empId );
    EmployeeDto updateEmployeeByName(int empId, String empName);


}
