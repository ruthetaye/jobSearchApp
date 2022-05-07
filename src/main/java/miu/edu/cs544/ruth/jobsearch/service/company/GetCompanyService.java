package miu.edu.cs544.ruth.jobsearch.service.company;

import miu.edu.cs544.ruth.jobsearch.entity.Company;
import miu.edu.cs544.ruth.jobsearch.exception.CompanyException;
import miu.edu.cs544.ruth.jobsearch.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCompanyService {

    @Autowired
    CompanyRepository companyRepository;
    Company company;

    public Company getCompanyById(long id) {
        company = companyRepository.findById(id).get();
        if(company !=null){
            return company;
        } else {
            handleCompanyError(id);
        }
        return company;
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    private void handleCompanyError(long id){throw new CompanyException(id);}
}
