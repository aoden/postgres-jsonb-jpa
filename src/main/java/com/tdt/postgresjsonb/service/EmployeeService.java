package com.tdt.postgresjsonb.service;

import com.tdt.postgresjsonb.domain.Employee;
import com.tdt.postgresjsonb.repository.EmployeeRepository;
import com.tdt.postgresjsonb.utils.PostgresJsonbUtils;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> findAllDevsWithSkills(List<String> skills, boolean conjunctive) {
        return conjunctive ? employeeRepository.findAllDevsWithSkillConjunctive("[" + PostgresJsonbUtils.toPostgresArrayStr(skills) + "]")
                : employeeRepository.findAllDevsWithSkillDisjunctive(PostgresJsonbUtils.toPostgresArrayStr(skills));
    }

    public List<Employee> findAllDevs() {
        return employeeRepository.findAllDevs();
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
