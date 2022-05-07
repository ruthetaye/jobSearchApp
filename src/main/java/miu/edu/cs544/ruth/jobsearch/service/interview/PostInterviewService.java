package miu.edu.cs544.ruth.jobsearch.service.interview;

import miu.edu.cs544.ruth.jobsearch.entity.Interview;
import miu.edu.cs544.ruth.jobsearch.entity.Job;
import miu.edu.cs544.ruth.jobsearch.repository.InterviewRepository;
import miu.edu.cs544.ruth.jobsearch.service.job.GetJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostInterviewService {

    @Autowired
    InterviewRepository interviewRepository;

    @Autowired
    GetJobService getJobService;

    public Interview addInterview(Interview interview, long id){
        Job jobFromDb = getJobService.getJobById(id);
        interview.setJob(jobFromDb);
        return interviewRepository.save(interview);
    }
}
