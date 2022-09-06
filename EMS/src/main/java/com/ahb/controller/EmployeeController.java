package com.ahb.controller;

import com.ahb.model.EmployeeDto;
import com.ahb.service.EmployeeService;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

@Controller("/employee")
public class EmployeeController {

    @Inject
    EmployeeService employeeService;


    @Post("/new")
    public EmployeeDto createNewEmployee(@Body EmployeeDto employeeDto){
        return employeeService.createNewEmployee(employeeDto);
    }

    @Get("/get/{empId}")
    public EmployeeDto getEmployee(@PathVariable(value = "empId") int id){
        return employeeService.getEmployee(id);
    }

    @Put("/update")
    public EmployeeDto updateEmployee(@QueryValue(value = "empId") int id, @Body EmployeeDto employeeDto){
        return employeeService.updateEmployeeById(id, employeeDto);
    }

    @Delete("/delete")
    public Boolean deleteEmployee(@QueryValue(value = "empId") int id){
        return employeeService.deleteEmployeeById(id);
    }

    @Patch("/update/name")
    public EmployeeDto updateEmployeeByName(@QueryValue(value = "empId") int id, @QueryValue(value = "name") String name){
        return employeeService.updateEmployeeByName(id, name);
    }

}
