package miu.edu.cs544.ruth.jobsearch.service.recruiter;

import miu.edu.cs544.ruth.jobsearch.entity.Recruiter;
import miu.edu.cs544.ruth.jobsearch.exception.CompanyException;
import miu.edu.cs544.ruth.jobsearch.repository.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateRecruiterService {

    @Autowired
    RecruiterRepository recruiterRepository;
    @Autowired
    GetRecruiterService getRecruiterService;


    public Recruiter updateRecruiter(long id, Recruiter recruiter){
        Recruiter recruiterFromDB = getRecruiter(id);

        if(recruiterFromDB!=null){
            recruiterFromDB.setName(recruiter.getName());
            recruiterFromDB.setAddress(recruiter.getAddress());
            recruiterFromDB.setClients(recruiter.getClients());
            recruiterRepository.save(recruiterFromDB);
        } else{
            handleRecruiterException(id);
        }

        return recruiterFromDB;
    }

    private void handleRecruiterException(long id){
        throw new CompanyException(id);
    }

    public Recruiter getRecruiter(long id){
        return getRecruiterService.getRecruiterById(id);
    }
}
