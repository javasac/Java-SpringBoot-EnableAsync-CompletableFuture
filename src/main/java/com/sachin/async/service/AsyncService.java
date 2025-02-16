package com.sachin.async.service;
import com.sachin.async.model.Employee;
import com.sachin.async.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@EnableAsync
@Service
public class AsyncService
{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Async
    public CompletableFuture<List<Employee>> getAllEmployees()
    {
        List<Employee> lt = employeeRepository.findAll();
        return CompletableFuture.completedFuture(lt);
    }

    @Async
    public CompletableFuture<Employee> getEmployeeID(long id)
    {
        Employee emp = employeeRepository.findById(id).orElse(null);
        return CompletableFuture.completedFuture(emp);
    }

}
