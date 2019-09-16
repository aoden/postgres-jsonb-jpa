package com.tdt.postgresjsonb.service;

import com.tdt.postgresjsonb.domain.Company;
import com.tdt.postgresjsonb.repository.CompanyRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.tdt.postgresjsonb.utils.PostgresJsonbUtils.toPostgresArrayStr;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public List<Company> findAllCompanyHasDevsWithSkills(List<String> skills, boolean conjunctive) {
        return conjunctive ? companyRepository.findAllCompanyHasDevsWithSkillConjunctive("[" + toPostgresArrayStr(skills) + "]")
                : companyRepository.findAllCompanyHasDevsWithSkillDisjunctive(toPostgresArrayStr(skills));
    }

    @Transactional
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Transactional
    public void updateCompany(Company company) {
        companyRepository.save(company);
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }
}
