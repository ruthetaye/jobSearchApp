package miu.edu.cs544.ruth.jobsearch.service.company;

import miu.edu.cs544.ruth.jobsearch.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteCompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public ResponseEntity<String> deleteCompanyById(long id){
        try {
            companyRepository.deleteById(id);
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch(RuntimeException ex){
            System.out.println(ex.getMessage());
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }

}
