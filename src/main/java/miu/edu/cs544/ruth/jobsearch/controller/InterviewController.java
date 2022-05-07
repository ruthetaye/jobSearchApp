package miu.edu.cs544.ruth.jobsearch.controller;

import miu.edu.cs544.ruth.jobsearch.entity.Interview;
import miu.edu.cs544.ruth.jobsearch.service.interview.DeleteInterviewService;
import miu.edu.cs544.ruth.jobsearch.service.interview.GetInterviewService;
import miu.edu.cs544.ruth.jobsearch.service.interview.PostInterviewService;
import miu.edu.cs544.ruth.jobsearch.service.interview.UpdateInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class InterviewController {
    @Autowired
    GetInterviewService getInterviewService;
    @Autowired
    PostInterviewService postInterviewService;
    @Autowired
    DeleteInterviewService deleteInterviewService;
    @Autowired
    UpdateInterviewService updateInterviewService;

    @GetMapping("/jobs/{id}/interviews")
    public List<Interview> getAllInterviews(@PathVariable("id")long id){
        System.out.println("GetAllInterviews");
        return getInterviewService.getAllInterviews(id);
    }

    @GetMapping("/jobs/{id}/interviews/{interviewId}")
    public Interview getInterviewById(@PathVariable("id")long id, @PathVariable("interviewId") long interviewId){
        System.out.println("GetInterviewById");
        return getInterviewService.getInterviewById(id,interviewId);
    }

    @DeleteMapping("/jobs/{id}/interviews/{interviewId}")
    public ResponseEntity<String> deleteInterview(@PathVariable("id")long id, @PathVariable("interviewId")long interviewId){
        return deleteInterviewService.deleteInterviewById(id, interviewId);
    }

    @PutMapping("/jobs/{id}/interviews/{interviewId}")
    public Interview updateInterview(@PathVariable("id")long id, @PathVariable("interviewId")long interviewId, @RequestBody Interview interview) {
        return updateInterviewService.updateInterview(id,interviewId,interview);
    }

    @GetMapping(value = "/jobs/interviews",params = {"startDate","endDate"})
    public List<Interview> getInterviewsWithinAWeek(@RequestParam("startDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)LocalDate startDate,
                                                    @RequestParam("endDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)LocalDate endDate){
        return getInterviewService.interviewsWithinAWeek(startDate,endDate);
    }






}
