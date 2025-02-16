package com.sachin.async.controller;
import com.sachin.async.model.Employee;
import com.sachin.async.service.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sync")
public class SyncController
{
    @Autowired
    private SyncService sync;

    @GetMapping("/all")
    public List<Employee> getAllEmployees()
    {
        System.out.println("Sync - getting all employee records using Thread = " + Thread.currentThread().getName());
        return sync.getAllEmployees();
    }

    @GetMapping("/id/{id}")
    public Optional<Employee> getEmployeebyID(@PathVariable Long id)
    {
        System.out.println("Sync - get particular Employee = " + id + " using Thread =" + Thread.currentThread().getName());
        Optional<Employee> emp = sync.getEmployeeID(id);
        return emp;
    }
}
