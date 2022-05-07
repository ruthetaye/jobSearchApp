package miu.edu.cs544.ruth.jobsearch.service.recruiter;

import miu.edu.cs544.ruth.jobsearch.entity.Recruiter;
import miu.edu.cs544.ruth.jobsearch.repository.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostRecruiterService {

    @Autowired
    RecruiterRepository recruiterRepository;

    public Recruiter addRecruiter(Recruiter recruiter) {
        return recruiterRepository.save(recruiter);
    }
}
