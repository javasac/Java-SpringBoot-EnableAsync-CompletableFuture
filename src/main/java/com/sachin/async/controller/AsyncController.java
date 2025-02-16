package com.sachin.async.controller;
import com.sachin.async.model.Employee;
import com.sachin.async.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EnableAsync
@RestController
@RequestMapping("/async")
public class AsyncController
{
    @Autowired
    private AsyncService asyncService;

    @Async
    @GetMapping("/all")
    public CompletableFuture<List<Employee>> getAllEmployees()
    {
        System.out.println("Async - getting all employee records using Thread = " + Thread.currentThread().getName());
        CompletableFuture<List<Employee>> list = asyncService.getAllEmployees();
        return list;
    }

    @Async
    @GetMapping("/id/{id}")
    public CompletableFuture<Employee> getEmployeebyID(@PathVariable Long id)
    {
        System.out.println("Async - get particular Employee = " + id + " using Thread =" + Thread.currentThread().getName());
        CompletableFuture<Employee> emp = asyncService.getEmployeeID(id);
        return emp;
    }
}
