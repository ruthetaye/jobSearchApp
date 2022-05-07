package miu.edu.cs544.ruth.jobsearch.service.company;

import miu.edu.cs544.ruth.jobsearch.entity.Company;
import miu.edu.cs544.ruth.jobsearch.exception.CompanyException;
import miu.edu.cs544.ruth.jobsearch.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCompanyService {

    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    GetCompanyService getCompanyService;

    public Company updateCompany(long id, Company company){
        Company companyFromDB = getCompany(id);

        if(companyFromDB!=null){
            companyFromDB.setName(company.getName());
            companyFromDB.setAddress(company.getAddress());
            companyRepository.save(companyFromDB);
        } else{
            handleCompanyError(id);
        }
        return companyFromDB;
    }

    public Company getCompany(long id){
        return getCompanyService.getCompanyById(id);
    }

    private void handleCompanyError(long id){throw new CompanyException(id);}
}
