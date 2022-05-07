package miu.edu.cs544.ruth.jobsearch.service.hiringManagerInterview;

import miu.edu.cs544.ruth.jobsearch.entity.HiringManagerInterview;
import miu.edu.cs544.ruth.jobsearch.entity.Job;
import miu.edu.cs544.ruth.jobsearch.repository.HiringManagerInterviewRepository;
import miu.edu.cs544.ruth.jobsearch.service.job.GetJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostHiringManagerInterviewService {

    @Autowired
    HiringManagerInterviewRepository hiringManagerInterviewRepository;
    @Autowired
    GetJobService getJobService;

    public HiringManagerInterview addHiringManagerInterview(HiringManagerInterview hiringManagerInterview, long id){
        setJobForInterview(getJobForInterview(id),hiringManagerInterview);
        return hiringManagerInterviewRepository.save(hiringManagerInterview);
    }

    public Job getJobForInterview(long id){
        return getJobService.getJobById(id);
    }
    public void setJobForInterview(Job job, HiringManagerInterview hiringManagerInterview){
        hiringManagerInterview.setJob(job);
    }

}
