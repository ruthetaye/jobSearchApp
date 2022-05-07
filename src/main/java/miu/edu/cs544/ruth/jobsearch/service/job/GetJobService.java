package miu.edu.cs544.ruth.jobsearch.service.job;

import miu.edu.cs544.ruth.jobsearch.entity.Job;
import miu.edu.cs544.ruth.jobsearch.exception.JobException;
import miu.edu.cs544.ruth.jobsearch.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetJobService {

    @Autowired
    JobRepository jobRepository;
    Job job;

    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }
    public Job getJobById(long id){
        job = jobRepository.findById(id).get();
        if(job!=null){
            return job;
        } else{
            handleJobException(id);
        }
        return job;
    }

    private void handleJobException(long id) {
        throw new JobException(id);
    }



    public List<Job> getJobsWithApplications() {return jobRepository.findJobsWithApplication();}

    public List<Job> getJobsWithCompaniesInState(String state){
        return jobRepository.jobsInaState(state);
    }

    public List<Job> getJobsWithAtleast2Interviews(){
        return jobRepository.findJobsHavingAtleastTwoInterviews();

    }
}
