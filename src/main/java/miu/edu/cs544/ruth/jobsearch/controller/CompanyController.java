package miu.edu.cs544.ruth.jobsearch.controller;

import miu.edu.cs544.ruth.jobsearch.entity.Company;
import miu.edu.cs544.ruth.jobsearch.service.company.DeleteCompanyService;
import miu.edu.cs544.ruth.jobsearch.service.company.GetCompanyService;
import miu.edu.cs544.ruth.jobsearch.service.company.PostCompanyService;
import miu.edu.cs544.ruth.jobsearch.service.company.UpdateCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    GetCompanyService getCompanyService;
    @Autowired
    PostCompanyService postCompanyService;
    @Autowired
    DeleteCompanyService deleteCompanyService;
    @Autowired
    UpdateCompanyService updateCompanyService;

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable("id")long id){
        System.out.println("GetCompanyById");
        return getCompanyService.getCompanyById(id);
    }

    @GetMapping()
    public List<Company> getAllCompanies(){
        System.out.println("Get All Companies");
        return getCompanyService.getAllCompanies();
    }

    @PostMapping
    public Company addCompany(@RequestBody Company company) {
        return postCompanyService.addCompany(company);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable long id){
        return deleteCompanyService.deleteCompanyById(id);
    }

    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable long id, @RequestBody Company company) {
        return updateCompanyService.updateCompany(id,company);
    }
}
