package miu.edu.cs544.ruth.jobsearch.controller;

import miu.edu.cs544.ruth.jobsearch.entity.HiringManagerInterview;
import miu.edu.cs544.ruth.jobsearch.service.hiringManagerInterview.DeleteHiringManagerInterviewService;
import miu.edu.cs544.ruth.jobsearch.service.hiringManagerInterview.GetHiringManagerInterviewService;
import miu.edu.cs544.ruth.jobsearch.service.hiringManagerInterview.PostHiringManagerInterviewService;
import miu.edu.cs544.ruth.jobsearch.service.hiringManagerInterview.UpdateHiringManagerInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs/{id}/hiring_manager_interviews")
public class HiringManagerInterviewController {

    @Autowired
    GetHiringManagerInterviewService getHiringManagerInterviewService;
    @Autowired
    PostHiringManagerInterviewService postHiringManagerInterviewService;
    @Autowired
    DeleteHiringManagerInterviewService deleteHiringManagerInterviewService;
    @Autowired
    UpdateHiringManagerInterviewService updateHiringManagerInterviewService;

    @GetMapping()
    public List<HiringManagerInterview> getAllHiringManagerInterviews(@PathVariable("id")long id){
        System.out.println("GetAllTechnicalInterviews");
        return getHiringManagerInterviewService.getAllHiringManagerInterviews(id);
    }

    @GetMapping("/{hiringManagerInterviewId}")
    public HiringManagerInterview getHiringManagerInterviewById(@PathVariable("id")long id, @PathVariable("hiringManagerInterviewId") long hiringManagerInterviewId){
        System.out.println("GetHiringManagerInterviewById");
        return getHiringManagerInterviewService.getHiringManagerInterviewById(id,hiringManagerInterviewId);
    }

    @PostMapping()
    public HiringManagerInterview addHiringManagerInterview(@RequestBody HiringManagerInterview hiringManagerInterview, @PathVariable("id")long id) {
        return postHiringManagerInterviewService.addHiringManagerInterview(hiringManagerInterview,id);
    }

    @DeleteMapping("/{hiringManagerInterviewId}")
    public ResponseEntity<String> deleteHiringManagerInterview(@PathVariable("id")long id, @PathVariable("hiringManagerInterviewId")long hiringManagerInterviewId){

        return deleteHiringManagerInterviewService.deleteHiringManagerInterviewById(id, hiringManagerInterviewId);
    }

    @PutMapping("/{hiringManagerInterviewId}")
    public HiringManagerInterview updateHiringManagerInterview(@PathVariable("id")long id, @PathVariable("hiringManagerInterviewId")long hiringManagerInterviewId, @RequestBody HiringManagerInterview hiringManagerInterview) {
        return updateHiringManagerInterviewService.updateHiringManagerInterview(id,hiringManagerInterviewId,hiringManagerInterview);
    }
}
