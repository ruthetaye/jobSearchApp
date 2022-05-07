package miu.edu.cs544.ruth.jobsearch.service.company;

import miu.edu.cs544.ruth.jobsearch.entity.Company;
import miu.edu.cs544.ruth.jobsearch.exception.CompanyException;
import miu.edu.cs544.ruth.jobsearch.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostCompanyService {

    @Autowired
    CompanyRepository companyRepository;
    Company companyToSave;

    public Company addCompany(Company company) {
        if(company!=null){
            companyToSave =companyRepository.save(company);
        } else{
            handleCompanyError("Error Creating Company");
        }
        return companyToSave;
    }

    private void handleCompanyError(String message){throw new CompanyException(message);}
}
