package miu.edu.cs544.ruth.jobsearch.service.job;

import miu.edu.cs544.ruth.jobsearch.entity.Job;
import miu.edu.cs544.ruth.jobsearch.exception.JobException;
import miu.edu.cs544.ruth.jobsearch.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateJobService {

    @Autowired
    JobRepository jobRepository;

    public Job updateJob(long id, Job job){
        Job jobFromDB = getJob(id);

        if(jobFromDB!=null){
            jobFromDB.setTitle(job.getTitle());
            jobFromDB.setSalary(job.getSalary());
            jobRepository.save(jobFromDB);
        } else{
            handleJobExcception(id);
        }

        return jobFromDB;
    }

    private void handleJobExcception(long id) {
        throw new JobException(id);
    }

    public Job getJob(long id){
        return jobRepository.findById(id).get();
    }
}
