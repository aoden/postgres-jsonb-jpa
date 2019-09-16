package com.tdt.postgresjsonb.controller;

import com.tdt.postgresjsonb.domain.Employee;
import com.tdt.postgresjsonb.service.EmployeeService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/dev")
    public List<Employee> findAllDevs(@RequestParam(value = "skill", required = false) List<String> skills,
                                      @RequestParam(defaultValue = "false") boolean conjunctive) {
        return employeeService.findAllDevsWithSkills(skills, conjunctive);
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
}
