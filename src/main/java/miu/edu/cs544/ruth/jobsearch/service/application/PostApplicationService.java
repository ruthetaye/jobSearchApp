package miu.edu.cs544.ruth.jobsearch.service.application;

import miu.edu.cs544.ruth.jobsearch.entity.Application;
import miu.edu.cs544.ruth.jobsearch.entity.Job;
import miu.edu.cs544.ruth.jobsearch.exception.ApplicationException;
import miu.edu.cs544.ruth.jobsearch.repository.ApplicationRepository;
import miu.edu.cs544.ruth.jobsearch.service.job.GetJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostApplicationService {

    @Autowired
    ApplicationRepository applicationRepository;
    @Autowired
    GetJobService getJobService;

    Application applicationToSave;

    public Application addApplication(Application application, long id) {
        setJobForApplication(getJobForApplication(id),application);

        try{
            applicationToSave = applicationRepository.save(application);
        } catch (RuntimeException ex){
            handleApplicationError("Error creating Application");
        }
        return applicationToSave;
    }

    private void handleApplicationError(String message){throw new ApplicationException(message);}

    public Job getJobForApplication(long id){
        return getJobService.getJobById(id);
    }
    public void setJobForApplication(Job job,Application application){
        application.setJob(job);
    }
}
