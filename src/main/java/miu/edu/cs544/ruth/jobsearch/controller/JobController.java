package miu.edu.cs544.ruth.jobsearch.controller;

import miu.edu.cs544.ruth.jobsearch.entity.Job;
import miu.edu.cs544.ruth.jobsearch.service.job.DeleteJobService;
import miu.edu.cs544.ruth.jobsearch.service.job.GetJobService;
import miu.edu.cs544.ruth.jobsearch.service.job.PostJobService;
import miu.edu.cs544.ruth.jobsearch.service.job.UpdateJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.jms.JMSException;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    PostJobService postJobService;
    @Autowired
    GetJobService getJobService;
    @Autowired
    UpdateJobService updateJobService;
    @Autowired
    DeleteJobService deleteJobService;


    @PostMapping
    public Job addJob(@RequestBody Job job)  {
        return postJobService.addJob(job);
    }
    @GetMapping
    public List<Job> getAllJobs(){
        return getJobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable("id") long id){
        return getJobService.getJobById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable long id){
           return deleteJobService.deleteJobById(id);
    }

    @PutMapping("/{id}")
    public Job updateJob(@PathVariable long id, @RequestBody Job job) {
           return updateJobService.updateJob(id,job);
    }

    @GetMapping("/applications")
    public List<Job> jobsWithAnApplication(){
        return getJobService.getJobsWithApplications();
    }

    @GetMapping(value = "/companies", params = "state")
    public List<Job> jobsInAState(@RequestParam("state") String state){
        return getJobService.getJobsWithCompaniesInState(state);
    }

    @GetMapping("/interviews")
    public List<Job> jobsWithAtleast2Interviews(){
        return getJobService.getJobsWithAtleast2Interviews();
    }


}
