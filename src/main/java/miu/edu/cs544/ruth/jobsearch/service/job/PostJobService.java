package miu.edu.cs544.ruth.jobsearch.service.job;

import miu.edu.cs544.ruth.jobsearch.entity.Job;
import miu.edu.cs544.ruth.jobsearch.jms.Sender;
import miu.edu.cs544.ruth.jobsearch.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;


@Service
public class PostJobService {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    Sender sender;

    public Job addJob(Job job)  {
        System.out.println(job);
        return sender.sendJob(job);
    };


}
