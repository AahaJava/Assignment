package com.ahb.service;

import com.ahb.entity.EmployeeEntity;
import com.ahb.model.EmployeeDto;
import com.ahb.reposistory.EmployeeRepository;
import io.micronaut.context.annotation.Bean;
import jakarta.inject.Inject;
import org.modelmapper.ModelMapper;

import java.util.Optional;

@Bean
public class EmployeeServiceImp implements EmployeeService {


    @Inject
    EmployeeRepository repository;

    @Inject
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto createNewEmployee(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = repository.save(getEmployeeEntityFromDto(employeeDto));
        return getEmployeeDtoFromEntity(employeeEntity);
    }

    @Override
    public EmployeeDto getEmployee(int empId) {
        Optional<EmployeeEntity> optional = repository.findById(empId);
        if (optional.isPresent()) {
            EmployeeEntity employeeEntity = optional.get();
            return getEmployeeDtoFromEntity(employeeEntity);
        } else {
            return null;
        }
    }

    @Override
    public EmployeeDto updateEmployeeById(int empId, EmployeeDto employeeDto) {
        Optional<EmployeeEntity> optionalEmployeeEntity = repository.findById(empId);
        if(optionalEmployeeEntity.isPresent()){

            EmployeeEntity employeeEntity = optionalEmployeeEntity.get();
            employeeEntity.setSalary(employeeDto.getSalary());
            employeeEntity.setAge(employeeDto.getAge());
            employeeEntity.setName(employeeDto.getName());
            return getEmployeeDtoFromEntity(repository.update(employeeEntity));
        }else {
            return null;
            //throw new InvalidOrderIdException("Invalid Order Id "+empId);
        }
    }

    @Override
    public Boolean deleteEmployeeById(int empId) {
        Optional<EmployeeEntity> optionalEmployeeEntity = repository.findById(empId);
        if (optionalEmployeeEntity.isPresent()) {
            repository.deleteById(empId);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public EmployeeDto updateEmployeeByName(int empId, String empName) {

        Optional<EmployeeEntity> optionalEmployeeEntity = repository.findById(empId);
        if(optionalEmployeeEntity.isPresent()){

            EmployeeEntity employeeEntity = optionalEmployeeEntity.get();
            employeeEntity.setName(empName);
            return getEmployeeDtoFromEntity(repository.update(employeeEntity));
        }else {
            return null;
            //throw new InvalidOrderIdException("Invalid Order Id "+empId);
        }

    }


    private EmployeeDto getEmployeeDtoFromEntity(EmployeeEntity entity) {

        EmployeeDto dto = this.modelMapper.map(entity, EmployeeDto.class);
        return dto;
    }

    private EmployeeEntity getEmployeeEntityFromDto(EmployeeDto dto) {

        EmployeeEntity entity = this.modelMapper.map(dto, EmployeeEntity.class);
        return entity;
    }
}
