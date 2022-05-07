package miu.edu.cs544.ruth.jobsearch.service.screeningInterview;

import miu.edu.cs544.ruth.jobsearch.entity.Job;
import miu.edu.cs544.ruth.jobsearch.entity.ScreeningInterview;
import miu.edu.cs544.ruth.jobsearch.repository.ScreeningInterviewRepository;
import miu.edu.cs544.ruth.jobsearch.service.job.GetJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostScreeningInterviewService {
    @Autowired
    ScreeningInterviewRepository screeningInterviewRepository;
    @Autowired
    GetJobService getJobService;

    public ScreeningInterview addScreeningInterview(ScreeningInterview screeningInterview, long id){
        setJobForInterview(getJobForInterview(id),screeningInterview);
        return screeningInterviewRepository.save(screeningInterview);
    }

    public Job getJobForInterview(long id){
        return getJobService.getJobById(id);
    }
    public void setJobForInterview(Job job, ScreeningInterview screeningInterview){
        screeningInterview.setJob(job);
    }
}
