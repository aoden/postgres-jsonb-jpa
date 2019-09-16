package com.tdt.postgresjsonb.controller;

import com.tdt.postgresjsonb.domain.Company;
import com.tdt.postgresjsonb.service.CompanyService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companyService.createCompany(company);
    }

    @GetMapping
    public List<Company> findAllCompanyHasDevsWithSkills(@RequestParam(value = "skill", required = false) List<String> skills,
                                                         @RequestParam(defaultValue = "false") boolean conjunctive) {
        return companyService.findAllCompanyHasDevsWithSkills(skills, conjunctive);
    }
}
