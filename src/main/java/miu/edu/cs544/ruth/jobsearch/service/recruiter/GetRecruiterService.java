package miu.edu.cs544.ruth.jobsearch.service.recruiter;

import miu.edu.cs544.ruth.jobsearch.entity.Recruiter;
import miu.edu.cs544.ruth.jobsearch.exception.CompanyException;
import miu.edu.cs544.ruth.jobsearch.repository.RecruiterRepository;
import miu.edu.cs544.ruth.jobsearch.repository.RecruiterSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetRecruiterService {

    @Autowired
    RecruiterRepository recruiterRepository;

    Recruiter recruiter;

    public Recruiter getRecruiterById(long id) {
        recruiter=recruiterRepository.findById(id).get();
        if(recruiter !=null){
            return recruiter;
        } else{
            handleRecruiterException(id);
        }
        return recruiter;
    }

    private void handleRecruiterException(long id) {
        throw new CompanyException(id);
    }

    public List<Recruiter> getAllRecruiters() {
        return recruiterRepository.findAll();
    }

    public List<Recruiter> getRecruitersWithJobsPayingMoreThanCertainAmount(double salary){
        return recruiterRepository.findAll(RecruiterSpecification.recruitersWithSalary(salary));
    }
}
