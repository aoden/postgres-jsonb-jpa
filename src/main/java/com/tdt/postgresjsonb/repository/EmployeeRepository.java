package com.tdt.postgresjsonb.repository;

import com.tdt.postgresjsonb.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT * FROM employee e WHERE e.info->>'position' = 'dev' " +
            "AND e.info->'skills' @> ANY(CAST(STRING_TO_ARRAY(?1, ',') AS JSONB[]))", nativeQuery = true)
    List<Employee> findAllDevsWithSkillDisjunctive(String skills);

    @Query(value = "SELECT * FROM employee e WHERE e.info->>'position' = 'dev' " +
            "AND e.info->'skills' @> CAST(?1 AS JSONB)", nativeQuery = true)
    List<Employee> findAllDevsWithSkillConjunctive(String skills);

    @Query(value = "SELECT * FROM employee e WHERE e.info->>'position' = 'dev'", nativeQuery = true)
    List<Employee> findAllDevs();
}
