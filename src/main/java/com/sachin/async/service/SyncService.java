package com.sachin.async.service;

import com.sachin.async.model.Employee;
import com.sachin.async.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class SyncService
{
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeID(long id)
    {
        Optional<Employee> emp = Optional.ofNullable(employeeRepository.findById(id).orElse(null));
        return emp;
    }

}
