package miu.edu.cs544.ruth.jobsearch.service.technicalInterview;

import miu.edu.cs544.ruth.jobsearch.entity.Job;
import miu.edu.cs544.ruth.jobsearch.entity.TechnicalInterview;
import miu.edu.cs544.ruth.jobsearch.repository.TechnicalInterviewRepository;
import miu.edu.cs544.ruth.jobsearch.service.job.GetJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostTechnicalInterviewService {

    @Autowired
    TechnicalInterviewRepository technicalInterviewRepository;
    @Autowired
    GetJobService getJobService;

    public TechnicalInterview addTechnicalInterview(TechnicalInterview technicalInterview, long id){
        setJobForInterview(getJobForInterview(id),technicalInterview);
        return technicalInterviewRepository.save(technicalInterview);
    }

    public Job getJobForInterview(long id){
        return getJobService.getJobById(id);
    }
    public void setJobForInterview(Job job, TechnicalInterview technicalInterview){
        technicalInterview.setJob(job);
    }

}
