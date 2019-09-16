package com.tdt.postgresjsonb.repository;

import com.tdt.postgresjsonb.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query(value = "SELECT * FROM company com,JSONB_ARRAY_ELEMENTS(com.employees) em " +
            "WHERE em->'info'->'skills' @> ANY(CAST(STRING_TO_ARRAY(?1, ',') AS JSONB[]))", nativeQuery = true)
    List<Company> findAllCompanyHasDevsWithSkillDisjunctive(String skills);

    @Query(value = "SELECT * FROM company com,JSONB_ARRAY_ELEMENTS(com.employees) em " +
            "WHERE em->'info'->'skills' @> CAST(?1 AS JSONB)", nativeQuery = true)
    List<Company> findAllCompanyHasDevsWithSkillConjunctive(String skills);
}
