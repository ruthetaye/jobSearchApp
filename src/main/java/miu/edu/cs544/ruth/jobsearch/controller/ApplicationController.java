package miu.edu.cs544.ruth.jobsearch.controller;

import miu.edu.cs544.ruth.jobsearch.entity.Application;
import miu.edu.cs544.ruth.jobsearch.service.application.DeleteApplicationService;
import miu.edu.cs544.ruth.jobsearch.service.application.GetApplicationService;
import miu.edu.cs544.ruth.jobsearch.service.application.PostApplicationService;
import miu.edu.cs544.ruth.jobsearch.service.application.UpdateApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs/{id}/application")
public class ApplicationController {

    @Autowired
    DeleteApplicationService deleteApplicationService;
    @Autowired
    PostApplicationService postApplicationService;
    @Autowired
    GetApplicationService getApplicationService;
    @Autowired
    UpdateApplicationService updateApplicationService;


    @PostMapping()
    public Application addApplication(@RequestBody Application application, @PathVariable("id")long id) {
        return postApplicationService.addApplication(application,id);
    }

    @GetMapping()
    public Application getApplicationById(@PathVariable("id")long id){
        System.out.println("GetAppById");
        return getApplicationService.getApplicationById(id);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteApplication(@PathVariable("id")long id){
        return deleteApplicationService.deleteApplicationById(id);
    }

    @PutMapping()
    public Application updateApplication(@PathVariable("id")long id, @RequestBody Application application) {
        return updateApplicationService.updateApplication(id,application);

    }

}
