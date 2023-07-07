package com.example.asses.demo.EmployeeController;
import com.example.asses.demo.EmployeeDto.Employeedto;
import com.example.asses.demo.EmployeeService.Employeeservice;
import com.example.asses.demo.model.Employee;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
@RestController
@RequestMapping("/api")
public class Employeecontroller {
    private Employeeservice employeeService;

    @Autowired
    public Employeecontroller( Employeeservice emp) {

        employeeService = emp;
    }


@GetMapping("/employees")
public List<Employeedto> findempAll() {
    return employeeService.findAllEmployees();
}
    @GetMapping("/employees/{employeeId}")
    public Employeedto getEmployee(@PathVariable long employeeId) {

        Employeedto theEmployee = employeeService.getEmployeeById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        Employee dbEmployee = employeeService.saveEmployee(theEmployee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public void updateEmployee(@RequestBody Employee theEmployee) {
        employeeService.saveEmployee(theEmployee);

    }
    @DeleteMapping("/employees/{employeeId}")
    public void  deleteEmployee(@PathVariable long employeeId) {

        Employeedto tempEmployee = employeeService.getEmployeeById(employeeId);


        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.delete(employeeId);


    }


}
