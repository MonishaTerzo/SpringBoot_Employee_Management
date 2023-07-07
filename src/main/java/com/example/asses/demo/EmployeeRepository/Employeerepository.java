package com.example.asses.demo.EmployeeRepository;

import com.example.asses.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Employeerepository extends JpaRepository<Employee,Long> {
}
