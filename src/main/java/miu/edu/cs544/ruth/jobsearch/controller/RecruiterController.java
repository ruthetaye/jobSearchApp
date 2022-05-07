package miu.edu.cs544.ruth.jobsearch.controller;

import miu.edu.cs544.ruth.jobsearch.entity.Recruiter;
import miu.edu.cs544.ruth.jobsearch.service.recruiter.DeleteRecruiterService;
import miu.edu.cs544.ruth.jobsearch.service.recruiter.GetRecruiterService;
import miu.edu.cs544.ruth.jobsearch.service.recruiter.PostRecruiterService;
import miu.edu.cs544.ruth.jobsearch.service.recruiter.UpdateRecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recruiters")
public class RecruiterController {


    @Autowired
    GetRecruiterService getRecruiterService;
    @Autowired
    PostRecruiterService postRecruiterService;
    @Autowired
    DeleteRecruiterService deleteRecruiterService;
    @Autowired
    UpdateRecruiterService updateRecruiterService;

    @GetMapping("/{id}")
    public Recruiter getRecruiterById(@PathVariable("id")long id){
        return getRecruiterService.getRecruiterById(id);
    }

    @GetMapping()
    public List<Recruiter> getAllRecruiter(){
        System.out.println("Get All Recruiters");
        return getRecruiterService.getAllRecruiters();
    }

    @PostMapping
    public Recruiter addRecruiter(@RequestBody Recruiter recruiter) {
        return postRecruiterService.addRecruiter(recruiter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecruiterById(@PathVariable long id){
        return deleteRecruiterService.deleteRecruiterById(id);
    }

    @PutMapping("/{id}")
    public Recruiter updateRecruiter(@PathVariable long id, @RequestBody Recruiter recruiter) {
        return updateRecruiterService.updateRecruiter(id,recruiter);

    }

    @GetMapping(params = {"salary"})
    public List<Recruiter> recruitersWithJobsPayingMoreThanCertainAmount(@RequestParam("salary")double salary){
        return getRecruiterService.getRecruitersWithJobsPayingMoreThanCertainAmount(salary);
    }


}
