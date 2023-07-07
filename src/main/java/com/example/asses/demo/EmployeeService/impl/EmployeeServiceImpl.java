package com.example.asses.demo.EmployeeService.impl;
import com.example.asses.demo.EmployeeDto.Employeedto;
import com.example.asses.demo.EmployeeRepository.Employeerepository;
import com.example.asses.demo.EmployeeService.Employeeservice;
import com.example.asses.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class EmployeeServiceImpl implements Employeeservice {

   private Employeerepository employeerepository;
   @Autowired
   public EmployeeServiceImpl(Employeerepository employeerepository) {
        this.employeerepository = employeerepository;
    }
    @Override
    public List<Employeedto> findAllEmployees() {
            List<Employee> employees = employeerepository.findAll();
            return employees.stream().map((employee) -> maptoemployeedto(employee)).collect(Collectors.toList());
        }

    @Override
    public Employeedto getEmployeeById(Long Id) {
        Employee emp=employeerepository.findById(Id).get();
        return maptoemployeedto(emp);
    }

    @Override
    public void updateEmployee(Employeedto empdto) {

            Employee emp = maptoemployee(empdto);
            employeerepository.save(emp);
        }

    @Override
    public Employee saveEmployee(Employee emp) {
        return employeerepository.save(emp);
    }

    @Override
    public void delete(Long Id) {
        employeerepository.deleteById(Id);

    }


    public Employee maptoemployee(Employeedto emp) {
        Employee emps = Employee.builder()
                .id(emp.getId())
                .photoUrl(emp.getPhotoUrl())
                .id(emp.getId())
                .name(emp.getName())
                .department(emp.getDepartment())
                .jobtitle(emp.getJobtitle())
                .performance(emp.getPerformance())
                .joining_date(emp.getJoining_date())
                .build();
        return emps;
    }

    public Employeedto maptoemployeedto(Employee employee) {
        Employeedto dtos = Employeedto.builder()
                .photoUrl(employee.getPhotoUrl())
                .id(employee.getId())
                .name(employee.getName())
                .department(employee.getDepartment())
                .jobtitle(employee.getJobtitle())
                .performance(employee.getPerformance())
                .joining_date(employee.getJoining_date()).build();
        return dtos;
    }
}
